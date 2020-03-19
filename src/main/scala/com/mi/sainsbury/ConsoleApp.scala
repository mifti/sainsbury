package com.mi.sainsbury

import com.mi.sainsbury.response.dto.ProductResponseDto
import com.mi.sainsbury.services.ProductScraperService
import com.mi.sainsbury.utilities.TotalCalculator

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
    var gross = TotalCalculator.getTotalGross(products)
    var vat = TotalCalculator.getTotalVat(gross)
    var jsonproduct = new ProductResponseDto(products, gross, vat)
    println(jsonproduct.getJsonResponse())
  }
}