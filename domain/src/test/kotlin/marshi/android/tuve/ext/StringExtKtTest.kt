package marshi.android.tuve.ext

import org.hamcrest.core.Is
import org.junit.Assert.assertThat
import org.junit.Test

class StringExtKtTest {
  @Test
  fun testDecodeNCR() {
    assertThat("&#8211;".decodeNCR(), Is.`is`("–")) //this character is en-dash. not hyphen.
  }
}