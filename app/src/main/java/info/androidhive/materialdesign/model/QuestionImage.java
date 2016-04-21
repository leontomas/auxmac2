package info.androidhive.materialdesign.model;

/**
 * Created on 2/21/2016.
 */
public class QuestionImage {

    private Integer id;
    private String choicea;
    private String choiceb;
    private String choicec;
    private String answer;
    private String type;

    public QuestionImage() {

    }

    public QuestionImage(Integer id, String choicea, String choiceb, String choicec, String answer, String type) {
        this.id = id;
        this.choicea = choicea;
        this.choiceb = choiceb;
        this.choicec = choicec;
        this.answer = answer;
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getChoicea() {
        return choicea;
    }

    public void setChoicea(String choicea) {
        this.choicea = choicea;
    }

    public String getChoiceb() {
        return choiceb;
    }

    public void setChoiceb(String choiceb) {
        this.choiceb = choiceb;
    }

    public String getChoicec() {
        return choicec;
    }

    public void setChoicec(String choicec) {
        this.choicec = choicec;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
