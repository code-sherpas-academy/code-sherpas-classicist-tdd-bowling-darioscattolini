/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample

fun calculateScore(input: String): Int {
    val frames = getFrames(input)

    return calculateFramesScore(frames)
}

private fun getFrames(input: String) = input.replace('-', '0').split("||", "|").dropLast(1)

private tailrec fun calculateFramesScore(frames: List<String>): Int {
    if (frames.isEmpty()) return 0

    val currentFrame = frames.first()
    val nextFrames = frames.drop(1)

    val score = if (currentFrame == "X") {
        calculateStrikeScore(nextFrames.getOrElse(0) { "00" }, nextFrames.getOrElse(1) { "00" })
    } else {
        addKnockedDownPins(currentFrame)
    }

    return score + calculateFramesScore(nextFrames)
}

private fun calculateStrikeScore(nextFrame: String, secondNextFrame: String): Int {
    return if (nextFrame == "X" && secondNextFrame == "X") {
        30
    } else if (nextFrame == "X") {
        20 + secondNextFrame[0].digitToInt()
    } else {
        10 + addKnockedDownPins(nextFrame)
    }
}

private fun addKnockedDownPins(frame: String): Int {
    return frame.sumOf { it.digitToInt() }
}
