package com.mi.sainsbury.utilities

import scala.collection.mutable.ArrayBuffer
import com.mi.sainsbury.models.ProductModel
import com.mi.sainsbury.constants.Constants

object TotalCalculator {
  /**
   * method to calculate and return total gross value
   */
  def getTotalGross(products: ArrayBuffer[ProductModel]): Double = {
    var gross: Double = products.map(f => f.price).reduce((x, y) => x + y)
    return NumericHelper.doubleDecimalPrecision(gross, 2)
  }

  /**
   * method to calculate and return vat value
   */
  def getTotalVat(gross: Double): Double = {
    var vat: Double = (gross-(gross/(1+(Constants.VAT_RATE/100.0))))
    return NumericHelper.doubleDecimalPrecision(vat, 2)
  }
}