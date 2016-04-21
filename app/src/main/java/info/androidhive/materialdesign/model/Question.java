package info.androidhive.materialdesign.model;

public class Question {

    private Integer id;
    private String question;
    private String lesson;
    private String choicea;
    private String choiceb;
    private String choicec;
    private String answer;
    private String additionalInfo;

    public Question() {

    }

    public Question(Integer id, String question, String lesson, String choicea, String choiceb, String choicec, String answer, String additionalInfo ) {
        this.id = id;
        this.question = question;
        this.lesson = lesson;
        this.choicea = choicea;
        this.choiceb = choiceb;
        this.choicec = choicec;
        this.answer = answer;
        this.additionalInfo = additionalInfo;
    }

    public int getID() {
        return id;
    }

    public void setID(int id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getLesson() {
        return lesson;
    }

    public void setLesson(String lesson) {
        this.lesson = lesson;
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

    public String getadditionalInfo() { return additionalInfo; }

    public void setadditionalInfo(String additionalInfo) { this.additionalInfo = additionalInfo; }
}
