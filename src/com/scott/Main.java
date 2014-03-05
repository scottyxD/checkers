package com.scott;

public class Main {

	public static void main(String[] args) 
	{
		Board theBoard = new Board();
		int turn = 0;
		while(!theBoard.player1.pieces.isEmpty() || !theBoard.player2.pieces.isEmpty() )
		{
			theBoard.drawBoard();
			if (turn % 2 == 0)
			{
				
				theBoard.moveDown(theBoard.player1, theBoard.player1.makeMove());
			}
			else
			{
				theBoard.moveUp(theBoard.player2, theBoard.player2.makeMove());
			}
			turn = turn + 1;
		}
		
		if (theBoard.player1.pieces.isEmpty())
		{
			System.out.println("Player 2 wins!");
		}
		else
		{
			System.out.println("player 1 wins!");
		}
	
	}

}
