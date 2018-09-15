package marshi.android.feedpond.ext

import java.util.regex.Pattern

private val pattern = Pattern.compile("&#(\\d+);|&#([\\da-fA-F]+);")

/**
 * decode Numeric Character Reference.
 */
fun String.decodeNCR(): String {
  val matcher = pattern.matcher(this)
  val sb = StringBuffer()
  var buf: Char?
  while (matcher.find()) {
    if (matcher.group(1) != null) {
      buf = Integer.parseInt(matcher.group(1)).toChar()
    } else {
      buf = Integer.parseInt(matcher.group(2), 16).toChar()
    }
    matcher.appendReplacement(sb, buf.toString())
  }
  matcher.appendTail(sb)
  return sb.toString()
}
