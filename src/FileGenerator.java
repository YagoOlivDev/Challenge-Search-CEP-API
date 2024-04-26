import com.google.gson.GsonBuilder;
import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class FileGenerator
{
    public void GenerateJsonFile(Address address) throws IOException
    {

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        FileWriter writing = new FileWriter(address.cep() + ".json");
        writing.write(gson.toJson(address));
        writing.close();
    }
}
