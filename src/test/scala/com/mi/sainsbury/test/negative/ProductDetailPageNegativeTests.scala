package com.mi.sainsbury.test.negative

import org.junit.Assert._
import org.junit.Test
import com.mi.sainsbury.utilities.ScalaScraper
import com.mi.sainsbury.constants.Constants

class ProductDetailPageNegativeTests {
  
  @Test
  def testProductsLinks(){
    var valid_links_count = 0
    var list_page = ScalaScraper.getPage(Constants.URL_BASE + Constants.URL_PRODUCT_LIST) 
    if(list_page!=null){
      var product_list_pages = ScalaScraper.getElementList(list_page, Constants.ELEMENT_PRODUCT_LIST)
      var product_list_urls = ScalaScraper.getNextUrlFromElementList(product_list_pages)
      for (product_detail_page <- product_list_urls) {
        var product_page = ScalaScraper.getPage(Constants.URL_BASE + "/invalid/" + product_detail_page.get)
        if (product_page != null) {
          valid_links_count += 1
        }
      }
    }
    assertEquals(0, valid_links_count)
  }
  
  
  
}