# moneytostr.test.coffee

conv = require '../../main/coffee/moneytostr.coffee'

Const = (->
  Const = ->
  Const.V_12L = 12
  Const.V_123L = 123
  Const.V_11D = 11
  Const.V_12D = 12
  Const.V_11_12D = 11.12
  Const.V_12_11D = 12.11
  Const.V_300D = 300
  Const.V_400D = 400
  Const.V_700D = 700
  Const.V_800D = 800
  Const.V_50D = 50
  Const.V_60D = 60
  Const.V_13D = 13
  Const.V_14D = 14
  Const.V_15D = 15
  Const.V_16D = 16
  Const.V_17D = 17
  Const.V_18D = 18
  Const.V_19D = 19
  Const.V_31D = 31
  Const.V_978637287197540L = 978637287197540
  Const.V_234978637287197540L = 234978637287197540
  Const.V_32D = 32
  Const.V_1000D = 1000
  Const.V_2000D = 2000
  Const.V_5000D = 5000
  Const.V_1000000D = 1000000
  Const.V_2000000D = 2000000
  Const.V_5000000D = 5000000
  Const.V_1000000000D = 1000000000
  Const.V_2000000000D = 2000000000
  Const.V_5000000000D = 5000000000
  Const.V_1000000000000D = 1000000000000
  Const.V_2000000000000D = 2000000000000
  Const.V_5000000000000D = 5000000000000
  Const.V_1D = 1
  Const.V_2D = 2
  Const.V_3D = 3
  Const.V_4D = 4
  Const.V_5D = 5
  Const.V_6D = 6
  Const.V_7D = 7
  Const.V_8D = 8
  Const.V_9D = 9
  Const.V_123D = 123
  Const.V_1_1D = 1.1
  Const.V_1_01D = 1.01
  Const.V_1_02D = 1.02
  Const.V_1_11D = 1.11
  Const.V_2_02D = 2.02
  Const.V_5_05D = 5.05
  Const.V_5_0005D = 5.0005
  Const.V_777_77D = 777.77
  Const
)()

moneyToStrUAH = new conv.MoneyToStr(conv.Currency.UAH, conv.Language.UKR, conv.Pennies.NUMBER)
moneyToStrRUR = new conv.MoneyToStr(conv.Currency.RUR, conv.Language.RUS, conv.Pennies.NUMBER)
moneyToStrPER100 = new conv.MoneyToStr(conv.Currency.PER100, conv.Language.RUS, conv.Pennies.TEXT)
moneyToStrPER1000 = new conv.MoneyToStr(conv.Currency.PER1000, conv.Language.RUS, conv.Pennies.TEXT)
moneyToStrUSDENG =  new conv.MoneyToStr(conv.Currency.USD, conv.Language.ENG, conv.Pennies.TEXT)

equal = (expected, actual) ->
  throw new Error(expected + " != " + actual) if expected != actual
  
test_checkUAH = ()->
    equal("нуль гривень 00 копійок", moneyToStrUAH.convertValue(0))
    equal("триста гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_300D))
    equal("дев’ятсот сімдесят вісім трильйонів шістсот " + "тридцять сім мільярдів " +
            "двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч " +
            "п’ятсот сорок гривень 12 копійок", moneyToStrUAH.convert(Const.V_978637287197540L, Const.V_12L));
    equal("двісті тридцять чотири ??? дев’ятсот сімдесят вісім трильйонів шістсот " +
            "тридцять сім мільярдів двісті вісімдесят сім мільйонів сто " + "дев’яносто сім тисяч " +
            "п’ятсот тридцять шість гривень 12 копійок", moneyToStrUAH.convert(Const.V_234978637287197540L, Const.V_12L));
    equal("одинадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_11D));
    equal("дванадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_12D));
    equal("одинадцять гривень 12 копійок", moneyToStrUAH.convertValue(Const.V_11_12D));
    equal("дванадцять гривень 11 копійок", moneyToStrUAH.convertValue(Const.V_12_11D));
    equal("триста гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_300D));
    equal("чотириста гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_400D));
    equal("сімсот гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_700D));
    equal("вісімсот гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_800D));
    equal("п’ятдесят гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_50D));
    equal("шістдесят гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_60D));
    equal("тринадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_13D));
    equal("чотирнадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_14D));
    equal("п’ятнадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_15D));
    equal("шiстнадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_16D));
    equal("сiмнадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_17D));
    equal("вiсiмнадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_18D));
    equal("дев'ятнадцять гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_19D));
    equal("одна гривня 00 копійок", moneyToStrUAH.convertValue(Const.V_1D));
    equal("дві гривні 00 копійок", moneyToStrUAH.convertValue(Const.V_2D));
    equal("тридцять одна гривня 00 копійок", moneyToStrUAH.convertValue(Const.V_31D));
    equal("тридцять дві гривні 00 копійок", moneyToStrUAH.convertValue(Const.V_32D));
    equal("одна тисяча гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_1000D));
    equal("дві тисячі гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_2000D));
    equal("п’ять тисяч гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_5000D));
    equal("один мільйон гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_1000000D));
    equal("два мільйона гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_2000000D));
    equal("п’ять мільйонів гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_5000000D));
    equal("один мільярд гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_1000000000D));
    equal("два мільярда гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_2000000000D));
    equal("п’ять мільярдів гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_5000000000D));
    equal("один трильйон гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_1000000000000D));
    equal("два трильйона гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_2000000000000D));
    equal("п’ять трильйонів гривень 00 копійок", moneyToStrUAH.convertValue(Const.V_5000000000000D));
    equal("одна гривня 01 копійка", moneyToStrUAH.convertValue(Const.V_1_01D));
    equal("одна гривня 02 копійки", moneyToStrUAH.convertValue(Const.V_1_02D));

test_checkRUR = ()->
    equal("семьсот семьдесят семь рублей 77 копеек", moneyToStrRUR.convertValue(Const.V_777_77D));

test_checkPER100 = ()->
    equal("одна целая, одна сотая процента", moneyToStrPER100.convertValue(Const.V_1_01D));
    equal("одна целая, десять сотых процента", moneyToStrPER100.convertValue(Const.V_1_1D));
    equal("одна целая, две сотых процента", moneyToStrPER100.convertValue(Const.V_1_02D));
    equal("одна целая, одиннадцать сотых процента", moneyToStrPER100.convertValue(Const.V_1_11D));
    equal("две целых, две сотых процента", moneyToStrPER100.convertValue(Const.V_2_02D));
    equal("пять целых, пять сотых процента", moneyToStrPER100.convertValue(Const.V_5_05D));

test_checkPER1000 = ()->
    equal("двенадцать целых, триста сорок шесть тысячных процента", moneyToStrPER1000.convertValue(12.346));

test_checkPercentToStrRus = ()->
    equal("одна целая, одна сотая процента", conv.MoneyToStr.percentToStr(Const.V_1_01D, conv.Language.RUS));
    equal("одна целая, одна десятая процента", conv.MoneyToStr.percentToStr(Const.V_1_1D, conv.Language.RUS));
    equal("одна целая, две сотых процента", conv.MoneyToStr.percentToStr(Const.V_1_02D, conv.Language.RUS));
    equal("одна целая, одиннадцать сотых процента", conv.MoneyToStr.percentToStr(Const.V_1_11D, conv.Language.RUS));
    equal("две целых, две сотых процента", conv.MoneyToStr.percentToStr(Const.V_2_02D, conv.Language.RUS));
    equal("пять целых, пять сотых процента", conv.MoneyToStr.percentToStr(Const.V_5_05D, conv.Language.RUS));
    equal("пять целых, пять десятитысячных процента", conv.MoneyToStr.percentToStr(Const.V_5_0005D, conv.Language.RUS));

test_checkUSD_ENG = ()->
    equal("one dollar and zero cents", moneyToStrUSDENG.convertValue(1));
    equal("two dollars and zero cents", moneyToStrUSDENG.convertValue(2));
    equal("three dollars and zero cents", moneyToStrUSDENG.convertValue(3));
    equal("four dollars and zero cents", moneyToStrUSDENG.convertValue(4));
    equal("five dollars and zero cents", moneyToStrUSDENG.convertValue(5));
    equal("six dollars and zero cents", moneyToStrUSDENG.convertValue(6));
    equal("seven dollars and zero cents", moneyToStrUSDENG.convertValue(7));
    equal("eight dollars and zero cents", moneyToStrUSDENG.convertValue(8));
    equal("nine dollars and zero cents", moneyToStrUSDENG.convertValue(9));
    equal("ten dollars and zero cents", moneyToStrUSDENG.convertValue(10));
    equal("eleven dollars and zero cents", moneyToStrUSDENG.convertValue(11));
    equal("twelve dollars and zero cents", moneyToStrUSDENG.convertValue(12));
    equal("thirteen dollars and zero cents", moneyToStrUSDENG.convertValue(13));
    equal("twenty-seven trillion four hundred fifty-one billion six hundred thirty-two " +
        "million four hundred fifty-nine thousand eight hundred seventy dollars and forty-nine cents",
    moneyToStrUSDENG.convertValue(27451632459870.49));

test_checkUAH()
test_checkRUR()
test_checkPER100()
test_checkPER1000()
test_checkPercentToStrRus()
test_checkUSD_ENG()
console.log "Tests were run test_checkUAH() test_checkRUR() test_checkPER100() test_checkPER1000() test_checkPercentToStrRus() test_checkUSD_ENG()"
