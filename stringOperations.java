/* This is java code to perform following opertaions on string - Append, CountWords, Replace, 
isPalindrome, Splice, Split, MaxRepeatingCharacter, Sort, Shift, and Reverse. 
Date Of Creation - 29/11/24 
Programmer - Raj Gehlot*/
import java.util.Scanner;
public class stringOperations {
    Scanner scanner = new Scanner(System.in);
    //This Method Is Used To Append A String
    public static String Append(String old,String New){
        old = old + New;
        return old;
    }
    //This Method Is Used To Count Number Of Words In Strings
    public static int countWords(String input){
        int count = 0;
        int index = 0;
        while(index < input.length()){
            if(input.charAt(index) != ' '){
                count++;
                while(index < input.length() && input.charAt(index) != ' '){
                    index++;
                }
            }
            index++;
        }
        return count;
    }
    //Method To Check Equality Of Two String
    public static Boolean compare(String first, String second){
        if(first.length() != second.length()){
            return false;
        }
        int firstIndex = 0;
        int secondIndex = 0;
        while(firstIndex < first.length() && secondIndex < second.length()){
            if(first.charAt(firstIndex) != second.charAt(secondIndex)){
                return false;
            }
            firstIndex++;
            secondIndex++;
        }
        return true;
    }
    //This Method Is Used To Replace Characters In String
    public static void replace(String input, String old, String New){
        String output = "";
        String dummy = "";
        boolean check = true;
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == old.charAt(0)){
                dummy = "";
                check = true;
                for(int j = i; j < input.length() && check == true; j++){
                    dummy += input.charAt(j);
                    if(compare(dummy,old) == true){
                        i = j;
                        output += New;
                        check = false;
                    }
                }
                if(check == true){
                    output += input.charAt(i);
                }
            }
            else{
                output += input.charAt(i);
            }
        }
        System.out.println("Original String:" + input);
        System.out.println("String After Replace:"+output);
    }
    //This Method Is Used To Check If A Given String Is Palindrome Or Not
    public static boolean isPalindrome(String input){
        int start = 0;
        int end = input.length() - 1;
        while(start <= end){
            if(input.charAt(start) != input.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    //This Method Is Used To Splice From A Given Starting Index And Length Of Splice
    public static void splice(String input, int start, int length){
        String output = "";
        for(int i = 0; i < input.length(); i++){
            if(i == start){
                while(i < start + length - 1){
                    i++;
                }
            }
            else{
                output += input.charAt(i);
            }
        }
        System.out.println("Original String:" + input);
        System.out.println("Spliced String:" + output);
    }
    //This Method Is Used To Split A String In An Array
    public static void split(String input){
        int size = countWords(input);
        String []Words = new String[size];
        int index = 0;
        for(int i = 0; i < input.length(); i++){
            Words[index] = "";
            if(input.charAt(i) != ' '){
                while(i < input.length() && input.charAt(i) != ' '){
                    Words[index] += input.charAt(i);
                    i++;
                }
                index++;
            }
        }
        System.out.print("[ ");
        for(int i = 0; i < size; i++){
            if(i != size - 1)
            System.out.print("\"" + Words[i] + "\", ");
            else
            System.out.print("\"" + Words[i] + "\"");
        }
        System.out.println(" ]");
    }
    //This Method Is Used To Find Max Occurring Letter In A String And Its Count 
    public static void maxRepeat(String input){
        int max = 0;
        int count = 0;
        char []Array = new char[input.length()];
        int index = 0;
        for(int i = 0; i < input.length(); i++){
            count = 1;
            for(int j = i + 1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j) && input.charAt(i) != ' '){
                    count++;
                }
            }
            if(count > max){
                max = count;
            }
        }
        for(int i = 0; i < input.length(); i++){
            count = 1;
            for(int j = i + 1; j < input.length(); j++){
                if(input.charAt(i) == input.charAt(j) && input.charAt(i) != ' '){
                    count++;
                }
            }
            if(count == max){
                Array[index++] = input.charAt(i);
            }
        }
        if(max == 1)
        System.out.println("No Maximum Count Letter Found");
        else{
            for(int i = 0; i < index; i++)
            System.out.println("'" + Array[i] +  "'" + " -> " + max);
        }
    }
    //This Method Is Used To Sort A String
    public static void sort(String input){
        char []Array = new char[input.length()];
        String output = "";
        for(int i = 0; i < input.length(); i++){
            if( input.charAt(i) != ' ')
            Array[i] = input.charAt(i);
        }
        char temp = ' ';
        for(int i = 0; i < input.length() - 1; i++){
            for(int j = i + 1;j < input.length(); j++){
                if(Array[i] > Array[j]){
                    temp = Array[i];
                    Array[i] = Array[j];
                    Array[j] = temp;
                }
            }
        }
        for(int i = 0; i < input.length(); i++){
            output += Array[i];
        }
        System.out.println("Original String:" + input);
        System.out.println("Sorted String:" + output);
    }
    //This Method Is Used To Shift First n Character To End Of String
    public static void shift(String input, int index){
        String output = "";
        for(int i = index; i < input.length(); i++){
            output += input.charAt(i);
        }
        for(int i = 0; i < index ; i++){
            output += input.charAt(i);
        }
        System.out.println("Original String:" + input);
        System.out.println("String After Shift:" + output);
    }
    //This Method Is Used To Reverse A String
    public static void reverse(String input){
        String output = "";
        for(int i = input.length() - 1; i >= 0; i--){
            output += input.charAt(i);
        }
        System.out.println("Original String:" + input);
        System.out.println("Reversed String:" + output);
    }
    public static void performOperations(String input, int choice){
        Scanner scanner = new Scanner(System.in);
        if(choice != 11){
        showOperations();
        System.out.println("Enter Operation To Perform On String:");
        choice = scanner.nextInt();
        }
        switch(choice){
            case 1:
            System.out.println("Enter New Appending String:");
            Scanner Scan1 = new Scanner(System.in);
            String appendString = Scan1.nextLine();
            input = Append(input, appendString);
            System.out.println("String After Appending: " + input);
            break;

            case 2:
            System.out.println("Total Number Of Words: "+countWords(input));
            break;

            case 3:
            System.out.println("Enter String To Replace:");
            Scanner scan2 = new Scanner(System.in);
            String old = scan2.nextLine();
            System.out.println("Enter New String:");
            Scanner scan3 = new Scanner(System.in);
            String New = scan3.nextLine();
            replace(input, old, New);
            break;

            case 4:
            if(isPalindrome(input))
            System.out.println("Given String Is a Palindrome");
            else
            System.out.println("Given String Is Not a Palindrome");
            break;

            case 5:
            System.out.println("Enter Starting Index:");
            int start = scanner.nextInt();
            System.out.println("Enter Length Of Splice:");
            int length = scanner.nextInt();
            splice(input, start, length);
            break;

            case 6:
            System.out.println("New Character Array Of String:");
            split(input);
            break;

            case 7:
            System.out.println("Maximum Repeating Characters:");
            maxRepeat(input);
            break;

            case 8:
            System.out.println("Sorted String:");
            sort(input);
            break;

            case 9:
            System.out.println("Enter Number Of First n Letters To Shift:");
            int n = scanner.nextInt();
            shift(input, n);
            break;

            case 10:
            reverse(input);
            break;

            case 11:
            return ;
            
            default:
            System.out.println("Invalid Input Please Enter Between 1 - 11:");
            performOperations(input, 1);
            break;
        }
        System.out.println("Enter Any Key For Further Operation Or Press 11 To Exit");
        Scanner scan4 = new Scanner(System.in);
        choice = scan4.nextInt();
        performOperations(input, choice);
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
        String input = scanner.nextLine();
        performOperations(input,1);
        System.out.println("Your String:" + input);
    } 
}