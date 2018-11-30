/**
 * KVPair class that holds a key of comparable type T and a
 * value object
 * 
<<<<<<< HEAD
 * @author bob313 cdc97
 * @version nov21
=======
 * @author Christian Carminucci <cdc97> Bob Bao <bob313>
 * @version 11/20/2018
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
 * @param <T>
 *            the generic comparable
 */
public class KVPair<T extends Comparable<T>> {
    private Object value;
    private Comparable<T> key;


    /**
<<<<<<< HEAD
     * 
     * @param key2
     *            key
     * @param elem
     *            element
     */
    public KVPair(Comparable<T> key2, Object elem) {
=======
     * Constructor for KVPair
     * Initializes the Key and Value
     * 
     * @param ky
     *            they key
     * @param elem
     *            the value
     */
    public KVPair(Comparable<T> ky, Object elem) {
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
        value = elem;
        key = ky;
    }


    /**
<<<<<<< HEAD
     * 
     * @return value or element
=======
     * Gets the value of KVPair
     * 
     * @return the KVPair value
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public Object value() {
        return value;
    }


    /**
<<<<<<< HEAD
     * 
     * @return the key
=======
     * Gets the Key of KVPair
     * 
     * @return the KVPair key
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public Comparable<T> key() {
        return key;
    }


    /**
<<<<<<< HEAD
     * convert to string
     * 
     * @return the string
=======
     * Retrieves the string form of the KVPair Value
     * 
     * @return the string form of Value or 'null' if value is null
>>>>>>> 9778e42fd5c80b37a685c233202bd19002029adb
     */
    public String toString() {
        if (value != null) {
            return value.toString();
        }
        return "null";
    }
    
    
}
