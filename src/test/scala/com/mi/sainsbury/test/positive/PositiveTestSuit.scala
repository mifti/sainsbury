package com.mi.sainsbury.test.positive

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(classOf[Suite])
@Suite.SuiteClasses(Array(classOf[ConsoleAppPositiveTest], classOf[ProductDetailPagePositiveTests], classOf[ProductListPagePositiveTests]))
class PositiveTestSuit {
  
}