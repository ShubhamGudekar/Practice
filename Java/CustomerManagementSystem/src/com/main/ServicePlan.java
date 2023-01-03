package com.main;

public enum ServicePlan {
	SILVER(250),GOLD(500),DIAMOND(750),PLATINUM(1000);
	
	private double planCost;
	
	private ServicePlan(double planCost)
	{
		this.planCost = planCost;
	}
	
	public double getPlanCost()
	{
		return this.planCost;
	}
	
	public void setPlanCost(double planCost)
	{
		this.planCost=planCost;
	}
}
