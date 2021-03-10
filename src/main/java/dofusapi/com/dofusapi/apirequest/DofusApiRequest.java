package dofusapi.com.dofusapi.apirequest;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class DofusApiRequest
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
}
