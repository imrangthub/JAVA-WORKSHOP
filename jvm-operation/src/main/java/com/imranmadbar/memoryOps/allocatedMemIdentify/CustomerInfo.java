package com.imranmadbar.memoryOps.allocatedMemIdentify;

public class CustomerInfo {
	
	
	public void makeCustomerMemConsumer(int memInfo) {
        long bytesToAllocate = memInfo * 1024L * 1024L;
        byte[]  memoryArray = new byte[(int) bytesToAllocate];
		
	}
	
	
	

}
