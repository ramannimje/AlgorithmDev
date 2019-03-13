package com.practo.rmn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Scanner;
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

	public List<String> getCountries() {
		String[] countryCodes = Locale.getISOCountries();
		Locale obj = null;
		List<String> countryList = new ArrayList<String>();
		for(String countrycode : countryCodes) {
			obj = new Locale("", countrycode);
			System.out.println("Country code: " +obj.getCountry() + " Country name: " + obj.getDisplayCountry());
			countryList.add(countrycode);
		}
		return countryList;
	}

	public void getAirLines() {
		LinkedList<String> airlines =  new LinkedList<String>();
		airlines.add("Singapore Airlines");
		airlines.add("Qatar Airlines");
		airlines.add("ANA All Nippon Airways");
		airlines.add("Emirates");
		airlines.add("EVA Air");
		airlines.add("Cathay Pacific Airways");
		airlines.add("Lufthansa");
		airlines.add("Hainan Airlines");
		airlines.add("Garuda Indonesia");
		airlines.add("Thai Airways");
		airlines.add("Trans Anguilla Airways");
		airlines.add("LIAT");
		airlines.add("Air New Zealand");
		airlines.add("British Airways");
		airlines.add("Air India");
		airlines.add("Indigo");
		airlines.add("Jet Airways");
		airlines.add("Quantas");
		airlines.add("Air Canada");
		airlines.add("Air France");
		airlines.add("Kuwait Airlines");
		airlines.add("American Airlines");

		/*for(int i=0; i<airlines.size(); i++) {
			System.out.println(airlines.get(i).toString());
		}*/
	}

	public void searchFlights() {
		Scanner scFrom = new Scanner(System.in);
		System.out.println("Put from where you want to start Journey: ");
		String source = scFrom.nextLine();
		System.out.println(source);
		
		System.out.println("Put your Destination point: ");
		Scanner scTo =  new Scanner(System.in);
		String destination = scTo.nextLine();
		
		String startSource= null;
		String endDestination= null;
		List<String> countries = getCountries();
		if(scFrom != null) {
			if(countries.contains(source)) {
				startSource = source;
				System.out.println("Your Source is: " +startSource);
			}
		}
		
		if(scTo != null) {
			if(countries.contains(destination)) {
				endDestination = destination;
				System.out.println("Your Destination is: " +endDestination);
			}
		}
		
		String journeyDetails = startSource + " ---> " + destination;
		String airline = null;
		System.out.println("Journey Details: "+ journeyDetails);
		/*Get the India-Based Airlines*/
		if(journeyDetails.contains("US ---> IN") || journeyDetails.contains("IN ---> US")
				|| journeyDetails.contains("GB ---> IN") || journeyDetails.contains("IN ---> GB")
				|| journeyDetails.contains("FR ---> IN") || journeyDetails.contains("IN ---> FR")
				|| journeyDetails.contains("IN ---> DE") || journeyDetails.contains("DE ---> IN")) {
			if(startSource.contains("IN")) {
				airline = "Jet Airways";
			}
			else if(startSource.contains("FR")) {
				airline = "Air France";
			}
			else if(startSource.contains("US")) {
				airline = "American Airlines";
			}
			else {
				airline = "British Airways";
			}
		}
		/*Get the US-Based Airlines*/
		else if(journeyDetails.contains("US ---> GB") || journeyDetails.contains("GB ---> US")
				|| journeyDetails.contains("US ---> FR") || journeyDetails.contains("FR ---> US")
				|| journeyDetails.contains("US ---> DE") || journeyDetails.contains("DE ---> US")){
			if(startSource.contains("US")) {
				airline = "American Airlines";
			}
			else if(startSource.contains("FR")) {
				airline = "Air France";
			}
			else if(startSource.contains("GB")) {
				airline = "British Airways";
			}
			else {
				airline = "Lufthansa";
			}
		}
		/*Get the Australia-Based Airlines*/
		else if(journeyDetails.contains("AU ---> GB") || journeyDetails.contains("GB ---> AU")
				|| journeyDetails.contains("AU ---> IN") || journeyDetails.contains("IN ---> AU")
				|| journeyDetails.contains("AU ---> US") || journeyDetails.contains("US ---> AU")
				|| journeyDetails.contains("AU ---> DE") || journeyDetails.contains("DE ---> AU")
				|| journeyDetails.contains("AU ---> FR") || journeyDetails.contains("FR ---> AU")){
			if(startSource.contains("AU")) {
				airline = "Quantas";
			}
			else if(startSource.contains("GB")) {
				airline = "British Airways";
			}
			else if(startSource.contains("US")) {
				airline = "American Airlines";
			}
			else if(startSource.contains("FR")) {
				airline = "Air France";
			}
			else if(startSource.contains("DE")) {
				airline = "Lufthansa";
			}
			else {
				airline = "Air India";
			}
		}
		/*Get the France-Based Airlines*/
		else if(journeyDetails.contains("FR ---> GB") || journeyDetails.contains("GB ---> FR")
				|| journeyDetails.contains("FR ---> AU") || journeyDetails.contains("AU ---> FR")
				|| journeyDetails.contains("FR ---> IN") || journeyDetails.contains("IN ---> FR")
				|| journeyDetails.contains("FR ---> US") || journeyDetails.contains("US ---> FR")
				|| journeyDetails.contains("FR ---> DE") || journeyDetails.contains("DE ---> FR")){
			if(startSource.contains("FR")) {
				airline = "Air France";
			}
			else if(startSource.contains("GB")) {
				airline = "British Airways";
			}
			else if(startSource.contains("AU")) {
				airline = "Quantas";
			}
			else if(startSource.contains("IN")) {
				airline = "Jet Airways";
			}
			else if(startSource.contains("US")) {
				airline = "Virgin Atlantic";
			}
			else if(startSource.contains("GB")) {
				airline = "British Airways";
			}
			else{
				airline = "Lufthansa";
			}
		}
		/*Get the New-Zealand-Based Airlines*/
		else if(journeyDetails.contains("NZ ---> GB") || journeyDetails.contains("GB ---> NZ")
				|| journeyDetails.contains("NZ ---> AU") || journeyDetails.contains("AU ---> NZ")
				|| journeyDetails.contains("NZ ---> IN") || journeyDetails.contains("IN ---> NZ")
				|| journeyDetails.contains("NZ ---> US") || journeyDetails.contains("US ---> NZ")
				|| journeyDetails.contains("NZ ---> DE") || journeyDetails.contains("DE ---> NZ")){
			if(startSource.contains("FR")) {
				airline = "Air France";
			}
			else if(startSource.contains("GB")) {
				airline = "British Airways";
			}
			else if(startSource.contains("AU")) {
				airline = "Quantas";
			}
			else if(startSource.contains("IN")) {
				airline = "Jet Airways";
			}
			else if(startSource.contains("US")) {
				airline = "Virgin Atlantic";
			}
			else if(startSource.contains("GB")) {
				airline = "British Airways";
			}
			else if(startSource.contains("DE")){
				airline = "Lufthansa";
			}
			else {
				airline = "Air New Zealand";
			}
		}
		
		HashMap<String, String> airlinehm = new HashMap<String, String>();
		airlinehm.put(journeyDetails, airline);
		System.out.println("Following is the flight for your journey: " +airlinehm.values());
		System.out.println("\n");
		System.out.println("************Flight Search Result***********");
		System.out.println("********  "+journeyDetails + "  ***********");
		System.out.println("********  "+airline + "  ***********");
	}
}
