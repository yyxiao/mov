/**
 * CrunchifyBlockingMain.java
 * com.test.crunchify
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月28日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package crunchify;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

 
public class CrunchifyBlockingMain {
	
	public static void main(String[] args) {
		
		BlockingQueue<CrunchifyMessage> crunchQueue = new ArrayBlockingQueue<>(10);
		CrunchifyBlockingProducer crunchProducer = new CrunchifyBlockingProducer(crunchQueue);
        CrunchifyBlockingConsumer crunchConsumer = new CrunchifyBlockingConsumer(crunchQueue);
        
        // starting producer to produce messages in queue
        new Thread(crunchProducer).start();
        
        // starting consumer to consume messages from queue
        new Thread(crunchConsumer).start();
        
        System.out.println("Let's get started. Producer / Consumer Test Started.\n");
	}
}
