import java.util.*;

public class KeyAndList <K extends Comparable<K>,V> implements Comparable<KeyAndList<K,V>> {
    private K key;
    private List<V> values;

    public KeyAndList(K key, List<V> values) {
        this.key = key;
        this.values = values;
    }

    @Override
    public String toString() {
        String s = key + " -> ";
        boolean first = true;
        for (V v : values) {
            if (first) {
                first = false;
            } else {
                s += ", ";
            }
            s += v;
        }
        return s;
    }

    @Override
    public int compareTo(KeyAndList<K, V> kv) {
        if (values.size() < kv.values.size()) {
            return -1;
        } else {
            if (values.size() > kv.values.size()) {
                return 1;
            } else {
                return key.compareTo(kv.key);
            }
        }
    }
}