package src;
import java.util.List;

public interface ListDS<Item> {
    /**
     * Insert an item to the end of the list.
     */
    void addLast(Item x);

    /**
     * Insert an item to the start of the list.
     */
    void addFirst(Item x);


    /**
     * Return the last item of the list.
     */
    Item getLast();

    /**
     * Return the first item of the list.
     */
    Item getFirst();


    /**
     * Delete item from back of the list and return the deleted item.
     */
    Item removeLast();


    /**
     * Get the (i+1)th item of the list.
     */
    Item get(int i);


    /**
     * Return the size of the list.
     */
    int size();

    /** Convert ListDS implemented to Java Lists */
    List<Item> toList();
}



