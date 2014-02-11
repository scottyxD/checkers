package com.scott;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Scanner;

public class Player {
	private String playerName;
	private Color playerColor;
	public ArrayList<Piece> pieces;
	private Scanner scanIn = new Scanner(System.in);
		
	public String getName()
	{
		return playerName;
	}
	
	Player(Color theColor, String theName) 
	{
		playerColor = theColor;
		playerName = theName;
		pieces = new ArrayList<Piece>();
		for (int i=0;i<12;i++)
		{
			Piece piece = new Piece(this.playerColor);
			pieces.add(piece);
		}		
	}
	public Move makeMove()
	{
		Move move = new Move();
		
		System.out.println(playerName + ", Choose checker row number: ");
		move.setOrigY(scanIn.nextInt());
		System.out.println(playerName + ", Choose checker column number: ");
		move.setOrigX(scanIn.nextInt());
		
		System.out.println(playerName + ", Choose destination row number: ");
		move.setDestY(scanIn.nextInt());
		System.out.println(playerName + ", Choose destination column number: ");
		move.setDestX(scanIn.nextInt());
		
		return move;
	}
	
	public boolean validateSource(Move move)
	{
		for (int i=0;i<pieces.size();i++)
		{
			if (pieces.get(i).getxPos()==move.getOrigX())
			{
				if(pieces.get(i).getyPos() == move.getOrigY())
				{
					return true;
				}
				
			}
		}
		return false;
	}
	
	public boolean validateDest(Move move)
	{
		for (int i=0;i<pieces.size();i++)
		{
			if (pieces.get(i).getxPos() == move.getDestX())
			{
				if (pieces.get(i).getyPos() == move.getDestY())
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean updatePiece(Move move)
	{
		for (int i=0;i<pieces.size();i++)
		{
			if (pieces.get(i).getxPos() == move.getOrigX())
			{
				if (pieces.get(i).getyPos() == move.getOrigY())
				{
					pieces.get(i).setxPos(move.getDestX());
					pieces.get(i).setyPos(move.getDestY());
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean deletePiece(Move move)
	{
		for (int i=0;i<pieces.size();i++)
		{
			if (pieces.get(i).getxPos() == move.getDestX())
			{
				if(pieces.get(i).getyPos() == move.getDestY())
				{
					pieces.remove(i);
					return true;
				}
				
			}
		}
		
		return false;
	}
	
}
	
