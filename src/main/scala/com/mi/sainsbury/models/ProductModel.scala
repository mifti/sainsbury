package com.mi.sainsbury.models

import com.mi.sainsbury.utilities.Helper

/**
 * Product Model class
 */
class ProductModel {
  private var _name: String = ""
  private var _price: Double = 0
  private var _description: String = ""
  private var _calories: Int = 0

  /**
   * name getter
   */
  def name: String = {
    return _name
  }

  /**
   * name setter
   */
  def name_=(value: String) = {
    _name = value
  }
  
  /**
   * price getter
   * 
   * return price double value with 2 precision
   */
  def price: Double = {
    return Helper.doubleDecimalPrecision(_price, 2)
  }

  /**
   * price setter
   * 
   * set price removing currency "£" character 
   * from start and "/unit" string from end of price
   * and converting this into Double
   */
  def price_=(value: String) = {
    if (value.isEmpty() || !value.contains("/unit")){
      _price = 0
    }
    else{
      _price = Helper.toDouble(value.substring(1, value.length()-5))
    }
  }
  
  /**
   * description getter
   */
  def description: String = {
    return _description
  }

  /**
   * description setter
   */
  def description_=(value: String) = {
    _description = value
  }
  
  /**
   * calories getter
   */
  def calories: Int = {
    return _calories
  }

  /**
   * calories setter
   * 
   * set calories removing "kcal" string from end of calories
   * and converting this into Integer
   */
  def calories_=(value: String) = {
    if (value.isEmpty() || !value.contains("kcal")){
      _calories = 0
    }
    else{
      _calories = Helper.toInt(value.substring(0, value.length()-4))
    }
  }
  
  

}