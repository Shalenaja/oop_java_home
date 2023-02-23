package oop_java_home_3;

import java.util.Comparator;

public class ComparatorNotebookRam implements Comparator <Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {    
        return o1.getRam()-o2.getRam();
    }
}