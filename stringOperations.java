/* This is java code to perform following opertaions on string - Append, CountWords, Replace, 
isPalindrome, Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse. 
Date Of Creation - 29/11/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
class stringOperations{
    //This Method Is Used To Append A String
    public static String Append(String oldString,String newString){
        oldString = oldString + newString;
        return oldString;
    }
    //This Method Is Used To Count Number Of Words In Strings
    public static int countWords(String inputString){
        int countWords = 0;
        int index = 0;
        while(index < inputString.length()){
            if(inputString.charAt(index) != ' '){
                countWords++;
                while(index < inputString.length() && inputString.charAt(index) != ' '){
                    index++;
                }
            }
            index++;
        }
        return countWords;
    }
    //Method To Check Equality Of Two String
    public static Boolean compare(String firstString, String secondString){
        if(firstString.length() != secondString.length()){
            return false;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        while(firstIndex < firstString.length() && secondIndex < secondString.length()){
            if(firstString.charAt(firstIndex) != secondString.charAt(secondIndex)){
                return false;
            }
            firstIndex++;
            secondIndex++;
        }
        return true;
    }
    //This Method Is Used To Replace Characters In String
    public static String replace(String inputString, String oldString, String newString){
        String ansString = "";
        String dummyString = "";
        boolean check = true;
        for(int i = 0; i < inputString.length(); i++){
            if(inputString.charAt(i) == oldString.charAt(0)){
                dummyString = "";
                check = true;
                for(int j = i; j < inputString.length() && check == true; j++){
                    dummyString += inputString.charAt(j);
                    if(compare(dummyString,oldString) == true){
                        i = j;
                        ansString += newString;
                        check = false;
                    }
                }
                if(check == true){
                    ansString += inputString.charAt(i);
                }
            }
            else{
                ansString += inputString.charAt(i);
            }
        }
        return ansString;
    }
    //This Method Is Used To Check If A Given String Is Palindrome Or Not
    public static boolean isPalindrome(String inputString){
        int start = 0;
        int end = inputString.length() - 1;
        while(start <= end){
            if(inputString.charAt(start) != inputString.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //This Method Is Used To Splice From A Given Starting Index And Length Of Splice
    public static String spliceString(String inputString, int start, int length){
        String ansString = "";
        for(int i = 0; i < inputString.length(); i++){
            if(i == start){
                while(i < start + length - 1){
                    i++;
                }
            }
            else{
                ansString += inputString.charAt(i);
            }
        }
        return ansString;
    }
    //This Method Is Used To Split A String In An Array
    public static String[] splitString(String inputString){
        int size = countWords(inputString);
        String []Words = new String[size];
        int index = 0;
        for(int i = 0; i < inputString.length(); i++){
            Words[index] = "";
            if(inputString.charAt(i) != ' '){
                while(i < inputString.length() && inputString.charAt(i) != ' '){
                    Words[index] += inputString.charAt(i);
                    i++;
                }
                index++;
            }
        }
        return Words;
    }
    //This Method Is Used To Find Max Occurring Letter In A String And Its Count 
    public static void maxRepeat(String inputString){
        int maxCount = 0;
        int count = 0;
        char maxRepeatCharacter = ' ';
        for(int i = 0; i < inputString.length(); i++){
            count = 1;
            for(int j = i + 1; j < inputString.length(); j++){
                if(inputString.charAt(i) == inputString.charAt(j) && inputString.charAt(i) != ' '){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                maxRepeatCharacter = inputString.charAt(i);
            }
        }
        System.out.println("'" + maxRepeatCharacter + "'" + " -> " + maxCount);
    }
    //This Method Is Used To Sort A String
    public static String sortString(String inputString){
        char []charArray = new char[inputString.length()];
        String ansString = "";
        for(int i = 0; i < inputString.length(); i++){
            if( inputString.charAt(i) != ' ')
            charArray[i] = inputString.charAt(i);
        }
        char temp = ' ';
        for(int i = 0; i < inputString.length() - 1; i++){
            for(int j = i + 1;j < inputString.length(); j++){
                if(charArray[i] > charArray[j]){
                    temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        for(int i = 0; i < inputString.length(); i++){
            ansString += charArray[i];
        }
        return ansString;
    }
    //This Method Is Used To Shift First n Character To End Of String
    public static String shiftString(String inputString, int index){
        String ansString = "";
        for(int i = index; i < inputString.length(); i++){
            ansString += inputString.charAt(i);
        }
        for(int i = 0; i < index ; i++){
            ansString += inputString.charAt(i);
        }
        return ansString;
    }
    //This Method Is Used To Reverse A String
    public static String reverseString(String inputString){
        String ansString = "";
        for(int i = inputString.length() - 1; i >= 0; i--){
            ansString += inputString.charAt(i);
        }
        return ansString;
    }
    //This Method Is Used To Print Or Show All Operations Provided To User
    public static void showOperations(){
        System.out.println("1.Append()");
        System.out.println("2.CountWords()");
        System.out.println("3.Replace()");
        System.out.println("4.isPalindrome()");
        System.out.println("5.splice()");
        System.out.println("6.split()");
        System.out.println("7.MaxRepeatingCharacter()");
        System.out.println("8.Sort()");
        System.out.println("9.Shift()");
        System.out.println("10.Reverse()");
        System.out.println("11.exit()");

    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter A String:");
        String inputString = scanner.nextLine();
        int choice;
        do{
        //Showing All Operations
        showOperations();
        System.out.println("Enter Operation To Perform On String:");
        choice = scanner.nextInt();
        //Calling For Operation 1
        if(choice == 1){
            System.out.println("Enter New Appending String:");
            Scanner scanString = new Scanner(System.in);
            String appendString = scanString.nextLine();
            inputString = Append(inputString, appendString);
            System.out.println("String After Appending: "+inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operations:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 2
        else if(choice == 2){
            System.out.println("Total Number Of Words: "+countWords(inputString));
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operations:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 3
        else if(choice == 3){
            System.out.println("Enter String To Replace:");
            Scanner newScan = new Scanner(System.in);
            String oldString = newScan.nextLine();
            System.out.println("Enter New String:");
            Scanner newScan2 = new Scanner(System.in);
            String newString = newScan2.nextLine();
            inputString = replace(inputString, oldString, newString);
            System.out.println("New String: "+inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operations:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 4
        else if(choice == 4){
            if(isPalindrome(inputString))
            System.out.println("Given String Is a Palindrome");
            else
            System.out.println("Given String Is Not a Palindrome");
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operations:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 5
        else if(choice == 5){
            System.out.println("Enter Starting Index:");
            int startIndex = scanner.nextInt();
            System.out.println("Enter Length Of Splice:");
            int length = scanner.nextInt();
            inputString = spliceString(inputString, startIndex, length);
            System.out.println("New String "+inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operations:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 6
        else if(choice == 6){
            System.out.println("New Character Array Of String:");
            String []strToCharArray = splitString(inputString);
            for(int i = 0; i < countWords(inputString); i++){
                System.out.print(strToCharArray[i]+" ");
            }
                System.out.print("\nEnter 1 For More Operation Or Enter 2 To End Operations:");
                int newChoice = scanner.nextInt();
                if(newChoice == 2){
                    choice = 11;
                }
        }
        //Calling For Operation 7
        else if(choice == 7){
            System.out.println("Maximum Repeating Character:");
            maxRepeat(inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operation:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 8
        else if(choice == 8){
            System.out.println("Sorted String:");
            inputString = sortString(inputString);
            System.out.println(inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operation:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 9
        else if(choice == 9){
            System.out.println("Enter Number Of First n Letters To Shift:");
            int n = scanner.nextInt();
            inputString = shiftString(inputString, n);
            System.out.println("New Shifted String: "+inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operation:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        //Calling For Operation 10
        else if(choice == 10){
            inputString = reverseString(inputString);
            System.out.println("Reversed String: "+inputString);
            System.out.print("Enter 1 For More Operation Or Enter 2 To End Operation:");
            int newChoice = scanner.nextInt();
            if(newChoice == 2){
                choice = 11;
            }
        }
        }while(choice != 11);
        //Final Good Bye
        System.out.println("Thank You For Performing Operations");
        System.out.println("Final String:"+inputString);
    }
}