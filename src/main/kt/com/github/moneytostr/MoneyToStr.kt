/*
* $Id$
*
* Copyright 2017 Valentyn Kolesnikov
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package com.github.moneytostr
/**
* Converts numbers to symbols.
*
* @author Valentyn Kolesnikov
* @version $Revision$ $Date$
*/
class MoneyToStr {
  val messages:Map<String, Array<String>> = java.util.LinkedHashMap<String, Array<String>>()
  private val rubOneUnit:String
  private val rubTwoUnit:String
  private val rubFiveUnit:String
  private val rubSex:String
  private val kopOneUnit:String
  private val kopTwoUnit:String
  private val kopFiveUnit:String
  private val kopSex:String
  val rubShortUnit:String
  private val currency:Currency
  val language:Language
  private val pennies:Pennies
  /** Currency. */
  enum class Currency {
    /**.*/
    RUR,
    /**.*/
    UAH,
    /**.*/
    USD,
    /**.*/
    PER10,
    /**.*/
    PER100,
    /**.*/
    PER1000,
    /**.*/
    PER10000,
    /**.*/
    Custom
  }
  /** Language. */
  enum class Language {
    /**.*/
    RUS,
    /**.*/
    UKR,
    /**.*/
    ENG
  }
  /** Pennies. */
  enum class Pennies {
    /**.*/
    NUMBER,
    /**.*/
    TEXT
  }
  /**
 * Inits class with currency. Usage: MoneyToStr moneyToStr = new MoneyToStr(
 * MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
 * Definition for currency is placed into currlist.xml
 *
 * @param currency the currency (UAH, RUR, USD)
 * @param language the language (UKR, RUS, ENG)
 * @param pennies the pennies (NUMBER, TEXT)
 */
  constructor(currency:Currency, language:Language, pennies:Pennies) {
    if (currency == null)
    {
      throw IllegalArgumentException("currency is null")
    }
    if (language == null)
    {
      throw IllegalArgumentException("language is null")
    }
    if (pennies == null)
    {
      throw IllegalArgumentException("pennies is null")
    }
    this.currency = currency
    this.language = language
    this.pennies = pennies
    val theISOstr = currency.name
    val languageElement = (xmlDoc.getElementsByTagName(language.name)).item(0) as org.w3c.dom.Element
    val items = languageElement.getElementsByTagName("item")
    run({ var index = 0
         while (index < items.getLength())
         {
           val languageItem = items.item(index) as org.w3c.dom.Element
           messages.put(languageItem.getAttribute("value"), languageItem.getAttribute("text").split((",").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray())
           index += 1
         } })
    val theISOElements = (xmlDoc.getElementsByTagName(theISOstr)) as org.w3c.dom.NodeList
    var theISOElement:org.w3c.dom.Element? = null
    var index = 0
    while (index < theISOElements.getLength())
    {
      if ((theISOElements.item(index) as org.w3c.dom.Element).getAttribute("language") == language.name)
      {
        theISOElement = theISOElements.item(index) as org.w3c.dom.Element
        break
      }
      index += 1
    }
    rubOneUnit = theISOElement!!.getAttribute("RubOneUnit")
    rubTwoUnit = theISOElement!!.getAttribute("RubTwoUnit")
    rubFiveUnit = theISOElement!!.getAttribute("RubFiveUnit")
    kopOneUnit = theISOElement!!.getAttribute("KopOneUnit")
    kopTwoUnit = theISOElement!!.getAttribute("KopTwoUnit")
    kopFiveUnit = theISOElement!!.getAttribute("KopFiveUnit")
    rubSex = theISOElement!!.getAttribute("RubSex")
    kopSex = theISOElement!!.getAttribute("KopSex")
    rubShortUnit = if (theISOElement!!.hasAttribute("RubShortUnit")) theISOElement!!.getAttribute("RubShortUnit") else ""
  }
  /**
 * Inits class with currency. Usage: MoneyToStr moneyToStr = new MoneyToStr(
 * MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
 *
 * @param currency the currency (UAH, RUR, USD)
 * @param language the language (UKR, RUS, ENG)
 * @param pennies the pennies (NUMBER, TEXT)
 * @param names the custom names
 */
  constructor(currency:Currency, language:Language, pennies:Pennies, names:Array<String>) {
    if (currency == null)
    {
      throw IllegalArgumentException("currency is null")
    }
    if (language == null)
    {
      throw IllegalArgumentException("language is null")
    }
    if (pennies == null)
    {
      throw IllegalArgumentException("pennies is null")
    }
    if (names == null || names.size != 8)
    {
      throw IllegalArgumentException("names is null")
    }
    this.currency = currency
    this.language = language
    this.pennies = pennies
    val languageElement = (xmlDoc.getElementsByTagName(language.name)).item(0) as org.w3c.dom.Element
    val items = languageElement.getElementsByTagName("item")
    var index = 0
    while (index < items.getLength())
    {
      val languageItem = items.item(index) as org.w3c.dom.Element
      messages.put(languageItem.getAttribute("value"), languageItem.getAttribute("text").split((",").toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray())
      index += 1
    }
    rubOneUnit = names[0]
    rubTwoUnit = names[1]
    rubFiveUnit = names[2]
    rubSex = names[3]
    kopOneUnit = names[4]
    kopTwoUnit = names[5]
    kopFiveUnit = names[6]
    kopSex = names[7]
    rubShortUnit = names[0]
  }
  /**
 * Converts double value to the text description.
 *
 * @param theMoney
 * the amount of money in format major.minor
 * @return the string description of money value
 */
  fun convert(theMoney:Double):String {
    if (theMoney == null)
    {
      throw IllegalArgumentException("theMoney is null")
    }
    val intPart = theMoney.toLong()
    var fractPart = Math.round((theMoney - intPart) * NUM100)
    if (currency == Currency.PER1000)
    {
      fractPart = Math.round((theMoney - intPart) * NUM1000)
    }
    return convert(intPart, fractPart)
  }
  /**
 * Converts amount to words. Usage: MoneyToStr moneyToStr =
 * new MoneyToStr(MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
 * String result = moneyToStr.convert(123D); Expected: result = сто двадцять т��и гривні 00 копійок
 *
 * @param theMoney
 * the amount of money major currency
 * @param theKopeiki
 * the amount of money minor currency
 * @return the string description of money value
 */
  fun convert(theMoney:Long, theKopeiki:Long):String {
    if (theMoney == null)
    {
      throw IllegalArgumentException("theMoney is null")
    }
    if (theKopeiki == null)
    {
      throw IllegalArgumentException("theKopeiki is null")
    }
    val money2str = StringBuilder()
    var triadNum = 0L
    var theTriad:Long
    var intPart = Math.abs(theMoney)
    if (intPart == 0L)
    {
      money2str.append(messages.get("0")[0] + " ")
    }
    do
    {
      theTriad = intPart % NUM1000
      money2str.insert(0, triad2Word(theTriad, triadNum, rubSex))
      if (triadNum == 0L)
      {
        if ((theTriad % NUM100) / NUM10 == NUM1.toLong())
        {
          money2str.append(rubFiveUnit)
        }
        else
        {
          when (java.lang.Long.valueOf(theTriad % NUM10).toByte()) {
            NUM1 -> money2str.append(rubOneUnit)
            NUM2, NUM3, NUM4 -> money2str.append(rubTwoUnit)
            else -> money2str.append(rubFiveUnit)
          }
        }
      }
      intPart /= NUM1000.toLong()
      triadNum++
    }
    while (intPart > 0)
    if (theMoney < 0)
    {
      money2str.insert(0, messages.get("minus")[0] + " ")
    }
    if (pennies == Pennies.TEXT)
    {
      money2str.append(if (language == Language.ENG) " and " else " ").append(
        if (theKopeiki == 0) messages.get("0")[0] + " " else triad2Word(Math.abs(theKopeiki), 0L, kopSex))
    }
    else
    {
      money2str.append((" " + (if (Math.abs(theKopeiki) < 10)
                               "0" + Math.abs(theKopeiki)
                               else
                               Math.abs(theKopeiki)) + " "))
    }
    if (theKopeiki >= NUM11 && theKopeiki <= NUM14)
    {
      money2str.append(kopFiveUnit)
    }
    else
    {
      when ((theKopeiki % NUM10).toByte()) {
        NUM1 -> money2str.append(kopOneUnit)
        NUM2, NUM3, NUM4 -> money2str.append(kopTwoUnit)
        else -> money2str.append(kopFiveUnit)
      }
    }
    return money2str.toString().trim({ it <= ' ' })
  }
  private fun triad2Word(triad:Long, triadNum:Long, sex:String):String {
    val triadWord = StringBuilder(NUM100)
    if (triad == 0)
    {
      return ""
    }
    triadWord.append(concat<String>(arrayOf<String>(""), messages.get("100_900"))[java.lang.Long.valueOf(triad / NUM100).toByte()])
    val range10 = (triad % NUM100) / NUM10
    triadWord.append(concat<String>(arrayOf<String>("", ""), messages.get("20_90"))[range10.toByte()])
    if (language == Language.ENG && triadWord.length > 0 && triad % NUM10 == 0L)
    {
      triadWord.deleteCharAt(triadWord.length - 1)
      triadWord.append(" ")
    }
    check2(triadNum, sex, triadWord, triad, range10)
    when (triadNum.toByte()) {
      NUM0 -> {}
      NUM1, NUM2, NUM3, NUM4 -> if (range10 == NUM1)
      {
        triadWord.append(messages.get("1000_10")[triadNum.toByte() - 1] + " ")
      }
      else
      {
        val range = triad % NUM10
        when (range.toByte()) {
          NUM1 -> triadWord.append(messages.get("1000_1")[triadNum.toByte() - 1] + " ")
          NUM2, NUM3, NUM4 -> triadWord.append(messages.get("1000_234")[triadNum.toByte() - 1] + " ")
          else -> triadWord.append(messages.get("1000_5")[triadNum.toByte() - 1] + " ")
        }
      }
      else -> triadWord.append("??? ")
    }
    return triadWord.toString()
  }
  /**
 * @param triadNum the triad num
 * @param sex the sex
 * @param triadWord the triad word
 * @param triad the triad
 * @param range10 the range 10
 */
  private fun check2(triadNum:Long, sex:String, triadWord:StringBuilder, triad:Long, range10:Long) {
    val range = triad % NUM10
    if (range10 == 1)
    {
      triadWord.append(messages.get("10_19")[range.toByte()] + " ")
    }
    else
    {
      when (range.toByte()) {
        NUM1 -> if (triadNum == NUM1)
        {
          triadWord.append(messages.get("1")[INDEX_0] + " ")
        }
        else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4)
        {
          triadWord.append(messages.get("1")[INDEX_1] + " ")
        }
        else if ("M" == sex)
        {
          triadWord.append(messages.get("1")[INDEX_2] + " ")
        }
        else if ("F" == sex)
        {
          triadWord.append(messages.get("1")[INDEX_3] + " ")
        }
        NUM2 -> if (triadNum == NUM1)
        {
          triadWord.append(messages.get("2")[INDEX_0] + " ")
        }
        else if (triadNum == NUM2 || triadNum == NUM3 || triadNum == NUM4)
        {
          triadWord.append(messages.get("2")[INDEX_1] + " ")
        }
        else if ("M" == sex)
        {
          triadWord.append(messages.get("2")[INDEX_2] + " ")
        }
        else if ("F" == sex)
        {
          triadWord.append(messages.get("2")[INDEX_3] + " ")
        }
        NUM3, NUM4, NUM5, NUM6, NUM7, NUM8, NUM9 -> triadWord.append(concat<String>(arrayOf<String>("", "", ""), messages.get("3_9"))[range.toByte()] + " ")
        else -> {}
      }
    }
  }
  private fun <T> concat(first:Array<T>, second:Array<T>):Array<T> {
    val result = java.util.Arrays.copyOf<T>(first, first.size + second.size)
    System.arraycopy(second, 0, result, first.size, second.size)
    return result
  }
  companion object {
    private val INDEX_3 = 3
    private val INDEX_2 = 2
    private val INDEX_1 = 1
    private val INDEX_0 = 0
    private val xmlDoc:org.w3c.dom.Document
    private val NUM0 = 0
    private val NUM1 = 1
    private val NUM2 = 2
    private val NUM3 = 3
    private val NUM4 = 4
    private val NUM5 = 5
    private val NUM6 = 6
    private val NUM7 = 7
    private val NUM8 = 8
    private val NUM9 = 9
    private val NUM10 = 10
    private val NUM11 = 11
    private val NUM14 = 14
    private val NUM100 = 100
    private val NUM1000 = 1000
    private val NUM10000 = 10000
    private val CURRENCY_LIST = (
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
      + " <item value=\"10_19\" text=\"\u0434\u0435\u0441\u044f\u0442\u044c,\u043e\u0434\u0438\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0434\u0432\u0430\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0442\u0440\u0438\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0447\u043e\u0442\u0438\u0440\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u043f\u2019\u044f\u0442\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0448i\u0441\u0442\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0441i\u043c\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0432i\u0441i\u043c\u043d\u0430\u0434\u0446\u044f\u0442\u044c,\u0434\u0435\u0432\'\u044f\u0442\u043d\u0430\u0434\u0446\u044f\u0442\u044c\"/>\n"
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
      + "</CurrencyList>\n")
    init{
      initXmlDoc(CURRENCY_LIST)
    }
    fun initXmlDoc(xmlData:String) {
      val docFactory = javax.xml.parsers.DocumentBuilderFactory.newInstance()
      try
      {
        val xmlDocBuilder = docFactory.newDocumentBuilder()
        xmlDoc = xmlDocBuilder.parse(java.io.ByteArrayInputStream(xmlData.toByteArray(charset("UTF8"))))
      }
      catch (ex:Exception) {
        throw UnsupportedOperationException(ex)
      }
    }
    /**
 * Converts percent to string.
 * @param amount the amount of percent
 * @param lang the language (RUS, UKR, ENG)
 * @param pennies the pennies (NUMBER, TEXT)
 * @return the string of percent
 */
    @JvmOverloads fun percentToStr(amount:Double, lang:Language, pennies:Pennies = Pennies.TEXT):String {
      if (amount == null)
      {
        throw IllegalArgumentException("amount is null")
      }
      if (lang == null)
      {
        throw IllegalArgumentException("language is null")
      }
      if (pennies == null)
      {
        throw IllegalArgumentException("pennies is null")
      }
      val intPart = amount.toLong()
      val fractPart = 0L
      val result:String
      if (amount.toFloat() == amount.toInt().toFloat())
      {
        result = MoneyToStr(Currency.PER10, lang, pennies).convert(amount.toLong(), 0L)
      }
      else if (java.lang.Double.valueOf(amount * NUM10).toFloat() == java.lang.Double.valueOf(amount * NUM10).toInt().toFloat())
      {
        fractPart = Math.round((amount - intPart) * NUM10)
        result = MoneyToStr(Currency.PER10, lang, pennies).convert(intPart, fractPart)
      }
      else if (java.lang.Double.valueOf(amount * NUM100).toFloat() == java.lang.Double.valueOf(amount * NUM100).toInt().toFloat())
      {
        fractPart = Math.round((amount - intPart) * NUM100)
        result = MoneyToStr(Currency.PER100, lang, pennies).convert(intPart, fractPart)
      }
      else if (java.lang.Double.valueOf(amount * NUM1000).toFloat() == java.lang.Double.valueOf(amount * NUM1000).toInt().toFloat())
      {
        fractPart = Math.round((amount - intPart) * NUM1000)
        result = MoneyToStr(Currency.PER1000, lang, pennies).convert(intPart, fractPart)
      }
      else
      {
        fractPart = Math.round((amount - intPart) * NUM10000)
        result = MoneyToStr(Currency.PER10000, lang, pennies).convert(intPart, fractPart)
      }
      return result
    }
    @JvmStatic fun main(args:Array<String>) {
      val amount = "123.25"
      val language = "ENG"
      val currency = "USD"
      val pennies = "TEXT"
      if (args.size == 0)
      {
        println("Usage: java -jar moneytostr.jar --amount=123.25 --language=rus|ukr|eng --currency=rur|uah|usd --pennies=text|number")
      }
      else
      {
        for (arg in args)
        {
          if (arg.startsWith("--amount="))
          {
            amount = arg.substring("--amount=".length).trim({ it <= ' ' }).replace(",", ".")
          }
          else if (arg.startsWith("--language="))
          {
            language = arg.substring("--language=".length).trim({ it <= ' ' }).toUpperCase()
          }
          else if (arg.startsWith("--currency="))
          {
            currency = arg.substring("--currency=".length).trim({ it <= ' ' }).toUpperCase()
          }
          else if (arg.startsWith("--pennies="))
          {
            pennies = arg.substring("--pennies=".length).trim({ it <= ' ' }).toUpperCase()
          }
        }
        val result = MoneyToStr(Currency.valueOf(currency), Language.valueOf(language), Pennies.valueOf(pennies)).convert(java.lang.Double.valueOf(amount))
        println(result)
      }
    }
  }
}

