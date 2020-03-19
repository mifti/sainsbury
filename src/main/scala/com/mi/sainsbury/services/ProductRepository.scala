package com.mi.sainsbury.services

import scala.collection.mutable.ArrayBuffer
import com.mi.sainsbury.models.ProductModel

/**
 * Product Repository
 */
trait ProductRepository {
  
  /**
   * method declaration for getting products
   */
  def getProducts() : ArrayBuffer[ProductModel];
  
}