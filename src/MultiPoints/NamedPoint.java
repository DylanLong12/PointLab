package MultiPoints;

public class NamedPoint extends Point{
    private String name;

    public NamedPoint(double x, double y, String name) {
        super(x,y);
        this.name = name;
    }

    @Override
    public String toString(){
        return name + super.toString();
        //return name + "(" + super.getX() + ", " + super.getY() + ")\n";
    }
}
