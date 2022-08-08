package sample

class Frame(
    private val firstRoll: Int,
    private val secondRoll: Int = 0,
    private val firstBonusRoll: Int = 0,
    private val secondBonusRoll: Int = 0
) {
    val score
        get() = firstRoll + secondRoll + firstBonusRoll + secondBonusRoll
}
