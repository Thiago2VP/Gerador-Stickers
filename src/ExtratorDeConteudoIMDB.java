import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoIMDB implements ExtratorConteudo{
    
    public List<Conteudo> extraiConteudos(String json){
        // extrair os dados mais importantes (titulo, poster, classificação)
        var parser = new JsonParser();

        //listas de atributos
        List<Map<String, String>> listaDoJson = parser.Parse(json);
        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteudos
        for(Map<String, String> atributos : listaDoJson){
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("image").replaceAll("(@+)(.*).jpg$", "$1.jpg"); //para ir ao link da imagem grande
            String rank = atributos.get("rank");
            String nota = atributos.get("imDbRating");
            var conteudo = new Conteudo(titulo, urlImagem, rank, nota);

            conteudos.add(conteudo);
        }

        return conteudos; 
    }
}
