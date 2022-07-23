import java.net.URI;
//import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
//import java.net.http.HttpResponse.BodyHandler;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

//import javax.imageio.ImageIO;

//import java.awt.Image;
//import java.awt.Toolkit;
//import java.awt.image.BufferedImage;
//import java.io.File;

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

        //Definir emojis e cores
        String[] emojis = new String[5];
        emojis[0] = "🤬";
        emojis[1] = "🤨";
        emojis[2] = "😎";
        String[] cores = new String[3];
        cores[0] = "\u001b[31m\u001b[41m";
        cores[1] = "\u001b[33m\u001b[43m";
        cores[2] = "\u001b[32m\u001b[42m";

        // exibir e manipular os dados
        for (Map<String, String> filme : listaDeFilmes) {
            //URL imgUrl = new URL(filme.get("image"));
            //BufferedImage imgFinal = ImageIO.read(imgUrl);
            //var ascii = new ASCII();
            if(Double.parseDouble(filme.get("imDbRating"))<=8.3){
                System.out.printf("%s\u001b[47m%s ",cores[0],filme.get("title"));
                System.out.printf("\u001b[37m\u001b[41m %s \u001b[m %s\n",filme.get("imDbRating"),emojis[0]);
                System.out.printf("\u001b[36m%s",filme.get("image"));
                System.out.println("\u001b[m\n\n");
            } else if(Double.parseDouble(filme.get("imDbRating"))<=8.7){
                System.out.printf("%s\u001b[47m%s ",cores[1],filme.get("title"));
                System.out.printf("\u001b[37m\u001b[43m %s \u001b[m %s\n",filme.get("imDbRating"),emojis[1]);
                System.out.printf("\u001b[36m%s",filme.get("image"));
                System.out.println("\u001b[m\n\n");
            } else{
                System.out.printf("%s\u001b[47m%s ",cores[2],filme.get("title"));
                System.out.printf("\u001b[37m\u001b[42m %s \u001b[m %s\n",filme.get("imDbRating"),emojis[2]);
                System.out.printf("\u001b[m\u001b[36m%s",filme.get("image"));
                System.out.println("\u001b[m\n");
            }
            //String imgAscii = ascii.convert(imgFinal);
            //System.out.println(imgAscii);
        }

        //Avaliar filme
        System.out.println("\u001b[34mEscolha o filme digitando sua posição no ranking (São 250 filmes)\u001b[m");
        try (Scanner input = new Scanner(System.in)) {
            String rankingPos = input.nextLine();
            int end = Integer.parseInt(rankingPos);
            System.out.printf("\n\u001b[m\u001b[34mO filme é: \u001b[1m\u001b[32m%s\u001b[m\n",listaDeFilmes.get(end-1).get("title"));
            System.out.println("\n\u001b[34mDigite a sua nota para o filme\u001b[m");
            String note = input.nextLine();
            listaDeFilmes.get(end-1).put("imDbRating", note);
            System.out.printf("\n\u001b[1m\u001b[33m%s - %s\u001b[m\n\n",listaDeFilmes.get(end-1).get("title"),listaDeFilmes.get(end-1).get("imDbRating"));

        }
        
    }
}
