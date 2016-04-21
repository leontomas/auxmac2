package info.androidhive.materialdesign.model;

public class Dictionary {

    private Integer id;
    private String word;
    private String description;

    public Dictionary() {

    }

    public Dictionary(int id, String word, String description) {
        this.id = id;
        this.word = word;
        this.description = description;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
