package exceptionlearn.test1;

import exceptionlearn.test1.impl.DeployService;

/**
 * 结论：
 * 1.接口中声明了throws Exception，那实现的方法中可以不写throws Exception
 * 2.接口中没有声明throws Exception，那实现的方法中一定不能加上throws Exception
 * 3.实现的方法中声明了throws Exception，那调用的方法中一定得加上try catch语句或者在调用的方法中抛出
 */
public class AppMain {
    public static void main(String[] args) {
        IDeployService deployService = new DeployService();
        try {
            deployService.doSomething();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
