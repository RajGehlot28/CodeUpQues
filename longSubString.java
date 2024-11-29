/*This is a java program to find the length of longest subString
for e.g. input String = "pwwkew", Longest SubString = "wke", output = 3
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
import java.util.Scanner;

public class longSubString {

    //Method to Count Length Of Longest SubString
    public static int longestSubString(String inputStr){
        int count = 1;
        int maxCount = 0;
        int lastPos = 0;

        for(int i = 1; i < inputStr.length(); i ++){
            count = 1;

            for(int j = i - 1 ; j >= lastPos; j-- ){
                //Making Substring And Counting It's Length In cnt
                if(inputStr.charAt(i) != inputStr.charAt(j)) {
                    count++;
                }
                else if(inputStr.charAt(i) == inputStr.charAt(j)){
                    //Storing Last Position Of SubString
                    lastPos = i;
                }
            }
            //Storing Maximum Count
            if(count > maxCount){
                maxCount = count;
            }
        }

        return maxCount;

    }

    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();

        int maxSubStrLength = longestSubString(inputStr);
        //Printing Longest SubString Length
        System.out.print(maxSubStrLength);

    }

};