// acessar a api via HTTP
//String json = new ClienteHttp().pegaCorpoApi("http://localhost:8080/");

//manipular os dados
//ExtratorConteudo extrator = new ExtratorDeConteudoLinguagens(); //muda so a classe extratora
//List<Conteudo> conteudos = extrator.extraiConteudos(json);

//Api e terminal

//exibe todos os filmes mostrnado titulo, nota e link da imagem
//TrataFilmes.exibeFilmes(conteudos);   //codigo

//Permite ao usuario avaliar um filme
//TrataFilmes.avalie(conteudos);


//Gerador de Imagens

//Cria Imagens a partir dos filmes da lista
//new ImagemDaListaDeFilmes().criaStickerDaListaDeFilmes(conteudos);

//Cria imagens a partir de um caminho completo de um arquivo dado pelo ususario
//var criadoraMaquina = new ImagemDaMaquina();
//criadoraMaquina.criaStickerDaMaquina();

//Cria Imagens sem frase a paratir da Api da Nasa
//var criadoraNasaImagem = new NasaImages();
//criadoraNasaImagem.criaStickerDaApi(conteudos);

//Cria Imagens a partir das linguagens da lista
//new ImagemDaListaLinguagens().criaStickerDaListaDeLing(conteudos);

//Interface

import java.util.List;
import java.util.Scanner;

public class InterfaceUser {
    
    public static void interfaceExec() throws Exception{

        try (Scanner entrada = new Scanner(System.in)) {
            System.out.printf("\n\u001b[1m\n\u001b[32mDigite o Número referente ao que deseja\u001b[m\n");
            System.out.printf("\u001b[1m\u001b[32m---------------------------------------------------------------------------------\u001b[m");
            System.out.printf("\n\u001b[1m\u001b[35m1: IMDB  \u001b[36m2: Nasa  \u001b[33m3: Linguagens de Programação  \u001b[34m4: Imagem dada\u001b[m\n");
            String opt = entrada.nextLine();
            int numOpt = Integer.parseInt(opt);
            if(numOpt==1){
                ExtratorConteudo extrator = new ExtratorDeConteudoIMDB();
                System.out.printf("\n\u001b[1m\n\u001b[32mIMDB escolhido\u001b[m\n");
                System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja usar?\n\u001b[m");
                System.out.printf("\u001b[1m\n\u001b[33m1: Top 250 Filmes  2: Filmes Populares  3: Top Series  4: Series Populares\n\u001b[m");
                opt = entrada.nextLine();
                numOpt = Integer.parseInt(opt);
                if(numOpt==1){
                    System.out.printf("\n\u001b[1m\n\u001b[32mTop 250 Filmes escolhido\u001b[m\n");
                    String json = new ClienteHttp().pegaCorpoApi("https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060");
                    List<Conteudo> conteudos = extrator.extraiConteudos(json);
                    System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja Fazer?\n\u001b[m");
                    System.out.printf("\u001b[1m\n\u001b[33m1: Listar as Obras  2: Avaliar uma obra  3: Gerar Figurinhas\n\u001b[m");
                    opt = entrada.nextLine();
                    numOpt = Integer.parseInt(opt);
                    if(numOpt==1){
                        System.out.printf("\n\u001b[1m\n\u001b[32mListar as Obras escolhido\u001b[m\n\n");
                        TrataFilmes.exibeFilmes(conteudos);
                    } else if(numOpt==2){
                        System.out.printf("\n\u001b[1m\n\u001b[32mAvaliar uma obra escolhido\u001b[m\n\n");
                        TrataFilmes.avalie(conteudos);
                    } else if(numOpt==3){
                        System.out.printf("\n\u001b[1m\n\u001b[32mGerar Figurinhas escolhido\u001b[m\n\n");
                        new ImagemDaListaDeFilmes().criaStickerDaListaDeFilmes(conteudos);
                    } else{
                        System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
                    }
                } else if(numOpt==2){
                    System.out.printf("\n\u001b[1m\n\u001b[32mFilmes Populares escolhido\u001b[m\n");
                    String json = new ClienteHttp().pegaCorpoApi("https://api.mocki.io/v2/549a5d8b/MostPopularMovies");
                    List<Conteudo> conteudos = extrator.extraiConteudos(json);
                    System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja Fazer?\n\u001b[m");
                    System.out.printf("\u001b[1m\n\u001b[33m1: Listar as Obras  2: Avaliar uma obra  3: Gerar Figurinhas\n\u001b[m");
                    opt = entrada.nextLine();
                    numOpt = Integer.parseInt(opt);
                    if(numOpt==1){
                        System.out.printf("\n\u001b[1m\n\u001b[32mListar as Obras escolhido\u001b[m\n\n");
                        TrataFilmes.exibeFilmes(conteudos);
                    } else if(numOpt==2){
                        System.out.printf("\n\u001b[1m\n\u001b[32mAvaliar uma obra escolhido\u001b[m\n\n");
                        TrataFilmes.avalie(conteudos);
                    } else if(numOpt==3){
                        System.out.printf("\n\u001b[1m\n\u001b[32mGerar Figurinhas escolhido\u001b[m\n\n");
                        new ImagemDaListaDeFilmes().criaStickerDaListaDeFilmes(conteudos);
                    } else{
                        System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
                    }
                } else if(numOpt==3){
                    System.out.printf("\n\u001b[1m\n\u001b[32mTop Series escolhido\u001b[m\n");
                    String json = new ClienteHttp().pegaCorpoApi("https://api.mocki.io/v2/549a5d8b/Top250TVs");
                    List<Conteudo> conteudos = extrator.extraiConteudos(json);
                    System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja Fazer?\n\u001b[m");
                    System.out.printf("\u001b[1m\n\u001b[33m1: Listar as Obras  2: Avaliar uma obra  3: Gerar Figurinhas\n\u001b[m");
                    opt = entrada.nextLine();
                    numOpt = Integer.parseInt(opt);
                    if(numOpt==1){
                        System.out.printf("\n\u001b[1m\n\u001b[32mListar as Obras escolhido\u001b[m\n\n");
                        TrataFilmes.exibeFilmes(conteudos);
                    } else if(numOpt==2){
                        System.out.printf("\n\u001b[1m\n\u001b[32mAvaliar uma obra escolhido\u001b[m\n\n");
                        TrataFilmes.avalie(conteudos);
                    } else if(numOpt==3){
                        System.out.printf("\n\u001b[1m\n\u001b[32mGerar Figurinhas escolhido\u001b[m\n\n");
                        new ImagemDaListaDeFilmes().criaStickerDaListaDeFilmes(conteudos);
                    } else{
                        System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
                    }
                } else if(numOpt==4){
                    System.out.printf("\n\u001b[1m\n\u001b[32mSeries Populares escolhido\u001b[m\n");
                    String json = new ClienteHttp().pegaCorpoApi("https://api.mocki.io/v2/549a5d8b/MostPopularTVs");
                    List<Conteudo> conteudos = extrator.extraiConteudos(json);
                    System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja Fazer?\n\u001b[m");
                    System.out.printf("\u001b[1m\n\u001b[33m1: Listar as Obras  2: Avaliar uma obra  3: Gerar Figurinhas\n\u001b[m");
                    opt = entrada.nextLine();
                    numOpt = Integer.parseInt(opt);
                    if(numOpt==1){
                        System.out.printf("\n\u001b[1m\n\u001b[32mListar as Obras escolhido\u001b[m\n\n");
                        TrataFilmes.exibeFilmes(conteudos);
                    } else if(numOpt==2){
                        System.out.printf("\n\u001b[1m\n\u001b[32mAvaliar uma obra escolhido\u001b[m\n\n");
                        TrataFilmes.avalie(conteudos);
                    } else if(numOpt==3){
                        System.out.printf("\n\u001b[1m\n\u001b[32mGerar Figurinhas escolhido\u001b[m\n\n");
                        new ImagemDaListaDeFilmes().criaStickerDaListaDeFilmes(conteudos);
                    } else{
                        System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
                    }
                } else{
                    System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
                }
            } else if(numOpt==2){
                ExtratorConteudo extrator = new ExtratorDeConteudoNasa();
                System.out.printf("\n\u001b[1m\n\u001b[32mNasa escolhido\u001b[m\n");
                System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja usar?\n\u001b[m");
                System.out.printf("\u001b[1m\n\u001b[33m1: Imagem do Dia  2: Imagens do James Web\n\u001b[m");
                opt = entrada.nextLine();
                numOpt = Integer.parseInt(opt);
                if(numOpt==1){
                    System.out.printf("\n\u001b[1m\n\u001b[32mImagem do Dia escolhido\u001b[m\n");
                    String json = new ClienteHttp().pegaCorpoApi("https://api.mocki.io/v2/549a5d8b/NASA-APOD");
                    List<Conteudo> conteudos = extrator.extraiConteudos(json);

                    System.out.printf("\n\u001b[1m\n\u001b[32mGerando Imagem\u001b[m\n\n");
                    var criadoraNasaImagem = new NasaImages();
                    criadoraNasaImagem.criaStickerDaApi(conteudos);
                } else if(numOpt==2){
                    System.out.printf("\n\u001b[1m\n\u001b[32mImagens do James Web escolhido\u001b[m\n");
                    String json = new ClienteHttp().pegaCorpoApi("https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope");
                    List<Conteudo> conteudos = extrator.extraiConteudos(json);
                    
                    System.out.printf("\n\u001b[1m\n\u001b[32mGerando Imagem\u001b[m\n\n");
                    var criadoraNasaImagem = new NasaImages();
                    criadoraNasaImagem.criaStickerDaApi(conteudos);
                } else{
                    System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
                }
            } else if(numOpt==3){
                ExtratorConteudo extrator = new ExtratorDeConteudoLinguagens();
                System.out.printf("\n\u001b[1m\n\u001b[32mLinguagens de programação escolhido\u001b[m\n");
                String json = new ClienteHttp().pegaCorpoApi("https://thg-linguagens-api.herokuapp.com/linguagens");
                List<Conteudo> conteudos = extrator.extraiConteudos(json);
                
                System.out.printf("\n\u001b[1m\n\u001b[32mGerando Figurinhas das Linguagens rankeadas escolhido\u001b[m\n\n");
                new ImagemDaListaLinguagens().criaStickerDaListaDeLing(conteudos);
                
            } else if(numOpt==4){
                System.out.printf("\n\u001b[1m\n\u001b[32mImagem dada escolhido\u001b[m\n");
                System.out.printf("\n\u001b[1m\n\u001b[32mO que Deseja usar?\n\u001b[m");
                System.out.printf("\u001b[1m\n\u001b[33m1: Imagem do Computador  2: Imagens da Internet\n\u001b[m");
                opt = entrada.nextLine();
                numOpt = Integer.parseInt(opt);
                if (numOpt==1){
                    var criadoraMaquina = new ImagemDaMaquina();
                    criadoraMaquina.criaStickerDaMaquina();
                } else if(numOpt==2){
                    var criadoraMaquina = new ImagemDaMaquina();
                    criadoraMaquina.criaStickerDaInternet();
                } else{
                    System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");    
                }
            } else{
                System.out.printf("\n\u001b[1m\n\u001b[32mDigite um Número váido\u001b[m\n\n");
            }
        }
    }
}
