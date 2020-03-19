package com.mi.sainsbury.scrapers

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import net.ruippeixotog.scalascraper.dsl.DSL._
import net.ruippeixotog.scalascraper.dsl.DSL.Extract._
import net.ruippeixotog.scalascraper.model._
import net.ruippeixotog.scalascraper.scraper.ContentParsers._
import java.net.SocketTimeoutException
import java.util.concurrent.TimeUnit
import scala.concurrent.duration.Duration
import com.mi.sainsbury.browsers.CustomJsoupBrowser

/**
 * Scala scraper wrapper class of 
 * A Scala library for scraping content from HTML pages
 * 
 * Link:
 * https://index.scala-lang.org/ruippeixotog/scala-scraper/scala-scraper/2.2.0?target=_2.13
 */
object ScalaScraper {

  val browser = new CustomJsoupBrowser(Duration(100L, TimeUnit.SECONDS).toMillis.toInt)
  
  /**
   * method to get html document object of a web page
   * 
   * @url: url of the page
   */
  def getPage(url: String): Document = {
    var doc: Document = null
    try {
      doc = browser.get(url)
    }
    catch {
      case x: Exception =>
        {
          println("Exception: Something went wrong.")
        }
    }
    return doc
  }

  /**
   * method to get html element list out of a documnet 
   * found through css query selector 
   * 
   * @doc: Document containing elements to look into
   * @findBy: css query selector to locate desired elemets
   */
  def getElementList(doc: Document, findBy: String): List[Element] = {
    var documentList = doc >/~ validator(text(findBy))(_ != null)
    return documentList match {
      case Left(s) => List.empty[Element]
      case Right(i) => doc >> elementList(findBy)
    }
  }

  /**
   * method to get list of string url from an element list
   * 
   * @elementList: list of elements having <a> tag
   */
  def getNextUrlFromElementList(elementList: List[Element]): List[Option[String]] = {
    return elementList.map(_ >?> attr("href")("a"))
  }

  /**
   * method to get text of an html element out of a documnet 
   * found through css query selector 
   * 
   * @doc: Document containing elements to look into
   * @findBy: css query selector to locate desired elemets
   */
  def getTextFromElement(fromElement: Document, findBy: String): String = {
    val res = fromElement >/~ validator(text(findBy))(_ != null)
    return res match {
      case Left(s) => ""
      case Right(i) => fromElement >> extractor(findBy, text, asIs[String])
    }

  }
}