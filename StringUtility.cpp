// This files provides some of string operations like - append, replace character, sort, reverse
// Name - Raj Gehlot
// Date - 19/9/25

#include<iostream>
using namespace std;

// This function is used to append new string to existing string
string append(string inputString, string newString) {
    for(int i = 0; i < newString.size(); i++) {
        inputString += newString[i];
    }
    return inputString;
}
string appendString(string inputString) {
    string newString;
    cout << "Enter New String To Append:";
    getline(cin, newString);
    string finalString = append(inputString, newString);
    return finalString;
}

// This function is used to replace all occurance of a character with new character
string replace(string inputString, string oldString, string newString) {
    int size = inputString.size();
    string currString = "";
    for(int i = 0; i < inputString.size(); i++) {
        string subString = "";
        for(int j = i; j < i+oldString.size() && j < size; j++) {
            subString += inputString[j];
        }
        if(subString == oldString) {
            currString += newString;
            i += oldString.size();
            if(i >= size) break;
        }
        currString += inputString[i];
    }
    return currString;
}
string replaceCharacter(string inputString) {
    string oldString, newString;
    cout << "Enter character to replace: ";
    cin >> oldString;
    cout << "Enter new character to insert: ";
    cin >> newString;
    inputString = replace(inputString, oldString, newString);
    return inputString;
}

// This function is used to sort an string according to it's alphabetical order
string sort(string inputString) {
    int n = inputString.size();
    // using bubble sort
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < n-i-1; j++) {
            if(inputString[j] > inputString[j+1]) {
                char temp = inputString[j];
                inputString[j] = inputString[j+1];
                inputString[j+1] = temp;
            }
        }
    }
    return inputString;
}

// This function is used to reverse a string
string reverse(string inputString) {
    int leftPointer = 0, rightPointer = inputString.size()-1;
    while(leftPointer < rightPointer) {
        char temp = inputString[leftPointer];
        inputString[leftPointer] = inputString[rightPointer];
        inputString[rightPointer] = temp;
        leftPointer++;
        rightPointer--;
    }
    return inputString;
}

// This function is used to select which operation to perform
bool selectChoice(string &inputString) {
    string choice = "";
    cout << "choose operation to perform with string by it's sequence: " << endl;
    cout << "1. Append new string to existing string" << endl;
    cout << "2. Replace character" << endl;
    cout << "3. Sort characters in string in alphabetical order" << endl;
    cout << "4. Reverse a string" << endl;
    cout << "5. Enter 0 to exit()" << endl;
    cin >> choice;

    if(choice.empty()) return true;
    switch(choice[0]) {
        case '0':
            cout << "Thank you" << endl;
            return false;
        break;
        case '1':
            inputString = appendString(inputString);
            cout << "Final String after append:" << inputString << endl;
        break;
        case '2':
            inputString = replaceCharacter(inputString);
            cout << "String after replacement of character: " << inputString << endl;
        break;
        case '3':
            inputString = sort(inputString);
            cout << "String after sorting all characters in alphabetical order: " << inputString << endl;
        break;
        case '4':
            inputString = reverse(inputString);
            cout << "String after reverse: " << inputString << endl;
        break;
        default:
            cout << "Invalid input please enter again:" << endl;
        break;
    }
    return true;
}

int main() {
    string inputString = "";
    cout << "Enter a string:";
    getline(cin, inputString);
    bool doAgain = true;
    while(doAgain) {
        doAgain = selectChoice(inputString);
        if(!doAgain) break;
    }
    return 0;
}