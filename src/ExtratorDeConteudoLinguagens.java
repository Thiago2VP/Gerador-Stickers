import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ExtratorDeConteudoLinguagens implements ExtratorConteudo {
    
    public List<Conteudo> extraiConteudos(String jsonString){

        // extrair os dados mais importantes
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        //listas de atributos
        List<Conteudo> conteudos = new ArrayList<>();

        // Fazer o Parse
        try {

            List<Linguagem> listaDoJason = mapper.readValue(jsonString, new TypeReference<List<Linguagem>>() {});

            for(Linguagem atributos : listaDoJason){
                
                String titulo = atributos.getTitle();
                String urlImagem = atributos.getImage();
                String rank;
                rank = "" + atributos.getRank();
                var conteudo = new Conteudo(titulo, urlImagem, rank, "Indefinido");
    
                conteudos.add(conteudo);
            }

        } catch (IOException e){
            System.out.printf("Ocorreu um erro: %s\n",e);
        }

        return conteudos;

    }

}
