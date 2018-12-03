/**
 * KVPair class that holds a key of comparable type T and a
 * value object
 * 
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
 * @param <T>
 *            the generic comparable
 */
public class KVPair<T extends Comparable<T>> {
    private Object value;
    private Comparable<T> key;


    /**
     * 
     * Constructor for KVPair
     * Initializes the Key and Value
     * 
     * @param ky
     *            key
     * @param elem
     *            element
     */
    public KVPair(Comparable<T> ky, Object elem) {
        value = elem;
        key = ky;
    }


    /**
     * Gets the value of KVPair
     * 
     * @return the KVPair value
     */
    public Object value() {
        return value;
    }


    /**
     * 
     * Gets the Key of KVPair
     * 
     * @return the KVPair key
     */
    public Comparable<T> key() {
        return key;
    }


    /**
     * Retrieves the string form of the KVPair Value
     * 
     * @return the string form of Value or 'null' if value is null
     */
    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return "null";
    }

}
