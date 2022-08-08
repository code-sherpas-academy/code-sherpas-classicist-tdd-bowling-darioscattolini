/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample

fun calculateScore(input: String): Int {
    val frames = input.replace('-', '0').split("||", "|").dropLast(1)

    return calculateFramesScore(frames)
}

internal tailrec fun calculateFramesScore(frames: List<String>): Int {
    if (frames.isEmpty()) return 0

    val currentFrame = frames.first()
    val nextFrames = frames.drop(1)

    var score = 0

    if (currentFrame == "X") {
        score += calculateStrikeScore(nextFrames[0], nextFrames[1])
    } else {
        score += currentFrame[0].digitToInt()
        score += currentFrame[1].digitToInt()
    }

    return score + calculateFramesScore(nextFrames)
}

internal fun calculateStrikeScore(nextFrame: String, secondNextFrame: String): Int {
    var score = 10

    if (nextFrame == "X") {
        score += 10
        score += secondNextFrame[0].digitToInt()
    } else {
        score += nextFrame[0].digitToInt()
        score += nextFrame[1].digitToInt()
    }

    return score
}
