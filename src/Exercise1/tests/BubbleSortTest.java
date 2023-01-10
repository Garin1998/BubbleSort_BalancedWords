package Exercise1.tests;

import Exercise1.BubbleSort;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


/**
 * Unit tests of {@link BubbleSort Class} using BDD testing approach
 * @author Krzysztof Kubiś
 * @since JDK 17, JUnit 5.8.1
 */
public class BubbleSortTest {

    @Test
    void whenArrayOfIntegersAsListIsValidThenReturnSortedList() {
        //given
        Integer[] arrayToSort = {1,4,5,6,8,3,8};
        Integer[] expectedArray = {1,3,4,5,6,8,8};
        BubbleSort<Integer> bs = new BubbleSort<>();
        List<Integer> arrayToSortAsList = new ArrayList<>(Arrays.asList(arrayToSort));

        //when - then
        bs.sort(arrayToSortAsList);
        assertArrayEquals(expectedArray, arrayToSortAsList.toArray());
    }

    @Test
    void whenArrayOfDoublesAsListIsValidThenReturnSortedList() {
        // given
        Double[] arrayToSort = {-9.3,0.2,4.0,0.1,5.0,9.0};
        Double[] expectedArray = {-9.3,0.1,0.2,4.0,5.0,9.0};
        List<Double> arrayToSortAsList = new ArrayList<>(Arrays.asList(arrayToSort));
        BubbleSort<Double> bs = new BubbleSort<>();

        // when - then
        bs.sort(arrayToSortAsList);
        assertArrayEquals(expectedArray, arrayToSortAsList.toArray());
    }

    @Test
    void whenArrayAsListIsEmptyThenReturnSortedEmptyList() {
        // given
        Integer[] arrayToSort = {};
        Integer[] expectedArray = {};
        List<Integer> arrayToSortAsList = new ArrayList<>(Arrays.asList(arrayToSort));
        BubbleSort<Integer> bs = new BubbleSort<>();

        // when - then
        bs.sort(arrayToSortAsList);
        assertArrayEquals(expectedArray, arrayToSortAsList.toArray());
    }

    @Test
    void whenArrayAsListIsValidAndContainNullThenRemoveNullFromThemAndReturnSortedList() {
        // given
        Double[] arrayToSort = {null,5.0001};
        Double[] expectedArray = {5.0001};
        List<Double> arrayToSortAsList = new ArrayList<>(Arrays.asList(arrayToSort));
        BubbleSort<Double> bs = new BubbleSort<>();

        // when - then
        bs.sort(arrayToSortAsList);
        assertArrayEquals(expectedArray, arrayToSortAsList.toArray());
    }

    @Test
    void whenArrayAsListToSortIsNullThenThrowRuntimeException() {
        // given
        List<Double> arrayToSortAsList = null;
        BubbleSort<Double> bs = new BubbleSort<>();

        // when - then
        assertThrows(RuntimeException.class, () -> bs.sort(arrayToSortAsList));
    }
}