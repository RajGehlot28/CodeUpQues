package CodeUpQues;
/*This is a java program to compress a string like
for e.g. input String = "aabbbcc", output = a2b3c2
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
import java.util.Scanner;
public class charFreq{
    public static void compressChar(String inputString) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i += count) {
            count = 1;
            for (int j = i + 1; j < inputString.length(); j++) {
                //Increasing Count Till We Got The Same letter
                if (inputString.charAt(i) == inputString.charAt(j)) {
                    count++;
                }
            }
            //Printing Letter And Its Count
            System.out.print(inputString.charAt(i) + "" + count);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        compressChar(inputString);
    }
}
