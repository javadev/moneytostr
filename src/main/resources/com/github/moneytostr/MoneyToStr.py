'''
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
'''

import math
'''
 * Converts numbers to words.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
'''
class MoneyToStr:
    class StringBuilder:
        _buffer = []
    
        def __init__(self):
            self._buffer = []
    
        def append(self, text):
            self._buffer.append(text)
            return self
    
        def insert(self, index, text):
            self._buffer.insert(index, text)
            return self
    
        def length(self):
            return self.toString().__len__()
    
        def deleteCharAt(self, index):
            str = self.toString()
            self._buffer = []
            self.append(str[:index])
            return self
    
        def toString(self):
            return "".join(self._buffer)


    currencyList = {
  "CurrencyList" : {
    "language" : { "-value" : "UKR" },
    "UKR" : {
      "item" : [
        {
          "-value" : "0",
          "-text" : "нуль"
        },
        {
          "-value" : "1000_10",
          "-text" : "тисяч,мільйонів,мільярдів,трильйонів"
        },
        {
          "-value" : "1000_1",
          "-text" : "тисяча,мільйон,мільярд,трильйон"
        },
        {
          "-value" : "1000_234",
          "-text" : "тисячі,мільйона,мільярда,трильйона"
        },
        {
          "-value" : "1000_5",
          "-text" : "тисяч,мільйонів,мільярдів,трильйонів"
        },
        {
          "-value" : "10_19",
          "-text" : "десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п’ятнадцять,шiстнадцять,сiмнадцять,вiсiмнадцять,дев'ятнадцять"
        },
        {
          "-value" : "1",
          "-text" : "одна,один,один,одна"
        },
        {
          "-value" : "2",
          "-text" : "дві,два,два,дві"
        },
        {
          "-value" : "3_9",
          "-text" : "три,чотири,п’ять,шість,сім,вісім,дев’ять"
        },
        {
          "-value" : "100_900",
          "-text" : "сто ,двісті ,триста ,чотириста ,п’ятсот ,шістсот ,сімсот ,вісімсот ,дев’ятсот "
        },
        {
          "-value" : "20_90",
          "-text" : "двадцять ,тридцять ,сорок ,п’ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев’яносто "
        }
      ]
    },
    "RUS" : {
      "item" : [
        {
          "-value" : "0",
          "-text" : "ноль"
        },
        {
          "-value" : "1000_10",
          "-text" : "тысяч,миллионов,миллиардов,триллионов"
        },
        {
          "-value" : "1000_1",
          "-text" : "тысяча,миллион,миллиард,триллион"
        },
        {
          "-value" : "1000_234",
          "-text" : "тысячи,миллиона,миллиарда,триллиона"
        },
        {
          "-value" : "1000_5",
          "-text" : "тысяч,миллионов,миллиардов,триллионов"
        },
        {
          "-value" : "10_19",
          "-text" : "десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать"
        },
        {
          "-value" : "1",
          "-text" : "одна,один,один,одна"
        },
        {
          "-value" : "2",
          "-text" : "две,два,два,две"
        },
        {
          "-value" : "3_9",
          "-text" : "три,четыре,пять,шесть,семь,восемь,девять"
        },
        {
          "-value" : "100_900",
          "-text" : "сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот "
        },
        {
          "-value" : "20_90",
          "-text" : "двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто "
        }
      ]
    },
    "ENG" : {
      "item" : [
        {
          "-value" : "0",
          "-text" : "zero"
        },
        {
          "-value" : "1000_10",
          "-text" : "thousand,million,billion,trillion"
        },
        {
          "-value" : "1000_1",
          "-text" : "thousand,million,billion,trillion"
        },
        {
          "-value" : "1000_234",
          "-text" : "thousand,million,billion,trillion"
        },
        {
          "-value" : "1000_5",
          "-text" : "thousand,million,billion,trillion"
        },
        {
          "-value" : "10_19",
          "-text" : "ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen"
        },
        {
          "-value" : "1",
          "-text" : "one,one,one,one"
        },
        {
          "-value" : "2",
          "-text" : "two,two,two,two"
        },
        {
          "-value" : "3_9",
          "-text" : "three,four,five,six,seven,eight,nine"
        },
        {
          "-value" : "100_900",
          "-text" : "one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred "
        },
        {
          "-value" : "20_90",
          "-text" : "twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-"
        }
      ]
    },
    "RUR" : [
      {
        "-CurrID" : "810",
        "-CurrName" : "Российские рубли",
        "-language" : "RUS",
        "-RubOneUnit" : "рубль",
        "-RubTwoUnit" : "рубля",
        "-RubFiveUnit" : "рублей",
        "-RubSex" : "M",
        "-KopOneUnit" : "копейка",
        "-KopTwoUnit" : "копейки",
        "-KopFiveUnit" : "копеек",
        "-KopSex" : "F"
      },
      {
        "-CurrID" : "810",
        "-CurrName" : "Российские рубли",
        "-language" : "UKR",
        "-RubOneUnit" : "рубль",
        "-RubTwoUnit" : "рубля",
        "-RubFiveUnit" : "рублів",
        "-RubSex" : "M",
        "-KopOneUnit" : "копійка",
        "-KopTwoUnit" : "копійки",
        "-KopFiveUnit" : "копійок",
        "-KopSex" : "F"
      }
    ],
    "UAH" : [
      {
        "-CurrID" : "980",
        "-CurrName" : "Украинскі гривні",
        "-language" : "RUS",
        "-RubOneUnit" : "гривня",
        "-RubTwoUnit" : "гривни",
        "-RubFiveUnit" : "гривень",
        "-RubSex" : "F",
        "-KopOneUnit" : "копейка",
        "-KopTwoUnit" : "копейки",
        "-KopFiveUnit" : "копеек",
        "-KopSex" : "F"
      },
      {
        "-CurrID" : "980",
        "-CurrName" : "Украинскі гривні",
        "-language" : "UKR",
        "-RubOneUnit" : "гривня",
        "-RubTwoUnit" : "гривні",
        "-RubFiveUnit" : "гривень",
        "-RubSex" : "F",
        "-KopOneUnit" : "копійка",
        "-KopTwoUnit" : "копійки",
        "-KopFiveUnit" : "копійок",
        "-KopSex" : "F"
      }
    ],
    "USD" : [
      {
        "-CurrID" : "840",
        "-CurrName" : "Долари США",
        "-language" : "RUS",
        "-RubOneUnit" : "долар",
        "-RubTwoUnit" : "долара",
        "-RubFiveUnit" : "доларів",
        "-RubSex" : "M",
        "-KopOneUnit" : "цент",
        "-KopTwoUnit" : "цента",
        "-KopFiveUnit" : "центов",
        "-KopSex" : "M"
      },
      {
        "-CurrID" : "840",
        "-CurrName" : "Долари США",
        "-language" : "UKR",
        "-RubOneUnit" : "долар",
        "-RubTwoUnit" : "долара",
        "-RubFiveUnit" : "доларів",
        "-RubSex" : "M",
        "-KopOneUnit" : "цент",
        "-KopTwoUnit" : "цента",
        "-KopFiveUnit" : "центів",
        "-KopSex" : "M"
      },
      {
        "-CurrID" : "840",
        "-CurrName" : "Долари США",
        "-language" : "ENG",
        "-RubOneUnit" : "dollar",
        "-RubTwoUnit" : "dollars",
        "-RubFiveUnit" : "dollars",
        "-RubSex" : "M",
        "-KopOneUnit" : "cent",
        "-KopTwoUnit" : "cents",
        "-KopFiveUnit" : "cents",
        "-KopSex" : "M"
      }
     ],
    "PER10" : [
      {
        "-CurrID" : "556",
        "-CurrName" : "Вiдсотки з десятими частинами",
        "-language" : "RUS",
        "-RubOneUnit" : "целая,",
        "-RubTwoUnit" : "целых,",
        "-RubFiveUnit" : "целых,",
        "-RubSex" : "F",
        "-KopOneUnit" : "десятая процента",
        "-KopTwoUnit" : "десятых процента",
        "-KopFiveUnit" : "десятых процента",
        "-KopSex" : "F"
      },
      {
        "-CurrID" : "556",
        "-CurrName" : "Вiдсотки з десятими частинами",
        "-language" : "UKR",
        "-RubOneUnit" : "ціла,",
        "-RubTwoUnit" : "цілих,",
        "-RubFiveUnit" : "цілих,",
        "-RubSex" : "F",
        "-KopOneUnit" : "десята відсотка",
        "-KopTwoUnit" : "десятих відсотка",
        "-KopFiveUnit" : "десятих відсотка",
        "-KopSex" : "F"
      }
    ],
    "PER100" : [
      {
        "-CurrID" : "557",
        "-CurrName" : "Вiдсотки з сотими частинами",
        "-language" : "RUS",
        "-RubOneUnit" : "целая,",
        "-RubTwoUnit" : "целых,",
        "-RubFiveUnit" : "целых,",
        "-RubSex" : "F",
        "-KopOneUnit" : "сотая процента",
        "-KopTwoUnit" : "сотых процента",
        "-KopFiveUnit" : "сотых процента",
        "-KopSex" : "F"
      },
      {
        "-CurrID" : "557",
        "-CurrName" : "Вiдсотки з сотими частинами",
        "-language" : "UKR",
        "-RubOneUnit" : "ціла,",
        "-RubTwoUnit" : "цілих,",
        "-RubFiveUnit" : "цілих,",
        "-RubSex" : "F",
        "-KopOneUnit" : "сота відсотка",
        "-KopTwoUnit" : "сотих відсотка",
        "-KopFiveUnit" : "сотих відсотка",
        "-KopSex" : "F"
      }
    ],
    "PER1000" : [
      {
        "-CurrID" : "558",
        "-CurrName" : "Вiдсотки з тисячними частинами",
        "-language" : "RUS",
        "-RubOneUnit" : "целая,",
        "-RubTwoUnit" : "целых,",
        "-RubFiveUnit" : "целых,",
        "-RubSex" : "F",
        "-KopOneUnit" : "тысячная процента",
        "-KopTwoUnit" : "тысячных процента",
        "-KopFiveUnit" : "тысячных процента",
        "-KopSex" : "F"
      },
      {
        "-CurrID" : "558",
        "-CurrName" : "Вiдсотки з тисячними частинами",
        "-language" : "UKR",
        "-RubOneUnit" : "ціла,",
        "-RubTwoUnit" : "цілих,",
        "-RubFiveUnit" : "цілих,",
        "-RubSex" : "F",
        "-KopOneUnit" : "тисячна відсотка",
        "-KopTwoUnit" : "тисячних відсотка",
        "-KopFiveUnit" : "тисячних відсотка",
        "-KopSex" : "F"
      }
    ],
    "PER10000" : [
      {
        "-CurrID" : "559",
        "-CurrName" : "Вiдсотки з десяти тисячними частинами",
        "-language" : "RUS",
        "-RubOneUnit" : "целая,",
        "-RubTwoUnit" : "целых,",
        "-RubFiveUnit" : "целых,",
        "-RubSex" : "F",
        "-KopOneUnit" : "десятитысячная процента",
        "-KopTwoUnit" : "десятитысячные процента",
        "-KopFiveUnit" : "десятитысячных процента",
        "-KopSex" : "F"
      },
      {
        "-CurrID" : "559",
        "-CurrName" : "Вiдсотки з десяти тисячними частинами",
        "-language" : "UKR",
        "-RubOneUnit" : "ціла,",
        "-RubTwoUnit" : "цілих,",
        "-RubFiveUnit" : "цілих,",
        "-RubSex" : "F",
        "-KopOneUnit" : "десятитисячна відсотка",
        "-KopTwoUnit" : "десятитисячних відсотка",
        "-KopFiveUnit" : "десятитисячних відсотка",
        "-KopSex" : "M"
      }
    ]
  }
    }
    NUM0 = 0
    NUM1 = 1
    NUM2 = 2
    NUM3 = 3
    NUM4 = 4
    NUM5 = 5
    NUM6 = 6
    NUM7 = 7
    NUM8 = 8
    NUM9 = 9
    NUM10 = 10
    NUM11 = 11
    NUM14 = 14
    NUM100 = 100
    NUM1000 = 1000
    NUM10000 = 10000
    INDEX_0 = 0
    INDEX_1 = 1
    INDEX_2 = 2
    INDEX_3 = 3

    @staticmethod
    def percentToStr(amount, lang):
        if amount is None:
            raise Exception("amount is null")
        if lang is None:
            raise Exception("Language is null")
        intPart = int(amount);
        fractPart = 0
        result = ""
        if amount == int(amount):
            result = MoneyToStr("PER10", lang, "TEXT").convert(amount, 0);
        elif (round(amount * MoneyToStr.NUM10, 4) == int(amount * MoneyToStr.NUM10)):
            fractPart = round((amount - intPart) * MoneyToStr.NUM10)
            result = MoneyToStr("PER10", lang, "TEXT").convert(intPart, fractPart)
        elif (round(amount * MoneyToStr.NUM100, 4) == int(amount * MoneyToStr.NUM100)):
            fractPart = round((amount - intPart) * MoneyToStr.NUM100)
            result = MoneyToStr("PER100", lang, "TEXT").convert(intPart, fractPart)
        elif (round(amount * MoneyToStr.NUM1000, 4) == int(amount * MoneyToStr.NUM1000)):
            fractPart = ((amount - intPart) * MoneyToStr.NUM1000).round
            result = MoneyToStr("PER1000", lang, "TEXT").convert(intPart, fractPart)
        else:
            fractPart = round((amount - intPart) * MoneyToStr.NUM10000)
            result = MoneyToStr("PER10000", lang, "TEXT").convert(intPart, fractPart)
        return result

    def __init__(self, currency, language, pennies):
        if currency is None:
            raise Exception("Currency is null")
        if language is None:
            raise Exception("Language is null")
        if pennies is None:
            raise Exception("Pennies is null")
        self.currency = currency
        self.language = language
        self.pennies = pennies
        languageElement = language;
        items = self.currencyList["CurrencyList"][languageElement]["item"];
        self.messages = {}
        for languageItem in items:
            if languageItem["-text"] is not None:
                self.messages[languageItem["-value"]] = languageItem["-text"].split(',')
        currencyItem = self.currencyList["CurrencyList"][self.currency]
        theISOElement = None
        for item in currencyItem:
            if item["-language"] == self.language:
                theISOElement = item
                break
        if theISOElement is None:
            raise Exception("Currency not found " + self.currency)
        self.rubOneUnit = theISOElement["-RubOneUnit"]
        self.rubTwoUnit = theISOElement["-RubTwoUnit"]
        self.rubFiveUnit = theISOElement["-RubFiveUnit"]
        self.kopOneUnit = theISOElement["-KopOneUnit"]
        self.kopTwoUnit = theISOElement["-KopTwoUnit"]
        self.kopFiveUnit = theISOElement["-KopFiveUnit"]
        self.rubSex = theISOElement["-RubSex"]
        self.kopSex = theISOElement["-KopSex"]

    '''
     * Converts double value to the text description.
     *
     * @param theMoney
     *            the amount of money in format major.minor
     * @return the string description of money value
    '''
    def convertValue(self, theMoney):
        intPart = int(theMoney)
        fractPart = int(round(((theMoney - intPart) * self.NUM100)))
        if self.currency == "PER1000":
            fractPart = int(round(((theMoney - intPart) * self.NUM1000)))
        return self.convert(intPart, fractPart)

    '''
     * Converts number to currency. Usage: MoneyToStr moneyToStr = new MoneyToStr("UAH", "UKR", "NUMBER"); String result =
     * moneyToStr.convertValue(123D); Expected: result = сто двадцять три гривні 00 копійок
     *
     * @param theMoney
     *            the amount of money major currency
     * @param theKopeiki
     *            the amount of money minor currency
     * @return the string description of money value
    '''
    def convert(self, theMoney, theKopeiki):
        money2str = MoneyToStr.StringBuilder()
        triadNum = 0

        intPart = int(theMoney)
        if intPart == 0:
            money2str.append(messages["0"][0] + " ")
        while True:
            theTriad = intPart % self.NUM1000
            money2str.insert(0, self.triad2Word(theTriad, triadNum, self.rubSex))
            if triadNum == 0:
                range10 = int((theTriad % self.NUM100) / self.NUM10)
                range = int(theTriad % self.NUM10)
                if range10 == self.NUM1:
                    money2str.append(self.rubFiveUnit);
                else:
                    if range == self.NUM1:
                        money2str.append(self.rubOneUnit)
                    elif range == self.NUM2 or range == self.NUM3 or range == self.NUM4:
                        money2str.append(self.rubTwoUnit)
                    else:
                        money2str.append(self.rubFiveUnit)
            intPart = int(intPart / self.NUM1000);
            triadNum += 1;
            if intPart <= 0:
                break

        if self.pennies == "TEXT":
            param1 = " "
            if self.language == "ENG":
                param1 = " and "
            param2 = self.triad2Word(theKopeiki, 0, self.kopSex)
            if int(theKopeiki) == 0:
                param2 = self.messages["0"][0] + " "
            money2str.append(param1).append(param2)
        else:
            param = str(theKopeiki)
            if theKopeiki < 10:
                param = "0" + str(theKopeiki)
            money2str.append(" " + param + " ");
        if theKopeiki >= self.NUM11 and theKopeiki <= self.NUM14:
            money2str.append(self.kopFiveUnit);
        else:
            if theKopeiki % self.NUM10 == self.NUM1:
                money2str.append(self.kopOneUnit);
            elif theKopeiki % self.NUM10 == self.NUM2 or theKopeiki % self.NUM10 == self.NUM3 or theKopeiki % self.NUM10 == self.NUM4:
                money2str.append(self.kopTwoUnit)
            else:
                money2str.append(self.kopFiveUnit)
        return money2str.toString().strip();

    def triad2Word(self, triad, triadNum, sex):
        triadWord = MoneyToStr.StringBuilder();

        if triad == 0:
            return ""

        range = self.check1(triad, triadWord);
        if self.language == "ENG" and triadWord.length() > 0 and triad % self.NUM10 == 0:
            triadWord.deleteCharAt(triadWord.length() - 1)
            triadWord.append(" ")

        range10 = range
        range = triad % self.NUM10
        self.check2(triadNum, sex, triadWord, triad, range10);
        if int(triadNum) == self.NUM0:
            triadWord.append("")
        elif triadNum == self.NUM1 or triadNum == self.NUM2 or triadNum == self.NUM3 or triadNum == self.NUM4:
            if range10 == self.NUM1:
                triadWord.append(self.messages["1000_10"][triadNum - 1] + " ");
            else:
                if range ==self. NUM1:
                    triadWord.append(self.messages["1000_1"][triadNum - 1] + " ")
                elif range == self.NUM2 or range == self.NUM3 or range == self.NUM4:
                    triadWord.append(self.messages["1000_234"][triadNum - 1] + " ")
                else:
                    triadWord.append(self.messages["1000_5"][triadNum - 1] + " ")
        else:
            triadWord.append("??? ")
        return triadWord.toString()

    '''
     * @param triadNum the triad num
     * @param sex the sex
     * @param triadWord the triad word
     * @param triad the triad
     * @param range10 the range 10
    '''
    def check2(self, triadNum, sex, triadWord, triad, range10):
        range = int(triad % self.NUM10)
        if range10 == 1:
            triadWord.append(self.messages["10_19"][range] + " ");
        else:
            if range == self.NUM1:
                if triadNum == self.NUM1:
                    triadWord.append(self.messages["1"][self.INDEX_0] + " ")
                elif triadNum == self.NUM2 or triadNum == self.NUM3 or triadNum == self.NUM4:
                    triadWord.append(self.messages["1"][self.INDEX_1] + " ")
                elif "M" == sex:
                    triadWord.append(self.messages["1"][self.INDEX_2] + " ")
                elif "F" == sex:
                    triadWord.append(self.messages["1"][self.INDEX_3] + " ")
            elif range == self.NUM2:
                if triadNum == self.NUM1:
                    triadWord.append(self.messages["2"][self.INDEX_0] + " ")
                elif triadNum == self.NUM2 or triadNum == self.NUM3 or triadNum == self.NUM4:
                    triadWord.append(self.messages["2"][self.INDEX_1] + " ")
                elif "M" == sex:
                    triadWord.append(self.messages["2"][self.INDEX_2] + " ")
                elif "F" == sex:
                    triadWord.append(self.messages["2"][self.INDEX_3] + " ")
            elif range == self.NUM3 or range == self.NUM4 or range == self.NUM5 or range == self.NUM6 or range == self.NUM7 or range == self.NUM8 or range == self.NUM9:
                triadWord.append(self.concat(["", "", ""], self.messages["3_9"])[range] + " ");

    '''
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
    '''
    def check1(self, triad, triadWord):
        range = int(triad / self.NUM100)
        triadWord.append(self.concat([""], self.messages["100_900"])[range])

        range = int((triad % self.NUM100) / self.NUM10);
        triadWord.append(self.concat(["", ""], self.messages["20_90"])[range]);
        return range;

    def concat(self, first, second):
        result = []
        result.extend(first)
        result.extend(second)
        return result
