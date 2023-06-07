package Lists;
/* AList Invariants:
   + The position of next item to-be-inserted is `size`.
   + `size` is always the number of items in the AList.
   + The last item in the list is always in position `size - 1`.
 */

public class AList<Item> {
    private Item[] items;
    private int size;

    /** Create an empty list. */
    public AList() {
        items = (Item[]) new Object[100];
        size = 0;
    }


    /** Insert an item to the end of the list. */
    public void addLast(Item x) {
        items[size] = x;
        size += 1;
    }

    /** Adjust the size of the list. */
    private void resize(int capacity) {
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);

    }

    /** Insert an item at the end of thelist, even if out-of-range. */
    public void insertBack(Item x) {
        int RFACTOR = 2;
        if (size == items.length) {
               resize(size * RFACTOR);
        }
        items[size] = x;
        size += 1;
    }

    /** Return the last item of the list. */
    public Item getLast() {
        return items[size - 1];
    }

    /** Get the (i+1)th item of the list. */
    public Item get(int i) {
        return items[i];
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }
    

    /** Delete simple item from back of the list and return deleted item. */
    public Item removeLast() {
        Item x = getLast();
        size -= 1;
        return x;
    }

    /** Delete object from back of the list and return deleted item. */
    public Item deleteBack() {
        Item x = getLast();
        items[size - 1] = null;
        size -= 1;
        return x;
    }
}