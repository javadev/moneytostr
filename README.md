moneytostr
==========

[![Maven Central](https://img.shields.io/maven-central/v/com.github.javadev/moneytostr?style=flat-square)](https://central.sonatype.com/artifact/com.github.javadev/moneytostr/1.21)
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
  <version>1.21</version>
</dependency>
```
or Gradle:

```groovy
implementation 'com.github.javadev:moneytostr:1.21'

```

### Usage

```java
MoneyToStr moneyToStr = new MoneyToStr(MoneyToStr.Currency.UAH, MoneyToStr.Language.UKR, MoneyToStr.Pennies.NUMBER);
moneyToStr.convert(777.77D)

// сімсот сімдесят сім гривень 77 копійок
```
