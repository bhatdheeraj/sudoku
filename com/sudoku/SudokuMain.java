package com.sudoku;

import java.util.Scanner; //for input

public class SudokuMain {

	public static void main(String[] args) {

		Sudoku sudoku = new Sudoku();

		Scanner sc = new Scanner(System.in);
		int totalKnownValues; // total number of known values to be inserted

		int row; // row of known value
		int col; // column of known value
		int knownValue; // known value

		// input of known values for soduku puzzle
		System.out.print("Enter the number of known values : ");
		totalKnownValues = sc.nextInt();

		System.out.println("\nEnter the known values : \n\n");
		for (int initLoop = 0; initLoop < totalKnownValues; initLoop++) {
			row = sc.nextInt(); // input row
			col = sc.nextInt(); // input column
			knownValue = sc.nextInt(); // input known value

			if (!sudoku.insertPuzzle(row, col, knownValue)) // check for
															// validity of input
															// values
				initLoop--;
		}

		System.out.println("Initial puzzle : \n");
		sudoku.displayPuzzle(); // display initial puzzle
		System.out.println("\n\n");
		boolean solved = sudoku.sudokuSolver(0, 0, sudoku.puzzle); // solve the
																	// puzzle

		// solved=true for successful solution
		// solve=false for unsuccessful solution
		// display result if solved=true
		if (solved) {

			System.out.println("Solution : \n");
			sudoku.displayPuzzle();
		} else
			System.out.println("The puzzle could not be solved\n");
	}

}
