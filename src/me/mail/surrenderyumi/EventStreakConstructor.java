package me.mail.surrenderyumi;

import java.util.ArrayList;
import java.util.List;

public class EventStreakConstructor {
	private List<PlayerCellWeight> weights;
	private boolean usepreferences;
	private List<Integer> preferencedList;
	private List<Integer> notfilled;
	private float[] currentweightpoint;
	
	public EventStreakConstructor(List<PlayerCellWeight> weights, List<Integer> preferencedList) {
		this.weights = weights;
		this.preferencedList = preferencedList;
		notfilled = new ArrayList<Integer>();
	}
	
	public void generateEventStreak(int period) {
		List<EventResult> events = new ArrayList<EventResult>();
		int i = 0;
		String waitString = "";
		
		currentweightpoint = new float[weights.size()];
		float[] currentWeight = new float[weights.size()];
		for(int a = 0; a<currentWeight.length;a++) {
			currentWeight[a] = 0;
		}
		usepreferences = false;
		notfilled = new ArrayList<>();
		for(int a = 0; a < currentWeight.length; a++) { notfilled.add(a); }
		while(i<period) {
			waitString += i + ", ";
			
			for(int a = 0; a<currentweightpoint.length;a++) {
				currentweightpoint[a] = 0;
			}
			
			events.add(new EventResult(generateSize(currentWeight), generateTimeduration(currentWeight), generateValuable(currentWeight), generateTypeway(currentWeight),
					generateDifficult(currentWeight), generateMenhunted(currentWeight),
					currentweightpoint[0], currentweightpoint[1], currentweightpoint[2], currentweightpoint[3], currentweightpoint[4], currentweightpoint[5], currentweightpoint[6], currentweightpoint[7], currentweightpoint[8], currentweightpoint[9], currentweightpoint[10]));
			int wait = (int) Math.floor(Math.random()*7);
			i += 3 + wait;
		}
		// here should be optimizer to get the best way
		System.out.println("Generating new scheduler has been ended");
		System.out.println("events schedule: " + waitString);
		for(EventResult event : events) {
			event.printEventMetadata();
		}
		
	}
	
	private int generateSize(float[] currentweights) {
		int element = (int)Math.floor(notfilled.size()*Math.random());
		int choosedone = notfilled.get(element);
		int characteristic = weights.get(choosedone).getPreferredSize();
		for(int i = 0; i <currentweights.length;i++) {
			currentweights[i] += (weights.get(i).getsize(characteristic)-currentweights[i])/2;
			currentweightpoint[i] += (weights.get(i).getsize(characteristic)-currentweightpoint[i])/2;
		}
		if(!usepreferences&&currentweights[choosedone]>=weights.get(choosedone).getRequirement()) removerequirement(element);
		return weights.get(choosedone).getPreferredSize();
	}
	private int generateTimeduration(float[] currentweights) {
		int element = (int)Math.floor(notfilled.size()*Math.random());
		int choosedone = notfilled.get(element);
		int characteristic = weights.get(choosedone).getPreferredSize();
		for(int i = 0; i <currentweights.length;i++) {
			currentweights[i] += (weights.get(i).getsize(characteristic)-currentweights[i])/2;
			currentweightpoint[i] += (weights.get(i).getsize(characteristic)-currentweightpoint[i])/2;
		}
		if(!usepreferences&&currentweights[choosedone]>=weights.get(choosedone).getRequirement()) removerequirement(element);
		return weights.get(choosedone).getPreferredTime();
	}
	private int generateValuable(float[] currentweights) {
		int element = (int)Math.floor(notfilled.size()*Math.random());
		int choosedone = notfilled.get(element);
		int characteristic = weights.get(choosedone).getPreferredSize();
		for(int i = 0; i <currentweights.length;i++) {
			currentweights[i] += (weights.get(i).getsize(characteristic)-currentweights[i])/2;
			currentweightpoint[i] += (weights.get(i).getsize(characteristic)-currentweightpoint[i])/2;
		}
		if(!usepreferences&&currentweights[choosedone]>=weights.get(choosedone).getRequirement()) removerequirement(element);
		return weights.get(choosedone).getPreferredValuable();
	}
	private int generateTypeway(float[] currentweights) {
		int element = (int)Math.floor(notfilled.size()*Math.random());
		int choosedone = notfilled.get(element);
		int characteristic = weights.get(choosedone).getPreferredSize();
		for(int i = 0; i <currentweights.length;i++) {
			currentweights[i] += (weights.get(i).getsize(characteristic)-currentweights[i])/2;
			currentweightpoint[i] += (weights.get(i).getsize(characteristic)-currentweightpoint[i])/2;
		}
		if(!usepreferences&&currentweights[choosedone]>=weights.get(choosedone).getRequirement()) removerequirement(element);
		return weights.get(choosedone).getPreferredTypeway();
	}
	private int generateDifficult(float[] currentweights) {
		int element = (int)Math.floor(notfilled.size()*Math.random());
		int choosedone = notfilled.get(element);
		int characteristic = weights.get(choosedone).getPreferredSize();
		for(int i = 0; i <currentweights.length;i++) {
			currentweights[i] += (weights.get(i).getsize(characteristic)-currentweights[i])/2;
			currentweightpoint[i] += (weights.get(i).getsize(characteristic)-currentweightpoint[i])/2;
		}
		if(!usepreferences&&currentweights[choosedone]>=weights.get(choosedone).getRequirement()) removerequirement(element);
		return weights.get(choosedone).getPreferredDifficult();
	}
	private int generateMenhunted(float[] currentweights) {
		int element = (int)Math.floor(notfilled.size()*Math.random());
		int choosedone = notfilled.get(element);
		int characteristic = weights.get(choosedone).getPreferredSize();
		for(int i = 0; i <currentweights.length;i++) {
			currentweights[i] += (weights.get(i).getsize(characteristic)-currentweights[i])/2;
			currentweightpoint[i] += (weights.get(i).getsize(characteristic)-currentweightpoint[i])/2;
		}
		if(!usepreferences&&currentweights[choosedone]>=weights.get(choosedone).getRequirement()) removerequirement(element);
		return weights.get(choosedone).getPreferredMenhunted();
	}
	
	private void removerequirement(int i) {
		notfilled.remove(i);
		System.out.println("notfilled: " + notfilled);
		if(notfilled.size()==0) {
			usepreferences = true;
			notfilled = preferencedList;
			System.out.println("new: " + notfilled);
		}
	}
}
