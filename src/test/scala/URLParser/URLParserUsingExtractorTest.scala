import org.scalatest.funsuite.AnyFunSuite
import URLParser.URLParserUsingExtractor

class URLParserUsingExtractorTest extends AnyFunSuite {

  test("valid URL with protocol, domain, and path should parse correctly") {
    val url = "https://www.knoldus.com/accelerators"
    val expected = Some(("https", "www.knoldus.com", "accelerators"))
    assert(URLParserUsingExtractor.unapply(url) == expected)
  }

  test("valid URL with protocol and domain only should parse correctly") {
    val url = "http://www.google.com"
    val expected = Some(("http", "www.google.com", ""))
    assert(URLParserUsingExtractor.unapply(url) == expected)
  }

  test("invalid URL with missing protocol should return None") {
    val url = "www.invalid.com"
    assert(URLParserUsingExtractor.unapply(url).isEmpty)
  }

  test("invalid URL with empty domain should return None") {
    val url = "http://"
    assert(URLParserUsingExtractor.unapply(url).isEmpty)
  }

  test("invalid URL with newline character in path should return None") {
    val url = "http://www.invalid.com/\npath"
    assert(URLParserUsingExtractor.unapply(url).isEmpty)
  }
}
