/**
 * IAnyDirectional.java
 */
package com.tjp.algorithm.astar.bean.inter;

import java.util.ArrayList;
import java.util.List;

import com.tjp.algorithm.astar.bean.driection.Direction;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 上午11:48:04 
 * @version 1.0 
 */

public interface IAnyDirectional {
	
	//方向集合
	public List<Direction> directionList=new ArrayList<Direction>();
	

	/**
	 * 创建方向
	 * @return
	 */
	public IAnyDirectional createDirection();

}
