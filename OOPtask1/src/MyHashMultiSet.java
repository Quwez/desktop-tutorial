import java.util.HashMap;

public class MyHashMultiSet<T> {
    private HashMap<T, Integer> counts;
    private int totalSize;

    public MyHashMultiSet() {
        this.counts = new HashMap<>();
        this.totalSize = 0;
    }

    public void add(T element) {
        if (counts.containsKey(element)) {
            int current = counts.get(element);
            counts.put(element, current + 1);
        } else {
            counts.put(element, 1);
        }
        totalSize++;
    }

    public boolean remove(T element) {
        if (!counts.containsKey(element)) {
            return false;
        }

        int current = counts.get(element);
        if (current == 1) {
            counts.remove(element);
        } else {
            counts.put(element, current - 1);
        }

        totalSize--;
        return true;
    }

    public int count(T element) {
        if (counts.containsKey(element)) {
            return counts.get(element);
        }
        return 0;
    }

    public boolean contains(T element) {
        return counts.containsKey(element);
    }

    public int size() {
        return totalSize;
    }

    public void clear() {
        counts.clear();
        totalSize = 0;
    }

    @Override
    public String toString() {
        return counts.toString();
    }
}