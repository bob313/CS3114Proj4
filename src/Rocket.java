/**
 * 
 * @author bob313 cdc97
 * @version Nov 25
 *
 */
public class Rocket extends AirObject {
    private int asc;
    private double traj;


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
     * @param ascent
     *            ascent rate
     * @param trajectory
     *            trajectory
     */
    public Rocket(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth,
        String ascent,
        String trajectory) {
        super(object, inname, xorig, yorig, zorig, xwidth, ywidth, zwidth);
        asc = Integer.parseInt(ascent);
        traj = Double.parseDouble(trajectory);
    }


    @Override
    /**
     * @return the string of fields
     */
    public String toString() {
        return (string() + " " + asc + " " + traj);
    }


    /**
     * 
     * @return the ascent rate
     */
    public int getAscent() {
        return asc;
    }


    /**
     * 
     * @return the trajectory
     */
    public double getTrajectory() {
        return traj;
    }
}
