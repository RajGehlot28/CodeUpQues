import java.util.Scanner;
public class Main {
    public static void callClasses(String choice){
            if(choice.charAt(0) != '6' && choice.length() == 1){
                switch(choice.charAt(0)){
                    case '1':
                    DigitSumLoop obj1 = new DigitSumLoop();
                    obj1.takeInput();
                    break;
        
                    case '2':
                    ASCIIConversation obj2 = new ASCIIConversation();
                    obj2.takeInput();
                    break;
        
                    case '3':
                    ShiftVariability obj3 = new ShiftVariability();
                    obj3.takeInput();
                    break;
        
                    case '4':
                    ConsecutiveNumberSum obj4 = new ConsecutiveNumberSum();
                    obj4.takeInput();
                    break;
        
                    case '5':
                    ParanthesisCombination obj5 = new ParanthesisCombination();
                    obj5.takeInput();
                    break;

                    default:
                    System.out.println("Invalid input please enter again:");
                    break;
                }
                showOperations();
            }
            else if(choice.charAt(0) == '6' && choice.length() == 1){
                return ;
            }
            else{
                System.out.println("invalid input please enter again:");
                showOperations();
            }
    }
    public static boolean check(String input){
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) < '0' || input.charAt(i) > '6')
            return false;
        }
        return true;
    }
    public static void showOperations(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1.digitLoop():");
        System.out.println("2.ASCIIConversion():");
        System.out.println("3.ShiftVariability():");
        System.out.println("4.ConsecutiveNumberSum():");
        System.out.println("5.StringCombinataion():");
        System.out.print("Enter choice Or Enter 6 to exit:");
        String choice = scanner.nextLine();
        callClasses(choice);
    }
    public static void main(String[] args){
        showOperations();
    }
}
