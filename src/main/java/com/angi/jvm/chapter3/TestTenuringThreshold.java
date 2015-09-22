package com.angi.jvm.chapter3;

/**
 * 长期存活的对象将进入老年代
 * 
 * @author Angi
 * 
 */


/*
-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution

[GC [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
- age   1:     429176 bytes,     429176 total
: 4695K->419K(9216K), 0.0030565 secs] 4695K->4515K(19456K), 0.0030799 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 1 (max 1)
: 4515K->0K(9216K), 0.0004495 secs] 8611K->4515K(19456K), 0.0004606 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4423K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  54% used [0x00000000f9a00000, 0x00000000f9e51f98, 0x00000000fa200000)
  from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 4515K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  44% used [0x00000000fa400000, 0x00000000fa868c88, 0x00000000fa868e00, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 3040K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0f8268, 0x00000000fb0f8400, 0x00000000fc2c0000)
No shared spaces configured.
 */

/*
-verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:+UseSerialGC -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution

[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:     429176 bytes,     429176 total
: 4695K->419K(9216K), 0.0042782 secs] 4695K->4515K(19456K), 0.0042959 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[GC [DefNew
Desired survivor size 524288 bytes, new threshold 15 (max 15)
- age   1:        136 bytes,        136 total
- age   2:     429176 bytes,     429312 total
: 4679K->419K(9216K), 0.0004672 secs] 8775K->4515K(19456K), 0.0004766 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
Heap
 def new generation   total 9216K, used 4679K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
  eden space 8192K,  52% used [0x00000000f9a00000, 0x00000000f9e28fd8, 0x00000000fa200000)
  from space 1024K,  40% used [0x00000000fa200000, 0x00000000fa268d00, 0x00000000fa300000)
  to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
 tenured generation   total 10240K, used 4096K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
   the space 10240K,  40% used [0x00000000fa400000, 0x00000000fa800010, 0x00000000fa800200, 0x00000000fae00000)
 compacting perm gen  total 21248K, used 3040K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
   the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0f8268, 0x00000000fb0f8400, 0x00000000fc2c0000)
No shared spaces configured.
 */

public class TestTenuringThreshold {

	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3;
		allocation1 = new byte[_1MB / 4];
		//什么时候进入老年代取决于-XX:MaxTenuringThreshold的设置
		allocation2 = new byte[4 * _1MB];
		allocation3 = new byte[4 * _1MB];
		allocation3 = null;
		allocation3 = new byte[4 * _1MB];
	}
}
