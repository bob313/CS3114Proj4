/**
 * 
 * @author bob313 cdc97
 * @version nov21
 * @param <T>
 */
public class KVPair<T extends Comparable<T>> {
    private Object value;
    private Comparable<T> key;


    /**
     * 
     * @param key2
     *            key
     * @param elem
     *            element
     */
    public KVPair(Comparable<T> key2, Object elem) {
        value = elem;
        key = key2;
    }


    /**
     * 
     * @return value or element
     */
    public Object value() {
        return value;
    }


    /**
     * 
     * @return the key
     */
    public Comparable<T> key() {
        return key;
    }


    /**
     * convert to string
     * 
     * @return the string
     */
    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return "null";
    }
}
