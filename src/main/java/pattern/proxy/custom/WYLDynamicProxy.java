package pattern.proxy.custom;

import java.lang.reflect.Method;

import pattern.proxy.target.Person;

public class WYLDynamicProxy implements WYLInvocationHandler {

    private Person target;

    public WYLDynamicProxy(Person target){
        this.target = target;
    }
    /**
     * 生成代理对象
     */
    public Object getDynamicObj(){
        return WYLProxy.newProxyInstance(new WYLClassLoader(),
                target.getClass().getInterfaces(),this);
    }

    public Object invoke(Object proxy, Method method, Object[] args) {
    	try {
    		Class clazz = this.target.getClass();
    		System.out.println("被代理类:"+clazz.getName());
    		return method.invoke(target, args);
		} catch (Exception e) {
			System.out.println(e.toString());
		}
    	return null;
    }

}
