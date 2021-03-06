package search.managers

import java.io.File
import org.junit.Test
import org.junit.Assert._
import org.junit.BeforeClass
import search.managers.SearchManager
import search.documents.MockDocument
import search.documents.MockDocumentManager

object TestSearchManagerOnMopp {
  val searchManager = new SearchManager[MockDocument]
  searchManager.addToIndex(new MockDocumentManager().parseFolder(new File("src/resources/documents/mopp")))
}

class TestSearchManagerOnMopp {

  @Test
  def testIndexAll() = {
    assertEquals(291, TestSearchManagerOnMopp.searchManager.index.totalDocumentsIndexed)
  }

  @Test
  def testQuery() = {
    val queryResult = TestSearchManagerOnMopp.searchManager.query("supplementary")
    println(queryResult)
    assertEquals(9, queryResult.length)
  }

  @Test
  def testQueryGuild() = {
    val queryResult = TestSearchManagerOnMopp.searchManager.query("guild")
    assertEquals(24, queryResult.length)
  }
  @Test
  def testQueryMultiple() = {
    val queryResult = TestSearchManagerOnMopp.searchManager.query("qut")
    assertEquals(100, queryResult.length)
  }

  @Test
  def quickTest() = {
    val queryResult = TestSearchManagerOnMopp.searchManager.query("supplementary")
  }
}