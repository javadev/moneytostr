/*
 * $Id$
 *
 * Copyright 2014 Valentyn Kolesnikov
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
package com.github.moneytostr;

import java.io.IOException;
import java.io.InputStream;

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
public class MoneyToStr {
    private static final int INDEX_3 = 3;
    private static final int INDEX_2 = 2;
    private static final int INDEX_1 = 1;
    private static final int INDEX_0 = 0;
    private static org.w3c.dom.Document xmlDoc;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int NUM7 = 7;
    private static final int NUM8 = 8;
    private static final int NUM9 = 9;
    private static final int NUM10 = 10;
    private static final int NUM11 = 11;
    private static final int NUM14 = 14;
    private static final int NUM100 = 100;
    private static final int NUM1000 = 1000;
    private static final int NUM10000 = 10000;
    private static final String CURRENCY_LIST = '''
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
         KopOneUnit="цент" KopTwoUnit="цена" KopFiveUnit="центов" KopSex="M"
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
         KopOneUnit="цент" KopTwoUnit="цена" KopFiveUnit="центів" KopSex="M"
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
''';
    private java.util.Map<String, String[]> messages = new java.util.LinkedHashMap<String, String[]>();
    private String rubOneUnit;
    private String rubTwoUnit;
    private String rubFiveUnit;
    private String rubSex;
    private String kopOneUnit;
    private String kopTwoUnit;
    private String kopFiveUnit;
    private String kopSex;
    private String rubShortUnit;
    private final Currency currency;
    private final Language language;
    private final Pennies pennies;

    static {
        initXmlDoc(CURRENCY_LIST);
    }

    public static void initXmlDoc(final String xmlData) {
        javax.xml.parsers.DocumentBuilderFactory docFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        try {
            javax.xml.parsers.DocumentBuilder xmlDocBuilder = docFactory.newDocumentBuilder();
            xmlDoc = xmlDocBuilder.parse(new java.io.ByteArrayInputStream(xmlData.getBytes("UTF-8")));
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        }
    }

    /** Currency. */
    public enum Currency {
        /**.*/
        RUR,
        /**.*/
        UAH,
        /**.*/
        USD,
        /**.*/
        PER10,
        /**.*/
        PER100,
        /**.*/
        PER1000,
        /**.*/
        PER10000
    }

    /** Language. */
    public enum Language {
        /**.*/
        RUS,
        /**.*/
        UKR,
        /**.*/
        ENG
    }

    /** Pennies. */
    public enum Pennies {
        /**.*/
        NUMBER,
        /**.*/
        TEXT
    }

    /**
     * Inits class with currency. Usage: MoneyToStr moneyToStr = new MoneyToStr(
     *     MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
     * Definition for currency is placed into currlist.xml
     *
     * @param currency the currency (UAH, RUR, USD)
     * @param language the language (UKR, RUS, ENG)
     * @param pennies the pennies (NUMBER, TEXT)
     */
    public MoneyToStr(Currency currency, Language language, Pennies pennies) {
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
        String theISOstr = currency.name();
        org.w3c.dom.Element languageElement =
            (xmlDoc.getElementsByTagName(language.name())).item(0);
        org.w3c.dom.NodeList items = languageElement.getElementsByTagName("item");
        for (int index = 0; index < items.getLength(); index += 1) {
            org.w3c.dom.Element languageItem = (org.w3c.dom.Element) items.item(index);
            messages.put(languageItem.getAttribute("value"), languageItem.getAttribute("text").split(","));
        }
        org.w3c.dom.NodeList theISOElements = (org.w3c.dom.NodeList) (xmlDoc.getElementsByTagName(theISOstr));
        org.w3c.dom.Element theISOElement = null;
        for (int index = 0; index < theISOElements.getLength(); index += 1) {
            if (((org.w3c.dom.Element) theISOElements.item(index)).getAttribute("language").equals(language.name())) {
                theISOElement = (org.w3c.dom.Element) theISOElements.item(index);
                break;
            }
        }
        rubOneUnit = theISOElement.getAttribute("RubOneUnit");
        rubTwoUnit = theISOElement.getAttribute("RubTwoUnit");
        rubFiveUnit = theISOElement.getAttribute("RubFiveUnit");
        kopOneUnit = theISOElement.getAttribute("KopOneUnit");
        kopTwoUnit = theISOElement.getAttribute("KopTwoUnit");
        kopFiveUnit = theISOElement.getAttribute("KopFiveUnit");
        rubSex = theISOElement.getAttribute("RubSex");
        kopSex = theISOElement.getAttribute("KopSex");
    }

    /**
     * Converts percent to string.
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR)
     * @return the string of percent
     */
    public static String percentToStr(Double amount, Language lang) {
        return percentToStr(amount, lang, Pennies.TEXT);
    }

    /**
     * Converts percent to string.
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR, ENG)
     * @param pennies the pennies (NUMBER, TEXT)
     * @return the string of percent
     */
    public static String percentToStr(Double amount, Language lang, Pennies pennies) {
        if (amount == null) {
            throw new IllegalArgumentException("amount is null");
        }
        if (lang == null) {
            throw new IllegalArgumentException("language is null");
        }
        if (pennies == null) {
            throw new IllegalArgumentException("pennies is null");
        }
        Long intPart = amount.longValue();
        Long fractPart = 0L;
        String result;
        if (amount.floatValue() == amount.intValue()) {
            result = new MoneyToStr(Currency.PER10, lang, pennies).convert(amount.longValue(), 0L);
        } else if (Double.valueOf(amount * NUM10).floatValue() == Double.valueOf(amount * NUM10).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM10);
            result = new MoneyToStr(Currency.PER10, lang, pennies).convert(intPart, fractPart);
        } else if (Double.valueOf(amount * NUM100).floatValue() == Double.valueOf(amount * NUM100).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM100);
            result = new MoneyToStr(Currency.PER100, lang, pennies).convert(intPart, fractPart);
        } else if (Double.valueOf(amount * NUM1000).floatValue() == Double.valueOf(amount * NUM1000).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM1000);
            result = new MoneyToStr(Currency.PER1000, lang, pennies).convert(intPart, fractPart);
        } else {
            fractPart = Math.round((amount - intPart) * NUM10000);
            result = new MoneyToStr(Currency.PER10000, lang, pennies).convert(intPart, fractPart);
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
    public String convert(Double theMoney) {
        if (theMoney == null) {
            throw new IllegalArgumentException("theMoney is null");
        }
        Long intPart = theMoney.longValue();
        Long fractPart = Math.round((theMoney - intPart) * NUM100);
        if (currency == Currency.PER1000) {
            fractPart = Math.round((theMoney - intPart) * NUM1000);
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
    public String convert(Long theMoney, Long theKopeiki) {
        if (theMoney == null) {
            throw new IllegalArgumentException("theMoney is null");
        }
        if (theKopeiki == null) {
            throw new IllegalArgumentException("theKopeiki is null");
        }
        StringBuilder money2str = new StringBuilder();
        Long triadNum = 0L;
        Long theTriad;

        Long intPart = theMoney;
        if (intPart == 0) {
            money2str.append(messages.get("0")[0] + " ");
        }
        for(;;) {
            theTriad = intPart % NUM1000;
            money2str.insert(0, triad2Word(theTriad, triadNum, rubSex));
            if (triadNum == 0) {
                Long range10 = (theTriad % NUM100) / NUM10;
                Long range = theTriad % NUM10;
                if (range10 == NUM1) {
                    money2str.append(rubFiveUnit);
                } else {
                    switch (range.byteValue()) {
                    case NUM1:
                        money2str.append(rubOneUnit);
                        break;
                    case NUM2:
                    case NUM3:
                    case NUM4:
                        money2str.append(rubTwoUnit);
                        break;
                    default:
                        money2str.append(rubFiveUnit);
                        break;
                    }
                }
            }
            intPart = intPart / NUM1000;
            triadNum++;
            if (intPart <= 0) {
                break;
            }
        }

        if (pennies == Pennies.TEXT) {
            money2str.append(language == Language.ENG ? " and " : " ").append(theKopeiki == 0 ? messages.get("0")[0] + " " : triad2Word(theKopeiki, 0L, kopSex));
        } else {
            money2str.append(" " + (theKopeiki < 10 ? "0" + theKopeiki : theKopeiki) + " ");
        }
        if (theKopeiki >= NUM11 && theKopeiki <= NUM14) {
            money2str.append(kopFiveUnit);
        } else {
            switch ((byte) (theKopeiki % NUM10)) {
            case NUM1:
                money2str.append(kopOneUnit);
                break;
            case NUM2:
            case NUM3:
            case NUM4:
                money2str.append(kopTwoUnit);
                break;
            default:
                money2str.append(kopFiveUnit);
                break;
            }
        }
        return money2str.toString().trim();
    }

    private String triad2Word(Long triad, Long triadNum, String sex) {
        StringBuilder triadWord = new StringBuilder(NUM100);

        if (triad == 0) {
            return "";
        }

        Long range = check1(triad, triadWord);
        if (language == Language.ENG && triadWord.length() > 0 && triad % NUM10 == 0) {
            triadWord.deleteCharAt(triadWord.length() - 1);
            triadWord.append(" ");
        }

        Long range10 = range;
        range = triad % NUM10;
        check2(triadNum, sex, triadWord, triad, range10);
        switch (triadNum.byteValue()) {
        case NUM0:
            break;
        case NUM1:
        case NUM2:
        case NUM3:
        case NUM4:
            if (range10 == NUM1) {
                triadWord.append(messages.get("1000_10")[triadNum.byteValue() - 1] + " ");
            } else {
                switch (range.byteValue()) {
                case NUM1:
                    triadWord.append(messages.get("1000_1")[triadNum.byteValue() - 1] + " ");
                    break;
                case NUM2:
                case NUM3:
                case NUM4:
                    triadWord.append(messages.get("1000_234")[triadNum.byteValue() - 1] + " ");
                    break;
                default:
                    triadWord.append(messages.get("1000_5")[triadNum.byteValue() - 1] + " ");
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
    private void check2(Long triadNum, String sex, StringBuilder triadWord, Long triad, Long range10) {
        Long range = triad % NUM10;
        if (range10 == 1) {
            triadWord.append(messages.get("10_19")[range.byteValue()] + " ");
        } else {
            switch (range.byteValue()) {
            case NUM1:
                if (triadNum == NUM1) {
                    triadWord.append(messages.get("1")[INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.append(messages.get("1")[INDEX_1] + " ");
                } else if ("M".equals(sex)) {
                    triadWord.append(messages.get("1")[INDEX_2] + " ");
                } else if ("F".equals(sex)) {
                    triadWord.append(messages.get("1")[INDEX_3] + " ");
                }
                break;
            case NUM2:
                if (triadNum == NUM1) {
                    triadWord.append(messages.get("2")[INDEX_0] + " ");
                } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                    triadWord.append(messages.get("2")[INDEX_1] + " ");
                } else if ("M".equals(sex)) {
                    triadWord.append(messages.get("2")[INDEX_2] + " ");
                } else if ("F".equals(sex)) {
                    triadWord.append(messages.get("2")[INDEX_3] + " ");
                }
                break;
            case NUM3:
            case NUM4:
            case NUM5:
            case NUM6:
            case NUM7:
            case NUM8:
            case NUM9:
                triadWord.append(["", "", ""].plus(messages.get("3_9")).flatten()[range.byteValue()] + " ");
                break;
            default:
                break;
            }
        }
    }

    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
    private Long check1(Long triad, StringBuilder triadWord) {
        Long range = triad / NUM100;
        triadWord.append([""].plus(messages.get("100_900")).flatten()[range.byteValue()]);

        range = (triad % NUM100) / NUM10;
        triadWord.append(["", ""].plus(messages.get("20_90")).flatten()[range.byteValue()]);
        return range;
    }

    public static void main(String[] args) {
        String amount = "123.25";
        String language = "ENG";
        String currency = "USD";
        String pennies = "TEXT";
        if (args.length == 0) {
            System.out.println("Usage: groovy MoneyToStr.groovy --amount=123.25 --language=rus|ukr|eng --currency=rur|uah|usd --pennies=text|number");
        } else {
            for (String arg : args) {
                if (arg.startsWith("--amount=")) {
                    amount = arg.substring(9).trim().replace(",", ".");
                } else if (arg.startsWith("--language=")) {
                    language = arg.substring(11).trim().toUpperCase();
                } else if (arg.startsWith("--currency=")) {
                    currency = arg.substring(11).trim().toUpperCase();
                } else if (arg.startsWith("--pennies=")) {
                    pennies = arg.substring(10).trim().toUpperCase();
                }
            }
            String result = new MoneyToStr(Currency.valueOf(currency), Language.valueOf(language), Pennies.valueOf(pennies)).convert(Double.valueOf(amount));
            System.out.println(result);
        }
    }
}
