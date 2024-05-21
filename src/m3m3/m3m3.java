package m3m3;

import java.util.*;

class Point {
	int x;
	int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class m3m3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int[][] maze = new int[n][n];
		int[][] visited = new int[n][n];

		String[] smaze = new String[n];

		for (int i = 0; i < n; i++) {
			smaze[i] = sc.next();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (smaze[i].charAt(j) == '#')
					maze[i][j] = 0;
				else if (smaze[i].charAt(j) == '.')
					maze[i][j] = 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(maze[i][j]);
				if (j == n - 1)
					System.out.println("");
			}
		}

		Queue<Point> q = new LinkedList<Point>();
		Stack<Point> s = new Stack<Point>();
		q.add(new Point(1, 1));
		visited[1][1] = 1;
		int destX = n - 2;
		int destY = n - 2;
		boolean done = false;

		while (!q.isEmpty()) {
			Point p = q.poll();
			s.add(p);
			if (maze[p.x][p.y + 1] == 1 && p.y + 1 > 0 && visited[p.x][p.y + 1] != 1) {
				q.add(new Point(p.x, p.y + 1));
				// s.add(new Point(p.x,p.y+1));
				visited[p.x][p.y + 1]++;

				if (p.x == destX && p.y + 1 == destY) {
					done = true;
					break;
				}

			}
			if (maze[p.x][p.y - 1] == 1 && p.y - 1 > 0 && visited[p.x][p.y - 1] != 1) {
				q.add(new Point(p.x, p.y - 1));
				// s.add(new Point(p.x,p.y-1));
				visited[p.x][p.y - 1]++;

				if (p.x == destX && p.y - 1 == destY) {
					done = true;
					break;
				}
			}
			if (maze[p.x - 1][p.y] == 1 && p.x - 1 > 0 && visited[p.x - 1][p.y] != 1) {
				q.add(new Point(p.x - 1, p.y));
				// s.add(new Point(p.x-1,p.y));
				visited[p.x - 1][p.y]++;

				if (p.x - 1 == destX && p.y == destY) {
					done = true;
					break;
				}
			}
			if (maze[p.x + 1][p.y] == 1 && p.x + 1 > 0 && visited[p.x + 1][p.y] != 1) {
				q.add(new Point(p.x + 1, p.y));
				// s.add(new Point(p.x+1,p.y));
				visited[p.x + 1][p.y]++;

				if (p.x + 1 == destX && p.y == destY) {
					done = true;
					break;
				}

			}

		}
		
		if(!done) {
			System.out.println("error");
			System.exit(0);
		}
		

		int length = 1;

		Point route = s.pop();
		System.out.println("x =" + route.x + " y =" + route.y);
		
		
			
		
		while (!s.isEmpty()) {
			Point route1 = s.pop();
			if ((route1.x == route.x && route1.y + 1 == route.y) || (route1.x == route.x && route1.y - 1 == route.y)
					|| (route1.y == route.y && route1.x - 1 == route.x)
					|| (route1.y == route.y && route1.x + 1 == route.x)) {
				System.out.println("x =" + route1.x + " y =" + route1.y);
				System.out.println(maze[route1.x][route1.y]);
				length++;
				route = route1;

			}
		}
		System.out.println(length + 1);
	}

}
