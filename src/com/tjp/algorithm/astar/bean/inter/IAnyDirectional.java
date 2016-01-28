/**
 * IAnyDirectional.java
 */
package com.tjp.algorithm.astar.bean.inter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

import com.tjp.algorithm.astar.bean.driection.Direction;

/**
 * @author pei
 * @date 创建时间：2015年12月18日 上午11:48:04 
 * @version 1.0 
 */

public interface IAnyDirectional {
	
	//方向集合
	 //Collections.synchronizedList(new ArrayList<Direction>());//new ArrayList<Direction>();
	

	/**
	 * 创建方向
	 * @return
	 */
	public IAnyDirectional createDirection();
	
	public List<Direction> getDirectionList();

}
