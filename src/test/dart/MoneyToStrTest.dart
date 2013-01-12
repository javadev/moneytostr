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
 
import '../../main/dart/moneytostr.dart';
/**
 * MoneyToStr unit test.
 *
 * @author Valentyn V Kolesnikov
 * @version $Revision$ $Date$
 */
class MoneyToStrTest {
    const long V_12L = 12;
    const long V_123L = 123;
    const double V_11D = 11;
    const double V_12D = 12;
    const double V_11_12D = 11.12;
    const double V_12_11D = 12.11;
    const double V_300D = 300;
    const double V_400D = 400;
    const double V_700D = 700;
    const double V_800D = 800;
    const double V_50D = 50;
    const double V_60D = 60;
    const double V_13D = 13;
    const double V_14D = 14;
    const double V_15D = 15;
    const double V_16D = 16;
    const double V_17D = 17;
    const double V_18D = 18;
    const double V_19D = 19;
    const double V_31D = 31;
    const long V_978637287197540L = 978637287197540;
    const long V_234978637287197540L = 234978637287197540;
    const double V_32D = 32;
    const double V_1000D = 1000;
    const double V_2000D = 2000;
    const double V_5000D = 5000;
    const double V_1000000D = 1000000;
    const double V_2000000D = 2000000;
    const double V_5000000D = 5000000;
    const double V_1000000000D = 1000000000;
    const double V_2000000000D = 2000000000;
    const double V_5000000000D = 5000000000;
    const double V_1000000000000D = 1000000000000;
    const double V_2000000000000D = 2000000000000;
    const double V_5000000000000D = 5000000000000;
    const double V_1D = 1;
    const double V_2D = 2;
    const double V_3D = 3;
    const double V_4D = 4;
    const double V_5D = 5;
    const double V_6D = 6;
    const double V_7D = 7;
    const double V_8D = 8;
    const double V_9D = 9;
    const double V_123D = 123;
    const double V_1_1D = 1.1;
    const double V_1_01D = 1.01;
    const double V_1_02D = 1.02;
    const double V_1_11D = 1.11;
    const double V_2_02D = 2.02;
    const double V_5_05D = 5.05;
    const double V_5_0005D = 5.0005;
    const double V_777_77D = 777.77;

    MoneyToStr moneyToStrUAH;
    MoneyToStr moneyToStrRUR;
    MoneyToStr moneyToStrUSDENG;
    MoneyToStr moneyToStrPER100; 
    MoneyToStr moneyToStrPER1000;

    /** setUp. */
    void setup() {
        moneyToStrUAH = new MoneyToStr("UAH", "UKR", "NUMBER");
        moneyToStrRUR = new MoneyToStr("RUR", "RUS", "NUMBER");
        moneyToStrUSDENG = new MoneyToStr("USD", "ENG", "TEXT");
        moneyToStrPER100 = new MoneyToStr("PER100", "RUS", "TEXT");
        moneyToStrPER1000 = new MoneyToStr("PER1000", "RUS", "TEXT");
    }

    void assert_equal(string expected, string actual) {
        if (expected != actual) {
            throw new ExpectException("expected: (".concat(expected).concat(") actual: (").concat(actual).concat(")"));
        }
    }

    /** checkUAH. */
    void test_checkUAH() {
        assert_equal("триста гривень 00 копійок", moneyToStrUAH.convertValue(V_300D));
        assert_equal("дев’ятсот сімдесят вісім трильйонів шістсот тридцять сім мільярдів "
                .concat("двісті вісімдесят сім мільйонів сто дев’яносто сім тисяч ")
                .concat("п’ятсот сорок гривень 12 копійок"), moneyToStrUAH.convert(V_978637287197540L, V_12L));
        assert_equal("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот "
                .concat("тридцять сім мільярдів двісті вісімдесят сім мільйонів сто дев’яносто сім тисяч ")
                .concat("п’ятсот сорок гривень 12 копійок"), moneyToStrUAH.convert(V_234978637287197540L, V_12L));
        assert_equal("одинадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_11D));
        assert_equal("дванадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_12D));
        assert_equal("одинадцять гривень 12 копійок", moneyToStrUAH.convertValue(V_11_12D));
        assert_equal("дванадцять гривень 11 копійок", moneyToStrUAH.convertValue(V_12_11D));
        assert_equal("триста гривень 00 копійок", moneyToStrUAH.convertValue(V_300D));
        assert_equal("чотириста гривень 00 копійок", moneyToStrUAH.convertValue(V_400D));
        assert_equal("сімсот гривень 00 копійок", moneyToStrUAH.convertValue(V_700D));
        assert_equal("вісімсот гривень 00 копійок", moneyToStrUAH.convertValue(V_800D));
        assert_equal("п’ятдесят гривень 00 копійок", moneyToStrUAH.convertValue(V_50D));
        assert_equal("шістдесят гривень 00 копійок", moneyToStrUAH.convertValue(V_60D));
        assert_equal("тринадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_13D));
        assert_equal("чотирнадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_14D));
        assert_equal("п’ятнадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_15D));
        assert_equal("шiстнадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_16D));
        assert_equal("сiмнадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_17D));
        assert_equal("вiсiмнадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_18D));
        assert_equal("дев'ятнадцять гривень 00 копійок", moneyToStrUAH.convertValue(V_19D));
        assert_equal("одна гривня 00 копійок", moneyToStrUAH.convertValue(V_1D));
        assert_equal("дві гривні 00 копійок", moneyToStrUAH.convertValue(V_2D));
        assert_equal("тридцять одна гривня 00 копійок", moneyToStrUAH.convertValue(V_31D));
        assert_equal("тридцять дві гривні 00 копійок", moneyToStrUAH.convertValue(V_32D));
        assert_equal("одна тисяча гривень 00 копійок", moneyToStrUAH.convertValue(V_1000D));
        assert_equal("дві тисячі гривень 00 копійок", moneyToStrUAH.convertValue(V_2000D));
        assert_equal("п’ять тисяч гривень 00 копійок", moneyToStrUAH.convertValue(V_5000D));
        assert_equal("один мільйон гривень 00 копійок", moneyToStrUAH.convertValue(V_1000000D));
        assert_equal("два мільйона гривень 00 копійок", moneyToStrUAH.convertValue(V_2000000D));
        assert_equal("п’ять мільйонів гривень 00 копійок", moneyToStrUAH.convertValue(V_5000000D));
        assert_equal("один мільярд гривень 00 копійок", moneyToStrUAH.convertValue(V_1000000000D));
        assert_equal("два мільярда гривень 00 копійок", moneyToStrUAH.convertValue(V_2000000000D));
        assert_equal("п’ять мільярдів гривень 00 копійок", moneyToStrUAH.convertValue(V_5000000000D));
        assert_equal("один трильйон гривень 00 копійок", moneyToStrUAH.convertValue(V_1000000000000D));
        assert_equal("два трильйона гривень 00 копійок", moneyToStrUAH.convertValue(V_2000000000000D));
        assert_equal("п’ять трильйонів гривень 00 копійок", moneyToStrUAH.convertValue(V_5000000000000D));
        assert_equal("одна гривня 01 копійка", moneyToStrUAH.convertValue(V_1_01D));
        assert_equal("одна гривня 02 копійки", moneyToStrUAH.convertValue(V_1_02D));
    }

    /** checkRUR. */
    void test_checkRUR() {
        assert_equal("семьсот семьдесят семь рублей 77 копеек", moneyToStrRUR.convertValue(V_777_77D));
    }

    /** checkUSD_ENG. */
    void test_checkUSDENG() {
        assert_equal("one dollar and zero cents", moneyToStrUSDENG.convertValue(1));
        assert_equal("two dollars and zero cents", moneyToStrUSDENG.convertValue(2));
        assert_equal("three dollars and zero cents", moneyToStrUSDENG.convertValue(3));
        assert_equal("four dollars and zero cents", moneyToStrUSDENG.convertValue(4));
        assert_equal("five dollars and zero cents", moneyToStrUSDENG.convertValue(5));
        assert_equal("six dollars and zero cents", moneyToStrUSDENG.convertValue(6));
        assert_equal("seven dollars and zero cents", moneyToStrUSDENG.convertValue(7));
        assert_equal("eight dollars and zero cents", moneyToStrUSDENG.convertValue(8));
        assert_equal("nine dollars and zero cents", moneyToStrUSDENG.convertValue(9));
        assert_equal("ten dollars and zero cents", moneyToStrUSDENG.convertValue(10));
        assert_equal("eleven dollars and zero cents", moneyToStrUSDENG.convertValue(11));
        assert_equal("twelve dollars and zero cents", moneyToStrUSDENG.convertValue(12));
        assert_equal("thirteen dollars and zero cents", moneyToStrUSDENG.convertValue(13));
        assert_equal("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two "
            .concat("million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents"),
        moneyToStrUSDENG.convertValue(27451632459870.49));
    }

    /** checkPER100. */
    void test_checkPER100() {
        assert_equal("одна целая, одна сотая процента", moneyToStrPER100.convertValue(V_1_01D));
        assert_equal("одна целая, десять сотых процента", moneyToStrPER100.convertValue(V_1_1D));
        assert_equal("одна целая, две сотых процента", moneyToStrPER100.convertValue(V_1_02D));
        assert_equal("одна целая, одиннадцать сотых процента", moneyToStrPER100.convertValue(V_1_11D));
        assert_equal("две целых, две сотых процента", moneyToStrPER100.convertValue(V_2_02D));
        assert_equal("пять целых, пять сотых процента", moneyToStrPER100.convertValue(V_5_05D));
    }

    void test_checkPER1000() {
        assert_equal("двенадцать целых, триста сорок шесть тысячных процента", moneyToStrPER1000.convertValue(12.346));
    }

    void test_percentToStr() {
        assert_equal("двенадцать целых, ноль десятых процента", MoneyToStr.percentToStr(12, "RUS"));
    }

    /** check percentToStr. */
    void test_checkPercentToStrRus() {
        assert_equal("одна целая, одна сотая процента", MoneyToStr.percentToStr(V_1_01D, "RUS"));
        assert_equal("одна целая, одна десятая процента", MoneyToStr.percentToStr(V_1_1D, "RUS"));
        assert_equal("одна целая, две сотых процента", MoneyToStr.percentToStr(V_1_02D, "RUS"));
        assert_equal("одна целая, одиннадцать сотых процента", MoneyToStr.percentToStr(V_1_11D, "RUS"));
        assert_equal("две целых, две сотых процента", MoneyToStr.percentToStr(V_2_02D, "RUS"));
        assert_equal("пять целых, пять сотых процента", MoneyToStr.percentToStr(V_5_05D, "RUS"));
        assert_equal("пять целых, пять десятитысячных процента", MoneyToStr.percentToStr(V_5_0005D, "RUS"));
    }

}

void main() {
    MoneyToStrTest test = new MoneyToStrTest();
    test.setup();
    test.test_checkUAH();
    test.test_checkRUR();
    test.test_checkUSDENG();
    test.test_checkPER100();
    test.test_checkPER1000();
    test.test_percentToStr();
    test.test_checkPercentToStrRus();
    print("7 tests were run: test_checkUAH(), test_checkRUR(), test_checkUSDENG(), test_checkPER100(), test_checkPER1000(), test_percentToStr(), test_checkPercentToStrRus()");
}
