
//A class representing a square matrix
//(We are assuming that inputs are only NxN arrays)
public class Matrix {

	private double[][] matrix;
	private int size;
		
	//Create a blank matrix with given size
	public Matrix(int s) {
		matrix = new double[s][s];
		size = matrix.length;
	}
	
	//Create a matrix from array values
	public Matrix(double[][] matrix) {
		this.matrix = matrix;
		size = matrix.length;
	}
	
	//--Public methods
	
	//Get a specific matrix value by coordinate
	public double get(int row, int col) { return matrix[row][col]; }
	
	//Set a specific matrix value by coordinate
	public void set(int row, int col, double value) { matrix[row][col] = value; }
	
	//Get a specific array of matrix values by row
	public double[] getRow(int row) {
		double[] result = new double[size];
		for(int i = 0; i < size; i++)
			result[i] = get(row, i);
		return result;
	}
	
	//Get a specific array of matrix values by column
	public double[] getCol(int col) {
		double[] result = new double[size];
		for(int i = 0; i < size; i++)
			result[i] = get(i, col);
		return result;
	}
	
	//Return whether matrix is a null matrix (all values are 0)
	public boolean isNullMatrix() {	return isAllValue(0); }
	
	//Return whether matrix is a unit matrix (all values are 1)
	public boolean isUnitMatrix() { return isAllValue(1); }
	
	//Return sum of two matrices
	public Matrix add(Matrix other) {
		Matrix result = new Matrix(size); //Object to store result in.
		
		//Iterate through each matrix value, adding the contents
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				result.set(i, j, this.get(i, j) + other.get(i, j));
		
		//Return added result.
		return result;
	}
	
	public Matrix amplify(double magnitude) {
		Matrix result = new Matrix(size); //Object to store result in
		
		//Iterate through each matrix value, amplifying value by magnitude
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				result.set(i, j, magnitude * get(i, j));
		
		//Return amplified result.
		return result;
	}
	
	//Return product of two matrices
	// Hey, so, serves me right for not reading the assignment carefully; I implemented this
	// without realizing it's outside the scope of the project. Kept it in for future reference.
	public Matrix multiply(Matrix other) {
		Matrix result = new Matrix(size); //Object to store the result in
		
		//Iterate through each matrix value, determining the dot product of the contents
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				result.set(i, j, this.dotProduct(i, j, other));
		
		//Return multiplied result
		return result;
	}

	//Return the determinant of this Matrix
	public double determinant() {
		double determinant = 0;											 //value to be returned
		switch(size) {
		case 1: 
			determinant = get(0,0);										 //just return matrix value for 1x1 matrix
			break;
		case 2:
			determinant = (get(0,0) * get(1,1)) - (get(0,1) * get(1,0)); //Formula for 2x2 determinant = (ad - bc) 
			break;
		default: 
			for(int i = 0; i < size; i++) {
				int mult = (i % 2 == 0) ? 1 : -1; 											 //(We want to alternate between adding / subtracting the subdeterminants)
				determinant += (mult * this.get(0, i) * this.subMatrix(0, i).determinant()); //Add/subtract the determinant of the submatrix.
			}
		}
		return determinant;
	}
	
	//Return string representation of a Matrix
	public String toString() {
		String result = "";
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++)
				result += get(i, j) + " | ";
			result += "\n";
		}
		return result;
	}
	
	//--Private methods
	
	//Returns a matrix consisting of values not in the given row or column
	//(Used for calculating determinants)
	private Matrix subMatrix(int row, int col) {

		Matrix result = new Matrix(size-1);	//Object to store result in.
		for(int i = 0; i < size; i++)
			for(int j = 0; j < size; j++)
				//If we are not on the excluded row or column, add result to the submatrix
				if(row != i && col != j)
					result.set(i < row ? i : i-1, //Note the ternary operators, so we don't try to add a row/column in the subarray that doesn't exist.
							   j < col ? j : j-1, //So, if we're removing row 1, we want row 0 to be put into row 0 of the submatrix, 
							   get(i, j));		  //but row 2 wants to go into row (2 - 1 = 1) of the submatrix.
		return result;
	}
	
	//Return whether this matrix has all values equal to given value
	//(Used for determining unit matrix or null matrix)
	private boolean isAllValue(double value) {
		//Iterate through each array value, returning false if a value is not equal
		for(int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (this.get(i, j) != value)
					return false;	//Return false if a value is not 0	
		return true;
	}
	
	//Return the dot product for a given row and column between two matrices
	private double dotProduct(int row, int col, Matrix other) {
		double result = 0;						//Object to store result in
		double[] thisRow = getRow(row);			//Use row of this matrix
		double[] thatCol = other.getCol(col);	//And col of other matrix
		for(int i = 0; i < size; i++)
			result += thisRow[i] * thatCol[i];	//Multiply together to get dot product
		return result;
	}
	
}
