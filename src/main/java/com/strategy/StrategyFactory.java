package com.strategy;
/**
 * 策略工厂
 * @author 竹
 *
 */
public class StrategyFactory {
	private Strategy strategy;

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}
	
	public void execute() {
		this.strategy.executor();
	}
	
}
