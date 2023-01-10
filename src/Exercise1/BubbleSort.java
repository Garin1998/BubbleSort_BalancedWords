package Exercise1;

import java.util.List;
import java.util.Objects;

/**
 * Class which contains basic method to sorting numbers via implementation of Bubble Sort Algorithm.
 * @param <T> must be a subclass of Number class and also have an implementation of Comparable class to be able to compare two numbers.
 * @author Krzysztof Kubiś
 * @since JDK 17
 */
public class BubbleSort<T extends Number & Comparable<T>> {

    public BubbleSort() {

    }

    /**
     * Sorting via Bubble Sort algorithm numbers, which are contained in provided List.
     * If a List contains null value then it is removed from it.
     * @param input  A List of specified type that contains numbers to be sorted.
     * @return List of specified type with sorted numbers in it.
     * @throws RuntimeException when a provided List is null.
     */
    public List<T> sort(List<T> input) throws RuntimeException {
        if(input == null) {
            throw new RuntimeException();
        }

        input.removeIf(Objects::isNull);

        for(int i = 0; i < input.size() - 1; i++) {
            for (int j = 0; j < input.size() - i - 1; j++) {
                if ((input.get(j)).compareTo(input.get(j + 1)) > 0) {
                    T temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);
                }
            }
        }
        return input;
    }
}
