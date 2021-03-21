package dofusapi.com.dofusapi.client;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import dofusapi.com.dofusapi.core.CharacterClass;
import dofusapi.com.dofusapi.core.EquipmentClean;
import dofusapi.com.dofusapi.core.EquipmentFromClient;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

@Service
public class DofusClientApi implements DofusClient
{
    OkHttpClient client = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();
    ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

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

    public EquipmentClean[] getAllEquipment()
    {
        try
        {
            String content = new DofusClientApi().run("https://fr.dofus.dofapi.fr/equipments");
            EquipmentFromClient[] mapperTest = objectMapper.readValue(content, EquipmentFromClient[].class);
            for( EquipmentFromClient equipment : mapperTest)
            {
                if(equipment.getStatistics() != null)
                {
                    for(Map<String, Object> equipmentStats : equipment.getStatistics())
                    {
                        if(equipmentStats.containsKey("emote"))
                        {
                            equipmentStats.remove("emote");
                        }

                        if(equipmentStats.containsKey("title"))
                        {
                            equipmentStats.remove("title");
                        }
                    }
                }
            }

            String cleanContent = objectWriter.writeValueAsString(mapperTest);
            EquipmentClean[] mappedEquipmentClean = objectMapper.readValue(cleanContent, EquipmentClean[].class);
            return mappedEquipmentClean;
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return null;
        }
    }
}