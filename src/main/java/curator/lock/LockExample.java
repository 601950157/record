package curator.lock;

import java.util.concurrent.TimeUnit;

import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.recipes.locks.InterProcessMutex;

public class LockExample {

	private InterProcessMutex lock;
	private String clientName;

	public LockExample(CuratorFramework client, String lockPath,String clientName) {
		this.clientName = clientName;
		lock = new InterProcessMutex(client, lockPath);
	}

	public void doWork(long time, TimeUnit unit) throws Exception {
		try {
			if (lock.acquire(time, unit)) {
				System.out.println(clientName + " has the lock");
			}
		} finally {
			System.out.println(clientName + " releasing the lock");
			lock.release();
		}
	}
}
