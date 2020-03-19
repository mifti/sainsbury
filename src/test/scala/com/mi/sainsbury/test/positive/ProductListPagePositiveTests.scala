package com.mi.sainsbury.test.positive

import org.junit.Assert._
import org.junit.Test

import com.mi.sainsbury.utilities.ScalaScraper
import com.mi.sainsbury.constants.Constants


class ProductListPagePositiveTests {
  
  @Test
  def testListPage {
    var list_page = ScalaScraper.getPage(Constants.URL_BASE + Constants.URL_PRODUCT_LIST) 
    assertEquals(true, list_page!=null)
  }
  
  @Test
  def testProductsLinksCount {
    var expected_urls_count = 0
    var list_page = ScalaScraper.getPage(Constants.URL_BASE + Constants.URL_PRODUCT_LIST) 
    if(list_page!=null){
      var product_list_pages = ScalaScraper.getElementList(list_page, Constants.ELEMENT_PRODUCT_LIST)
      var product_list_urls = ScalaScraper.getNextUrlFromElementList(product_list_pages)
      expected_urls_count = product_list_urls.length
    }
    assertEquals(17, expected_urls_count)
  }
  
}