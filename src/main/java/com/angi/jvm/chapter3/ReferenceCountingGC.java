package com.angi.jvm.chapter3;

/**
 * 引用计数算法
 * 
 * VM Args:-XX:+PrintGCDetails
 * 
 * objA和 objB会不会被GC呢？会
 * 
 * @author Angi
 * 
 */

/*
[GC [DefNew: 2417K->150K(4928K), 0.0042562 secs] 2417K->2198K(15872K), 0.0042993 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (System) [Tenured: 2048K->150K(10944K), 0.0063230 secs] 4246K->150K(15872K), [Perm : 2146K->2146K(12288K)], 0.0063919 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
Heap
 def new generation   total 4992K, used 134K [0x03ae0000, 0x04040000, 0x09030000)
  eden space 4480K,   3% used [0x03ae0000, 0x03b01a70, 0x03f40000)
  from space 512K,   0% used [0x03f40000, 0x03f40000, 0x03fc0000)
  to   space 512K,   0% used [0x03fc0000, 0x03fc0000, 0x04040000)
 tenured generation   total 10944K, used 150K [0x09030000, 0x09ae0000, 0x13ae0000)
   the space 10944K,   1% used [0x09030000, 0x09055a88, 0x09055c00, 0x09ae0000)
 compacting perm gen  total 12288K, used 2158K [0x13ae0000, 0x146e0000, 0x17ae0000)
   the space 12288K,  17% used [0x13ae0000, 0x13cfba98, 0x13cfbc00, 0x146e0000)
No shared spaces configured.
*/
public class ReferenceCountingGC {

	public Object instance = null;

	private static final int _1MB = 1024 * 1024;

	/**
	 * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
	 */
	@SuppressWarnings("unused")
	private byte[] bigSize = new byte[2 * _1MB];

	public static void main(String[] args) {
		ReferenceCountingGC objA = new ReferenceCountingGC();
		ReferenceCountingGC objB = new ReferenceCountingGC();
		objA.instance = objB;
		objB.instance = objA;
		objA = null;
		objB = null;
		System.gc();
	}
}
