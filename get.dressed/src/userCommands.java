import org.jetbrains.annotations.NotNull;
import java.util.*;
public class userCommands {

    public static Hashtable<Integer, String> hotResponse = HashTableResponses.hotResponse();
    public static Hashtable<Integer, String> coldResponse = HashTableResponses.coldResponse();
    public static Scanner input = new Scanner(System.in);
    public static String output = "";
    public static int[] answers = new int[8];



    public static void main(String[] args) {
        managingOutput();
    }

    public static void updateAnswers (int userInput) {
        answers[userInput - 1] = userInput;
    }

    public static @NotNull
    String hotOrColdCommand () {
        System.out.println("ARE YOU HOT OR COLD: ");
        return input.nextLine().toUpperCase();
    }


    public static int userCommand () {
        System.out.println("AVAILABLE COMMANDS ARE 1-8 NUMBERS PICK YOUR COMMAND: ");
        return input.nextInt();
    }

    public static boolean enforceRulesForHotResponses(int command) {
        boolean validInput = true;
        boolean checkIfAllClothesOn = answers[0] != 1 && command == 7;
        boolean checkForShirtWearing = answers[1] != 0 && command == 4;
        for (int num : answers) {
            boolean checkPresentClothes = ( checkIfAllClothesOn || checkForShirtWearing);
            if (( num == command || (command == 3 || command == 5)) || checkPresentClothes) {
                validInput = false;
                break;
            }
        }
        updateAnswers(command);
        return validInput;
    }



    private static boolean enforceRulesForColdResponses(int command) {
        boolean validInput = true;
        boolean checkIfAllClothesOn = answers[0] == 0 && command == 7;
        boolean checkIfSocksAndPantsBeforeBoots = (answers[2] == 0 || answers[5] == 0) && command == 1;
        boolean checkIfShirtBeforeHeadwerOrJacket = ((answers[1] != 0 || answers[4] != 0 )&& command == 4);
        boolean checkPresentClothes = ( checkIfSocksAndPantsBeforeBoots || checkIfShirtBeforeHeadwerOrJacket || checkIfAllClothesOn);
        for(int num : answers) {
            if((num == command) || checkPresentClothes){
                validInput = false;
                break;
            }
        }
        updateAnswers(command);
        return validInput;
    }

    public static void managingOutput () {
        String userResponseOnHotOrCold = hotOrColdCommand();

        if (userResponseOnHotOrCold.equals("HOT")) {
            output += "Hot, ";
            System.out.println(output);
            int response = userCommand();
            updateAnswers(response);
            //Check if users first response is 8 (taking pjs off)
            if(response == 8) {
                // IF USER FIRST RESPONSE CORRECT GO INTO LOOP
                output += hotResponse.get(response) + ", ";
                System.out.println(output); // print first string "HOT, REMOVING PJS"
                for (int i = 1; i < 8; i++){
                    int response2 = userCommand();

                    if(enforceRulesForHotResponses(response2) ){
                        output += hotResponse.get(response2) + ", ";
                        System.out.println(output);
                    }
                    else {
                        output += "fail";
                        System.out.println(output);
                        break;
                    }
                }

            }
            else {
                System.out.println("fail");
            }

        }
        else if (userResponseOnHotOrCold.equals("COLD")){

            System.out.println(output);
            int response = userCommand();
            updateAnswers(response);

            if(response == 8) {

                output += coldResponse.get(response) + ", ";
                System.out.println(output); // print first string "HOT, REMOVING PJS"

                for (int i = 1; i < 8; i++) {
                    int response2 = userCommand();

                    if (enforceRulesForColdResponses(response2)) {
                        output += coldResponse.get(response2) + ", ";
                        System.out.println(output);
                    } else {
                        output += "fail";
                        System.out.println(output);
                        break;
                    }
                }
            }
            else {
                System.out.println("fail");
            }
        }
        else {
            System.out.println("fail");
        }
    }

}