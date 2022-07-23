public class Conteudo {
    
    private final String titulo;
    private final String urlImagem;
    private final String rank;
    private String nota;
    
    public Conteudo(String titulo, String urlImagem, String rank, String nota) {
        this.titulo = titulo;
        this.urlImagem = urlImagem;
        this.rank = rank;
        this.nota = nota;
    }

    public String getTitulo() {
        return titulo;
    }
    public String getUrlImagem() {
        return urlImagem;
    }
    public String getRank() {
        return rank;
    }
    public String getNota() {
        return nota;
    }

    public String setNota(String novaNota){
        this.nota = novaNota;
        return nota;
    }
    
}
