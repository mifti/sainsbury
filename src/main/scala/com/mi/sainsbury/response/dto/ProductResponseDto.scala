package com.mi.sainsbury.response.dto

import scala.collection.mutable.ArrayBuffer
import org.json4s.JsonDSL._

import com.mi.sainsbury.jsonparser.Json4s
import com.mi.sainsbury.models.ProductModel
import com.mi.sainsbury.models.TotalModel

/**
 * response dto class for product list
 */
class ProductResponseDto(products: ArrayBuffer[ProductModel], total: TotalModel) {
  
  /**
   * method to defines json format for product list 
   * and return beautified json as string
   */
  def getJsonResponse(): String = {
    val json =
      (("results" ->
        products.map { p =>
          if (p.calories == 0) {
            (
              ("title" -> p.name) ~
              ("unit_price" -> p.price) ~
              ("description" -> p.description))
          } else {
            (
              ("title" -> p.name) ~
              ("kcal_per_100g" -> p.calories) ~
              ("unit_price" -> p.price) ~
              ("description" -> p.description))
          }
        }) ~
        ("total" ->
          ("gross" -> total.gross) ~
          ("vat" -> total.vat)))
    return Json4s.beautifyJson(json)
  }
}