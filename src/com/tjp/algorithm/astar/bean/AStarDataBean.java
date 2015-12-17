package com.tjp.algorithm.astar.bean;
/**
 * Created by pei on 2015/12/16.
 */
public class AStarDataBean
{
	
	public AStarDataBean(byte data,int x,int y)
	{
		this.data=data;
		this.x=x;
		this.y=y;
	}
	
    //数据信息 保存该点是否可以通过等 暂定为 0:可以通过;  1:可跳过; 2: 可飞过; 3:怎么都过不去
    private byte data;

    //X坐标
    private int x;

    //Y坐标
    private  int y;
    
    private float gValue;//预估消耗值
    private float hValue;//到目的地预估消耗值
    private float fValue;//总消耗值
    
    private AStarDataBean parent;//父节点
    
    

    public byte getData() {
        return data;
    }

    public void setData(byte data) {
        this.data = data;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

	public float getgValue() {
		return gValue;
	}

	public void setgValue(float gValue) {
		this.gValue = gValue;
	}

	public float gethValue() {
		return hValue;
	}

	public void sethValue(float hValue) {
		this.hValue = hValue;
	}

	public float getfValue() {
		return fValue;
	}

	public void setfValue() {
		this.fValue = getgValue()+gethValue();
	}

	public AStarDataBean getParent() {
		return parent;
	}

	public void setParent(AStarDataBean parent) {
		this.parent = parent;
	}
    
    
    
}
