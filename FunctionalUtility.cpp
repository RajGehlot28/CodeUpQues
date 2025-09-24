/*  This Program Includes Solution Of All Problems Of Assignment-1
    Name - Raj Gehlot
    Date - 16/9/25
 */


#include <bits/stdc++.h>
using namespace std;

// This function is used to print the length of longest substring without repeating characters
// example. input: s = "abcabcbb", Output: 3 
int getLength() {
    cout << "Enter a string:";
    string inputString;
    cin >> inputString;

    vector<int> indices(26, -1);
    int maxLength = 0;
    int left = 0, right = 0;

    while (right < inputString.size()) {
        char currCharacter = inputString[right];
        if (indices[currCharacter - 'a'] >= left) {
            left = indices[currCharacter - 'a'] + 1;
        }
        int currLength = right - left + 1;
        if (currLength > maxLength) maxLength = currLength;
        indices[currCharacter - 'a'] = right;
        right++;
    }
    return maxLength;
}

// This function is used to convert a input number to its word conversion
// example. Input: 51, Output: "fifty one"
void printTens(int index) {
    string tens[] = {"Ten", "Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};
    cout << tens[index-1] << " ";
}
void printOnes(int index) {
    string ones[] = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten"};
    cout << ones[index-1];
}
void printOthers(int number) {
    string others[] = {"Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","NineTeen"};
    int index = (number % 10);
    cout << others[index-1] << endl;
}
void printNumber(int number) {
    // base case for 0 and 1000
    if(number == 0) {
        cout << "Zero" << endl;
        return ;
    }
    if(number == 1000) {
        cout << "One Thousand" << endl;
        return ;
    }

    int store[3] = {0,0,0};
    int index = 0;
    int num = number;
    while(num > 0) {
        int rem = num % 10;
        store[index++] = rem;
        num = num / 10;
    }
    reverse(store, store+3);

    index = 0;
    while(index < 3) {
        // printing hundreds - 100,200,300,etc.
        if(index == 0 && store[index] != 0) {
            printOnes(store[index]);
            cout << " Hundred ";
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
void getWord() {
    int number;
    cout << "Enter a number:";
    cin >> number;
    while(number < 0 || number > 1000) {
        cout << "Invalid number please enter again:";
        cin >> number;
    }
    printNumber(number);
}

// This program is used to check whether a input number is a prime number or not
// example. Input: 21, Output: "The given number is NOT prime"
bool isPrime(int number) {
    if(number <= 1) return false;
    for(int i = 2; i < number; i++) {
        if(number % i == 0) return false;
    }
    return true;
}
void primeChecker() {
    int number;
    cout << "Enter a number:";
    cin >> number;
    if(isPrime(number)) {
        cout << "The given number is a prime number" << endl;
    }
    else {
        cout << "The given number is not a prime number" << endl;
    }
}

// This program is used to print Frequency of a character from a input string
// example. Input: "aabcccdeee", Output: "a2b1c3d1e3"
string getFrequency() {
    cout << "Enter a string:";
    string inputString;
    cin >> inputString;
    string charFreqString = "";
    int index = 0;
    while(index < (int)inputString.size()) {
        char currentCharacter = inputString[index];
        int occurance = 0;
        while(index < (int)inputString.size() && inputString[index] == currentCharacter) {
            index++;
            occurance++;
        }
        charFreqString += currentCharacter;
        charFreqString += to_string(occurance);
    }
    return charFreqString;
}

// This program is used to extand characters in an input string with a perticular digit
// example. Input: "a1b4c3", Output: "abbbbccc"
string expand() {
    cout << "Enter a string:";
    string inputString;
    cin >> inputString;
    string extendedString = "";
    for(int i = 1; i < (int)inputString.size(); i+=2) {
        if(inputString[i] >= '0' && inputString[i] <= '9') {
            char lastChar = inputString[i-1];
            int times = inputString[i] - '0';
            for(int j = 0; j < times; j++) {
                extendedString += lastChar;
            }
        }
    }
    return extendedString;
}

int main() {
    bool flag = true;
    while(flag == true) {
        cout << "Choose a question basis on its sequence:" << endl;
        cout << "1. String Expand" << endl;
        cout << "2. String Frequency" << endl;
        cout << "3. Check For Prime" << endl;
        cout << "4. Number To Word" << endl;
        cout << "5. Longest Non-Repeating Character Substring" << endl;
        cout << "Or enter -1 to exit" << endl;
        int choice;
        cin >> choice;
        switch(choice) {
            case 1: {
                string expended = expand();
                cout << expended << endl;
            }
            break;
            case 2: {
                string freqString = getFrequency();
                cout << "characters with their frequencies: " << freqString << endl;
            }
            break;
            case 3:
                primeChecker();
            break;
            case 4:
                getWord();
            break;
            case 5: {
                int length = getLength();
                cout << "Length of longest substring without repeating characters: " << length << endl;
            }
            break;
            case -1:
                flag = false;
            break;
            default:
                cout << "Invalid input" << endl;
            break;
        }
    }
    return 0;
}