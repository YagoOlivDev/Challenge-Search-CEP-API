import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CEPQuery
{
    public Address AddressSearch(String cep)
    {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://viacep.com.br/ws/"+cep+"/json/"))
                .build();

        try
        {
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Address.class);
        }

        catch (IOException | InterruptedException e)
        {
            throw new RuntimeException("I was unable to obtain an address based " +
                    "on this zip code.");
        }
    }
}
