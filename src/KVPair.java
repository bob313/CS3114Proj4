
public class KVPair<T extends Comparable<T>> {
    private Object value;
    private Comparable<T> key;

    public KVPair(Comparable<T> key2, Object elem) {
        value = elem;
        key = key2;
    }

    public Object value() {
        return value;
    }

    public Comparable<T> key() {
        return key;
    }

    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return "null";
    }
}
