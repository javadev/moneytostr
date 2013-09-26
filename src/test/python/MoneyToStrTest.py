'''
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
'''

import os, sys
import unittest
sys.path.append(os.path.abspath("../../main/python"))
from MoneyToStr import MoneyToStr

class MoneyToStrTest(unittest.TestCase):
    V_12L = 12
    V_123L = 123
    V_11D = 11
    V_12D = 12
    V_11_12D = 11.12
    V_12_11D = 12.11
    V_300D = 300
    V_400D = 400
    V_700D = 700
    V_800D = 800
    V_50D = 50
    V_60D = 60
    V_13D = 13
    V_14D = 14
    V_15D = 15
    V_16D = 16
    V_17D = 17
    V_18D = 18
    V_19D = 19
    V_31D = 31
    V_978637287197540L = 978637287197540
    V_234978637287197540L = 234978637287197540
    V_32D = 32
    V_1000D = 1000
    V_2000D = 2000
    V_5000D = 5000
    V_1000000D = 1000000
    V_2000000D = 2000000
    V_5000000D = 5000000
    V_1000000000D = 1000000000
    V_2000000000D = 2000000000
    V_5000000000D = 5000000000
    V_1000000000000D = 1000000000000
    V_2000000000000D = 2000000000000
    V_5000000000000D = 5000000000000
    V_1D = 1
    V_2D = 2
    V_3D = 3
    V_4D = 4
    V_5D = 5
    V_6D = 6
    V_7D = 7
    V_8D = 8
    V_9D = 9
    V_123D = 123
    V_1_1D = 1.1
    V_1_01D = 1.01
    V_1_02D = 1.02
    V_1_11D = 1.11
    V_2_02D = 2.02
    V_5_05D = 5.05
    V_5_0005D = 5.0005
    V_777_77D = 777.77

    #/** setUp. */
    def setUp(self):
        self.moneyToStrUAH = MoneyToStr("UAH", "UKR", "NUMBER")
        self.moneyToStrRUR = MoneyToStr("RUR", "RUS", "NUMBER")
        self.moneyToStrUSDENG = MoneyToStr("USD", "ENG", "TEXT")
        self.moneyToStrPER100 = MoneyToStr("PER100", "RUS", "TEXT")
        self.moneyToStrPER1000 = MoneyToStr("PER1000", "RUS", "TEXT")

    #/** checkUAH. */
    def test_checkUAH(self):
        self.assertEqual("триста гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_300D))
        self.assertEqual("дев’ятсот сімдесят вісім трильйонів шістсот тридцять сім мільярдів "\
                "двісті вісімдесят сім мільйонів сто дев’яносто сім тисяч "
                "п’ятсот сорок гривень 12 копійок", self.moneyToStrUAH.convert(self.V_978637287197540L, self.V_12L))
        self.assertEqual("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот "\
                "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто дев’яносто сім тисяч "\
                "п’ятсот сорок гривень 12 копійок", self.moneyToStrUAH.convert(self.V_234978637287197540L, self.V_12L))
        self.assertEqual("одинадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_11D));
        self.assertEqual("дванадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_12D));
        self.assertEqual("одинадцять гривень 12 копійок", self.moneyToStrUAH.convertValue(self.V_11_12D));
        self.assertEqual("дванадцять гривень 11 копійок", self.moneyToStrUAH.convertValue(self.V_12_11D));
        self.assertEqual("триста гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_300D));
        self.assertEqual("чотириста гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_400D));
        self.assertEqual("сімсот гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_700D));
        self.assertEqual("вісімсот гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_800D));
        self.assertEqual("п’ятдесят гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_50D));
        self.assertEqual("шістдесят гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_60D));
        self.assertEqual("тринадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_13D));
        self.assertEqual("чотирнадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_14D));
        self.assertEqual("п’ятнадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_15D));
        self.assertEqual("шiстнадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_16D));
        self.assertEqual("сiмнадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_17D));
        self.assertEqual("вiсiмнадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_18D));
        self.assertEqual("дев'ятнадцять гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_19D));
        self.assertEqual("одна гривня 00 копійок", self.moneyToStrUAH.convertValue(self.V_1D));
        self.assertEqual("дві гривні 00 копійок", self.moneyToStrUAH.convertValue(self.V_2D));
        self.assertEqual("тридцять одна гривня 00 копійок", self.moneyToStrUAH.convertValue(self.V_31D));
        self.assertEqual("тридцять дві гривні 00 копійок", self.moneyToStrUAH.convertValue(self.V_32D));
        self.assertEqual("одна тисяча гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_1000D));
        self.assertEqual("дві тисячі гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_2000D));
        self.assertEqual("п’ять тисяч гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_5000D));
        self.assertEqual("один мільйон гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_1000000D));
        self.assertEqual("два мільйона гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_2000000D));
        self.assertEqual("п’ять мільйонів гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_5000000D));
        self.assertEqual("один мільярд гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_1000000000D));
        self.assertEqual("два мільярда гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_2000000000D));
        self.assertEqual("п’ять мільярдів гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_5000000000D));
        self.assertEqual("один трильйон гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_1000000000000D));
        self.assertEqual("два трильйона гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_2000000000000D));
        self.assertEqual("п’ять трильйонів гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_5000000000000D));
        self.assertEqual("одна гривня 01 копійка", self.moneyToStrUAH.convertValue(self.V_1_01D));
        self.assertEqual("одна гривня 02 копійки", self.moneyToStrUAH.convertValue(self.V_1_02D));

    #/** checkRUR. */
    def test_checkRUR(self):
        self.assertEqual("семьсот семьдесят семь рублей 77 копеек", self.moneyToStrRUR.convertValue(self.V_777_77D));

    #/** checkUSD_ENG. */
    def test_checkUSDENG(self):
        self.assertEqual("one dollar and zero cents", self.moneyToStrUSDENG.convertValue(1));
        self.assertEqual("two dollars and zero cents", self.moneyToStrUSDENG.convertValue(2));
        self.assertEqual("three dollars and zero cents", self.moneyToStrUSDENG.convertValue(3));
        self.assertEqual("four dollars and zero cents", self.moneyToStrUSDENG.convertValue(4));
        self.assertEqual("five dollars and zero cents", self.moneyToStrUSDENG.convertValue(5));
        self.assertEqual("six dollars and zero cents", self.moneyToStrUSDENG.convertValue(6));
        self.assertEqual("seven dollars and zero cents", self.moneyToStrUSDENG.convertValue(7));
        self.assertEqual("eight dollars and zero cents", self.moneyToStrUSDENG.convertValue(8));
        self.assertEqual("nine dollars and zero cents", self.moneyToStrUSDENG.convertValue(9));
        self.assertEqual("ten dollars and zero cents", self.moneyToStrUSDENG.convertValue(10));
        self.assertEqual("eleven dollars and zero cents", self.moneyToStrUSDENG.convertValue(11));
        self.assertEqual("twelve dollars and zero cents", self.moneyToStrUSDENG.convertValue(12));
        self.assertEqual("thirteen dollars and zero cents", self.moneyToStrUSDENG.convertValue(13));
        self.assertEqual("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two " \
            "million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents",
        self.moneyToStrUSDENG.convertValue(27451632459870.49));

    #/** checkPER100. */
    def test_checkPER100(self):
        self.assertEqual("одна целая, одна сотая процента", self.moneyToStrPER100.convertValue(self.V_1_01D));
        self.assertEqual("одна целая, десять сотых процента", self.moneyToStrPER100.convertValue(self.V_1_1D));
        self.assertEqual("одна целая, две сотых процента", self.moneyToStrPER100.convertValue(self.V_1_02D));
        self.assertEqual("одна целая, одиннадцать сотых процента", self.moneyToStrPER100.convertValue(self.V_1_11D));
        self.assertEqual("две целых, две сотых процента", self.moneyToStrPER100.convertValue(self.V_2_02D));
        self.assertEqual("пять целых, пять сотых процента", self.moneyToStrPER100.convertValue(self.V_5_05D));

    def test_checkPER1000(self):
        self.assertEqual("двенадцать целых, триста сорок шесть тысячных процента", self.moneyToStrPER1000.convertValue(12.346));

    def test_percentToStr(self):
        self.assertEqual("двенадцать целых, ноль десятых процента", MoneyToStr.percentToStr(12, "RUS"));

    #/** check percentToStr. */
    def test_checkPercentToStrRus(self):
        self.assertEqual("одна целая, одна сотая процента", MoneyToStr.percentToStr(self.V_1_01D, "RUS"));
        self.assertEqual("одна целая, одна десятая процента", MoneyToStr.percentToStr(self.V_1_1D, "RUS"));
        self.assertEqual("одна целая, две сотых процента", MoneyToStr.percentToStr(self.V_1_02D, "RUS"));
        self.assertEqual("одна целая, одиннадцать сотых процента", MoneyToStr.percentToStr(self.V_1_11D, "RUS"));
        self.assertEqual("две целых, две сотых процента", MoneyToStr.percentToStr(self.V_2_02D, "RUS"));
        self.assertEqual("пять целых, пять сотых процента", MoneyToStr.percentToStr(self.V_5_05D, "RUS"));
        self.assertEqual("пять целых, пять десятитысячных процента", MoneyToStr.percentToStr(self.V_5_0005D, "RUS"));

def main():
    unittest.main()

if __name__ == '__main__':
    main()
