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
				
				theBoard.doPlayer1Move();
			}
			else
			{
				theBoard.doPlayer2Move();
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
