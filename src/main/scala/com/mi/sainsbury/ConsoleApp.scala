package com.mi.sainsbury

import com.mi.sainsbury.response.dto.ProductResponseDto
import com.mi.sainsbury.services.ProductScraperService
import com.mi.sainsbury.utilities.TotalCalculator

import org.json4s._
import org.json4s.jackson.JsonMethods._

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
    var productResponse = new ProductResponseDto(products, gross, vat)
    println(productResponse.getJsonResponse())    
  }
}