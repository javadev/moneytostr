using System;
using System.Collections;
using System.Collections.Generic;
using System.Collections.ObjectModel;
using System.Dynamic;
using System.Linq;
using System.Text;
using System.Web.Script.Serialization;

public class MoneyToStr {
    public sealed class DynamicJsonConverter : JavaScriptConverter {
        public override object Deserialize(IDictionary<string, object> dictionary, Type type, JavaScriptSerializer serializer) {
            if (dictionary == null) {
                throw new ArgumentNullException("dictionary");
            }
            return type == typeof(object) ? new DynamicJsonObject(dictionary) : null;
        }
    
        public override IDictionary<string, object> Serialize(object obj, JavaScriptSerializer serializer) {
            throw new NotImplementedException();
        }
    
        public override IEnumerable<Type> SupportedTypes {
            get { return new ReadOnlyCollection<Type>(new List<Type>(new[] { typeof(object) })); }
        }
    
        #region Nested type: DynamicJsonObject
        private sealed class DynamicJsonObject : DynamicObject {
            private readonly IDictionary<string, object> _dictionary;
    
            public DynamicJsonObject(IDictionary<string, object> dictionary) {
                if (dictionary == null) {
                    throw new ArgumentNullException("dictionary");
                }
                _dictionary = dictionary;
            }
    
            public override string ToString() {
                var sb = new StringBuilder("{");
                ToString(sb);
                return sb.ToString();
            }
    
            private void ToString(StringBuilder sb) {
                var firstInDictionary = true;
                foreach (var pair in _dictionary) {
                    if (!firstInDictionary)
                        sb.Append(",");
                    firstInDictionary = false;
                    var value = pair.Value;
                    var name = pair.Key;
                    if (value is string) {
                        sb.AppendFormat("{0}:\"{1}\"", name, value);
                    } else if (value is IDictionary<string, object>) {
                        new DynamicJsonObject((IDictionary<string, object>)value).ToString(sb);
                    } else if (value is ArrayList) {
                        sb.Append(name + ":[");
                        var firstInArray = true;
                        foreach (var arrayValue in (ArrayList) value) {
                            if (!firstInArray) {
                                sb.Append(",");
                            }
                            firstInArray = false;
                            if (arrayValue is IDictionary<string, object>) {
                                new DynamicJsonObject((IDictionary<string, object>)arrayValue).ToString(sb);
                            } else if (arrayValue is string) {
                                sb.AppendFormat("\"{0}\"", arrayValue);
                            } else {
                                sb.AppendFormat("{0}", arrayValue);
                            }
                        }
                        sb.Append("]");
                    } else {
                        sb.AppendFormat("{0}:{1}", name, value);
                    }
                }
                sb.Append("}");
            }
    
            public override bool TryGetMember(GetMemberBinder binder, out object result) {
                if (!_dictionary.TryGetValue(binder.Name, out result)) {
                    result = null;
                    return true;
                }
    
                var dictionary = result as IDictionary<string, object>;
                if (dictionary != null) {
                    result = new DynamicJsonObject(dictionary);
                    return true;
                }
    
                var arrayList = result as ArrayList;
                if (arrayList != null && arrayList.Count > 0) {
                    if (arrayList[0] is IDictionary<string, object>) {
                        result = new List<object>(arrayList.Cast<IDictionary<string, object>>().Select(x => new DynamicJsonObject(x)));
                    } else {
                        result = new List<object>(arrayList.Cast<object>());
                    }
                }
                return true;
            }
        }
        #endregion
    }

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
    /** Currency. */
public class Currency {
        /**.*/
        const string UAH = "UAH";
        /**.*/
        const string RUR = "RUR";
        /**.*/
        const string USD = "USD";
        /**.*/
        const string PER10 = "PER10";
        /**.*/
        const string PER100 = "PER100";
        /**.*/
        const string PER1000 = "PER1000";
        /**.*/
        const string PER10000 = "PER10000";
}

    /** Language. */
public class Language {
        /**.*/
        const string RUS = "RUS";
        /**.*/
        const string UKR = "UKR";
        /**.*/
        const string ENG = "ENG";
}

    /** Pennies. */
public class Pennies {
        /**.*/
        const string NUMBER = "NUMBER";
        /**.*/
        const string TEXT = "TEXT";
}
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

    public MoneyToStr(string currency, string language, string pennies) {
        this.currency = currency;
        this.language = language;
        this.pennies = pennies;
        string languageElement = language;
        var serializer = new JavaScriptSerializer();
        serializer.RegisterConverters(new[] { new DynamicJsonConverter() });
        dynamic currencyList = serializer.Deserialize(json, typeof(object));

        var items = currencyList.CurrencyList[languageElement]["item"];
/*
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
*/
    }

    static void Main(string[] args) {
        System.Console.WriteLine(new MoneyToStr("UKR", "UAH", "TEXT"));
    }
}
