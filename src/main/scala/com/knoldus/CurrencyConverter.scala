package com.knoldus

/**
 * In this class we do the task of converting the amount from one type of currency to another type
 */
class CurrencyConverter {
  /**
   * This map stores the conversion rates corresponding to their currency name for conversion in Indian Rupees
   */
  private val conversionRateFromInr: Map[String, Double] = Map("usd" -> 0.014, "euro" -> 0.013, "cad" -> 0.019,
    "pkr" -> 2.16, "gbp" -> 0.011, "aud" -> 0.021, "yen" -> 1.53, "idr" -> 191.31, "sgd" -> 0.019, "inr" -> 1.00)
  /**
   * This map stores the conversion rates for conversion from indian rupees
   */
  private val conversionRateToInr: Map[String, Double] = Map("usd" -> 71.52, "euro" -> 78.28, "cad" -> 53.73,
    "pkr" -> 0.46, "gbp" -> 92.20, "aud" -> 47.72, "yen" -> 0.65, "idr" -> 0.0052, "sgd" -> 51.46, "inr" -> 1.00)

  private val currency = List("usd","euro","cad","pkr","gbp","aud","yen","idr","sgd","inr")

  /**
   * A method that calls 2 functions to get the converted amount
   *
   * @param from   the currency from which the amount has to be converted
   * @param to     the currency to which the amount has to be converted
   * @param amount it denotes the amount to be converted
   * @return
   */
  def converter(from: String, to: String, amount: Double): Double = {
    if (currency.contains(to.toLowerCase) && currency.contains(from.toLowerCase) && amount >= 0) {
      if (to.toLowerCase != from.toLowerCase) {
        val equivalentInr = convertToInr(from.toLowerCase, amount)
        val convertedAmount = convertFromInr(to.toLowerCase, equivalentInr)
        convertedAmount
      }
      else {
        amount
      }
    } else{
      throw new Exception("This currency conversion is not possible")
    }
  }

  /**
   * This method converts the amount to Indian Rupees
   *
   * @param from   the currency from which the amount has to be converted
   * @param amount it denotes the amount to be converted in Indian Rupees
   * @return
   */

  def convertToInr(from: String, amount: Double): Double = amount * conversionRateToInr(from)

  /**
   * This method converts the Indian Rupees to the required currency
   *
   * @param to     the currency to which the amount has to be converted
   * @param amount it converts the Indian Rupees to the required currency
   * @return
   */
  def convertFromInr(to: String, amount: Double): Double = amount * conversionRateFromInr(to)
}
