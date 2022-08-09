/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class CalculateScoreTest {
    @Test
    fun `returns 0 for no pins knocked down`() {
        assertThat(calculateScore("--|--|--|--|--|--|--|--|--|--||")).isEqualTo(0)
    }

    @ParameterizedTest
    @CsvSource(
        "3-|--|--|--|--|--|--|--|--|--||, 3",
        "-7|--|--|--|--|--|--|--|--|--||, 7",
        "26|--|--|--|--|--|--|--|--|--||, 8",
        "--|--|--|4-|--|--|--|--|--|--||, 4",
        "--|--|--|--|-5|--|--|--|--|--||, 5",
        "--|--|--|--|--|--|--|--|71|--||, 8"
    )
    fun `returns amount of pins knocked down for any frame without strike or spare`(input: String, expectedScore: Int) {
        assertThat(calculateScore(input)).isEqualTo(expectedScore)
    }

    @Test
    fun `returns amount of pins knocked down for many frames without strikes or spares`() {
        assertThat(calculateScore("--|2-|-3|18|-1|--|6-|--|-4|--||")).isEqualTo(25)
    }

    @ParameterizedTest
    @CsvSource(
        "X|--|--|--|--|--|--|--|--|--||, 10",
        "X|3-|--|--|--|--|--|--|--|--||, 16",
        "X|-7|--|--|--|--|--|--|--|--||, 24",
        "X|26|--|--|--|--|--|--|--|--||, 26",
        "X|X|--|--|--|--|--|--|--|--||, 30",
        "X|X|31|--|--|--|--|--|--|--||, 41",
        "X|X|X|--|--|--|--|--|--|--||, 60",
        "--|--|X|71|--|--|--|--|--|--||, 26",
        "--|--|--|X|X|X|25|--|--|--||, 76",
    )
    fun `returns 10 + pins knocked down in next two attempts for any frame with strike`(input: String, expectedScore: Int) {
        assertThat(calculateScore(input)).isEqualTo(expectedScore)
    }

    @ParameterizedTest
    @CsvSource(
        "--|--|--|--|--|--|--|--|--|X||--, 10",
        "--|--|--|--|--|--|--|--|--|X||-4, 14",
        "--|--|--|--|--|--|--|--|--|X||34, 17",
        "--|--|--|--|--|--|--|--|--|X||3X, 23",
        "--|--|--|--|--|--|--|--|--|X||XX, 30",
        "--|--|--|--|--|--|--|--|X|X||-4, 34",
        "--|--|--|--|--|--|--|--|X|X||24, 38",
    )
    fun `adds two extra attempts after strike in last frame`(input: String, expectedScore: Int) {
        assertThat(calculateScore(input)).isEqualTo(expectedScore)
    }

    @Test
    fun `returns 300 for all strikes`() {
        assertThat(calculateScore("X|X|X|X|X|X|X|X|X|X||XX")).isEqualTo(300)
    }

    @ParameterizedTest
    @CsvSource(
        "3/|--|--|--|--|--|--|--|--|--||, 10",
        "3/|3-|--|--|--|--|--|--|--|--||, 16",
        "3/|-4|--|--|--|--|--|--|--|--||, 14",
        "9/|X|--|--|--|--|--|--|--|--||, 30",
        "--|--|--|--|--|7/|--|--|--|--||, 10",
        "--|--|--|5/|4-|--|--|--|--|--||, 18",
        "--|--|--|--|--|--|--|2/|-7|--||, 17",
        "--|--|--|--|--|1/|X|--|--|--||, 30",
    )
    fun `returns 10 + pins knocked down in next attempt for any frame with spare`(input: String, expectedScore: Int) {
        assertThat(calculateScore(input)).isEqualTo(expectedScore)
    }

    @ParameterizedTest
    @CsvSource(
        "--|--|--|--|--|--|--|--|--|3/||-, 10",
        "--|--|--|--|--|--|--|--|--|5/||4, 14",
        "--|--|--|--|--|--|--|--|--|7/||X, 20"
    )
    fun `adds one extra attempt after spare in last frame`(input: String, expectedScore: Int) {
        assertThat(calculateScore(input)).isEqualTo(expectedScore)
    }
}
