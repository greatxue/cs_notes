package Lists;

public class SLList {
    private static class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    private IntNode sentinel;
    private int size;

    /** Create an empty list */
    public SLList() {
        sentinel = new IntNode(66, null);
        size = 0;
    }

    public SLList(int x) {
        sentinel = new IntNode(66, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x) {
        size += 1;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    /** Return the first item of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    /** Return the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Create a list of one integer 5 */
        SLList L = new SLList();
        L.addFirst(10);
        L.addLast(5);
        System.out.println(L.size());
    }
}
