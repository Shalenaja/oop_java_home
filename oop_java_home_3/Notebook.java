package oop_java_home_3;

public class Notebook  {

    private double price;
    private int ram;
   
    public Notebook(double price, int ram) {
        this.price = price;
        this.ram = ram;        
    }

    public Notebook(int i, int j, int k) {
    }

    public double getPrice() {
        return price;
    }

    public int getRam() {
        return ram;
    }

    @Override
    public String toString() {        
        return "[" + ram + "] " + price;
    }

}