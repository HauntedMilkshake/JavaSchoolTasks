public class Cube {
    double x,y,z;
 
    public double volume(){
        return x * y * z;
    }
    public double lateralSurfaceArea(){
        return 2 * (x * y) + 2 * (x * y) + 2 * (y * z);
    }
    public void printInfo(){
        System.out.println("x: " + x + " y: " + y + " z: " + z);
        System.out.println("Volume: " + volume() + " Lateral Surface Area: " + lateralSurfaceArea());
    }
}