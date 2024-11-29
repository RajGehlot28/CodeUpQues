/*This is a java program to expand a string like
for e.g. input String = "a2b3c2", output = aabbbcc
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */

package CodeUpQues;
import java.util.Scanner;
class expandCharacter{
     public static void expandChar(String inputStr){
         for(int i = 0; i < inputStr.length(); i += 2){
             //Counting Number After Every Character
             int number = inputStr.charAt(i+1) - 48;
             for(int j = 0 ; j < number ; j++){
                 //Printing Character Till Number Count
                 System.out.print(inputStr.charAt(i));
             }
         }
     }
     public static void main(String[] args){
        //Taking User Input
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();
        expandChar(inputStr);
    }
}
