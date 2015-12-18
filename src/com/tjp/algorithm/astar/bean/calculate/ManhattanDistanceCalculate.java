/**
 * ManhattanDistanceCalculate.java
 */
package com.tjp.algorithm.astar.bean.calculate;

import com.tjp.algorithm.astar.bean.inter.IAlgorithmCalculate;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 下午2:12:35 
 * @version 1.0 
 * @param <T>
 */

public class ManhattanDistanceCalculate implements IAlgorithmCalculate<Integer> {

	/* (non-Javadoc)
	 * @see com.tjp.algorithm.astar.bean.inter.IAlgorithmCalculate#calculateValue(int, int, int, int)
	 */
	@Override
	public Integer calculateValue(int beginX, int beginY, int endX, int endY) {
		// TODO Auto-generated method stub
		return Math.abs(beginX-endX)+Math.abs(beginY-endY);
	}

	
	

}
