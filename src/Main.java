
public class Main {

	public static void main(String[] args) {
		
		//Given value for Matrix X amplitude
		double amplitude = 2;
		
		//Given value for Matrix X
		Matrix matrixX = new Matrix(new double[][] {
				{1, 2, 3},
				{2, 3, 4},
				{3, 4, 5}
		});
		
		//Given value for Matrix Y
		Matrix matrixY = new Matrix(new double[][] {
				{2, 2, 2},
				{1, 3, 1},
				{1, 2, 3}
		});
		
		//Calculate Matrix Z
		Matrix matrixZ = matrixX.amplify(amplitude).add(matrixY);
		
		//Print result to console
		System.out.println(matrixZ);		
		
	}
	
}