package CodeUpQues;
/*This is a java program to check if given number is prime or not
for e.g. input number = 3, output = 3 Is A Prime Number
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
import java.util.Scanner;
public class checkPrime {
    public static boolean checkPrimeNumber(int number){
        //Base Case For 0 And 1
        if(number == 0 || number == 1){
            return false;
        }
        //Checking If The Number Is Divisible By Any Number Or Not
        for(int i = 2; i < number ; i++){
            if(number % i == 0){
                return false;
            }
        }
        //Returning True For Not Divisible
        return true;
    }
    public static void main(String[] args){
        System.out.print("Enter Any Number:");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        if(checkPrimeNumber(number)){
            System.out.println(number+" Is A Prime Number");
        }
        else{
            System.out.println(number+" Is Not A Prime Number");
        }
    }
};
