package com.netbuilder.nodemap;

import java.io.Serializable;

/**
 * 
 * @author JustinMabbutt
 *
 */
public class GladosFactory implements NodeFactory, Serializable
{
	private static final long serialVersionUID = -7401475084654209737L;

	@Override
    public Node createNode(int x, int y) 
	{
        return new GladosNode(x, y);
    }
}