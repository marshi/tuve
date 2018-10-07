package marshi.android.tuve.ext

import java.util.Date

fun Date.humanReadableRelativeText(): String {
    val current = Date()
    val diffHour = (current.time - this.time) / 1000 / 60 / 60
    if (diffHour < 1) {
        return "1時間以内"
    }
    if (diffHour < 24) {
        return "1日以内"
    }
    if (diffHour < 24 * 7) {
        return "1週間以内"
    }
    if (diffHour < 24 * 30) {
        return "1ヶ月以内"
    }
    if (diffHour < 24 * 30 * 3) {
        return "3ヶ月以内"
    }
    return "3ヶ月以上前"
}