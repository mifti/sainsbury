package com.mi.sainsbury.utilities

/**
 * Helper object containing utility functions
 */
object NumericHelper {
  /**
   * method to get precise double value
   */
  def doubleDecimalPrecision(value: Double, precision: Int): Double = {
    return BigDecimal(value).setScale(precision, BigDecimal.RoundingMode.HALF_UP).toDouble
  }

  /**
   * method to try parse string into Int
   */
  def toInt(value: String): Int = {
    try {
      value.toInt
    } catch {
      case e: Exception => 0
    }
  }
  
  /**
   * method to try parse string into Double
   */
  def toDouble(value: String): Double = {
    try {
      value.toDouble
    } catch {
      case e: Exception => 0
    }
  }
}