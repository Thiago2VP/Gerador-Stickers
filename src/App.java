import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {

        // acessar a api via HTTP
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        // extrair os dados mais importantes (titulo, poster, classificação)
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.Parse(body);

        // exibir e manipular os dados
        /*
         * for (Map<String, String> filme : listaDeFilmes) {
         * System.out.println(filme.get("title"));
         * System.out.println(filme.get("image"));
         * System.out.println(filme.get("imDbRating"));
         * System.out.println();
         * }
         */
        System.out.println("\u001b[1m \u001b[32m");
        System.out.println(listaDeFilmes.get(0).get("title"));
        System.out.println("\u001b[m \u001b[36m");
        System.out.println(listaDeFilmes.get(0).get("image"));
        System.out.println("\u001b[1m \u001b[32m");
        System.out.println(listaDeFilmes.get(0).get("imDbRating"));
        System.out.println("\u001b[m \u001b[36m");
        System.out.println("😅");
    }
}
