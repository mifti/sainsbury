package com.mi.sainsbury.utilities

import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

/**
 * object of Json4s
 */
object Json4s {
  
  /**
   * method to beautify json object as string
   */
  def beautifyJson(json: JValue) : String = {
    return pretty(render(json))
  }
}