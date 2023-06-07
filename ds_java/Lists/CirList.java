package Lists;
public class CirList {
    private static class IntNode {
        public int item;
        public IntNode prev;
        public IntNode next;
        
        public IntNode(int i, IntNode p, IntNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    
    private IntNode sentinel;
    private int size;
    
    public CirList(int x) {
        sentinel = new IntNode(66, null, null);
        sentinel.next = new IntNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    /** Create an empty list. */
    public CirList() {
        sentinel = new IntNode(66, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    /** Add x to the front of the list. */
    public void addFirst(int x) {
        size += 1;
        IntNode newNode = new IntNode(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    /** Return the 1st item of the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Add an item to the end of the list. */
    public void addLast(int x) {
        size += 1;
        IntNode newNode = new IntNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }
    
    /** Return the size of the list. */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        /* Create a list of one integer 5 */
        CirList L = new CirList(10);
        L.addFirst(10);
        L.addLast(5);
        System.out.println(L.size());
    }
}