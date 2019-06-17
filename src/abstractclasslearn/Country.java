package abstractclasslearn;

import static java.lang.System.out;

public abstract class Country {

    public abstract void printCountryName();

    /* 抽象类中可以有非抽象的方法 */
    public void printCountrySetUpTime() {
        out.println("The creation time of the country remains a mystery!");
    }

    public static void main(String[] args) {
        Country c; /* 抽象类居然可以声明 */
    }
}
