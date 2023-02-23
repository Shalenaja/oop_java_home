package oop_java_home_3;

import java.util.Comparator;

public class ComparatorNotebookPrice implements Comparator <Notebook> {
    @Override
    public int compare(Notebook o1, Notebook o2) {
        if (o1.getPrice() > o2.getPrice())
            return 1;
        else if (o1.getPrice() < o2.getPrice())
            return -1;
        else     
            return 0;
        }
}
