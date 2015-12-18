/**
 * EuclideanMetricCalculate.java
 */
package com.tjp.algorithm.astar.bean.calculate;

import com.tjp.algorithm.astar.bean.inter.IAlgorithmCalculate;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 下午2:19:47 
 * @version 1.0 
 */

public class EuclideanMetricCalculate implements IAlgorithmCalculate<Double> {

	/* (non-Javadoc)
	 * @see com.tjp.algorithm.astar.bean.inter.IAlgorithmCalculate#calculateValue(int, int, int, int)
	 */
	@Override
	public Double calculateValue(int beginX, int beginY, int endX, int endY) {
		// TODO Auto-generated method stub
		return Math.sqrt((beginX-endX)^2+(beginY-endY)^2);
	}

}
