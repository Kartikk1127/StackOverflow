import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StackOverflow stackOverflow = StackOverflow.getInstance();

        //register users
        User user1 = new User(1,"Kartik","12345","kartik@gmail.com",0);
        User user2= new User(2,"Ayush","54321","ayush@gmail.com",0);
        stackOverflow.registerUser(user1);
        stackOverflow.registerUser(user2);

        //user login
        User loggedInUser = stackOverflow.loginUser("Kartik","12345");
        if (loggedInUser!=null){
            System.out.println("User logged in: " + loggedInUser.getUsername());
        } else {
            System.out.println("Invalid username or password");
        }

        //post a question
        Question question1 = new Question(1, "What is Java?", "Please explain Java.", user1, new ArrayList<>(),
                new ArrayList<>(), Arrays.asList(new Tag(1, "java"), new Tag(2, "programming")), 0);

        stackOverflow.postQuestion(question1);

        //post an answer
        Answer answer1 = new Answer(1, "Java is an object-oriented programming language.", user2, question1,
                new ArrayList<>(), 0);
        stackOverflow.postAnswer(answer1);

        //comment on a question
        Comment comment = new Comment(question1,answer1);
        stackOverflow.postComment(comment);

        //vote on the question
        stackOverflow.voteQuestion(question1,1);

        //search for questions
        List<Question> searchResults = stackOverflow.searchQuestions("Java");
        System.out.println("Search Results:");

        for (Question question : searchResults){
            System.out.println(question.getTitle());
        }

        //get questions by tag
        List<Question> taggedQuestions = stackOverflow.getQuestionsByTag("java");
        System.out.println("Questions tagged with 'java':");
        for (Question question : taggedQuestions){
            System.out.println(question.getTitle());
        }

        //get questions by user
        List<Question> userQuestions = stackOverflow.getQuestionsByUser(user1);
        System.out.println("Questions posted by user1:");
        for (Question question : userQuestions) {
            System.out.println(question.getTitle());
        }

    }
}