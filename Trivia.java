 //libraries
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;
import java.util.Scanner;
import java.util.Random;

public class Trivia{
    public static void main() {

        //initializes scanner and prints intro message
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the TriviaMaster!");

        //user selects rank based on difficulty of question
        System.out.println("Choose a rank of questions to answer(1-5): ");
        int selectedRank = scanner.nextInt();

        //variables are set for the trivia that is being taken from the JSON File
        JSONObject triviaData = readJSONFile("trivia.json");
        JSONArray triviaArray = (JSONArray) triviaData.get("trivia");
        JSONArray selectedQuestions = new JSONArray();

        //Makes a new array out of the questions from the selected rank 
        for (Object obj : triviaArray) {
            JSONObject question = (JSONObject) obj;
            long rank = (long) question.get("Rank");
            if(rank == selectedRank){
                selectedQuestions.add(question);
            }
        }

        //Takes random question and stores the options, key, etc 
        if (selectedQuestions.size() > 0) {
            JSONObject randomQuestion = (JSONObject) selectedQuestions.get(new Random().nextInt(selectedQuestions.size()));
            String questionText = (String) randomQuestion.get("question");
            JSONArray choices = (JSONArray) randomQuestion.get("choices");
            int correctAnswerIndex = ((Long) randomQuestion.get("Key")).intValue();
            System.out.println("Question: " + questionText);
            for(int i = 0; i < choices.size(); i++){
                System.out.println(i + ": " + choices.get(i));
            }

            //user enters information and feedback is given based on response
            System.out.println("Enter the number of your answer(Starts at 0): ");
            int userAnswer = scanner.nextInt();

            if(userAnswer == correctAnswerIndex){
                int coinsEarned = selectedRank * 10;
                System.out.println("Congratulations, you answered it correctly and recieved " + coinsEarned + " coins! ");
            } else {
                System.out.println("Sorry, you got it wrong. Better luck next time!");
            }

        } else {
            System.out.println("You tried to be oversmart and it did not work! Exiting the TriviaMaster now");

        }

        
    }

    public static JSONObject readJSONFile(String filename) {
        JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader(filename));
            return (JSONObject) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}

