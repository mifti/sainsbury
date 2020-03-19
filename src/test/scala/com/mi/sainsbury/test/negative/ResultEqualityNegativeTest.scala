package com.mi.sainsbury.test.negative

import org.junit.Assert._
import org.junit.Test

import org.json4s._
import org.json4s.jackson.JsonMethods._

import com.mi.sainsbury.response.dto.ProductResponseDto
import com.mi.sainsbury.services.ProductScraperService
import com.mi.sainsbury.utilities.TotalCalculator

class ResultEqualityNegativeTest {
  val expectedOutput = parse("""{
  "results" : [ {
    "title" : "Sainsbury's Strawberries 400g",
    "kcal_per_100g" : 33,
    "unit_price" : 1.75,
    "description" : "by Sainsbury's strawberries"
  }, {
    "title" : "Sainsbury's Blueberries 200g",
    "kcal_per_100g" : 45,
    "unit_price" : 1.75,
    "description" : "by Sainsbury's blueberries"
  }, {
    "title" : "Sainsbury's Raspberries 225g",
    "kcal_per_100g" : 32,
    "unit_price" : 1.75,
    "description" : "by Sainsbury's raspberries"
  }, {
    "title" : "Sainsbury's Blackberries, Sweet 150g",
    "kcal_per_100g" : 32,
    "unit_price" : 1.5,
    "description" : "by Sainsbury's blackberries"
  }, {
    "title" : "Sainsbury's Blueberries 400g",
    "kcal_per_100g" : 45,
    "unit_price" : 3.25,
    "description" : "by Sainsbury's blueberries"
  }, {
    "title" : "Sainsbury's Blueberries, SO Organic 150g",
    "kcal_per_100g" : 45,
    "unit_price" : 2.0,
    "description" : "So Organic blueberries"
  }, {
    "title" : "Sainsbury's Raspberries, Taste the Difference 150g",
    "kcal_per_100g" : 32,
    "unit_price" : 2.5,
    "description" : "Ttd raspberries"
  }, {
    "title" : "Sainsbury's Cherries 400g",
    "kcal_per_100g" : 52,
    "unit_price" : 2.5,
    "description" : "by Sainsbury's Family Cherry Punnet"
  }, {
    "title" : "Sainsbury's Blackberries, Tangy 150g",
    "kcal_per_100g" : 32,
    "unit_price" : 1.5,
    "description" : "by Sainsbury's blackberries"
  }, {
    "title" : "Sainsbury's Strawberries, Taste the Difference 300g",
    "kcal_per_100g" : 33,
    "unit_price" : 2.5,
    "description" : "Ttd strawberries"
  }, {
    "title" : "Sainsbury's Cherry Punnet 200g",
    "unit_price" : 1.5,
    "description" : "Cherries"
  }, {
    "title" : "Sainsbury's Mixed Berries 300g",
    "unit_price" : 3.5,
    "description" : "by Sainsbury's mixed berries"
  }, {
    "title" : "Sainsbury's Mixed Berry Twin Pack 200g",
    "unit_price" : 2.75,
    "description" : "Mixed Berries"
  }, {
    "title" : "Sainsbury's Redcurrants 150g",
    "kcal_per_100g" : 71,
    "unit_price" : 2.5,
    "description" : "by Sainsbury's redcurrants"
  }, {
    "title" : "Sainsbury's Cherry Punnet, Taste the Difference 200g",
    "kcal_per_100g" : 48,
    "unit_price" : 2.5,
    "description" : "Cherry Punnet"
  }, {
    "title" : "Sainsbury's Blackcurrants 150g",
    "unit_price" : 1.75,
    "description" : "Union Flag"
  }, {
    "title" : "Sainsbury's British Cherry & Strawberry Pack 600g",
    "unit_price" : 4.0,
    "description" : "British Cherry & Strawberry Mixed Pack"
  } ],
  "total" : {
    "gross" : 39.5,
    "vat" : 0
  }
}
""")
  
  @Test
  def testAppResultEquality(){
    var products = ProductScraperService.getProducts()
    var gross = TotalCalculator.getTotalGross(products)
    var vat = TotalCalculator.getTotalVat(gross)
    var productResponse = new ProductResponseDto(products, gross, vat)
    var jsonString = productResponse.getJsonResponse()
    var jsonEvaluated = parse(jsonString)
    assertEquals(true, jsonEvaluated!=expectedOutput)
  }
}