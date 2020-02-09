package com.knoldus

import org.scalatest._

class CurrencyConverterSpec extends FlatSpec with BeforeAndAfterAll {
  var currencyConverter: CurrencyConverter = new CurrencyConverter

  override def beforeAll(): Unit = {
    currencyConverter = new CurrencyConverter
  }

  override def afterAll(): Unit = {
    if (currencyConverter != null) {
      currencyConverter = null
    }
  }

  "Converter method" should "return amount if from and to are same" in {
    val actualResult = currencyConverter.converter("inr", "INR", 21)
    val expectedResult = 21
    assert(expectedResult == actualResult)
  }

  "Converter method" should "return equivalent amount if converted to Indian Rupees" in {
    val actualResult = currencyConverter.converter("pkr", "InR", 21)
    val expectedResult = 9.66
    assert(expectedResult == actualResult)
  }

  "Converter method" should "return converted amount if converted to other currency" in {
    val actualResult = currencyConverter.converter("yen", "auD", 21)
    val expectedResult = 0.28665
    assert(expectedResult == actualResult)
  }

}
