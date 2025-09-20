#include<iostream>
using namespace std;
string takeInput(string inputString) {
    getline(cin, inputString);
    return inputString;
}
string replace(string inputString, char oldChar, char newChar) {
    for(int i = 0; i < inputString.size(); i++) {
        if(inputString[i] == oldChar) inputString[i] = newChar;
    }
    return inputString;
}
string replaceCharacter(string inputString) {
    char oldChar, newChar;
    try {
        cout << "Enter character to replace: ";
        cin >> oldChar;
        cout << "Enter new character to insert: ";
        cin >> newChar;
        inputString = replace(inputString, oldChar, newChar);
    }
    catch(exception e) {
        cout << "Invalid character please enter again:" << endl;
        replaceCharacter(inputString);
    }
    return inputString;
}
int main() {
    string inputString = "";
    cout << "Enter a string:";
    inputString = takeInput(inputString);
    char oldChar, newChar;
    cout << "Enter character to replace: ";
    cin >> oldChar;
    cout << "Enter new character to insert: ";
    cin >> newChar;
    inputString = replace(inputString, oldChar, newChar);
    cout << "String after replacement of character: " << inputString << endl;
    return 0;
}