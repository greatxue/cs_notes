package Sort;

public class Sort {
    public static void sort(String[] x) {
        int smallest = findSmallest(x);
        swap(x, 0, smallest);
        return ;
    }

    /** Sort the array starting at index 'start'. */
    private static void sort(String[] x, int start) {
        if (start >= x.length) {
            return ;
        }
        int smallest = findSmallest(x);
        swap(x, start, smallest);
        sort(x, start + 1);
    }
    public static int findSmallest(String [] x) {
        int smallest = 0;
        for (int i = 0; i < x.length; i++) {
            int cmp = x[i].compareTo(x[smallest]);
            if (cmp < 0) {
                smallest = i;
            }
        }
        return smallest;
    }

    public static void swap(String[] x, int a, int b) {
        String tmp = x[a];
        x[a] = x[b];
        x[b] = tmp;
    }
}
