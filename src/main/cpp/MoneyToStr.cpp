#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main(){
    vector<string> strings;
    strings.push_back("string 1");
    strings.push_back("string 2");
    vector<string>::const_iterator strIter;
    string result("");
    for (strIter=strings.begin(); strIter!=strings.end(); strIter++) {
        cout << *strIter << endl;
        result = result + *strIter;
    }
    cout << "Basic list programm!" << endl;
    cout << "Together: " << result << endl;
    return 0;
}
