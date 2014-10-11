/*
 * $Id$
 *
 * Copyright 2013 Valentyn Kolesnikov
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

library moneytostr;

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn V Kolesnikov
 * @version $Revision$ $Date$
 */
class StringBuilder {
    List _buffer;

    StringBuilder() {
        this._buffer = new List();
    }

    StringBuilder append(text) {
        this._buffer.add(text);
        return this;
    }
        
    StringBuilder insert(index, text) { 
        this._buffer.insert(index, text);
        return this;
    }

    int length() {
        return this.toString().length;
    }

    StringBuilder deleteCharAt(index) {
        var str = this.toString();
        this._buffer = new List();
        append(str.substring(0, index)); 
        return this;
    }

    String toString() {
        return this._buffer.join("");
    }
}

class Currency {
   final _value;
   const Currency._internal(this._value);
   toString() => '$_value';

   static const RUR = const Currency._internal('RUR');
   static const UAH = const Currency._internal('UAH');
   static const USD = const Currency._internal('USD');
   static const PER10 = const Currency._internal('PER10');
   static const PER100 = const Currency._internal('PER100');
   static const PER1000 = const Currency._internal('PER1000');
   static const PER10000 = const Currency._internal('PER10000');
}

class Language {
   final _value;
   const Language._internal(this._value);
   toString() => '$_value';

   static const RUS = const Language._internal('RUS');
   static const UKR = const Language._internal('UKR');
   static const ENG = const Language._internal('ENG');
}

class Pennies {
   final _value;
   const Pennies._internal(this._value);
   toString() => '$_value';

   static const NUMBER = const Pennies._internal('NUMBER');
   static const TEXT = const Pennies._internal('TEXT');
}

class MoneyToStr {
static Map json =
{
  "CurrencyList": {
    "language": { "-value": "UKR" },
    "UKR": {
      "item": [
        {
          "-value": "0",
          "-text": "нуль"
        },
        {
          "-value": "1000_10",
          "-text": "тисяч,мільйонів,мільярдів,трильйонів"
        },
        {
          "-value": "1000_1",
          "-text": "тисяча,мільйон,мільярд,трильйон"
        },
        {
          "-value": "1000_234",
          "-text": "тисячі,мільйона,мільярда,трильйона"
        },
        {
          "-value": "1000_5",
          "-text": "тисяч,мільйонів,мільярдів,трильйонів"
        },
        {
          "-value": "10_19",
          "-text": "десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п’ятнадцять,шiстнадцять,сiмнадцять,вiсiмнадцять,дев'ятнадцять"
        },
        {
          "-value": "1",
          "-text": "одна,один,один,одна"
        },
        {
          "-value": "2",
          "-text": "дві,два,два,дві"
        },
        {
          "-value": "3_9",
          "-text": "три,чотири,п’ять,шість,сім,вісім,дев’ять"
        },
        {
          "-value": "100_900",
          "-text": "сто ,двісті ,триста ,чотириста ,п’ятсот ,шістсот ,сімсот ,вісімсот ,дев’ятсот "
        },
        {
          "-value": "20_90",
          "-text": "двадцять ,тридцять ,сорок ,п’ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев’яносто "
        }
      ]
    },
    "RUS": {
      "item": [
        {
          "-value": "0",
          "-text": "ноль"
        },
        {
          "-value": "1000_10",
          "-text": "тысяч,миллионов,миллиардов,триллионов"
        },
        {
          "-value": "1000_1",
          "-text": "тысяча,миллион,миллиард,триллион"
        },
        {
          "-value": "1000_234",
          "-text": "тысячи,миллиона,миллиарда,триллиона"
        },
        {
          "-value": "1000_5",
          "-text": "тысяч,миллионов,миллиардов,триллионов"
        },
        {
          "-value": "10_19",
          "-text": "десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать"
        },
        {
          "-value": "1",
          "-text": "одна,один,один,одна"
        },
        {
          "-value": "2",
          "-text": "две,два,два,две"
        },
        {
          "-value": "3_9",
          "-text": "три,четыре,пять,шесть,семь,восемь,девять"
        },
        {
          "-value": "100_900",
          "-text": "сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот "
        },
        {
          "-value": "20_90",
          "-text": "двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто "
        }
      ]
    },
    "ENG": {
      "item": [
        {
          "-value": "0",
          "-text": "zero"
        },
        {
          "-value": "1000_10",
          "-text": "thousand,million,billion,trillion"
        },
        {
          "-value": "1000_1",
          "-text": "thousand,million,billion,trillion"
        },
        {
          "-value": "1000_234",
          "-text": "thousand,million,billion,trillion"
        },
        {
          "-value": "1000_5",
          "-text": "thousand,million,billion,trillion"
        },
        {
          "-value": "10_19",
          "-text": "ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen"
        },
        {
          "-value": "1",
          "-text": "one,one,one,one"
        },
        {
          "-value": "2",
          "-text": "two,two,two,two"
        },
        {
          "-value": "3_9",
          "-text": "three,four,five,six,seven,eight,nine"
        },
        {
          "-value": "100_900",
          "-text": "one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred "
        },
        {
          "-value": "20_90",
          "-text": "twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-"
        }
      ]
    },
    "RUR": [
      {
        "-CurrID": "810",
        "-CurrName": "Российские рубли",
        "-language": "RUS",
        "-RubOneUnit": "рубль",
        "-RubTwoUnit": "рубля",
        "-RubFiveUnit": "рублей",
        "-RubSex": "M",
        "-RubShortUnit": "руб.",
        "-KopOneUnit": "копейка",
        "-KopTwoUnit": "копейки",
        "-KopFiveUnit": "копеек",
        "-KopSex": "F"
      },
      {
        "-CurrID": "810",
        "-CurrName": "Российские рубли",
        "-language": "UKR",
        "-RubOneUnit": "рубль",
        "-RubTwoUnit": "рублі",
        "-RubFiveUnit": "рублів",
        "-RubSex": "M",
        "-RubShortUnit": "руб.",
        "-KopOneUnit": "копійка",
        "-KopTwoUnit": "копійки",
        "-KopFiveUnit": "копійок",
        "-KopSex": "F"
      },
      {
        "-CurrID": "810",
        "-CurrName": "Российские рубли",
        "-language": "ENG",
        "-RubOneUnit": "ruble",
        "-RubTwoUnit": "rubles",
        "-RubFiveUnit": "rubles",
        "-RubSex": "M",
        "-RubShortUnit": "RUR.",
        "-KopOneUnit": "kopeck",
        "-KopTwoUnit": "kopecks",
        "-KopFiveUnit": "kopecks",
        "-KopSex": "M"
      }
    ],
    "UAH": [
      {
        "-CurrID": "980",
        "-CurrName": "Украинскі гривні",
        "-language": "RUS",
        "-RubOneUnit": "гривня",
        "-RubTwoUnit": "гривни",
        "-RubFiveUnit": "гривень",
        "-RubSex": "F",
        "-RubShortUnit": "грн.",
        "-KopOneUnit": "копейка",
        "-KopTwoUnit": "копейки",
        "-KopFiveUnit": "копеек",
        "-KopSex": "F"
      },
      {
        "-CurrID": "980",
        "-CurrName": "Украинскі гривні",
        "-language": "UKR",
        "-RubOneUnit": "гривня",
        "-RubTwoUnit": "гривні",
        "-RubFiveUnit": "гривень",
        "-RubSex": "F",
        "-RubShortUnit": "грн.",
        "-KopOneUnit": "копійка",
        "-KopTwoUnit": "копійки",
        "-KopFiveUnit": "копійок",
        "-KopSex": "F"
      },
      {
        "-CurrID": "980",
        "-CurrName": "Украинскі гривні",
        "-language": "ENG",
        "-RubOneUnit": "hryvnia",
        "-RubTwoUnit": "hryvnias",
        "-RubFiveUnit": "hryvnias",
        "-RubSex": "M",
        "-RubShortUnit": "UAH.",
        "-KopOneUnit": "kopeck",
        "-KopTwoUnit": "kopecks",
        "-KopFiveUnit": "kopecks",
        "-KopSex": "M"
      }
    ],
    "USD": [
      {
        "-CurrID": "840",
        "-CurrName": "Долари США",
        "-language": "RUS",
        "-RubOneUnit": "доллар",
        "-RubTwoUnit": "доллара",
        "-RubFiveUnit": "долларов",
        "-RubSex": "M",
        "-RubShortUnit": "дол.",
        "-KopOneUnit": "цент",
        "-KopTwoUnit": "цента",
        "-KopFiveUnit": "центов",
        "-KopSex": "M"
      },
      {
        "-CurrID": "840",
        "-CurrName": "Долари США",
        "-language": "UKR",
        "-RubOneUnit": "долар",
        "-RubTwoUnit": "долара",
        "-RubFiveUnit": "доларів",
        "-RubSex": "M",
        "-RubShortUnit": "дол.",
        "-KopOneUnit": "цент",
        "-KopTwoUnit": "цента",
        "-KopFiveUnit": "центів",
        "-KopSex": "M"
      },
      {
        "-CurrID": "840",
        "-CurrName": "Долари США",
        "-language": "ENG",
        "-RubOneUnit": "dollar",
        "-RubTwoUnit": "dollars",
        "-RubFiveUnit": "dollars",
        "-RubSex": "M",
        "-RubShortUnit": "USD.",
        "-KopOneUnit": "cent",
        "-KopTwoUnit": "cents",
        "-KopFiveUnit": "cents",
        "-KopSex": "M"
      }
    ],
    "PER10": [
      {
        "-CurrID": "556",
        "-CurrName": "Вiдсотки з десятими частинами",
        "-language": "RUS",
        "-RubOneUnit": "целая,",
        "-RubTwoUnit": "целых,",
        "-RubFiveUnit": "целых,",
        "-RubSex": "F",
        "-KopOneUnit": "десятая процента",
        "-KopTwoUnit": "десятых процента",
        "-KopFiveUnit": "десятых процента",
        "-KopSex": "F"
      },
      {
        "-CurrID": "556",
        "-CurrName": "Вiдсотки з десятими частинами",
        "-language": "UKR",
        "-RubOneUnit": "ціла,",
        "-RubTwoUnit": "цілих,",
        "-RubFiveUnit": "цілих,",
        "-RubSex": "F",
        "-KopOneUnit": "десята відсотка",
        "-KopTwoUnit": "десятих відсотка",
        "-KopFiveUnit": "десятих відсотка",
        "-KopSex": "F"
      },
      {
        "-CurrID": "560",
        "-CurrName": "Вiдсотки з десятими частинами",
        "-language": "ENG",
        "-RubOneUnit": ",",
        "-RubTwoUnit": "integers,",
        "-RubFiveUnit": "integers,",
        "-RubSex": "F",
        "-KopOneUnit": "tenth of one percent",
        "-KopTwoUnit": "tenth of one percent",
        "-KopFiveUnit": "tenth of one percent",
        "-KopSex": "F"
      }
    ],
    "PER100": [
      {
        "-CurrID": "557",
        "-CurrName": "Вiдсотки з сотими частинами",
        "-language": "RUS",
        "-RubOneUnit": "целая,",
        "-RubTwoUnit": "целых,",
        "-RubFiveUnit": "целых,",
        "-RubSex": "F",
        "-KopOneUnit": "сотая процента",
        "-KopTwoUnit": "сотых процента",
        "-KopFiveUnit": "сотых процента",
        "-KopSex": "F"
      },
      {
        "-CurrID": "557",
        "-CurrName": "Вiдсотки з сотими частинами",
        "-language": "UKR",
        "-RubOneUnit": "ціла,",
        "-RubTwoUnit": "цілих,",
        "-RubFiveUnit": "цілих,",
        "-RubSex": "F",
        "-KopOneUnit": "сота відсотка",
        "-KopTwoUnit": "сотих відсотка",
        "-KopFiveUnit": "сотих відсотка",
        "-KopSex": "F"
      },
      {
        "-CurrID": "561",
        "-CurrName": "Вiдсотки з сотими частинами",
        "-language": "ENG",
        "-RubOneUnit": ",",
        "-RubTwoUnit": "integers,",
        "-RubFiveUnit": "integers,",
        "-RubSex": "F",
        "-KopOneUnit": "hundred percent",
        "-KopTwoUnit": "hundredth of percent",
        "-KopFiveUnit": "hundredth of percent",
        "-KopSex": "F"
      }
    ],
    "PER1000": [
      {
        "-CurrID": "558",
        "-CurrName": "Вiдсотки з тисячними частинами",
        "-language": "RUS",
        "-RubOneUnit": "целая,",
        "-RubTwoUnit": "целых,",
        "-RubFiveUnit": "целых,",
        "-RubSex": "F",
        "-KopOneUnit": "тысячная процента",
        "-KopTwoUnit": "тысячных процента",
        "-KopFiveUnit": "тысячных процента",
        "-KopSex": "F"
      },
      {
        "-CurrID": "558",
        "-CurrName": "Вiдсотки з тисячними частинами",
        "-language": "UKR",
        "-RubOneUnit": "ціла,",
        "-RubTwoUnit": "цілих,",
        "-RubFiveUnit": "цілих,",
        "-RubSex": "F",
        "-KopOneUnit": "тисячна відсотка",
        "-KopTwoUnit": "тисячних відсотка",
        "-KopFiveUnit": "тисячних відсотка",
        "-KopSex": "F"
      },
      {
        "-CurrID": "562",
        "-CurrName": "Вiдсотки з тисячними частинами",
        "-language": "ENG",
        "-RubOneUnit": ",",
        "-RubTwoUnit": "integers,",
        "-RubFiveUnit": "integers,",
        "-RubSex": "F",
        "-KopOneUnit": "thousandth of percent",
        "-KopTwoUnit": "thousandths of percent",
        "-KopFiveUnit": "thousandths of percent",
        "-KopSex": "F"
      }
    ],
    "PER10000": [
      {
        "-CurrID": "559",
        "-CurrName": "Вiдсотки з десяти тисячними частинами",
        "-language": "RUS",
        "-RubOneUnit": "целая,",
        "-RubTwoUnit": "целых,",
        "-RubFiveUnit": "целых,",
        "-RubSex": "F",
        "-KopOneUnit": "десятитысячная процента",
        "-KopTwoUnit": "десятитысячные процента",
        "-KopFiveUnit": "десятитысячных процента",
        "-KopSex": "F"
      },
      {
        "-CurrID": "559",
        "-CurrName": "Вiдсотки з десяти тисячними частинами",
        "-language": "UKR",
        "-RubOneUnit": "ціла,",
        "-RubTwoUnit": "цілих,",
        "-RubFiveUnit": "цілих,",
        "-RubSex": "F",
        "-KopOneUnit": "десятитисячна відсотка",
        "-KopTwoUnit": "десятитисячних відсотка",
        "-KopFiveUnit": "десятитисячних відсотка",
        "-KopSex": "M"
      },
      {
        "-CurrID": "563",
        "-CurrName": "Вiдсотки з десяти тисячними частинами",
        "-language": "ENG",
        "-RubOneUnit": ",",
        "-RubTwoUnit": "integers,",
        "-RubFiveUnit": "integers,",
        "-RubSex": "F",
        "-KopOneUnit": "ten percent",
        "-KopTwoUnit": "ten-percent",
        "-KopFiveUnit": "ten-percent",
        "-KopSex": "F"
      }
    ]
  }
};

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

    Currency currency;
    Language language;
    Pennies pennies;
    Map messages = new Map();
    String rubOneUnit;
    String rubTwoUnit;
    String rubFiveUnit;
    String kopOneUnit;
    String kopTwoUnit;
    String kopFiveUnit;
    String rubSex;
    String kopSex;

    MoneyToStr(Currency currency, Language language, Pennies pennies) {
        if (currency == null) {
            throw new Exception("Currency code is null");
        }
        if (language == null) {
            throw new Exception("Language is null");
        }
        if (pennies == null) {
            throw new Exception("Pennies is null");
        }
        this.currency = currency;
        this.language = language;
        this.pennies = pennies;
        Language languageElement = language;
        var currencyList = json;
        var items = currencyList["CurrencyList"][languageElement.toString()]["item"];
        for (var languageItem in items) {
            if (languageItem["-text"] != null) {
                messages[languageItem["-value"]] = languageItem["-text"].split(',');
            }
        }
        var currencyItem = currencyList["CurrencyList"][this.currency.toString()];
        var theISOElement = null;
        for (var item in currencyItem) {
            if (item["-language"] == this.language.toString()) {
                theISOElement = item;
                break;
            }
        }
        if (theISOElement == null) {
            throw new Exception("Currency not found " + this.currency.toString());
        }
        this.rubOneUnit = theISOElement["-RubOneUnit"];
        this.rubTwoUnit = theISOElement["-RubTwoUnit"];
        this.rubFiveUnit = theISOElement["-RubFiveUnit"];
        this.kopOneUnit = theISOElement["-KopOneUnit"];
        this.kopTwoUnit = theISOElement["-KopTwoUnit"];
        this.kopFiveUnit = theISOElement["-KopFiveUnit"];
        this.rubSex = theISOElement["-RubSex"];
        this.kopSex = theISOElement["-KopSex"];
    }

    /**
     * Converts percent to string.
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR)
     * @return the string of percent
     */
    static String percentToStr(double amount, Language lang) {
        if (lang == null) {
            throw new Exception("Language is null");
        }
        int intPart = amount.toInt();
        int fractPart = 0;
        String result = "";
        if (amount == amount.toInt()) {
            result = new MoneyToStr(Currency.PER10, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else if ((amount * NUM10).toStringAsFixed(4) == (amount * NUM10).toInt().toStringAsFixed(4)) {
            fractPart = ((amount - intPart) * NUM10).round().toInt();
            result = new MoneyToStr(Currency.PER10, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else if ((amount * NUM100).toStringAsFixed(4) == (amount * NUM100).toInt().toStringAsFixed(4)) {
            fractPart = ((amount - intPart) * NUM100).round().toInt();
            result = new MoneyToStr(Currency.PER100, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else if ((amount * NUM1000).toStringAsFixed(4) == (amount * NUM1000).toInt().toStringAsFixed(4)) {
            fractPart = ((amount - intPart) * NUM1000).round().toInt();
            result = new MoneyToStr(Currency.PER1000, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else {
            fractPart = ((amount - intPart) * NUM10000).round().toInt();
            result = new MoneyToStr(Currency.PER10000, lang, Pennies.TEXT).convert(intPart, fractPart);
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
    String convertValue(double theMoney) {
        int intPart = theMoney.toInt();
        int fractPart = ((theMoney - intPart) * NUM100).round().toInt();
        if (currency == Currency.PER1000) {
            fractPart = ((theMoney - intPart) * NUM1000).round().toInt();
        }
        return convert(intPart, fractPart);
    }

    /**
     * Converts number to currency. Usage: MoneyToStr moneyToStr = new MoneyToStr("UAH", "UKR", "NUMBER"); String result =
     * moneyToStr.convertValue(123D); Expected: result = сто двадцять три гривні 00 копійок
     *
     * @param theMoney
     *            the amount of money major currency
     * @param theKopeiki
     *            the amount of money minor currency
     * @return the string description of money value
     */
    String convert(int theMoney, int theKopeiki) {
        StringBuilder money2str = new StringBuilder();
        int triadNum = 0;
        int theTriad;

        int intPart = theMoney.toInt();
        if (intPart == 0) {
            money2str.append(messages["0"][0] + " ");
        }
        do {
            theTriad = intPart % NUM1000;
            money2str.insert(0, triad2Word(theTriad, triadNum, rubSex));
            if (triadNum == 0) {
                int range10 = ((theTriad % NUM100) / NUM10).toInt();
                int range = (theTriad % NUM10).toInt();
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
            intPart = (intPart / NUM1000).toInt();
            triadNum += 1;
        } while (intPart > 0);

        if (pennies == Pennies.TEXT) {
            money2str.append(language == Language.ENG ? " and " : " ").append(theKopeiki == 0 ? (messages["0"][0] + " ") : triad2Word(theKopeiki, 0, kopSex));
        } else {
            money2str.append(" " + (theKopeiki < 10 ? "0" + theKopeiki.toString() : theKopeiki.toString()) + " ");
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
        return money2str.toString().trim();
    }

    String triad2Word(int triad, int triadNum, String sex) {
        StringBuilder triadWord = new StringBuilder();

        if (triad == 0) {
            return "";
        }

        int range = check1(triad, triadWord);
        if (language == Language.ENG && triadWord.length() > 0 && triad % NUM10 == 0) {
            triadWord.deleteCharAt(triadWord.length() - 1);
            triadWord.append(" ");
        }

        int range10 = range;
        range = triad % NUM10;
        check2(triadNum, sex, triadWord, triad, range10);
        switch (triadNum) {
        case NUM0:
            break;
        case NUM1: case NUM2: case NUM3: case NUM4:
            if (range10 == NUM1) {
                triadWord.append(messages["1000_10"][triadNum - 1] + " ");
            } else {
                switch (range) {
                case NUM1:
                    triadWord.append(messages["1000_1"][triadNum - 1] + " ");
                    break;
                case NUM2: case NUM3: case NUM4:
                    triadWord.append(messages["1000_234"][triadNum - 1] + " ");
                    break;
                default:
                    triadWord.append(messages["1000_5"][triadNum - 1] + " ");
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
    void check2(int triadNum, String sex, StringBuilder triadWord, int triad, int range10) {
        int range = triad % NUM10;
        if (range10 == 1) {
            triadWord.append(messages["10_19"][range] + " ");
        } else {
            switch (range) {
            case NUM1:
                if (triadNum == NUM1) {
                    triadWord.append(messages["1"][INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.append(messages["1"][INDEX_1] + " ");
                } else if ("M" == sex) {
                    triadWord.append(messages["1"][INDEX_2] + " ");
                } else if ("F" == sex) {
                    triadWord.append(messages["1"][INDEX_3] + " ");
                }
                break;
            case NUM2:
                if (triadNum == NUM1) {
                    triadWord.append(messages["2"][INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.append(messages["2"][INDEX_1] + " ");
                } else if ("M" == sex) {
                    triadWord.append(messages["2"][INDEX_2] + " ");
                } else if ("F" == sex) {
                    triadWord.append(messages["2"][INDEX_3] + " ");
                }
                break;
            case NUM3: case NUM4: case NUM5: case NUM6: case NUM7: case NUM8: case NUM9:
                triadWord.append(concat(["", "", ""], messages["3_9"])[range] + " ");
                break;
            }
        }
    }

    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
    int check1(int triad, StringBuilder triadWord) {
        int range = (triad / NUM100).toInt();
        triadWord.append(concat([""], messages["100_900"])[range]);

        range = ((triad % NUM100) / NUM10).toInt();
        triadWord.append(concat(["", ""], messages["20_90"])[range]);
        return range;
    }

    List<String> concat(List<String> first, List<String> second) {
        List<String> result = [];
        result.addAll(first);
        result.addAll(second);
        return result;
    }

}
