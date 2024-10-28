package me.mail.surrenderyumi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class WeightAnalysor {
	private List<EventResult> results;
	private List<PlayerCellWeight> playersWeights;
	private EventStreakConstructor constructor;
	static int period = 90;
	
	public WeightAnalysor() {
		results = new ArrayList<EventResult>();
		playersWeights = new ArrayList<PlayerCellWeight>();
		
		for(int i = 0; i < 11;i++) playersWeights.add(new PlayerCellWeight(i));
		
		for(int i = 0; i<4; i++) {
			addEvent();
		}
		ArrayList<Integer> preferences = new ArrayList<Integer>();
		preferences.add(1);
		preferences.add(8);
		preferences.add(10);
		
		constructor = new EventStreakConstructor(playersWeights, preferences);
	}
	
	public void addEvent() {
		Scanner inputScanner = new InputLine().scanner;
		System.out.println("Event size: 0 small, 1 medium, 2 big, 3 global");
		int size = inputScanner.nextInt(); // 0 small, 1 medium, 2 big, 3 global
		System.out.println("Event time: 0 less 12 h, 1 more 12 h ");
		int time = inputScanner.nextInt(); // 0 less 12 h, 1 more 12 h 
		System.out.println("Event time waste 0 less then 1 h per day, 1 more or free");
		int valuable = inputScanner.nextInt(); // 0 less then 1 h per day, 1 more or free
		System.out.println("Event type  0 fight, 1 adventure, 2 research");
		int typeway = inputScanner.nextInt(); // 0 fight, 1 adventure, 2 research
		System.out.println("Event difficulty 0 allallowed, 1 hard");
		int difficult = inputScanner.nextInt(); // 0 allallowed, 1 hard
		System.out.println("Event mensize  0 sollo, 1 party, 2 raid, 3 guild");
		int menhunted = inputScanner.nextInt(); // 0 sollo, 1 party, 2 raid, 3 guild
		System.out.println("Plyer less then 1 h per day");
		float toobusy = inputScanner.nextFloat(); // less then 1 h per day
		weightTune(0, toobusy, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Player less then 5 h per day");
		float smallbusy = inputScanner.nextFloat(); // less then 5 h per day
		weightTune(1, smallbusy, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players more then 5 h per day");
		float notbusy = inputScanner.nextFloat(); // 2 more 5 h per day
		weightTune(2, notbusy, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players pve");
		float pve = inputScanner.nextFloat(); // style type
		weightTune(3, pve, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players pvp");
		float pvp = inputScanner.nextFloat(); // style type
		weightTune(4, pvp, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players pvevp");
		float pvevp = inputScanner.nextFloat(); // style type
		weightTune(5, pvevp, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players sollo");
		float sollo = inputScanner.nextFloat(); // player type
		weightTune(6, sollo, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players group");
		float party = inputScanner.nextFloat(); // player type
		weightTune(7, party, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players guild");
		float guild = inputScanner.nextFloat(); // player type
		weightTune(8, guild, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players researchers");
		float researcher = inputScanner.nextFloat(); // player type
		weightTune(9, researcher, size, time, valuable, typeway,difficult,menhunted);
		System.out.println("Players fighters");
		float fighter = inputScanner.nextFloat(); // player type
		weightTune(10, fighter, size, time, valuable, typeway,difficult,menhunted);
		results.add(new EventResult(size, time, valuable, typeway,difficult,menhunted,toobusy,smallbusy,notbusy,pve,pvp, pvevp, sollo, party, guild, researcher, fighter));
	}
	
	public void showEvents() {
		for(EventResult result : results) {
			result.printEventMetadata();
		}
	}
	
	public void showWeights() {
		for(int i = 0; i < playersWeights.size(); i++) {
			System.out.println("show current weight of: " + i);
			playersWeights.get(i).showWeights();
		}
	}
	
	private void weightTune(int number, Float weight, int size, int time, int valuable, int typeway, int difficult, int menhunted) {
		playersWeights.get(number).setSize(weight, size);
		playersWeights.get(number).setTime(weight, time);
		playersWeights.get(number).setValuable(weight, valuable);
		playersWeights.get(number).setTypeway(weight, typeway);
		playersWeights.get(number).setDifficult(weight, difficult);
		playersWeights.get(number).setMenhunted(weight, menhunted);
	}
	
	public void doPrediction() {
		constructor.generateEventStreak(period);
	}
}
