/*
 * $Id$
 *
 * Copyright 2012 Valentyn V Kolesnikov
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
    private static final double V_1_11D = 1.11D;
    private static final double V_2_02D = 2.02D;
    private static final double V_5_05D = 5.05D;

    private MoneyToStr moneyToStrUAH;
    private MoneyToStr moneyToStrPER100;

    /** setUp. */
    @Before
    public void setUp() {
        moneyToStrUAH = new MoneyToStr(MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
        moneyToStrPER100 = new MoneyToStr(MoneyToStr.Currency.PER100, MoneyToStr.Language.RUS, MoneyToStr.Pennies.TEXT);
    }

    /** checkUAH. */
    @Test
    public void checkUAH() {
        assertEquals("триста гривень 00 копійок", moneyToStrUAH.convert(V_300D));
        assertEquals("дев’ятсот сімдесят вісім трильйонів шістсот " + "тридцять сім мільярдів "
                + "двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч "
                + "п’ятсот сорок гривень 12 копійок", moneyToStrUAH.convert(V_978637287197540L, V_12L));
        assertEquals("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот "
                + "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч "
                + "п’ятсот сорок гривень 12 копійок", moneyToStrUAH.convert(V_234978637287197540L, V_12L));
        assertEquals("одинадцять гривень 00 копійок", moneyToStrUAH.convert(V_11D));
        assertEquals("дванадцять гривень 00 копійок", moneyToStrUAH.convert(V_12D));
        assertEquals("одинадцять гривень 12 копійок", moneyToStrUAH.convert(V_11_12D));
        assertEquals("дванадцять гривень 11 копійок", moneyToStrUAH.convert(V_12_11D));
        assertEquals("триста гривень 00 копійок", moneyToStrUAH.convert(V_300D));
        assertEquals("чотириста гривень 00 копійок", moneyToStrUAH.convert(V_400D));
        assertEquals("сімсот гривень 00 копійок", moneyToStrUAH.convert(V_700D));
        assertEquals("вісімсот гривень 00 копійок", moneyToStrUAH.convert(V_800D));
        assertEquals("п’ятдесят гривень 00 копійок", moneyToStrUAH.convert(V_50D));
        assertEquals("шістдесят гривень 00 копійок", moneyToStrUAH.convert(60D));
        assertEquals("тринадцять гривень 00 копійок", moneyToStrUAH.convert(V_13D));
        assertEquals("чотирнадцять гривень 00 копійок", moneyToStrUAH.convert(V_14D));
        assertEquals("п’ятнадцять гривень 00 копійок", moneyToStrUAH.convert(V_15D));
        assertEquals("шiстнадцять гривень 00 копійок", moneyToStrUAH.convert(V_16D));
        assertEquals("сiмнадцять гривень 00 копійок", moneyToStrUAH.convert(V_17D));
        assertEquals("вiсiмнадцять гривень 00 копійок", moneyToStrUAH.convert(V_18D));
        assertEquals("дев'ятнадцять гривень 00 копійок", moneyToStrUAH.convert(V_19D));
        assertEquals("одна гривня 00 копійок", moneyToStrUAH.convert(1D));
        assertEquals("дві гривні 00 копійок", moneyToStrUAH.convert(V_2D));
        assertEquals("тридцять одна гривня 00 копійок", moneyToStrUAH.convert(V_31D));
        assertEquals("тридцять дві гривні 00 копійок", moneyToStrUAH.convert(V_32D));
        assertEquals("одна тисяча гривень 00 копійок", moneyToStrUAH.convert(1000D));
        assertEquals("дві тисячі гривень 00 копійок", moneyToStrUAH.convert(V_2000D));
        assertEquals("п’ять тисяч гривень 00 копійок", moneyToStrUAH.convert(V_5000D));
        assertEquals("один мільйон гривень 00 копійок", moneyToStrUAH.convert(V_1000000D));
        assertEquals("два мільйона гривень 00 копійок", moneyToStrUAH.convert(V_2000000D));
        assertEquals("п’ять мільйонів гривень 00 копійок", moneyToStrUAH.convert(V_5000000D));
        assertEquals("один мільярд гривень 00 копійок", moneyToStrUAH.convert(V_1000000000D));
        assertEquals("два мільярда гривень 00 копійок", moneyToStrUAH.convert(V_2000000000D));
        assertEquals("п’ять мільярдів гривень 00 копійок", moneyToStrUAH.convert(V_5000000000D));
        assertEquals("один трильйон гривень 00 копійок", moneyToStrUAH.convert(V_1000000000000D));
        assertEquals("два трильйона гривень 00 копійок", moneyToStrUAH.convert(V_2000000000000D));
        assertEquals("п’ять трильйонів гривень 00 копійок", moneyToStrUAH.convert(V_5000000000000D));
        assertEquals("одна гривня 01 копійка", moneyToStrUAH.convert(V_1_01D));
        assertEquals("одна гривня 02 копійки", moneyToStrUAH.convert(V_1_02D));
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

    /** checkException. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException() {
        moneyToStrUAH = new MoneyToStr(null, null, null);
    }

    /** checkException2. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException2() {
        moneyToStrUAH = new MoneyToStr(MoneyToStr.Currency.UAH, null, null);
    }

    /** checkException3. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException3() {
        moneyToStrUAH.convert(null);
    }

    /** checkException4. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException4() {
        moneyToStrUAH.convert(1L, null);
    }

    /** checkException5. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException5() {
        moneyToStrUAH.convert(null, 1L);
    }

    /** checkException6. */
    @Test(expected = IllegalArgumentException.class)
    public void checkException6() {
        moneyToStrUAH.convert(null, null);
    }
}
