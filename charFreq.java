package CodeUpQues;
/*This is a java program to compress a string like
for e.g. input String = "aabbbcc", output = a2b3c2
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
import java.util.Scanner;
public class charFreq{
    //This Method Is Used To Print Character And Its Count
    public static void compressCharacter(String inputString) {
        int count = 0;
        for (int i = 0; i < inputString.length(); i += count) {
            count = 1;
            for (int j = i + 1; j < inputString.length(); j++) {
                if (inputString.charAt(i) == inputString.charAt(j)) {
                    count++;
                }
            }
            System.out.print(inputString.charAt(i) + "" + count);
        }
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        compressCharacter(inputString);
    }
}
