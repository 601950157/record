package pattern.factory.abs;

import pattern.factory.Car;

/**
 * @author wangyl
 * 抽象工厂模式测试入口
 * @date 2018-5-18
 */
public class Test {

    public static void main(String[] args) {
        DefaultFactory f = new DefaultFactory();
        Car car = f.getCar("BMW");
        String name = car.getName();
        System.out.println(name);
    }
}

