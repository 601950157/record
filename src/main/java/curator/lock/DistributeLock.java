package curator.lock;

import java.util.concurrent.TimeUnit;

import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.CuratorFrameworkFactory;
import com.netflix.curator.retry.ExponentialBackoffRetry;

/**
 *  分布式锁
 *  @author wangyl
 */
public class DistributeLock {

	private static final String PATH = "/wangyl";
	private static final String zkStr = "bigdata1:2181,bigdata2:2181,bigdata3:2181";

	public static void main(String[] args) {

		for (int i = 0; i < 200; i++) {
			CuratorFramework client = CuratorFrameworkFactory.newClient(zkStr, new ExponentialBackoffRetry(1000, 3));
			client.start();
			LockExample example = new LockExample(client, PATH, "client" + i);
			try {
				example.doWork(10, TimeUnit.SECONDS);
			} catch (Exception e) {

			} finally {
				client.close();
			}
		}
	}
}
