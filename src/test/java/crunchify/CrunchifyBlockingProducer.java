/**
 * CrunchifyBlockingProducer.java
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

 
public class CrunchifyBlockingProducer implements Runnable{
	
	private BlockingQueue<CrunchifyMessage> crunchQueue;

	public CrunchifyBlockingProducer(BlockingQueue<CrunchifyMessage> queue) {
		this.crunchQueue = queue;
	}
	
	@Override
	public void run() {
		for(int i = 1; i<=5; i++){
			CrunchifyMessage msg= new CrunchifyMessage("i'm msg "+i);
			try {
				Thread.sleep(10);
				crunchQueue.put(msg);
				System.out.println("CrunchifyBlockingProducer: Message - "+msg.getMsg());
			} catch (Exception e) {
				System.out.println("Exception:"+e);
			}
		}
		
		 // adding exit message
        CrunchifyMessage msg = new CrunchifyMessage("All done from Producer side. Produced 50 CrunchifyMessages");
        try {
            crunchQueue.put(msg);
            System.out.println("CrunchifyBlockingProducer: Exit Message - " + msg.getMsg());
        } catch (Exception e) {
            System.out.println("Exception:" + e);
        }
	}

}
