import java.awt.Color;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class ImagemDaListaDeFilmes {

    public void criaStickerDaListaDeFilmes(List<Conteudo> listaDeFilmes) throws Exception{
        //constroi as classes usadas
        var geradora = new GeradorDeStickers();
        var funcoesFilmes = new TrataFilmes();

        String link;

        //passa por todos os filmes
        for (Conteudo conteudo : listaDeFilmes) {
            
            //transforma o link para pegar a imagem maior
            link = conteudo.getUrlImagem();
            String frase;
            Color cor;

            //processo para criar a figurinha
            try {
                //captura a imagem atraves do link
                InputStream inputStream = new URL(link).openStream();
            
                //cria o que vai ser o nome do arquivo a partir do titulo do filme
                String nomeArquivo = conteudo.getTitulo() + ".png";

                //condicional que escolhe cor e conteudo do que vai ser escrito na figura
                if(funcoesFilmes.avaliacao(conteudo.getNota())=="Pessimo"){
                    frase = "Que papelão";
                    cor = Color.RED;
                } else if(funcoesFilmes.avaliacao(conteudo.getNota())=="Ruim"){
                    frase = "Xiiiii";
                    cor = Color.ORANGE;
                } else if(funcoesFilmes.avaliacao(conteudo.getNota())=="Regular"){
                    frase = "Cavalo";
                    cor = Color.YELLOW;
                } else if(funcoesFilmes.avaliacao(conteudo.getNota())=="Bom"){
                    frase = "Ele gosta";
                    cor = Color.CYAN;
                } else if(funcoesFilmes.avaliacao(conteudo.getNota())=="Excelente"){
                    frase = "Uuuuuui";
                    cor = Color.GREEN;
                } else{
                    frase = "Imprescritivel";
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
