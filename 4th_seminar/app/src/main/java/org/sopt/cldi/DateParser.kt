package org.sopt.cldi

import java.text.SimpleDateFormat
import java.util.*

object DateParser {

    private val dateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA)
    private val talkDateFormat = SimpleDateFormat("yy.MM.dd", Locale.KOREA)

    private fun parseStringToCalendar(raw: String) : Calendar {
        val date = dateFormat.parse(raw)
        return Calendar.getInstance().apply { time = date ?: Date()}
    }

    /** 곰신톡에서 사용할 시간 차이 계산 함수 */
    fun calculateDiffDate(raw: String) : String {
        val parsedDate = parseStringToCalendar(raw)
        var diff = System.currentTimeMillis() - parsedDate.timeInMillis

        val diffMin = diff / 1000 / 60
        val diffDay = diffMin / 60 / 24
        val diffHour = diffMin / 60

        return when {
            diffDay > 0 -> convertToTalkDateString(parsedDate)
            diffHour > 0 -> "${diffHour}시간 전"
            diffMin > 0 -> "${diffMin}분 전"
            else -> "방금"
        }
    }

    private fun convertToTalkDateString(cal: Calendar) : String
            = talkDateFormat.format(cal.time)

}