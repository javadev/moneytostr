<?php
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
require('../../main/php/MoneyToStr.php');

class MoneyToStrTest {
    const V_12L = 12;
    const V_123L = 123;
    const V_11D = 11;
    const V_12D = 12;
    const V_11_12D = 11.12;
    const V_12_11D = 12.11;
    const V_300D = 300;
    const V_400D = 400;
    const V_700D = 700;
    const V_800D = 800;
    const V_50D = 50;
    const V_60D = 60;
    const V_13D = 13;
    const V_14D = 14;
    const V_15D = 15;
    const V_16D = 16;
    const V_17D = 17;
    const V_18D = 18;
    const V_19D = 19;
    const V_31D = 31;
    const V_978637287197540L = 978637287197540;
    const V_234978637287197540L = 234978637287197540;
    const V_32D = 32;
    const V_1000D = 1000;
    const V_2000D = 2000;
    const V_5000D = 5000;
    const V_1000000D = 1000000;
    const V_2000000D = 2000000;
    const V_5000000D = 5000000;
    const V_1000000000D = 1000000000;
    const V_2000000000D = 2000000000;
    const V_5000000000D = 5000000000;
    const V_1000000000000D = 1000000000000;
    const V_2000000000000D = 2000000000000;
    const V_5000000000000D = 5000000000000;
    const V_1D = 1;
    const V_2D = 2;
    const V_3D = 3;
    const V_4D = 4;
    const V_5D = 5;
    const V_6D = 6;
    const V_7D = 7;
    const V_8D = 8;
    const V_9D = 9;
    const V_123D = 123;
    const V_1_1D = 1.1;
    const V_1_01D = 1.01;
    const V_1_02D = 1.02;
    const V_1_11D = 1.11;
    const V_2_02D = 2.02;
    const V_5_05D = 5.05;
    const V_5_0005D = 5.0005;
    const V_777_77D = 777.77;
    private $moneyToStrUAH, $moneyToStrRUR, $moneyToStrUSDENG, $moneyToStrPER100, $moneyToStrPER1000;

    #/** setUp. */
    public function __construct() {
        $this->moneyToStrUAH = new MoneyToStr("UAH", "UKR", "NUMBER");
        $this->moneyToStrRUR = new MoneyToStr("RUR", "RUS", "NUMBER");
        $this->moneyToStrUSDENG = new MoneyToStr("USD", "ENG", "TEXT");
        $this->moneyToStrPER100 = new MoneyToStr("PER100", "RUS", "TEXT");
        $this->moneyToStrPER1000 = new MoneyToStr("PER1000", "RUS", "TEXT");
    }

    public function assertEqual($expected, $actual) {
        if ($expected != $actual) {
            throw new Exception("expected: (" . $expected . ") actual: (" . $actual . ")");
        }
    }

    #/** checkUAH. */
    public function test_checkUAH() {
        $this->assertEqual("триста гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_300D));
/*
        $this->assertEqual("дев’ятсот сімдесят вісім трильйонів шістсот тридцять сім мільярдів "
                . "двісті вісімдесят сім мільйонів сто дев’яносто сім тисяч "
                . "п’ятсот сорок гривень 12 копійок", $this->moneyToStrUAH->convert(MoneyToStrTest::V_978637287197540L, MoneyToStrTest::V_12L));
        $this->assertEqual("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот "
                . "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто дев’яносто сім тисяч "
                . "п’ятсот сорок гривень 12 копійок", $this->moneyToStrUAH->convert(MoneyToStrTest::V_234978637287197540L, MoneyToStrTest::V_12L));
*/
        $this->assertEqual("одинадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_11D));
        $this->assertEqual("дванадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_12D));
        $this->assertEqual("одинадцять гривень 12 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_11_12D));
        $this->assertEqual("дванадцять гривень 11 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_12_11D));
        $this->assertEqual("триста гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_300D));
        $this->assertEqual("чотириста гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_400D));
        $this->assertEqual("сімсот гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_700D));
        $this->assertEqual("вісімсот гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_800D));
        $this->assertEqual("п’ятдесят гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_50D));
        $this->assertEqual("шістдесят гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_60D));
        $this->assertEqual("тринадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_13D));
        $this->assertEqual("чотирнадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_14D));
        $this->assertEqual("п’ятнадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_15D));
        $this->assertEqual("шiстнадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_16D));
        $this->assertEqual("сiмнадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_17D));
        $this->assertEqual("вiсiмнадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_18D));
        $this->assertEqual("дев'ятнадцять гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_19D));
        $this->assertEqual("одна гривня 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1D));
        $this->assertEqual("дві гривні 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_2D));
        $this->assertEqual("тридцять одна гривня 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_31D));
        $this->assertEqual("тридцять дві гривні 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_32D));
        $this->assertEqual("одна тисяча гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1000D));
        $this->assertEqual("дві тисячі гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_2000D));
        $this->assertEqual("п’ять тисяч гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_5000D));
        $this->assertEqual("один мільйон гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1000000D));
        $this->assertEqual("два мільйона гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_2000000D));
        $this->assertEqual("п’ять мільйонів гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_5000000D));
        $this->assertEqual("один мільярд гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1000000000D));
        $this->assertEqual("два мільярда гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_2000000000D));
/*
        $this->assertEqual("п’ять мільярдів гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_5000000000D));
        $this->assertEqual("один трильйон гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1000000000000D));
        $this->assertEqual("два трильйона гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_2000000000000D));
        $this->assertEqual("п’ять трильйонів гривень 00 копійок", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_5000000000000D));
*/
        $this->assertEqual("одна гривня 01 копійка", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1_01D));
        $this->assertEqual("одна гривня 02 копійки", $this->moneyToStrUAH->convertValue(MoneyToStrTest::V_1_02D));
    }

    #/** checkRUR. */
    public function test_checkRUR() {
        $this->assertEqual("семьсот семьдесят семь рублей 77 копеек", $this->moneyToStrRUR->convertValue(MoneyToStrTest::V_777_77D));
    }

    #/** checkUSD_ENG. */
    public function test_checkUSDENG() {
        $this->assertEqual("one dollar and zero cents", $this->moneyToStrUSDENG->convertValue(1));
        $this->assertEqual("two dollars and zero cents", $this->moneyToStrUSDENG->convertValue(2));
        $this->assertEqual("three dollars and zero cents", $this->moneyToStrUSDENG->convertValue(3));
        $this->assertEqual("four dollars and zero cents", $this->moneyToStrUSDENG->convertValue(4));
        $this->assertEqual("five dollars and zero cents", $this->moneyToStrUSDENG->convertValue(5));
        $this->assertEqual("six dollars and zero cents", $this->moneyToStrUSDENG->convertValue(6));
        $this->assertEqual("seven dollars and zero cents", $this->moneyToStrUSDENG->convertValue(7));
        $this->assertEqual("eight dollars and zero cents", $this->moneyToStrUSDENG->convertValue(8));
        $this->assertEqual("nine dollars and zero cents", $this->moneyToStrUSDENG->convertValue(9));
        $this->assertEqual("ten dollars and zero cents", $this->moneyToStrUSDENG->convertValue(10));
        $this->assertEqual("eleven dollars and zero cents", $this->moneyToStrUSDENG->convertValue(11));
        $this->assertEqual("twelve dollars and zero cents", $this->moneyToStrUSDENG->convertValue(12));
        $this->assertEqual("thirteen dollars and zero cents", $this->moneyToStrUSDENG->convertValue(13));
/*
        $this->assertEqual("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two "
            . "million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents",
        $this->moneyToStrUSDENG->convertValue(27451632459870.49));
*/
    }

    /** checkPER100. */
    public function test_checkPER100() {
        $this->assertEqual("одна целая, одна сотая процента", $this->moneyToStrPER100->convertValue(MoneyToStrTest::V_1_01D));
        $this->assertEqual("одна целая, десять сотых процента", $this->moneyToStrPER100->convertValue(MoneyToStrTest::V_1_1D));
        $this->assertEqual("одна целая, две сотых процента", $this->moneyToStrPER100->convertValue(MoneyToStrTest::V_1_02D));
        $this->assertEqual("одна целая, одиннадцать сотых процента", $this->moneyToStrPER100->convertValue(MoneyToStrTest::V_1_11D));
        $this->assertEqual("две целых, две сотых процента", $this->moneyToStrPER100->convertValue(MoneyToStrTest::V_2_02D));
        $this->assertEqual("пять целых, пять сотых процента", $this->moneyToStrPER100->convertValue(MoneyToStrTest::V_5_05D));
    }

    public function test_checkPER1000() {
        $this->assertEqual("двенадцать целых, триста сорок шесть тысячных процента", $this->moneyToStrPER1000->convertValue(12.346));
    }

    public function test_percentToStr() {
        $this->assertEqual("двенадцать целых, ноль десятых процента", MoneyToStr::percentToStr(12, "RUS"));
    }

    public function test_checkPercentToStrRus() {
        $this->assertEqual("одна целая, одна сотая процента", MoneyToStr::percentToStr(MoneyToStrTest::V_1_01D, "RUS"));
        $this->assertEqual("одна целая, одна десятая процента", MoneyToStr::percentToStr(MoneyToStrTest::V_1_1D, "RUS"));
        $this->assertEqual("одна целая, две сотых процента", MoneyToStr::percentToStr(MoneyToStrTest::V_1_02D, "RUS"));
        $this->assertEqual("одна целая, одиннадцать сотых процента", MoneyToStr::percentToStr(MoneyToStrTest::V_1_11D, "RUS"));
        $this->assertEqual("две целых, две сотых процента", MoneyToStr::percentToStr(MoneyToStrTest::V_2_02D, "RUS"));
        $this->assertEqual("пять целых, пять сотых процента", MoneyToStr::percentToStr(MoneyToStrTest::V_5_05D, "RUS"));
        $this->assertEqual("пять целых, пять десятитысячных процента", MoneyToStr::percentToStr(MoneyToStrTest::V_5_0005D, "RUS"));
    }
}

    $test = new MoneyToStrTest();
    $test->test_checkUAH();
    $test->test_checkRUR();
    $test->test_checkUSDENG();
    $test->test_checkPER100();
    $test->test_checkPER1000();
    $test->test_percentToStr();
    $test->test_checkPercentToStrRus();
    echo "7 tests were passed, test_checkUAH(), test_checkRUR(), test_checkUSDENG(), test_checkPER100(), test_checkPER1000(), test_percentToStr(), test_checkPercentToStrRus()\n";
?>