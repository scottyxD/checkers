package com.scott;

import java.awt.Color;

public class Board {
	String[][] theBoard;
	Player player1, player2;
	Board()
	{
		theBoard = new String[8][8];
		player1 = new Player(Color.white,"Player 1");
		player2 = new Player(Color.black, "Player 2");
		initializePlayers();
		//initialize board to spaces
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				theBoard[i][j] = " ";
			}
		}		
	}
				
	public void drawBoard()
	{
		for (int i=0; i<8; i++)
		{
			for (int j=0; j<8; j++)
			{
				theBoard[i][j] = " ";
			}
		}
		for (int i=0;i<player1.pieces.size();i++)
		{
			theBoard[player1.pieces.get(i).getyPos()][player1.pieces.get(i).getxPos()] = player1.pieces.get(i).toString();
		}
		for (int i=0;i<player2.pieces.size();i++)
		{
			theBoard[player2.pieces.get(i).getyPos()][player2.pieces.get(i).getxPos()] = player2.pieces.get(i).toString();
		}
		
		for (int i=0; i<8; i++)
		{
			System.out.println("  —————————————————");
			System.out.print(i + " ");
			for (int j=0; j<8; j++)
			{
				System.out.print("|");
				System.out.print(theBoard[i][j]);
			}
			System.out.println("|");
		}
		System.out.println("  —————————————————");
		System.out.print("  ");
		for (int i=0; i<8; i++)
		{
			System.out.print(" " + i);
		}
		System.out.println("\n");
		
	}
	
	private void initializePlayers()
	{
		
		//player 1 row 1
		player1.pieces.get(0).setxPos(0);
		player1.pieces.get(0).setyPos(0);
		player1.pieces.get(1).setxPos(2);
		player1.pieces.get(1).setyPos(0);
		player1.pieces.get(2).setxPos(4);
		player1.pieces.get(2).setyPos(0);
		player1.pieces.get(3).setxPos(6);
		player1.pieces.get(3).setyPos(0);
		//player 1 row 2
		player1.pieces.get(4).setxPos(1);
		player1.pieces.get(4).setyPos(1);
		player1.pieces.get(5).setxPos(3);
		player1.pieces.get(5).setyPos(1);
		player1.pieces.get(6).setxPos(5);
		player1.pieces.get(6).setyPos(1);
		player1.pieces.get(7).setxPos(7);
		player1.pieces.get(7).setyPos(1);
		//player 1 row 3
		player1.pieces.get(8).setxPos(0);
		player1.pieces.get(8).setyPos(2);
		player1.pieces.get(9).setxPos(2);
		player1.pieces.get(9).setyPos(2);
		player1.pieces.get(10).setxPos(4);
		player1.pieces.get(10).setyPos(2);
		player1.pieces.get(11).setxPos(6);
		player1.pieces.get(11).setyPos(2);
		
		//player 2 row 1
		player2.pieces.get(0).setxPos(1); 
		player2.pieces.get(0).setyPos(7);
		player2.pieces.get(1).setxPos(3);
		player2.pieces.get(1).setyPos(7);
		player2.pieces.get(2).setxPos(5);
		player2.pieces.get(2).setyPos(7);
		player2.pieces.get(3).setxPos(7);
		player2.pieces.get(3).setyPos(7);
		//player 2 row 2
		player2.pieces.get(4).setxPos(0); 
		player2.pieces.get(4).setyPos(6);
		player2.pieces.get(5).setxPos(2);
		player2.pieces.get(5).setyPos(6);
		player2.pieces.get(6).setxPos(4);
		player2.pieces.get(6).setyPos(6);
		player2.pieces.get(7).setxPos(6);
		player2.pieces.get(7).setyPos(6);
		//player 2 row 3
		player2.pieces.get(8).setxPos(1); 
		player2.pieces.get(8).setyPos(5); 
		player2.pieces.get(9).setxPos(3);
		player2.pieces.get(9).setyPos(5);
		player2.pieces.get(10).setxPos(5);
		player2.pieces.get(10).setyPos(5);
		player2.pieces.get(11).setxPos(7);
		player2.pieces.get(11).setyPos(5);
	}

	public void doPlayer1Move()
	{
		
		Move p1Move = player1.makeMove();
		if(player1.validateSource(p1Move)) //check if source is a piece in player 1's inventory
		{
			System.out.println("Player 1 has piece in inventory");
			if(p1Move.getDestY()-p1Move.getOrigY() == 1) // if destination row is greater than source
			{
				if(Math.abs(p1Move.getDestX()-p1Move.getOrigX()) == 1) //if dest col is ofset from source col by 1
				{
					if (p1Move.getDestY() >= 0 && p1Move.getDestY() <= 7 && p1Move.getDestX() >= 0 && p1Move.getDestX() <= 7  ) //check if destination is on board
					{
						if(!player1.validateDest(p1Move)) //if player 1 doesn't have a piece in destination
						{
							if(player2.validateDest(p1Move)) //if player 2 has a piece in the destination
							{
								System.err.println("Player 2 piece detected");
								Move oldMove = new Move();
								oldMove.setDestX(p1Move.getDestX());
								oldMove.setDestY(p1Move.getDestY());
								//if move lands on player 2 piece, check if hop is valid and hop piece
								p1Move.setDestY(p1Move.getDestY() + 1);
								
								if (p1Move.getOrigX() < p1Move.getDestX() )
								{
									p1Move.setDestX(p1Move.getDestX() + 1);
								}
								else
								{
									p1Move.setDestX(p1Move.getDestX() - 1);
								}
								
								if (p1Move.getDestY() >= 0 && p1Move.getDestY() <= 7 && p1Move.getDestX() >= 0 && p1Move.getDestX() <= 7  ) //check if destination is on board
								{
									if (!player2.validateDest(p1Move))
									{
										player2.deletePiece(oldMove);
										player1.updatePiece(p1Move);
										//todo: check for potential double hop
									}
								}
								
							}
							else
							{
								player1.updatePiece(p1Move);
							}
							
						}
					}
				}
			}
		}
		
	}
	
	public void doPlayer2Move()
	{
		Move p2Move = player2.makeMove();
		if(player2.validateSource(p2Move)) //check if source is a piece in player 1's inventory
		{
			System.out.println("Player 2 has piece in inventory");
			if(p2Move.getDestY()-p2Move.getOrigY() == -1) // if destination row is greater than source by 1
			{
				if(Math.abs(p2Move.getDestX()-p2Move.getOrigX()) == 1) //if dest col is ofset from source col by 1
				{
					if (p2Move.getDestY() >= 0 && p2Move.getDestY() <= 7 && p2Move.getDestX() >= 0 && p2Move.getDestX() <= 7  ) //check if destination is on board
					{
						if(!player2.validateDest(p2Move)) //if player 1 doesn't have a piece in destination
						{
							if(player1.validateDest(p2Move))
							{
								System.err.println("Player 1 piece detected");
								Move oldMove = new Move();
								oldMove.setDestX(p2Move.getDestX());
								oldMove.setDestY(p2Move.getDestY());
								//if move lands on player 2 piece, check if hop is valid and hop piece
								p2Move.setDestY(p2Move.getDestY() - 1);
								
								if (p2Move.getOrigX() < p2Move.getDestX() )
								{
									p2Move.setDestX(p2Move.getDestX() + 1);
								}
								else
								{
									p2Move.setDestX(p2Move.getDestX() - 1);
								}
								if (p2Move.getDestY() >= 0 && p2Move.getDestY() <= 7 && p2Move.getDestX() >= 0 && p2Move.getDestX() <= 7  )
								{
									if (!player1.validateDest(p2Move))
									{
										player1.deletePiece(oldMove);
										player2.updatePiece(p2Move);
										//todo: check for potential double hop
									}
								}
								
							}
							else
							{
								player2.updatePiece(p2Move);
							}
							
						}
					}
				}
			}
		}
	}
}

