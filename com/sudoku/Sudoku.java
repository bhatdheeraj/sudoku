package com.sudoku;

class Sudoku {
	int puzzle[][]; // array to hold puzzle

	public Sudoku() {
		puzzle = new int[9][9];

		// initialize every cell of puzzle to 0
		for (int initRow = 0; initRow < 9; initRow++)
			for (int initCol = 0; initCol < 9; initCol++)
				puzzle[initRow][initCol] = 0;
		
		//example inputs
		/*
		puzzle[0][0] = 1;
		puzzle[0][1] = 7;
		puzzle[0][2] = 3;
		puzzle[1][2] = 8;
		puzzle[1][5] = 4;
		puzzle[2][3] = 8;
		puzzle[2][4] = 3;
		puzzle[2][8] = 6;
		puzzle[3][1] = 1;
		puzzle[3][4] = 6;
		puzzle[3][5] = 3;
		puzzle[3][6] = 5;
		puzzle[4][2] = 5;
		puzzle[4][6] = 4;
		puzzle[5][2] = 4;
		puzzle[5][3] = 1;
		puzzle[5][4] = 9;
		puzzle[5][7] = 3;
		puzzle[6][0] = 9;
		puzzle[6][4] = 2;
		puzzle[6][5] = 8;
		puzzle[7][3] = 5;
		puzzle[7][6] = 6;
		puzzle[8][6] = 2;
		puzzle[8][7] = 7;
		puzzle[8][8] = 5;
		*/
		
		/*
		puzzle[0][1] = 3; 
		puzzle[0][5] = 6; 
		puzzle[0][6] = 9; 
		puzzle[0][8] = 4; 
		puzzle[1][1] = 1;
		puzzle[1][3] = 5; 
		puzzle[1][4] = 8; 
		puzzle[2][0] = 6; 
		puzzle[2][2] = 8; 
		puzzle[2][5] = 3; 
		puzzle[2][6] = 1;
		puzzle[3][1] = 8; 
		puzzle[3][7] = 2; 
		puzzle[4][0] = 4; 
		puzzle[4][2] = 2; 
		puzzle[4][3] = 1; 
		puzzle[4][3] = 1; 
		puzzle[4][5] = 9; 
		puzzle[4][6] = 8;
		puzzle[4][8] = 3; 
		puzzle[5][1] = 9;
		puzzle[5][7] = 4;
		puzzle[6][2] = 7; 
		puzzle[6][3] = 9; 
		puzzle[6][6] = 6; 
		puzzle[6][8] = 5; 
		puzzle[7][4] = 7; 
		puzzle[7][5] = 5; 
		puzzle[7][7] = 1; 
		puzzle[8][0] = 8; 
		puzzle[8][2] = 3; 
		puzzle[8][3] = 6; 
		puzzle[8][7] = 9;
		*/ 

		/*
		puzzle[0][4] = 9; 
		puzzle[0][7] = 2; 
		puzzle[1][0] = 2; 
		puzzle[1][1] = 7; 
		puzzle[1][7] = 4; 
		puzzle[1][8] = 3; 
		puzzle[2][5] = 1; 
		puzzle[3][0] = 3; 
		puzzle[3][2] = 5; 
		puzzle[3][8] = 7; 
		puzzle[4][3] = 3;
		puzzle[4][5] = 7; 
		puzzle[5][0] = 4; 
		puzzle[5][6] = 5; 
		puzzle[5][8] = 2; 
		puzzle[6][3] = 9; 
		puzzle[7][0] = 5; 
		puzzle[7][1] = 1; 
		puzzle[7][7] = 8; 
		puzzle[7][8] = 6; 
		puzzle[8][1] = 8; 
		puzzle[8][4] = 4;
		*/ 
	}

	/*
	 * function to find the grid in which the given value is present. function
	 * returns the grid number.
	 */
	int getGridNo(int row, int col) {

		int gridNo;

		if (row >= 0 && row <= 2) {

			if (col >= 0 && col <= 2)
				gridNo = 1;
			else if (col >= 3 && col <= 5)
				gridNo = 2;
			else
				gridNo = 3;

		} else if (row >= 3 && row <= 5) {

			if (col >= 0 && col <= 2)
				gridNo = 4;
			else if (col >= 3 && col <= 5)
				gridNo = 5;
			else
				gridNo = 6;

		} else {

			if (col >= 0 && col <= 2)
				gridNo = 7;
			else if (col >= 3 && col <= 5)
				gridNo = 8;
			else
				gridNo = 9;
		}

		return gridNo;
	}

	/*
	 * function to check if the given value collides i.e. if the value is
	 * present already in the current row, column and grid). function returns
	 * true if the value doesn't collide and returns false when it collides.
	 */
	boolean isColliding(int row, int col, int value) {

		int rowI, colJ;
		boolean collide = false;

		// check for the collision in the row and column
		for (rowI = 0; rowI < 9; rowI++)
			if (puzzle[rowI][col] == value || puzzle[row][rowI] == value)
				collide = true;

		int gridNo = getGridNo(row, col);   // holds the grid number which is
											// returned by the findGridNo
											// function

		// check for collision in the grid
		switch (gridNo) {

		case 1:
			for (rowI = 0; rowI <= 2; rowI++)
				for (colJ = 0; colJ <= 2; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 2:
			for (rowI = 0; rowI <= 2; rowI++)
				for (colJ = 3; colJ <= 5; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;
		case 3:
			for (rowI = 0; rowI <= 2; rowI++)
				for (colJ = 6; colJ <= 8; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 4:
			for (rowI = 3; rowI <= 5; rowI++)
				for (colJ = 0; colJ <= 2; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 5:
			for (rowI = 3; rowI <= 5; rowI++)
				for (colJ = 3; colJ <= 5; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 6:
			for (rowI = 3; rowI <= 5; rowI++)
				for (colJ = 6; colJ <= 8; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 7:
			for (rowI = 6; rowI <= 8; rowI++)
				for (colJ = 0; colJ <= 2; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 8:
			for (rowI = 6; rowI <= 8; rowI++)
				for (colJ = 3; colJ <= 5; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		case 9:
			for (rowI = 6; rowI <= 8; rowI++)
				for (colJ = 6; colJ <= 8; colJ++)
					if (puzzle[rowI][colJ] == value)
						collide = true;
			break;

		}

		return collide;
	}

	// function to check the validity of input by the user
	boolean insertPuzzle(int row, int col, int knownValue) {

		boolean validInput = true;
		if (row < 1 || row > 9) {

			System.out.println("The row must be within 1-9\n");
			validInput = false;

		} else if (col < 1 || col > 9) {

			System.out.println("The column must be within 1-9\n");
			validInput = false;

		} else if (knownValue < 1 || knownValue > 9) {

			System.out.println("The known value must be within 1-9\n");
			validInput = false;

		} else if (isColliding(row - 1, col - 1, knownValue)) {

			System.out.println("Cannot Insert value as they are colliding\n");
			validInput = false;

		} else {

			puzzle[row - 1][col - 1] = knownValue; // if the input is valid
													// insert the value in the
													// corresponding cell

			validInput = true;
		}
		return validInput;
	}

	/*
	 * recursive function to solve the sudoku puzzle. the function returns true
	 * to the calling function when the puzzle is solved and false when it isnt.
	 */
	boolean sudokuSolver(int row, int col, int puzzle[][]) {

		// check if the last cell of the puzzle is reached
		if (row == 9) {

			row = 0;
			if (++col == 9)
				return true; // if the end of puzzle is reached return true
		}

		if (puzzle[row][col] != 0) // if the cell already consists of a value
									// then recursively call the function to
									// move to next cell
			return sudokuSolver(row + 1, col, puzzle);
		else {

			for (int value = 1; value <= 9; value++) {

				if (!isColliding(row, col, value)) { // if the value doesnt
														// collide then insert
														// it into the puzzle

					puzzle[row][col] = value;

					if (sudokuSolver(row + 1, col, puzzle)) // recursive call to
															// the function to
															// proceed to next
															// cell
						return true;
				}
			}
			puzzle[row][col] = 0;// if no values fit in the cell, insert 0 in
									// the cell and check the previous cell
									// again
		}

		return false;
	}

	// function to display the puzzle
	void displayPuzzle() {

		for (int row = 0; row < 9; row++) {
			for (int col = 0; col < 9; col++) {

				System.out.print(puzzle[row][col] + "  ");
				if (col == 2 || col == 5)
					System.out.print(" | ");
			}

			if (row == 2 || row == 5)
				System.out.println("\n-------     -------     -------");
			else
				System.out.println("\n");
		}
	}
}