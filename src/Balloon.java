/**
 * 
 * @author bob313 cdc97
 * @version Nov 25
 *
 */
public class Balloon extends AirObject {
    private String typ;
    private int asc;


    /**
     * 
     * @param object
     *            object
     * @param inname
     *            name
     * @param xorig
     *            xcoord
     * @param yorig
     *            ycoord
     * @param zorig
     *            zcoord
     * @param xwidth
     *            xlength
     * @param ywidth
     *            ylength
     * @param zwidth
     *            zlength
     * @param type
     *            type of balloon
     * @param ascent
     *            ascent rate
     */
    public Balloon(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth,
        String type,
        String ascent) {
        super(object, inname, xorig, yorig, zorig, xwidth, ywidth, zwidth);
        typ = type;
        asc = Integer.parseInt(ascent);
    }


    @Override
    /**
     * returns a string of fields
     */
    public String toString() {
        return (string() + " " + typ + " " + asc);
    }


    /**
     * 
     * @return the type of balloon
     */
    public String getType() {
        return typ;
    }


    /**
     * 
     * @return the ascent rate
     */
    public int getAscent() {
        return asc;
    }
}
