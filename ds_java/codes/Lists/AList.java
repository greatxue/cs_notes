package Lists;
/* AList Invariants:
   1. The position of next item to-be-inserted is 'size'.
   2. 'size' is always the number of items in the AList.
   3. The last item in the list is always in position 'size - 1'.
 */

public class AList<Item> {
    private Item[] items;
    private int size;

    /** Creates an empty list. */
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
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
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
    public static void main(String[] args) {
        AList<Integer> myList = new AList<>();

        // Add to the end of the list.
        myList.addLast(5);
        myList.addLast(10);
        myList.addLast(15);

        // Get the size of the list.
        int size = myList.size();
        System.out.println("The size of list: " + size);

        // Get the item of the list.
        int item = myList.get(1);
        System.out.println("The item [1]: " + item);

        // Delete end of the list.
        int removedItem = myList.removeLast();
        System.out.println("The item deleted: " + removedItem);

        // Get the last item of the list.
        int lastItem = myList.getLast();
        System.out.println("The last item: " + lastItem);
    }
}
