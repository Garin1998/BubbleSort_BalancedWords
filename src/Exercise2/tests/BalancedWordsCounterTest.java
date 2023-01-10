package Exercise2.tests;

import Exercise2.BalancedWordsCounter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests of {@link BalancedWordsCounter Class} using BDD testing approach.
 * @author Krzysztof Kubiś
 * @since JDK 17, JUnit 5.8.1
 */
class BalancedWordsCounterTest {

    @Test
    void whenStringIsValidReturnCountOfBalancedWordsInSubWords28() {
        // given
        String input = "aabbabcccba";
        Integer expectedValue = 28;
        BalancedWordsCounter bwc = new BalancedWordsCounter();

        // when - then
        Integer actualValue = bwc.count(input);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void whenStringIsBlankReturnCountOfBalancedWordsInSubWords0() {
        // given
        String input = "";
        Integer expectedValue = 0;
        BalancedWordsCounter bwc = new BalancedWordsCounter();

        //when - then
        Integer actualValue = bwc.count(input);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    void whenStringContainsNumbersThenThrowRuntimeException() {
        // given
        String input = "abababa1";
        BalancedWordsCounter bwc = new BalancedWordsCounter();

        // when - then
        assertThrows(RuntimeException.class, () -> bwc.count(input));
    }

    @Test
    void whenStringIsNullThenThrowRuntimeException() {
        //given
        String input = null;
        BalancedWordsCounter bwc = new BalancedWordsCounter();

        //when - then
        assertThrows(RuntimeException.class, () -> bwc.count(input));
    }
}