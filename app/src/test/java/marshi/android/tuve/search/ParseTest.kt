package marshi.android.tuve.search

import org.junit.Before
import org.junit.Test

import java.util.regex.Pattern

class ParseTest {

  @Before
  fun setUp() {
  }

  @Test
  fun parse() {
    val pattern = Pattern.compile("^jpameblo://ameblo\\.jp/[a-z0-9\\-]{3,24}/entry-[0-9]{11}\\.html$")
    val matcher = pattern.matcher("jpameblo://ameblo.jp/marshi/entry-11111111111.html")
    println(matcher.matches())
  }
}