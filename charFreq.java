package CodeUpQues;
/*This is a java program to compress a string like
for e.g. input String = "aabbbcc", output = a2b3c2
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
import java.util.Scanner;

public class charFreq{
    public static void compressChar(String inputStr) {
        int count = 0;

        for (int i = 0; i < inputStr.length(); i += count) {
            count = 1;

            for (int j = i + 1; j < inputStr.length(); j++) {
                //Increasing Count Till We Got The Same letter
                if (inputStr.charAt(i) == inputStr.charAt(j)) {
                    count++;
                }
            }
            //Printing Letter And Its Count
            System.out.print(inputStr.charAt(i) + "" + count);
        }

    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputStr = input.nextLine();

        compressChar(inputStr);

    }
}
