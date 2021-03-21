package dofusapi.com.dofusapi.client;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class DofusClientApi implements DofusClient
{
    OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

    public DofusClientApi()
    {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
    }

    public String run(String url) throws IOException
    {
        Request request = new Request.Builder().url(url).build();

        try(Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }

    public CharacterClass[] getAllClasses()
    {
        try
        {
            String content = new DofusClientApi().run("https://fr.dofus.dofapi.fr/classes");
            CharacterClass[] mappedClass = objectMapper.readValue(content, CharacterClass[].class);
            return mappedClass;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Equipment[] getAllEquipment()
    {
        try
        {
            String content = new DofusClientApi().run("https://fr.dofus.dofapi.fr/equipments");
            DeserializationProblemHandler deserializationProblemHandler = new UnMarshallingErrorHandler();
            objectMapper.addHandler(deserializationProblemHandler);
            Equipment[] mappedEquipment = objectMapper.readValue(content, Equipment[].class);
            return mappedEquipment;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    class UnMarshallingErrorHandler extends DeserializationProblemHandler {
        @Override
        public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser jp, JsonDeserializer deserializer, Object beanOrClass, String propertyName) throws IOException, JsonProcessingException {
            boolean result = false;
            super.handleUnknownProperty(ctxt, jp, deserializer, beanOrClass, propertyName);
            System.out.println("Property with name '" + propertyName + "' doesn't exist in Class of type '" + beanOrClass.getClass().getName() + "'");
            return true; // returns true to inform the deserialization process that we can handle the error and it can continue deserializing and returns false, if we want to stop the deserialization immediately.
        }
    }
}