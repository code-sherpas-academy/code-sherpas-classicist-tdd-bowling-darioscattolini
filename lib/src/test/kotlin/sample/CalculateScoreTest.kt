/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package sample

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class CalculateScoreTest {
    @Test
    fun `returns 0 for no pins knocked down`() {
        assertThat(calculateScore("--|--|--|--|--|--|--|--|--|--||")).isEqualTo(0)
    }

    @Test
    fun `returns amount of pins knocked down for frame 1, attempt 1, no strike`() {
        assertThat(calculateScore("3-|--|--|--|--|--|--|--|--|--||")).isEqualTo(3)
    }

    @Test
    fun `returns amount of pins knocked down for frame 1, attempt 2, no spare`() {
        assertThat(calculateScore("-7|--|--|--|--|--|--|--|--|--||")).isEqualTo(7)
    }

    @Test
    fun `returns amount of pins knocked down for frame 1, two attempts, no spare`() {
        assertThat(calculateScore("26|--|--|--|--|--|--|--|--|--||")).isEqualTo(8)
    }

    @Test
    fun `returns amount of pins knocked down for any frame, attempt 1, no strike`() {
        assertThat(calculateScore("--|--|--|4-|--|--|--|--|--|--||")).isEqualTo(4)
    }

    @Test
    fun `returns amount of pins knocked down for any frame, attempt 2, no spare`() {
        assertThat(calculateScore("--|--|--|--|-5|--|--|--|--|--||")).isEqualTo(5)
    }

    @Test
    fun `returns amount of pins knocked down for any frame, two attempts, no spare`() {
        assertThat(calculateScore("--|--|--|--|71|--|--|--|--|--||")).isEqualTo(8)
    }

    @Test
    fun `returns amount of pins knocked down for many frames, two attempts, no strikes nor spares`() {
        assertThat(calculateScore("--|2-|-3|18|-1|--|6-|--|-4|--||")).isEqualTo(25)
    }
}
