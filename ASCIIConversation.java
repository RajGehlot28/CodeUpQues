/* This is java code  that takes an unsorted array of digits and a series of integers. It encodes
the highest digits, based on the provided series, into their corresponding ASCII characters
Example:
● Input: Array: 2315, Series: 123
Output: "535150"
Date Of Creation - 6/12/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
public class ASCIIConversation {
    public static void printASCII(String input, String series){
        char temp = ' ';
        char []array = new char[input.length()];
        for(int i = 0; i < input.length(); i++){
            array[i] = input.charAt(i);
        }
        for(int i = 0; i < input.length() - 1; i++){
            for(int j = i + 1; j < input.length(); j++){
                if(array[i] < array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
        for(int i = 0; i < series.length(); i++){
            int index = series.charAt(i) - '0';
            System.out.print((int)array[index - 1]);
        }
        System.out.println();
    }
    public static boolean check(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                return false;
            }
        }
        return true;
    }
    public static boolean checkSeries(int size,String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '9'){
                return false;
            }
            if(input.charAt(i) - '0' > size){
                return false;
            }
        }
        for(int i = 0; i < input.length() - 1; i++){
            for(int j = i + 1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j))
                return false;
            }
        }
        return true;
    }
    public static void takeInput(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.print("Enter Array:");
            String input = scanner.nextLine();
            if(check(input)){
                while(true){
                    System.out.print("Enter Series:");
                    Scanner scan1 = new Scanner(System.in);
                    String series = scan1.nextLine();
                    if(checkSeries(input.length(),series)){
                        printASCII(input, series);
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
