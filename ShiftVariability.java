/* This is java code that implements the Caesar Cipher encryption technique
but with a twist. The program should take an input string and a shift pattern array. For
each character in the string, apply the corresponding shift value from the pattern array
● Example:
○ Input: "HELLO WORLD", Shift Pattern: [1, 2, 3]
○ Output: "IFMMP XPSME" (Shifts: 'H' +1, 'E' +2, 'L' +3, 'L' +1, 'O' +2, etc.)
Date Of Creation - 6/12/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
public class ShiftVariability {
    public static boolean check(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) != ' ' && (input.charAt(i) < 65 || input.charAt(i) > 90) && (input.charAt(i) < 97 || input.charAt(i) > 122)){
                return false;
            }
        }
        return true;
    }
    public static boolean checkPattern(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
    public static void printShift(String input, String pattern){
        char character = ' ';
        int i = 0;
        while(i < input.length()){
            for(int j = 0; i < input.length() && j < pattern.length(); j++){
                if(input.charAt(i) != ' '){
                character = (char)(input.charAt(i) + pattern.charAt(j) - '0');
                System.out.print(character);
            }
            else{
                j--;
                System.out.print(" ");
            }
                i++;
            }
        }
        System.out.println();
    }
    public static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("enter a string:");
            String input = scanner.nextLine();
            if(check(input)){
                Scanner scan1 = new Scanner(System.in);
                while(true){
                    System.out.print("Enter Pattern:");
                    String pattern = scan1.nextLine();
                    if(checkPattern(pattern)){
                        printShift(input,pattern);
                        break;
                    }
                    else{
                        System.out.println("invalid input please enter again:");
                    }
                }
                break;
            }
            else{
                System.out.println("invalid input please enter again:");
            }
        }
        String choice = "";
        System.out.print("enter any key to proceed or enter 1 to exit:");
        Scanner scan = new Scanner(System.in);
        choice = scan.nextLine();
        if(choice.charAt(0) == '1' && choice.length() == 1){
            return ;
        }
        else{
            takeInput();
        }
    }
    public static void main(String[] args){
        takeInput();
    }
}
