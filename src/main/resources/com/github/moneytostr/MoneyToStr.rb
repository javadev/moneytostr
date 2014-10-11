=begin
/*
 * $Id$
 *
 * Copyright 2012 Valentyn Kolesnikov
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
=end

=begin
/**
 * Converts numbers to symbols.
 *
 * @author Valentyn V Kolesnikov
 * @version $Revision$ $Date$
 */
=end
class MoneyToStr
@@currencyList =
{
  "CurrencyList" => {
    "language" => { "-value" => "UKR" },
    "UKR" => {
      "item" => [
        {
          "-value" => "0",
          "-text" => "нуль"
        },
        {
          "-value" => "1000_10",
          "-text" => "тисяч,мільйонів,мільярдів,трильйонів"
        },
        {
          "-value" => "1000_1",
          "-text" => "тисяча,мільйон,мільярд,трильйон"
        },
        {
          "-value" => "1000_234",
          "-text" => "тисячі,мільйона,мільярда,трильйона"
        },
        {
          "-value" => "1000_5",
          "-text" => "тисяч,мільйонів,мільярдів,трильйонів"
        },
        {
          "-value" => "10_19",
          "-text" => "десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п’ятнадцять,шiстнадцять,сiмнадцять,вiсiмнадцять,дев'ятнадцять"
        },
        {
          "-value" => "1",
          "-text" => "одна,один,один,одна"
        },
        {
          "-value" => "2",
          "-text" => "дві,два,два,дві"
        },
        {
          "-value" => "3_9",
          "-text" => "три,чотири,п’ять,шість,сім,вісім,дев’ять"
        },
        {
          "-value" => "100_900",
          "-text" => "сто ,двісті ,триста ,чотириста ,п’ятсот ,шістсот ,сімсот ,вісімсот ,дев’ятсот "
        },
        {
          "-value" => "20_90",
          "-text" => "двадцять ,тридцять ,сорок ,п’ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев’яносто "
        }
      ]
    },
    "RUS" => {
      "item" => [
        {
          "-value" => "0",
          "-text" => "ноль"
        },
        {
          "-value" => "1000_10",
          "-text" => "тысяч,миллионов,миллиардов,триллионов"
        },
        {
          "-value" => "1000_1",
          "-text" => "тысяча,миллион,миллиард,триллион"
        },
        {
          "-value" => "1000_234",
          "-text" => "тысячи,миллиона,миллиарда,триллиона"
        },
        {
          "-value" => "1000_5",
          "-text" => "тысяч,миллионов,миллиардов,триллионов"
        },
        {
          "-value" => "10_19",
          "-text" => "десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать"
        },
        {
          "-value" => "1",
          "-text" => "одна,один,один,одна"
        },
        {
          "-value" => "2",
          "-text" => "две,два,два,две"
        },
        {
          "-value" => "3_9",
          "-text" => "три,четыре,пять,шесть,семь,восемь,девять"
        },
        {
          "-value" => "100_900",
          "-text" => "сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот "
        },
        {
          "-value" => "20_90",
          "-text" => "двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто "
        }
      ]
    },
    "ENG" => {
      "item" => [
        {
          "-value" => "0",
          "-text" => "zero"
        },
        {
          "-value" => "1000_10",
          "-text" => "thousand,million,billion,trillion"
        },
        {
          "-value" => "1000_1",
          "-text" => "thousand,million,billion,trillion"
        },
        {
          "-value" => "1000_234",
          "-text" => "thousand,million,billion,trillion"
        },
        {
          "-value" => "1000_5",
          "-text" => "thousand,million,billion,trillion"
        },
        {
          "-value" => "10_19",
          "-text" => "ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen"
        },
        {
          "-value" => "1",
          "-text" => "one,one,one,one"
        },
        {
          "-value" => "2",
          "-text" => "two,two,two,two"
        },
        {
          "-value" => "3_9",
          "-text" => "three,four,five,six,seven,eight,nine"
        },
        {
          "-value" => "100_900",
          "-text" => "one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred "
        },
        {
          "-value" => "20_90",
          "-text" => "twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-"
        }
      ]
    },
    "RUR" => [
      {
        "-CurrID" => "810",
        "-CurrName" => "Российские рубли",
        "-language" => "RUS",
        "-RubOneUnit" => "рубль",
        "-RubTwoUnit" => "рубля",
        "-RubFiveUnit" => "рублей",
        "-RubSex" => "M",
        "-KopOneUnit" => "копейка",
        "-KopTwoUnit" => "копейки",
        "-KopFiveUnit" => "копеек",
        "-KopSex" => "F"
      },
      {
        "-CurrID" => "810",
        "-CurrName" => "Российские рубли",
        "-language" => "UKR",
        "-RubOneUnit" => "рубль",
        "-RubTwoUnit" => "рубля",
        "-RubFiveUnit" => "рублей",
        "-RubSex" => "M",
        "-KopOneUnit" => "копейка",
        "-KopTwoUnit" => "копейки",
        "-KopFiveUnit" => "копеек",
        "-KopSex" => "F"
      }
    ],
    "UAH" => [
      {
        "-CurrID" => "980",
        "-CurrName" => "Украинскі гривні",
        "-language" => "RUS",
        "-RubOneUnit" => "гривня",
        "-RubTwoUnit" => "гривни",
        "-RubFiveUnit" => "гривень",
        "-RubSex" => "F",
        "-KopOneUnit" => "копейка",
        "-KopTwoUnit" => "копейки",
        "-KopFiveUnit" => "копеек",
        "-KopSex" => "F"
      },
      {
        "-CurrID" => "980",
        "-CurrName" => "Украинскі гривні",
        "-language" => "UKR",
        "-RubOneUnit" => "гривня",
        "-RubTwoUnit" => "гривні",
        "-RubFiveUnit" => "гривень",
        "-RubSex" => "F",
        "-KopOneUnit" => "копійка",
        "-KopTwoUnit" => "копійки",
        "-KopFiveUnit" => "копійок",
        "-KopSex" => "F"
      }
    ],
    "USD" => [
      {
        "-CurrID" => "840",
        "-CurrName" => "Долари США",
        "-language" => "RUS",
        "-RubOneUnit" => "долар",
        "-RubTwoUnit" => "долара",
        "-RubFiveUnit" => "доларів",
        "-RubSex" => "M",
        "-KopOneUnit" => "цент",
        "-KopTwoUnit" => "цента",
        "-KopFiveUnit" => "центов",
        "-KopSex" => "M"
      },
      {
        "-CurrID" => "840",
        "-CurrName" => "Долари США",
        "-language" => "UKR",
        "-RubOneUnit" => "долар",
        "-RubTwoUnit" => "долара",
        "-RubFiveUnit" => "доларів",
        "-RubSex" => "M",
        "-KopOneUnit" => "цент",
        "-KopTwoUnit" => "цента",
        "-KopFiveUnit" => "центів",
        "-KopSex" => "M"
      },
      {
        "-CurrID" => "840",
        "-CurrName" => "Долари США",
        "-language" => "ENG",
        "-RubOneUnit" => "dollar",
        "-RubTwoUnit" => "dollars",
        "-RubFiveUnit" => "dollars",
        "-RubSex" => "M",
        "-KopOneUnit" => "cent",
        "-KopTwoUnit" => "cents",
        "-KopFiveUnit" => "cents",
        "-KopSex" => "M"
      }
     ],
    "PER10" => [
      {
        "-CurrID" => "556",
        "-CurrName" => "Вiдсотки з десятими частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десятая процента",
        "-KopTwoUnit" => "десятых процента",
        "-KopFiveUnit" => "десятых процента",
        "-KopSex" => "F"
      },
      {
        "-CurrID" => "556",
        "-CurrName" => "Вiдсотки з десятими частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десята відсотка",
        "-KopTwoUnit" => "десятих відсотка",
        "-KopFiveUnit" => "десятих відсотка",
        "-KopSex" => "F"
      }
    ],
    "PER100" => [
      {
        "-CurrID" => "557",
        "-CurrName" => "Вiдсотки з сотими частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "сотая процента",
        "-KopTwoUnit" => "сотых процента",
        "-KopFiveUnit" => "сотых процента",
        "-KopSex" => "F"
      },
      {
        "-CurrID" => "557",
        "-CurrName" => "Вiдсотки з сотими частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "сота відсотка",
        "-KopTwoUnit" => "сотих відсотка",
        "-KopFiveUnit" => "сотих відсотка",
        "-KopSex" => "F"
      }
    ],
    "PER1000" => [
      {
        "-CurrID" => "558",
        "-CurrName" => "Вiдсотки з тисячними частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "тысячная процента",
        "-KopTwoUnit" => "тысячных процента",
        "-KopFiveUnit" => "тысячных процента",
        "-KopSex" => "F"
      },
      {
        "-CurrID" => "558",
        "-CurrName" => "Вiдсотки з тисячними частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "тисячна відсотка",
        "-KopTwoUnit" => "тисячних відсотка",
        "-KopFiveUnit" => "тисячних відсотка",
        "-KopSex" => "F"
      }
    ],
    "PER10000" => [
      {
        "-CurrID" => "559",
        "-CurrName" => "Вiдсотки з десяти тисячними частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десятитысячная процента",
        "-KopTwoUnit" => "десятитысячные процента",
        "-KopFiveUnit" => "десятитысячных процента",
        "-KopSex" => "F"
      },
      {
        "-CurrID" => "559",
        "-CurrName" => "Вiдсотки з десяти тисячними частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десятитисячна відсотка",
        "-KopTwoUnit" => "десятитисячних відсотка",
        "-KopFiveUnit" => "десятитисячних відсотка",
        "-KopSex" => "M"
      }
    ]
  }
}
    #/** Currency. */
class Currency
        #/**.*/
        UAH = :UAH
        #/**.*/
        RUR = :RUR
        #/**.*/
        USD = :USD
        #/**.*/
        PER10 = :PER10
        #/**.*/
        PER100 = :PER100
        #/**.*/
        PER1000 = :PER1000
        #/**.*/
        PER10000 = :PER10000
end

    #/** Language. */
class Language
        #/**.*/
        RUS = :RUS
        #/**.*/
        UKR = :UKR
        #/**.*/
        ENG = :ENG
end

    #/** Pennies. */
class Pennies
        #/**.*/
        NUMBER = :NUMBER
        #/**.*/
        TEXT = :TEXT
end

class StringBuilder
    def initialize()
        @buffer = [];
    end

    def append(text)
            @buffer[@buffer.length] = text;
            return self;
    end
        
    def insert(index, text)
            @buffer.insert(index, text);
            return self;
    end

    def length()
            return toString().length;
    end

    def deleteCharAt(index)
            str = toString();
            initialize();
            append(str[0, index]); 
            return self;
    end

    def toString()
            return @buffer.join("");
    end
end

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

    def self.percentToStr(amount, lang)
        if (amount == nil)
            raise ArgumentError, "amount is nil"
        end
        if (lang == nil)
            raise ArgumentError, "Language is nil"
        end
        intPart = amount.to_i;
        fractPart = 0;
        @result = "";
        if (amount == amount.to_i)
            result = MoneyToStr.new(Currency::PER10, lang, Pennies::TEXT).convert(amount, 0);
        elsif ((amount * MoneyToStr::NUM10).round(4) == (amount * MoneyToStr::NUM10).to_i)
            fractPart = ((amount - intPart) * MoneyToStr::NUM10).round;
            result = MoneyToStr.new(Currency::PER10, lang, Pennies::TEXT).convert(intPart, fractPart);
        elsif ((amount * MoneyToStr::NUM100).round(4) == (amount * MoneyToStr::NUM100).to_i)
            fractPart = ((amount - intPart) * MoneyToStr::NUM100).round;
            result = MoneyToStr.new(Currency::PER100, lang, Pennies::TEXT).convert(intPart, fractPart);
        elsif ((amount * MoneyToStr::NUM1000).round(4) == (amount * MoneyToStr::NUM1000).to_i)
            fractPart = ((amount - intPart) * MoneyToStr::NUM1000).round;
            result = MoneyToStr.new(Currency::PER1000, lang, Pennies::TEXT).convert(intPart, fractPart);
        else
            fractPart = ((amount - intPart) * MoneyToStr::NUM10000).round;
            result = MoneyToStr.new(Currency::PER10000, lang, Pennies::TEXT).convert(intPart, fractPart);
        end
        return result;
    end

    def initialize(currency, language, pennies)
        @currency = currency.to_s;
        @language = language.to_s;
        @pennies = pennies.to_s;
        @languageElement = language.to_s;
        @items = @@currencyList['CurrencyList'][@languageElement]['item'];
        @messages = {};
        for languageItem in @items
            if languageItem["-text"] != nil
                @messages[languageItem["-value"]] = languageItem["-text"].split(",");
            end
        end
        currencyItem = @@currencyList['CurrencyList'][@currency]
        theISOElement = nil;
        for item in currencyItem
            if item["-language"] == @language
                theISOElement = item;
                next;
            end
        end
        if theISOElement == nil
            raise ArgumentError, "Currency not found " + @currency
        end
        @rubOneUnit = theISOElement["-RubOneUnit"];
        @rubTwoUnit = theISOElement["-RubTwoUnit"];
        @rubFiveUnit = theISOElement["-RubFiveUnit"];
        @kopOneUnit = theISOElement["-KopOneUnit"];
        @kopTwoUnit = theISOElement["-KopTwoUnit"];
        @kopFiveUnit = theISOElement["-KopFiveUnit"];
        @rubSex = theISOElement["-RubSex"];
        @kopSex = theISOElement["-KopSex"];
    end

=begin
    /**
     * Converts double value to the text description.
     *
     * @param theMoney
     *            the amount of money in format major.minor
     * @return the string description of money value
     */
=end
    def convertValue(theMoney)
        if theMoney == nil
            raise ArgumentError, "theMoney is nil"
        end
        intPart = theMoney.to_i
        fractPart = ((theMoney - intPart) * NUM100).round
        if @currency == Currency::PER1000.to_s
            fractPart = ((theMoney - intPart) * NUM1000).round
        end
        return convert(intPart, fractPart);
    end

=begin
    /**
     * Converts number to currency. Usage: MoneyToStr moneyToStr = new MoneyToStr("UAH"); String result =
     * moneyToStr.convert(123D); Expected: result = сто двадцять три гривні 00 копійок
     *
     * @param theMoney
     *            the amount of money major currency
     * @param theKopeiki
     *            the amount of money minor currency
     * @return the string description of money value
     */
=end
    def convert(theMoney, theKopeiki)
        if theMoney == nil
            raise ArgumentError, "theMoney is nil"
        end
        if theKopeiki == nil
            raise ArgumentError, "theKopeiki is nil"
        end
        money2str = StringBuilder.new();
        triadNum = 0;
        theTriad = nil;

        intPart = theMoney;
        if intPart == 0
            money2str.append(messages["0"][0] + " ");
        end
        begin
            theTriad = intPart % NUM1000;
            money2str.insert(0, triad2Word(theTriad, triadNum, @rubSex));
            if triadNum == 0
                range10 = (theTriad % NUM100) / NUM10;
                range = theTriad % NUM10;
                if range10 == NUM1
                    money2str.append(@rubFiveUnit);
                else
                    case range
                    when NUM1
                        money2str.append(@rubOneUnit)
                    when NUM2, NUM3,  NUM4
                        money2str.append(@rubTwoUnit)
                    else
                        money2str.append(@rubFiveUnit)
                    end
                end
            end
            intPart = intPart / NUM1000;
            triadNum += 1;
        end while intPart > 0

        if @pennies == Pennies::TEXT.to_s
            money2str.append(@language == Language::ENG.to_s ? " and " : " ").append(theKopeiki == 0 ? @messages["0"][0] + " " : triad2Word(theKopeiki, 0, @kopSex));
        else
            money2str.append(" " + (theKopeiki < 10 ? "0" + theKopeiki.to_s : theKopeiki.to_s) + " ");
        end
        if theKopeiki >= NUM11 && theKopeiki <= NUM14
            money2str.append(@kopFiveUnit);
        else
            case theKopeiki % NUM10
            when NUM1
                money2str.append(@kopOneUnit);
            when NUM2,  NUM3,  NUM4
                money2str.append(@kopTwoUnit);
            else
                money2str.append(@kopFiveUnit);
            end
        end
        return money2str.toString().strip;
    end

    def triad2Word(triad, triadNum, sex)
        triadWord = StringBuilder.new();

        if triad == 0
            return "";
        end

        range = check1(triad, triadWord);
        if @language == Language::ENG.to_s && triadWord.length() > 0 && triad % NUM10 == 0
            triadWord.deleteCharAt(triadWord.length() - 1);
            triadWord.append(" ");
        end

        range10 = range;
        range = triad % NUM10;
        check2(triadNum, sex, triadWord, triad, range10);
        case (triadNum)
        when NUM0
        when NUM1, NUM2, NUM3, NUM4
            if range10 == NUM1
                triadWord.append(@messages["1000_10"][triadNum - 1] + " ");
            else
                case (range)
                when NUM1
                    triadWord.append(@messages["1000_1"][triadNum - 1] + " ");
                when NUM2, NUM3, NUM4
                    triadWord.append(@messages["1000_234"][triadNum - 1] + " ");
                else
                    triadWord.append(@messages["1000_5"][triadNum - 1] + " ");
                end
            end
        else
            triadWord.append("??? ");
        end
        return triadWord.toString();
    end

=begin
    /**
     * @param triadNum the triad num
     * @param sex the sex
     * @param triadWord the triad word
     * @param triad the triad
     * @param range10 the range 10
     */
=end
    def check2(triadNum, sex, triadWord, triad, range10)
        range = triad % NUM10;
        if range10 == 1
            triadWord.append(@messages["10_19"][range] + " ");
        else
            case range
            when NUM1
                if triadNum == NUM1
                    triadWord.append(@messages["1"][INDEX_0] + " ");
                elsif triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4
                    triadWord.append(@messages["1"][INDEX_1] + " ");
                elsif "M" == sex
                    triadWord.append(@messages["1"][INDEX_2] + " ");
                elsif "F" == sex
                    triadWord.append(@messages["1"][INDEX_3] + " ");
                end
            when NUM2
                if triadNum == NUM1
                    triadWord.append(@messages["2"][INDEX_0] + " ");
                elsif triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4
                    triadWord.append(@messages["2"][INDEX_1] + " ");
                elsif "M" == sex
                    triadWord.append(@messages["2"][INDEX_2] + " ");
                elsif "F" == sex
                    triadWord.append(@messages["2"][INDEX_3] + " ");
                end
            when NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9
                triadWord.append((["", "", ""] + @messages["3_9"])[range] + " ");
            end
        end
    end

=begin
    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
=end
    def check1(triad, triadWord)
        range = triad / NUM100;
        triadWord.append(([""] + @messages["100_900"])[range]);

        range = (triad % NUM100) / NUM10;
        triadWord.append((["", ""] + @messages["20_90"])[range]);
        return range;
    end
end
