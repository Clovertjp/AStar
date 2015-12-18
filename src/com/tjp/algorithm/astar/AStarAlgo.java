package com.tjp.algorithm.astar;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

import com.tjp.algorithm.astar.bean.AStarDataBean;
import com.tjp.algorithm.astar.bean.calculate.EuclideanMetricCalculate;
import com.tjp.algorithm.astar.bean.calculate.ManhattanDistanceCalculate;
import com.tjp.algorithm.astar.bean.driection.Direction;
import com.tjp.algorithm.astar.bean.driection.EightDirectional;
import com.tjp.algorithm.astar.bean.driection.FourDirectional;
import com.tjp.algorithm.astar.bean.inter.IAlgorithmCalculate;
import com.tjp.algorithm.astar.bean.inter.IAnyDirectional;
import com.tjp.algorithm.astar.comparator.AStarComparator;
import com.tjp.algorithm.astar.enums.AlgorithmCalculateEnum;

/**
 * Created by pei on 2015/12/16.
 */
public class AStarAlgo {

    private int xLenth;//横坐标长度
    private int yLenth;//纵坐标长度
    private AStarDataBean starDataBeans[][];//数据
    
    //起始坐标x,y
    private int beginX=-1;
    private int beginY=-1;
    
    //目的坐标x,y
    private int endX=-1;
    private int endY=-1;
    
    //寻路类型
    private byte moveType=0;
    
    //方向参数 默认8方向
    private IAnyDirectional direction=null;
    
    //计算方法 默认曼哈顿距离
    private IAlgorithmCalculate calculate=null;
    
    //open 表
    PriorityQueue<AStarDataBean> openQueue;
    
    //cloae 表
    List<AStarDataBean> closeArray;
    
    //路径表
    Stack<AStarDataBean> wayStack;

    public AStarAlgo(int ylenth,int xlenth) throws Exception
    {
    	if(xlenth<=0 || ylenth<=0)
    		throw new Exception("起始点坐标错误");
    	xLenth=xlenth;yLenth=ylenth;
    	starDataBeans=new AStarDataBean[yLenth][xLenth];
    	openQueue=new PriorityQueue<AStarDataBean>((int)Math.sqrt(xlenth*ylenth), new AStarComparator());
    	closeArray=new ArrayList<AStarDataBean>();
    	wayStack=new Stack<AStarDataBean>();
    }
    
    //
    
    /**
     * 初始化数据，将地图数据转换为可以用的Bean
     * @param data 
     */
    public AStarAlgo init(byte [][] data)
    {
    	for(int i=0;i<yLenth;i++)
    	{
    		for(int j=0;j<xLenth;j++)
    		{
    			AStarDataBean starDataBean=new AStarDataBean(data[i][j],j,i);
    			starDataBeans[i][j]=starDataBean;
    		}
    	}
    	
    	return this;
    }
    
    //
    
    /**
     * 设置起始点和目的点
     * @param beginX 起始X
     * @param beginY 起始Y
     * @param endX 目的X
     * @param endY 目的Y
     * @throws Exception
     */
    public AStarAlgo setBeginEnd(int beginX,int beginY,int endX,int endY) throws Exception
    {
    	if((beginX<0 || beginY<0) || (beginX>=xLenth || beginY>=yLenth) )
    		throw new Exception("起始点坐标错误");
    	this.beginX=beginX;this.beginY=beginY;
    	
    	if((endX<0 || endY<0) || (endX>=xLenth || endY>=yLenth) )
    		throw new Exception("目标点坐标错误");
    	this.endX=endX;this.endY=endY;
    	
    	return this;
    }
    
    //
    
    /**
     * 设置可走类型
     * @param moveType 暂定为： 0:可以通过;  1:可跳过; 2: 可飞过; 3:怎么都过不去
     * @throws Exception
     */
    public AStarAlgo setMoveType(byte moveType) throws Exception
    {
    	if(moveType<0)
    		throw new Exception("寻路类型错误");
    	this.moveType=moveType;
    	
    	return this;
    }
    
    //
    
    /**
     * 设置搜索方向 不设置的话默认8方向
     * @param direction
     * @return
     */
    public AStarAlgo setDirectional(IAnyDirectional direction)
    {
    	this.direction=direction;
    	return this;
    }
    //
    
    /**
     * 距离的计算公式 默认为曼哈顿距离
     * @param algoEnum 传入类型
     * @param cal 如果类型为Other 则需要传入 cal 否则传入null
     * @return
     */
    public AStarAlgo setAlgorithmCalculate(AlgorithmCalculateEnum algoEnum ,IAlgorithmCalculate cal)
    {
    	switch(algoEnum)
    	{
    	case EUCLIDEANMETRIC:
    		calculate=new EuclideanMetricCalculate();
    		break;
    	case MANHATTANDISTANCE:
    		calculate=new ManhattanDistanceCalculate();
    		break;
    	case OTHER:
    		if(cal!=null)
    		{
    			calculate=cal;
    		}else
    		{
    			calculate=new ManhattanDistanceCalculate();
    		}
    		break;
    		
    	}
    	return this;
    }
    
    //
    
    /**
     * A*寻路算法
     * @return true 有路径 false 无路径
     * @throws Exception
     */
    public boolean searchWay() throws Exception
    {
    	if(beginX<0 || beginY<0)
    		throw new Exception("起始点坐标错误");
    	if(endX<0 || endY<0)
    		throw new Exception("目标点坐标错误");

    	openQueue.add(starDataBeans[beginY][beginX]);
    	
    	if(direction==null)
    	{
    		direction=new EightDirectional(xLenth, yLenth).createDirection();
    	}
    	
    	if(calculate==null)
    	{
    		calculate=new ManhattanDistanceCalculate();
    	}
    	
    	while(!openQueue.isEmpty())
    	{
    		AStarDataBean dataBean=openQueue.poll();
    		
    		if(dataBean.getX()==endX && dataBean.getY()==endY)
    		{
    			closeArray.add(dataBean);
    			setWay();
    			return true;
    		}
    		for(int i=0;i<direction.directionList.size();i++)
    		{
    			Direction _direction=direction.directionList.get(i);
    			if(_direction.judePoint(dataBean.getX(), dataBean.getY()))
    			{
    				int x=dataBean.getX()+_direction.getxOffset();
    				int y=dataBean.getY()+_direction.getyOffset();
    				
    				if(starDataBeans[y][x].getData()>moveType)//判断是否为不可通过点
    					continue;
    				
    				if(closeArray.contains(starDataBeans[y][x]))
    					continue;
    				
    				int oldFValue=Integer.MAX_VALUE;
    				int nowFValue=0;
    				int gValue=0;
    				int hValue=0;
    				
    				if(openQueue.contains(starDataBeans[y][x]))
    				{
    					openQueue.remove(starDataBeans[y][x]);
    					
    					oldFValue=starDataBeans[y][x].getfValue();
    				}
    				
    				gValue=_direction.getDirectionValue();
    				hValue=(int) calculate.calculateValue(x, y, endX, endY);
    				nowFValue=gValue+hValue;
    				
    				if(oldFValue>nowFValue)
    				{
    					starDataBeans[y][x].setfValue(nowFValue);
    					starDataBeans[y][x].setgValue(gValue);
    					starDataBeans[y][x].sethValue(hValue);
    					starDataBeans[y][x].setParent(dataBean);
    				}
    				//System.out.println(x+ "   "+y);
    				openQueue.add(starDataBeans[y][x]);	
    			}
    		}
    		closeArray.add(dataBean);
    		
    	}
    	
    	wayStack.clear();
    	return false;
    }
    
    private void setWay()
    {
    	wayStack.clear();
    	AStarDataBean dataBean=starDataBeans[endY][endX];
    	while(dataBean.getParent()!=null)
    	{
    		wayStack.push(dataBean);
    		dataBean=dataBean.getParent();
    	}
    	wayStack.add(dataBean);
    }
    
    public Stack<AStarDataBean> getWay()
    {
    	return (Stack<AStarDataBean>) wayStack.clone();
    }
    


    public static void main(String[] args) throws Exception {
    	
    	byte[][] data={ {0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,1,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
    					{0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}// y 15 x 30

    	};
    	
    	AStarAlgo ago=new AStarAlgo(15, 30);
    	ago.setBeginEnd(0, 0, 29, 14).setDirectional(new FourDirectional(30, 15).createDirection()).setMoveType((byte) 0)
    	.setAlgorithmCalculate(AlgorithmCalculateEnum.MANHATTANDISTANCE, null).init(data);
    	System.out.println(ago.searchWay());
    	
    	Stack<AStarDataBean> stac=ago.getWay();
    	
    	while(!stac.empty())
    	{
    		System.out.println(stac.pop());
    	}

    	

	}

}
