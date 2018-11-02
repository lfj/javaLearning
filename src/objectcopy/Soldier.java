package objectcopy;

public class Soldier implements Cloneable{

    private String id;

    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "id=" + id + ",name=" + name;
    }

    public static void main(String[] args) {
        Soldier soldier1 = new Soldier();
        Soldier soldier2 = null;
        try {
            soldier2 = (Soldier)soldier1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        if (soldier1 == soldier2) {
            System.out.println("两个士兵不一样");
        }
    }
}
