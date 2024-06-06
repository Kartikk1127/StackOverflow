import java.sql.Timestamp;

public class Comment {
    private int id;
    private String text;
    private User author;

    private final Question question;
    private final Answer answer;
    private Timestamp createdAt;

    public Comment(Question question, Answer answer) {
        this.question = question;
        this.answer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public Answer getAnswer(){
        return answer;
    }
}
