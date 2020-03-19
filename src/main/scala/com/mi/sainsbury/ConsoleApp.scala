package com.mi.sainsbury

import com.mi.sainsbury.response.dto.ProductResponseDto
import com.mi.sainsbury.services.ProductScraperService

/**
 * Sainsbury ConsoleApp Object
 */
object ConsoleApp {
  
  /**
   * method that initiate products scraping process and 
 	 * print json output on console on completion
   */
  def init(): Unit = {
    var products = ProductScraperService.getProducts()
    var total = ProductScraperService.getTotal(products)
    var jsonproduct = new ProductResponseDto(products, total)
    println(jsonproduct.getJsonResponse())
  }
}