package com.mi.sainsbury.models

import scala.collection.mutable.ArrayBuffer
import com.mi.sainsbury.constants.Constants
import com.mi.sainsbury.utilities.Helper

/**
 * Todal Model Class
 */
class TotalModel {
  private var _gross: Double = 0
  private var _vat: Double = 0

  /**
   * gross getter
   * 
   * retrun gross double value with 2 precision
   */
  def gross: Double = {
    return Helper.doubleDecimalPrecision(_gross, 2)
  }

  /**
   * vat getter
   * 
   * retrun vat double value with 2 precision
   */
  def vat: Double = {
    return Helper.doubleDecimalPrecision(_vat, 2)
  }

  /**
   * method to calculate gross and vat value
   */
  def calculateTotal(products: ArrayBuffer[ProductModel]): Unit = {
    calculateTotalGross(products)
    calculateTotalVat()
  }

  /**
   * method to calculate total gross value
   */
  private def calculateTotalGross(products: ArrayBuffer[ProductModel]): Unit = {
    this._gross = products.map(f => f.price).reduce((x, y) => x + y)
  }

  /**
   * method to calculate vat value
   */
  private def calculateTotalVat(): Unit = {
    this._vat = (this._gross-(this._gross/(1+(Constants.VAT_RATE/100.0))))
  }

}