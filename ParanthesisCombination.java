/* This is java code that generates all valid combinations of the string pairs of
parentheses. Each combination should be unique and well-formed.
for eg.:
Input: n = ab
Output: [“a”,”b”,”ab”,”ba”]
Date Of Creation - 6/12/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
public class ParanthesisCombination {
    public static void printPairs(String input){
        System.out.print("[");
        for(int i = 0; i < input.length(); i++){
            System.out.print("\""+input.charAt(i)+"\""+", ");
        }
        for(int i = 0; i < input.length(); i++){
            for(int j = 0; j < input.length(); j++){
                if(i != j){
                    if(i == input.length() - 1 && j == input.length() - 2){
                        System.out.print("\""+input.charAt(i)+""+input.charAt(j)+"\"");
                    }
                    else{
                        System.out.print("\""+input.charAt(i)+""+input.charAt(j)+"\""+", ");
                    }
                }
            }
        }
        System.out.println("]");
    }
    public static boolean check(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) > '0' && input.charAt(i) < '9')
            return false;
        }
        return true;
    }
    public static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("enter any string:");
            String input = scanner.nextLine();
            if(check(input)){
                printPairs(input);
                break;
            }
            else{
                System.out.println("invalid input please enter again:");
            }
        }
        String choice = "";
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter any key to proceed or enter 1 to exit:");
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
