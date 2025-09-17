/*  This Class Includes Solution Of All Problems Of Assignment-1

    Name - Raj Gehlot
    Date - 16/9/25
 */

import java.util.*;
public class FunctionUtility {
    // This function is used to print the length of longest substring without repeating characters
    // example. input: s = "abcabcbb", Output: 3 
    public static int getLength() {
        Scanner userInput= new Scanner(System.in);
        System.out.print("Enter a string:");
        String inputString = userInput.nextLine();
        int indices[] = new int[26];
        for(int i = 0; i < 26; i++) indices[i] = -1;
 
        int maxLength = 0;
        int left = 0, right = 0;
        while(right < inputString.length()) {
            char currCharacter = inputString.charAt(right);
            if(indices[currCharacter-'a'] >= left) {
                left = indices[currCharacter-'a'] + 1;
            }
            int currLength = right-left + 1;
            if(currLength > maxLength) maxLength = currLength;
            indices[currCharacter-'a'] = right;
            right++;
        }
        return maxLength;
    }

    // This function is used to convert a input number to its word conversion
    // example. Input: 51, Output: "fifty one"
    public static void printTens(int index) {
        String []tens = {"Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        System.out.print(tens[index-1] + " ");
    }
    public static void printOnes(int index) {
        String []ones = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
        System.out.print(ones[index-1]);
    }
    public static void printOthers(int number) {
        String []others = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","NineTeen"};
        int index = (number % 10);
        System.out.println(others[index-1]);
    }
    public static void printNumber(int number) {
        // base case for 0 and 1000
        if(number == 0) {
            System.out.println("Zero");
            return ;
        }
        if(number == 1000) {
            System.out.println("One Thousand");
            return ;
        }

        int store[] = {0, 0, 0};
        int index = 0;
        int num = number;
        while(num > 0) {
            int rem = num % 10;
            store[index++] = rem;
            num = num / 10;
        }
        int i = 0, j = 2;
        while(i < j) {
            int temp = store[i];
            store[i] = store[j];
            store[j] = temp;
            i++;
            j--;
        }

        index = 0;
        while(index < 3) {
            // printing hundreds - 100,200,300,etc.
            if(index == 0 && store[index] != 0) {
                printOnes(store[index]);
                System.out.print(" Hundred ");
            }
            // printing number from 11-19
            if(index == 1 && store[index] == 1 && store[index+1] != 0) {
                printOthers(store[index+1]);
                return ;
            }
            // printing tens - 10,20,30,etc.
            if(index == 1 && store[index] != 0) {
                printTens(store[index]);
            }
            // printing single digit - 1,2,3,etc.
            if(index == 2 && store[index] != 0) {
                printOnes(store[index]);
            }
            index++;
        }
    }
    public static void getWord() {
        Scanner userInput= new Scanner(System.in);
        int number;
        try {
            System.out.print("Enter a number:");
            number = userInput.nextInt();
            while(number < 0 || number > 1000) {
                System.out.println("Invalid number please enter again:");
                number = userInput.nextInt();
            }
            printNumber(number);
        } catch (Exception e) {
            System.out.println("Invalid input please enter again:");
            getWord();
        }
    }

    // This program is used to check whether a input number is a prime number or not
    // example. Input: 21, Output: "The given number is NOT prime"
    public static boolean isPrime(int number) {
        if(number <= 1) return false;
        for(int i = 2; i < number; i++) {
            if(number % i == 0) return false;
        }
        return true;
    }
    public static void primeChecker() {
        Scanner userInput= new Scanner(System.in);
        int number;
        try {
            System.out.print("Enter a number:");
            number = userInput.nextInt();
            if(isPrime(number)) {
                System.out.println("The given number is a prime number");
            }
            else {
                System.out.println("The given number is not a prime number");
            }
        }
        catch(Exception e) {
            System.out.println("Input is not a valid number! please enter again:");
            primeChecker();
        }
    }

    // This program is used to print Frequency of a character from a input string
    // example. Input: "aabcccdeee", Output: "a2b1c3d1e3"
    public static String getFrequency() {
        Scanner userInput= new Scanner(System.in);
        String inputString = "";
        String charFreqString = "";
        try {
            System.out.print("Enter a string:");
            inputString = userInput.nextLine();
            int index = 0;
            while(index < inputString.length()) {
                char currentCharacter = inputString.charAt(index);
                int occurance = 0;
                while(index < inputString.length() && inputString.charAt(index) == currentCharacter) {
                    index++;
                    occurance++;
                }
                charFreqString += currentCharacter;
                charFreqString += (occurance);
            }
        }
        catch(Exception e) {
            System.out.println("Invalid input");
        }
        return charFreqString;
    }

    // This program is used to extand characters in an input string with a perticular digit
    // example. Input: "a1b4c3", Output: "abbbbccc"
    public static String expand() {
        Scanner userInput = new Scanner(System.in);
        String inputString = "";
        String extendedString = "";
        try {
            System.out.print("Enter a string:");
            inputString = userInput.nextLine();
            for(int i = 1; i < inputString.length(); i+=2) {
                if(inputString.charAt(i) >= '0' && inputString.charAt(i) <= '9') {
                    char lastChar = '\0';
                    if(i > 0)
                    lastChar = inputString.charAt(i-1);
                    int times = inputString.charAt(i) - '0';
                    for(int j = 0; j < times; j++) {
                        extendedString += lastChar;
                    }
                }
            }
        }
        catch(Exception e) {
            System.out.println("Please enter a valid input string:");
        }
        return extendedString;
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Choose a question basis on its sequence:");
        System.out.println("1. String Expand");
        System.out.println("2. String Frequency");
        System.out.println("3. Check For Prime");
        System.out.println("4. Number To Word");
        System.out.println("5. Longest Non-Repeating Character Substring");
        int choice = userInput.nextInt();
        switch(choice) {
            case 1:
                String expended = expand();
                System.out.println(expended);
            break;
            case 2:
                String freqString = getFrequency();
                System.out.println("characters with their frequencies: " + freqString);
            break;
            case 3:
                primeChecker();
            break;
            case 4:
                getWord();
            break;
            case 5:
                int length = getLength();
                System.out.println("Length of longest substring without repeating characters: "+length);
            break;
        }
    }
}
