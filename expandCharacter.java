/*This is a java program to expand a string like
for e.g. input String = "a2b3c2", output = aabbbcc
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
package CodeUpQues;
import java.util.Scanner;
class expandCharacter{
    //This Method Is Used To Expand A Character
     public static void expandChar(String inputString){
         for(int i = 0; i < inputString.length(); i += 2){
             int number = inputString.charAt(i+1) - 48;
             for(int j = 0 ; j < number ; j++){
                 System.out.print(inputString.charAt(i));
             }
         }
     }
     public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        expandChar(inputStr);
    }
}
