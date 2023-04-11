package Nov_15th;
import java.util.Scanner;
//! this is normal java program to cal the area without using any oops concepts


class Rectangle {
    float length;
    float breadth;
    float area;
    
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
    
    public void disp() {
        System.out.println("the area is " + area);
    }
}

class Square {
    float length;
    float area;
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the length of square");
        length = scan.nextFloat();
    }
    
    public void compute() {
        area = length * length;
    }
    
    public void disp() {
        System.out.println("the area is " + area);
    }
}

class Circle {
    float radius;
    final float pi = 3.14f;
    float area;
    
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("please enter the radius of circle");
        radius = scan.nextFloat();
    }
    
    public void compute() {
        area = pi * radius * radius;
    }
    
    public void disp() {
        System.out.println("the area is " + area);
    }
}

public class LaunchAreaCal {
    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Square s = new Square();
        Circle c = new Circle();
        
        r.input();
        r.compute();
        r.disp();

        s.input();
        s.compute();
        s.disp();

        c.input();
        c.compute();
        c.disp();
    }
}
