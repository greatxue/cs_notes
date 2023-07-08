/* AList Invariants:
   1. The position of next item to-be-inserted is "size".
   2. "size" is always the number of items in the AList.
   3. The last item in the list is always in position "size - 1".
 */

public class AListDS<Item> implements Lists<Item> {
    private Item[] items;
    private int size;
    private int rfactor = 2;

    /** Creates an empty list. */
    public AListDS() {
        items = (Item[]) new Object[100];
        size = 0;
    }

    @Override
    public void addLast(Item x) {
        items[size] = x;
        size += 1;
    }

    @Override
    public void addFirst(Item x) {
        items[0] = x;
        size += 1;
    }

    /** Insert an item to the end of the list, even if out-of-range. */
    public void insertBack(Item x) {
        if (size == items.length) {
            resize(size * rfactor);
        }
        items[size] = x;
        size += 1;
    }

    @Override
    public Item getLast() {
        return items[size - 1];
    }

    @Override
    public Item getFirst() {
        return items[0];
    }

    @Override
    public Item removeLast() {
        Item x = getLast();
        // items[size - 1] = null;
        size -= 1;
        return x;
    }


    @Override
    public Item get(int i) {
        return items[i];
    }

    @Override
    public int size() {
        return size;
    }

    /** Adjust the size of the list. */
    public void resize(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    public static void main(String[] args) {
        AListDS<Integer> myList = new AListDS<>();

        // Add to the end of the list.
        myList.addLast(5);
        myList.addLast(10);
        myList.addLast(15);

        // Get the size of the list.
        int size = myList.size();
        System.out.println("The size of list is: " + size);

        // Get the item of the list.
        int item = myList.get(1);
        System.out.println("The item with index [1] is: " + item);

        // Delete end of the list.
        int removedItem = myList.removeLast();
        System.out.println("The item deleted is: " + removedItem);

        // Get the last item of the list.
        int lastItem = myList.getLast();
        System.out.println("The last item is: " + lastItem);
    }
}