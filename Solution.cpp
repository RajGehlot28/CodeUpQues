// This files has solution of week-1 stories
// Name - Raj Gehlot
// Date - 4/11/25

#include<iostream>
#include<vector>
#include<math.h>
using namespace std;

class Point {
    float x, y;

    public:
    Point(float x, float y) {
        this->x = x;
        this->y = y;
    }

    float distance(float x_point, float y_point) {
        float sq1 = float(x_point - x) * (x_point - x);
        float sq2 = float(y_point - y) * (y_point - y);
        return sqrt(sq1 + sq2);
    }

    void translate(float new_x, float new_y) {
        this->x = new_x;
        this->y = new_y;
    }

    void display() {
        cout << "(" << this->x << ", " << this->y << ")" << endl;
    }
};

class Shape : public Point {
    public:
    void get_area() {};
};

class Circle {
    float radius;
    public:

    Circle(float radius) {
        this->radius = radius;
    }

    float get_area() {
        float area = 3.14 * (this->radius)*(this->radius);
        return area;
    }
};

class Square {
    float side;
    public:

    Square(float side) {
        this->side = side;
    }

    float get_area() {
        return this->side * this->side;
    }
};

void GeometryOperations() {
    float x1, x2, y1, y2, new_x, new_y;
    float side, radius;
    cout << "Enter co-ordinates of point-1(x1, y1):";
    cin >> x1 >> y1;
    cout << "Enter co-ordinates of point-2(x2, y2):";
    cin >> x2 >> y2;
    cout << "Enter radius of circle:";
    cin >> radius;
    cout << "Enter side of square:";
    cin >> side;
    cout << "Enter co-ordinates of translation point:";
    cin >> new_x >> new_y;

    Point point(x1, y1);
    Circle circle(radius);
    Square square(side);

    float distance = point.distance(x2, y2);
    float circleArea = circle.get_area();
    float squareArea = square.get_area();
    point.translate(new_x, new_y);

    cout << "Distance: " << distance << endl;
    cout << "Circle Area: " << circleArea << endl;
    cout << "Square Area: " << squareArea << endl;
    cout << "Translated Point1: ";
    point.display();
    cout << endl;
}

void travel() {
    int cities, energy;
    vector<int> costs;
    try {
        cout << "Enter number of cites:";
        cin >> cities;
        cout << "Enter initial energy:";
        cin >> energy;
        cout << "Enter cost to travel cities:" << endl;
        costs.resize(cities);
        for(int i = 0; i < cities; i++) {
            cin >> costs[i];
        }
    }
    catch(exception e) {
        cout << "Invalid input please enter again:" << endl;
        travel();
        return ;
    }
    for(int i = 0; i < costs.size(); i++) {
        energy -= costs[i];
        if(i == cities-1 || energy < 0) {
            cout << i << endl;
            break;
        }
    }
}
void equalSum() {
    int size;
    vector<int> numbers;
    try {
        cout << "Enter the size of array:";
        cin >> size;
        numbers.resize(size);
        cout << "Enter elements of array:" << endl;
        for(int i = 0; i < size; i++) cin >> numbers[i];
    }
    catch(exception e) {
        cout << "Invalid input please enter again:" << endl;
        equalSum();
        return;
    }

    int prefSum = 0, suffSum = 0;
    for(int i = size-1; i > 0; i--) {
        suffSum += numbers[i];
    }
    for(int i = 0; i < size; i++) {
        if(prefSum == suffSum) {
            cout << i << endl;
            return;
        }
        prefSum += numbers[i];
        if(i+1 < size) suffSum -= numbers[i+1];
    }
    cout << -1 << endl;
}
void flip() {
    int size;
    cout << "Enter size of binary array:";
    cin >> size;
    vector<int> binary(size);
    cout << "Enter binary array:" << endl;
    for(int i = 0; i < size; i++) cin >> binary[i];
    int minFlips = 0;
    int zeroCount = 0, oneCount = 0;
    for(int i = 0; i < size; i++) {
        if(binary[i] == 0) zeroCount++;
        else oneCount++;
    }
    if(zeroCount < oneCount) {
        cout << zeroCount << endl;
    }
    else {
        cout << oneCount << endl;
    }
}
void oddOut() {
    int size;
    cout << "Enter size of the array:";
    cin >> size;
    if(size%2 == 0) {
        cout << "Size should be odd please enter again:" << endl;
        oddOut();
        return;
    }
    cout << "Enter elements of array:" << endl;
    vector<int> numbers(size);
    for(int i = 0; i < size; i++) cin >> numbers[i];
    int unique = 0;
    for(int i = 0; i < size; i++) {
        unique ^= numbers[i];
    }
    cout << unique << endl;
}
void smartPair() {
    int size, target;
    cout << "Enter size of the array:" << endl;
    cin >> size;
    cout << "Enter target sum:";
    cin >> target;
    cout << "Enter elements of array:" << endl;
    vector<int> numbers(size);
    for(int i = 0; i < size; i++) cin >> numbers[i];

    for(int i = 0; i < size; i++) {
        for(int j = i+1; j < size; j++) {
            if(numbers[i] + numbers[j] == target) {
                cout << "true" << endl;
                return;
            }
        }
    }
    cout << "false" << endl;
}
void paint() {
    int walls;
    cout << "Enter number of walls:" << endl;
    cin >> walls;
    cout << "Enter time to paint each wall:" << endl;
    vector<int> time(walls);
    for(int i = 0; i < walls; i++) cin >> time[i];

    int maxTime = 0;
    int totalTime = 0;
    for(int i = 0; i < walls; i++) {
        totalTime += time[i];
        maxTime = max(maxTime, time[i]);
    }
    cout << totalTime - maxTime << endl;
}
int main() {
    bool flag = true;
    while(flag) {
        cout << "Enter a choice:" << endl;
        cout << "1. Efficient traveler:" << endl;
        cout << "2. Stand out sum:" << endl;
        cout << "3. Flip the switch:" << endl;
        cout << "4. Odd one out:" << endl;
        cout << "5. Smart pair finder:" << endl;
        cout << "6. The Minimalist Painter:" << endl;
        cout << "7. Geometry operations:" << endl;
        cout << "0. to end:" << endl;
        string choice;
        cin >> choice;
        switch(choice[0]) {
            case '1':
                travel();
            break;
            case '2':
                equalSum();
            break;
            case '3':
                flip();
            break;
            case '4':
                oddOut();
            break;
            case '5':
                smartPair();
            break;
            case '6':
                paint();
            break;
            case '7':
                GeometryOperations();
            break;
            case '0':
                flag = false;
            break;
            default:
                cout << "Invalid input please enter again:" << endl;
            break;
        }
    }
    cout << "Thank You\n";
    return 0;
}