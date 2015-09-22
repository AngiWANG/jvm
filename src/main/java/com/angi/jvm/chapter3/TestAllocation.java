package com.angi.jvm.chapter3;

/**
 * 大对象优先在Eden分配
 * 
 * VM Args: <br/>
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails
 * 
 * @author Angi
 * 
 */

/*
[GC [DefNew: 6651K->150K(9216K), 0.0083815 secs] 6651K->6294K(19456K), 0.0084274 secs] [Times: user=0.00 sys=0.01, real=0.01 secs] 
Heap
 def new generation   total 9216K, used 4492K [0x03a90000, 0x04490000, 0x04490000)
  eden space 8192K,  53% used [0x03a90000, 0x03ecd7f8, 0x04290000)
  from space 1024K,  14% used [0x04390000, 0x043b5ad8, 0x04490000)
  to   space 1024K,   0% used [0x04290000, 0x04290000, 0x04390000)
 tenured generation   total 10240K, used 6144K [0x04490000, 0x04e90000, 0x04e90000)
   the space 10240K,  60% used [0x04490000, 0x04a90030, 0x04a90200, 0x04e90000)
 compacting perm gen  total 12288K, used 2158K [0x04e90000, 0x05a90000, 0x08e90000)
   the space 12288K,  17% used [0x04e90000, 0x050aba08, 0x050abc00, 0x05a90000)
No shared spaces configured.
*/

public class TestAllocation {

	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		// 出现一次Minor GC
		allocation4 = new byte[4 * _1MB];
	}
}
