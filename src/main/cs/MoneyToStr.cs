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
using System;
using System.Collections;
using System.Collections.Generic;
using System.Text;
using System.Web.Script.Serialization;

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn V Kolesnikov
 * @version $Revision$ $Date$
 */
public class MoneyToStr {

readonly string json = @"{
  ""CurrencyList"" : {
    ""language"" : { ""-value"" : ""UKR"" },
    ""UKR"" : {
      ""item"" : [
        {
          ""-value"" : ""0"",
          ""-text"" : ""нуль""
        },
        {
          ""-value"" : ""1000_10"",
          ""-text"" : ""тисяч,мільйонів,мільярдів,трильйонів""
        },
        {
          ""-value"" : ""1000_1"",
          ""-text"" : ""тисяча,мільйон,мільярд,трильйон""
        },
        {
          ""-value"" : ""1000_234"",
          ""-text"" : ""тисячі,мільйона,мільярда,трильйона""
        },
        {
          ""-value"" : ""1000_5"",
          ""-text"" : ""тисяч,мільйонів,мільярдів,трильйонів""
        },
        {
          ""-value"" : ""10_19"",
          ""-text"" : ""десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п’ятнадцять,шiстнадцять,сiмнадцять,вiсiмнадцять,дев'ятнадцять""
        },
        {
          ""-value"" : ""1"",
          ""-text"" : ""одна,один,один,одна""
        },
        {
          ""-value"" : ""2"",
          ""-text"" : ""дві,два,два,дві""
        },
        {
          ""-value"" : ""3_9"",
          ""-text"" : ""три,чотири,п’ять,шість,сім,вісім,дев’ять""
        },
        {
          ""-value"" : ""100_900"",
          ""-text"" : ""сто ,двісті ,триста ,чотириста ,п’ятсот ,шістсот ,сімсот ,вісімсот ,дев’ятсот ""
        },
        {
          ""-value"" : ""20_90"",
          ""-text"" : ""двадцять ,тридцять ,сорок ,п’ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев’яносто ""
        }
      ]
    },
    ""RUS"" : {
      ""item"" : [
        {
          ""-value"" : ""0"",
          ""-text"" : ""ноль""
        },
        {
          ""-value"" : ""1000_10"",
          ""-text"" : ""тысяч,миллионов,миллиардов,триллионов""
        },
        {
          ""-value"" : ""1000_1"",
          ""-text"" : ""тысяча,миллион,миллиард,триллион""
        },
        {
          ""-value"" : ""1000_234"",
          ""-text"" : ""тысячи,миллиона,миллиарда,триллиона""
        },
        {
          ""-value"" : ""1000_5"",
          ""-text"" : ""тысяч,миллионов,миллиардов,триллионов""
        },
        {
          ""-value"" : ""10_19"",
          ""-text"" : ""десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать""
        },
        {
          ""-value"" : ""1"",
          ""-text"" : ""одна,один,один,одна""
        },
        {
          ""-value"" : ""2"",
          ""-text"" : ""две,два,два,две""
        },
        {
          ""-value"" : ""3_9"",
          ""-text"" : ""три,четыре,пять,шесть,семь,восемь,девять""
        },
        {
          ""-value"" : ""100_900"",
          ""-text"" : ""сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот ""
        },
        {
          ""-value"" : ""20_90"",
          ""-text"" : ""двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто ""
        }
      ]
    },
    ""ENG"" : {
      ""item"" : [
        {
          ""-value"" : ""0"",
          ""-text"" : ""zero""
        },
        {
          ""-value"" : ""1000_10"",
          ""-text"" : ""thousand,million,billion,trillion""
        },
        {
          ""-value"" : ""1000_1"",
          ""-text"" : ""thousand,million,billion,trillion""
        },
        {
          ""-value"" : ""1000_234"",
          ""-text"" : ""thousand,million,billion,trillion""
        },
        {
          ""-value"" : ""1000_5"",
          ""-text"" : ""thousand,million,billion,trillion""
        },
        {
          ""-value"" : ""10_19"",
          ""-text"" : ""ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen""
        },
        {
          ""-value"" : ""1"",
          ""-text"" : ""one,one,one,one""
        },
        {
          ""-value"" : ""2"",
          ""-text"" : ""two,two,two,two""
        },
        {
          ""-value"" : ""3_9"",
          ""-text"" : ""three,four,five,six,seven,eight,nine""
        },
        {
          ""-value"" : ""100_900"",
          ""-text"" : ""one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred ""
        },
        {
          ""-value"" : ""20_90"",
          ""-text"" : ""twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-""
        }
      ]
    },
    ""RUR"" : [
      {
        ""-CurrID"" : ""810"",
        ""-CurrName"" : ""Российские рубли"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""рубль"",
        ""-RubTwoUnit"" : ""рубля"",
        ""-RubFiveUnit"" : ""рублей"",
        ""-RubSex"" : ""M"",
        ""-KopOneUnit"" : ""копейка"",
        ""-KopTwoUnit"" : ""копейки"",
        ""-KopFiveUnit"" : ""копеек"",
        ""-KopSex"" : ""F""
      },
      {
        ""-CurrID"" : ""810"",
        ""-CurrName"" : ""Российские рубли"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""рубль"",
        ""-RubTwoUnit"" : ""рубля"",
        ""-RubFiveUnit"" : ""рублів"",
        ""-RubSex"" : ""M"",
        ""-KopOneUnit"" : ""копійка"",
        ""-KopTwoUnit"" : ""копійки"",
        ""-KopFiveUnit"" : ""копійок"",
        ""-KopSex"" : ""F""
      }
    ],
    ""UAH"" : [
      {
        ""-CurrID"" : ""980"",
        ""-CurrName"" : ""Украинскі гривні"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""гривня"",
        ""-RubTwoUnit"" : ""гривни"",
        ""-RubFiveUnit"" : ""гривень"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""копейка"",
        ""-KopTwoUnit"" : ""копейки"",
        ""-KopFiveUnit"" : ""копеек"",
        ""-KopSex"" : ""F""
      },
      {
        ""-CurrID"" : ""980"",
        ""-CurrName"" : ""Украинскі гривні"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""гривня"",
        ""-RubTwoUnit"" : ""гривні"",
        ""-RubFiveUnit"" : ""гривень"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""копійка"",
        ""-KopTwoUnit"" : ""копійки"",
        ""-KopFiveUnit"" : ""копійок"",
        ""-KopSex"" : ""F""
      }
    ],
    ""USD"" : [
      {
        ""-CurrID"" : ""840"",
        ""-CurrName"" : ""Долари США"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""долар"",
        ""-RubTwoUnit"" : ""долара"",
        ""-RubFiveUnit"" : ""доларів"",
        ""-RubSex"" : ""M"",
        ""-KopOneUnit"" : ""цент"",
        ""-KopTwoUnit"" : ""цена"",
        ""-KopFiveUnit"" : ""центов"",
        ""-KopSex"" : ""M""
      },
      {
        ""-CurrID"" : ""840"",
        ""-CurrName"" : ""Долари США"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""долар"",
        ""-RubTwoUnit"" : ""долара"",
        ""-RubFiveUnit"" : ""доларів"",
        ""-RubSex"" : ""M"",
        ""-KopOneUnit"" : ""цент"",
        ""-KopTwoUnit"" : ""цена"",
        ""-KopFiveUnit"" : ""центів"",
        ""-KopSex"" : ""M""
      },
      {
        ""-CurrID"" : ""840"",
        ""-CurrName"" : ""Долари США"",
        ""-language"" : ""ENG"",
        ""-RubOneUnit"" : ""dollar"",
        ""-RubTwoUnit"" : ""dollars"",
        ""-RubFiveUnit"" : ""dollars"",
        ""-RubSex"" : ""M"",
        ""-KopOneUnit"" : ""cent"",
        ""-KopTwoUnit"" : ""cents"",
        ""-KopFiveUnit"" : ""cents"",
        ""-KopSex"" : ""M""
      }
     ],
    ""PER10"" : [
      {
        ""-CurrID"" : ""556"",
        ""-CurrName"" : ""Вiдсотки з десятими частинами"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""целая,"",
        ""-RubTwoUnit"" : ""целых,"",
        ""-RubFiveUnit"" : ""целых,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""десятая процента"",
        ""-KopTwoUnit"" : ""десятых процента"",
        ""-KopFiveUnit"" : ""десятых процента"",
        ""-KopSex"" : ""F""
      },
      {
        ""-CurrID"" : ""556"",
        ""-CurrName"" : ""Вiдсотки з десятими частинами"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""ціла,"",
        ""-RubTwoUnit"" : ""цілих,"",
        ""-RubFiveUnit"" : ""цілих,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""десята відсотка"",
        ""-KopTwoUnit"" : ""десятих відсотка"",
        ""-KopFiveUnit"" : ""десятих відсотка"",
        ""-KopSex"" : ""F""
      }
    ],
    ""PER100"" : [
      {
        ""-CurrID"" : ""557"",
        ""-CurrName"" : ""Вiдсотки з сотими частинами"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""целая,"",
        ""-RubTwoUnit"" : ""целых,"",
        ""-RubFiveUnit"" : ""целых,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""сотая процента"",
        ""-KopTwoUnit"" : ""сотых процента"",
        ""-KopFiveUnit"" : ""сотых процента"",
        ""-KopSex"" : ""F""
      },
      {
        ""-CurrID"" : ""557"",
        ""-CurrName"" : ""Вiдсотки з сотими частинами"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""ціла,"",
        ""-RubTwoUnit"" : ""цілих,"",
        ""-RubFiveUnit"" : ""цілих,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""сота відсотка"",
        ""-KopTwoUnit"" : ""сотих відсотка"",
        ""-KopFiveUnit"" : ""сотих відсотка"",
        ""-KopSex"" : ""F""
      }
    ],
    ""PER1000"" : [
      {
        ""-CurrID"" : ""558"",
        ""-CurrName"" : ""Вiдсотки з тисячними частинами"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""целая,"",
        ""-RubTwoUnit"" : ""целых,"",
        ""-RubFiveUnit"" : ""целых,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""тысячная процента"",
        ""-KopTwoUnit"" : ""тысячных процента"",
        ""-KopFiveUnit"" : ""тысячных процента"",
        ""-KopSex"" : ""F""
      },
      {
        ""-CurrID"" : ""558"",
        ""-CurrName"" : ""Вiдсотки з тисячними частинами"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""ціла,"",
        ""-RubTwoUnit"" : ""цілих,"",
        ""-RubFiveUnit"" : ""цілих,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""тисячна відсотка"",
        ""-KopTwoUnit"" : ""тисячних відсотка"",
        ""-KopFiveUnit"" : ""тисячних відсотка"",
        ""-KopSex"" : ""F""
      }
    ],
    ""PER10000"" : [
      {
        ""-CurrID"" : ""559"",
        ""-CurrName"" : ""Вiдсотки з десяти тисячними частинами"",
        ""-language"" : ""RUS"",
        ""-RubOneUnit"" : ""целая,"",
        ""-RubTwoUnit"" : ""целых,"",
        ""-RubFiveUnit"" : ""целых,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""десятитысячная процента"",
        ""-KopTwoUnit"" : ""десятитысячные процента"",
        ""-KopFiveUnit"" : ""десятитысячных процента"",
        ""-KopSex"" : ""F""
      },
      {
        ""-CurrID"" : ""559"",
        ""-CurrName"" : ""Вiдсотки з десяти тисячними частинами"",
        ""-language"" : ""UKR"",
        ""-RubOneUnit"" : ""ціла,"",
        ""-RubTwoUnit"" : ""цілих,"",
        ""-RubFiveUnit"" : ""цілих,"",
        ""-RubSex"" : ""F"",
        ""-KopOneUnit"" : ""десятитисячна відсотка"",
        ""-KopTwoUnit"" : ""десятитисячних відсотка"",
        ""-KopFiveUnit"" : ""десятитисячних відсотка"",
        ""-KopSex"" : ""M""
      }
    ]
  }
}";

    const int NUM0 = 0;
    const int NUM1 = 1;
    const int NUM2 = 2;
    const int NUM3 = 3;
    const int NUM4 = 4;
    const int NUM5 = 5;
    const int NUM6 = 6;
    const int NUM7 = 7;
    const int NUM8 = 8;
    const int NUM9 = 9;
    const int NUM10 = 10;
    const int NUM11 = 11;
    const int NUM14 = 14;
    const int NUM100 = 100;
    const int NUM1000 = 1000;
    const int NUM10000 = 10000;
    const int INDEX_0 = 0;
    const int INDEX_1 = 1;
    const int INDEX_2 = 2;
    const int INDEX_3 = 3;

    private string currency;
    private string language;
    private string pennies;
    private Dictionary<string, string[]> messages = new Dictionary<string, string[]>();
    private string rubOneUnit;
    private string rubTwoUnit;
    private string rubFiveUnit;
    private string kopOneUnit;
    private string kopTwoUnit;
    private string kopFiveUnit;
    private string rubSex;
    private string kopSex;

    public MoneyToStr(string currency, string language, string pennies) {
        if (currency == null) {
            throw new ArgumentNullException("currency is null");
        }
        if (language == null) {
            throw new ArgumentNullException("language is null");
        }
        if (pennies == null) {
            throw new ArgumentNullException("pennies is null");
        }
        this.currency = currency;
        this.language = language;
        this.pennies = pennies;
        string languageElement = language;
        JavaScriptSerializer serializer = new JavaScriptSerializer(); 
        dynamic currencyList = serializer.Deserialize<object>(json);

        var items = currencyList["CurrencyList"][languageElement]["item"];
        foreach (var languageItem in items) {
            if (languageItem["-text"] != null) {
                messages[languageItem["-value"]] = languageItem["-text"].Split(',');
            }
        }
        var currencyItem = currencyList["CurrencyList"][this.currency];
        var theISOElement = (dynamic) null;
        foreach (var item in currencyItem) {
            if (item["-language"] == this.language) {
                theISOElement = item;
                break;
            }
        }
        if (theISOElement == null) {
            throw new ArgumentNullException("Currency not found " + this.currency);
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
    public static string percentToStr(double amount, string lang) {
        if (lang == null) {
            throw new ArgumentNullException("Language is null");
        }
        long intPart = (long) amount;
        long fractPart = 0;
        string result = "";
        if (amount == (long) amount) {
            result = new MoneyToStr("PER10", lang, "TEXT").convert(intPart, fractPart);
        } else if (Math.Round(amount * NUM10, 4) == (long) (amount * NUM10)) {
            fractPart = (long) Math.Round((amount - intPart) * NUM10);
            result = new MoneyToStr("PER10", lang, "TEXT").convert(intPart, fractPart);
        } else if (Math.Round(amount * NUM100, 4) == (long) (amount * NUM100)) {
            fractPart = (long) Math.Round((amount - intPart) * NUM100);
            result = new MoneyToStr("PER100", lang, "TEXT").convert(intPart, fractPart);
        } else if (Math.Round(amount * NUM1000, 4) == (long) (amount * NUM1000)) {
            fractPart = (long) Math.Round((amount - intPart) * NUM1000);
            result = new MoneyToStr("PER1000", lang, "TEXT").convert(intPart, fractPart);
        } else {
            fractPart = (long) Math.Round((amount - intPart) * NUM10000);
            result = new MoneyToStr("PER10000", lang, "TEXT").convert(intPart, fractPart);
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
    public string convertValue(double theMoney) {
        long intPart = (long) theMoney;
        long fractPart = (long) Math.Round((theMoney - intPart) * NUM100);
        if (currency == "PER1000") {
            fractPart = (long) Math.Round((theMoney - intPart) * NUM1000);
        }
        return convert(intPart, fractPart);
    }

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
    public string convert(long theMoney, long theKopeiki) {
        StringBuilder money2str = new StringBuilder();
        long triadNum = 0;
        long theTriad;

        long intPart = theMoney;
        if (intPart == 0) {
            money2str.Append(messages["0"][0] + " ");
        }
        do {
            theTriad = intPart % NUM1000;
            money2str.Insert(0, triad2Word(theTriad, triadNum, rubSex));
            if (triadNum == 0) {
                long range10 = (theTriad % NUM100) / NUM10;
                long range = theTriad % NUM10;
                if (range10 == NUM1) {
                    money2str.Append(rubFiveUnit);
                } else {
                    switch (range) {
                    case NUM1:
                        money2str.Append(rubOneUnit);
                        break;
                    case NUM2: case NUM3: case NUM4:
                        money2str.Append(rubTwoUnit);
                        break;
                    default:
                        money2str.Append(rubFiveUnit);
                        break;
                    }
                }
            }
            intPart = intPart / NUM1000;
            triadNum += 1;
        } while (intPart > 0);

        if (pennies == "TEXT") {
            money2str.Append(language == "ENG" ? " and " : " ").Append(theKopeiki == 0 ? (messages["0"][0] + " ") : triad2Word(theKopeiki, 0, kopSex));
        } else {
            money2str.Append(" " + (theKopeiki < 10 ? "0" + Convert.ToString(theKopeiki) : Convert.ToString(theKopeiki)) + " ");
        }
        if (theKopeiki >= NUM11 && theKopeiki <= NUM14) {
            money2str.Append(kopFiveUnit);
        } else {
            switch (theKopeiki % NUM10) {
            case NUM1:
                money2str.Append(kopOneUnit);
                break;
            case NUM2: case NUM3: case NUM4:
                money2str.Append(kopTwoUnit);
                break;
            default:
                money2str.Append(kopFiveUnit);
                break;
            }
        }
        return money2str.ToString().Trim();
    }

    private string triad2Word(long triad, long triadNum, string sex) {
        StringBuilder triadWord = new StringBuilder();

        if (triad == 0) {
            return "";
        }

        long range = check1(triad, triadWord);
        if (language == "ENG" && triadWord.Length > 0 && triad % NUM10 == 0) {
            triadWord = new StringBuilder(triadWord.ToString(0, triadWord.Length - 1));
            triadWord.Append(" ");
        }

        long range10 = range;
        range = triad % NUM10;
        check2(triadNum, sex, triadWord, triad, range10);
        switch (triadNum) {
        case NUM0:
            break;
        case NUM1: case NUM2: case NUM3: case NUM4:
            if (range10 == NUM1) {
                triadWord.Append(messages["1000_10"][triadNum - 1] + " ");
            } else {
                switch (range) {
                case NUM1:
                    triadWord.Append(messages["1000_1"][triadNum - 1] + " ");
                    break;
                case NUM2: case NUM3: case NUM4:
                    triadWord.Append(messages["1000_234"][triadNum - 1] + " ");
                    break;
                default:
                    triadWord.Append(messages["1000_5"][triadNum - 1] + " ");
                    break;
                }
            }
            break;
        default:
            triadWord.Append("??? ");
            break;
        }
        return triadWord.ToString();
    }

    /**
     * @param triadNum the triad num
     * @param sex the sex
     * @param triadWord the triad word
     * @param triad the triad
     * @param range10 the range 10
     */
    private void check2(long triadNum, string sex, StringBuilder triadWord, long triad, long range10) {
        long range = triad % NUM10;
        if (range10 == 1) {
            triadWord.Append(messages["10_19"][range] + " ");
        } else {
            switch (range) {
            case NUM1:
                if (triadNum == NUM1) {
                    triadWord.Append(messages["1"][INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.Append(messages["1"][INDEX_1] + " ");
                } else if ("M" == sex) {
                    triadWord.Append(messages["1"][INDEX_2] + " ");
                } else if ("F" == sex) {
                    triadWord.Append(messages["1"][INDEX_3] + " ");
                }
                break;
            case NUM2:
                if (triadNum == NUM1) {
                    triadWord.Append(messages["2"][INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.Append(messages["2"][INDEX_1] + " ");
                } else if ("M" == sex) {
                    triadWord.Append(messages["2"][INDEX_2] + " ");
                } else if ("F" == sex) {
                    triadWord.Append(messages["2"][INDEX_3] + " ");
                }
                break;
            case NUM3: case NUM4: case NUM5: case NUM6: case NUM7: case NUM8: case NUM9:
                triadWord.Append(concat(new string[] {"", "", ""}, messages["3_9"])[range] + " ");
                break;
            }
        }
    }

    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
    private long check1(long triad, StringBuilder triadWord) {
        long range = triad / NUM100;
        triadWord.Append(concat(new string[] {""}, messages["100_900"])[range]);

        range = (triad % NUM100) / NUM10;
        triadWord.Append(concat(new string[] {"", ""}, messages["20_90"])[range]);
        return range;
    }

    private string[] concat(string[] first, string[] second) {
        string[] result = new string[first.Length + second.Length];
        first.CopyTo(result, 0);
        second.CopyTo(result, first.Length);
        return result;
    }
}
