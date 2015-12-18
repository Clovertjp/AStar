/**
 * IAlgorithmCalculate.java
 */
package com.tjp.algorithm.astar.bean.inter;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 下午2:04:24 
 * @version 1.0 
 */

public interface IAlgorithmCalculate<T> {
	
	public T calculateValue(int beginX,int beginY,int endX,int endY);

}
