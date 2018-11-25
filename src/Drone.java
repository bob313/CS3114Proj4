
public class Drone extends AirObject {
    private String brand;
    private int eng;


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
    public String toString() {
        return (string() + " " + brand + " " + eng);
    }

}
