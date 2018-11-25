/**
 * 
 * @author bob313 cdc97
 * @version Nov 25
 *
 */
public class Drone extends AirObject {
    private String brand;
    private int eng;


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
     * @param brand
     *            brand of drone
     * @param engine
     *            number of engines
     */
    public Drone(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth,
        String brand,
        String engine) {
        super(object, inname, xorig, yorig, zorig, xwidth, ywidth, zwidth);
        this.brand = brand;
        eng = Integer.parseInt(engine);
    }


    @Override
    /**
     * @return the string of fields
     */
    public String toString() {
        return (string() + " " + brand + " " + eng);
    }


    /**
     * 
     * @return the brand of drone
     */
    public String getBrand() {
        return brand;
    }


    /**
     * 
     * @return the number of engines
     */
    public int getEngines() {
        return eng;
    }

}
