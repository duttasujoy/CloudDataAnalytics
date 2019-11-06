package com.microservice.products;

import java.awt.Robot;
import java.awt.event.KeyEvent;

public class RobotKeyPress {
	
	public static void main(String[] args) {
		 Robot r;
		try {
			r = new Robot();
			
			while(true){
			r.keyPress(KeyEvent.VK_UP);
			Thread.sleep(20000);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    
	}

}
