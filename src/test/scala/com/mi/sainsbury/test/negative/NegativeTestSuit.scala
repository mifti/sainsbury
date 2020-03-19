package com.mi.sainsbury.test.negative

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(classOf[Suite])
@Suite.SuiteClasses(Array(classOf[ProductListPageNegativeTests], classOf[ProductDetailPageNegativeTests], classOf[ResultEqualityNegativeTest], classOf[ResultEquivalenceNegativeTest]))
class NegativeTestSuit {
  
}