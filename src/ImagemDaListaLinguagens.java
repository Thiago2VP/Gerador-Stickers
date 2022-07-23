import java.awt.Color;
import java.io.InputStream;
import java.util.List;
import java.net.URL;

public class ImagemDaListaLinguagens {
    
    public void criaStickerDaListaDeLing(List<Conteudo> listaDeFilmes) throws Exception{
        
        //constroi as classes usadas
        var geradora = new GeradorDeStickers();

        String link;

        //passa por todos os filmes
        for (Conteudo conteudo : listaDeFilmes) {
            
            link = conteudo.getUrlImagem();
            String frase;
            Color cor;

            //processo para criar a figurinha
            try {
                //captura a imagem atraves do link
                InputStream inputStream = new URL(link).openStream();
            
                //cria o que vai ser o nome do arquivo a partir do titulo do filme
                String nomeArquivo = conteudo.getTitulo() + ".png";

                // Define frase
                frase = conteudo.getTitulo() + " - " + conteudo.getRank();

                //condicional que escolhe cor e conteudo do que vai ser escrito na figura
                if((float) Float.parseFloat(conteudo.getRank())==1){
                    cor = Color.YELLOW;
                } else if((float) Float.parseFloat(conteudo.getRank())==2){
                    cor = Color.GRAY;
                } else if((float) Float.parseFloat(conteudo.getRank())==3){
                    cor = Color.ORANGE;
                } else {
                    cor = Color.WHITE;
                }
                
                //chama a funçao que cria as figuras e salva na pasta saida dentro do projeto
                geradora.criarSticker(inputStream, nomeArquivo, frase, cor);

            } catch (Exception e) {
                System.out.println("Imagem inexistente");
                continue;
            }   

        }

    }

}
