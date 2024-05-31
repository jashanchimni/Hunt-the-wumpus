
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

public class Trivia{
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the TriviaMaster!");

        System.out.println("Choose a rank of questions to answer(1-5): ");
        int selectedRank = scanner.nextInt();

        JSONObject triviaData = readJSONFile("trivia.json");
        JSONArray triviaArray = (JSONArray) triviaData.get("trivia");
        JSONArray selectedQuestions = new JSONArray();

        for (Object obj : triviaArray) {
            JSONObject question = (JSONObject) obj;
            long rank = (long) question.get("Rank");
            if(rank == selectedRank){
                selectedQuestions.add(question);
            }
        }

        if (selectedQuestions.size() > 0) {
            JSONObject randomQuestion = (JSONObject) selectedQuestions.get(new Random().nextInt(selectedQuestions.size()));
            String questionText = (String) randomQuestion.get("question");
            JSONArray choices = (JSONArray) randomQuestion.get("choices");
            int correctAnswerIndex = ((Long) randomQuestion.get("Key")).intValue();
            System.out.println("Question: " + questionText);
            for(int i = 0; i < choices.size(); i++){
                System.out.println(i + "i " + choices.get(i));
            }

            System.out.println("Enter the number of your answer(Starts at 0): ");
            int userAnswer = scanner.nextInt();

            if(userAnswer == correctAnswerIndex){
                int coinsEarned = selectedRank * 10;
                System.out.println("Congratulations, you answered it correctly and recieved " + coinsEarned + " coins! ");
            } else {
                System.out.println("Sorry, you got it wrong. Better luck next time!");
            }

        } else {
            System.out.println("That is an invalid rank, please select a valid rank");

        }

        
    }
}