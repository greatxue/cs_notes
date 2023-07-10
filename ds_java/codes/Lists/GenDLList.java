package Lists;

public class GenDLList<LochNess> {
    private class PubNode {
        public LochNess item;
        public PubNode prev;
        public PubNode next;
        
        public PubNode(LochNess i, PubNode p, PubNode n) {
            item = i;
            prev = p;
            next = n;
        }
    }
    
    private PubNode sentinel;
    private int size;
    
    public GenDLList(LochNess x) {
        sentinel = new PubNode(null, null, null);
        sentinel.next = new PubNode(x, sentinel, sentinel);
        sentinel.prev = sentinel.next;
        size = 1;
    }

    public GenDLList() {
        sentinel = new PubNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    public void addFirst(LochNess x) {
        size += 1;
        PubNode newNode = new PubNode(x, sentinel, sentinel.next);
        sentinel.next.prev = newNode;
        sentinel.next = newNode;
    }

    public LochNess getFirst() {
        return sentinel.next.item;
    }

    public void addLast(LochNess x) {
        size += 1;
        PubNode newNode = new PubNode(x, sentinel.prev, sentinel);
        sentinel.prev.next = newNode;
        sentinel.prev = newNode;
    }
    
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        GenDLList<Integer> L = new GenDLList<>(10);
        L.addFirst(20);
        L.addLast(30);
        System.out.println(L.size());
    }
}
