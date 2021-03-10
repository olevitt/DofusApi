package dofusapi.com.dofusapi.apirequest;

import java.io.IOException;

public class ClassRequest {

    public String getAllClasses()
    {
        try
        {
            String content = new DofusApiRequest().run("https://fr.dofus.dofapi.fr/classes");
            System.out.println(content);
            return content;
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return  null;
        }
    }
}
