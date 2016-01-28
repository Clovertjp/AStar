/**
 * FourDirectional.java
 */
package com.tjp.algorithm.astar.bean.driection;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import com.tjp.algorithm.astar.bean.inter.IAnyDirectional;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 上午11:40:49 
 * @version 1.0 
 */

public class FourDirectional implements IAnyDirectional {
	
	protected int xMax;
	protected int xMin;
	protected int yMax;
	protected int yMin;
	
	public List<Direction> directionList=new ArrayList<Direction>();
	
	public FourDirectional(int xMax,int yMax)
	{
		this.xMax=xMax;this.yMax=yMax;
	}
	
	public FourDirectional(int xMax,int yMax,int xMin,int yMin)
	{
		this(xMax, yMax);
		this.xMin=xMin;this.yMin=yMin;
	}

	/* (non-Javadoc)
	 * @see com.tjp.algorithm.astar.bean.IAnyDirectional#createDirection()
	 */
	@Override
	public IAnyDirectional createDirection() {
		// TODO Auto-generated method stub
		
		Direction upDriection=new Direction(0, -1, 1, xMax, yMax, xMin, yMin);
		Direction downDriection=new Direction(0, 1, 1, xMax, yMax, xMin, yMin);
		Direction leftDriection=new Direction(-1, 0, 1, xMax, yMax, xMin, yMin);
		Direction rightDriection=new Direction(1, 0, 1, xMax, yMax, xMin, yMin);
		
		directionList.add(upDriection);
		directionList.add(downDriection);
		directionList.add(leftDriection);
		directionList.add(rightDriection);
		
		return this;
	}

	/* (non-Javadoc)
	 * @see com.tjp.algorithm.astar.bean.inter.IAnyDirectional#getList()
	 */
	@Override
	public List<Direction> getDirectionList() {
		// TODO Auto-generated method stub
		return directionList;
	}

	
	

}
