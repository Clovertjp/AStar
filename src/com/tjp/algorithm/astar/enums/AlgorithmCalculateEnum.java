/**
 * AlgorithmCalculateEnum.java
 */
package com.tjp.algorithm.astar.enums;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 下午2:28:17 
 * @version 1.0 
 */

public enum AlgorithmCalculateEnum {
	
	//
	
	/**
	 * 欧几里得距离</br>
	 * 公式：√( (x1-x2)^2+(y1-y2)^2 )
	 */
	EUCLIDEANMETRIC,
	//
	
	/**
	 * 曼哈顿距离</br>
	 * 公式：|x1-x2|+|y1-y2|
	 */
	MANHATTANDISTANCE,
	
	//
	
	/**
	 * 其他，自定义
	 */
	OTHER

}
