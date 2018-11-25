
public class Bird extends AirObject {
    private String type;
    private int num;


    public Bird(
        String object,
        String inname,
        String xorig,
        String yorig,
        String zorig,
        String xwidth,
        String ywidth,
        String zwidth,
        String type,
        String number) {
        super(object, inname, xorig, yorig, zorig, xwidth, ywidth, zwidth);
        this.type = type;
        num = Integer.parseInt(number);
    }


    @Override
    public String toString() {
        return (string() + " " + type + " " + num);
    }

}
