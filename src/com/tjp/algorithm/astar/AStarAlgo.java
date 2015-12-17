package com.tjp.algorithm.astar;

import java.util.List;
import java.util.PriorityQueue;

import com.tjp.algorithm.astar.bean.AStarDataBean;
import com.tjp.algorithm.astar.comparator.AStarComparator;

/**
 * Created by pei on 2015/12/16.
 */
public class AStarAlgo {

    private int xLenth;//横坐标长度
    private int yLenth;//纵坐标长度
    private AStarDataBean starDataBeans[][];//数据
    
    //起始坐标x,y
    private int beginX=-1;
    private int brginY=-1;
    
    //目的坐标x,y
    private int endX=-1;
    private int endY=-1;
    
    //寻路类型
    private byte moveType=0;
    
    //open 表
    PriorityQueue<AStarDataBean> openQueue;
    
    //cloae 表
    List<AStarDataBean> closeArray;

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
    
    
    public void setBeginEnd(int beginX,int beginY,int endX,int endY) throws Exception
    {
    	if((beginX<0 || beginY<0) || (beginX>=xLenth || beginY>=yLenth) )
    		throw new Exception("起始点坐标错误");
    	this.beginX=beginX;this.brginY=beginY;
    	
    	if((endX<0 || endY<0) || (endX>=xLenth || endY>=yLenth) )
    		throw new Exception("目标点坐标错误");
    	this.endX=endX;this.endY=endY;
    }
    
    public void setMoveType(byte moveType) throws Exception
    {
    	if(moveType<0)
    		throw new Exception("寻路类型错误");
    	this.moveType=moveType;
    }
    
    
    public boolean searchWay() throws Exception
    {
    	if(beginX<0 || brginY<0)
    		throw new Exception("起始点坐标错误");
    	if(endX<0 || endY<0)
    		throw new Exception("目标点坐标错误");
    	
    	
    	
    	return true;
    }
    


    public static void main(String[] args) {
    	
    	PriorityQueue queue=new PriorityQueue<AStarDataBean>(10, new AStarComparator());
    	
    	AStarDataBean b1=new AStarDataBean((byte) 0, 0, 0);
    	b1.setgValue(100);
    	b1.setfValue();
    	
    	AStarDataBean b2=new AStarDataBean((byte) 0, 0, 0);
    	b2.setgValue(10);
    	b2.setfValue();
    	
    	AStarDataBean b3=new AStarDataBean((byte) 0, 0, 0);
    	b3.setgValue(1000);
    	b3.setfValue();
    	
    	queue.add(b1);queue.add(b2);queue.add(b3);
    	
    	System.out.println(((AStarDataBean)queue.poll()).getfValue());

	}

}
