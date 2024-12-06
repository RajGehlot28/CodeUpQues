/* This is java code to find whether a given number can be expressed as the sum of two or
more consecutive natural numbers if possible then print all numbers
for eg. number = 15, output:
1 2 3 4 5
4 5 6
7 8
Date Of Creation - 6/12/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
public class ConsecutiveNumberSum {
    public static void printArray(int []array, int size){
        for(int i = 0; i < size; i++){
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
    public static void getNumbers(int number){
        int []array = new int[number];
        for(int i = 1; i < number; i++){
            int count = 0;
            int sum = i;
            array[count++] = i;
            for(int j = i + 1; j < number; j++){
                sum = sum + j;
                array[count++] = j;
                if(sum == number){
                    printArray(array,count);
                }
                else if(sum > number){
                    continue;
                }
            }
        }
    }
    public static boolean check(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
    public static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("enter any number:");
            String input = scanner.nextLine();
            if(check(input)){
                int number = 0;
                for(int i = 0; i < input.length(); i++){
                    number = number * 10 + input.charAt(i) - '0';
                }
                getNumbers(number);
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
