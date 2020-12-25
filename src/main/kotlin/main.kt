fun main() {
    println(agoToText(0))
    println(agoToText(60))
    println(agoToText(120))
    println(agoToText(600))
    println(agoToText(3600))
    println(agoToText(7200))
    println(agoToText(36000))
    println(agoToText(86400))
    println(agoToText(172800))
    println(agoToText(Int.MAX_VALUE))
}
fun agoToText(seconds: Int): String =
    "был(а) " + when {
        seconds < 60 -> "только что"
        seconds < 60 * 60 -> "${minutesToText(seconds / 60)} назад"
        seconds < 24 * 60 * 60 -> "${hoursToText(seconds / 60 / 60)} назад"
        seconds < 2 * 24 * 60 * 60 -> "сегодня"
        seconds < 3 * 24 * 60 * 60 -> "вчера"
        else -> "давно"
    }
fun minutesToText(minutes: Int): String =
    numberToText(
        number = minutes,
        one = "минуту",
        few = "минуты",
        other = "минут"
    )
fun hoursToText(hours: Int): String =
    numberToText(
        number = hours,
        one = "час",
        few = "часа",
        other = "часов"
    )
fun numberToText(number: Int, one: String, few: String, other: String): String {
    val suffix = when (number) {
        1 -> one
        in 2..4 -> few
        else -> other
    }
    return "$number $suffix"
}