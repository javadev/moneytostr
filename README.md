moneytostr
==========

[![Maven Central](https://img.shields.io/maven-central/v/com.github.javadev/moneytostr?style=flat-square)](https://central.sonatype.com/artifact/com.github.javadev/moneytostr/1.23)
[![Java CI](https://github.com/javadev/moneytostr/actions/workflows/maven.yml/badge.svg)](https://github.com/javadev/moneytostr/actions/workflows/maven.yml)
[![CodeQL](https://github.com/javadev/moneytostr/actions/workflows/codeql-analysis.yml/badge.svg)](https://github.com/javadev/moneytostr/actions/workflows/codeql-analysis.yml)
[![Coverage Status](https://coveralls.io/repos/javadev/moneytostr-russian/badge.svg)](https://coveralls.io/r/javadev/moneytostr-russian)
[![Known Vulnerabilities](https://snyk.io/test/github/javadev/moneytostr/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/javadev/moneytostr?targetFile=pom.xml)


The tool to convert amount to words in Ukrainian/English/Russian languages

## Download

Download [latest release](https://github.com/javadev/moneytostr/releases) or grab via Maven:

```xml
<dependency>
  <groupId>com.github.javadev</groupId>
  <artifactId>moneytostr</artifactId>
  <version>1.23</version>
</dependency>
```
or Gradle:

```groovy
implementation 'com.github.javadev:moneytostr:1.23'

```

MoneyToStr - Java Class

Class Overview:
The MoneyToStr class provides methods to convert numeric values into text representations of currency in various languages.

Dependencies:
- Java Standard Library

Public Classes:
- MoneyToStr: Main class for converting numbers to symbols.
- MoneyToStr.Currency: Enum representing different currencies.
- MoneyToStr.Language: Enum representing different languages.
- MoneyToStr.Pennies: Enum representing pennies as numbers or text.

Public Methods:
- MoneyToStr(Currency currency, Language language, Pennies pennies): Constructor to initialize the MoneyToStr object with currency, language, and pennies.
- String convert(Double theMoney): Converts a double value to a text description of the money value.
- String convert(Long theMoney, Long theKopeiki): Converts an amount to words.

Usage Example:

```java
MoneyToStr moneyToStr = new MoneyToStr(Currency.UAH, Language.UKR, Pennies.NUMBER);
String result = moneyToStr.convert(123D);
// Expected: result = сто двадцять три гривні 00 копійок
```

