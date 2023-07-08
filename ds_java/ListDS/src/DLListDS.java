public class DLListDS implements Lists<Integer>{
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
    private IntNode rearguard;
    private int size;


    /** Initialize a list with a specific item within. */
    public DLListDS(int x) {
        sentinel = new IntNode(-1, null, null);
        rearguard = new IntNode(-1, null, null);
        sentinel.next = new IntNode(x, sentinel, rearguard);
        rearguard.prev = sentinel.next;
        size = 1;
    }

    /** Create an empty list. */
    public DLListDS() {
        sentinel = new IntNode(-1, null, null);
        rearguard = new IntNode(-1, null, null);
        sentinel.next = rearguard;
        rearguard.prev = sentinel;
        size = 0;
    }

    @Override
    public void addLast(Integer x) {
        size += 1;
        IntNode newNode = new IntNode(x, rearguard.prev, rearguard);
        rearguard.prev.next = newNode;
        rearguard.prev = newNode;
    }

    @Override
    public void addFirst(Integer x) {
        size += 1;
        IntNode newNode = new IntNode(x, rearguard.prev, rearguard);

    }

    @Override
    public Integer getLast() {
        return null;
    }

    @Override
    public Integer getFirst() {
        return null;
    }

    @Override
    public Integer removeLast() {
        return null;
    }

    @Override
    public Integer get(int i) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }






}
