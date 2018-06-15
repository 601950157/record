# record记录开发中的点滴知识

### pattern包下面属于设计模式
```
proxy包里面手写一个动态代理，入口类pattern.proxy.custom.Main
```

### curator包下面是zookeeper的应用场景实现

#### 连接失败重试策略
```
ExponentialBackoffRetry(int baseSleepTimeMs, int maxRetries) 重试指定的次数, 且每一次重试之间停顿的时间逐渐增加.
RetryNTimes 指定最大重试次数
RetryOneTime 仅重试一次
RetryUnitilElapsed 一直重试直到规定的时间
```

#### 分布式锁
```
InterProcessMutex：分布式可重入排它锁
InterProcessSemaphoreMutex：分布式排它锁
InterProcessReadWriteLock：分布式读写锁
InterProcessMultiLock：将多个锁作为单个实体管理的容器
```
