package dofusapi.com.dofusapi.api;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.Equipment;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@Primary
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
            Equipment[] mappedEquipment = objectMapper.readValue(content, Equipment[].class);
            return mappedEquipment;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
