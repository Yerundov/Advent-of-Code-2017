package day5;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Solution to Day 5 Advent of Code
 *
 */
public class Maze {
	
	private ArrayList<Integer> maze;
	
	public Maze(ArrayList<Integer> maze){
		this.maze = maze;
	}
	
	public static void main(String[] args) {
		ArrayList<Integer> maze = new ArrayList<Integer>();
		Scanner in = null;
		try {
			in = new Scanner(new FileReader("maze.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(in.hasNextInt()){
			maze.add(in.nextInt());
		}
		in.close();
		Maze main = new Maze(maze);
		main.run();
	}
	
	public void run(){
		System.out.println("Part One:\t" + countStepsPOne());
		System.out.println("Part Two:\t" + countStepsPTwo());
	}
	
	private int countStepsPOne(){
		ArrayList<Integer> tmpMaze = (ArrayList<Integer>) maze.clone();
		int index = 0;
		int count = 0;
		while(index >= 0 && index < tmpMaze.size()){
			int tmpJmp = tmpMaze.get(index);
			tmpMaze.set(index, tmpJmp + 1);
			index += tmpJmp;
			count++;
		}
		return count;
	}
	
	private int countStepsPTwo(){
		ArrayList<Integer> tmpMaze = (ArrayList<Integer>) maze.clone();
		int index = 0;
		int count = 0;
		while(index >= 0 && index < tmpMaze.size()){
			int tmpJmp = tmpMaze.get(index);
			tmpMaze.set(index, tmpJmp >= 3 ? tmpJmp - 1 : tmpJmp + 1);
			index += tmpJmp;
			count++;
		}
		return count;
	}
	
}
