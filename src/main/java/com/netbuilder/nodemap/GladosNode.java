package com.netbuilder.nodemap;

import java.io.Serializable;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class GladosNode extends Node implements Serializable
{

	private static final long serialVersionUID = 3517839626106250588L;

	public GladosNode(){
		super();
	}
	
	public GladosNode(int xPosition, int yPosition)
	{
        super(xPosition, yPosition);
    }

    public void sethCosts(Node endNode) 
    {
        this.sethCosts((absolute(this.getxPosition() - endNode.getxPosition())
                + absolute(this.getyPosition() - endNode.getyPosition()))
                * BASICMOVEMENTCOST);
    }

    private int absolute(int a) 
    {
        return a > 0 ? a : -a;
    }
}