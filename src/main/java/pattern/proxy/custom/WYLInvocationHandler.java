package pattern.proxy.custom;

import java.lang.reflect.Method;

/**
 * @author wangyl
 * @see java.lang.reflect.InvocationHandler
 */
public interface WYLInvocationHandler {
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable;
}
