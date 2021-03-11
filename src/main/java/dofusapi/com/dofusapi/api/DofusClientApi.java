package dofusapi.com.dofusapi.api;

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

    public String run(String url) throws IOException
    {
        Request request = new Request.Builder().url(url).build();

        try(Response response = client.newCall(request).execute())
        {
            return response.body().string();
        }
    }

    public String getAllClasses()
    {
        try
        {
            String content = new DofusClientApi().run("https://fr.dofus.dofapi.fr/classes");
            return content;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return  null;
        }
    }
}
