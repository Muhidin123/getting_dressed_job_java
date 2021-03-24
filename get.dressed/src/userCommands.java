//import org.jetbrains.annotations.NotNull;
import java.util.*;
public class userCommands {

    public static Hashtable<Integer, String> hotResponse = HashTableResponses.hotResponse(); //HASH TABLE OF HOT COMMANDS
    public static Hashtable<Integer, String> coldResponse = HashTableResponses.coldResponse(); ////HASH TABLE OF COLD COMMANDS
    public static Scanner input = new Scanner(System.in);
    public static String output = "";
    public static int[] answers = new int[8];

    public static void main(String[] args) {
        managingOutput();
    }



    public static void updateAnswers (int userInput) {
        //UPDATE ANSWERS ARRAY WITH USERS INPUT COMMANDS(ARR IS ORDERED)
        answers[userInput - 1] = userInput;
    }

//    public static @NotNull
    public static String hotOrColdCommand () {
        //PROMPT USER FOR FIRST COMMAND IN THE PROCESS
        System.out.println("ARE YOU HOT OR COLD: ");
        return input.nextLine().toUpperCase();
    }


    public static int userCommand () {
        //PROMPT USER FOR COMMANDS AFTER SELECTING HOT OR COLD
        System.out.println("AVAILABLE COMMANDS ARE 1-8 NUMBERS PICK YOUR COMMAND: ");
        return input.nextInt();
    }

    public static boolean enforceRulesForHotResponses(int command) {

        //CHECKS FOR VALIDITY OF USERS INPUT BASED ON PREDEFINED RULES
        boolean validInput = true;

        //CHECKS IF ALL CLOTHES ARE ON BEFORE LEAVING HOUSE
        boolean checkIfAllClothesOn = answers[0] != 1 && command == 7;

        //CHECKS IF  SHIRT IS PUT ON BEFORE HEADWEAR
        boolean checkForShirtWearing = answers[1] != 0 && command == 4;

        //MATCH RULES DEFINED ABOVE
        boolean checkPresentClothes = ( checkIfAllClothesOn || checkForShirtWearing);
        for (int num : answers) {

            //GOING TROUGH ARRAY OF USERS COMMANDS(INTEGERS) AND CHECKING FOR
            //CURRENT COMMAND BEING ISSUED WITH THE RULES
            if (( num == command || (command == 3 || command == 5)) || checkPresentClothes) {
                //IF it's HOT PREVENT USER FROM ISSUING COMMANDS 3 AND 5 OR ABOVE ^^ DEFINED RULES
                validInput = false;
                break;
            }
        }
        updateAnswers(command); //UPDATED THE ANSWERS ARRAY WITH USER COMMAND
        return validInput; //RETURNING BOOLEAN IF COMMAND IS CORRECT OR NOT
    }



    private static boolean enforceRulesForColdResponses(int command) {
        boolean validInput = true;

        //CHECKS IF ALL CLOTHES ARE ON BEFORE LEAVING HOUSE
        boolean checkIfAllClothesOn = answers[0] == 0 && command == 7;

        //CHECKS IF SOCKS AND PANTS ARE PUT BEFORE BOOTS
        boolean checkIfSocksAndPantsBeforeBoots = (answers[2] == 0 || answers[5] == 0) && command == 1;

        //CHECKS IF  SHIRT IS PUT ON BEFORE HEADWEAR
        boolean checkIfShirtBeforeHeadwearOrJacket = ((answers[1] != 0 || answers[4] != 0 )&& command == 4);

        //MATCH RULES DEFINED ABOVE
        boolean checkPresentClothes = ( checkIfSocksAndPantsBeforeBoots || checkIfShirtBeforeHeadwearOrJacket || checkIfAllClothesOn);
        for(int num : answers) {

            //GOING TROUGH ARRAY OF USERS COMMANDS(INTEGERS) AND CHECKING FOR
            //CURRENT COMMAND BEING ISSUED WITH THE RULES
            if((num == command) || checkPresentClothes){
                validInput = false;
                break;
            }
        }
        updateAnswers(command);
        return validInput;
    }

    public static void managingOutput() {
        String userResponseOnHotOrCold = hotOrColdCommand();

        if (userResponseOnHotOrCold.equals("HOT")) {
            output += "Hot, ";
            System.out.println(output);
            int response = userCommand();
            updateAnswers(response);

            //Check if users first response is 8 (taking pjs off)
            if(response == 8) {
                // IF USER FIRST RESPONSE CORRECT GO INTO LOOP

                output += hotResponse.get(response) + ", "; //ASSIGN VALUE OF THE RESPONSE TO THE OUTPUT STRING
                System.out.println(output); // print first string "HOT, REMOVING PJS"

                for (int i = 1; i < 6; i++){ //LOOP UNTIL ALL ANSWERS CORRECT OR BREAK IF FAIL HAPPENS

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
            } else {
                System.out.println("fail");
            }
        }
        else if (userResponseOnHotOrCold.equals("COLD")){

            System.out.println(output);
            int response = userCommand();
            updateAnswers(response);

            // IF USER FIRST RESPONSE CORRECT GO INTO LOOP
            if(response == 8) {
                //FIRST RESPONSE SHOULD ALWAYS BE "TAKING OF PJS"
                output += coldResponse.get(response) + ", ";

                System.out.println(output); // print first string "HOT, REMOVING PJS"

                for (int i = 1; i < 8; i++) {
                    //LOOP UNTIL ALL ANSWERS CORRECT OR BREAK IF FAIL HAPPENS

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