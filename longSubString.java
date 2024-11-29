/*This is a java program to find the length of longest subString
for e.g. input String = "pwwkew", Longest SubString = "wke", output = 3
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
import java.util.Scanner;
public class longSubString {
    //Method to Count Length Of Longest SubString
    public static int longestSubString(String inputString){
        int count = 1;
        int maxCount = 0;
        int lastPosition = 0;
        for(int i = 1; i < inputString.length(); i++){
            count = 1;
            for(int j = i - 1 ; j >= lastPosition; j--){
                if(inputString.charAt(i) != inputString.charAt(j)) {
                    count++;
                }
                else if(inputString.charAt(i) == inputString.charAt(j)){
                    lastPosition = i;
                }
            }
            if(count > maxCount){
                maxCount = count;
            }
        }
        return maxCount;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        int maxSubStrLength = longestSubString(inputString);
        System.out.print(maxSubStrLength);
    }
};