package pattern.factory.abs;

import pattern.factory.Car;

/**
 * 抽象工厂
 */
public abstract class AbstractFactory {

    /**
     * 抽象方法，由子类实现
     * @author wangyl
     */
    protected abstract Car getCar();

    public Car getCar(String name){
        if(name.equals("Audi")){
            return new AudiFactory().getCar();
        }else if(name.equals("BMW")){
            return new BMWFactory().getCar();
        }
        return  null;
    }

}
