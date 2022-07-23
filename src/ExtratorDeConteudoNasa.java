import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoNasa implements ExtratorConteudo{
    
    public List<Conteudo> extraiConteudos(String json){
        // extrair os dados mais importantes
        var parser = new JsonParser();

        //listas de atributos
        List<Map<String, String>> listaDoJson = parser.Parse(json);
        List<Conteudo> conteudos = new ArrayList<>();
        
        //popular a lista de conteudos
        for(Map<String, String> atributos : listaDoJson){
            String titulo = atributos.get("title");
            String urlImagem = atributos.get("url");
            var conteudo = new Conteudo(titulo, urlImagem, "Indefinido", "Indefinido");

            conteudos.add(conteudo);
        }

        return conteudos;
    }
}
