package trustrace;

class Coffee {
 public boolean Status=false;
    synchronized void makeCoffee() throws Exception {
        while (Status){wait();}
        System.out.println("Processing");
        Thread.sleep(10000);
        System.out.println("Coffee Ready....!");
        Status=true;
        notify();
    }
    synchronized void takeCoffee() throws Exception{
        while (!Status){wait();}
        System.out.println("Taking");
        Thread.sleep(5000);
        System.out.println("Make new One...!");
        Status=false;
        notify();
    }
}
class CoffeeMachine extends Thread{
    Coffee coffee;
    CoffeeMachine(Coffee coffee){
        this.coffee=coffee;
        Thread thread = new Thread(this,"CoffeeMachine");
        thread.start();
    }
    public void run() {
        while (true){
            try { coffee.makeCoffee();  }catch (Exception e){ System.out.println(e.getMessage()); }
        }
    }
}
class Waiter extends Thread{
    Coffee coffee;
    Waiter(Coffee coffee){
        this.coffee=coffee;
        Thread thread = new Thread(this,"Waiter");
        thread.start();
    }
    public void run(){
        while (true){
            try { coffee.takeCoffee(); }catch (Exception e){ System.out.println(e.getMessage()); }
        }
    }
}
public class CoffeeShop {
    public static void main(String[] args) {

        Coffee coffee=new Coffee();
        new CoffeeMachine(coffee);
        new Waiter(coffee);
    }
}
