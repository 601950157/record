package pattern.proxy;

import pattern.proxy.target.Person;
import pattern.proxy.target.WYL;
import sun.misc.ProxyGenerator;

import java.io.FileOutputStream;

/**
 * @author wangyl
 *
 * 将JDK的代理对象保存到文件
 */
public class GeneratorProxyApp {

    public static void main(String[] args) throws Exception {
        //proxy为WYL对象的代理对象
        Person wyl = new WYL("WangYongLong");
        DynamicProxy dynamicProxy = new DynamicProxy(wyl);
        Person proxy =(Person) dynamicProxy.getDynamicObj();
        proxy.getName();
        System.out.println(proxy.getClass());

        //生成代理对象类保存到本地文件
        byte[] data = ProxyGenerator.generateProxyClass("$Proxy0",new Class[]{Person.class});
        FileOutputStream fos = new FileOutputStream("$Proxy0.class");
        fos.write(data);
        fos.close();

        //生成的文件反编译之后与test中的$Proxy0类内容一致
    }
}
