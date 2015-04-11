/*
 * $Id$
 *
 * Copyright 2015 Valentyn Kolesnikov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
#include <cmath>
#include <iostream>
#include <vector>
#include <sstream>
#include <string>
#include <stdexcept>
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
    string currency;
    string language;
    string pennies;
    string rubOneUnit;
    string rubTwoUnit;
    string rubFiveUnit;
    string kopOneUnit;
    string kopTwoUnit;
    string kopFiveUnit;
    string rubSex;
    string kopSex;
    static const int NUM0 = 0;
    static const int NUM1 = 1;
    static const int NUM2 = 2;
    static const int NUM3 = 3;
    static const int NUM4 = 4;
    static const int NUM5 = 5;
    static const int NUM6 = 6;
    static const int NUM7 = 7;
    static const int NUM8 = 8;
    static const int NUM9 = 9;
    static const int NUM10 = 10;
    static const int NUM11 = 11;
    static const int NUM14 = 14;
    static const int NUM100 = 100;
    static const int NUM1000 = 1000;
    static const int NUM10000 = 10000;
    static const int INDEX_0 = 0;
    static const int INDEX_1 = 1;
    static const int INDEX_2 = 2;
    static const int INDEX_3 = 3;
    vector<string> messages_0;
    vector<string> messages1000_10;
    vector<string> messages1000_1;
    vector<string> messages1000_234;
    vector<string> messages1000_5;
    vector<string> messages10_19;
    vector<string> messages1;
    vector<string> messages2;
    vector<string> messages3_9;
    vector<string> messages100_900;
    vector<string> messages20_90;

    public:
    MoneyToStr() {
    };

    MoneyToStr(string currency, string language, string pennies) {
        if (currency.empty()) {
            throw std::invalid_argument("currency is empty");
        }
        if (language.empty()) {
            throw std::invalid_argument("language is empty");
        }
        if (pennies.empty()) {
            throw std::invalid_argument("pennies is empty");
        }
        this->currency = currency;
        this->language = language;
        this->pennies = pennies;
        if (language == "RUS") {
            if (currency == "RUR") {
                rubOneUnit = "рубль";
                rubTwoUnit = "рубля";
                rubFiveUnit = "рублей";
                rubSex = "M";
                kopOneUnit = "копейка";
                kopTwoUnit = "копейки";
                kopFiveUnit = "копеек";
                kopSex = "F";
            } else if (currency == "UAH") {
                rubOneUnit = "гривня";
                rubTwoUnit = "гривни";
                rubFiveUnit = "гривень";
                rubSex = "F";
                kopOneUnit = "копейка";
                kopTwoUnit = "копейки";
                kopFiveUnit = "копеек";
                kopSex = "F";
            } else if (currency == "USD") {
                rubOneUnit = "доллар";
                rubTwoUnit = "доллара";
                rubFiveUnit = "долларов";
                rubSex = "M";
                kopOneUnit = "цент";
                kopTwoUnit = "цента";
                kopFiveUnit = "центов";
                kopSex = "M";
            } else if (currency == "PER10") {
                rubOneUnit = "целая,";
                rubTwoUnit = "целых,";
                rubFiveUnit = "целых,";
                rubSex = "F";
                kopOneUnit = "десятая процента";
                kopTwoUnit = "десятых процента";
                kopFiveUnit = "десятых процента";
                kopSex = "F";
            } else if (currency == "PER100") {
                rubOneUnit = "целая,";
                rubTwoUnit = "целых,";
                rubFiveUnit = "целых,";
                rubSex = "F";
                kopOneUnit = "сотая процента";
                kopTwoUnit = "сотых процента";
                kopFiveUnit = "сотых процента";
                kopSex = "F";
            } else if (currency == "PER1000") {
                rubOneUnit = "целая,";
                rubTwoUnit = "целых,";
                rubFiveUnit = "целых,";
                rubSex = "F";
                kopOneUnit = "тысячная процента";
                kopTwoUnit = "тысячных процента";
                kopFiveUnit = "тысячных процента";
                kopSex = "F";
            } else if (currency == "PER10000") {
                rubOneUnit = "целая,";
                rubTwoUnit = "целых,";
                rubFiveUnit = "целых,";
                rubSex = "F";
                kopOneUnit = "десятитысячная процента";
                kopTwoUnit = "десятитысячные процента";
                kopFiveUnit = "десятитысячных процента";
                kopSex = "F";
            } else {
                throw std::invalid_argument("Unsupported currency " + currency);
            }
            messages_0.push_back("ноль ");
            messages1000_10.push_back("тысяч");
            messages1000_10.push_back("миллионов");
            messages1000_10.push_back("миллиардов");
            messages1000_10.push_back("триллионов");
            messages1000_1.push_back("тысяча");
            messages1000_1.push_back("миллион");
            messages1000_1.push_back("миллиард");
            messages1000_1.push_back("триллион");
            messages1000_234.push_back("тысячи");
            messages1000_234.push_back("миллиона");
            messages1000_234.push_back("миллиарда");
            messages1000_234.push_back("триллиона");
            messages1000_5.push_back("тысяч");
            messages1000_5.push_back("миллионов");
            messages1000_5.push_back("миллиардов");
            messages1000_5.push_back("триллионов");
            messages10_19.push_back("десять");
            messages10_19.push_back("одиннадцать");
            messages10_19.push_back("двенадцать");
            messages10_19.push_back("тринадцать");
            messages10_19.push_back("четырнадцать");
            messages10_19.push_back("пятнадцать");
            messages10_19.push_back("шестнадцать");
            messages10_19.push_back("семнадцать");
            messages10_19.push_back("восемнадцать");
            messages10_19.push_back("девятнадцать");
            messages1.push_back("одна");
            messages1.push_back("один");
            messages1.push_back("один");
            messages1.push_back("одна");
            messages2.push_back("две");
            messages2.push_back("два");
            messages2.push_back("два");
            messages2.push_back("две");
            messages3_9.push_back("");
            messages3_9.push_back("");
            messages3_9.push_back("");
            messages3_9.push_back("три");
            messages3_9.push_back("четыре");
            messages3_9.push_back("пять");
            messages3_9.push_back("шесть");
            messages3_9.push_back("семь");
            messages3_9.push_back("восемь");
            messages3_9.push_back("девять");
            messages100_900.push_back("");
            messages100_900.push_back("сто ");
            messages100_900.push_back("двести ");
            messages100_900.push_back("триста ");
            messages100_900.push_back("четыреста ");
            messages100_900.push_back("пятьсот ");
            messages100_900.push_back("шестьсот ");
            messages100_900.push_back("семьсот ");
            messages100_900.push_back("восемьсот ");
            messages100_900.push_back("девятьсот ");
            messages20_90.push_back("");
            messages20_90.push_back("");
            messages20_90.push_back("двадцать ");
            messages20_90.push_back("тридцать ");
            messages20_90.push_back("сорок ");
            messages20_90.push_back("пятьдесят ");
            messages20_90.push_back("шестьдесят ");
            messages20_90.push_back("семьдесят ");
            messages20_90.push_back("восемьдесят ");
            messages20_90.push_back("девяносто ");
        } else if (language == "UKR") {
            if (currency == "RUR") {
                rubOneUnit = "рубль";
                rubTwoUnit = "рубля";
                rubFiveUnit = "рублів";
                kopOneUnit = "копійка";
                kopTwoUnit = "копійки";
                kopFiveUnit ="копійок";
                rubSex = "M";
                kopSex = "F";
            } else if (currency == "UAH") {
                rubOneUnit = "гривня";
                rubTwoUnit = "гривні";
                rubFiveUnit = "гривень";
                kopOneUnit = "копійка";
                kopTwoUnit = "копійки";
                kopFiveUnit = "копійок";
                rubSex = "F";
                kopSex = "F";
            } else if (currency == "USD") {
                rubOneUnit = "долар";
                rubTwoUnit = "долара";
                rubFiveUnit = "доларів";
                kopOneUnit = "цент";
                kopTwoUnit = "цента";
                kopFiveUnit = "центів";
                rubSex = "M";
                kopSex = "M";
            } else if (currency == "PER10") {
                rubOneUnit = "ціла,";
                rubTwoUnit = "цілих,";
                rubFiveUnit = "цілих,";
                rubSex = "F";
                kopOneUnit = "десята відсотка";
                kopTwoUnit = "десятих відсотка";
                kopFiveUnit = "десятих відсотка";
                kopSex = "F";
            } else if (currency == "PER100") {
                rubOneUnit = "ціла,";
                rubTwoUnit = "цілих,";
                rubFiveUnit = "цілих,";
                rubSex = "F";
                kopOneUnit = "сота відсотка";
                kopTwoUnit = "сотих відсотка";
                kopFiveUnit = "сотих відсотка";
                kopSex = "F";
            } else if (currency == "PER1000") {
                rubOneUnit = "ціла,";
                rubTwoUnit = "цілих,";
                rubFiveUnit = "цілих,";
                rubSex = "F";
                kopOneUnit = "тисячна відсотка";
                kopTwoUnit = "тисячних відсотка";
                kopFiveUnit = "тисячних відсотка";
                kopSex = "F";
            } else if (currency == "PER10000") {
                rubOneUnit = "ціла,";
                rubTwoUnit = "цілих,";
                rubFiveUnit = "цілих,";
                rubSex = "F";
                kopOneUnit = "десятитисячна відсотка";
                kopTwoUnit = "десятитисячних відсотка";
                kopFiveUnit = "десятитисячних відсотка";
                kopSex = "F";
            } else {
                throw std::invalid_argument("Unsupported currency " + currency);
            }
            messages_0.push_back("нуль ");
            messages1000_10.push_back("тисяч");
            messages1000_10.push_back("мільйонів");
            messages1000_10.push_back("мільярдів");
            messages1000_10.push_back("трильйонів");
            messages1000_1.push_back("тисяча");
            messages1000_1.push_back("мільйон");
            messages1000_1.push_back("мільярд");
            messages1000_1.push_back("трильйон");
            messages1000_234.push_back("тисячі");
            messages1000_234.push_back("мільйона");
            messages1000_234.push_back("мільярда");
            messages1000_234.push_back("трильйона");
            messages1000_5.push_back("тисяч");
            messages1000_5.push_back("мільйонів");
            messages1000_5.push_back("мільярдів");
            messages1000_5.push_back("трильйонів");
            messages10_19.push_back("десять");
            messages10_19.push_back("одинадцять");
            messages10_19.push_back("дванадцять");
            messages10_19.push_back("тринадцять");
            messages10_19.push_back("чотирнадцять");
            messages10_19.push_back("п’ятнадцять");
            messages10_19.push_back("шiстнадцять");
            messages10_19.push_back("сiмнадцять");
            messages10_19.push_back("вiсiмнадцять");
            messages10_19.push_back("дев'ятнадцять");
            messages1.push_back("одна");
            messages1.push_back("один");
            messages1.push_back("один");
            messages1.push_back("одна");
            messages2.push_back("дві");
            messages2.push_back("два");
            messages2.push_back("два");
            messages2.push_back("дві");
            messages3_9.push_back("");
            messages3_9.push_back("");
            messages3_9.push_back("");
            messages3_9.push_back("три");
            messages3_9.push_back("чотири");
            messages3_9.push_back("п’ять");
            messages3_9.push_back("шість");
            messages3_9.push_back("сім");
            messages3_9.push_back("вісім");
            messages3_9.push_back("дев’ять");
            messages100_900.push_back("");
            messages100_900.push_back("сто ");
            messages100_900.push_back("двісті ");
            messages100_900.push_back("триста ");
            messages100_900.push_back("чотириста ");
            messages100_900.push_back("п’ятсот ");
            messages100_900.push_back("шістсот ");
            messages100_900.push_back("сімсот ");
            messages100_900.push_back("вісімсот ");
            messages100_900.push_back("дев’ятсот ");
            messages20_90.push_back("");
            messages20_90.push_back("");
            messages20_90.push_back("двадцять ");
            messages20_90.push_back("тридцять ");
            messages20_90.push_back("сорок ");
            messages20_90.push_back("п’ятдесят ");
            messages20_90.push_back("шістдесят ");
            messages20_90.push_back("сімдесят ");
            messages20_90.push_back("вісімдесят ");
            messages20_90.push_back("дев’яносто ");
        } else {
            throw std::invalid_argument("Unsupported language " + language);
        }
    }

    template <class T>
    inline std::string toString(const T& t) {
        std::stringstream ss;
        ss << t;
        return ss.str();
    }

    static double round (double value) {
        return floor(value * 10000 + 0.5f) / 10000;
    }

    /**
     * Converts percent to string.
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR)
     * @return the string of percent
     */
    static string percentToStr(double amount, string lang) {
        if (lang.empty()) {
            throw std::invalid_argument("lang is empty");
        }
        long intPart = (long) amount;
        long fractPart = 0;
        string result = "";
        if (amount == (long) amount) {
            result = MoneyToStr("PER10", lang, "TEXT").convert(intPart, fractPart);
        } else if (round(amount * NUM10) == (long) (amount * NUM10)) {
            fractPart = (long) round((amount - intPart) * NUM10);
            result = MoneyToStr("PER10", lang, "TEXT").convert(intPart, fractPart);
        } else if (round(amount * NUM100) == (long) (amount * NUM100)) {
            fractPart = (long) round((amount - intPart) * NUM100);
            result = MoneyToStr("PER100", lang, "TEXT").convert(intPart, fractPart);
        } else if (round(amount * NUM1000) == (long) (amount * NUM1000)) {
            fractPart = (long) round((amount - intPart) * NUM1000);
            result = MoneyToStr("PER1000", lang, "TEXT").convert(intPart, fractPart);
        } else {
            fractPart = (long) round((amount - intPart) * NUM10000);
            result = MoneyToStr("PER10000", lang, "TEXT").convert(intPart, fractPart);
        }
        return result;
    }

    /**
     * Converts double value to the text description.
     *
     * @param theMoney
     *            the amount of money in format major.minor
     * @return the string description of money value
     */
    string convertValue(double theMoney) {
        long intPart = (long) theMoney;
        long fractPart = (long) round((theMoney - intPart) * NUM100);
        if (currency == "PER1000") {
            fractPart = (long) round((theMoney - intPart) * NUM1000);
        }
        return convert(intPart, fractPart);
    }

    /**
     * Converts number to currency. Usage: MoneyToStr moneyToStr = MoneyToStr("UAH", "UKR", "NUMBER"); String result =
     * moneyToStr.convert(123, 0); Expected: result = сто двадцять три гривні 00 копійок
     *
     * @param theMoney
     *            the amount of money major currency
     * @param theKopeiki
     *            the amount of money minor currency
     * @return the string description of money value
     */
    string convert(long theMoney, long theKopeiki) {
        StringBuilder money2str;
        long triadNum = 0;
        long theTriad;

        long intPart = theMoney;
        if (intPart == 0) {
            money2str.append(messages_0[0]);
        }
        do {
            theTriad = intPart % NUM1000;
            money2str.insert(0, triad2Word(theTriad, triadNum, rubSex));
            if (triadNum == 0) {
                long range10 = (theTriad % NUM100) / NUM10;
                long range = theTriad % NUM10;
                if (range10 == NUM1) {
                    money2str.append(rubFiveUnit);
                } else {
                    switch (range) {
                    case NUM1:
                        money2str.append(rubOneUnit);
                        break;
                    case NUM2: case NUM3: case NUM4:
                        money2str.append(rubTwoUnit);
                        break;
                    default:
                        money2str.append(rubFiveUnit);
                        break;
                    }
                }
            }
            intPart = intPart / NUM1000;
            triadNum += 1;
        } while (intPart > 0);

        if (pennies == "TEXT") {
            money2str.append(language == "ENG" ? " and " : " ");
            if (theKopeiki == 0) {
                money2str.append(messages_0[0]);
            } else {
                money2str.append(triad2Word(theKopeiki, 0, kopSex));
            }
        } else {
            money2str.append(" " + (theKopeiki < 10 ? "0" + toString(theKopeiki) : toString(theKopeiki)) + " ");
        }
        if (theKopeiki >= NUM11 && theKopeiki <= NUM14) {
            money2str.append(kopFiveUnit);
        } else {
            switch (theKopeiki % NUM10) {
            case NUM1:
                money2str.append(kopOneUnit);
                break;
            case NUM2: case NUM3: case NUM4:
                money2str.append(kopTwoUnit);
                break;
            default:
                money2str.append(kopFiveUnit);
                break;
            }
        }
        return money2str.toString();
    }

    string triad2Word(long triad, long triadNum, string sex) {
        StringBuilder triadWord;

        if (triad == 0) {
            return "";
        }

        long range = check1(triad, triadWord);
        if (language == "ENG" && triadWord.length() > 0 && triad % NUM10 == 0) {
            triadWord.deleteCharAt(triadWord.length() - 1);
            triadWord.append(" ");
        }

        long range10 = range;
        range = triad % NUM10;
        check2(triadNum, sex, triadWord, triad, range10);
        switch (triadNum) {
        case NUM0:
            break;
        case NUM1: case NUM2: case NUM3: case NUM4:
            if (range10 == NUM1) {
                triadWord.append(messages1000_10[triadNum - 1] + " ");
            } else {
                switch (range) {
                case NUM1:
                    triadWord.append(messages1000_1[triadNum - 1] + " ");
                    break;
                case NUM2: case NUM3: case NUM4:
                    triadWord.append(messages1000_234[triadNum - 1] + " ");
                    break;
                default:
                    triadWord.append(messages1000_5[triadNum - 1] + " ");
                    break;
                }
            }
            break;
        default:
            triadWord.append("??? ");
            break;
        }
        return triadWord.toString();
    }

    /**
     * @param triadNum the triad num
     * @param sex the sex
     * @param triadWord the triad word
     * @param triad the triad
     * @param range10 the range 10
     */
    void check2(long triadNum, string sex, StringBuilder & triadWord, long triad, long range10) {
        long range = triad % NUM10;
        if (range10 == 1) {
            triadWord.append(messages10_19[range] + " ");
        } else {
            switch (range) {
            case NUM1:
                if (triadNum == NUM1) {
                    triadWord.append(messages1[INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.append(messages1[INDEX_1] + " ");
                } else if ("M" == sex) {
                    triadWord.append(messages1[INDEX_2] + " ");
                } else if ("F" == sex) {
                    triadWord.append(messages1[INDEX_3] + " ");
                }
                break;
            case NUM2:
                if (triadNum == NUM1) {
                    triadWord.append(messages2[INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.append(messages2[INDEX_1] + " ");
                } else if ("M" == sex) {
                    triadWord.append(messages2[INDEX_2] + " ");
                } else if ("F" == sex) {
                    triadWord.append(messages2[INDEX_3] + " ");
                }
                break;
            case NUM3: case NUM4: case NUM5: case NUM6: case NUM7: case NUM8: case NUM9:
                triadWord.append(messages3_9[range] + " ");
                break;
            }
        }
    }

    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
    long check1(long triad, StringBuilder & triadWord) {
        long range = triad / NUM100;
        triadWord.append(messages100_900[range]);
        range = (triad % NUM100) / NUM10;
        triadWord.append(messages20_90[range]);
        return range;
    }

};
            