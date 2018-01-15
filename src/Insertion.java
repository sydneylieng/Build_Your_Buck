// Insertion sort class
public class Insertion {
	
	// Takes in the array of strings, sorts the array using less and exch methods
    public static Comparable[] sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--) {
                exch(a, j, j-1);
            }
        }
        return a;
    }
    
    // Compares two values and see which one if the first is less than the second
    private static boolean less(Comparable v, Comparable w) {
        return (v.compareTo(w) < 0);
    }

    // Takes in two values and exchanges their position in the array
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}