/**
 * 
 * @author bob313 cdc97
 * @version Nov 25
 *
 */
public class Airplane extends AirObject {
    private String carr;
    private int fli;
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
     * @param carrier
     *            type of aircraft
     * @param flight
     *            flight
     */
    public Airplane(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth,
        String carrier,
        String flight,
        String engine) {
        super(object, inname, xorig, yorig, zorig, xwidth, ywidth, zwidth);
        carr = carrier;
        fli = Integer.parseInt(flight);
        eng = Integer.parseInt(engine);
    }
    
    @Override
    public String toString() {
        return (string() + " " + carr + " " + fli + " " + eng);
    }
}
