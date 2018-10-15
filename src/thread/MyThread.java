package thread;

public class MyThread extends Thread {

    private int count = 5;
    public MyThread(String name){
        super();
        this.setName(name);
    }

    public MyThread(){
        super();
    }

    @Override
    synchronized public void run() {
        super.run();
        while (count > 0) {
            count--;
            System.out.println(" 由 " + this.currentThread().getName() + " 计算，count=" + count);
        }
    }

    public static void main(String[] args) {

        /* 不共享数据的运行结果 */
//        MyThread a=new MyThread("A");
//        MyThread b=new MyThread("B");
//        MyThread c=new MyThread("C");
//        a.start();
//        b.start();
//        c.start();

        /* 共享数据的运行结果 */
        MyThread mythread=new MyThread();
        Thread a1=new Thread(mythread,"A");
        Thread b1=new Thread(mythread,"B");
        Thread c1=new Thread(mythread,"C");
        Thread d1=new Thread(mythread,"D");
        Thread e1=new Thread(mythread,"E");
        a1.start();
        b1.start();
        c1.start();
        d1.start();
        e1.start();
    }
}
