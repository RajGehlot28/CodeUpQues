/* This is java code to that continuously takes a number as input and replaces it with the sum of
its digits until the number is reduced to a single digit
Example:
Input: 9875
Output: 2 (Explanation: 9+8+7+5=29, 2+9=11, 1+1=2)
Date Of Creation - 6/12/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
public class DigitSumLoop {
    public static boolean check(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
    public static int getSum(String input){
        int sum = 0;
        for(int i = 0; i < input.length(); i++){
            int number = input.charAt(i) - '0';
            sum += number;
        }

        if(sum / 10 == 0){
            return sum;
        }
        else{
            String newNumber = "";
            while(sum > 0){
                int remainder = sum % 10;
                newNumber += remainder;
                sum = sum / 10;
            }
            return getSum(newNumber);
        }
    }
    public static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter Any Number:");
            String input = scanner.nextLine();
        if(input.length() == 1 && check(input)){
            int number = input.charAt(0) - '0';
            System.out.println("It Is Already A Single Digit Number: " + number);
            break;
        }
        else if(check(input)){
            System.out.println(getSum(input));
            break;
        }
        else{
            System.out.println("Invalid Number Please Enter Again:");
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
