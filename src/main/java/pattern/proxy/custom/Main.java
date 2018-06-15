package pattern.proxy.custom;

import pattern.proxy.target.Person;
import pattern.proxy.target.WYL;

public class Main {

   public static void main(String[] args) {

        Person wyl = new WYL("WangYongLong");
        WYLDynamicProxy dynamicProxy = new WYLDynamicProxy(wyl);
        Person proxy =(Person) dynamicProxy.getDynamicObj();

        String name = proxy.getName();
        System.out.println(name);
    }

}
