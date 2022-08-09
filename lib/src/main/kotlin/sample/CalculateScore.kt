/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample

fun calculateScore(input: String) = convertToFrames(input).sum()

private fun convertToFrames(input: String): List<Int> {
    val stringFrames = input.replace('-', '0').split("||", "|")
    val frameData = stringFrames.windowed(3, 1, true)
        .take(10)
        .map { Triple(it[0], it.getOrElse(1) { "00" }, it.getOrElse(2) { "00" }) }

    return frameData.map(buildFrame)
}

private val buildFrame = { frameData: Triple<String, String, String> ->
    val (frame, nextFrame, frameAfterNext) = frameData

    if (frame == "X") {
        val firstRoll = 10
        val bonusRolls = (nextFrame.toCharArray() + frameAfterNext.toCharArray())
            .take(2)
            .map { if (it == 'X') 10 else it.digitToInt() }

        firstRoll + bonusRolls[0] + bonusRolls[1]
    } else if (frame[1] == '/') {
        val firstRoll = frame[0].digitToInt()
        val secondRoll = 10 - firstRoll
        val bonusRoll = if (nextFrame[0] == 'X') 10 else nextFrame[0].digitToInt()

        firstRoll + secondRoll + bonusRoll
    } else {
        frame[0].digitToInt() + frame[1].digitToInt()
    }
}