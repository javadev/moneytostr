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
    private static org.w3c.dom.Document xmlDoc;
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
            "<CurrencyList>\n"
                    + " \n"
                    + " <language value=\"UKR\"/>\n"
                    + " <UKR>\n"
                    + " <item value=\"minus\" text=\"\u043C\u0456\u043D\u0443\u0441\"/>\n"
                    + " <item value=\"0\" text=\"\u043d\u0443\u043b\u044c\"/>\n"
                    + " <item value=\"1000_10\" text=\"\u0442\u0438\u0441\u044f\u0447,\u043c\u0456\u043b\u044c\u0439\u043e\u043d\u0456\u0432,\u043c\u0456\u043b\u044c\u044f\u0440\u0434\u0456\u0432,\u0442\u0440\u0438\u043b\u044c\u0439\u043e\u043d\u0456\u0432\"/>\n"
                    + " <item value=\"1000_1\" text=\"\u0442\u0438\u0441\u044f\u0447\u0430,\u043c\u0456\u043b\u044c\u0439\u043e\u043d,\u043c\u0456\u043b\u044c\u044f\u0440\u0434,\u0442\u0440\u0438\u043b\u044c\u0439\u043e\u043d\"/>\n"
                    + " <item value=\"1000_234\" text=\"\u0442\u0438\u0441\u044f\u0447\u0456,\u043c\u0456\u043b\u044c\u0439\u043e\u043d\u0430,\u043c\u0456\u043b\u044c\u044f\u0440\u0434\u0430,\u0442\u0440\u0438\u043b\u044c\u0439\u043e\u043d\u0430\"/>\n"
                    + " <item value=\"1000_5\" text=\"\u0442\u0438\u0441\u044f\u0447,\u043c\u0456\u043b\u044c\u0439\u043e\u043d\u0456\u0432,\u043c\u0456\u043b\u044c\u044f\u0440\u0434\u0456\u0432,\u0442\u0440\u0438\u043b\u044c\u0439\u043e\u043d\u0456\u0432\"/>\n"
                    + " <item value=\"10_19\" text=\"\u0434\u0435\u0441\u044f\u0442\u044c,\u043e\u0434\u0438\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0434\u0432\u0430\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0442\u0440\u0438\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0447\u043e\u0442\u0438\u0440\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u043f\u2019\u044f\u0442\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0448\u0456\u0441\u0442\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0441\u0456\u043c\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0432\u0456\u0441\u0456\u043c\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0434\u0435\u0432\u2019\u044f\u0442\u043d\u0430\u0434\u0446\u044f\u0442\u044c\"/>\n"
                    + " <item value=\"1\" text=\"\u043e\u0434\u043d\u0430,\u043e\u0434\u0438\u043d,\u043e\u0434\u0438\u043d,\u043e\u0434\u043d\u0430\"/>\n"
                    + " <item value=\"2\" text=\"\u0434\u0432\u0456,\u0434\u0432\u0430,\u0434\u0432\u0430,\u0434\u0432\u0456\"/>\n"
                    + " <item value=\"3_9\" text=\"\u0442\u0440\u0438,\u0447\u043e\u0442\u0438\u0440\u0438,\u043f\u2019\u044f\u0442\u044c,\u0448\u0456\u0441\u0442\u044c,\u0441\u0456\u043c,\u0432\u0456\u0441\u0456\u043c,\u0434\u0435\u0432\u2019\u044f\u0442\u044c\"/>\n"
                    + " <item value=\"100_900\" text=\"\u0441\u0442\u043e ,\u0434\u0432\u0456\u0441\u0442\u0456 ,\u0442\u0440\u0438\u0441\u0442\u0430 ,\u0447\u043e\u0442\u0438\u0440\u0438\u0441\u0442\u0430 ,\u043f\u2019\u044f\u0442\u0441\u043e\u0442 ,\u0448\u0456\u0441\u0442\u0441\u043e\u0442 ,\u0441\u0456\u043c\u0441\u043e\u0442 ,\u0432\u0456\u0441\u0456\u043c\u0441\u043e\u0442 ,\u0434\u0435\u0432\u2019\u044f\u0442\u0441\u043e\u0442 \"/>\n"
                    + " <item value=\"20_90\" text=\"\u0434\u0432\u0430\u0434\u0446\u044f\u0442\u044c ,\u0442\u0440\u0438\u0434\u0446\u044f\u0442\u044c ,\u0441\u043e\u0440\u043e\u043a ,\u043f\u2019\u044f\u0442\u0434\u0435\u0441\u044f\u0442 ,\u0448\u0456\u0441\u0442\u0434\u0435\u0441\u044f\u0442 ,\u0441\u0456\u043c\u0434\u0435\u0441\u044f\u0442 ,\u0432\u0456\u0441\u0456\u043c\u0434\u0435\u0441\u044f\u0442 ,\u0434\u0435\u0432\u2019\u044f\u043d\u043e\u0441\u0442\u043e \"/>\n"
                    + " <item value=\"pdv\" text=\"\u0432 \u0442.\u0447. \u041f\u0414\u0412 \"/>\n"
                    + " <item value=\"pdv_value\" text=\"20\"/>\n"
                    + " </UKR>\n"
                    + " <RUS>\n"
                    + " <item value=\"minus\" text=\"\u043C\u0438\u043D\u0443\u0441\"/>\n"
                    + " <item value=\"0\" text=\"\u043d\u043e\u043b\u044c\"/>\n"
                    + " <item value=\"1000_10\" text=\"\u0442\u044b\u0441\u044f\u0447,\u043c\u0438\u043b\u043b\u0438\u043e\u043d\u043e\u0432,\u043c\u0438\u043b\u043b\u0438\u0430\u0440\u0434\u043e\u0432,\u0442\u0440\u0438\u043b\u043b\u0438\u043e\u043d\u043e\u0432\"/>\n"
                    + " <item value=\"1000_1\" text=\"\u0442\u044b\u0441\u044f\u0447\u0430,\u043c\u0438\u043b\u043b\u0438\u043e\u043d,\u043c\u0438\u043b\u043b\u0438\u0430\u0440\u0434,\u0442\u0440\u0438\u043b\u043b\u0438\u043e\u043d\"/>\n"
                    + " <item value=\"1000_234\" text=\"\u0442\u044b\u0441\u044f\u0447\u0438,\u043c\u0438\u043b\u043b\u0438\u043e\u043d\u0430,\u043c\u0438\u043b\u043b\u0438\u0430\u0440\u0434\u0430,\u0442\u0440\u0438\u043b\u043b\u0438\u043e\u043d\u0430\"/>\n"
                    + " <item value=\"1000_5\" text=\"\u0442\u044b\u0441\u044f\u0447,\u043c\u0438\u043b\u043b\u0438\u043e\u043d\u043e\u0432,\u043c\u0438\u043b\u043b\u0438\u0430\u0440\u0434\u043e\u0432,\u0442\u0440\u0438\u043b\u043b\u0438\u043e\u043d\u043e\u0432\"/>\n"
                    + " <item value=\"10_19\" text=\"\u0434\u0435\u0441\u044f\u0442\u044c,\u043e\u0434\u0438\u043d\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0434\u0432\u0435\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0442\u0440\u0438\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0447\u0435\u0442\u044b\u0440\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u043f\u044f\u0442\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0448\u0435\u0441\u0442\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0441\u0435\u043c\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0432\u043e\u0441\u0435\u043c\u043d\u0430\u0434\u0446\u0430\u0442\u044c,\u0434\u0435\u0432\u044f\u0442\u043d\u0430\u0434\u0446\u0430\u0442\u044c\"/>\n"
                    + " <item value=\"1\" text=\"\u043e\u0434\u043d\u0430,\u043e\u0434\u0438\u043d,\u043e\u0434\u0438\u043d,\u043e\u0434\u043d\u0430\"/>\n"
                    + " <item value=\"2\" text=\"\u0434\u0432\u0435,\u0434\u0432\u0430,\u0434\u0432\u0430,\u0434\u0432\u0435\"/>\n"
                    + " <item value=\"3_9\" text=\"\u0442\u0440\u0438,\u0447\u0435\u0442\u044b\u0440\u0435,\u043f\u044f\u0442\u044c,\u0448\u0435\u0441\u0442\u044c,\u0441\u0435\u043c\u044c,\u0432\u043e\u0441\u0435\u043c\u044c,\u0434\u0435\u0432\u044f\u0442\u044c\"/>\n"
                    + " <item value=\"100_900\" text=\"\u0441\u0442\u043e ,\u0434\u0432\u0435\u0441\u0442\u0438 ,\u0442\u0440\u0438\u0441\u0442\u0430 ,\u0447\u0435\u0442\u044b\u0440\u0435\u0441\u0442\u0430 ,\u043f\u044f\u0442\u044c\u0441\u043e\u0442 ,\u0448\u0435\u0441\u0442\u044c\u0441\u043e\u0442 ,\u0441\u0435\u043c\u044c\u0441\u043e\u0442 ,\u0432\u043e\u0441\u0435\u043c\u044c\u0441\u043e\u0442 ,\u0434\u0435\u0432\u044f\u0442\u044c\u0441\u043e\u0442 \"/>\n"
                    + " <item value=\"20_90\" text=\"\u0434\u0432\u0430\u0434\u0446\u0430\u0442\u044c ,\u0442\u0440\u0438\u0434\u0446\u0430\u0442\u044c ,\u0441\u043e\u0440\u043e\u043a ,\u043f\u044f\u0442\u044c\u0434\u0435\u0441\u044f\u0442 ,\u0448\u0435\u0441\u0442\u044c\u0434\u0435\u0441\u044f\u0442 ,\u0441\u0435\u043c\u044c\u0434\u0435\u0441\u044f\u0442 ,\u0432\u043e\u0441\u0435\u043c\u044c\u0434\u0435\u0441\u044f\u0442 ,\u0434\u0435\u0432\u044f\u043d\u043e\u0441\u0442\u043e \"/>\n"
                    + " <item value=\"pdv\" text=\"\u0432 \u0442.\u0447. \u041d\u0414\u0421 \"/>\n"
                    + " <item value=\"pdv_value\" text=\"18\"/>\n"
                    + " </RUS>\n"
                    + " <ENG>\n"
                    + " <item value=\"minus\" text=\"minus\"/>\n"
                    + " <item value=\"0\" text=\"zero\"/>\n"
                    + " <item value=\"1000_10\" text=\"thousand,million,billion,trillion\"/>\n"
                    + " <item value=\"1000_1\" text=\"thousand,million,billion,trillion\"/>\n"
                    + " <item value=\"1000_234\" text=\"thousand,million,billion,trillion\"/>\n"
                    + " <item value=\"1000_5\" text=\"thousand,million,billion,trillion\"/>\n"
                    + " <item value=\"10_19\" text=\"ten,eleven,twelve,thirteen,fourteen,fifteen,sixteen,seventeen,eighteen,nineteen\"/>\n"
                    + " <item value=\"1\" text=\"one,one,one,one\"/>\n"
                    + " <item value=\"2\" text=\"two,two,two,two\"/>\n"
                    + " <item value=\"3_9\" text=\"three,four,five,six,seven,eight,nine\"/>\n"
                    + " <item value=\"100_900\" text=\"one hundred ,two hundred ,three hundred ,four hundred ,five hundred ,six hundred ,seven hundred ,eight hundred ,nine hundred \"/>\n"
                    + " <item value=\"20_90\" text=\"twenty-,thirty-,forty-,fifty-,sixty-,seventy-,eighty-,ninety-\"/>\n"
                    + " <item value=\"pdv\" text=\"including VAT \"/>\n"
                    + " <item value=\"pdv_value\" text=\"10\"/>\n"
                    + " </ENG>\n"
                    + "\n"
                    + " <RUR CurrID=\"810\" CurrName=\"\u0420\u043e\u0441\u0441\u0438\u0439\u0441\u043a\u0438\u0435 \u0440\u0443\u0431\u043b\u0438\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0440\u0443\u0431\u043b\u044c\" RubTwoUnit=\"\u0440\u0443\u0431\u043b\u044f\" RubFiveUnit=\"\u0440\u0443\u0431\u043b\u0435\u0439\" RubSex=\"M\" RubShortUnit=\"\u0440\u0443\u0431.\"\n"
                    + " KopOneUnit=\"\u043a\u043e\u043f\u0435\u0439\u043a\u0430\" KopTwoUnit=\"\u043a\u043e\u043f\u0435\u0439\u043a\u0438\" KopFiveUnit=\"\u043a\u043e\u043f\u0435\u0435\u043a\" KopSex=\"F\"\n"
                    + " />\n"
                    + " <UAH CurrID=\"980\" CurrName=\"\u0423\u043a\u0440\u0430\u0438\u043d\u0441\u043a\u0456 \u0433\u0440\u0438\u0432\u043d\u0456\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0433\u0440\u0438\u0432\u043d\u044f\" RubTwoUnit=\"\u0433\u0440\u0438\u0432\u043d\u0438\" RubFiveUnit=\"\u0433\u0440\u0438\u0432\u0435\u043d\u044c\" RubSex=\"F\" RubShortUnit=\"\u0433\u0440\u043d.\"\n"
                    + " KopOneUnit=\"\u043a\u043e\u043f\u0435\u0439\u043a\u0430\" KopTwoUnit=\"\u043a\u043e\u043f\u0435\u0439\u043a\u0438\" KopFiveUnit=\"\u043a\u043e\u043f\u0435\u0435\u043a\" KopSex=\"F\"\n"
                    + " />\n"
                    + " <USD CurrID=\"840\" CurrName=\"\u0414\u043e\u043b\u0430\u0440\u0438 \u0421\u0428\u0410\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0434\u043e\u043b\u043b\u0430\u0440\" RubTwoUnit=\"\u0434\u043e\u043b\u043b\u0430\u0440\u0430\" RubFiveUnit=\"\u0434\u043e\u043b\u043b\u0430\u0440\u043e\u0432\" RubSex=\"M\" RubShortUnit=\"\u0434\u043e\u043b.\"\n"
                    + " KopOneUnit=\"\u0446\u0435\u043d\u0442\" KopTwoUnit=\"\u0446\u0435\u043d\u0442\u0430\" KopFiveUnit=\"\u0446\u0435\u043d\u0442\u043e\u0432\" KopSex=\"M\"\n"
                    + " />\n"
                    + " <EUR CurrID=\"840\" CurrName=\"\u0415\u0432\u0440\u043E \u0415\u0421\" language=\"RUS\""
                    + " RubOneUnit=\"\u0435\u0432\u0440\u043E\" RubTwoUnit=\"\u0435\u0432\u0440\u043E\" RubFiveUnit=\"\u0435\u0432\u0440\u043E\" RubSex=\"M\" RubShortUnit=\"\u0435\u0432\u0440.\""
                    + " KopOneUnit=\"\u0446\u0435\u043D\u0442\" KopTwoUnit=\"\u0446\u0435\u043D\u0442\u0430\" KopFiveUnit=\"\u0446\u0435\u043D\u0442\u043E\u0432\" KopSex=\"M\" />"
                    + "\n"
                    + " <RUR CurrID=\"810\" CurrName=\"\u0420\u043e\u0441\u0441\u0438\u0439\u0441\u043a\u0438\u0435 \u0440\u0443\u0431\u043b\u0438\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0440\u0443\u0431\u043b\u044c\" RubTwoUnit=\"\u0440\u0443\u0431\u043b\u0456\" RubFiveUnit=\"\u0440\u0443\u0431\u043b\u0456\u0432\" RubSex=\"M\" RubShortUnit=\"\u0440\u0443\u0431.\"\n"
                    + " KopOneUnit=\"\u043a\u043e\u043f\u0456\u0439\u043a\u0430\" KopTwoUnit=\"\u043a\u043e\u043f\u0456\u0439\u043a\u0438\" KopFiveUnit=\"\u043a\u043e\u043f\u0456\u0439\u043e\u043a\" KopSex=\"F\"\n"
                    + " /> \n"
                    + " <UAH CurrID=\"980\" CurrName=\"\u0423\u043a\u0440\u0430\u0438\u043d\u0441\u043a\u0456 \u0433\u0440\u0438\u0432\u043d\u0456\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0433\u0440\u0438\u0432\u043d\u044f\" RubTwoUnit=\"\u0433\u0440\u0438\u0432\u043d\u0456\" RubFiveUnit=\"\u0433\u0440\u0438\u0432\u0435\u043d\u044c\" RubSex=\"F\" RubShortUnit=\"\u0433\u0440\u043d.\"\n"
                    + " KopOneUnit=\"\u043a\u043e\u043f\u0456\u0439\u043a\u0430\" KopTwoUnit=\"\u043a\u043e\u043f\u0456\u0439\u043a\u0438\" KopFiveUnit=\"\u043a\u043e\u043f\u0456\u0439\u043e\u043a\" KopSex=\"F\"\n"
                    + " />\n"
                    + " <USD CurrID=\"840\" CurrName=\"\u0414\u043e\u043b\u0430\u0440\u0438 \u0421\u0428\u0410\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0434\u043e\u043b\u0430\u0440\" RubTwoUnit=\"\u0434\u043e\u043b\u0430\u0440\u0430\" RubFiveUnit=\"\u0434\u043e\u043b\u0430\u0440\u0456\u0432\" RubSex=\"M\" RubShortUnit=\"\u0434\u043e\u043b.\"\n"
                    + " KopOneUnit=\"\u0446\u0435\u043d\u0442\" KopTwoUnit=\"\u0446\u0435\u043d\u0442\u0430\" KopFiveUnit=\"\u0446\u0435\u043d\u0442\u0456\u0432\" KopSex=\"M\"\n"
                    + " />\n"
                    + " <EUR CurrID=\"840\" CurrName=\"\u0415\u0432\u0440\u043E \u0415\u0421\" language=\"UKR\""
                    + " RubOneUnit=\"\u0454\u0432\u0440\u043E\" RubTwoUnit=\"\u0454\u0432\u0440\u043E\" RubFiveUnit=\"\u0454\u0432\u0440\u043E\" RubSex=\"M\" RubShortUnit=\"\u0454\u0432\u0440.\""
                    + " KopOneUnit=\"\u0446\u0435\u043D\u0442\" KopTwoUnit=\"\u0446\u0435\u043D\u0442\u0430\" KopFiveUnit=\"\u0446\u0435\u043D\u0442\u0456\u0432\" KopSex=\"M\" />"
                    + "\n"
                    + " <RUR CurrID=\"810\" CurrName=\"\u0420\u043e\u0441\u0441\u0438\u0439\u0441\u043a\u0438\u0435 \u0440\u0443\u0431\u043b\u0438\" language=\"ENG\"\n"
                    + " RubOneUnit=\"ruble\" RubTwoUnit=\"rubles\" RubFiveUnit=\"rubles\" RubSex=\"M\" RubShortUnit=\"RUR.\"\n"
                    + " KopOneUnit=\"kopeck\" KopTwoUnit=\"kopecks\" KopFiveUnit=\"kopecks\" KopSex=\"M\"\n"
                    + " /> \n"
                    + " <UAH CurrID=\"980\" CurrName=\"\u0423\u043a\u0440\u0430\u0438\u043d\u0441\u043a\u0456 \u0433\u0440\u0438\u0432\u043d\u0456\" language=\"ENG\"\n"
                    + " RubOneUnit=\"hryvnia\" RubTwoUnit=\"hryvnias\" RubFiveUnit=\"hryvnias\" RubSex=\"M\" RubShortUnit=\"UAH.\"\n"
                    + " KopOneUnit=\"kopeck\" KopTwoUnit=\"kopecks\" KopFiveUnit=\"kopecks\" KopSex=\"M\"\n"
                    + " />\n"
                    + " <USD CurrID=\"840\" CurrName=\"\u0414\u043e\u043b\u0430\u0440\u0438 \u0421\u0428\u0410\" language=\"ENG\"\n"
                    + " RubOneUnit=\"dollar\" RubTwoUnit=\"dollars\" RubFiveUnit=\"dollars\" RubSex=\"M\" RubShortUnit=\"USD.\"\n"
                    + " KopOneUnit=\"cent\" KopTwoUnit=\"cents\" KopFiveUnit=\"cents\" KopSex=\"M\"\n"
                    + " />\n"
                    + " <EUR CurrID=\"840\" CurrName=\"\u0415\u0432\u0440\u043E \u0415\u0421\" language=\"ENG\""
                    + " RubOneUnit=\"euro\" RubTwoUnit=\"euros\" RubFiveUnit=\"euros\" RubSex=\"M\" RubShortUnit=\"EUR.\""
                    + " KopOneUnit=\"cent\" KopTwoUnit=\"cents\" KopFiveUnit=\"cents\" KopSex=\"M\" />"
                    + "\n"
                    + " <PER10 CurrID=\"556\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0434\u0435\u0441\u044f\u0442\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0446\u0435\u043b\u0430\u044f,\" RubTwoUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubFiveUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0434\u0435\u0441\u044f\u0442\u0430\u044f \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopTwoUnit=\"\u0434\u0435\u0441\u044f\u0442\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopFiveUnit=\"\u0434\u0435\u0441\u044f\u0442\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER100 CurrID=\"557\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0441\u043e\u0442\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0446\u0435\u043b\u0430\u044f,\" RubTwoUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubFiveUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0441\u043e\u0442\u0430\u044f \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopTwoUnit=\"\u0441\u043e\u0442\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopFiveUnit=\"\u0441\u043e\u0442\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER1000 CurrID=\"558\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0442\u0438\u0441\u044f\u0447\u043d\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0446\u0435\u043b\u0430\u044f,\" RubTwoUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubFiveUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0442\u044b\u0441\u044f\u0447\u043d\u0430\u044f \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopTwoUnit=\"\u0442\u044b\u0441\u044f\u0447\u043d\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopFiveUnit=\"\u0442\u044b\u0441\u044f\u0447\u043d\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER10000 CurrID=\"559\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0434\u0435\u0441\u044f\u0442\u0438 \u0442\u0438\u0441\u044f\u0447\u043d\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"RUS\"\n"
                    + " RubOneUnit=\"\u0446\u0435\u043b\u0430\u044f,\" RubTwoUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubFiveUnit=\"\u0446\u0435\u043b\u044b\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0442\u044b\u0441\u044f\u0447\u043d\u0430\u044f \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopTwoUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0442\u044b\u0441\u044f\u0447\u043d\u044b\u0435 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopFiveUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0442\u044b\u0441\u044f\u0447\u043d\u044b\u0445 \u043f\u0440\u043e\u0446\u0435\u043d\u0442\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER10 CurrID=\"556\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0434\u0435\u0441\u044f\u0442\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0446\u0456\u043b\u0430,\" RubTwoUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubFiveUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0434\u0435\u0441\u044f\u0442\u0430 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopTwoUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopFiveUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER100 CurrID=\"557\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0441\u043e\u0442\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0446\u0456\u043b\u0430,\" RubTwoUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubFiveUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0441\u043e\u0442\u0430 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopTwoUnit=\"\u0441\u043e\u0442\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopFiveUnit=\"\u0441\u043e\u0442\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER1000 CurrID=\"558\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0442\u0438\u0441\u044f\u0447\u043d\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0446\u0456\u043b\u0430,\" RubTwoUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubFiveUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0442\u0438\u0441\u044f\u0447\u043d\u0430 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopTwoUnit=\"\u0442\u0438\u0441\u044f\u0447\u043d\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopFiveUnit=\"\u0442\u0438\u0441\u044f\u0447\u043d\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER10000 CurrID=\"559\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0434\u0435\u0441\u044f\u0442\u0438 \u0442\u0438\u0441\u044f\u0447\u043d\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"UKR\"\n"
                    + " RubOneUnit=\"\u0446\u0456\u043b\u0430,\" RubTwoUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubFiveUnit=\"\u0446\u0456\u043b\u0438\u0445,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0442\u0438\u0441\u044f\u0447\u043d\u0430 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopTwoUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0442\u0438\u0441\u044f\u0447\u043d\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopFiveUnit=\"\u0434\u0435\u0441\u044f\u0442\u0438\u0442\u0438\u0441\u044f\u0447\u043d\u0438\u0445 \u0432\u0456\u0434\u0441\u043e\u0442\u043a\u0430\" KopSex=\"M\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER10 CurrID=\"560\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0434\u0435\u0441\u044f\u0442\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"ENG\"\n"
                    + " RubOneUnit=\",\" RubTwoUnit=\"integers,\" RubFiveUnit=\"integers,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"tenth of one percent\" KopTwoUnit=\"tenth of one percent\" KopFiveUnit=\"tenth of one percent\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER100 CurrID=\"561\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0441\u043e\u0442\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"ENG\"\n"
                    + " RubOneUnit=\",\" RubTwoUnit=\"integers,\" RubFiveUnit=\"integers,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"hundred percent\" KopTwoUnit=\"hundredth of percent\" KopFiveUnit=\"hundredth of percent\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER1000 CurrID=\"562\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0442\u0438\u0441\u044f\u0447\u043d\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"ENG\"\n"
                    + " RubOneUnit=\",\" RubTwoUnit=\"integers,\" RubFiveUnit=\"integers,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"thousandth of percent\" KopTwoUnit=\"thousandths of percent\" KopFiveUnit=\"thousandths of percent\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + " <PER10000 CurrID=\"563\" CurrName=\"\u0412i\u0434\u0441\u043e\u0442\u043a\u0438 \u0437 \u0434\u0435\u0441\u044f\u0442\u0438 \u0442\u0438\u0441\u044f\u0447\u043d\u0438\u043c\u0438 \u0447\u0430\u0441\u0442\u0438\u043d\u0430\u043c\u0438\" language=\"ENG\"\n"
                    + " RubOneUnit=\",\" RubTwoUnit=\"integers,\" RubFiveUnit=\"integers,\" RubSex=\"F\"\n"
                    + " KopOneUnit=\"ten percent\" KopTwoUnit=\"ten-percent\" KopFiveUnit=\"ten-percent\" KopSex=\"F\"\n"
                    + " />\n"
                    + "\n"
                    + "</CurrencyList>\n";
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
        initXmlDoc(CURRENCY_LIST);
    }

    public static void initXmlDoc(final String xmlData) {
        javax.xml.parsers.DocumentBuilderFactory docFactory =
                javax.xml.parsers.DocumentBuilderFactory.newInstance();
        try {
            javax.xml.parsers.DocumentBuilder xmlDocBuilder = docFactory.newDocumentBuilder();
            xmlDoc =
                    xmlDocBuilder.parse(new java.io.ByteArrayInputStream(xmlData.getBytes("UTF8")));
        } catch (Exception ex) {
            throw new UnsupportedOperationException(ex);
        }
    }

    /** Currency. */
    public enum Currency {
        /** . */
        RUR,
        /** . */
        UAH,
        /** . */
        USD,
        /** . */
        EUR,
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
        RUS,
        /** . */
        UKR,
        /** . */
        ENG
    }

    /** Pennies. */
    public enum Pennies {
        /** . */
        NUMBER,
        /** . */
        TEXT
    }

    /**
     * Inits class with currency. Usage: MoneyToStr moneyToStr = new MoneyToStr(
     * MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER); Definition for
     * currency is placed into currlist.xml
     *
     * @param currency the currency (UAH, RUR, USD, EUR)
     * @param language the language (UKR, RUS, ENG)
     * @param pennies the pennies (NUMBER, TEXT)
     */
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
        org.w3c.dom.Element languageElement =
                (org.w3c.dom.Element) (xmlDoc.getElementsByTagName(language.name())).item(0);
        org.w3c.dom.NodeList items = languageElement.getElementsByTagName("item");
        for (int index = 0; index < items.getLength(); index += 1) {
            org.w3c.dom.Element languageItem = (org.w3c.dom.Element) items.item(index);
            messages.put(
                    languageItem.getAttribute("value"),
                    languageItem.getAttribute("text").split(","));
        }
        org.w3c.dom.NodeList theISOElements =
                (org.w3c.dom.NodeList) (xmlDoc.getElementsByTagName(theISOstr));
        org.w3c.dom.Element theISOElement = null;
        for (int index = 0; index < theISOElements.getLength(); index += 1) {
            if (((org.w3c.dom.Element) theISOElements.item(index))
                    .getAttribute("language")
                    .equals(language.name())) {
                theISOElement = (org.w3c.dom.Element) theISOElements.item(index);
                break;
            }
        }
        rubOneUnit = theISOElement.getAttribute("RubOneUnit");
        rubTwoUnit = theISOElement.getAttribute("RubTwoUnit");
        rubFiveUnit = theISOElement.getAttribute("RubFiveUnit");
        kopOneUnit = theISOElement.getAttribute("KopOneUnit");
        kopTwoUnit = theISOElement.getAttribute("KopTwoUnit");
        kopFiveUnit = theISOElement.getAttribute("KopFiveUnit");
        rubSex = theISOElement.getAttribute("RubSex");
        kopSex = theISOElement.getAttribute("KopSex");
        rubShortUnit =
                theISOElement.hasAttribute("RubShortUnit")
                        ? theISOElement.getAttribute("RubShortUnit")
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
        org.w3c.dom.Element languageElement =
                (org.w3c.dom.Element) (xmlDoc.getElementsByTagName(language.name())).item(0);
        org.w3c.dom.NodeList items = languageElement.getElementsByTagName("item");
        for (int index = 0; index < items.getLength(); index += 1) {
            org.w3c.dom.Element languageItem = (org.w3c.dom.Element) items.item(index);
            messages.put(
                    languageItem.getAttribute("value"),
                    languageItem.getAttribute("text").split(","));
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
        Long fractPart = 0L;
        String result;
        if (amount.floatValue() == amount.intValue()) {
            result = new MoneyToStr(Currency.PER10, lang, pennies).convert(amount.longValue(), 0L);
        } else if (Double.valueOf(amount * NUM10).floatValue()
                == Double.valueOf(amount * NUM10).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM10);
            result = new MoneyToStr(Currency.PER10, lang, pennies).convert(intPart, fractPart);
        } else if (Double.valueOf(amount * NUM100).floatValue()
                == Double.valueOf(amount * NUM100).intValue()) {
            fractPart = Math.round((amount - intPart) * NUM100);
            result = new MoneyToStr(Currency.PER100, lang, pennies).convert(intPart, fractPart);
        } else if (Double.valueOf(amount * NUM1000).floatValue()
                == Double.valueOf(amount * NUM1000).intValue()) {
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
