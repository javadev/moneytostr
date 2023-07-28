/*
 * $Id$
 *
 * Copyright 2014 Valentyn Kolesnikov
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
package com.github.moneytostr;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Converts numbers to symbols.
 *
 * @author Valentyn Kolesnikov
 * @version $Revision$ $Date$
 */
public class MoneyToStr {
    private static final int INDEX_3 = 3;
    private static final int INDEX_2 = 2;
    private static final int INDEX_1 = 1;
    private static final int INDEX_0 = 0;
    private static Map<String, Object> jsonMap;
    private static final int NUM0 = 0;
    private static final int NUM1 = 1;
    private static final int NUM2 = 2;
    private static final int NUM3 = 3;
    private static final int NUM4 = 4;
    private static final int NUM5 = 5;
    private static final int NUM6 = 6;
    private static final int NUM7 = 7;
    private static final int NUM8 = 8;
    private static final int NUM9 = 9;
    private static final int NUM10 = 10;
    private static final int NUM11 = 11;
    private static final int NUM14 = 14;
    private static final int NUM100 = 100;
    private static final int NUM1000 = 1000;
    private static final int NUM10000 = 10000;
    private static final String CURRENCY_LIST =
            "{\n"
                    + "  \"CurrencyList\": {\n"
                    + "    \"language\": {\n"
                    + "      \"-value\": \"UKR\"\n"
                    + "    },\n"
                    + "    \"UKR\": {\n"
                    + "      \"item\": [\n"
                    + "        {\n"
                    + "          \"-value\": \"minus\",\n"
                    + "          \"-text\": \"мінус\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"0\",\n"
                    + "          \"-text\": \"нуль\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_10\",\n"
                    + "          \"-text\": \"тисяч,мільйонів,мільярдів,трильйонів\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_1\",\n"
                    + "          \"-text\": \"тисяча,мільйон,мільярд,трильйон\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_234\",\n"
                    + "          \"-text\": \"тисячі,мільйона,мільярда,трильйона\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_5\",\n"
                    + "          \"-text\": \"тисяч,мільйонів,мільярдів,трильйонів\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"10_19\",\n"
                    + "          \"-text\": \"десять,одинадцять,дванадцять,тринадцять,чотирнадцять,п'ятнадцять,шістнадцять,сімнадцять,вісімнадцять,дев'ятнадцять\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1\",\n"
                    + "          \"-text\": \"одна,один,один,одна\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"2\",\n"
                    + "          \"-text\": \"дві,два,два,дві\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"3_9\",\n"
                    + "          \"-text\": \"три,чотири,п'ять,шість,сім,вісім,дев'ять\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"100_900\",\n"
                    + "          \"-text\": \"сто ,двісті ,триста ,чотириста ,п'ятсот ,шістсот ,сімсот ,вісімсот ,дев'ятсот \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"20_90\",\n"
                    + "          \"-text\": \"двадцять ,тридцять ,сорок ,п'ятдесят ,шістдесят ,сімдесят ,вісімдесят ,дев'яносто \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"pdv\",\n"
                    + "          \"-text\": \"в т.ч. ПДВ \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"pdv_value\",\n"
                    + "          \"-text\": \"20\"\n"
                    + "        }\n"
                    + "      ]\n"
                    + "    },\n"
                    + "    \"RUS\": {\n"
                    + "      \"item\": [\n"
                    + "        {\n"
                    + "          \"-value\": \"minus\",\n"
                    + "          \"-text\": \"минус\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"0\",\n"
                    + "          \"-text\": \"ноль\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_10\",\n"
                    + "          \"-text\": \"тысяч,миллионов,миллиардов,триллионов\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_1\",\n"
                    + "          \"-text\": \"тысяча,миллион,миллиард,триллион\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_234\",\n"
                    + "          \"-text\": \"тысячи,миллиона,миллиарда,триллиона\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_5\",\n"
                    + "          \"-text\": \"тысяч,миллионов,миллиардов,триллионов\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"10_19\",\n"
                    + "          \"-text\": \"десять,одиннадцать,двенадцать,тринадцать,четырнадцать,пятнадцать,шестнадцать,семнадцать,восемнадцать,девятнадцать\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1\",\n"
                    + "          \"-text\": \"одна,один,один,одна\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"2\",\n"
                    + "          \"-text\": \"две,два,два,две\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"3_9\",\n"
                    + "          \"-text\": \"три,четыре,пять,шесть,семь,восемь,девять\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"100_900\",\n"
                    + "          \"-text\": \"сто ,двести ,триста ,четыреста ,пятьсот ,шестьсот ,семьсот ,восемьсот ,девятьсот \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"20_90\",\n"
                    + "          \"-text\": \"двадцать ,тридцать ,сорок ,пятьдесят ,шестьдесят ,семьдесят ,восемьдесят ,девяносто \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"pdv\",\n"
                    + "          \"-text\": \"в т.ч. НДС \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"pdv_value\",\n"
                    + "          \"-text\": \"18\"\n"
                    + "        }\n"
                    + "      ]\n"
                    + "    },\n"
                    + "    \"ENG\": {\n"
                    + "      \"item\": [\n"
                    + "        {\n"
                    + "          \"-value\": \"minus\",\n"
                    + "          \"-text\": \"minus\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"0\",\n"
                    + "          \"-text\": \"zero\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_10\",\n"
                    + "          \"-text\": \"thousand,million,billion,trillion\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_1\",\n"
                    + "          \"-text\": \"thousand,million,billion,trillion\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_234\",\n"
                    + "          \"-text\": \"thousand,million,billion,trillion\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1000_5\",\n"
                    + "          \"-text\": \"thousand,million,billion,trillion\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"10_19\",\n"
                    + "          \"-text\": \"ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"1\",\n"
                    + "          \"-text\": \"one,one,one,one\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"2\",\n"
                    + "          \"-text\": \"two,two,two,two\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"3_9\",\n"
                    + "          \"-text\": \"three,four,five,six,seven,eight,nine\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"100_900\",\n"
                    + "          \"-text\": \"one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"20_90\",\n"
                    + "          \"-text\": \"twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-\"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"pdv\",\n"
                    + "          \"-text\": \"including VAT \"\n"
                    + "        },\n"
                    + "        {\n"
                    + "          \"-value\": \"pdv_value\",\n"
                    + "          \"-text\": \"10\"\n"
                    + "        }\n"
                    + "      ]\n"
                    + "    },\n"
                    + "    \"RUR\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"810\",\n"
                    + "        \"-CurrName\": \"Российские рубли\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"рубль\",\n"
                    + "        \"-RubTwoUnit\": \"рубля\",\n"
                    + "        \"-RubFiveUnit\": \"рублей\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"руб.\",\n"
                    + "        \"-KopOneUnit\": \"копейка\",\n"
                    + "        \"-KopTwoUnit\": \"копейки\",\n"
                    + "        \"-KopFiveUnit\": \"копеек\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"810\",\n"
                    + "        \"-CurrName\": \"Российские рубли\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"рубль\",\n"
                    + "        \"-RubTwoUnit\": \"рублі\",\n"
                    + "        \"-RubFiveUnit\": \"рублів\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"руб.\",\n"
                    + "        \"-KopOneUnit\": \"копійка\",\n"
                    + "        \"-KopTwoUnit\": \"копійки\",\n"
                    + "        \"-KopFiveUnit\": \"копійок\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"810\",\n"
                    + "        \"-CurrName\": \"Российские рубли\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \"ruble\",\n"
                    + "        \"-RubTwoUnit\": \"rubles\",\n"
                    + "        \"-RubFiveUnit\": \"rubles\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"RUR.\",\n"
                    + "        \"-KopOneUnit\": \"kopeck\",\n"
                    + "        \"-KopTwoUnit\": \"kopecks\",\n"
                    + "        \"-KopFiveUnit\": \"kopecks\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"UAH\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"980\",\n"
                    + "        \"-CurrName\": \"Украинскі гривні\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"гривня\",\n"
                    + "        \"-RubTwoUnit\": \"гривни\",\n"
                    + "        \"-RubFiveUnit\": \"гривень\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-RubShortUnit\": \"грн.\",\n"
                    + "        \"-KopOneUnit\": \"копейка\",\n"
                    + "        \"-KopTwoUnit\": \"копейки\",\n"
                    + "        \"-KopFiveUnit\": \"копеек\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"980\",\n"
                    + "        \"-CurrName\": \"Украинскі гривні\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"гривня\",\n"
                    + "        \"-RubTwoUnit\": \"гривні\",\n"
                    + "        \"-RubFiveUnit\": \"гривень\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-RubShortUnit\": \"грн.\",\n"
                    + "        \"-KopOneUnit\": \"копійка\",\n"
                    + "        \"-KopTwoUnit\": \"копійки\",\n"
                    + "        \"-KopFiveUnit\": \"копійок\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"980\",\n"
                    + "        \"-CurrName\": \"Украинскі гривні\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \"hryvnia\",\n"
                    + "        \"-RubTwoUnit\": \"hryvnias\",\n"
                    + "        \"-RubFiveUnit\": \"hryvnias\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"UAH.\",\n"
                    + "        \"-KopOneUnit\": \"kopeck\",\n"
                    + "        \"-KopTwoUnit\": \"kopecks\",\n"
                    + "        \"-KopFiveUnit\": \"kopecks\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"USD\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"840\",\n"
                    + "        \"-CurrName\": \"Долари США\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"доллар\",\n"
                    + "        \"-RubTwoUnit\": \"доллара\",\n"
                    + "        \"-RubFiveUnit\": \"долларов\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"дол.\",\n"
                    + "        \"-KopOneUnit\": \"цент\",\n"
                    + "        \"-KopTwoUnit\": \"цента\",\n"
                    + "        \"-KopFiveUnit\": \"центов\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"840\",\n"
                    + "        \"-CurrName\": \"Долари США\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"долар\",\n"
                    + "        \"-RubTwoUnit\": \"долара\",\n"
                    + "        \"-RubFiveUnit\": \"доларів\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"дол.\",\n"
                    + "        \"-KopOneUnit\": \"цент\",\n"
                    + "        \"-KopTwoUnit\": \"цента\",\n"
                    + "        \"-KopFiveUnit\": \"центів\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"840\",\n"
                    + "        \"-CurrName\": \"Долари США\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \"dollar\",\n"
                    + "        \"-RubTwoUnit\": \"dollars\",\n"
                    + "        \"-RubFiveUnit\": \"dollars\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"USD.\",\n"
                    + "        \"-KopOneUnit\": \"cent\",\n"
                    + "        \"-KopTwoUnit\": \"cents\",\n"
                    + "        \"-KopFiveUnit\": \"cents\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"EUR\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"840\",\n"
                    + "        \"-CurrName\": \"Евро ЕС\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"евро\",\n"
                    + "        \"-RubTwoUnit\": \"евро\",\n"
                    + "        \"-RubFiveUnit\": \"евро\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"евр.\",\n"
                    + "        \"-KopOneUnit\": \"цент\",\n"
                    + "        \"-KopTwoUnit\": \"цента\",\n"
                    + "        \"-KopFiveUnit\": \"центов\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"840\",\n"
                    + "        \"-CurrName\": \"Евро ЕС\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"євро\",\n"
                    + "        \"-RubTwoUnit\": \"євро\",\n"
                    + "        \"-RubFiveUnit\": \"євро\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"дол.\",\n"
                    + "        \"-KopOneUnit\": \"цент\",\n"
                    + "        \"-KopTwoUnit\": \"цента\",\n"
                    + "        \"-KopFiveUnit\": \"центів\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"840\",\n"
                    + "        \"-CurrName\": \"Долари США\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \"euro\",\n"
                    + "        \"-RubTwoUnit\": \"euros\",\n"
                    + "        \"-RubFiveUnit\": \"euros\",\n"
                    + "        \"-RubSex\": \"M\",\n"
                    + "        \"-RubShortUnit\": \"USD.\",\n"
                    + "        \"-KopOneUnit\": \"cent\",\n"
                    + "        \"-KopTwoUnit\": \"cents\",\n"
                    + "        \"-KopFiveUnit\": \"cents\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"PER10\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"556\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з десятими частинами\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"целая,\",\n"
                    + "        \"-RubTwoUnit\": \"целых,\",\n"
                    + "        \"-RubFiveUnit\": \"целых,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"десятая процента\",\n"
                    + "        \"-KopTwoUnit\": \"десятых процента\",\n"
                    + "        \"-KopFiveUnit\": \"десятых процента\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"556\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з десятими частинами\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"ціла,\",\n"
                    + "        \"-RubTwoUnit\": \"цілих,\",\n"
                    + "        \"-RubFiveUnit\": \"цілих,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"десята відсотка\",\n"
                    + "        \"-KopTwoUnit\": \"десятих відсотка\",\n"
                    + "        \"-KopFiveUnit\": \"десятих відсотка\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"560\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з десятими частинами\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \",\",\n"
                    + "        \"-RubTwoUnit\": \"integers,\",\n"
                    + "        \"-RubFiveUnit\": \"integers,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"tenth of one percent\",\n"
                    + "        \"-KopTwoUnit\": \"tenth of one percent\",\n"
                    + "        \"-KopFiveUnit\": \"tenth of one percent\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"PER100\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"557\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з сотими частинами\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"целая,\",\n"
                    + "        \"-RubTwoUnit\": \"целых,\",\n"
                    + "        \"-RubFiveUnit\": \"целых,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"сотая процента\",\n"
                    + "        \"-KopTwoUnit\": \"сотых процента\",\n"
                    + "        \"-KopFiveUnit\": \"сотых процента\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"557\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з сотими частинами\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"ціла,\",\n"
                    + "        \"-RubTwoUnit\": \"цілих,\",\n"
                    + "        \"-RubFiveUnit\": \"цілих,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"сота відсотка\",\n"
                    + "        \"-KopTwoUnit\": \"сотих відсотка\",\n"
                    + "        \"-KopFiveUnit\": \"сотих відсотка\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"561\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з сотими частинами\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \",\",\n"
                    + "        \"-RubTwoUnit\": \"integers,\",\n"
                    + "        \"-RubFiveUnit\": \"integers,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"hundred percent\",\n"
                    + "        \"-KopTwoUnit\": \"hundredth of percent\",\n"
                    + "        \"-KopFiveUnit\": \"hundredth of percent\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"PER1000\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"558\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з тисячними частинами\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"целая,\",\n"
                    + "        \"-RubTwoUnit\": \"целых,\",\n"
                    + "        \"-RubFiveUnit\": \"целых,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"тысячная процента\",\n"
                    + "        \"-KopTwoUnit\": \"тысячных процента\",\n"
                    + "        \"-KopFiveUnit\": \"тысячных процента\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"558\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з тисячними частинами\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"ціла,\",\n"
                    + "        \"-RubTwoUnit\": \"цілих,\",\n"
                    + "        \"-RubFiveUnit\": \"цілих,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"тисячна відсотка\",\n"
                    + "        \"-KopTwoUnit\": \"тисячних відсотка\",\n"
                    + "        \"-KopFiveUnit\": \"тисячних відсотка\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"562\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з тисячними частинами\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \",\",\n"
                    + "        \"-RubTwoUnit\": \"integers,\",\n"
                    + "        \"-RubFiveUnit\": \"integers,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"thousandth of percent\",\n"
                    + "        \"-KopTwoUnit\": \"thousandths of percent\",\n"
                    + "        \"-KopFiveUnit\": \"thousandths of percent\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      }\n"
                    + "    ],\n"
                    + "    \"PER10000\": [\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"559\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з десяти тисячними частинами\",\n"
                    + "        \"-language\": \"RUS\",\n"
                    + "        \"-RubOneUnit\": \"целая,\",\n"
                    + "        \"-RubTwoUnit\": \"целых,\",\n"
                    + "        \"-RubFiveUnit\": \"целых,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"десятитысячная процента\",\n"
                    + "        \"-KopTwoUnit\": \"десятитысячные процента\",\n"
                    + "        \"-KopFiveUnit\": \"десятитысячных процента\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"559\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з десяти тисячними частинами\",\n"
                    + "        \"-language\": \"UKR\",\n"
                    + "        \"-RubOneUnit\": \"ціла,\",\n"
                    + "        \"-RubTwoUnit\": \"цілих,\",\n"
                    + "        \"-RubFiveUnit\": \"цілих,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"десятитисячна відсотка\",\n"
                    + "        \"-KopTwoUnit\": \"десятитисячних відсотка\",\n"
                    + "        \"-KopFiveUnit\": \"десятитисячних відсотка\",\n"
                    + "        \"-KopSex\": \"M\"\n"
                    + "      },\n"
                    + "      {\n"
                    + "        \"-CurrID\": \"563\",\n"
                    + "        \"-CurrName\": \"Вiдсотки з десяти тисячними частинами\",\n"
                    + "        \"-language\": \"ENG\",\n"
                    + "        \"-RubOneUnit\": \",\",\n"
                    + "        \"-RubTwoUnit\": \"integers,\",\n"
                    + "        \"-RubFiveUnit\": \"integers,\",\n"
                    + "        \"-RubSex\": \"F\",\n"
                    + "        \"-KopOneUnit\": \"ten percent\",\n"
                    + "        \"-KopTwoUnit\": \"ten-percent\",\n"
                    + "        \"-KopFiveUnit\": \"ten-percent\",\n"
                    + "        \"-KopSex\": \"F\"\n"
                    + "      }\n"
                    + "    ]\n"
                    + "  }\n"
                    + "}";

    public static class FromJson {
        public static class ParseException extends RuntimeException {
            private final int offset;
            private final int line;
            private final int column;

            public ParseException(String message, int offset, int line, int column) {
                super(message + " at " + line + ":" + column);
                this.offset = offset;
                this.line = line;
                this.column = column;
            }

            public int getOffset() {
                return offset;
            }

            public int getLine() {
                return line;
            }

            public int getColumn() {
                return column;
            }
        }

        public static class JsonParser {
            private final String json;
            private int index;
            private int line;
            private int lineOffset;
            private int current;
            private StringBuilder captureBuffer;
            private int captureStart;

            public JsonParser(String string) {
                this.json = string;
                line = 1;
                captureStart = -1;
            }

            public Object parse() {
                read();
                skipWhiteSpace();
                final Object result = readValue();
                skipWhiteSpace();
                if (!isEndOfText()) {
                    throw error("Unexpected character");
                }
                return result;
            }

            private Object readValue() {
                switch (current) {
                    case 'n':
                        return readNull();
                    case 't':
                        return readTrue();
                    case 'f':
                        return readFalse();
                    case '"':
                        return readString();
                    case '[':
                        return readArray();
                    case '{':
                        return readObject();
                    case '-':
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        return readNumber();
                    default:
                        throw expected("value");
                }
            }

            private List<Object> readArray() {
                read();
                List<Object> array = new ArrayList<>();
                skipWhiteSpace();
                if (readChar(']')) {
                    return array;
                }
                do {
                    skipWhiteSpace();
                    array.add(readValue());
                    skipWhiteSpace();
                } while (readChar(','));
                if (!readChar(']')) {
                    throw expected("',' or ']'");
                }
                return array;
            }

            private Map<String, Object> readObject() {
                read();
                Map<String, Object> object = new LinkedHashMap<>();
                skipWhiteSpace();
                if (readChar('}')) {
                    return object;
                }
                do {
                    skipWhiteSpace();
                    String name = readName();
                    skipWhiteSpace();
                    if (!readChar(':')) {
                        throw expected("':'");
                    }
                    skipWhiteSpace();
                    object.put(name, readValue());
                    skipWhiteSpace();
                } while (readChar(','));
                if (!readChar('}')) {
                    throw expected("',' or '}'");
                }
                return object;
            }

            private String readName() {
                if (current != '"') {
                    throw expected("name");
                }
                return readString();
            }

            private String readNull() {
                read();
                readRequiredChar('u');
                readRequiredChar('l');
                readRequiredChar('l');
                return null;
            }

            private Boolean readTrue() {
                read();
                readRequiredChar('r');
                readRequiredChar('u');
                readRequiredChar('e');
                return Boolean.TRUE;
            }

            private Boolean readFalse() {
                read();
                readRequiredChar('a');
                readRequiredChar('l');
                readRequiredChar('s');
                readRequiredChar('e');
                return Boolean.FALSE;
            }

            private void readRequiredChar(char ch) {
                if (!readChar(ch)) {
                    throw expected("'" + ch + "'");
                }
            }

            private String readString() {
                read();
                startCapture();
                while (current != '"') {
                    if (current == '\\') {
                        pauseCapture();
                        readEscape();
                        startCapture();
                    } else if (current < 0x20) {
                        throw expected("valid string character");
                    } else {
                        read();
                    }
                }
                String string = endCapture();
                read();
                return string;
            }

            private void readEscape() {
                read();
                switch (current) {
                    case '"':
                    case '/':
                    case '\\':
                        captureBuffer.append((char) current);
                        break;
                    case 'b':
                        captureBuffer.append('\b');
                        break;
                    case 'f':
                        captureBuffer.append('\f');
                        break;
                    case 'n':
                        captureBuffer.append('\n');
                        break;
                    case 'r':
                        captureBuffer.append('\r');
                        break;
                    case 't':
                        captureBuffer.append('\t');
                        break;
                    case 'u':
                        char[] hexChars = new char[4];
                        boolean isHexCharsDigits = true;
                        for (int i = 0; i < 4; i++) {
                            read();
                            if (!isHexDigit()) {
                                isHexCharsDigits = false;
                            }
                            hexChars[i] = (char) current;
                        }
                        if (isHexCharsDigits) {
                            captureBuffer.append((char) Integer.parseInt(new String(hexChars), 16));
                        } else {
                            captureBuffer
                                    .append("\\u")
                                    .append(hexChars[0])
                                    .append(hexChars[1])
                                    .append(hexChars[2])
                                    .append(hexChars[3]);
                        }
                        break;
                    default:
                        throw expected("valid escape sequence");
                }
                read();
            }

            private Number readNumber() {
                startCapture();
                readChar('-');
                int firstDigit = current;
                if (!readDigit()) {
                    throw expected("digit");
                }
                if (firstDigit != '0') {
                    while (readDigit()) {}
                }
                readFraction();
                readExponent();
                final String number = endCapture();
                if (number.contains(".") || number.contains("e") || number.contains("E")) {
                    return Double.valueOf(number);
                } else {
                    return Long.valueOf(number);
                }
            }

            private boolean readFraction() {
                if (!readChar('.')) {
                    return false;
                }
                if (!readDigit()) {
                    throw expected("digit");
                }
                while (readDigit()) {}
                return true;
            }

            private boolean readExponent() {
                if (!readChar('e') && !readChar('E')) {
                    return false;
                }
                if (!readChar('+')) {
                    readChar('-');
                }
                if (!readDigit()) {
                    throw expected("digit");
                }
                while (readDigit()) {}
                return true;
            }

            private boolean readChar(char ch) {
                if (current != ch) {
                    return false;
                }
                read();
                return true;
            }

            private boolean readDigit() {
                if (!isDigit()) {
                    return false;
                }
                read();
                return true;
            }

            private void skipWhiteSpace() {
                while (isWhiteSpace()) {
                    read();
                }
            }

            private void read() {
                if (index == json.length()) {
                    current = -1;
                    return;
                }
                if (current == '\n') {
                    line++;
                    lineOffset = index;
                }
                current = json.charAt(index++);
            }

            private void startCapture() {
                if (captureBuffer == null) {
                    captureBuffer = new StringBuilder();
                }
                captureStart = index - 1;
            }

            private void pauseCapture() {
                captureBuffer.append(json.substring(captureStart, index - 1));
                captureStart = -1;
            }

            private String endCapture() {
                int end = current == -1 ? index : index - 1;
                String captured;
                if (captureBuffer.length() > 0) {
                    captureBuffer.append(json.substring(captureStart, end));
                    captured = captureBuffer.toString();
                    captureBuffer.setLength(0);
                } else {
                    captured = json.substring(captureStart, end);
                }
                captureStart = -1;
                return captured;
            }

            private ParseException expected(String expected) {
                if (isEndOfText()) {
                    return error("Unexpected end of input");
                }
                return error("Expected " + expected);
            }

            private ParseException error(String message) {
                int absIndex = index;
                int column = absIndex - lineOffset;
                int offset = isEndOfText() ? absIndex : absIndex - 1;
                return new ParseException(message, offset, line, column - 1);
            }

            private boolean isWhiteSpace() {
                return current == ' ' || current == '\t' || current == '\n' || current == '\r';
            }

            private boolean isDigit() {
                return current >= '0' && current <= '9';
            }

            private boolean isHexDigit() {
                return isDigit()
                        || current >= 'a' && current <= 'f'
                        || current >= 'A' && current <= 'F';
            }

            private boolean isEndOfText() {
                return current == -1;
            }
        }

        @SuppressWarnings("unchecked")
        public static Map<String, Object> fromJson(String string) {
            return (Map<String, Object>) new JsonParser(string).parse();
        }
    }

    private final java.util.Map<String, String[]> messages =
            new java.util.LinkedHashMap<String, String[]>();
    private final String rubOneUnit;
    private final String rubTwoUnit;
    private final String rubFiveUnit;
    private final String rubSex;
    private final String kopOneUnit;
    private final String kopTwoUnit;
    private final String kopFiveUnit;
    private final String kopSex;
    private final String rubShortUnit;
    private final Currency currency;
    private final Language language;
    private final Pennies pennies;

    static {
        initJsonMap(CURRENCY_LIST);
    }

    public static void initJsonMap(final String json) {
        jsonMap = FromJson.fromJson(json);
    }

    /** Currency. */
    public enum Currency {
        /** . */
        UAH,
        /** . */
        USD,
        /** . */
        EUR,
        /** . */
        RUR,
        /** . */
        PER10,
        /** . */
        PER100,
        /** . */
        PER1000,
        /** . */
        PER10000,
        /** . */
        Custom
    }

    /** Language. */
    public enum Language {
        /** . */
        UKR,
        /** . */
        ENG,
        /** . */
        RUS
    }

    /** Pennies. */
    public enum Pennies {
        /** . */
        NUMBER,
        /** . */
        TEXT
    }

    /**
     * Usage: MoneyToStr moneyToStr = new MoneyToStr( MoneyToStr.Currency.UAH,
     * MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
     *
     * @param currency the currency (UAH, RUR, USD, EUR)
     * @param language the language (UKR, RUS, ENG)
     * @param pennies the pennies (NUMBER, TEXT)
     */
    @SuppressWarnings("unchecked")
    public MoneyToStr(Currency currency, Language language, Pennies pennies) {
        if (currency == null) {
            throw new IllegalArgumentException("currency is null");
        }
        if (language == null) {
            throw new IllegalArgumentException("language is null");
        }
        if (pennies == null) {
            throw new IllegalArgumentException("pennies is null");
        }
        this.currency = currency;
        this.language = language;
        this.pennies = pennies;
        String theISOstr = currency.name();
        Map<String, Object> languageElement =
                (Map<String, Object>)
                        ((Map<String, Object>) jsonMap.get("CurrencyList")).get(language.name());
        List<Map<String, Object>> items = (List<Map<String, Object>>) languageElement.get("item");
        for (Map<String, Object> languageItem : items) {
            messages.put(
                    (String) languageItem.get("-value"),
                    ((String) languageItem.get("-text")).split(","));
        }
        List<Map<String, Object>> theISOElements =
                (List<Map<String, Object>>)
                        ((Map<String, Object>) jsonMap.get("CurrencyList")).get(theISOstr);
        Map<String, Object> theISOElement = null;
        for (Map<String, Object> theISOElementLocal : theISOElements) {
            if (theISOElementLocal.get("-language").equals(language.name())) {
                theISOElement = theISOElementLocal;
                break;
            }
        }
        rubOneUnit = (String) theISOElement.get("-RubOneUnit");
        rubTwoUnit = (String) theISOElement.get("-RubTwoUnit");
        rubFiveUnit = (String) theISOElement.get("-RubFiveUnit");
        kopOneUnit = (String) theISOElement.get("-KopOneUnit");
        kopTwoUnit = (String) theISOElement.get("-KopTwoUnit");
        kopFiveUnit = (String) theISOElement.get("-KopFiveUnit");
        rubSex = (String) theISOElement.get("-RubSex");
        kopSex = (String) theISOElement.get("-KopSex");
        rubShortUnit =
                theISOElement.containsKey("-RubShortUnit")
                        ? (String) theISOElement.get("-RubShortUnit")
                        : "";
    }

    /**
     * Inits class with currency. Usage: MoneyToStr moneyToStr = new MoneyToStr(
     * MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
     *
     * @param currency the currency (UAH, RUR, USD, EUR)
     * @param language the language (UKR, RUS, ENG)
     * @param pennies the pennies (NUMBER, TEXT)
     * @param names the custom names
     */
    @SuppressWarnings("unchecked")
    public MoneyToStr(Currency currency, Language language, Pennies pennies, String[] names) {
        if (currency == null) {
            throw new IllegalArgumentException("currency is null");
        }
        if (language == null) {
            throw new IllegalArgumentException("language is null");
        }
        if (pennies == null) {
            throw new IllegalArgumentException("pennies is null");
        }
        if (names == null || names.length != 8) {
            throw new IllegalArgumentException("names is null");
        }
        this.currency = currency;
        this.language = language;
        this.pennies = pennies;
        Map<String, Object> languageElement =
                (Map<String, Object>)
                        ((Map<String, Object>) jsonMap.get("CurrencyList")).get(language.name());
        List<Map<String, Object>> items = (List<Map<String, Object>>) languageElement.get("item");
        for (Map<String, Object> languageItem : items) {
            messages.put(
                    (String) languageItem.get("-value"),
                    ((String) languageItem.get("-text")).split(","));
        }
        rubOneUnit = names[0];
        rubTwoUnit = names[1];
        rubFiveUnit = names[2];
        rubSex = names[3];
        kopOneUnit = names[4];
        kopTwoUnit = names[5];
        kopFiveUnit = names[6];
        kopSex = names[7];
        rubShortUnit = names[0];
    }

    /**
     * Converts percent to string.
     *
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR)
     * @return the string of percent
     */
    public static String percentToStr(Double amount, Language lang) {
        return percentToStr(amount, lang, Pennies.TEXT);
    }

    /**
     * Converts percent to string.
     *
     * @param amount the amount of percent
     * @param lang the language (RUS, UKR, ENG)
     * @param pennies the pennies (NUMBER, TEXT)
     * @return the string of percent
     */
    public static String percentToStr(Double amount, Language lang, Pennies pennies) {
        if (amount == null) {
            throw new IllegalArgumentException("amount is null");
        }
        if (lang == null) {
            throw new IllegalArgumentException("language is null");
        }
        if (pennies == null) {
            throw new IllegalArgumentException("pennies is null");
        }
        Long intPart = amount.longValue();
        final long fractPart;
        final String result;
        int fractCount = BigDecimal.valueOf(amount).scale();
        if (amount.floatValue() == amount.intValue()) {
            result = new MoneyToStr(Currency.PER10, lang, pennies).convert(amount.longValue(), 0L);
        } else if (fractCount == 1) {
            fractPart = Math.round((amount - intPart) * NUM10);
            result = new MoneyToStr(Currency.PER10, lang, pennies).convert(intPart, fractPart);
        } else if (fractCount == 2) {
            fractPart = Math.round((amount - intPart) * NUM100);
            result = new MoneyToStr(Currency.PER100, lang, pennies).convert(intPart, fractPart);
        } else if (fractCount == 3) {
            fractPart = Math.round((amount - intPart) * NUM1000);
            result = new MoneyToStr(Currency.PER1000, lang, pennies).convert(intPart, fractPart);
        } else {
            fractPart = Math.round((amount - intPart) * NUM10000);
            result = new MoneyToStr(Currency.PER10000, lang, pennies).convert(intPart, fractPart);
        }
        return result;
    }

    /**
     * Converts double value to the text description.
     *
     * @param theMoney the amount of money in format major.minor
     * @return the string description of money value
     */
    public String convert(Double theMoney) {
        if (theMoney == null) {
            throw new IllegalArgumentException("theMoney is null");
        }
        Long intPart = theMoney.longValue();
        Long fractPart = Math.round((theMoney - intPart) * NUM100);
        if (currency == Currency.PER1000) {
            fractPart = Math.round((theMoney - intPart) * NUM1000);
        }
        return convert(intPart, fractPart);
    }

    /**
     * Converts amount to words. Usage: MoneyToStr moneyToStr = new
     * MoneyToStr(MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
     * String result = moneyToStr.convert(123D); Expected: result = сто двадцять три гривні 00
     * копійок
     *
     * @param theMoney the amount of money major currency
     * @param theKopeiki the amount of money minor currency
     * @return the string description of money value
     */
    public String convert(Long theMoney, Long theKopeiki) {
        if (theMoney == null) {
            throw new IllegalArgumentException("theMoney is null");
        }
        if (theKopeiki == null) {
            throw new IllegalArgumentException("theKopeiki is null");
        }
        StringBuilder money2str = new StringBuilder();
        Long triadNum = 0L;
        Long theTriad;

        Long intPart = Math.abs(theMoney);
        if (intPart == 0) {
            money2str.append(messages.get("0")[0] + " ");
        }
        do {
            theTriad = intPart % NUM1000;
            money2str.insert(0, triad2Word(theTriad, triadNum, rubSex));
            if (triadNum == 0) {
                if ((theTriad % NUM100) / NUM10 == NUM1) {
                    money2str.append(rubFiveUnit);
                } else {
                    switch (Long.valueOf(theTriad % NUM10).byteValue()) {
                        case NUM1:
                            money2str.append(rubOneUnit);
                            break;
                        case NUM2:
                        case NUM3:
                        case NUM4:
                            money2str.append(rubTwoUnit);
                            break;
                        default:
                            money2str.append(rubFiveUnit);
                            break;
                    }
                }
            }
            intPart /= NUM1000;
            triadNum++;
        } while (intPart > 0);

        if (theMoney < 0) {
            money2str.insert(0, messages.get("minus")[0] + " ");
        }
        if (pennies == Pennies.TEXT) {
            money2str
                    .append(language == Language.ENG ? " and " : " ")
                    .append(
                            theKopeiki == 0
                                    ? messages.get("0")[0] + " "
                                    : triad2Word(Math.abs(theKopeiki), 0L, kopSex));
        } else {
            money2str.append(
                    " "
                            + (Math.abs(theKopeiki) < 10
                                    ? "0" + Math.abs(theKopeiki)
                                    : Math.abs(theKopeiki))
                            + " ");
        }
        if (theKopeiki >= NUM11 && theKopeiki <= NUM14) {
            money2str.append(kopFiveUnit);
        } else {
            switch ((byte) (theKopeiki % NUM10)) {
                case NUM1:
                    money2str.append(kopOneUnit);
                    break;
                case NUM2:
                case NUM3:
                case NUM4:
                    money2str.append(kopTwoUnit);
                    break;
                default:
                    money2str.append(kopFiveUnit);
                    break;
            }
        }
        return money2str.toString().trim();
    }

    private String triad2Word(Long triad, Long triadNum, String sex) {
        final StringBuilder triadWord = new StringBuilder(NUM100);

        if (triad == 0) {
            return "";
        }

        triadWord.append(
                concat(new String[] {""}, messages.get("100_900"))[
                        Long.valueOf(triad / NUM100).byteValue()]);
        final Long range10 = (triad % NUM100) / NUM10;
        triadWord.append(concat(new String[] {"", ""}, messages.get("20_90"))[range10.byteValue()]);
        if (language == Language.ENG && triadWord.length() > 0 && triad % NUM10 == 0) {
            triadWord.deleteCharAt(triadWord.length() - 1);
            triadWord.append(" ");
        }

        check2(triadNum, sex, triadWord, triad, range10);
        switch (triadNum.byteValue()) {
            case NUM0:
                break;
            case NUM1:
            case NUM2:
            case NUM3:
            case NUM4:
                if (range10 == NUM1) {
                    triadWord.append(messages.get("1000_10")[triadNum.byteValue() - 1] + " ");
                } else {
                    final Long range = triad % NUM10;
                    switch (range.byteValue()) {
                        case NUM1:
                            triadWord.append(
                                    messages.get("1000_1")[triadNum.byteValue() - 1] + " ");
                            break;
                        case NUM2:
                        case NUM3:
                        case NUM4:
                            triadWord.append(
                                    messages.get("1000_234")[triadNum.byteValue() - 1] + " ");
                            break;
                        default:
                            triadWord.append(
                                    messages.get("1000_5")[triadNum.byteValue() - 1] + " ");
                            break;
                    }
                }
                break;
            default:
                triadWord.append("??? ");
                break;
        }
        return triadWord.toString();
    }

    /**
     * @param triadNum the triad num
     * @param sex the sex
     * @param triadWord the triad word
     * @param triad the triad
     * @param range10 the range 10
     */
    private void check2(
            Long triadNum, String sex, StringBuilder triadWord, Long triad, Long range10) {
        final Long range = triad % NUM10;
        if (range10 == 1) {
            triadWord.append(messages.get("10_19")[range.byteValue()] + " ");
        } else {
            switch (range.byteValue()) {
                case NUM1:
                    if (triadNum == NUM1) {
                        triadWord.append(messages.get("1")[INDEX_0] + " ");
                    } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                        triadWord.append(messages.get("1")[INDEX_1] + " ");
                    } else if ("M".equals(sex)) {
                        triadWord.append(messages.get("1")[INDEX_2] + " ");
                    } else if ("F".equals(sex)) {
                        triadWord.append(messages.get("1")[INDEX_3] + " ");
                    }
                    break;
                case NUM2:
                    if (triadNum == NUM1) {
                        triadWord.append(messages.get("2")[INDEX_0] + " ");
                    } else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4) {
                        triadWord.append(messages.get("2")[INDEX_1] + " ");
                    } else if ("M".equals(sex)) {
                        triadWord.append(messages.get("2")[INDEX_2] + " ");
                    } else if ("F".equals(sex)) {
                        triadWord.append(messages.get("2")[INDEX_3] + " ");
                    }
                    break;
                case NUM3:
                case NUM4:
                case NUM5:
                case NUM6:
                case NUM7:
                case NUM8:
                case NUM9:
                    triadWord.append(
                            concat(new String[] {"", "", ""}, messages.get("3_9"))[
                                            range.byteValue()]
                                    + " ");
                    break;
                default:
                    break;
            }
        }
    }

    private <T> T[] concat(T[] first, T[] second) {
        final T[] result = java.util.Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }

    public static void main(String[] args) {
        String amount = "123.25";
        String language = "ENG";
        String currency = "USD";
        String pennies = "TEXT";
        if (args.length == 0) {
            System.out.println(
                    "Usage: java -jar moneytostr.jar --amount=123.25 --language=rus|ukr|eng --currency=rur|uah|usd|eur --pennies=text|number");
        } else {
            for (String arg : args) {
                if (arg.startsWith("--amount=")) {
                    amount = arg.substring("--amount=".length()).trim().replace(",", ".");
                } else if (arg.startsWith("--language=")) {
                    language = arg.substring("--language=".length()).trim().toUpperCase();
                } else if (arg.startsWith("--currency=")) {
                    currency = arg.substring("--currency=".length()).trim().toUpperCase();
                } else if (arg.startsWith("--pennies=")) {
                    pennies = arg.substring("--pennies=".length()).trim().toUpperCase();
                }
            }
            String result =
                    new MoneyToStr(
                                    Currency.valueOf(currency),
                                    Language.valueOf(language),
                                    Pennies.valueOf(pennies))
                            .convert(Double.valueOf(amount));
            System.out.println(result);
        }
    }

    public java.util.Map<String, String[]> getMessages() {
        return messages;
    }

    public String getRubShortUnit() {
        return rubShortUnit;
    }

    public Language getLanguage() {
        return language;
    }
}
