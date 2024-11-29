/*This is a java program to convert a given number in words
for e.g. input number = 123, output = one hundred twenty-three
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
package CodeUpQues;
import java.util.Scanner;

public class numToWord {

    public static int printOnes(int j, int []ans){
        int digit = ans[j-1];
        String []ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String ansStr = ones[digit - 1];
        System.out.print(ansStr);

        j = j - 1;
        return j;
    }

    public static int printTens(int j, int []ans){
        String []tens = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        int digit = ans[j-1];
        String ansStr = tens[digit - 1];
        System.out.print(ansStr);

        j = j - 1;
        return j;
    }
    public static int printOthers(int j, int []ans){
        String []others = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","NineTeen"};
        int digit = ans[j - 2];
        String ansStr = others[digit - 1];
        System.out.print(ansStr);

        return 0;
    }

    public static void main(String[] args){
        int[] arr = {1,4,3,4,5};

        Scanner input = new Scanner(System.in);
        int number = input.nextInt();

        if(number == 1000){
            System.out.print("One Thousand");
        }
        else if(number == 0){
            System.out.print("Zero");
        }
        else{
            int []ans = new int[3];
            int j = 0;

            //Storing All Digit Of Number In An Array
            while(number > 0) {
                ans[j] = number % 10;
                j++;
                number = number / 10;
            }

            if(j == 3){
                j = printOnes(j,ans);
                System.out.print(" Hundred ");
            }

            if(j == 2){
                if(ans[j-1] == 1 && ans[j-2] != 0){
                    j = printOthers(j,ans);
                }
                else if(ans[j-1] == 0){
                    j--;
                }
                else {
                    j = printTens(j,ans);
                }
            }

            if(j == 1 && ans[j-1] != 0){
                if(ans[j] != 0) {
                    System.out.print(" ");
                }
                printOnes(j,ans);
            }

        }

    }
}
