package oop_java_home_4;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit>  /* FIXME Исправлять тут! */ {
       
    // Нужно реализовать хранение фрукто в коробке Box

    private final List<T> BoxList = new ArrayList<>();
   
    public void add(T fruit) {        
        BoxList.add(fruit);
    }

    public double getWeight() {
        double weight = 0;
        for(T fruit : BoxList) {
            weight += fruit.getWeight(); 
        }
        return weight;
    }
        
    void moveTo(Box<? super T> anotherBox) {
        for(T fruit : BoxList) {
            anotherBox.add(fruit); }         
        BoxList.clear();   
    }
}
