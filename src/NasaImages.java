import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class NasaImages {
    
    void criaStickerDaApi(List<Conteudo> nasaImagens) throws Exception{

        //percorre as imagens
        for (Conteudo conteudo : nasaImagens) {

            //constroi as classes usadas
            var geradora = new GeradorDeStickers();

            //captura link
            String link = conteudo.getUrlImagem();

            //captura a imagem atraves do link
            InputStream inputStream = new URL(link).openStream();

            //cria o que vai ser o nome do arquivo a partir do titulo do filme
            String nomeArquivo = conteudo.getTitulo() + ".png";

            //chama a funçao que cria as figuras e salva na pasta saida dentro do projeto
            geradora.criarStickerSemFrase(inputStream, nomeArquivo);
            
        }
    }
}
