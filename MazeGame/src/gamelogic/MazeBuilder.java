package gamelogic;

import java.util.*;


public class MazeBuilder{
	static char[][] maze;
	static int exit_x;
	static int exit_y;
	
	static public char[][] buildMaze(int size) throws IllegalArgumentException{
		Random rnd = new Random();
		maze = new char[size][size];
		
		// fill maze
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				maze[i][j] = 'X';
			}
		}
		
		// choose exit		
		do {
			int exit_border = rnd.nextInt(4);
			switch (exit_border) {
			case 0: // left
				exit_x = 0;
				exit_y = rnd.nextInt(size);
				break;
			case 1: // right
				exit_x = size - 1;
				exit_y = rnd.nextInt(size);
				break;
			case 2: // top
				exit_y = 0;
				exit_x = rnd.nextInt(size);
				break;
			case 3: // bottom
				exit_y = size - 1;
				exit_x = rnd.nextInt(size);
				break;
			}
		} while ((exit_x == 0 || exit_x == size - 1) && (exit_y == 0 || exit_y == size - 1));
		
		maze[exit_y][exit_x] = 'S';
		
		
		
		// Create path
		Stack<Point> path = new Stack<Point>();
		
		// Starting point
		Point start = new Point();
		
		if (exit_x == 0) {
			start.x = 1;
			start.y = exit_y;
		}
		else if (exit_x == size - 1) {
			start.x = size - 2;
			start.y = exit_y;
		}
		else if (exit_y == 0) {
			start.x = exit_x;
			start.y = 1;
		}
		else if (exit_y == size - 1) {
			start.x = exit_x;
			start.y = size - 2;
		}
		
		maze[start.y][start.x] = ' ';
		path.push(start);
	
		
		// Next point
		while (!path.empty()) {
			Point next = chooseNextPos(maze, path.peek());
			
			if (next.x == -1 && next.y == -1) {
				path.pop();
			}
			else {
				
				maze[next.y][next.x] = ' ';
				path.push(next);
			}
		}
		
		
		return maze;
	}
	
	static public Point chooseNextPos(char[][] maze, Point pos) {
		Random rnd = new Random();
		Vector<Point> options = new Vector<Point>();
		options.addElement(new Point(pos.x+1,pos.y));
		options.addElement(new Point(pos.x-1,pos.y));
		options.addElement(new Point(pos.x,pos.y+1));
		options.addElement(new Point(pos.x,pos.y-1));
				
		for (int i = 4; i >= 1; i--) {
			int n = rnd.nextInt(i);
			int x = options.elementAt(n).x;
			int y = options.elementAt(n).y;
			
			// Ignore walls and empty spaces
			if ((maze[y][x] == 'S') || (maze[y][x] == ' ') ||
					(x == 0) || (x == maze[1].length - 1) || 
					(y == 0) || (y == maze.length - 1)) {
				
				options.removeElementAt(n);;	
				continue;
			}
			
			// Impose restrictions (diagonals)
			Point diag1 = new Point();
			Point diag2 = new Point();
			
			// New point on the same vertical
			if (x == pos.x) {
				diag1.x = x+1;
				diag1.y = y+(y-pos.y);
				diag2.x = x-1;
				diag2.y = y+(y-pos.y);
			}
			// New point on the same horizontal
			else if (y == pos.y) {
				diag1.x = x+(x-pos.x);
				diag1.y = y+1;
				diag2.x = x+(x-pos.x);
				diag2.y = y-1;
			}
			
			if (maze[diag1.y][diag1.x] == ' ' || maze[diag2.y][diag2.x] == ' ') { // diagonal is ' ' and adjacent != ' '
				options.removeElementAt(n);;	
				continue;
			}
			
			// Impose restrictions (white 2x2)
			if ((maze[y][x+1] == ' ' && maze[y+1][x+1] == ' ' && maze[y+1][x] == ' ') ||
					(maze[y][x-1] == ' ' && maze[y+1][x-1] == ' ' && maze[y+1][x] == ' ') ||
					(maze[y][x+1] == ' ' && maze[y-1][x+1] == ' ' && maze[y-1][x] == ' ') ||
					(maze[y][x-1] == ' ' && maze[y-1][x-1] == ' ' && maze[y-1][x] == ' ')) {
				
				options.removeElementAt(n);;	
				continue;
			}
			
			return options.elementAt(n);
		}
		
		return new Point(-1,-1);
	}
	
	
}
