package com.scott;

public class Move {
	
	private int origX, destX, origY, destY;

	public Move() {
		origX=0;
		origY=0;
		destX=0;
		destY=0;
	}

	public int getOrigX() {
		return origX;
	}

	public int getDestX() {
		return destX;
	}

	public int getOrigY() {
		return origY;
	}

	public int getDestY() {
		return destY;
	}

	public void setOrigX(int origX) {
		this.origX = origX;
	}

	public void setDestX(int destX) {
		this.destX = destX;
	}

	public void setOrigY(int origY) {
		this.origY = origY;
	}

	public void setDestY(int destY) {
		this.destY = destY;
	}
	

	
	

}
