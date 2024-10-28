package me.mail.surrenderyumi;


public class ArtificialIntellegenceAdvisor {
	
	public static void main(String[] args) {
		System.out.println("Hello, I am your helper. So we have program running");
		WeightAnalysor weightAnalysor = new WeightAnalysor();
		InputLine inputLine = new InputLine();
		while(true) {
			System.out.println("Commands: 0 - stop, 1 list all events, 2 show changes one to another, 3 show current weights, 4 add event, 10 start prediction");
			int command = inputLine.scanner.nextInt();
			if(command == 0) {
				break;
			} else if(command == 1) {
				weightAnalysor.showEvents();
			} else if(command == 2) {
				
			} else if(command == 3) {
				 weightAnalysor.showWeights();
			} else if(command == 4) {
				weightAnalysor.addEvent();
			} else if(command == 10) {
				weightAnalysor.doPrediction();
			}
		}
	}
	
}
