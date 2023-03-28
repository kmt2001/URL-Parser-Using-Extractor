package URLParser

//author: Krishna Mohan Tiwari
//date: March 28, 2023

/**
 * A class for parsing URLs into their component parts (protocol, domain, and path).
 * Uses an extractor method to return an Option containing a tuple of the URL parts.
 */
object URLParserUsingExtractor {
  /**
   * Attempts to parse the provided URL string into its component parts.
   *
   * @param urlString the URL string to parse
   * @return an Option containing a tuple of the URL parts if the URL is valid, otherwise None
   */
  def unapply(urlString: String): Option[(String, String, String)] = {
    try {
      val urlParts = urlString.split("://")
      if (urlParts.length != 2) {
        throw new IllegalArgumentException("Invalid URL: must include protocol")
      }
      val protocol = urlParts(0)
      val domainAndPathParts = urlParts(1).split("/", 2)
      val domain = domainAndPathParts(0)
      if (domain.isEmpty) {
        throw new IllegalArgumentException("Invalid URL: domain cannot be empty")
      }
      val path = if (domainAndPathParts.length > 1) domainAndPathParts(1) else ""
      if (path.contains("\n")) {
        throw new IllegalArgumentException("Invalid URL: path contains a newline character")
      }
      Some(protocol, domain, path)
    } catch {
      // Handle IllegalArgumentExceptions by printing an error message and returning None
      case exception: IllegalArgumentException =>
        println(s"Error parsing URL '$urlString': ${exception.getMessage}")
        None
      // Handle all other Throwable by printing an error message and returning None
      case exception: Throwable =>
        println(s"Unexpected error parsing URL '$urlString': ${exception.getMessage}")
        None
    }
  }
}

//Run the code
object URLParserUsingExtractorApp extends App {

  // Create a new URLParserUsingExtractor instance to parse URLs
  private val parser = URLParserUsingExtractor

  // Define a URL string to parse
  val url = "https://www.knoldus.com/accelerators"

  // Use pattern matching to extract the URL parts and print them
  url match {
    case parser(protocol, domain, path) =>
      println(s"Protocol: $protocol\nDomain: $domain\nPath: $path")
    case _ => println("Invalid URL")
  }
}
