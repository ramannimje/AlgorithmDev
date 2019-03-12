package com.practo.rmn;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeMap;
import java.util.logging.Logger;

public class LogicBehind {
	private static Logger logger = Logger.getLogger(MainApplication.class.getName());
	private NavigableMap<Integer, String> hm = new TreeMap<Integer, String>();

	public NavigableMap<Integer, String> getResponse() {
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
		while (salt.length() < 18) {
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;
	}

	public NavigableMap<Integer, String> reverseHashMap(){
		try {
			System.out.println("The Orignal Hashmap looks like: "+ hm.values());
			System.out.println("\n");
			System.out.println("After Reversing the Hashmap it looks like: ");
			for(int i=0; i<=hm.size()-1; i++) {
				System.out.println(hm.get(hm.size()-i));
			}
			System.out.println("Creating the derieved Hashmap: ");
			LinkedHashMap<Integer, String> reversedhm = new LinkedHashMap<Integer, String>();

			NavigableSet<Integer> hmSet = hm.navigableKeySet();
			Iterator<Integer> itr = hmSet.descendingIterator();
			Integer k;
			while(itr.hasNext()) {
				k = itr.next();
				reversedhm.put(k, hm.get(k));
			}
			System.out.println("\nReversed HashMap: "+reversedhm.values());
			logger.info("This is achived by converting the normal Hashmap to the Navigable HashMap and "
					+ "New Reversed hashmap is the LinkedHashMap");
		}
		catch (Exception e) {
			logger.warning("Error while reversing the HashMap..");
		}
		return hm;
	}

	public void serialKeysGenerator() {
		String serialKey = null;
		Character dashChar = new Character('-');
		String sb = null;
		if(serialKey == null) {
			for(int l=1; l<=hm.size(); l++) {
				serialKey = hm.get(l);
				System.out.println("The Generated Random value is:" +serialKey);

				int serialKeyLength = serialKey.length();
				System.out.println("The length of Random value is: " +serialKeyLength);

				logger.info("Your Serial key of Product is: ");

				sb = serialKey;
				String temp = null;
				int j=0;
				for(int i=1; i<=serialKey.length(); i++) {
					if(i%3 == 0)
					{
						temp = sb.substring(j, i) + dashChar;
						if(i==18) {
							temp = temp.substring(0, 3);
						}
						System.out.print(temp);
						j = j+3;
					}
				}
				System.out.println("\n");
			}
		}
	}
}
