package pattern.singleton;

/**
 * @author wangyl
 * 静态内部类实现单例
 *
 * @date 2018-5-18
 */
public class SingleInstance {

    private SingleInstance(){}

    /**
     * 1 JVM加载类的时机
     *      new 操作
     *      访问该类的静态成员
     *      class.forName()
     * 2 当把以下静态内部类改成静态代码块的时候
     *      只要加载该类，就会初始化单例对象，分配内存空间
     * 3 当使用静态内部类实现时
     *      加载该类不会初始化该类中的静态方法和静态内部类，只有被调用的时候才会初始化单例
     */
    private static class SingleInstanceHolder {
        private static final SingleInstance SINGLE_INSTANCE = new SingleInstance();
    }

    public static final SingleInstance getInstance() {
        return SingleInstanceHolder.SINGLE_INSTANCE;
    }

}
