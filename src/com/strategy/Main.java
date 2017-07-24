package com.strategy;

public class Main {

	public static void main(String[] args) {
		StrategyFactory sf = new StrategyFactory();
		sf.setStrategy(new StrategyDetail2());
		sf.execute();
		
		sf.setStrategy(new StrategyDetail2());
		sf.execute();
		
		
		sf.setStrategy(new StrategyDetail3());
		sf.execute();
	}

}
