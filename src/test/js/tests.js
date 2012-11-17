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
    }
});

test( "checkUAH", function() {
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
