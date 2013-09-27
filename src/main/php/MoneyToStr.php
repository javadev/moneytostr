<?php
class StringBuilder {
    var $_buffer;

    public function __construct() {
        $_buffer = array();
    }

    public function append($text) {
        $_buffer.append($text);
        return this;
    }

    public function insert($index, $text) {
        $_buffer.insert($index, $text);
        return this;
    }

    public function length() {
        return toString().length();
    }

    public function deleteCharAt($index) {
        $str = toString();
        $_buffer = array();
        append($str.substring(0, $index));
        return this;
    }

    public function toString() {
        return join("", $_buffer);
    }
}
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
          "-text" => "тис€ч,м≥льйон≥в,м≥ль€рд≥в,трильйон≥в"
        ),
        array(
          "-value" => "1000_1",
          "-text" => "тис€ча,м≥льйон,м≥ль€рд,трильйон"
        ),
        array(
          "-value" => "1000_234",
          "-text" => "тис€ч≥,м≥льйона,м≥ль€рда,трильйона"
        ),
        array(
          "-value" => "1000_5",
          "-text" => "тис€ч,м≥льйон≥в,м≥ль€рд≥в,трильйон≥в"
        ),
        array(
          "-value" => "10_19",
          "-text" => "дес€ть,одинадц€ть,дванадц€ть,тринадц€ть,чотирнадц€ть,пТ€тнадц€ть,шiстнадц€ть,сiмнадц€ть,вiсiмнадц€ть,дев'€тнадц€ть"
        ),
        array(
          "-value" => "1",
          "-text" => "одна,один,один,одна"
        ),
        array(
          "-value" => "2",
          "-text" => "дв≥,два,два,дв≥"
        ),
        array(
          "-value" => "3_9",
          "-text" => "три,чотири,пТ€ть,ш≥сть,с≥м,в≥с≥м,девТ€ть"
        ),
        array(
          "-value" => "100_900",
          "-text" => "сто ,дв≥ст≥ ,триста ,чотириста ,пТ€тсот ,ш≥стсот ,с≥мсот ,в≥с≥мсот ,девТ€тсот "
        ),
        array(
          "-value" => "20_90",
          "-text" => "двадц€ть ,тридц€ть ,сорок ,пТ€тдес€т ,ш≥стдес€т ,с≥мдес€т ,в≥с≥мдес€т ,девТ€носто "
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
          "-text" => "тыс€ч,миллионов,миллиардов,триллионов"
        ),
        array(
          "-value" => "1000_1",
          "-text" => "тыс€ча,миллион,миллиард,триллион"
        ),
        array(
          "-value" => "1000_234",
          "-text" => "тыс€чи,миллиона,миллиарда,триллиона"
        ),
        array(
          "-value" => "1000_5",
          "-text" => "тыс€ч,миллионов,миллиардов,триллионов"
        ),
        array(
          "-value" => "10_19",
          "-text" => "дес€ть,одиннадцать,двенадцать,тринадцать,четырнадцать,п€тнадцать,шестнадцать,семнадцать,восемнадцать,дев€тнадцать"
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
          "-text" => "три,четыре,п€ть,шесть,семь,восемь,дев€ть"
        ),
        array(
          "-value" => "100_900",
          "-text" => "сто ,двести ,триста ,четыреста ,п€тьсот ,шестьсот ,семьсот ,восемьсот ,дев€тьсот "
        ),
        array(
          "-value" => "20_90",
          "-text" => "двадцать ,тридцать ,сорок ,п€тьдес€т ,шестьдес€т ,семьдес€т ,восемьдес€т ,дев€носто "
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
        "-CurrName" => "–оссийские рубли",
        "-language" => "RUS",
        "-RubOneUnit" => "рубль",
        "-RubTwoUnit" => "рубл€",
        "-RubFiveUnit" => "рублей",
        "-RubSex" => "M",
        "-KopOneUnit" => "копейка",
        "-KopTwoUnit" => "копейки",
        "-KopFiveUnit" => "копеек",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "810",
        "-CurrName" => "–оссийские рубли",
        "-language" => "UKR",
        "-RubOneUnit" => "рубль",
        "-RubTwoUnit" => "рубл€",
        "-RubFiveUnit" => "рубл≥в",
        "-RubSex" => "M",
        "-KopOneUnit" => "коп≥йка",
        "-KopTwoUnit" => "коп≥йки",
        "-KopFiveUnit" => "коп≥йок",
        "-KopSex" => "F"
      )
    ),
    "UAH" => array(
      array(
        "-CurrID" => "980",
        "-CurrName" => "”краинск≥ гривн≥",
        "-language" => "RUS",
        "-RubOneUnit" => "гривн€",
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
        "-CurrName" => "”краинск≥ гривн≥",
        "-language" => "UKR",
        "-RubOneUnit" => "гривн€",
        "-RubTwoUnit" => "гривн≥",
        "-RubFiveUnit" => "гривень",
        "-RubSex" => "F",
        "-KopOneUnit" => "коп≥йка",
        "-KopTwoUnit" => "коп≥йки",
        "-KopFiveUnit" => "коп≥йок",
        "-KopSex" => "F"
      )
    ),
    "USD" => array(
      array(
        "-CurrID" => "840",
        "-CurrName" => "ƒолари —Ўј",
        "-language" => "RUS",
        "-RubOneUnit" => "долар",
        "-RubTwoUnit" => "долара",
        "-RubFiveUnit" => "долар≥в",
        "-RubSex" => "M",
        "-KopOneUnit" => "цент",
        "-KopTwoUnit" => "цена",
        "-KopFiveUnit" => "центов",
        "-KopSex" => "M"
      ),
      array(
        "-CurrID" => "840",
        "-CurrName" => "ƒолари —Ўј",
        "-language" => "UKR",
        "-RubOneUnit" => "долар",
        "-RubTwoUnit" => "долара",
        "-RubFiveUnit" => "долар≥в",
        "-RubSex" => "M",
        "-KopOneUnit" => "цент",
        "-KopTwoUnit" => "цена",
        "-KopFiveUnit" => "цент≥в",
        "-KopSex" => "M"
      ),
      array(
        "-CurrID" => "840",
        "-CurrName" => "ƒолари —Ўј",
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
        "-CurrName" => "¬iдсотки з дес€тими частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "цела€,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "дес€та€ процента",
        "-KopTwoUnit" => "дес€тых процента",
        "-KopFiveUnit" => "дес€тых процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "556",
        "-CurrName" => "¬iдсотки з дес€тими частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ц≥ла,",
        "-RubTwoUnit" => "ц≥лих,",
        "-RubFiveUnit" => "ц≥лих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "дес€та в≥дсотка",
        "-KopTwoUnit" => "дес€тих в≥дсотка",
        "-KopFiveUnit" => "дес€тих в≥дсотка",
        "-KopSex" => "F"
      )
    ),
    "PER100" => array(
      array(
        "-CurrID" => "557",
        "-CurrName" => "¬iдсотки з сотими частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "цела€,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "сота€ процента",
        "-KopTwoUnit" => "сотых процента",
        "-KopFiveUnit" => "сотых процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "557",
        "-CurrName" => "¬iдсотки з сотими частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ц≥ла,",
        "-RubTwoUnit" => "ц≥лих,",
        "-RubFiveUnit" => "ц≥лих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "сота в≥дсотка",
        "-KopTwoUnit" => "сотих в≥дсотка",
        "-KopFiveUnit" => "сотих в≥дсотка",
        "-KopSex" => "F"
      )
    ),
    "PER1000" => array(
      array(
        "-CurrID" => "558",
        "-CurrName" => "¬iдсотки з тис€чними частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "цела€,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "тыс€чна€ процента",
        "-KopTwoUnit" => "тыс€чных процента",
        "-KopFiveUnit" => "тыс€чных процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "558",
        "-CurrName" => "¬iдсотки з тис€чними частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ц≥ла,",
        "-RubTwoUnit" => "ц≥лих,",
        "-RubFiveUnit" => "ц≥лих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "тис€чна в≥дсотка",
        "-KopTwoUnit" => "тис€чних в≥дсотка",
        "-KopFiveUnit" => "тис€чних в≥дсотка",
        "-KopSex" => "F"
      )
    ),
    "PER10000" => array(
      array(
        "-CurrID" => "559",
        "-CurrName" => "¬iдсотки з дес€ти тис€чними частинами",
        "-language" => "RUS",
        "-RubOneUnit" => "цела€,",
        "-RubTwoUnit" => "целых,",
        "-RubFiveUnit" => "целых,",
        "-RubSex" => "F",
        "-KopOneUnit" => "дес€титыс€чна€ процента",
        "-KopTwoUnit" => "дес€титыс€чные процента",
        "-KopFiveUnit" => "дес€титыс€чных процента",
        "-KopSex" => "F"
      ),
      array(
        "-CurrID" => "559",
        "-CurrName" => "¬iдсотки з дес€ти тис€чними частинами",
        "-language" => "UKR",
        "-RubOneUnit" => "ц≥ла,",
        "-RubTwoUnit" => "ц≥лих,",
        "-RubFiveUnit" => "ц≥лих,",
        "-RubSex" => "F",
        "-KopOneUnit" => "дес€титис€чна в≥дсотка",
        "-KopTwoUnit" => "дес€титис€чних в≥дсотка",
        "-KopFiveUnit" => "дес€титис€чних в≥дсотка",
        "-KopSex" => "M"
      )
    )
  ));

    public function get() {
        return $this->$currencyList;
    }
}

    $data = new MoneyToStr().get();    
    echo "Starting Iteration" . "\n\r";
    for ($i=0;$i<10000;$i++) {
        echo "\r" . $i;
    }
    echo "Ending Iteration" . "\n\r";
?>
