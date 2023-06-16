package Lists;

public class SLList<Item> implements List61B<Item>{
    private class IntNode {
        public Item item;
        public IntNode next;

        public IntNode(Item i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Create an empty list */
    public SLList() {
        sentinel = new IntNode(null, null);
        size = 0;
    }

    public SLList(Item x) {
        sentinel = new IntNode(null, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Add x to the front of the list. */
    public void addFirst(Item x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    /** Return the first item of the list. */
    public Item getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(Item x) {
        size += 1;

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Return the size of the list. */
    @Override
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Create a list of one integer 5 */
        SLList<Integer> L = new SLList<>();
        L.addFirst(10);
        L.addLast(5);
        System.out.println(L.size());
    }
}
