package Nov_15th;
//! this is java program to cal the area wit using any oops concepts
import java.util.Scanner;

abstract class Shapes{
    float area; // since it is commann at all i am keeping here
    abstract public void input(); // ! above lines helped us to involve abstraction
    abstract public void compute();
    public void disp()
    {
        System.out.println("the area is "+ area);
    }
}

class Rectangle extends Shapes{
    float length;
    float breadth;
    // float area;
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the length of rectangle");
        length = scan.nextFloat();
        System.out.println("please enter the breadth of rectangle");
        breadth = scan.nextFloat();
    }
    public void compute() {
        area = length * breadth;
    }
}

class Square extends Shapes {
    float length;
    // float area;
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the length of square");
        length = scan.nextFloat();
    }
    
    public void compute() {
        area = length * length;
    }
    
    
}

class Circle extends Shapes{
    float radius;
    final float pi = 3.14f;
    // float area;
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the radius of circle");
        radius = scan.nextFloat();
    }
    
    public void compute() {
        area = pi * radius * radius;
    }
    
   
}
class Geometry{ //todo: which helps in involvment of poloymorphisam
    void permit(Shapes s){
        s.input();
        s.compute();
        s.disp();
    }

}
public class LaunchArea {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Square ss = new Square();
        Circle c = new Circle();
        
        Geometry g = new Geometry();
        g.permit(r);
        g.permit(ss);
        g.permit(c);

    }
}
