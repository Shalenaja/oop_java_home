// Создать класс Notebook с полями (price(double), ram(int))
// 1. Сгенерировать список объектов типа Notebook с разными значениям price и ram
// 2. Релизовать 3 сортировки: 1 - по цене, 2 - по памяти, 3 - сначала по памяти, потом по цене
// 3. Отсортировать тремя способами стандартными средствами (Collections#sort или List#sort)

package oop_java_home_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Comparators {
  
    public static void main(String[] args) {
 
    List<Notebook> notebook = new ArrayList<>();
    notebook.add(new Notebook(25000.20, 8));
    notebook.add(new Notebook(60000.50,50));
    notebook.add(new Notebook(12000, 4));
    notebook.add(new Notebook(10000, 4));
    notebook.add(new Notebook(30000, 6));
    notebook.add(new Notebook(50000, 8));
    notebook.add(new Notebook(40000, 8));
    System.out.println("Список объектов: " + notebook);

    //Comparator<Notebook> PriceComparator = (o1, o2) -> Double.valueOf(o1.getPrice()).compareTo(Double.valueOf(o2.getPrice()));
    ComparatorNotebookPrice PriceComparator = new ComparatorNotebookPrice();
    Collections.sort(notebook, PriceComparator);
    System.out.println("Сортировка по цене: " + notebook);
    
    //Comparator<Notebook> RamComparator = (o1, o2) -> Integer.valueOf(o1.getRam()).compareTo(Integer.valueOf(o2.getRam()));
    ComparatorNotebookRam RamComparator = new ComparatorNotebookRam();
    Collections.sort(notebook, RamComparator);
    System.out.println("Сортировка по ram: " + notebook);

    Comparator<Notebook> RamPriceComparator = new ComparatorNotebookRam().thenComparing(new ComparatorNotebookPrice());
    Collections.sort(notebook, RamPriceComparator);  
    System.out.println("Сортировка по ram и цене" + notebook);
    }        
}