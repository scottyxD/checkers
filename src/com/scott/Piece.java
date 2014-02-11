package com.scott;

import java.awt.Color;

public class Piece {
	
	private int xPos;
	private int yPos;
	private boolean isKnighted;
	private Color pieceColor;
	
	Piece(Color theColor)
	{
		xPos = 0;
		yPos = 0;
		isKnighted = false;
		pieceColor = theColor;
	}
		
	
	public int getxPos() {
		return xPos;
	}
	
	public Color getColor(){
		return pieceColor;
	}
	@Override
	public String toString() {
		if(pieceColor == Color.white)
		{
			return "O";
		}
		else
		{
			return "@";
		}
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}

	public int getyPos() {
		return yPos;
	}

	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	
	public boolean isKnighted() {
		return isKnighted;
	}

	public void setKnighted(boolean isKnighted) {
		this.isKnighted = isKnighted;
	}
	
}
