package tests;

import org.junit.jupiter.api.Test;
import static com.google.common.truth.Truth.assertThat;
import src.AListDS;
import src.ListDS;

public class ListsTest {
    @Test
    /** This test performs calls from AListDS. */
    public void AListTest() {
        AListDS<String> lds = new AListDS<>();
        lds.addLast("front"); // ["front"]
        lds.addLast("middle"); // ["front", "middle"]
        lds.addLast("back"); // ["front", "middle", "back"]
        assertThat(lds.toList()).containsExactly("front", "middle", "back").inOrder();
        assertThat(lds.removeLast()).isEqualTo("back");

        AListDS<Integer> lds2 = new AListDS<>();
        lds2.addFirst(6);
        for (int i = 0; i < 6; i++) {
            lds2.insertBack(3);
        }
        assertThat(lds2.toList()).containsExactly(6,3,3,3,3,3,3).inOrder();
        assertThat(lds2.getLast()).isEqualTo(3);
        assertThat(lds2.getFirst()).isEqualTo(6);
        assertThat(lds2.size()).isEqualTo(7);
    }

}
