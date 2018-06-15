package pattern.proxy.custom;

import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

/**
 * @author wangyl
 * @see java.lang.reflect.Proxy
 * 生成代理对象的类
 */
public class WYLProxy {

    private static String line = "\r\n";

    public static Object newProxyInstance(WYLClassLoader loader,
                                          Class<?>[] interfaces,
                                          WYLInvocationHandler h)
            throws IllegalArgumentException{
        //1 生成源代码
        String proxySrc = generateSrc(interfaces[0]);
        //2 保存磁盘为.java文件
        String filePath = WYLProxy.class.getResource("").getPath();
        File f = new File(filePath+"$Proxy0.java");
        try {
            FileWriter fw = new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            //3 编译
            JavaCompiler compile = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compile.getStandardFileManager(null, null, null);
            Iterable iterable = manager.getJavaFileObjects(f);
            JavaCompiler.CompilationTask task = compile.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();

            //4 加载到JVM,返回代理对象
            Class proxyClass = loader.findClass("$Proxy0");
            Constructor constructor = proxyClass.getConstructor(WYLInvocationHandler.class);
            return constructor.newInstance(h);

        }catch (Exception e){
            System.out.print(e.toString());
        }
        return null;
    }
    //生成源代码
    private static String generateSrc(Class<?> interfaces){
        StringBuilder sb = new StringBuilder();
        sb.append("package pattern.proxy.custom;").append(line);
        sb.append("import java.lang.reflect.Method;").append(line);
        sb.append("public final class $Proxy0 implements " + interfaces.getName()+" {" + line);

        sb.append("WYLInvocationHandler h;"+line);

        sb.append("public $Proxy0(WYLInvocationHandler h){" + line);
        sb.append("this.h=h;" + line);
        sb.append("}"+line);

        for(Method m : interfaces.getMethods()){
            sb.append("public "+m.getReturnType().getName()+ " "+m.getName() + "(){" + line);
            sb.append("try{" + line);
            sb.append("Method m = " + interfaces.getName() + ".class.getMethod(\""+m.getName()+"\",new Class[]{});" +line);
            sb.append("this.h.invoke(this,m,null);"+line);
            sb.append("}catch(Throwable e){"+line);
            sb.append("System.out.print(e.toString());"+line);
            sb.append("}"+line);
            if(!m.getReturnType().getName().equals("void")){
                sb.append("return \"\";" + line);
            }
            sb.append("}"+line);

        }
        sb.append("}");
        return sb.toString();
    }

}
