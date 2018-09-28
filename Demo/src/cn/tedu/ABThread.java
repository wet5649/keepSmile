package cn.tedu;
public class ABThread {
	public static void main(String[] args) {
		Integer a = new Integer(10);
		new Thread(){
			public void run(){
				while(true){
				synchronized (a) {
						for(int i=0;i<10;i++){
							System.out.print("A");
						}
						System.out.println();
						try {
							a.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
						a.notifyAll();
					}
					
				}
			}
		}.start();
		new Thread(){
			public void run(){
				while(true){
				synchronized (a) {
						for(int i=0;i<10;i++){
							System.out.print("B");
						}
						System.out.println();
						try {
							a.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					
				}
			}
		}.start();
	}
}
