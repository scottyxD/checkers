package com.scott;

public class Main {

	public static void main(String[] args) 
	{
		Board theBoard = new Board();
		while(true)
		{
			theBoard.drawBoard();
			theBoard.doMoves();
		}
	}

}
