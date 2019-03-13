package com.practo.rmn;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication implements Runnable {
	private static Logger logger = Logger.getLogger(MainApplication.class.getName());
	Thread tobj;

	MainApplication(){
		tobj = new Thread(this, "This is new runnable thread");
		System.out.println("My thread is created and is starting right now: " + tobj);
		tobj.start();
	}

	public static void main(String [] args) {
		MainApplication obj = new MainApplication();
		LogicBehind logicObj = new LogicBehind();
		try {
			logger.setLevel(Level.ALL);
			logger.info("The flow is in the main method now..");
			/*while(obj.tobj.isAlive()) {
				logger.info("is Alive and is generating logs");
				logicObj.getResponse();
				System.out.println("Getting the implementation of Reverse method: ");
				logicObj.reverseHashMap();
				Thread.sleep(1500);
				
				logger.info("Let's Generate the Serial Key: ");
				logicObj.serialKeysGenerator();
			}*/

			logicObj.getCountries();
			//System.out.println("Airlines are: ");
			logicObj.getAirLines();
			logicObj.searchFlights();
		}
		catch(Exception e) {
			logger.severe("getting error while getting the response..");
			System.out.println(e.getStackTrace());
		}
	}

	public void run() {
		System.out.println("Thread got started");
		try {
			logger.info("into the run method of thread operation..");
			for(int i=0; i<1; i++) {
				System.out.println(i);
				Thread.sleep(2000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

