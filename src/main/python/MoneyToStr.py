'''
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
'''

'''
/**
 * Converts numbers to symbols.
 *
 * @author Valentyn V Kolesnikov
 * @version $Revision$ $Date$
 */
'''
class MoneyToStr:
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
        "-KopTwoUnit" : "цена",
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
        "-KopTwoUnit" : "цена",
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
print MoneyToStr.currencyList["CurrencyList"]["language"]

