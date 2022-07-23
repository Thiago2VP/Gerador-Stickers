import java.util.Scanner;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class ImagemDaMaquina {

    public void criaStickerDaMaquina() throws Exception{
        //constroi as classes usadas
        var geradora = new GeradorDeStickers();

        //Pede para o usuario e captura o arquivo usando o Path
        System.out.println("\u001b[1m\u001b[32mDigite o caminho da imagem\u001b[m");
        try (Scanner entrada = new Scanner(System.in)) {
            String caminho = entrada.nextLine();
            
            //captura imagem a partir do caminho
            InputStream inputStream = new FileInputStream(new File(caminho));
            
            //Capturar nome do arquivo
            var caminhoDividido = caminho.split("/");
            var nomeComExt = caminhoDividido[caminhoDividido.length-1];
            String nome = nomeComExt.split("\\.")[0];

            //define o que vai ser o nome do arquivo
            String nomeArquivo = nome + ".png";

            //captura do usuario o que vai ser escrito na imagem
            System.out.println("\u001b[1m\u001b[32mDigite a frase que quer nela\u001b[m");
            String frase = entrada.nextLine();

            //captura do usuario o que vai ser a cor da frase escrita
            System.out.println("\u001b[1m\u001b[32mDigite o número referente a cor que quer nela\u001b[m");
            System.out.println("\u001b[1m\u001b[32m1: azul, 2: verde, 3: vermelho, 4: amarelo\u001b[m");
            String strNumCor = entrada.nextLine();
            int numCor = Integer.parseInt(strNumCor);
            Color cor;

            if(numCor==1){
                cor = Color.BLUE;
            } else if(numCor==2){
                cor = Color.GREEN;
            } else if(numCor==3){
                cor = Color.RED;
            } else if(numCor==4){
                cor = Color.YELLOW;
            } else {
                cor = Color.YELLOW;
                System.out.println("Digite um número válido");
            }

            //chama a funçao que cria as figuras e salva na pasta saida dentro do projeto
            geradora.criarSticker(inputStream, nomeArquivo, frase, cor);
        }

    }
}
