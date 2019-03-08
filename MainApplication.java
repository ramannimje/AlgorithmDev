package com.practo.rmn;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainApplication implements Runnable {
	private static Logger logger = Logger.getLogger(MainApplication.class.getName());
	Thread tobj;

	private HashMap<Integer, String> hm = new HashMap<>();
	MainApplication(){
		tobj = new Thread(this, "This is new runnable thread");
		System.out.println("My thread is created and is starting right now: " + tobj);
		tobj.start();
	}

	public static void main(String [] args) {
		MainApplication obj = new MainApplication();
		try {
			logger.setLevel(Level.ALL);
			logger.info("The flow is in the main method now..");
			while(obj.tobj.isAlive()) {
				logger.info("is Alive and is generating logs");
				obj.getResponse();
				System.out.println("Getting the implementation of Reverse method: ");
				obj.reverseHashMap();
				Thread.sleep(1500);
			}
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

	public HashMap<Integer, String> getResponse() {
		System.out.println("Ingesting the value inside the HashMap");
		hm.put(1, "Awe");
		hm.put(2, "Wsx");
		hm.put(3, "Rfv");
		hm.put(4, "Tgb");
		hm.put(5, "Ujm");


		Iterator<Entry<Integer, String>> itr = hm.entrySet().iterator();
		while(itr.hasNext()) {
			try {
				logger.info("We are iterating the current hashmap now..");
				System.out.println(hm.values());

				logger.info("Ingesting the random Strings in the Hashmap...");
				logger.info("The new Hashmap now looks like: ");
				int count = 0;
				if(count == 0 || count<1) {
					for(int i=1; i<=hm.size(); i++) {
						String randomString = getSaltString();
						hm.replace(i, hm.get(i), hm.put(i, randomString));
						count++;
					}
				}
				Thread.sleep(1000);
				System.out.println(hm.values());
				for(int i=1; i<=hm.values().size(); i++) {
					for(int j=0; j<hm.get(i).length(); j++) {
						System.out.println(hm.get(i).charAt(j));
					}
					System.out.println("\n");
				}

				break;
			} catch (InterruptedException e) {
				logger.severe("Error while iterating the hashmap..");
				System.out.println("Exception while iterating through the Iterator");
				e.printStackTrace();
			}
		}

		return hm;
	}

	private String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 18) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}

	private HashMap<Integer, String> reverseHashMap(){
		System.out.println("The Orignal Hashmap looks like: "+ hm.values());
		System.out.println("\n");
		System.out.println("After Reversing the Hashmap it looks like: ");
		for(int i=0; i<=hm.size()-1; i++) {
			System.out.println(hm.get(hm.size()-i));
		}
		return hm;
	}
}

