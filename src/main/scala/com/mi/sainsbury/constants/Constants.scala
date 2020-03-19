package com.mi.sainsbury.constants

/**
 * Application constants list
 */
object Constants {
  final val URL_BASE = "https://jsainsburyplc.github.io/serverside-test/site/www.sainsburys.co.uk/webapp/wcs/stores/servlet/gb/groceries/"
  final val URL_PRODUCT_LIST = "berries-cherries-currants6039.html"
  
  final val ELEMENT_PRODUCT_LIST = ".productLister li h3"
  final val TEXT_PRODUCT_TITLE = "h1"
  final val TEXT_PRODUCT_PRICE = "p.pricePerUnit"
  final val TEXT_PRODUCT_DESCRIPTION = "div.mainProductInfo h3 + div p:not(.statements)"
  final val TEXT_PRODUCT_CALORIES = "table.nutritionTable tr.tableRow0 td, table.nutritionTable tr:nth-child(2) td"
  
  final val VAT_RATE = 20.0
}