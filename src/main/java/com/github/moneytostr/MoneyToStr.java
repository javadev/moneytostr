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
package com.github.moneytostr;

import java.io.IOException;
import java.io.InputStream;

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn V Kolesnikov
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
    private static final int NUM12 = 12;
    private static final int NUM100 = 100;
    private static final int NUM1000 = 1000;
    private static final int NUM10000 = 10000;
    private java.util.Map<String, String[]> messages = new java.util.LinkedHashMap<String, String[]>();
    private String rubOneUnit;
    private String rubTwoUnit;
    private String rubFiveUnit;
    private String rubSex;
    private String kopOneUnit;
    private String kopTwoUnit;
    private String kopFiveUnit;
    private String kopSex;
    private final Pennies pennies;
    private final Currency currency;

    static {
        javax.xml.parsers.DocumentBuilderFactory docFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance();
        InputStream inputStream = null;

        try {
            javax.xml.parsers.DocumentBuilder xmlDocBuilder = docFactory.newDocumentBuilder();
            inputStream = MoneyToStr.class.getResourceAsStream("currlist.xml");
            xmlDoc = xmlDocBuilder.parse(inputStream);
        } catch (org.xml.sax.SAXException sxe) {
            throw new UnsupportedOperationException(sxe);
        } catch (javax.xml.parsers.ParserConfigurationException pce) {
            throw new UnsupportedOperationException(pce);
        } catch (java.io.IOException ioe) {
            throw new UnsupportedOperationException(ioe);
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }

    /** Currency. */
    public enum Currency {
        /**.*/
        UAH,
        /**.*/
        RUR,
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
        UKR
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
     * @param currency the currency (UAH, RUR)
     * @param language the language (UKR, RUS)
     * @param pennies the pennies (NUMBER, TEXT)
     */
    public MoneyToStr(Currency currency, Language language, Pennies pennies) {
        if (currency == null) {
            throw new IllegalArgumentException("Currency code is null");
        }
        if (language == null) {
            throw new IllegalArgumentException("Language is null");
        }
        if (pennies == null) {
            throw new IllegalArgumentException("Pennies is null");
        }
        this.pennies = pennies;
        this.currency = currency;
        String theISOstr = currency.name();
        org.w3c.dom.Element languageElement = (org.w3c.dom.Element)
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

        if (theISOElement == null) {
            throw new IllegalArgumentException("Currency not found " + theISOstr);
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
        if (amount == null) {
            throw new IllegalArgumentException("amount is null");
        }
        if (lang == null) {
            throw new IllegalArgumentException("Language is null");
        }
        Long intPart = amount.longValue();
        Long fractPart = 0L;
        String result;
        if (amount.floatValue() == amount.intValue()) {
            result = new MoneyToStr(Currency.PER10, lang, Pennies.TEXT).convert(amount.longValue(), 0L);
        } else if (Double.valueOf(amount * NUM10).floatValue() == Double.valueOf(amount * NUM10).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM10);
            result = new MoneyToStr(Currency.PER10, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else if (Double.valueOf(amount * NUM100).floatValue() == Double.valueOf(amount * NUM100).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM100);
            result = new MoneyToStr(Currency.PER100, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else if (Double.valueOf(amount * NUM1000).floatValue() == Double.valueOf(amount * NUM1000).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM1000);
            result = new MoneyToStr(Currency.PER1000, lang, Pennies.TEXT).convert(intPart, fractPart);
        } else {
            fractPart = Math.round((amount - intPart) * NUM10000);
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
        do {
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
        } while (intPart > 0);

        if (pennies == Pennies.TEXT) {
            money2str.append(" ").append(theKopeiki == 0 ? messages.get("0")[0] + " " : triad2Word(theKopeiki, 0L, kopSex));
        } else {
            money2str.append(" " + (theKopeiki < 10 ? "0" + theKopeiki : theKopeiki) + " ");
        }
        if (theKopeiki == NUM11 || theKopeiki == NUM12) {
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
                triadWord.append(concat(new String[] {"", "", ""}, messages.get("3_9"))[range.byteValue()] + " ");
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
        triadWord.append(concat(new String[] {""}, messages.get("100_900"))[range.byteValue()]);

        range = (triad % NUM100) / NUM10;
        triadWord.append(concat(new String[] {"", ""}, messages.get("20_90"))[range.byteValue()]);
        return range;
    }

    private <T> T[] concat(T[] first, T[] second) {
        T[] result = java.util.Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
