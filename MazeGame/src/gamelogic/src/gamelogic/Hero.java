package gamelogic;

import java.util.Random;

import gamelogic.Dragon;
import gamelogic.Maze;

public class Hero {
	public int x;
	public int y;
	public char has_sword;
	
	public Hero() {
	}
	
	public Hero(char[][] board) {		
		for (int i = 0; i < board.length; i++) {
			for (int a = 0; a < board.length; a++) {
				if (board[a][i] == 'H') {
					x = i;
					y = a;
				}
			}
		}
		
		this.has_sword = 'H';
	}
	
	
	public Hero(Maze maze) {
		Random rand = new Random(System.currentTimeMillis());
		
		// Get random starting position for hero
		while (true) {
			x = rand.nextInt(maze.board.length - 2);
			y = rand.nextInt(maze.board.length - 2);
			x++;
			y++;
			
			if (maze.board[y][x] == ' ') {
				break;
			}
		}
		
		// Place hero on board
		this.has_sword = 'H';
		maze.board[y][x] = has_sword;
	}
	
	public boolean move(String key, Maze maze) {		
		if (key.equals("w")) {
			if (maze.board[y - 1][x] == ' ' || maze.board[y - 1][x] == 'E') {
				maze.board[y][x] = ' ';
				y --;
				maze.board[y][x] = has_sword;
			
				return true;
			}
		}
		else if (key.equals("a")) {
			if (maze.board[y][x - 1] == ' ' || maze.board[y][x - 1] == 'E') {
				maze.board[y][x] = ' ';
				x --;
				maze.board[y][x] = has_sword;
				
				return true;
			}
		}
		else if (key.equals("d")) {
			if (maze.board[y][x + 1] == ' ' || maze.board[y][x + 1] == 'E') {
				maze.board[y][x] = ' ';
				x ++;
				maze.board[y][x] = has_sword;
				
				return true;
			}
		}
		else if (key.equals("s")) {
			if (maze.board[y + 1][x] == ' ' || maze.board[y + 1][x] == 'E') {
				maze.board[y][x] = ' ';
				y ++;
				maze.board[y][x] = has_sword;
				
				return true;
			}
		}
		
		return false;
	}
	
	public int fightDragon(Dragon dragon) {
		if (dragon.x == x) {
			if (dragon.y == y - 1 || dragon.y == y + 1) {
				if (has_sword == 'H') {
					if (dragon.is_sleeping == 'd')
						return 0; // works as wall

					return 1;
				} else if (has_sword == 'A') {
					return 2;
				}
			}
		}
		if (dragon.y == y) {
			if (dragon.x == x - 1 || dragon.x == x + 1) {
				if (has_sword == 'H') {
					if (dragon.is_sleeping == 'd')
						return 0; // works as wall
					return 1;
				} else if (has_sword == 'A') {
					return 2;
				}
			}
		}

		return 0;
	}
	
	public boolean pickUpSword(Maze.Sword sword, Maze maze) {
		if (sword.x == x && sword.y == y) {
			has_sword = 'A';
			maze.board[y][x] = has_sword;
			maze.sword_exists = false;
			
			return true;
		}
		
		return false;
	}
	
	public Point getHeroPosition()
	{
		return  (new Point(y, x));
	}
}