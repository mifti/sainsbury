package com.mi.sainsbury.test.negative

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(classOf[Suite])
@Suite.SuiteClasses(Array(classOf[ConsoleAppNegativeTest], classOf[ProductDetailPageNegativeTests], classOf[ProductListPageNegativeTests]))
class NegativeTestSuit {
  
}