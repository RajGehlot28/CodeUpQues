#include<iostream>
using namespace std;
string takeInput(string inputString) {
    getline(cin, inputString);
    return inputString;
}
string append(string inputString, string newString) {
    for(int i = 0; i < newString.size(); i++) {
        inputString += newString[i];
    }
    return inputString;
}
void append(string inputString) {
    string newString;
    cout << "Enter New String To Append:";
    newString = takeInput(newString);
    append(inputString, newString);
    string finalString = append(inputString, newString);
    cout << "Final String after append:" << finalString << endl;
}
int main() {
    string inputString = "", newString = "";
    cout << "Enter Original String:";
    inputString = takeInput(inputString);
    cout << "Enter New String To Append:";
    newString = takeInput(newString);
    append(inputString, newString);
    string finalString = append(inputString, newString);
    cout << "Final String after append:" << finalString << endl;
    return 0;
}