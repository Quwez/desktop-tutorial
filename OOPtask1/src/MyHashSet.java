import java.util.HashMap;

public class MyHashSet<T> {
    private HashMap<T, Boolean> data;

    public MyHashSet() {
        this.data = new HashMap<>();
    }

    public boolean add(T element) {
        if (data.containsKey(element)) {
            return false;
        }
        data.put(element, true);
        return true;
    }

    public boolean remove(T element) {
        if (!data.containsKey(element)) {
            return false;
        }
        data.remove(element);
        return true;
    }

    public boolean contains(T element) {
        return data.containsKey(element);
    }

    public int size() {
        return data.size();
    }

    public void clear() {
        data.clear();
    }

    @Override
    public String toString() {
        return data.keySet().toString();
    }
}