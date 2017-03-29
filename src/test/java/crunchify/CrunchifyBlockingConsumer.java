/**
 * CrunchifyBlockingConsumer.java
 * com.test.crunchify
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月28日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package crunchify;

import java.util.concurrent.BlockingQueue;

 
public class CrunchifyBlockingConsumer implements Runnable{
	
	private BlockingQueue<CrunchifyMessage> queue;
	
	public CrunchifyBlockingConsumer(BlockingQueue<CrunchifyMessage> queue){
		this.queue = queue;
	}
	
	@Override
	public void run() {
		try {
            CrunchifyMessage msg;
            // consuming messages until exit message is received
            while ((msg = queue.take()).getMsg() != "exit") {
                Thread.sleep(10);
                System.out.println("CrunchifyBlockingConsumer: Message - " + msg.getMsg() + " consumed.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
}
