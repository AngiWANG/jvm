package com.angi.jvm.chapter2;

/**
 * VM Args:-Xss2m
 * 
 * @author Angi
 * 
 */
public class JavaVMStackOOM {

	private void dontStop() {
		while (true) {

		}
	}

	public void stackLeakByThread() {
		while (true) {
			Thread thread = new Thread(new Runnable() {
				public void run() {
					dontStop();
				}
			});
			thread.start();
		}
	}

	public static void main(String[] args) throws Throwable {
		JavaVMStackOOM oom = new JavaVMStackOOM();
		oom.stackLeakByThread();
	}
}
