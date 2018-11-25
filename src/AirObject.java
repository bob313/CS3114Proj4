/**
 * Air traffic control general object type interface
 * All tracked objects must have a bounding prism and a name
 * *
 * 
 * @author {Your Name Here}
 * @version {Put Something Here}
 * 
 */

public class AirObject implements Comparable<AirObject> {
    private String obj;
    private String name; // Name for this AirObject
    private int xOrig;
    private int yOrig;
    private int zOrig;
    private int xWidth;
    private int yWidth;
    private int zWidth;


    /**
     * Constructor for base AirObject
     * 
     * @param inname
     *            The object's name
     *
     */
    public AirObject(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth) {
        obj = object;
        name = inname;
        xOrig = Integer.parseInt(xorig);
        yOrig = Integer.parseInt(yorig);
        zOrig = Integer.parseInt(zorig);
        xWidth = Integer.parseInt(xwidth);
        yWidth = Integer.parseInt(ywidth);
        zWidth = Integer.parseInt(zwidth);

    }


    /**
     * Gets the object type
     * 
     * @return the type of object
     */
    public String getObject() {
        return obj;
    }


    /**
     * Getter for x origin
     * 
     * @return x origin
     */
    public int getXorig() {
        return xOrig;
    }


    /**
     * Getter for x width
     * 
     * @return x width
     */
    public int getXwidth() {
        return xWidth;
    }


    /**
     * Getter for y origin
     * 
     * @return y origin
     */
    public int getYorig() {
        return yOrig;
    }


    /**
     * Getter for y width
     * 
     * @return y width
     */

    public int getYwidth() {
        return yWidth;
    }


    /**
     * Getter for z origin
     * 
     * @return z origin
     */
    public int getZorig() {
        return zOrig;
    }


    /**
     * Getter for z width
     * 
     * @return z width
     */

    public int getZwidth() {
        return zWidth;
    }


    /**
     * Getter for name
     * 
     * @return name
     */
    public String getName() {
        return name;
    }


    /**
     * Compare against a (name) String.
     *
     * @param it
     *            The String to compare to
     * 
     * @return Standard values for compareTo
     */
    public int compareTo(AirObject it) {
        return name.compareTo(it.getName());
    }
}
