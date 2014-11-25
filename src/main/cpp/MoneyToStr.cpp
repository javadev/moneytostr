#include <iostream>
#include <vector>
#include <string>
using namespace std;

class StringBuilder {
    vector<string> _buffer;

    public:
    StringBuilder() {
    }

    StringBuilder & append(string text) {
        _buffer.push_back(text);
        return *this;
    }

    StringBuilder & insert(int index, string text) {
        _buffer.insert(_buffer.begin() + index, text);
        return *this;
    }

    int length() {
        return toString().length();
    }

    StringBuilder & deleteCharAt(int index) {
        string str = toString();
        _buffer.clear();
        append(str.substr(0, index));
        return *this;
    }

    string toString() {
        string result("");
        for (vector<string>::const_iterator strIter = _buffer.begin(); strIter != _buffer.end(); strIter++) {
            result = result + *strIter;
        }
        return result;
    }
};

class MoneyToStr {
    public:
    MoneyToStr(string currency, string language, string pennies) {
        if (currency == "") {
            throw std::invalid_argument("currency is null");
        }
        if (language == "") {
            throw std::invalid_argument("language is null");
        }
        if (pennies == "") {
            throw std::invalid_argument("pennies is null");
        }
    }
};

int main(int argc, char *argv[]) {
    string amount = "123.25";
    string language = "ENG";
    string currency = "USD";
    string pennies = "TEXT";
    if (argc == 1) {
        cout << "Usage: MoneyToStr --amount=123.25 --language=rus|ukr|eng --currency=rur|uah|usd --pennies=text|number" << endl;
    }
    return 0;
}
