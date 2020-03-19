package com.mi.sainsbury.test.negative

import scala.util.control.Breaks.break
import scala.util.control.Breaks.breakable

import org.json4s.DefaultFormats
import org.json4s.jackson.JsonMethods.parse
import org.json4s.jvalue2extractable
import org.json4s.string2JsonInput
import org.junit.Assert._
import org.junit.Test

import com.mi.sainsbury.models.ProductModel
import com.mi.sainsbury.services.ProductScraperService
import com.mi.sainsbury.utilities.TotalCalculator

class ResultEquivalenceNegativeTest {
  val expectedProductsString = parse("""[ {
    "_name" : "Changed Name Sainsbury's Strawberries 400g",
    "_calories" : 33,
    "_price" : 1.75,
    "_description" : "by Sainsbury's strawberries"
  }, {
    "_name" : "Sainsbury's Blueberries 200g",
    "_calories" : 45,
    "_price" : 1.75,
    "_description" : "by Sainsbury's blueberries"
  }, {
    "_name" : "Sainsbury's Raspberries 225g",
    "_calories" : 32,
    "_price" : 1.75,
    "_description" : "by Sainsbury's raspberries"
  }, {
    "_name" : "Sainsbury's Blackberries, Sweet 150g",
    "_calories" : 32,
    "_price" : 1.5,
    "_description" : "by Sainsbury's blackberries"
  }, {
    "_name" : "Sainsbury's Blueberries 400g",
    "_calories" : 45,
    "_price" : 3.25,
    "_description" : "by Sainsbury's blueberries"
  }, {
    "_name" : "Sainsbury's Blueberries, SO Organic 150g",
    "_calories" : 45,
    "_price" : 2.0,
    "_description" : "So Organic blueberries"
  }, {
    "_name" : "Sainsbury's Raspberries, Taste the Difference 150g",
    "_calories" : 32,
    "_price" : 2.5,
    "_description" : "Ttd raspberries"
  }, {
    "_name" : "Sainsbury's Cherries 400g",
    "_calories" : 52,
    "_price" : 2.5,
    "_description" : "by Sainsbury's Family Cherry Punnet"
  }, {
    "_name" : "Sainsbury's Blackberries, Tangy 150g",
    "_calories" : 32,
    "_price" : 1.5,
    "_description" : "by Sainsbury's blackberries"
  }, {
    "_name" : "Sainsbury's Strawberries, Taste the Difference 300g",
    "_calories" : 33,
    "_price" : 2.5,
    "_description" : "Ttd strawberries"
  }, {
    "_name" : "Sainsbury's Cherry Punnet 200g",
    "_price" : 1.5,
    "_description" : "Cherries"
  }, {
    "_name" : "Sainsbury's Mixed Berries 300g",
    "_price" : 3.5,
    "_description" : "by Sainsbury's mixed berries"
  }, {
    "_name" : "Sainsbury's Mixed Berry Twin Pack 200g",
    "_price" : 2.75,
    "_description" : "Mixed Berries"
  }, {
    "_name" : "Sainsbury's Redcurrants 150g",
    "_calories" : 71,
    "_price" : 2.5,
    "_description" : "by Sainsbury's redcurrants"
  }, {
    "_name" : "Sainsbury's Cherry Punnet, Taste the Difference 200g",
    "_calories" : 48,
    "_price" : 2.5,
    "_description" : "Cherry Punnet"
  }, {
    "_name" : "Sainsbury's Blackcurrants 150g",
    "_price" : 1.75,
    "_description" : "Union Flag"
  }, {
    "_name" : "Sainsbury's British Cherry & Strawberry Pack 600g",
    "_price" : 4.0,
    "_description" : "British Cherry & Strawberry Mixed Pack"
  } ]""")

  var expectedGross = 39.5
  var expectedVat = 6.58

  @Test
  def testAppResultEquivalence() {
    var products = ProductScraperService.getProducts()
    var gross = TotalCalculator.getTotalGross(products)
    var vat = TotalCalculator.getTotalVat(gross)

    implicit val formats = DefaultFormats
    val expectedProducts = expectedProductsString.extract[List[ProductModel]]

    var evaluatedResult = products.length == expectedProducts.length

    if (evaluatedResult) {
      // Here, breakable is used to prevent exception
      breakable {
        // for loop execution with a range
        for (i <- 0 to products.length - 1) {
          if (!products(i).equals(expectedProducts(i))) {
            evaluatedResult = false
            break
          }
        }
      }
    }

    if (evaluatedResult) {
      evaluatedResult = gross == expectedGross && vat == expectedVat
    }

    assertEquals(false, evaluatedResult)
  }
}