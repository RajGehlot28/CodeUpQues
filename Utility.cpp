// This files provides some of string operations like - valid paranthesis generator, sum of digits, consecutive numbers sum, caesar cipher encoding, encoded ASCII transformation
// Name - Raj Gehlot
// Date - 30/9/25

#include<iostream>
#include<vector>
#include<limits>
using namespace std;

// This function generates all combinations of well-formed parentheses for a given number of braces
void findParanthesis(int number, string paranthesis, int open, int close, vector<string>& result) {
    if(open == number && close == number) {
        result.push_back(paranthesis);
        return ;
    }
    if(open > number || close > number) {
        return ;
    }

    if(open < number) {
        findParanthesis(number, paranthesis+"(", open+1, close, result);
    }
    if(close < open) {
        findParanthesis(number, paranthesis+')', open, close+1, result);
    }
}
void paranthesisGenerator() {
    int number;
    cout << "Enter number of pairs of paranthesis: ";
    cin >> number;
    int limit = 10; // Limit to prevent excessive computation
    if(cin.fail() || number < 0 || number > limit) {
        if(number > limit) {
            cout << "Number too large, please enter a number less than or equal to " << limit << endl;
        }
        else {
            cout << "Invalid number or input please enter again:\n";
        }
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        paranthesisGenerator();
        return;
    }
    if(number == 0) {
        cout << "No Combinations possible for 0 pairs of paranthesis" << endl;
        return ;
    }
    vector<string> result;
    findParanthesis(number, "", 0, 0, result);
    cout << "All combinations of well-formed parentheses are:\n";
    for(auto paranthesis : result) {
        cout << paranthesis << endl;
    }
}

// This function finds number of ways to express a number as the sum of consecutive natrural numbers
int consecutiveSum() {
    int number, ways = 0;
    cout << "Enter a number: ";
    cin >> number;
    if(cin.fail() || number < 1) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid number or input please enter again:\n";
        return consecutiveSum();
    }
    int left = 1, right = 1, sum = 1;
    while(right <= number) {
        if(sum == number) {
            ways++;
        }
        if(sum < number) {
            right++;
            sum += right;
        }
        else {
            sum -= left;
            left++;
        }
    }
    return ways;
}

// This function take an array of characters and encode them using ASCII manipulation with a given series number
string transform() {
    int size, series;
    string tranformed = "";
    cout << "Enter size of character array:";
    cin >> size;
    if(cin.fail() || size < 1) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid number or input please enter again:\n";
        return transform();
    }
    cout << "Enter series of transformation:";
    cin >> series;
    if(cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid number or input please enter again:\n";
        return transform();
    }
    cout << "Enter characters:";
    char *characters = new char[size];
    for(int i = 0; i < size; i++) {
        cin >> characters[i];
    }
    for(int i = 0; i < size; i++) {
        characters[i] += series;
        tranformed += characters[i];
        if(i != size - 1) tranformed += " ";
    }
    return tranformed;
}

// This function Encode a given string using Caesar Cipher logic (shifting characters by a fixed value). 
string encoding() {
    string input;
    cout << "Enter a string:";
    cin >> input;
    string encoded = input;
    int shift;
    cout << "Enter a shift number:";
    cin >> shift;
    if(cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid number or input please enter again:\n";
        return encoding();
    }
    for(int i = 0; i < encoded.size(); i++) {
        encoded[i] += shift;
    }
    return encoded;
}

// This function used to find sum of digits of a number
int sumDigit() {
    string number;
    long long sum = 0;
    cout << "Enter a number: ";
    cin >> number;
    if(cin.fail()) {
        cin.clear();
        cin.ignore(numeric_limits<streamsize>::max(), '\n');
        cout << "Invalid number or input please enter again:\n";
        return sumDigit();
    }
    string num = number;
    int index = num.size() - 1;
    while(index >= 0) {
        char digit = num[index];
        if(digit < '0' || digit > '9') {
            cout << "Invalid number or input please enter again:\n";
            return sumDigit();
        }
        sum += (digit - '0');
        index--;
    }
    return sum;
}

bool choices() {
    cout << "Enter a choice:" << endl;
    cout << "1. Valid Garanthesis Generator" << endl;
    cout << "2. Sum of Digits" << endl;
    cout << "3. Consecutive Numbers Sum" << endl;
    cout << "4. Caesar Cipher Encoding" << endl;
    cout << "5. Encoded ASCII Transformation" << endl;
    cout << "Else enter 0 to exit" << endl;
    try {
        char choice;
        cin >> choice;
        switch(choice) {
            case '1': {
                paranthesisGenerator();
                break;
            }
            case '2': {
                int sum = sumDigit();
                cout << sum << endl;
                break;
            }
            case '3': {
                int ways = consecutiveSum();
                cout << ways << endl;
                break;
            }
            case '4': {
                string encode = encoding();
                cout << encode << endl;
                break;
            }
            case '5': {
                string transformation = transform();
                cout << transformation << endl;
                break;
            }
            case '0': {
                return false;
                break;
            }
            default: {
                cout << "Invalid input please enter again:" << endl;
                break;
            }
        }
        return true;
    }
    catch(exception e) {
        cout << "Invalid input please enter again" << endl;
        choices();
    }
    return false;
}
int main() {
    bool doAgain = true;
    while(doAgain) {
        doAgain = choices();
        if(!doAgain) break;
    }
    cout << "Thank You" << endl;
    return 0;

}
