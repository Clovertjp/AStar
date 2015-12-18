/**
 * EightDirectional.java
 */
package com.tjp.algorithm.astar.bean.driection;

import com.tjp.algorithm.astar.bean.inter.IAnyDirectional;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 下午1:42:59 
 * @version 1.0 
 */

public class EightDirectional extends FourDirectional {

	/**
	 * @param xMax
	 * @param yMax
	 */
	public EightDirectional(int xMax, int yMax) {
		super(xMax, yMax);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param xMax
	 * @param yMax
	 * @param xMin
	 * @param yMin
	 */
	public EightDirectional(int xMax, int yMax, int xMin, int yMin) {
		super(xMax, yMax, xMin, yMin);
		// TODO Auto-generated constructor stub
	}

	
	/* (non-Javadoc)
	 * @see com.tjp.algorithm.astar.bean.FourDirectional#createDirection()
	 */
	@Override
	public IAnyDirectional createDirection() {
		// TODO Auto-generated method stub
		super.createDirection();
		
		Direction leftUpDriection=new Direction(-1, -1, 2, xMax, yMax, xMin, yMin);
		Direction leftDownDriection=new Direction(-1, 1, 2, xMax, yMax, xMin, yMin);
		Direction rightUpDriection=new Direction(1, -1, 2, xMax, yMax, xMin, yMin);
		Direction rightDownDriection=new Direction(1, 1, 2, xMax, yMax, xMin, yMin);
		
		directionList.add(leftUpDriection);
		directionList.add(leftDownDriection);
		directionList.add(rightUpDriection);
		directionList.add(rightDownDriection);
		
		return this;
	}
	



}
