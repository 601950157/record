package curator.selection;

import com.netflix.curator.framework.CuratorFramework;
import com.netflix.curator.framework.CuratorFrameworkFactory;
import com.netflix.curator.framework.recipes.leader.LeaderSelector;
import com.netflix.curator.framework.recipes.leader.LeaderSelectorListener;
import com.netflix.curator.framework.state.ConnectionState;
import com.netflix.curator.retry.ExponentialBackoffRetry;

/**
 * 选举
 *
 * @author wangyl
 *
 */
public class MasterSelection {

	private static String master_path = "/curator_recipes_master_path";
	private static final String zkStr = "bigdata1:2181,bigdata2:2181,bigdata3:2181";

	public static void main(String[] args) throws Exception {
		CuratorFramework client = CuratorFrameworkFactory.builder().connectString(zkStr)
				.retryPolicy(new ExponentialBackoffRetry(1000, 3)).build();
		client.start();

		LeaderSelectorListener leaderSelectorListener = new LeaderSelectorListener() {

			@Override
			public void stateChanged(CuratorFramework arg0, ConnectionState arg1) {

			}

			@Override
			public void takeLeadership(CuratorFramework client) throws Exception {
				System.out.println("成为Master角色");
				Thread.sleep(3000);
				System.out.println("完成Master操作，释放Master权利");

			}
		};

		LeaderSelector selector = new LeaderSelector(client, master_path, leaderSelectorListener);
		selector.autoRequeue();
		selector.start();
		Thread.sleep(Integer.MAX_VALUE);
	}
}
