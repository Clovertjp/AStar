/**
 * AStarComparable.java
 */
package com.tjp.algorithm.astar.comparator;

import java.util.Comparator;

import com.tjp.algorithm.astar.bean.AStarDataBean;

/**
 * @author pei
 * @date 创建时间：2015年12月17日 下午5:08:52 
 * @version 1.0 
 */

public class AStarComparator implements Comparator<AStarDataBean> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(AStarDataBean o1, AStarDataBean o2) {
		// TODO Auto-generated method stub

		return o1.getfValue()-o2.getfValue();
	}

	

}
