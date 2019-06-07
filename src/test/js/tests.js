Class.Mutators.Static = function(items){
    this.extend(items);
};
var Const = new Class({
Static: {
    V_12L: 12,
    V_123L: 123,
    V_11D: 11,
    V_12D: 12,
    V_11_12D: 11.12,
    V_12_11D: 12.11,
    V_300D: 300,
    V_400D: 400,
    V_700D: 700,
    V_800D: 800,
    V_50D: 50,
    V_60D: 60,
    V_13D: 13,
    V_14D: 14,
    V_15D: 15,
    V_16D: 16,
    V_17D: 17,
    V_18D: 18,
    V_19D: 19,
    V_31D: 31,
    V_978637287197540L: 978637287197540,
    V_234978637287197540L: 234978637287197540,
    V_32D: 32,
    V_1000D: 1000,
    V_2000D: 2000,
    V_5000D: 5000,
    V_1000000D: 1000000,
    V_2000000D: 2000000,
    V_5000000D: 5000000,
    V_1000000000D: 1000000000,
    V_2000000000D: 2000000000,
    V_5000000000D: 5000000000,
    V_1000000000000D: 1000000000000,
    V_2000000000000D: 2000000000000,
    V_5000000000000D: 5000000000000,
    V_1D: 1,
    V_2D: 2,
    V_3D: 3,
    V_4D: 4,
    V_5D: 5,
    V_6D: 6,
    V_7D: 7,
    V_8D: 8,
    V_9D: 9,
    V_123D: 123,
    V_1_1D: 1.1,
    V_1_01D: 1.01,
    V_1_02D: 1.02,
    V_1_11D: 1.11,
    V_2_02D: 2.02,
    V_5_05D: 5.05,
    V_5_0005D: 5.0005,
    V_777_77D: 777.77
}
});

module( "tests", {
    setup: function() {
        this.moneyToStrUAH = new MoneyToStr(Currency.UAH, Language.UKR, Pennies.NUMBER);
        this.moneyToStrUAHRUS = new MoneyToStr(Currency.UAH, Language.RUS, Pennies.NUMBER);
        this.moneyToStrRUR = new MoneyToStr(Currency.RUR, Language.RUS, Pennies.NUMBER);
        this.moneyToStrPER100 = new MoneyToStr(Currency.PER100, Language.RUS, Pennies.TEXT);
        this.moneyToStrPER1000 = new MoneyToStr(Currency.PER1000, Language.RUS, Pennies.TEXT);
        this.moneyToStrUSDENG =  new MoneyToStr(Currency.USD, Language.ENG, Pennies.TEXT);
        this.moneyToStrEURENG =  new MoneyToStr(Currency.EUR, Language.ENG, Pennies.TEXT);
    }
});

test( "checkUAH", function() {
    equal("нуль гривень 00 копійок", this.moneyToStrUAH.convertValue(0));
    equal("триста гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_300D));
    equal("дев’ятсот сімдесят вісім трильйонів шістсот " + "тридцять сім мільярдів "
            + "двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч "
            + "п’ятсот сорок гривень 12 копійок", this.moneyToStrUAH.convert(Const.V_978637287197540L, Const.V_12L));
    equal("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот "
            + "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч "
            + "п’ятсот тридцять шість гривень 12 копійок", this.moneyToStrUAH.convert(Const.V_234978637287197540L, Const.V_12L));
    equal("одинадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_11D));
    equal("дванадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_12D));
    equal("одинадцять гривень 12 копійок", this.moneyToStrUAH.convertValue(Const.V_11_12D));
    equal("дванадцять гривень 11 копійок", this.moneyToStrUAH.convertValue(Const.V_12_11D));
    equal("триста гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_300D));
    equal("чотириста гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_400D));
    equal("сімсот гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_700D));
    equal("вісімсот гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_800D));
    equal("п’ятдесят гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_50D));
    equal("шістдесят гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_60D));
    equal("тринадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_13D));
    equal("чотирнадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_14D));
    equal("п’ятнадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_15D));
    equal("шiстнадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_16D));
    equal("сiмнадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_17D));
    equal("вiсiмнадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_18D));
    equal("дев'ятнадцять гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_19D));
    equal("одна гривня 00 копійок", this.moneyToStrUAH.convertValue(Const.V_1D));
    equal("дві гривні 00 копійок", this.moneyToStrUAH.convertValue(Const.V_2D));
    equal("тридцять одна гривня 00 копійок", this.moneyToStrUAH.convertValue(Const.V_31D));
    equal("тридцять дві гривні 00 копійок", this.moneyToStrUAH.convertValue(Const.V_32D));
    equal("одна тисяча гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_1000D));
    equal("дві тисячі гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_2000D));
    equal("п’ять тисяч гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_5000D));
    equal("один мільйон гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_1000000D));
    equal("два мільйона гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_2000000D));
    equal("п’ять мільйонів гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_5000000D));
    equal("один мільярд гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_1000000000D));
    equal("два мільярда гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_2000000000D));
    equal("п’ять мільярдів гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_5000000000D));
    equal("один трильйон гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_1000000000000D));
    equal("два трильйона гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_2000000000000D));
    equal("п’ять трильйонів гривень 00 копійок", this.moneyToStrUAH.convertValue(Const.V_5000000000000D));
    equal("одна гривня 01 копійка", this.moneyToStrUAH.convertValue(Const.V_1_01D));
    equal("одна гривня 02 копійки", this.moneyToStrUAH.convertValue(Const.V_1_02D));
});
test( "checkRUR", function() {
    equal(this.moneyToStrRUR.convertValue(Const.V_777_77D), "семьсот семьдесят семь рублей 77 копеек");
});
test( "checkUAHUKRMinus", function() {
    equal(this.moneyToStrUAH.convertValue(-Const.V_300D), "мінус триста гривень 00 копійок");
    equal(this.moneyToStrUAH.convertValue(-Const.V_11_12D), "мінус одинадцять гривень 12 копійок");
});
test( "checkUAHRUSMinus", function() {
    equal(this.moneyToStrUAHRUS.convertValue(-Const.V_300D), "минус триста гривень 00 копеек");
    equal(this.moneyToStrUAHRUS.convertValue(-Const.V_11_12D), "минус одиннадцать гривень 12 копеек");
});
test( "checkPER100", function() {
    equal("одна целая, одна сотая процента", this.moneyToStrPER100.convertValue(Const.V_1_01D));
    equal("одна целая, десять сотых процента", this.moneyToStrPER100.convertValue(Const.V_1_1D));
    equal("одна целая, две сотых процента", this.moneyToStrPER100.convertValue(Const.V_1_02D));
    equal("одна целая, одиннадцать сотых процента", this.moneyToStrPER100.convertValue(Const.V_1_11D));
    equal("две целых, две сотых процента", this.moneyToStrPER100.convertValue(Const.V_2_02D));
    equal("пять целых, пять сотых процента", this.moneyToStrPER100.convertValue(Const.V_5_05D));
});
test( "checkPER1000", function() {
    equal("двенадцать целых, триста сорок шесть тысячных процента", this.moneyToStrPER1000.convertValue(12.346));
});
test( "checkPercentToStrRus", function() {
    equal("одна целая, одна сотая процента", MoneyToStr.percentToStr(Const.V_1_01D, Language.RUS));
    equal("одна целая, одна десятая процента", MoneyToStr.percentToStr(Const.V_1_1D, Language.RUS));
    equal("одна целая, две сотых процента", MoneyToStr.percentToStr(Const.V_1_02D, Language.RUS));
    equal("одна целая, одиннадцать сотых процента", MoneyToStr.percentToStr(Const.V_1_11D, Language.RUS));
    equal("две целых, две сотых процента", MoneyToStr.percentToStr(Const.V_2_02D, Language.RUS));
    equal("пять целых, пять сотых процента", MoneyToStr.percentToStr(Const.V_5_05D, Language.RUS));
    equal("пять целых, пять десятитысячных процента", MoneyToStr.percentToStr(Const.V_5_0005D, Language.RUS));
});
test( "checkUSD_ENG", function() {
    equal("one dollar and zero cents", this.moneyToStrUSDENG.convertValue(1));
    equal("two dollars and zero cents", this.moneyToStrUSDENG.convertValue(2));
    equal("three dollars and zero cents", this.moneyToStrUSDENG.convertValue(3));
    equal("four dollars and zero cents", this.moneyToStrUSDENG.convertValue(4));
    equal("five dollars and zero cents", this.moneyToStrUSDENG.convertValue(5));
    equal("six dollars and zero cents", this.moneyToStrUSDENG.convertValue(6));
    equal("seven dollars and zero cents", this.moneyToStrUSDENG.convertValue(7));
    equal("eight dollars and zero cents", this.moneyToStrUSDENG.convertValue(8));
    equal("nine dollars and zero cents", this.moneyToStrUSDENG.convertValue(9));
    equal("ten dollars and zero cents", this.moneyToStrUSDENG.convertValue(10));
    equal("eleven dollars and zero cents", this.moneyToStrUSDENG.convertValue(11));
    equal("twelve dollars and zero cents", this.moneyToStrUSDENG.convertValue(12));
    equal("thirteen dollars and zero cents", this.moneyToStrUSDENG.convertValue(13));
    equal("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two "
        + "million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents",
    this.moneyToStrUSDENG.convertValue(27451632459870.49));
});
test( "checkEUR_ENG", function() {
    equal("one euro and zero cents", this.moneyToStrEURENG.convertValue(1));
    equal("two euros and zero cents", this.moneyToStrEURENG.convertValue(2));
    equal("three euros and zero cents", this.moneyToStrEURENG.convertValue(3));
    equal("four euros and zero cents", this.moneyToStrEURENG.convertValue(4));
    equal("five euros and zero cents", this.moneyToStrEURENG.convertValue(5));
    equal("six euros and zero cents", this.moneyToStrEURENG.convertValue(6));
    equal("seven euros and zero cents", this.moneyToStrEURENG.convertValue(7));
    equal("eight euros and zero cents", this.moneyToStrEURENG.convertValue(8));
    equal("nine euros and zero cents", this.moneyToStrEURENG.convertValue(9));
    equal("ten euros and zero cents", this.moneyToStrEURENG.convertValue(10));
    equal("eleven euros and zero cents", this.moneyToStrEURENG.convertValue(11));
    equal("twelve euros and zero cents", this.moneyToStrEURENG.convertValue(12));
    equal("thirteen euros and zero cents", this.moneyToStrEURENG.convertValue(13));
    equal("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two "
        + "million four hundred fifty-nine thousand eight hundred seventy euros and forty-nine cents",
    this.moneyToStrEURENG.convertValue(27451632459870.49));
});
