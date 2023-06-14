package Sort;

import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;

public class TestSort {
    /** Test the sort method of the sort class. */
    @Test
    public void testSort() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        String[] expected = {"a","newway", "rawr", "zaza"};
        Sort.sort(input);
        
        assertThat(input).isEqualTo(expected);
    }

    /** Test the findSmallest method of the sort class. */
    @Test
    public void testFindSmallest() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        int expected = 1;
        int actual = Sort.findSmallest(input);
        assertThat(actual).isEqualTo(expected);
    }

    /** Test the sort method of the sort class. */
    @Test 
    public void testSwap() {
        String[] input = {"rawr", "a", "zaza", "newway"};
        String[] expected = {"rawr", "newway", "zaza", "a" };
        Sort.swap(input, 1, 3);

        assertThat(input).isEqualTo(expected);
    }
}

