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
    val actualResult = currencyConverter.converter("usd", "usd", 21)
    val expectedResult = 21
    assert(expectedResult == actualResult)
  }


  "Converter method" should "return converted amount if converted to other currency" in {
    val actualResult = currencyConverter.converter("yen", "auD", 21)
    val expectedResult = 0.28665
    assert(expectedResult == actualResult)
  }

  "Converter method" should "should throw exception if currency isn't available" in {
    try {
      val actualResult = currencyConverter.converter("ye", "au", 21)
    }
    catch {
      case e: Exception => assert(e.getMessage == "This currency conversion is not possible")
    }
  }

}
