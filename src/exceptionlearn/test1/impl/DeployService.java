package exceptionlearn.test1.impl;

import exceptionlearn.test1.IDeployService;

public class DeployService implements IDeployService {

    @Override
    public void doSomething() {
        System.out.println("I want to set up my own business!");
    }
}
