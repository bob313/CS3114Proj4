
public class Rocket extends AirObject {
    private int asc;
    private double traj;


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
    public String toString() {
        return (string() + " " + asc + " " + traj);
    }
}
