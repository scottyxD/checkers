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
		player1.setMovingDown();
		player2.setMovingUp();
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

	public Boolean makeMove(Player moveMaker, Move theMove, Boolean isHopping)
	{
		boolean wentRight = false;
		Player oppositePlayer;
		
		if (moveMaker.equals(player1))
		{
			oppositePlayer = player2;
		}
		else
		{
			oppositePlayer = player1;
		}
		
		
		if(moveMaker.validateSource(theMove)) //check if source is a piece in player 1's inventory
		{
			//System.out.println("Player 1 has piece in inventory");
			if(theMove.getDestY()-theMove.getOrigY() == moveMaker.getMoveFactor()) // if destination row is greater than source
			{
				if(Math.abs(theMove.getDestX()-theMove.getOrigX()) == 1) //if dest col is ofset from source col by 1
				{
					if (theMove.getDestY() >= 0 && theMove.getDestY() <= 7 && theMove.getDestX() >= 0 && theMove.getDestX() <= 7  ) //check if destination is on board
					{
						if(!moveMaker.validateDest(theMove)) //if player 1 doesn't have a piece in destination
						{
							if(oppositePlayer.validateDest(theMove)) //if player 2 has a piece in the destination
							{
								//System.err.println("Player 2 piece detected");
								Move oldMove = new Move();
								oldMove.setDestX(theMove.getDestX());
								oldMove.setDestY(theMove.getDestY());
								//if move lands on player 2 piece, check if hop is valid and hop piece
								theMove.setDestY(theMove.getDestY() + moveMaker.getMoveFactor());
								
								if (theMove.getOrigX() < theMove.getDestX() )
								{
									theMove.setDestX(theMove.getDestX() + 1);
									wentRight = true;
								}
								else
								{
									theMove.setDestX(theMove.getDestX() - 1);
								}
								
								if (theMove.getDestY() >= 0 && theMove.getDestY() <= 7 && theMove.getDestX() >= 0 && theMove.getDestX() <= 7  ) //check if destination is on board
								{
									if (!oppositePlayer.validateDest(theMove))
									{
										oppositePlayer.deletePiece(oldMove);
										if (moveMaker.equals(player1))
										{
											player1.updatePiece(theMove);
										}
										else
										{
											player2.updatePiece(theMove);
										}
										
										//todo: check for potential nulti hop
										//formulate next move
										theMove.setOrigX(theMove.getDestX());
										theMove.setOrigY(theMove.getDestY());
										theMove.setDestY(theMove.getDestY()+1);
										if (wentRight)
										{
											theMove.setDestX(theMove.getDestX()-1);
										}
										else
										{
											theMove.setDestX(theMove.getDestX()+1);
										}
										if (oppositePlayer.validateDest(theMove))
										{
											makeMove(moveMaker,theMove,true);
										}
									}
								}
								
							}
							else
							{
								if (moveMaker.equals(player1))
								{
									player1.updatePiece(theMove);
								}
								else
								{
									player2.updatePiece(theMove);
								}
							}
							
						}
						else if(!isHopping)
						{
							System.out.println("Your piece already occupies destination");
														
						}
					}
					else if(!isHopping)
					{
						System.out.println("Move is out of bounds");
						return false;
					}
				}
				else if(!isHopping)
				{
					System.out.println("Move is of invalid x distance");
					return false;
				}
			}
			else if(!isHopping)
			{
				System.out.println("Move is of invalid y distance");
				return false;
			}
		}
		else if(!isHopping)
		{
			System.out.println("Source is not a piece in your inventory");
			return false;
		}
		return true;
		
	}
		
}

