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
class StringBuilder {
    var $_buffer = array();

    public function __construct() {
        $this->_buffer = array();
    }

    public function append($text) {
        array_push($this->_buffer, $text);
        return $this;
    }

    public function insert($text) {
        array_unshift($this->_buffer, $text);
        return $this;
    }

    public function length() {
        return $this->toString().length();
    }

    public function deleteCharAt($index) {
        $str = toString();
        $this->_buffer = array();
        append($str.substring(0, $index));
        return $this;
    }

    public function toString() {
        return join("", $this->_buffer);
    }
}

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
class MoneyToStr {
    var $currencyList = array(
  "CurrencyList" => array(
    "language" => array( "-value" => "UKR" ),
    "UKR" => array(
      "item" => array(
        array(
          "-value" => "0",
          "-text" => "нуль"
        ),
        array(
          "-value" => "1000_10",
          "-text" => "тисяч,мільйонів,мільярдів,трильйонів"
        ),
        array(
          "-value" => "1000_1",
          "-text" => "тисяча,мільйон,мільярд,трильйон"
        ),
        array(
          "-value" => "1000_234",
          "-text" => "тисячі,мільйона,мільярда,трильйона"
        ),
        array(
          "-value" => "1000_5",
          "-text" => "тисяч,мільйонів,мільярдів,трильйонів"
        ),
        array(
          "-value" => "10_19",
          "-text" => "десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п’ятнадцять,шiстнадцять,сiмнадцять,вiсiмнадцять,дев'ятнадцять"
        ),
        array(
          "-value" => "1",
          "-text" => "одна,один,один,одна"
        ),
        array(
          "-value" => "2",
          "-text" => "дві,два,два,дві"
        ),
        array(
          "-value" => "3_9",
          "-text" => "три,чотири,п’ять,шість,сім,вісім,дев’ять"
        ),
        array(
          "-value" => "100_900",
          "-text" => "сто ,двісті ,триста ,чотириста ,п’ятсот ,шістсот ,сімсот ,вісімсот ,дев’ятсот "
        ),
        array(
          "-value" => "20_90",
          "-text" => "двадцять ,тридцять ,сорок ,п’ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев’яносто "
        )
      )
    ),
    "RUS" => array(
      "item" => array(
        array(
          "-value" => "0",
          "-text" => "ноль"
        ),
        array(
          "-value" => "1000_10",
          "-text" => "тысяч,миллионов,миллиардов,триллионов"
        ),
        array(
          "-value" => "1000_1",
          "-text" => "тысяча,миллион,миллиард,триллион"
        ),
        array(
          "-value" => "1000_234",
          "-text" => "тысячи,миллиона,миллиарда,триллиона"
        ),
        array(
          "-value" => "1000_5",
          "-text" => "тысяч,миллионов,миллиардов,триллионов"
        ),
        array(
          "-value" => "10_19",
          "-text" => "десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать"
        ),
        array(
          "-value" => "1",
          "-text" => "одна,один,один,одна"
        ),
        array(
          "-value" => "2",
          "-text" => "две,два,два,две"
        ),
        array(
          "-value" => "3_9",
          "-text" => "три,четыре,пять,шесть,семь,восемь,девять"
        ),
        array(
          "-value" => "100_900",
          "-text" => "сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот "
        ),
        array(
          "-value" => "20_90",
          "-text" => "двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто "
        )
      )
    ),
    "ENG" => array(
      "item" => array(
        array(
          "-value" => "0",
          "-text" => "zero"
        ),
        array(
          "-value" => "1000_10",
          "-text" => "thousand,million,billion,trillion"
        ),
        array(
          "-value" => "1000_1",
          "-text" => "thousand,million,billion,trillion"
        ),
        array(
          "-value" => "1000_234",
          "-text" => "thousand,million,billion,trillion"
        ),
        array(
          "-value" => "1000_5",
          "-text" => "thousand,million,billion,trillion"
        ),
        array(
          "-value" => "10_19",
          "-text" => "ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen"
        ),
        array(
          "-value" => "1",
          "-text" => "one,one,one,one"
        ),
        array(
          "-value" => "2",
          "-text" => "two,two,two,two"
        ),
        array(
          "-value" => "3_9",
          "-text" => "three,four,five,six,seven,eight,nine"
        ),
        array(
          "-value" => "100_900",
          "-text" => "one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred "
        ),
        array(
          "-value" => "20_90",
          "-text" => "twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-"
        )
      )
    ),
    "RUR" => array(
      array(
        "-CurrID" => "810",
        "-CurrName" => "Российские рубли",
        "-language" => "RUS",
        "-RubOneUnit" => "рубль",
        "-RubTwoUnit" => "рубля",
        "-RubFiveUnit" => "рублей",
        "-RubSex" => "M",
        "-KopOneUnit" => "копейка",
        "-KopTwoUnit" => "копейки",
        "-KopFiveUnit" => "копеек",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "810",
        "-CurrName" => "Российские рубли",
        "-language" => "UKR",
        "-RubOneUnit" => "рубль",
        "-RubTwoUnit" => "рубля",
        "-RubFiveUnit" => "рублів",
        "-RubSex" => "M",
        "-KopOneUnit" => "копійка",
        "-KopTwoUnit" => "копійки",
        "-KopFiveUnit" => "копійок",
        "-KopSex" => "F"
      )
    ),
    "UAH" => array(
      array(
        "-CurrID" => "980",
        "-CurrName" => "Украинскі гривні",
        "-language" => "RUS",
        "-RubOneUnit" => "гривня",
        "-RubTwoUnit" => "гривни",
        "-RubFiveUnit" => "гривень",
        "-RubSex" => "F",
        "-KopOneUnit" => "копейка",
        "-KopTwoUnit" => "копейки",
        "-KopFiveUnit" => "копеек",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "980",
        "-CurrName" => "Украинскі гривні",
        "-language" => "UKR",
        "-RubOneUnit" => "гривня",
        "-RubTwoUnit" => "гривні",
        "-RubFiveUnit" => "гривень",
        "-RubSex" => "F",
        "-KopOneUnit" => "копійка",
        "-KopTwoUnit" => "копійки",
        "-KopFiveUnit" => "копійок",
        "-KopSex" => "F"
      )
    ),
    "USD" => array(
      array(
        "-CurrID" => "840",
        "-CurrName" => "Долари США",
        "-language" => "RUS",
        "-RubOneUnit" => "долар",
        "-RubTwoUnit" => "долара",
        "-RubFiveUnit" => "доларів",
        "-RubSex" => "M",
        "-KopOneUnit" => "цент",
        "-KopTwoUnit" => "цена",
        "-KopFiveUnit" => "центов",
        "-KopSex" => "M"
      ),
      array(
        "-CurrID" => "840",
        "-CurrName" => "Долари США",
        "-language" => "UKR",
        "-RubOneUnit" => "долар",
        "-RubTwoUnit" => "долара",
        "-RubFiveUnit" => "доларів",
        "-RubSex" => "M",
        "-KopOneUnit" => "цент",
        "-KopTwoUnit" => "цена",
        "-KopFiveUnit" => "центів",
        "-KopSex" => "M"
      ),
      array(
        "-CurrID" => "840",
        "-CurrName" => "Долари США",
        "-language" => "ENG",
        "-RubOneUnit" => "dollar",
        "-RubTwoUnit" => "dollars",
        "-RubFiveUnit" => "dollars",
        "-RubSex" => "M",
        "-KopOneUnit" => "cent",
        "-KopTwoUnit" => "cents",
        "-KopFiveUnit" => "cents",
        "-KopSex" => "M"
      )
     ),
    "PER10" => array(
      array(
        "-CurrID" => "556",
        "-CurrName" => "Вiдсотки з десятими частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десятая процента",
        "-KopTwoUnit" => "десятых процента",
        "-KopFiveUnit" => "десятых процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "556",
        "-CurrName" => "Вiдсотки з десятими частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десята відсотка",
        "-KopTwoUnit" => "десятих відсотка",
        "-KopFiveUnit" => "десятих відсотка",
        "-KopSex" => "F"
      )
    ),
    "PER100" => array(
      array(
        "-CurrID" => "557",
        "-CurrName" => "Вiдсотки з сотими частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "сотая процента",
        "-KopTwoUnit" => "сотых процента",
        "-KopFiveUnit" => "сотых процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "557",
        "-CurrName" => "Вiдсотки з сотими частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "сота відсотка",
        "-KopTwoUnit" => "сотих відсотка",
        "-KopFiveUnit" => "сотих відсотка",
        "-KopSex" => "F"
      )
    ),
    "PER1000" => array(
      array(
        "-CurrID" => "558",
        "-CurrName" => "Вiдсотки з тисячними частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "тысячная процента",
        "-KopTwoUnit" => "тысячных процента",
        "-KopFiveUnit" => "тысячных процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "558",
        "-CurrName" => "Вiдсотки з тисячними частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "тисячна відсотка",
        "-KopTwoUnit" => "тисячних відсотка",
        "-KopFiveUnit" => "тисячних відсотка",
        "-KopSex" => "F"
      )
    ),
    "PER10000" => array(
      array(
        "-CurrID" => "559",
        "-CurrName" => "Вiдсотки з десяти тисячними частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "целая,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десятитысячная процента",
        "-KopTwoUnit" => "десятитысячные процента",
        "-KopFiveUnit" => "десятитысячных процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "559",
        "-CurrName" => "Вiдсотки з десяти тисячними частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ціла,",
        "-RubTwoUnit" => "цілих,",
        "-RubFiveUnit" => "цілих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "десятитисячна відсотка",
        "-KopTwoUnit" => "десятитисячних відсотка",
        "-KopFiveUnit" => "десятитисячних відсотка",
        "-KopSex" => "M"
      )
    )
  ));

    const NUM0 = 0;
    const NUM1 = 1;
    const NUM2 = 2;
    const NUM3 = 3;
    const NUM4 = 4;
    const NUM5 = 5;
    const NUM6 = 6;
    const NUM7 = 7;
    const NUM8 = 8;
    const NUM9 = 9;
    const NUM10 = 10;
    const NUM11 = 11;
    const NUM12 = 12;
    const NUM100 = 100;
    const NUM1000 = 1000;
    const NUM10000 = 10000;
    const INDEX_0 = 0;
    const INDEX_1 = 1;
    const INDEX_2 = 2;
    const INDEX_3 = 3;
    private $currency, $language, $pennies, $messages;
    private $rubOneUnit, $rubTwoUnit, $rubFiveUnit, $kopOneUnit, $kopTwoUnit, $kopFiveUnit, $rubSex, $kopSex;

    public function __construct($currency, $language, $pennies) {
        $this->currency = $currency;
        $this->language = $language;
        $this->pennies = $pennies;
        $languageElement = $language;
        $items = $this->currencyList['CurrencyList'][$languageElement]['item'];
        $this->messages = array();
        foreach ($items as $languageItem) {
            if ($languageItem["-text"] != null) {
                $this->messages[$languageItem["-value"]] = explode(",", $languageItem["-text"]);
            }
        }
        $currencyItem = $this->currencyList['CurrencyList'][$currency];
        $theISOElement = null;
        foreach ($currencyItem as $item) {
            if ($item["-language"] == $language) {
                $theISOElement = $item;
                next;
            }
        }
        if (theISOElement == null) {
            throw new Exception("Currency not found " . $currency);
        }
        $this->rubOneUnit = $theISOElement["-RubOneUnit"];
        $this->rubTwoUnit = $theISOElement["-RubTwoUnit"];
        $this->rubFiveUnit = $theISOElement["-RubFiveUnit"];
        $this->kopOneUnit = $theISOElement["-KopOneUnit"];
        $this->kopTwoUnit = $theISOElement["-KopTwoUnit"];
        $this->kopFiveUnit = $theISOElement["-KopFiveUnit"];
        $this->rubSex = $theISOElement["-RubSex"];
        $this->kopSex = $theISOElement["-KopSex"];
    }

    /**
     * Converts double value to the text description.
     *
     * @param theMoney
     *            the amount of money in format major.minor
     * @return the string description of money value
     */
    public function convertValue($theMoney) {
        $intPart = intval($theMoney);
        $fractPart = intval(round((($theMoney - $intPart) * MoneyToStr::NUM100)));
        if ($this->currency == "PER1000") {
            $fractPart = intval(round((($theMoney - $intPart) * MoneyToStr::NUM1000)));
        }
        return $this->convert($intPart, $fractPart);
    }

    /**
     * Converts number to currency. Usage: MoneyToStr moneyToStr = new MoneyToStr("UAH", "UKR", "NUMBER"); String result =
     * moneyToStr.convertValue(123D); Expected: result = сто двадцять три гривні 00 копійок
     *
     * @param theMoney
     *            the amount of money major currency
     * @param theKopeiki
     *            the amount of money minor currency
     * @return the string description of money value
     */
    public function convert($theMoney, $theKopeiki) {
        $money2str = new StringBuilder();
        $triadNum = 0;

        $intPart = intval($theMoney);
        if ($intPart == 0) {
            $money2str->append($this->messages["0"][0] . " ");
        }
        do {
            $theTriad = $intPart % MoneyToStr::NUM1000;
            $money2str->insert($this->triad2Word($theTriad, $triadNum, $this->rubSex));
            if ($triadNum == 0) {
                $range10 = intval(($theTriad % MoneyToStr::NUM100) / MoneyToStr::NUM10);
                $range = intval($theTriad % MoneyToStr::NUM10);
                if ($range10 == MoneyToStr::NUM1) {
                    $money2str->append($this->rubFiveUnit);
                } else {
                    switch ($range) {
                    case MoneyToStr::NUM1:
                        $money2str->append($this->rubOneUnit);
                        break;
                    case MoneyToStr::NUM2: case MoneyToStr::NUM3: case MoneyToStr::NUM4:
                        $money2str->append($this->rubTwoUnit);
                        break;
                    default:
                        $money2str->append($this->rubFiveUnit);
                        break;
                    }
                }
            }
            $intPart = intval($intPart / MoneyToStr::NUM1000);
            $triadNum += 1;
        } while ($intPart > 0);

        if ($this->pennies == "TEXT") {
            $money2str->append($this->language == "ENG" ? " and " : " ")->append($theKopeiki == 0 ? ($this->messages["0"][0] . " ") : $this->triad2Word($theKopeiki, 0, $this->kopSex));
        } else {
            $money2str->append(" " . ($theKopeiki < 10 ? "0" . strval($theKopeiki) : strval($theKopeiki)) . " ");
        }
        if ($theKopeiki == MoneyToStr::NUM11 || $theKopeiki == MoneyToStr::NUM12) {
            $money2str->append($this->kopFiveUnit);
        } else {
            switch ($theKopeiki % MoneyToStr::NUM10) {
            case MoneyToStr::NUM1:
                $money2str->append($this->kopOneUnit);
                break;
            case MoneyToStr::NUM2: case MoneyToStr::NUM3: case MoneyToStr::NUM4:
                $money2str->append($this->kopTwoUnit);
                break;
            default:
                $money2str->append($this->kopFiveUnit);
                break;
            }
        }
        return trim($money2str->toString());
    }

    public function triad2Word($triad, $triadNum, $sex) {
        $triadWord = new StringBuilder();

        if ($triad == 0) {
            return "";
        }

        $range = $this->check1($triad, $triadWord);
        if ($language == "ENG" && $triadWord->length() > 0 && $triad % MoneyToStr::NUM10 == 0) {
            $triadWord->deleteCharAt($triadWord.length() - 1);
            $triadWord->append(" ");
        }

        $range10 = $range;
        $range = $triad % MoneyToStr::NUM10;
        $this->check2($triadNum, $sex, $triadWord, $triad, $range10);
        switch ($triadNum) {
        case MoneyToStr::NUM0:
            break;
        case MoneyToStr::NUM1: case MoneyToStr::NUM2: case MoneyToStr::NUM3: case MoneyToStr::NUM4:
            if ($range10 == MoneyToStr::NUM1) {
                $triadWord->append($this->messages["1000_10"][$triadNum - 1] . " ");
            } else {
                switch ($range) {
                case MoneyToStr::NUM1:
                    $triadWord->append($this->messages["1000_1"][$triadNum - 1] . " ");
                    break;
                case MoneyToStr::NUM2: case MoneyToStr::NUM3: case MoneyToStr::NUM4:
                    $triadWord->append($this->messages["1000_234"][$triadNum - 1] . " ");
                    break;
                default:
                    $triadWord->append($this->messages["1000_5"][$triadNum - 1] . " ");
                    break;
                }
            }
            break;
        default:
            $triadWord->append("??? ");
            break;
        }
        return $triadWord->toString();
    }

    /**
     * @param triadNum the triad num
     * @param sex the sex
     * @param triadWord the triad word
     * @param triad the triad
     * @param range10 the range 10
     */
    public function check2($triadNum, $sex, $triadWord, $triad, $range10) {
        $range = $triad % MoneyToStr::NUM10;
        if ($range10 == 1) {
            $triadWord->append($this->messages["10_19"][$range] . " ");
        } else {
            switch ($range) {
            case MoneyToStr::NUM1:
                if ($triadNum == MoneyToStr::NUM1) {
                    $triadWord->append($this->messages["1"][MoneyToStr::INDEX_0] . " ");
                } else if ($triadNum == MoneyToStr::NUM2 || $triadNum == MoneyToStr::NUM3 || $triadNum == MoneyToStr::NUM4) {
                    $triadWord->append($this->messages["1"][MoneyToStr::INDEX_1] . " ");
                } else if ("M" == $sex) {
                    $triadWord->append($this->messages["1"][MoneyToStr::INDEX_2] . " ");
                } else if ("F" == $sex) {
                    $triadWord->append($this->messages["1"][MoneyToStr::INDEX_3] . " ");
                }
                break;
            case MoneyToStr::NUM2:
                if ($triadNum == MoneyToStr::NUM1) {
                    $triadWord->append($this->messages["2"][MoneyToStr::INDEX_0] . " ");
                } else if ($triadNum == MoneyToStr::NUM2 || $triadNum == MoneyToStr::NUM3 || $triadNum == MoneyToStr::NUM4) {
                    $triadWord->append($this->messages["2"][MoneyToStr::INDEX_1] . " ");
                } else if ("M" == $sex) {
                    $triadWord->append($this->messages["2"][MoneyToStr::INDEX_2] . " ");
                } else if ("F" == $sex) {
                    $triadWord->append($this->messages["2"][MoneyToStr::INDEX_3] . " ");
                }
                break;
            case MoneyToStr::NUM3: case MoneyToStr::NUM4: case MoneyToStr::NUM5: case MoneyToStr::NUM6: case MoneyToStr::NUM7: case MoneyToStr::NUM8: case MoneyToStr::NUM9:
                $triadWord->append($this->concat(["", "", ""], $this->messages["3_9"])[$range] . " ");
                break;
            }
        }
    }

    /**
     * @param triad the triad
     * @param triadWord the triad word
     * @return the range
     */
    private function check1($triad, $triadWord) {
        $range = intval($triad / MoneyToStr::NUM100);
        $triadWord->append($this->concat([""], $this->messages["100_900"])[$range]);

        $range = intval(($triad % MoneyToStr::NUM100) / MoneyToStr::NUM10);
        $triadWord->append($this->concat(["", ""], $this->messages["20_90"])[$range]);
        return $range;
    }

    private function concat($first, $second) {
        $result = array_merge($first, $second);
        return $result;
    }
}

?>
