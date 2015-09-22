package com.angi.jvm.chapter3;

/**
 * 大对象直接进入老年代
 * 
 * VM Args: <br/>
 * -verbose:gc -Xms20m -Xmx20m -Xmn10m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:PretenureSizeThreshold=3145728
 * 
 * @author Angi
 * 
 */

/*
Heap
 def new generation   total 9216K, used 671K [0x03a00000, 0x04400000, 0x04400000)
  eden space 8192K,   8% used [0x03a00000, 0x03aa7e50, 0x04200000)
  from space 1024K,   0% used [0x04200000, 0x04200000, 0x04300000)
  to   space 1024K,   0% used [0x04300000, 0x04300000, 0x04400000)
 tenured generation   total 10240K, used 4096K [0x04400000, 0x04e00000, 0x04e00000)
   the space 10240K,  40% used [0x04400000, 0x04800010, 0x04800200, 0x04e00000)
 compacting perm gen  total 12288K, used 2151K [0x04e00000, 0x05a00000, 0x08e00000)
   the space 12288K,  17% used [0x04e00000, 0x05019fd8, 0x0501a000, 0x05a00000)
No shared spaces configured.
*/

public class TestPretenureSizeThreshold {

	private static final int _1MB = 1024 * 1024;

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		byte[] allocation;
		allocation = new byte[4 * _1MB];
	}
}
