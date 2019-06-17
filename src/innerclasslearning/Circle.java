package innerclasslearning;

public class Circle {
    private double radius = 0;
    public static int count = 1;
    public String fileMaker = "lfj";

    public Circle(double radius){
        this.radius = radius;
        getDrawInstance().drawShape();
    }

    private Draw getDrawInstance() {
        return new Draw();
    }

    class Draw { //内部类
        private String fileMaker = "mn";

        public void drawShape() {
            System.out.println("radius=" + radius);
            System.out.println("fileMaker=" + fileMaker);
            System.out.println("Circle.this.fileMaker=" + Circle.this.fileMaker);
        }
    }

    public static void main() {
        /* 创建外部类 */
        /* 第一种方式 */
        Circle circle = new Circle(1.1);
        Circle.Draw draw = circle.new Draw(); //必须通过外部对象来创建

        /* 第二种方式 */

    }
}
