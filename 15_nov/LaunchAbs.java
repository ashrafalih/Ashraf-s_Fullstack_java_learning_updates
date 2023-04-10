package Nov_15th;

abstract class Loan1
{
    abstract public void dispInt();
    public void welcomNote()
    {
        System.out.println("welcome to xxx bank");
    }
}
class HomeLoan1 extends Loan1
{
    @Override
    public void dispInt() {
        System.out.println("rate of intrest is 12 percent");
    }
}
class EducationLoan1 extends Loan1
{
    @Override
    public void dispInt() {
        System.out.println("rate of intrest is 10 percent");
    }
}

public class LaunchAbs {
    public static void main(String[] args) {
       // Loan1 l = new Loan1(); 
// ! * if it is enabled then we get error with this 
//! we can conclude that we can't create object of abstrac class
       //todo: so if you don't want to create 
       
        Loan1 loan = new HomeLoan1(); 
// todo: taken here class name(Loan1) as ref.,
// ! with this we can say that we can create ref of abstract class
// todo: if you want no one to create object of your class then you have to 
// todo: to declare your class as abstract
        loan.dispInt();
        loan.welcomNote();

        Loan1 loan1 = new EducationLoan1();
        
    }
    
}
