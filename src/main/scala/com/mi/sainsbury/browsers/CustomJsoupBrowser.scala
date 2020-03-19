package com.mi.sainsbury.browsers

import net.ruippeixotog.scalascraper.browser.JsoupBrowser
import org.jsoup.Connection

/**
 * Custom class that extends JsoupBrowser
 * used for overriding default request settings
 */
class CustomJsoupBrowser(timeout: Int) extends JsoupBrowser {
  
  /**
   * method thats override default settings of JsoupBrowser
   */
  override protected[this] def defaultRequestSettings(conn: Connection): Connection = {
    super.defaultRequestSettings(conn)
    conn.timeout(timeout)
  }
}