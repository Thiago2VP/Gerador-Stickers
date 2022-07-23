import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

//import org.imgscalr.Scalr;

public class GeradorDeStickers {
    

    void criarSticker(InputStream inputStream, String nomeArquivo, String frase, Color cor) throws Exception {


        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaLargura = 800;
        //manter proporçao
        int novaAltura = (novaLargura * altura) / largura;

        BufferedImage imagemResize = new BufferedImage(novaLargura, novaAltura, BufferedImage.TRANSLUCENT);
        Graphics2D desenhaResImg = imagemResize.createGraphics();
        
        desenhaResImg.drawImage(imagemOriginal, 0, 0, novaLargura, novaAltura, null);
        desenhaResImg.dispose();

        //cria nova imagem em memoria com transparenacia e tamanho novo
        int alturaAdd = novaAltura + 200;
        BufferedImage novaImagem = new BufferedImage(novaLargura, alturaAdd, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemResize, 0, 0, null);

        //configurar a fonte
        //create the font
        
        try {
            //create the font to use. Specify the size!
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, new File("./src/fonts/impact.ttf")).deriveFont(12f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            //register the font
            ge.registerFont(customFont);

            //ver nomes das fontes disponiveis
            /*
            var listaFontes = ge.getAvailableFontFamilyNames();
            for (int i=0; i<200; i++) {
                System.out.println(listaFontes[i]);
            }
            */

        } catch (IOException e) {
            e.printStackTrace();
        } catch(FontFormatException e) {
            e.printStackTrace();
        }

        //usar tamanho da frase em caracteres para definir o tamanho da fonte
        int tamanhoFrase = frase.length();
        if(tamanhoFrase==0){
            alturaAdd = novaAltura;
        }

        float TamanhoFonte = (float) novaLargura/(tamanhoFrase-tamanhoFrase/4);
        int novoTamanhoFonte;
        if(TamanhoFonte>(alturaAdd-novaAltura)+(alturaAdd-novaAltura/2)){
            novoTamanhoFonte = (alturaAdd-novaAltura)+(alturaAdd-novaAltura/2);
        } else{
            novoTamanhoFonte = (int) TamanhoFonte;
        }

        //Nomes de fontes no diretorio fonts
        //Pricedown Bl
        //Guaraldo Personal Use
        var fonte = new Font("Impact", Font.BOLD, novoTamanhoFonte);

        //Fazer sombra
        graphics.setColor(Color.BLACK);
        graphics.setFont(fonte);

        //escrever a sombra na imagem
        graphics.drawString(frase, novaLargura-(novoTamanhoFonte*tamanhoFrase)+novaLargura/2-(novoTamanhoFonte/2)+3, novaAltura+(alturaAdd-novaAltura)/2+(novoTamanhoFonte/3)+3);
        
        //definir frase
        graphics.setColor(cor);

        //escrever a frase na imagem
        graphics.drawString(frase, novaLargura-(novoTamanhoFonte*tamanhoFrase)+novaLargura/2-(novoTamanhoFonte/2), novaAltura+(alturaAdd-novaAltura)/2+(novoTamanhoFonte/3));

        //escrever a nova imagem em um arquivo
        if(!new File("saida").exists()){
            new File("saida").mkdir();
        }
        //escrever imagem original na nova imagem
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));
    }

    void criarStickerSemFrase(InputStream inputStream, String nomeArquivo) throws Exception {
        
        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);

        //cria nova imagem em memoria com transparenacia e tamanho novo
        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        BufferedImage novaImagem = new BufferedImage(largura, altura, BufferedImage.TRANSLUCENT);

        //copiar a imagem original para nova imagem (em memoria)
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

        //escrever a nova imagem em um arquivo
        if(!new File("saida").exists()){
            new File("saida").mkdir();
        }
        //escrever imagem original na nova imagem
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));
    }

}
