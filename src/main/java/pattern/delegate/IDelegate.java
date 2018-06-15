package pattern.delegate;

/**
 * 委派模式：
 *      spring MVC的DispatcherServlet就是典型的委派模式
 *      在开发者眼中，是DispatcherServlet在干活
 *      而真正干活的是九大元素:HandlerMapping、HandlerAdapter、ViewResolver
 *      DispatcherServlet就是将任务分解，分配给不同角色去干。
 */
public interface IDelegate {
}
