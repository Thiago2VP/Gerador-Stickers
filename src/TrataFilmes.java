import java.util.List;
import java.util.Scanner;

public class TrataFilmes{
    public static void exibeFilmes(List<Conteudo> listaDeFilmes){
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
        for (Conteudo conteudo : listaDeFilmes) {

            if(Double.parseDouble(conteudo.getNota())<=8.3){
                System.out.printf("%s\u001b[47m%s ",cores[0],conteudo.getTitulo());
                System.out.printf("\u001b[37m\u001b[41m %s \u001b[m %s\n",conteudo.getNota(),emojis[0]);
                System.out.printf("\u001b[36m%s",conteudo.getUrlImagem());
                System.out.println("\u001b[m\n\n");
            } else if(Double.parseDouble(conteudo.getNota())<=8.7){
                System.out.printf("%s\u001b[47m%s ",cores[1],conteudo.getTitulo());
                System.out.printf("\u001b[37m\u001b[43m %s \u001b[m %s\n",conteudo.getNota(),emojis[1]);
                System.out.printf("\u001b[36m%s",conteudo.getUrlImagem());
                System.out.println("\u001b[m\n\n");
            } else{
                System.out.printf("%s\u001b[47m%s ",cores[2],conteudo.getTitulo());
                System.out.printf("\u001b[37m\u001b[42m %s \u001b[m %s\n",conteudo.getNota(),emojis[2]);
                System.out.printf("\u001b[m\u001b[36m%s",conteudo.getUrlImagem());
                System.out.println("\u001b[m\n");
            }
            
        }
    }

    public static void avalie(List<Conteudo> listaDeFilmes){
        //Avaliar filme
        System.out.printf("\u001b[34mEscolha o filme digitando sua posição no ranking (São %d filmes)\u001b[m\n",listaDeFilmes.size());
        try (Scanner entrada = new Scanner(System.in)) {
            String rankingPos = entrada.nextLine();
            int indice = Integer.parseInt(rankingPos);
            indice--;
            System.out.printf("\n\u001b[m\u001b[34mO filme é: \u001b[1m\u001b[32m%s\u001b[m\n",listaDeFilmes.get(indice).getTitulo());
            System.out.println("\n\u001b[34mDigite a sua nota para o filme\u001b[m");
            String note = entrada.nextLine();
            listaDeFilmes.get(indice).setNota(note);
            System.out.printf("\n\u001b[1m\u001b[33m%s - %s\u001b[m\n\n",listaDeFilmes.get(indice).getTitulo(),listaDeFilmes.get(indice).getNota());

        }
    }

    public String avaliacao(String nota){
        
        float notaNum = Float.parseFloat(nota);

        if(notaNum<=2.0){
            return "Pessimo";
        } else if(notaNum>2.0 && notaNum<=4.0){
            return "Ruim";
        } else if(notaNum>4.0 && notaNum<=6.0){
            return "Regular";
        } else if(notaNum>6.0 && notaNum<=8.0){
            return "Bom";
        } else if(notaNum>8.0 && notaNum<=10.0){
            return "Excelente";
        } else{
            return "inválido";
        }
    }
}
