#include <iostream>
#include <vector>
#include <string>
using namespace std;

class StringBuilder {
    vector<string> _buffer;

    StringBuilder() {
//        this._buffer = new List();
    }

    public:
    StringBuilder append(string text) {
        _buffer.push_back(text);
        return *this;
    }
/*
    StringBuilder insert(index, text) {
        _buffer.insert(index, text);
        return *this;
    }

    int length() {
        return toString().length();
    }

    StringBuilder deleteCharAt(index) {
        var str = this.toString();
        this._buffer = new List();
        append(str.substring(0, index));
        return this;
    }

    String toString() {
        return _buffer.join("");
    }
*/
};

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
