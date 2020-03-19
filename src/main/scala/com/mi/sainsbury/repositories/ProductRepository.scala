package com.mi.sainsbury.repositories

import scala.collection.mutable.ArrayBuffer
import com.mi.sainsbury.models.ProductModel
import com.mi.sainsbury.models.TotalModel

/**
 * Product Repository
 */
trait ProductRepository {
  
  /**
   * method declaration for getting products
   */
  def getProducts() : ArrayBuffer[ProductModel];
  
  /**
   * method declaration for total values
   */
  def getTotal(products: ArrayBuffer[ProductModel]) : TotalModel;
}