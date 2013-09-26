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

    def test_checkUAH(self):
        self.assertEqual("триста гривень 00 копійок", self.moneyToStrUAH.convertValue(self.V_300D));
    def testOne(self):
        self.failUnless(1 == 1)

def main():
    unittest.main()

if __name__ == '__main__':
    main()
