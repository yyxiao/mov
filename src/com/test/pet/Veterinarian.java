/**
 * Veterinarian.java
 * com.test.pet
 * author      date      	
 * ──────────────────────────────────
 * xiaoyy    2016年4月28日 		
 * Copyright (c)2016, All Rights Reserved.
 * Java源代码,未经许可禁止任何人、任何组织通过任何
 * 渠道使用、修改源代码.
*/
package com.test.pet;

import java.util.concurrent.BlockingQueue;

 
public class Veterinarian extends Thread{
	protected final BlockingQueue<Appointment<Pet>> appts;
	protected String text = "";
	protected final int restTime;
	private boolean shutdown = false;
	
	
	public Veterinarian(BlockingQueue<Appointment<Pet>> lbq, int pause){
		appts = lbq;
		restTime = pause;
	}
	
	public synchronized void shutdown(){
		shutdown = true;
	}
	
	@Override
	public void run() {
		while (!shutdown) {
			seePatient();
			try {
				Thread.sleep(restTime);
			} catch (Exception e) {
				shutdown = true;
			}
		}
		super.run();
	}
	
	public void seePatient(){
		try {
			//检索去除队列，直到有空闲的元素(阻塞take)
			Appointment<Pet> ap = appts.take();
			Pet patient = ap.getPatient();
			patient.examine();
		} catch (Exception e) {
			shutdown = true;
			e.printStackTrace();
		}
	}
	
}
