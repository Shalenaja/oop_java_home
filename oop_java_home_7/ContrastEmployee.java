package oop_java_home_7;

public class ContrastEmployee {
   
    public static void main(String[] args) {
    
    Employee mployee1 = new Employee ("Иванов Иван", "1", 21000);
    Employee mployee2 = new Employee ("Петров Иван", "2", 25000);
    Employee mployee3 = new Employee ("Иванов Иван", "1", 30000);
    Employee mployee4 = new Employee ("Иванов Петр", "1", 30000);
    System.out.println("Результат сравнения:" + mployee1.getName() + " с " + mployee2.getName() + " = "+ mployee1.equals(mployee2));
    System.out.println("Результат сравнения:" + mployee1.getName() + " с " + mployee3.getName() + " = "+ mployee1.equals(mployee3));
    System.out.println("Результат сравнения:" + mployee3.getName() + " с " + mployee4.getName() + " = "+ mployee3.equals(mployee4));

    System.out.println(mployee1.hashCode());
    System.out.println(mployee2.hashCode());
    System.out.println(mployee3.hashCode());
    System.out.println(mployee4.hashCode());
    System.out.println(mployee1.hashCode() == mployee2.hashCode());
    System.out.println(mployee1.hashCode() == mployee3.hashCode());
    System.out.println(mployee3.hashCode() == mployee4.hashCode());
      
    }
}
