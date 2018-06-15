package pattern.proxy;

import pattern.proxy.target.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author wangyl
 * 手写动态代理的实现原理：
 *
 * 1 获取代理对象的引用与接口
 * 2 重新生成一个类，实现同一个接口
 * 3 编译新的类执行
 *
 * @date 2018-5-17
 */
public class DynamicProxy implements InvocationHandler {

    private Person target;

    public DynamicProxy(Person target){
        this.target = target;
    }

    /**
     * 生成代理对象
     */
    public Object getDynamicObj(){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
        Class clazz = this.target.getClass();
        System.out.println("被代理类:"+clazz.getName());
        return null;
    }
}
