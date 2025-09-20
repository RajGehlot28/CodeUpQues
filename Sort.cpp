#include<iostream>
using namespace std;
string takeInput(string inputString) {
    getline(cin, inputString);
    return inputString;
}
string sort(string inputString) {
    int n = inputString.size();
    // using selection sort
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
int main() {
    string inputString = "";
    cout << "Enter a string:" << endl;
    inputString = takeInput(inputString);
    inputString = sort(inputString);
    cout << "String after sorting all characters in alphabetical order: " << inputString;
    return 0;
}