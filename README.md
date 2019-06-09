moneytostr
==========

[![Maven Central](https://img.shields.io/maven-central/v/com.github.javadev/moneytostr.svg)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.github.javadev%22%20AND%20a%3A%22moneytostr%22)
[![Build Status](https://secure.travis-ci.org/javadev/moneytostr-russian.svg)](http://travis-ci.org/javadev/moneytostr-russian)
[![Coverage Status](https://coveralls.io/repos/javadev/moneytostr-russian/badge.svg)](https://coveralls.io/r/javadev/moneytostr-russian)
[![Known Vulnerabilities](https://snyk.io/test/github/javadev/moneytostr-russian/badge.svg?targetFile=pom.xml)](https://snyk.io/test/github/javadev/moneytostr-russian?targetFile=pom.xml)


The tool to convert amount to words in Russian/Ukrainian/English languages

## Download

Download [latest release](https://github.com/javadev/moneytostr-russian/releases) or grab via Maven:

```xml
<dependency>
  <groupId>com.github.javadev</groupId>
  <artifactId>moneytostr</artifactId>
  <version>1.18</version>
</dependency>
```
or Gradle:

```groovy
dependencies {
  ...
  compile 'com.github.javadev:moneytostr:1.18'
  ...
}
```

### Usage

```java
MoneyToStr moneyToStr = new MoneyToStr(MoneyToStr.Currency.RUR, MoneyToStr.Language.RUS, MoneyToStr.Pennies.NUMBER);
moneyToStr.convert(777.77D)

// семьсот семьдесят семь рублей 77 копеек
```
