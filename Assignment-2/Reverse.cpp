#include<iostream>
using namespace std;
string takeInput(string inputString) {
    getline(cin, inputString);
    return inputString;
}
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
int main() {
    string inputString = "";
    cout << "Enter a string:" << endl;
    inputString = takeInput(inputString);
    inputString = reverse(inputString);
    cout << "String after reverse: " << inputString << endl;
    return 0;
}