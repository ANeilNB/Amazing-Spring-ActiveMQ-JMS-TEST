package com.netbuilder.nodemap;

import java.io.Serializable;
import java.util.List;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class Test implements Serializable
{
	private static final long serialVersionUID = 6;

	private Map<GladosNode> warehouseMap;
	private List<GladosNode> path;
	
	public List<GladosNode> getPath() {
		return path;
	}

	public Test()
	{
		warehouseMap = new Map<GladosNode>(20, 20, new GladosFactory());        
	    for(int i = 2; i < 18; i++)
	    {
	    	warehouseMap.setWalkable(2, i, false);
	    	warehouseMap.setWalkable(5, i, false);
	    	warehouseMap.setWalkable(8, i, false);
	    	warehouseMap.setWalkable(11, i, false);
	    	warehouseMap.setWalkable(14, i, false);
	    	warehouseMap.setWalkable(17, i, false);
	    }
	    path = warehouseMap.findPath(0, 0, 10, 10);
	    //send the path
	}
}