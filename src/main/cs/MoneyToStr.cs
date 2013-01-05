using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Web.Script.Serialization;

public class MoneyToStr {

const string json = @"{
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
        ""-RubFiveUnit"" : ""рублей"",
        ""-RubSex"" : ""M"",
        ""-KopOneUnit"" : ""копейка"",
        ""-KopTwoUnit"" : ""копейки"",
        ""-KopFiveUnit"" : ""копеек"",
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
    const int NUM12 = 12;
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
        System.Console.WriteLine(this.rubSex);
    }

    static void Main(string[] args) {
        System.Console.WriteLine(new MoneyToStr("RUR", "RUS", "TEXT"));
    }
}
