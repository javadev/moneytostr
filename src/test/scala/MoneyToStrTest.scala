object MoneyToStrTest {
    val V_12L = 12;
    val V_123L = 123;
    val V_11D : Double = 11;
    val V_12D : Double = 12;
    val V_11_12D : Double = 11.12;
    val V_12_11D : Double = 12.11;
    val V_300D : Double = 300;
    val V_400D : Double = 400;
    val V_700D : Double = 700;
    val V_800D : Double = 800;
    val V_50D : Double = 50;
    val V_60D : Double = 60;
    val V_13D : Double = 13;
    val V_14D : Double = 14;
    val V_15D : Double = 15;
    val V_16D : Double = 16;
    val V_17D : Double = 17;
    val V_18D : Double = 18;
    val V_19D : Double = 19;
    val V_31D : Double = 31;
    val V_978637287197540L : Long = 978637287197540L;
    val V_234978637287197540L : Long = 234978637287197540L;
    val V_32D : Double = 32;
    val V_1000D : Double = 1000;
    val V_2000D : Double = 2000;
    val V_5000D : Double = 5000;
    val V_1000000D : Double = 1000000;
    val V_2000000D : Double = 2000000;
    val V_5000000D : Double = 5000000;
    val V_1000000000D : Double = 1000000000D;
    val V_2000000000D : Double = 2000000000D;
    val V_5000000000D : Double = 5000000000D;
    val V_1000000000000D : Double = 1000000000000D;
    val V_2000000000000D : Double = 2000000000000D;
    val V_5000000000000D : Double = 5000000000000D;
    val V_1D : Double = 1;
    val V_2D : Double = 2;
    val V_3D : Double = 3;
    val V_4D : Double = 4;
    val V_5D : Double = 5;
    val V_6D : Double = 6;
    val V_7D : Double = 7;
    val V_8D : Double = 8;
    val V_9D : Double = 9;
    val V_123D : Double = 123;
    val V_1_1D : Double = 1.1;
    val V_1_01D : Double = 1.01;
    val V_1_02D : Double = 1.02;
    val V_1_11D : Double = 1.11;
    val V_2_02D : Double = 2.02;
    val V_5_05D : Double = 5.05;
    val V_5_0005D : Double = 5.0005;
    val V_777_77D : Double = 777.77;

    var moneyToStrUAH : MoneyToStr = null
    var moneyToStrRUR : MoneyToStr = null
    var moneyToStrUSDENG : MoneyToStr = null
    var moneyToStrPER100 : MoneyToStr = null 
    var moneyToStrPER1000 : MoneyToStr = null

    /** setUp. */
    def setup() = {
        moneyToStrUAH = new MoneyToStr("UAH", "UKR", "NUMBER")
        moneyToStrRUR = new MoneyToStr("RUR", "RUS", "NUMBER")
        moneyToStrUSDENG = new MoneyToStr("USD", "ENG", "TEXT")
        moneyToStrPER100 = new MoneyToStr("PER100", "RUS", "TEXT")
        moneyToStrPER1000 = new MoneyToStr("PER1000", "RUS", "TEXT")
    }

    def assert_equal(expected : String, actual : String) = {
        if (expected != actual) {
            throw new Exception("expected: (" + expected + ") actual: (" + actual + ")");
        }
    }

    /** checkUAH. */
    def test_checkUAH() = {
        assert_equal("триста гривень 00 копійок", moneyToStrUAH.convert(V_300D));
        assert_equal("дев’ятсот сімдесят вісім трильйонів шістсот " + "тридцять сім мільярдів "
                + "двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч "
                + "п’ятсот сорок гривень 12 копійок", moneyToStrUAH.convert(V_978637287197540L, V_12L));
        assert_equal("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот "
                + "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч "
                + "п’ятсот сорок гривень 12 копійок", moneyToStrUAH.convert(V_234978637287197540L, V_12L));
        assert_equal("одинадцять гривень 00 копійок", moneyToStrUAH.convert(V_11D));
        assert_equal("дванадцять гривень 00 копійок", moneyToStrUAH.convert(V_12D));
        assert_equal("одинадцять гривень 12 копійок", moneyToStrUAH.convert(V_11_12D));
        assert_equal("дванадцять гривень 11 копійок", moneyToStrUAH.convert(V_12_11D));
        assert_equal("триста гривень 00 копійок", moneyToStrUAH.convert(V_300D));
        assert_equal("чотириста гривень 00 копійок", moneyToStrUAH.convert(V_400D));
        assert_equal("сімсот гривень 00 копійок", moneyToStrUAH.convert(V_700D));
        assert_equal("вісімсот гривень 00 копійок", moneyToStrUAH.convert(V_800D));
        assert_equal("п’ятдесят гривень 00 копійок", moneyToStrUAH.convert(V_50D));
        assert_equal("шістдесят гривень 00 копійок", moneyToStrUAH.convert(V_60D));
        assert_equal("тринадцять гривень 00 копійок", moneyToStrUAH.convert(V_13D));
        assert_equal("чотирнадцять гривень 00 копійок", moneyToStrUAH.convert(V_14D));
        assert_equal("п’ятнадцять гривень 00 копійок", moneyToStrUAH.convert(V_15D));
        assert_equal("шiстнадцять гривень 00 копійок", moneyToStrUAH.convert(V_16D));
        assert_equal("сiмнадцять гривень 00 копійок", moneyToStrUAH.convert(V_17D));
        assert_equal("вiсiмнадцять гривень 00 копійок", moneyToStrUAH.convert(V_18D));
        assert_equal("дев'ятнадцять гривень 00 копійок", moneyToStrUAH.convert(V_19D));
        assert_equal("одна гривня 00 копійок", moneyToStrUAH.convert(V_1D));
        assert_equal("дві гривні 00 копійок", moneyToStrUAH.convert(V_2D));
        assert_equal("тридцять одна гривня 00 копійок", moneyToStrUAH.convert(V_31D));
        assert_equal("тридцять дві гривні 00 копійок", moneyToStrUAH.convert(V_32D));
        assert_equal("одна тисяча гривень 00 копійок", moneyToStrUAH.convert(V_1000D));
        assert_equal("дві тисячі гривень 00 копійок", moneyToStrUAH.convert(V_2000D));
        assert_equal("п’ять тисяч гривень 00 копійок", moneyToStrUAH.convert(V_5000D));
        assert_equal("один мільйон гривень 00 копійок", moneyToStrUAH.convert(V_1000000D));
        assert_equal("два мільйона гривень 00 копійок", moneyToStrUAH.convert(V_2000000D));
        assert_equal("п’ять мільйонів гривень 00 копійок", moneyToStrUAH.convert(V_5000000D));
        assert_equal("один мільярд гривень 00 копійок", moneyToStrUAH.convert(V_1000000000D));
        assert_equal("два мільярда гривень 00 копійок", moneyToStrUAH.convert(V_2000000000D));
        assert_equal("п’ять мільярдів гривень 00 копійок", moneyToStrUAH.convert(V_5000000000D));
        assert_equal("один трильйон гривень 00 копійок", moneyToStrUAH.convert(V_1000000000000D));
        assert_equal("два трильйона гривень 00 копійок", moneyToStrUAH.convert(V_2000000000000D));
        assert_equal("п’ять трильйонів гривень 00 копійок", moneyToStrUAH.convert(V_5000000000000D));
        assert_equal("одна гривня 01 копійка", moneyToStrUAH.convert(V_1_01D));
        assert_equal("одна гривня 02 копійки", moneyToStrUAH.convert(V_1_02D));
    }

    /** checkRUR. */
    def test_checkRUR() = {
        assert_equal("семьсот семьдесят семь рублей 77 копеек", moneyToStrRUR.convert(V_777_77D));
    }

    /** checkUSD_ENG. */
    def test_checkUSDENG() = {
        assert_equal("one dollar and zero cents", moneyToStrUSDENG.convert(1));
        assert_equal("two dollars and zero cents", moneyToStrUSDENG.convert(2));
        assert_equal("three dollars and zero cents", moneyToStrUSDENG.convert(3));
        assert_equal("four dollars and zero cents", moneyToStrUSDENG.convert(4));
        assert_equal("five dollars and zero cents", moneyToStrUSDENG.convert(5));
        assert_equal("six dollars and zero cents", moneyToStrUSDENG.convert(6));
        assert_equal("seven dollars and zero cents", moneyToStrUSDENG.convert(7));
        assert_equal("eight dollars and zero cents", moneyToStrUSDENG.convert(8));
        assert_equal("nine dollars and zero cents", moneyToStrUSDENG.convert(9));
        assert_equal("ten dollars and zero cents", moneyToStrUSDENG.convert(10));
        assert_equal("eleven dollars and zero cents", moneyToStrUSDENG.convert(11));
        assert_equal("twelve dollars and zero cents", moneyToStrUSDENG.convert(12));
        assert_equal("thirteen dollars and zero cents", moneyToStrUSDENG.convert(13));
        assert_equal("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two "
            + "million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents",
        moneyToStrUSDENG.convert(27451632459870.49));
    }

    /** checkPER100. */
    def test_checkPER100() = {
        assert_equal("одна целая, одна сотая процента", moneyToStrPER100.convert(V_1_01D));
        assert_equal("одна целая, десять сотых процента", moneyToStrPER100.convert(V_1_1D));
        assert_equal("одна целая, две сотых процента", moneyToStrPER100.convert(V_1_02D));
        assert_equal("одна целая, одиннадцать сотых процента", moneyToStrPER100.convert(V_1_11D));
        assert_equal("две целых, две сотых процента", moneyToStrPER100.convert(V_2_02D));
        assert_equal("пять целых, пять сотых процента", moneyToStrPER100.convert(V_5_05D));
    }

    def test_checkPER1000() = {
        assert_equal("двенадцать целых, триста сорок шесть тысячных процента", moneyToStrPER1000.convert(12.346));
    }

    def test_percentToStr() = {
        assert_equal("двенадцать целых, ноль десятых процента", MoneyToStr.percentToStr(12, "RUS"));
    }

    /** check percentToStr. */
    def test_checkPercentToStrRus() = {
        assert_equal("одна целая, одна сотая процента", MoneyToStr.percentToStr(V_1_01D, "RUS"));
        assert_equal("одна целая, одна десятая процента", MoneyToStr.percentToStr(V_1_1D, "RUS"));
        assert_equal("одна целая, две сотых процента", MoneyToStr.percentToStr(V_1_02D, "RUS"));
        assert_equal("одна целая, одиннадцать сотых процента", MoneyToStr.percentToStr(V_1_11D, "RUS"));
        assert_equal("две целых, две сотых процента", MoneyToStr.percentToStr(V_2_02D, "RUS"));
        assert_equal("пять целых, пять сотых процента", MoneyToStr.percentToStr(V_5_05D, "RUS"));
        assert_equal("пять целых, пять десятитысячных процента", MoneyToStr.percentToStr(V_5_0005D, "RUS"));
    }

    def main(args: Array[String]) {
        setup()
        test_checkUAH()
        test_checkRUR()
        test_checkUSDENG()
        test_checkPER100()
        test_checkPER1000()
        test_percentToStr()
        test_checkPercentToStrRus()
        println("7 tests were run: test_checkUAH(), test_checkRUR(), test_checkUSDENG(), test_checkPER100(), test_checkPER1000(), test_percentToStr(), test_checkPercentToStrRus()")
    }
}
