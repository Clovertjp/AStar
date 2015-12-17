package com.tjp.algorithm.astar;

import com.tjp.algorithm.astar.bean.AStarDataBean;

/**
 * Created by pei on 2015/12/16.
 */
public class AStarAlgo {

    private int xLenth;
    private int yLenth;
    private AStarDataBean starDataBeans[][];
    
    private int beginX;
    private int brginY;
    private int endX;
    private int endY;

    public AStarAlgo(int ylenth,int xlenth)
    {
    	xLenth=xlenth;yLenth=ylenth;
    	starDataBeans=new AStarDataBean[yLenth][xLenth];
    }
    
    public void init(byte [][] data)
    {
    	for(int i=0;i<yLenth;i++)
    	{
    		for(int j=0;j<xLenth;j++)
    		{
    			AStarDataBean starDataBean=new AStarDataBean(data[i][j],j,i);
    			starDataBeans[i][j]=starDataBean;
    		}
    	}
    }
    
    
    public void setBeginEnd(int beginX,int beginY,int endX,int endY)
    {
    	this.beginX=beginX;this.brginY=beginY;
    	this.endX=endX;this.endY=endY;
    }
    
    
    
    


    public static void main(String[] args) {

	}

}
