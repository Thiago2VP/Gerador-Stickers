public class Linguagem {
    
    private Object _id;
    private String title;
    private String image;
    private int rank;

    public Linguagem(){

    }

    public Linguagem(Object _id, String title, String image, int rank) {
        this._id = _id;
        this.title = title;
        this.image = image;
        this.rank = rank;
    }

    public void setId(Object _id) {
        this._id = _id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public void setRank(int rank) {
        this.rank = rank;
    }

    public Object getId() {
        return _id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage() {
        return image;
    }

    public int getRank() {
        return rank;
    }

}
