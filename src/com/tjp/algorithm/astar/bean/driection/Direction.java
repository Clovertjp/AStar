/**
 * Direction.java
 */
package com.tjp.algorithm.astar.bean.driection;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 上午11:18:10 
 * @version 1.0 
 */

public class Direction {
	
	//X偏移值
	private int xOffset=0;
	
	//Y偏移值
	private int yOffset=0;
	
	//方向值
	private int directionValue;
	
	//x最小值
	private int xMin=0;
	
	//X最大值
	private int xMax=Integer.MAX_VALUE;
	
	//y最小值
	private int yMin=0;
	
	//y最大值
	private int yMax=Integer.MAX_VALUE;
	
	public Direction(int xOffset,int yOffset,int directionValue)
	{
		this.xOffset=xOffset;this.yOffset=yOffset;this.directionValue=directionValue;
	}
	public Direction(int xOffset,int yOffset,int directionValue,int xMax,int yMax)
	{
		this(xOffset, yOffset, directionValue);
		this.xMax=xMax;this.yMax=yMax;
	}
	public Direction(int xOffset,int yOffset,int directionValue,int xMax,int yMax,int xMin,int yMin)
	{
		this(xOffset, yOffset, directionValue, xMax, yMax);
		this.xMin=xMin;this.yMin=yMin;
	}

	public int getxOffset() 
	{
		return xOffset;
	}

	public void setxOffset(int xOffset) 
	{
		this.xOffset = xOffset;
	}

	public int getyOffset() 
	{
		return yOffset;
	}

	public void setyOffset(int yOffset) 
	{
		this.yOffset = yOffset;
	}

	public int getDirectionValue()
	{
		return directionValue;
	}

	public void setDirectionValue(int directionValue) 
	{
		this.directionValue = directionValue;
	}

	public int getxMin() 
	{
		return xMin;
	}

	public void setxMin(int xMin) 
	{
		this.xMin = xMin;
	}

	public int getxMax() 
	{
		return xMax;
	}

	public void setxMax(int xMax) 
	{
		this.xMax = xMax;
	}

	public int getyMin() 
	{
		return yMin;
	}

	public void setyMin(int yMin) 
	{
		this.yMin = yMin;
	}

	public int getyMax() 
	{
		return yMax;
	}

	public void setyMax(int yMax) 
	{
		this.yMax = yMax;
	}

	
	/** 
	 * 检测在 x y 上加入偏移值后是否是可用坐标  </br>
	 * 必须要小于最大值大于等于最小值
	 * @param x
	 * @param y
	 * @return
	 */
	public boolean judePoint(int x,int y)
	{
		int tempX=x+getxOffset();
		if(tempX >= getxMax() || tempX<getxMin())
			return false;
		
		int tempY=y+getyOffset();
		if(tempY>=getyMax() || tempY<getyMin())
			return false;
		
		return true;
	}

}
