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

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * MoneyToStr unit test.
 *
 * @author Valentyn V Kolesnikov
 * @version $Revision$ $Date$
 */
public class MoneyToStrTest {

    private static final long V_12L = 12L;
    private static final long V_123L = 123L;
    private static final double V_11D = 11D;
    private static final double V_12D = 12D;
    private static final double V_11_12D = 11.12D;
    private static final double V_12_11D = 12.11D;
    private static final double V_300D = 300D;
    private static final double V_400D = 400D;
    private static final double V_700D = 700D;
    private static final double V_800D = 800D;
    private static final double V_50D = 50D;
    private static final double V_13D = 13D;
    private static final double V_14D = 14D;
    private static final double V_15D = 15D;
    private static final double V_16D = 16D;
    private static final double V_17D = 17D;
    private static final double V_18D = 18D;
    private static final double V_19D = 19D;
    private static final double V_31D = 31D;
    private static final long V_978637287197540L = 978637287197540L;
    private static final long V_234978637287197540L = 234978637287197540L;
    private static final double V_32D = 32D;
    private static final double V_2000D = 2000D;
    private static final double V_5000D = 5000D;
    private static final double V_1000000D = 1000000D;
    private static final double V_2000000D = 2000000D;
    private static final double V_5000000D = 5000000D;
    private static final double V_1000000000D = 1000000000D;
    private static final double V_2000000000D = 2000000000D;
    private static final double V_5000000000D = 5000000000D;
    private static final double V_1000000000000D = 1000000000000D;
    private static final double V_2000000000000D = 2000000000000D;
    private static final double V_5000000000000D = 5000000000000D;
    private static final double V_1D = 1D;
    private static final double V_2D = 2D;
    private static final double V_3D = 3D;
    private static final double V_4D = 4D;
    private static final double V_5D = 5D;
    private static final double V_6D = 6D;
    private static final double V_7D = 7D;
    private static final double V_8D = 8D;
    private static final double V_9D = 9D;
    private static final double V_123D = 123D;
    private static final double V_1_1D = 1.1D;
    private static final double V_1_01D = 1.01D;
    private static final double V_1_02D = 1.02D;
    private static final double V_1_10D = 1.10D;
    private static final double V_1_11D = 1.11D;
    private static final double V_1_12D = 1.12D;
    private static final double V_1_13D = 1.13D;
    private static final double V_1_14D = 1.14D;
    private static final double V_2_02D = 2.02D;
    private static final double V_5_05D = 5.05D;
    private static final double V_5_0005D = 5.0005D;
    private static final double V_777_77D = 777.77D;
    private static final double V_1234567_89D = 1234567.89D;

    private MoneyToStr moneyToStrUAH;
    private MoneyToStr moneyToStrUAHRUS;
    private MoneyToStr moneyToStrUAHENG;
    private MoneyToStr moneyToStrPLZPOL;
    private MoneyToStr moneyToStrRUR;
    private MoneyToStr moneyToStrRURRUS;
    private MoneyToStr moneyToStrRURENG;
    private MoneyToStr moneyToStrUSD;
    private MoneyToStr moneyToStrUSDRUS;
    private MoneyToStr moneyToStrUSDENG;
    private MoneyToStr moneyToStrEURRUS;
    private MoneyToStr moneyToStrPER100;
    private MoneyToStr moneyToStrPER1000;
    private MoneyToStr moneyToStrCustom;

    /** setUp. */
    @Before
    public void setUp() {
        moneyToStrUAH =
                new MoneyToStr(
                        MoneyToStr.Currency.UAH,
                        MoneyToStr.Language.UKR,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrUAHRUS =
                new MoneyToStr(
                        MoneyToStr.Currency.UAH,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrUAHENG =
                new MoneyToStr(
                        MoneyToStr.Currency.UAH,
                        MoneyToStr.Language.ENG,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrPLZPOL =
                new MoneyToStr(
                        MoneyToStr.Currency.PLZ,
                        MoneyToStr.Language.POL,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrRUR =
                new MoneyToStr(
                        MoneyToStr.Currency.RUR,
                        MoneyToStr.Language.UKR,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrRURRUS =
                new MoneyToStr(
                        MoneyToStr.Currency.RUR,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrRURENG =
                new MoneyToStr(
                        MoneyToStr.Currency.RUR,
                        MoneyToStr.Language.ENG,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrUSD =
                new MoneyToStr(
                        MoneyToStr.Currency.USD,
                        MoneyToStr.Language.UKR,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrUSDRUS =
                new MoneyToStr(
                        MoneyToStr.Currency.USD,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrUSDENG =
                new MoneyToStr(
                        MoneyToStr.Currency.USD, MoneyToStr.Language.ENG, MoneyToStr.Pennies.TEXT);
        moneyToStrEURRUS =
                new MoneyToStr(
                        MoneyToStr.Currency.EUR,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.NUMBER);
        moneyToStrPER100 =
                new MoneyToStr(
                        MoneyToStr.Currency.PER100,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.TEXT);
        moneyToStrPER1000 =
                new MoneyToStr(
                        MoneyToStr.Currency.PER1000,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.TEXT);
        moneyToStrCustom =
                new MoneyToStr(
                        MoneyToStr.Currency.RUR,
                        MoneyToStr.Language.RUS,
                        MoneyToStr.Pennies.NUMBER,
                        new String[] {
                            "евро", "евро", "евро", "M", "евроцент", "евроцента", "евроцентов", "M"
                        });
    }

    /** checkUAHUKR. */
    @Test
    public void checkUAHUKR() {
        assertEquals("триста гривень 00 копійок", moneyToStrUAH.convert(V_300D));
        assertEquals(
                "дев'ятсот сімдесят вісім трильйонів шістсот "
                        + "тридцять сім мільярдів "
                        + "двісті вісімдесят сім мільйонів сто "
                        + "дев'яносто сім тисяч "
                        + "п'ятсот сорок гривень 12 копійок",
                moneyToStrUAH.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двісті тридцять чотири ??? дев'ятсот сімдесят вісім трильйонів шістсот "
                        + "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто "
                        + "дев'яносто сім тисяч "
                        + "п'ятсот сорок гривень 12 копійок",
                moneyToStrUAH.convert(V_234978637287197540L, V_12L));
        assertEquals("одинадцять гривень 00 копійок", moneyToStrUAH.convert(V_11D));
        assertEquals("дванадцять гривень 00 копійок", moneyToStrUAH.convert(V_12D));
        assertEquals("одинадцять гривень 12 копійок", moneyToStrUAH.convert(V_11_12D));
        assertEquals("дванадцять гривень 11 копійок", moneyToStrUAH.convert(V_12_11D));
        assertEquals("триста гривень 00 копійок", moneyToStrUAH.convert(V_300D));
        assertEquals("чотириста гривень 00 копійок", moneyToStrUAH.convert(V_400D));
        assertEquals("сімсот гривень 00 копійок", moneyToStrUAH.convert(V_700D));
        assertEquals("вісімсот гривень 00 копійок", moneyToStrUAH.convert(V_800D));
        assertEquals("п'ятдесят гривень 00 копійок", moneyToStrUAH.convert(V_50D));
        assertEquals("шістдесят гривень 00 копійок", moneyToStrUAH.convert(60D));
        assertEquals("тринадцять гривень 00 копійок", moneyToStrUAH.convert(V_13D));
        assertEquals("чотирнадцять гривень 00 копійок", moneyToStrUAH.convert(V_14D));
        assertEquals("п'ятнадцять гривень 00 копійок", moneyToStrUAH.convert(V_15D));
        assertEquals("шістнадцять гривень 00 копійок", moneyToStrUAH.convert(V_16D));
        assertEquals("сімнадцять гривень 00 копійок", moneyToStrUAH.convert(V_17D));
        assertEquals("вісімнадцять гривень 00 копійок", moneyToStrUAH.convert(V_18D));
        assertEquals("дев'ятнадцять гривень 00 копійок", moneyToStrUAH.convert(V_19D));
        assertEquals("одна гривня 00 копійок", moneyToStrUAH.convert(1D));
        assertEquals("дві гривні 00 копійок", moneyToStrUAH.convert(V_2D));
        assertEquals("тридцять одна гривня 00 копійок", moneyToStrUAH.convert(V_31D));
        assertEquals("тридцять дві гривні 00 копійок", moneyToStrUAH.convert(V_32D));
        assertEquals("одна тисяча гривень 00 копійок", moneyToStrUAH.convert(1000D));
        assertEquals("дві тисячі гривень 00 копійок", moneyToStrUAH.convert(V_2000D));
        assertEquals("п'ять тисяч гривень 00 копійок", moneyToStrUAH.convert(V_5000D));
        assertEquals("один мільйон гривень 00 копійок", moneyToStrUAH.convert(V_1000000D));
        assertEquals("два мільйони гривень 00 копійок", moneyToStrUAH.convert(V_2000000D));
        assertEquals("п'ять мільйонів гривень 00 копійок", moneyToStrUAH.convert(V_5000000D));
        assertEquals("один мільярд гривень 00 копійок", moneyToStrUAH.convert(V_1000000000D));
        assertEquals("два мільярди гривень 00 копійок", moneyToStrUAH.convert(V_2000000000D));
        assertEquals("п'ять мільярдів гривень 00 копійок", moneyToStrUAH.convert(V_5000000000D));
        assertEquals("один трильйон гривень 00 копійок", moneyToStrUAH.convert(V_1000000000000D));
        assertEquals("два трильйони гривень 00 копійок", moneyToStrUAH.convert(V_2000000000000D));
        assertEquals(
                "п'ять трильйонів гривень 00 копійок", moneyToStrUAH.convert(V_5000000000000D));
        assertEquals("одна гривня 01 копійка", moneyToStrUAH.convert(V_1_01D));
        assertEquals("одна гривня 02 копійки", moneyToStrUAH.convert(V_1_02D));
        assertEquals("одна гривня 10 копійок", moneyToStrUAH.convert(V_1_10D));
        assertEquals("одна гривня 11 копійок", moneyToStrUAH.convert(V_1_11D));
        assertEquals("одна гривня 12 копійок", moneyToStrUAH.convert(V_1_12D));
        assertEquals("одна гривня 13 копійок", moneyToStrUAH.convert(V_1_13D));
        assertEquals("одна гривня 14 копійок", moneyToStrUAH.convert(V_1_14D));
    }

    @Test
    public void checkPLZPOL() {
        assertEquals("trzysta złotych 00 groszy", moneyToStrPLZPOL.convert(V_300D));
        assertEquals(
                "dziewięćset siedemdziesiąt osiem trylionów sześćset "
                        + "trzydzieści siedem miliardów "
                        + "dwieście osiemdziesiąt siedem milionów sto "
                        + "dziewięćdziesiąt siedem tysięcy "
                        + "pięćset czterdzieści złotych 12 groszy",
                moneyToStrPLZPOL.convert(V_978637287197540L, V_12L));
        assertEquals(
                "dwieście trzydzieści cztery ??? dziewięćset siedemdziesiąt osiem trylionów sześćset "
                        + "trzydzieści siedem miliardów dwieście osiemdziesiąt siedem milionów sto "
                        + "dziewięćdziesiąt siedem tysięcy "
                        + "pięćset czterdzieści złotych 12 groszy",
                moneyToStrPLZPOL.convert(V_234978637287197540L, V_12L));
        assertEquals("jedenaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_11D));
        assertEquals("dwanaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_12D));
        assertEquals("jedenaście złotych 12 groszy", moneyToStrPLZPOL.convert(V_11_12D));
        assertEquals("dwanaście złotych 11 groszy", moneyToStrPLZPOL.convert(V_12_11D));
        assertEquals("trzysta złotych 00 groszy", moneyToStrPLZPOL.convert(V_300D));
        assertEquals("czterysta złotych 00 groszy", moneyToStrPLZPOL.convert(V_400D));
        assertEquals("siedemset złotych 00 groszy", moneyToStrPLZPOL.convert(V_700D));
        assertEquals("osiemset złotych 00 groszy", moneyToStrPLZPOL.convert(V_800D));
        assertEquals("pięćdziesiąt złotych 00 groszy", moneyToStrPLZPOL.convert(V_50D));
        assertEquals("sześćdziesiąt złotych 00 groszy", moneyToStrPLZPOL.convert(60D));
        assertEquals("trzynaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_13D));
        assertEquals("czternaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_14D));
        assertEquals("piętnaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_15D));
        assertEquals("szesnaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_16D));
        assertEquals("siedemnaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_17D));
        assertEquals("osiemnaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_18D));
        assertEquals("dziewiętnaście złotych 00 groszy", moneyToStrPLZPOL.convert(V_19D));
        assertEquals("jeden złotych 00 groszy", moneyToStrPLZPOL.convert(1D));
        assertEquals("dwie złote 00 groszy", moneyToStrPLZPOL.convert(V_2D));
        assertEquals("trzydzieści jeden złotych 00 groszy", moneyToStrPLZPOL.convert(V_31D));
        assertEquals("trzydzieści dwie złote 00 groszy", moneyToStrPLZPOL.convert(V_32D));
        assertEquals("jeden tysiąc złotych 00 groszy", moneyToStrPLZPOL.convert(1000D));
        assertEquals("dwie tysiące złotych 00 groszy", moneyToStrPLZPOL.convert(V_2000D));
        assertEquals("pięć tysięcy złotych 00 groszy", moneyToStrPLZPOL.convert(V_5000D));
        assertEquals("jeden milion złotych 00 groszy", moneyToStrPLZPOL.convert(V_1000000D));
        assertEquals("dwa miliony złotych 00 groszy", moneyToStrPLZPOL.convert(V_2000000D));
        assertEquals("pięć milionów złotych 00 groszy", moneyToStrPLZPOL.convert(V_5000000D));
        assertEquals("jeden miliard złotych 00 groszy", moneyToStrPLZPOL.convert(V_1000000000D));
        assertEquals("dwa miliardy złotych 00 groszy", moneyToStrPLZPOL.convert(V_2000000000D));
        assertEquals("pięć miliardów złotych 00 groszy", moneyToStrPLZPOL.convert(V_5000000000D));
        assertEquals("jeden trylion złotych 00 groszy", moneyToStrPLZPOL.convert(V_1000000000000D));
        assertEquals("dwa tryliony złotych 00 groszy", moneyToStrPLZPOL.convert(V_2000000000000D));
        assertEquals(
                "pięć trylionów złotych 00 groszy", moneyToStrPLZPOL.convert(V_5000000000000D));
        assertEquals("jeden złotych 01 grosz", moneyToStrPLZPOL.convert(V_1_01D));
        assertEquals("jeden złotych 02 grosze", moneyToStrPLZPOL.convert(V_1_02D));
        assertEquals("jeden złotych 10 groszy", moneyToStrPLZPOL.convert(V_1_10D));
        assertEquals("jeden złotych 11 groszy", moneyToStrPLZPOL.convert(V_1_11D));
        assertEquals("jeden złotych 12 groszy", moneyToStrPLZPOL.convert(V_1_12D));
        assertEquals("jeden złotych 13 groszy", moneyToStrPLZPOL.convert(V_1_13D));
        assertEquals("jeden złotych 14 groszy", moneyToStrPLZPOL.convert(V_1_14D));
    }

    /** checkUAHUKR minus. */
    @Test
    public void checkUAHUKMinus() {
        assertEquals("мінус триста гривень 00 копійок", moneyToStrUAH.convert(-V_300D));
        assertEquals("мінус одинадцять гривень 12 копійок", moneyToStrUAH.convert(-V_11_12D));
    }

    /** checkUAHRUS. */
    @Test
    public void checkUAHRUS() {
        assertEquals("триста гривень 00 копеек", moneyToStrUAHRUS.convert(V_300D));
        assertEquals(
                "девятьсот семьдесят восемь триллионов шестьсот тридцать семь миллиардов двести восемьдесят семь миллионов с"
                        + "то девяносто семь тысяч пятьсот сорок гривень 12 копеек",
                moneyToStrUAHRUS.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двести тридцать четыре ??? девятьсот семьдесят восемь триллионов шестьсот тридца"
                        + "ть семь миллиардов двести восемьдесят семь миллионов сто девяносто семь тысяч пятьсот сорок гривень 12 копеек",
                moneyToStrUAHRUS.convert(V_234978637287197540L, V_12L));
    }

    /** checkUAHUKR minus. */
    @Test
    public void checkUAHRUSMinus() {
        assertEquals("минус триста гривень 00 копеек", moneyToStrUAHRUS.convert(-V_300D));
        assertEquals("минус одиннадцать гривень 12 копеек", moneyToStrUAHRUS.convert(-V_11_12D));
    }

    /** checkUAHENG. */
    @Test
    public void checkUAHENG() {
        assertEquals("three hundred hryvnias 00 kopecks", moneyToStrUAHENG.convert(V_300D));
        assertEquals(
                "nine hundred seventy-eight trillion six hundred thirty-seven billion two hundred eighty-seven million"
                        + " one hundred ninety-seven thousand five hundred forty hryvnias 12 kopecks",
                moneyToStrUAHENG.convert(V_978637287197540L, V_12L));
        assertEquals(
                "two hundred thirty-four ??? nine hundred seventy-eight trillion six hundred"
                        + " thirty-seven billion two hundred eighty-seven million one hundred ninety-seven"
                        + " thousand five hundred forty hryvnias 12 kopecks",
                moneyToStrUAHENG.convert(V_234978637287197540L, V_12L));
    }

    /** checkRURUKR. */
    @Test
    public void checkRURUKR() {
        assertEquals("триста рублів 00 копійок", moneyToStrRUR.convert(V_300D));
        assertEquals(
                "дев'ятсот сімдесят вісім трильйонів шістсот тридцять сім мільярдів двісті вісімдесят сім мільйонів сто"
                        + " дев'яносто сім тисяч п'ятсот сорок рублів 12 копійок",
                moneyToStrRUR.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двісті тридцять чотири ??? дев'ятсот сімдесят вісім трильйонів шістсот "
                        + "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто "
                        + "дев'яносто сім тисяч "
                        + "п'ятсот сорок рублів 12 копійок",
                moneyToStrRUR.convert(V_234978637287197540L, V_12L));
    }

    /** checkRURRUS. */
    @Test
    public void checkRURRUS() {
        assertEquals("триста рублей 00 копеек", moneyToStrRURRUS.convert(V_300D));
        assertEquals(
                "девятьсот семьдесят восемь триллионов шестьсот тридцать семь миллиардов двести восемьдесят семь миллионов с"
                        + "то девяносто семь тысяч пятьсот сорок рублей 12 копеек",
                moneyToStrRURRUS.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двести тридцать четыре ??? девятьсот семьдесят восемь триллионов шестьсот тридца"
                        + "ть семь миллиардов двести восемьдесят семь миллионов сто девяносто семь тысяч пятьсот сорок рублей 12 копеек",
                moneyToStrRURRUS.convert(V_234978637287197540L, V_12L));
        assertEquals(
                "семьсот семьдесят семь рублей 77 копеек", moneyToStrRURRUS.convert(V_777_77D));
    }

    @Test
    public void checkRURENG() {
        assertEquals("three hundred rubles 00 kopecks", moneyToStrRURENG.convert(V_300D));
        assertEquals(
                "nine hundred seventy-eight trillion six hundred thirty-seven billion two hundred eighty-seven million"
                        + " one hundred ninety-seven thousand five hundred forty rubles 12 kopecks",
                moneyToStrRURENG.convert(V_978637287197540L, V_12L));
        assertEquals(
                "two hundred thirty-four ??? nine hundred seventy-eight trillion six hundred"
                        + " thirty-seven billion two hundred eighty-seven million one hundred ninety-seven"
                        + " thousand five hundred forty rubles 12 kopecks",
                moneyToStrRURENG.convert(V_234978637287197540L, V_12L));
    }

    /** checkUSDUKR. */
    @Test
    public void checkUSDUKR() {
        assertEquals("триста доларів 00 центів", moneyToStrUSD.convert(V_300D));
        assertEquals(
                "дев'ятсот сімдесят вісім трильйонів шістсот тридцять сім мільярдів двісті вісімдесят сім мільйонів сто"
                        + " дев'яносто сім тисяч п'ятсот сорок доларів 12 центів",
                moneyToStrUSD.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двісті тридцять чотири ??? дев'ятсот сімдесят вісім трильйонів шістсот "
                        + "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто "
                        + "дев'яносто сім тисяч "
                        + "п'ятсот сорок доларів 12 центів",
                moneyToStrUSD.convert(V_234978637287197540L, V_12L));
    }

    /** checkUSDRUS. */
    @Test
    public void checkUSDRUS() {
        assertEquals("триста долларов 00 центов", moneyToStrUSDRUS.convert(V_300D));
        assertEquals(
                "девятьсот семьдесят восемь триллионов шестьсот тридцать семь миллиардов двести восемьдесят семь миллионов с"
                        + "то девяносто семь тысяч пятьсот сорок долларов 12 центов",
                moneyToStrUSDRUS.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двести тридцать четыре ??? девятьсот семьдесят восемь триллионов шестьсот тридца"
                        + "ть семь миллиардов двести восемьдесят семь миллионов сто девяносто семь тысяч пятьсот сорок долларов 12 центов",
                moneyToStrUSDRUS.convert(V_234978637287197540L, V_12L));
    }

    /** checkEURRUS. */
    @Test
    public void checkEURRUS() {
        assertEquals("триста евро 00 центов", moneyToStrEURRUS.convert(V_300D));
        assertEquals(
                "девятьсот семьдесят восемь триллионов шестьсот тридцать семь миллиардов двести восемьдесят семь миллионов с"
                        + "то девяносто семь тысяч пятьсот сорок евро 12 центов",
                moneyToStrEURRUS.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двести тридцать четыре ??? девятьсот семьдесят восемь триллионов шестьсот тридца"
                        + "ть семь миллиардов двести восемьдесят семь миллионов сто девяносто семь тысяч пятьсот сорок евро 12 центов",
                moneyToStrEURRUS.convert(V_234978637287197540L, V_12L));
    }

    /** checkUSD_ENG. */
    @Test
    public void checkUSDENG() {
        assertEquals("one dollar and zero cents", moneyToStrUSDENG.convert(1D));
        assertEquals("two dollars and zero cents", moneyToStrUSDENG.convert(2D));
        assertEquals("three dollars and zero cents", moneyToStrUSDENG.convert(3D));
        assertEquals("four dollars and zero cents", moneyToStrUSDENG.convert(4D));
        assertEquals("five dollars and zero cents", moneyToStrUSDENG.convert(5D));
        assertEquals("six dollars and zero cents", moneyToStrUSDENG.convert(6D));
        assertEquals("seven dollars and zero cents", moneyToStrUSDENG.convert(7D));
        assertEquals("eight dollars and zero cents", moneyToStrUSDENG.convert(8D));
        assertEquals("nine dollars and zero cents", moneyToStrUSDENG.convert(9D));
        assertEquals("ten dollars and zero cents", moneyToStrUSDENG.convert(10D));
        assertEquals("eleven dollars and zero cents", moneyToStrUSDENG.convert(11D));
        assertEquals("twelve dollars and zero cents", moneyToStrUSDENG.convert(12D));
        assertEquals("thirteen dollars and zero cents", moneyToStrUSDENG.convert(13D));
        assertEquals(
                "twenty-seven trillion four hundred fifty-one billion six hundred thirty-two "
                        + "million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents",
                moneyToStrUSDENG.convert(27451632459870.49D));
        assertEquals("zero dollars and zero cents", moneyToStrUSDENG.convert(0D));
        assertEquals("four dollars and zero cents", moneyToStrUSDENG.convert(4D));
        assertEquals("ten dollars and zero cents", moneyToStrUSDENG.convert(10D));
        assertEquals("twelve dollars and zero cents", moneyToStrUSDENG.convert(12D));
        assertEquals("one hundred dollars and zero cents", moneyToStrUSDENG.convert(100D));
        assertEquals("one hundred eight dollars and zero cents", moneyToStrUSDENG.convert(108D));
        assertEquals(
                "two hundred ninety-nine dollars and zero cents", moneyToStrUSDENG.convert(299D));
        assertEquals("one thousand dollars and zero cents", moneyToStrUSDENG.convert(1000D));
        assertEquals("one thousand three dollars and zero cents", moneyToStrUSDENG.convert(1003D));
        assertEquals("two thousand forty dollars and zero cents", moneyToStrUSDENG.convert(2040D));
        assertEquals(
                "forty-five thousand two hundred thirteen dollars and zero cents",
                moneyToStrUSDENG.convert(45213D));
        assertEquals(
                "one hundred thousand dollars and zero cents", moneyToStrUSDENG.convert(100000D));
        assertEquals(
                "one hundred thousand five dollars and zero cents",
                moneyToStrUSDENG.convert(100005D));
        assertEquals(
                "one hundred thousand ten dollars and zero cents",
                moneyToStrUSDENG.convert(100010D));
        assertEquals(
                "two hundred two thousand twenty dollars and zero cents",
                moneyToStrUSDENG.convert(202020D));
        assertEquals(
                "two hundred two thousand twenty-two dollars and zero cents",
                moneyToStrUSDENG.convert(202022D));
        assertEquals(
                "nine hundred ninety-nine thousand nine hundred ninety-nine dollars and zero cents",
                moneyToStrUSDENG.convert(999999D));
        assertEquals("one million dollars and zero cents", moneyToStrUSDENG.convert(1000000D));
        assertEquals("one million one dollar and zero cents", moneyToStrUSDENG.convert(1000001D));
        assertEquals("ten million dollars and zero cents", moneyToStrUSDENG.convert(10000000D));
        assertEquals(
                "ten million seven dollars and zero cents", moneyToStrUSDENG.convert(10000007D));
        assertEquals(
                "ninety-nine million nine hundred ninety-nine thousand nine hundred ninety-nine dollars and zero cents",
                moneyToStrUSDENG.convert(99999999D));
        assertEquals(
                "one million two hundred thirty-four thousand five hundred sixty-seven dollars and eighty-nine cents",
                moneyToStrUSDENG.convert(V_1234567_89D));
    }

    /** checkEURRUSCustom. */
    @Test
    public void checkEURRUSCustom() {
        assertEquals("триста евро 00 евроцентов", moneyToStrCustom.convert(V_300D));
        assertEquals(
                "девятьсот семьдесят восемь триллионов шестьсот тридцать семь миллиардов двести восемьдесят семь миллионов с"
                        + "то девяносто семь тысяч пятьсот сорок евро 12 евроцентов",
                moneyToStrCustom.convert(V_978637287197540L, V_12L));
        assertEquals(
                "двести тридцать четыре ??? девятьсот семьдесят восемь триллионов шестьсот тридца"
                        + "ть семь миллиардов двести восемьдесят семь миллионов сто девяносто семь тысяч пятьсот сорок евро 12 евроцентов",
                moneyToStrCustom.convert(V_234978637287197540L, V_12L));
    }

    /** checkPER100. */
    @Test
    public void checkPER100() {
        assertEquals("одна целая, одна сотая процента", moneyToStrPER100.convert(V_1_01D));
        assertEquals("одна целая, десять сотых процента", moneyToStrPER100.convert(V_1_1D));
        assertEquals("одна целая, две сотых процента", moneyToStrPER100.convert(V_1_02D));
        assertEquals("одна целая, одиннадцать сотых процента", moneyToStrPER100.convert(V_1_11D));
        assertEquals("две целых, две сотых процента", moneyToStrPER100.convert(V_2_02D));
        assertEquals("пять целых, пять сотых процента", moneyToStrPER100.convert(V_5_05D));
    }

    @Test
    public void checkPER1000() {
        assertEquals(
                "двенадцать целых, триста сорок шесть тысячных процента",
                moneyToStrPER1000.convert(12.346));
    }

    @Test
    public void percentToStr() {
        assertEquals(
                "двенадцать целых, ноль десятых процента",
                MoneyToStr.percentToStr(12D, MoneyToStr.Language.RUS));
    }

    /** check percentToStr. */
    @Test
    public void checkPercentToStrRus() {
        assertEquals(
                "одна целая, одна сотая процента",
                MoneyToStr.percentToStr(V_1_01D, MoneyToStr.Language.RUS));
        assertEquals(
                "одна целая, одна десятая процента",
                MoneyToStr.percentToStr(V_1_1D, MoneyToStr.Language.RUS));
        assertEquals(
                "одна целая, две сотых процента",
                MoneyToStr.percentToStr(V_1_02D, MoneyToStr.Language.RUS));
        assertEquals(
                "одна целая, одиннадцать сотых процента",
                MoneyToStr.percentToStr(V_1_11D, MoneyToStr.Language.RUS));
        assertEquals(
                "две целых, две сотых процента",
                MoneyToStr.percentToStr(V_2_02D, MoneyToStr.Language.RUS));
        assertEquals(
                "пять целых, пять сотых процента",
                MoneyToStr.percentToStr(V_5_05D, MoneyToStr.Language.RUS));
        assertEquals(
                "пять целых, пять десятитысячных процента",
                MoneyToStr.percentToStr(V_5_0005D, MoneyToStr.Language.RUS));
        assertEquals(
                "двенадцать целых, триста сорок шесть тысячных процента",
                MoneyToStr.percentToStr(12.346, MoneyToStr.Language.RUS));
        assertEquals(
                "шестнадцать целых, сто восемьдесят восемь тысячных процента",
                MoneyToStr.percentToStr(16.188, MoneyToStr.Language.RUS));
    }

    /** check main. */
    @Test
    public void main() {
        MoneyToStr.main(new String[] {});
        MoneyToStr.main(
                new String[] {
                    "--amount=123.25", "--language=rus", "--currency=rur", "--pennies=text"
                });
        MoneyToStr.main(new String[] {"--amount=123.25", "--language=rus", "--currency=rur", ""});
        moneyToStrUAH.getMessages();
        moneyToStrUAH.getRubShortUnit();
        moneyToStrUAH.getLanguage();
    }

    @Test(expected = MoneyToStr.FromJson.ParseException.class)
    public void initJsonMap() {
        MoneyToStr.initJsonMap("<1<2<3");
    }

    /** checkException. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException() {
        new MoneyToStr(null, null, null);
    }

    /** checkException2. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException2() {
        new MoneyToStr(MoneyToStr.Currency.UAH, null, null);
    }

    /** checkException3. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException3() {
        new MoneyToStr(MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, null);
    }

    /** checkException4. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException4() {
        moneyToStrUAH.convert(null);
    }

    /** checkException5. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException5() {
        moneyToStrUAH.convert(1L, null);
    }

    /** checkException6. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException6() {
        moneyToStrUAH.convert(null, 1L);
    }

    /** checkException7. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException7() {
        moneyToStrUAH.convert(null, null);
    }

    /** checkException8. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException8() {
        moneyToStrUAH.percentToStr(null, null);
    }

    /** checkException9. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException9() {
        moneyToStrUAH.percentToStr(123D, null);
    }

    /** checkException10. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException10() {
        moneyToStrUAH.percentToStr(123D, MoneyToStr.Language.UKR, null);
    }

    /** checkException11. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException11() {
        moneyToStrUAH.percentToStr(null, MoneyToStr.Language.UKR);
    }

    /** checkException12. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException12() {
        new MoneyToStr(null, null, null, null);
    }

    /** checkException13. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException13() {
        new MoneyToStr(MoneyToStr.Currency.UAH, null, null, null);
    }

    /** checkException14. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException14() {
        new MoneyToStr(MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, null, null);
    }

    /** checkException15. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException15() {
        new MoneyToStr(
                MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.TEXT, null);
    }

    /** checkException16. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException16() {
        new MoneyToStr(
                MoneyToStr.Currency.UAH,
                MoneyToStr.Language.UKR,
                MoneyToStr.Pennies.TEXT,
                new String[] {""});
    }

    /** custom. */
    @Test
    public void custom() {
        moneyToStrUAH =
                new MoneyToStr(
                        MoneyToStr.Currency.UAH,
                        MoneyToStr.Language.UKR,
                        MoneyToStr.Pennies.TEXT,
                        new String[] {"", "", "", "", "", "", "", ""});
        assertEquals("нуль", moneyToStrUAH.convert(V_1D));
        assertEquals("нуль", moneyToStrUAH.convert(V_2D));
    }
}
