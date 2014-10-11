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

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
class MoneyToStr {
    val currencyList =
<CurrencyList>
 
    <language value="UKR"/>
    <UKR>
        <item value="0" text="нуль"/>
        <item value="1000_10" text="тисяч,мільйонів,мільярдів,трильйонів"/>
        <item value="1000_1" text="тисяча,мільйон,мільярд,трильйон"/>
        <item value="1000_234" text="тисячі,мільйона,мільярда,трильйона"/>
        <item value="1000_5" text="тисяч,мільйонів,мільярдів,трильйонів"/>
        <item value="10_19" text="десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п’ятнадцять,шiстнадцять,сiмнадцять,вiсiмнадцять,дев'ятнадцять"/>
        <item value="1" text="одна,один,один,одна"/>
        <item value="2" text="дві,два,два,дві"/>
        <item value="3_9" text="три,чотири,п’ять,шість,сім,вісім,дев’ять"/>
        <item value="100_900" text="сто ,двісті ,триста ,чотириста ,п’ятсот ,шістсот ,сімсот ,вісімсот ,дев’ятсот "/>
        <item value="20_90" text="двадцять ,тридцять ,сорок ,п’ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев’яносто "/>
        <item value="pdv" text="в т.ч. ПДВ "/>
        <item value="pdv_value" text="20"/>
    </UKR>
    <RUS>
        <item value="0" text="ноль"/>
        <item value="1000_10" text="тысяч,миллионов,миллиардов,триллионов"/>
        <item value="1000_1" text="тысяча,миллион,миллиард,триллион"/>
        <item value="1000_234" text="тысячи,миллиона,миллиарда,триллиона"/>
        <item value="1000_5" text="тысяч,миллионов,миллиардов,триллионов"/>
        <item value="10_19" text="десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать"/>
        <item value="1" text="одна,один,один,одна"/>
        <item value="2" text="две,два,два,две"/>
        <item value="3_9" text="три,четыре,пять,шесть,семь,восемь,девять"/>
        <item value="100_900" text="сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот "/>
        <item value="20_90" text="двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто "/>
        <item value="pdv" text="в т.ч. НДС "/>
        <item value="pdv_value" text="18"/>
    </RUS>
    <ENG>
        <item value="0" text="zero"/>
        <item value="1000_10" text="thousand,million,billion,trillion"/>
        <item value="1000_1" text="thousand,million,billion,trillion"/>
        <item value="1000_234" text="thousand,million,billion,trillion"/>
        <item value="1000_5" text="thousand,million,billion,trillion"/>
        <item value="10_19" text="ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen"/>
        <item value="1" text="one,one,one,one"/>
        <item value="2" text="two,two,two,two"/>
        <item value="3_9" text="three,four,five,six,seven,eight,nine"/>
        <item value="100_900" text="one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred "/>
        <item value="20_90" text="twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-"/>
        <item value="pdv" text="including VAT "/>
        <item value="pdv_value" text="10"/>
    </ENG>

    <RUR CurrID="810" CurrName="Российские рубли" language="RUS"
         RubOneUnit="рубль" RubTwoUnit="рубля" RubFiveUnit="рублей" RubSex="M" RubShortUnit="руб."
         KopOneUnit="копейка" KopTwoUnit="копейки" KopFiveUnit="копеек" KopSex="F"
    />
    <UAH CurrID="980" CurrName="Украинскі гривні" language="RUS"
         RubOneUnit="гривня" RubTwoUnit="гривни" RubFiveUnit="гривень" RubSex="F" RubShortUnit="грн."
         KopOneUnit="копейка" KopTwoUnit="копейки" KopFiveUnit="копеек" KopSex="F"
    />
    <USD CurrID="840" CurrName="Долари США" language="RUS"
         RubOneUnit="доллар" RubTwoUnit="доллара" RubFiveUnit="долларов" RubSex="M" RubShortUnit="дол."
         KopOneUnit="цент" KopTwoUnit="цента" KopFiveUnit="центов" KopSex="M"
    />

    <RUR CurrID="810" CurrName="Российские рубли" language="UKR"
         RubOneUnit="рубль" RubTwoUnit="рублі" RubFiveUnit="рублів" RubSex="M" RubShortUnit="руб."
         KopOneUnit="копійка" KopTwoUnit="копійки" KopFiveUnit="копійок" KopSex="F"
    /> 
    <UAH CurrID="980" CurrName="Украинскі гривні" language="UKR"
         RubOneUnit="гривня" RubTwoUnit="гривні" RubFiveUnit="гривень" RubSex="F" RubShortUnit="грн."
         KopOneUnit="копійка" KopTwoUnit="копійки" KopFiveUnit="копійок" KopSex="F"
    />
    <USD CurrID="840" CurrName="Долари США" language="UKR"
         RubOneUnit="долар" RubTwoUnit="долара" RubFiveUnit="доларів" RubSex="M" RubShortUnit="дол."
         KopOneUnit="цент" KopTwoUnit="цента" KopFiveUnit="центів" KopSex="M"
    />

    <RUR CurrID="810" CurrName="Российские рубли" language="ENG"
         RubOneUnit="ruble" RubTwoUnit="rubles" RubFiveUnit="rubles" RubSex="M" RubShortUnit="RUR."
         KopOneUnit="kopeck" KopTwoUnit="kopecks" KopFiveUnit="kopecks" KopSex="M"
    /> 
    <UAH CurrID="980" CurrName="Украинскі гривні" language="ENG"
         RubOneUnit="hryvnia" RubTwoUnit="hryvnias" RubFiveUnit="hryvnias" RubSex="M" RubShortUnit="UAH."
         KopOneUnit="kopeck" KopTwoUnit="kopecks" KopFiveUnit="kopecks" KopSex="M"
    />
    <USD CurrID="840" CurrName="Долари США" language="ENG"
         RubOneUnit="dollar" RubTwoUnit="dollars" RubFiveUnit="dollars" RubSex="M" RubShortUnit="USD."
         KopOneUnit="cent" KopTwoUnit="cents" KopFiveUnit="cents" KopSex="M"
    />

    <PER10 CurrID="556" CurrName="Вiдсотки з десятими частинами" language="RUS"
         RubOneUnit="целая," RubTwoUnit="целых," RubFiveUnit="целых," RubSex="F"
         KopOneUnit="десятая процента" KopTwoUnit="десятых процента" KopFiveUnit="десятых процента" KopSex="F"
    />

    <PER100 CurrID="557" CurrName="Вiдсотки з сотими частинами" language="RUS"
         RubOneUnit="целая," RubTwoUnit="целых," RubFiveUnit="целых," RubSex="F"
         KopOneUnit="сотая процента" KopTwoUnit="сотых процента" KopFiveUnit="сотых процента" KopSex="F"
    />

    <PER1000 CurrID="558" CurrName="Вiдсотки з тисячними частинами" language="RUS"
         RubOneUnit="целая," RubTwoUnit="целых," RubFiveUnit="целых," RubSex="F"
         KopOneUnit="тысячная процента" KopTwoUnit="тысячных процента" KopFiveUnit="тысячных процента" KopSex="F"
    />

    <PER10000 CurrID="559" CurrName="Вiдсотки з десяти тисячними частинами" language="RUS"
         RubOneUnit="целая," RubTwoUnit="целых," RubFiveUnit="целых," RubSex="F"
         KopOneUnit="десятитысячная процента" KopTwoUnit="десятитысячные процента" KopFiveUnit="десятитысячных процента" KopSex="F"
    />

    <PER10 CurrID="556" CurrName="Вiдсотки з десятими частинами" language="UKR"
         RubOneUnit="ціла," RubTwoUnit="цілих," RubFiveUnit="цілих," RubSex="F"
         KopOneUnit="десята відсотка" KopTwoUnit="десятих відсотка" KopFiveUnit="десятих відсотка" KopSex="F"
    />

    <PER100 CurrID="557" CurrName="Вiдсотки з сотими частинами" language="UKR"
         RubOneUnit="ціла," RubTwoUnit="цілих," RubFiveUnit="цілих," RubSex="F"
         KopOneUnit="сота відсотка" KopTwoUnit="сотих відсотка" KopFiveUnit="сотих відсотка" KopSex="F"
    />

    <PER1000 CurrID="558" CurrName="Вiдсотки з тисячними частинами" language="UKR"
         RubOneUnit="ціла," RubTwoUnit="цілих," RubFiveUnit="цілих," RubSex="F"
         KopOneUnit="тисячна відсотка" KopTwoUnit="тисячних відсотка" KopFiveUnit="тисячних відсотка" KopSex="F"
    />

    <PER10000 CurrID="559" CurrName="Вiдсотки з десяти тисячними частинами" language="UKR"
         RubOneUnit="ціла," RubTwoUnit="цілих," RubFiveUnit="цілих," RubSex="F"
         KopOneUnit="десятитисячна відсотка" KopTwoUnit="десятитисячних відсотка" KopFiveUnit="десятитисячних відсотка" KopSex="M"
    />

    <PER10 CurrID="560" CurrName="Вiдсотки з десятими частинами" language="ENG"
         RubOneUnit="," RubTwoUnit="integers," RubFiveUnit="integers," RubSex="F"
         KopOneUnit="tenth of one percent" KopTwoUnit="tenth of one percent" KopFiveUnit="tenth of one percent" KopSex="F"
    />

    <PER100 CurrID="561" CurrName="Вiдсотки з сотими частинами" language="ENG"
         RubOneUnit="," RubTwoUnit="integers," RubFiveUnit="integers," RubSex="F"
         KopOneUnit="hundred percent" KopTwoUnit="hundredth of percent" KopFiveUnit="hundredth of percent" KopSex="F"
    />

    <PER1000 CurrID="562" CurrName="Вiдсотки з тисячними частинами" language="ENG"
         RubOneUnit="," RubTwoUnit="integers," RubFiveUnit="integers," RubSex="F"
         KopOneUnit="thousandth of percent" KopTwoUnit="thousandths of percent" KopFiveUnit="thousandths of percent" KopSex="F"
    />

    <PER10000 CurrID="563" CurrName="Вiдсотки з десяти тисячними частинами" language="ENG"
         RubOneUnit="," RubTwoUnit="integers," RubFiveUnit="integers," RubSex="F"
         KopOneUnit="ten percent" KopTwoUnit="ten-percent" KopFiveUnit="ten-percent" KopSex="F"
    />

</CurrencyList>
    private var rubOneUnit : String = ""
    private var rubTwoUnit : String = ""
    private var rubFiveUnit : String = ""
    private var rubSex : String = ""
    private var kopOneUnit : String = ""
    private var kopTwoUnit : String = ""
    private var kopFiveUnit : String = ""
    private var kopSex : String = ""
    private var rubShortUnit : String = ""
    private var currency : String = null
    private var language : String = null
    private var pennies : String = null
    private var messages : Map[String, Array[String]] = Map[String, Array[String]]()

    def this(currency : String, language : String, pennies : String) = {
        this()
        if (currency == null) {
            throw new IllegalArgumentException("currency is null");
        }
        if (language == null) {
            throw new IllegalArgumentException("language is null");
        }
        if (pennies == null) {
            throw new IllegalArgumentException("pennies is null");
        }
        this.currency = currency;
        this.language = language;
        this.pennies = pennies;
        var languageElement = (currencyList \\ "CurrencyList")(0) \ language
        var items = languageElement \ "item"
        for (index <- 0 to items.length - 1) {
            messages += (items(index) \ "@value").toString -> (items(index) \ "@text").toString.split(",")
        }
        var theISOElements = (currencyList \\ "CurrencyList")(0) \ currency
        var theISOElement : scala.xml.Node = null
        for (index <- 0 to theISOElements.length - 1) {
            if ((theISOElements(index) \ "@language").toString == language) {
                theISOElement = theISOElements(index)
            }
        }
        if (theISOElement == null) {
            throw new IllegalArgumentException("Currency not found " + currency);
        }
        rubOneUnit = (theISOElement \ "@RubOneUnit").toString
        rubTwoUnit = (theISOElement \ "@RubTwoUnit").toString
        rubFiveUnit = (theISOElement \ "@RubFiveUnit").toString
        kopOneUnit = (theISOElement \ "@KopOneUnit").toString
        kopTwoUnit = (theISOElement \ "@KopTwoUnit").toString
        kopFiveUnit = (theISOElement \ "@KopFiveUnit").toString
        rubSex = (theISOElement \ "@RubSex").toString
        kopSex = (theISOElement \ "@KopSex").toString
    }

    /**
     * Converts double value to the text description.
     *
     * @param theMoney
     *            the amount of money in format major.minor
     * @return the string description of money value
     */
    def convert(theMoney : Double) : String = {
        var intPart : Long = theMoney.longValue();
        var fractPart : Long = Math.round((theMoney - intPart) * MoneyToStr.NUM100);
        if (currency == "PER1000") {
            fractPart = Math.round((theMoney - intPart) * MoneyToStr.NUM1000);
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
    def convert(theMoney : Long, theKopeiki : Long) : String = {
        var money2str : StringBuilder = new StringBuilder()
        var triadNum : Long = 0L
        var theTriad: Long = 0L

        var intPart : Long = theMoney
        if (intPart == 0) {
            money2str.append(messages("0")(0) + " ");
        }
        do {
            theTriad = intPart % MoneyToStr.NUM1000;
            money2str.insert(0, triad2Word(theTriad, triadNum, rubSex));
            if (triadNum == 0) {
                var range10 : Long = (theTriad % MoneyToStr.NUM100) / MoneyToStr.NUM10;
                var range : Long = theTriad % MoneyToStr.NUM10;
                if (range10 == MoneyToStr.NUM1) {
                    money2str.append(rubFiveUnit);
                } else {
                    range.byteValue() match {
                    case MoneyToStr.NUM1 =>
                        money2str.append(rubOneUnit);
                    case MoneyToStr.NUM2 |
                        MoneyToStr.NUM3 |
                        MoneyToStr.NUM4 =>
                        money2str.append(rubTwoUnit);
                    case _ =>
                        money2str.append(rubFiveUnit);
                    }
                }
            }
            intPart = intPart / MoneyToStr.NUM1000
            triadNum += 1
        } while (intPart > 0)

        if (pennies == "TEXT") {
            if (language == "ENG") {
                money2str.append(" and ")
            } else {
                money2str.append(" ")
            }
            if (theKopeiki == 0) {
                money2str.append(messages("0")(0) + " ")
            } else {
                money2str.append(triad2Word(theKopeiki, 0L, kopSex))
            }
        } else {
            var value : String = theKopeiki.toString
            if (theKopeiki < 10) {
                value = "0" + theKopeiki
            }
            money2str.append(" " + value + " ");
        }
        if (theKopeiki >= MoneyToStr.NUM11 && theKopeiki <= MoneyToStr.NUM14) {
            money2str.append(kopFiveUnit);
        } else {
            theKopeiki % MoneyToStr.NUM10 match {
            case MoneyToStr.NUM1 =>
                money2str.append(kopOneUnit);
            case MoneyToStr.NUM2 |
                MoneyToStr.NUM3 |
                MoneyToStr.NUM4 =>
                money2str.append(kopTwoUnit);
            case _ =>
                money2str.append(kopFiveUnit);
            }
        }
        return money2str.toString().trim();
    }

    def triad2Word(triad : Long, triadNum : Long, sex : String) : String = {
        var triadWord : StringBuilder = new StringBuilder()

        if (triad == 0) {
            return "";
        }

        var range : Long = check1(triad, triadWord)
        if (language == "ENG" && triadWord.length > 0 && triad % MoneyToStr.NUM10 == 0) {
            triadWord.deleteCharAt(triadWord.length - 1)
            triadWord.append(" ")
        }

        var range10 : Long = range
        range = triad % MoneyToStr.NUM10
        check2(triadNum, sex, triadWord, triad, range10)
        triadNum.byteValue() match {
        case MoneyToStr.NUM0 => ;
        case MoneyToStr.NUM1 |
            MoneyToStr.NUM2 |
            MoneyToStr.NUM3 |
            MoneyToStr.NUM4 =>
            if (range10 == MoneyToStr.NUM1) {
                triadWord.append(messages("1000_10")(triadNum.byteValue() - 1) + " ")
            } else {
                range.byteValue() match {
                case MoneyToStr.NUM1 =>
                    triadWord.append(messages("1000_1")(triadNum.byteValue() - 1) + " ")
                case MoneyToStr.NUM2 |
                    MoneyToStr.NUM3 |
                    MoneyToStr.NUM4 =>
                    triadWord.append(messages("1000_234")(triadNum.byteValue() - 1) + " ")
                case _ =>
                    triadWord.append(messages("1000_5")(triadNum.byteValue() - 1) + " ")
                }
            }
        case _ =>
            triadWord.append("??? ")
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
    def check2(triadNum : Long, sex : String, triadWord : StringBuilder, triad : Long, range10 : Long) = {
        var range : Long = triad % MoneyToStr.NUM10
        if (range10 == 1) {
            triadWord.append(messages("10_19")(range.byteValue()) + " ");
        } else {
            range.byteValue() match {
            case MoneyToStr.NUM1 =>
                if (triadNum == MoneyToStr.NUM1) {
                    triadWord.append(messages("1")(MoneyToStr.INDEX_0) + " ")
                } else if (triadNum == MoneyToStr.NUM2 || triadNum == MoneyToStr.NUM3 || triadNum == MoneyToStr.NUM4) {
                    triadWord.append(messages("1")(MoneyToStr.INDEX_1) + " ")
                } else if ("M".equals(sex)) {
                    triadWord.append(messages("1")(MoneyToStr.INDEX_2) + " ")
                } else if ("F".equals(sex)) {
                    triadWord.append(messages("1")(MoneyToStr.INDEX_3) + " ")
                }
            case MoneyToStr.NUM2 =>
                if (triadNum == MoneyToStr.NUM1) {
                    triadWord.append(messages("2")(MoneyToStr.INDEX_0) + " ");
                } else if (triadNum == MoneyToStr.NUM2 || triadNum == MoneyToStr.NUM3 || triadNum == MoneyToStr.NUM4) {
                    triadWord.append(messages("2")(MoneyToStr.INDEX_1) + " ")
                } else if ("M".equals(sex)) {
                    triadWord.append(messages("2")(MoneyToStr.INDEX_2) + " ")
                } else if ("F".equals(sex)) {
                    triadWord.append(messages("2")(MoneyToStr.INDEX_3) + " ")
                }
            case MoneyToStr.NUM3 |
                MoneyToStr.NUM4 |
                MoneyToStr.NUM5 |
                MoneyToStr.NUM6 |
                MoneyToStr.NUM7 |
                MoneyToStr.NUM8 |
                MoneyToStr.NUM9 =>
                var array = Array[String]("", "", "") ++ messages("3_9")
                triadWord.append(array(range.toInt) + " ");
            case _ => ;
            }
        }
    }

    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
    def check1(triad : Long, triadWord : StringBuilder) : Long = {
        var range : Long = triad / MoneyToStr.NUM100
        var array = Array[String]("") ++ messages("100_900")
        triadWord.append(array(range.byteValue()))

        range = (triad % MoneyToStr.NUM100) / MoneyToStr.NUM10
        array = Array[String]("", "") ++ messages("20_90")
        triadWord.append(array(range.byteValue()))
        return range
    }
}

object MoneyToStr {
    val INDEX_3 = 3
    val INDEX_2 = 2
    val INDEX_1 = 1
    val INDEX_0 = 0
    val NUM0 = 0;
    val NUM1 = 1;
    val NUM2 = 2;
    val NUM3 = 3;
    val NUM4 = 4;
    val NUM5 = 5;
    val NUM6 = 6;
    val NUM7 = 7;
    val NUM8 = 8;
    val NUM9 = 9;
    val NUM10 = 10;
    val NUM11 = 11;
    val NUM14 = 14;
    val NUM100 = 100;
    val NUM1000 = 1000;
    val NUM10000 = 10000;

    /**
     * Converts percent to string.
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR)
     * @return the string of percent
     */
    def percentToStr(amount : Double, lang : String) : String = {
        if (lang == null) {
            throw new IllegalArgumentException("language is null");
        }
        var intPart : Long = amount.longValue();
        var fractPart : Long = 0L;
        var result : String = "";
        if (amount.floatValue() == amount.intValue()) {
            result = new MoneyToStr("PER10", lang, "TEXT").convert(amount.longValue(), 0L);
        } else if ((amount * MoneyToStr.NUM10).toFloat == (amount * MoneyToStr.NUM10).toInt) {
            fractPart = Math.round((amount - intPart) * MoneyToStr.NUM10);
            result = new MoneyToStr("PER10", lang, "TEXT").convert(intPart, fractPart);
        } else if ((amount * MoneyToStr.NUM100).toFloat == (amount * MoneyToStr.NUM100).toInt) {
            fractPart = Math.round((amount - intPart) * MoneyToStr.NUM100);
            result = new MoneyToStr("PER100", lang, "TEXT").convert(intPart, fractPart);
        } else if ((amount * MoneyToStr.NUM1000).toFloat == (amount * MoneyToStr.NUM1000).toInt) {
            fractPart = Math.round((amount - intPart) * MoneyToStr.NUM1000);
            result = new MoneyToStr("PER1000", lang, "TEXT").convert(intPart, fractPart);
        } else {
            fractPart = Math.round((amount - intPart) * MoneyToStr.NUM10000);
            result = new MoneyToStr("PER10000", lang, "TEXT").convert(intPart, fractPart);
        }
        return result;
    }

}

//val text = new MoneyToStr("UAH", "UKR", "TEXT").convert(123, 45)
//print("Hello, scala " + text);
