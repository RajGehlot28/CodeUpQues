/*This is a java program to convert a given number in words
for e.g. input number = 123, output = one hundred twenty-three
Date Of Creation - 26/11/24
Created By - Raj Gehlot
 */
package CodeUpQues;
import java.util.Scanner;
public class numToWord {
    public static int printOnes(int index, int []ans){
        int digit = ans[index-1];
        String []ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        String ansStr = ones[digit - 1];
        System.out.print(ansStr);
        index = index - 1;
        return index;
    }

    public static int printTens(int index, int []ans){
        String []tens = {"Ten","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        int digit = ans[index-1];
        String ansStr = tens[digit - 1];
        System.out.print(ansStr);
        index = index - 1;
        return index;
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
            int index = 0;
            //Storing All Digit Of Number In An Array
            while(number > 0) {
                ans[index] = number % 10;
                index++;
                number = number / 10;
            }
            if(index == 3){
                index = printOnes(index,ans);
                System.out.print(" Hundred ");
            }
            if(index == 2){
                if(ans[index-1] == 1 && ans[index-2] != 0){
                    index = printOthers(index,ans);
                }
                else if(ans[index-1] == 0){
                    index--;
                }
                else {
                    index = printTens(index,ans);
                }
            }
            if(index == 1 && ans[index-1] != 0){
                if(ans[index] != 0) {
                    System.out.print(" ");
                }
                printOnes(index,ans);
            }
        }
    }
}
