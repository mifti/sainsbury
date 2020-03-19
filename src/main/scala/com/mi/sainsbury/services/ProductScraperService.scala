package com.mi.sainsbury.services

import scala.collection.mutable.ArrayBuffer
import com.mi.sainsbury.scrapers.ScalaScraper
import com.mi.sainsbury.models.ProductModel
import com.mi.sainsbury.constants.Constants
import com.mi.sainsbury.repositories.ProductRepository
import com.mi.sainsbury.models.TotalModel

/**
 * Product Scraper Service object implements 
 * ProductRepository methods
 */
object ProductScraperService extends ProductRepository {

  /**
   * method to get products by scraping each product detail 
   * page listed on the product list page
   */
  def getProducts(): ArrayBuffer[ProductModel] = {
    var products = ArrayBuffer.empty[ProductModel]
    var list_page = ScalaScraper.getPage(Constants.URL_BASE + Constants.URL_PRODUCT_LIST)
    if (list_page != null) {
      var product_list_pages = ScalaScraper.getElementList(list_page, Constants.ELEMENT_PRODUCT_LIST)
      var product_list_urls = ScalaScraper.getNextUrlFromElementList(product_list_pages)
      for (product_detail_page <- product_list_urls) {
        var product_page = ScalaScraper.getPage(Constants.URL_BASE + product_detail_page.get)

        if (product_page != null) {
          var name = ScalaScraper.getTextFromElement(product_page, Constants.TEXT_PRODUCT_TITLE)
          var price = ScalaScraper.getTextFromElement(product_page, Constants.TEXT_PRODUCT_PRICE)
          var desc = ScalaScraper.getTextFromElement(product_page, Constants.TEXT_PRODUCT_DESCRIPTION)
          var kcal = ScalaScraper.getTextFromElement(product_page, Constants.TEXT_PRODUCT_CALORIES)

          var newProduct = new ProductModel
          newProduct.name_=(name)
          newProduct.price_=(price)
          newProduct.description_=(desc)
          newProduct.calories_=(kcal)

          products = products :+ newProduct
        }

      }
    }
    return products
  }

  /**
   * method to get calculated value of total gross and vat 
   * from products list
   * 
   * @products: list of products
   */
  def getTotal(products: ArrayBuffer[ProductModel]): TotalModel = {
    var total = new TotalModel
    total.calculateTotal(products)
    return total

  }

}