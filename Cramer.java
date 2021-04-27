public class Cramer {

	private double valores[][];
	private double n, sX=0, sY=0, sXY=0, sXa2=0, det, detB1, detB0;
	private double matrizA[][] = new double[2][2], matrizResultados[] = new double[2];
	
	public Cramer(double valores[][]) {
		this.valores = valores;
		this.n = valores.length;
		this.setSumaX();
		this.setSumaY();
		this.setSumaXY();
		this.setSumaXCuadrado();
		matrizA[0][0] = n;
		matrizA[0][1] = sX;
		matrizA[1][0] = sX;
		matrizA[1][1] = sXa2;
		matrizA[0][0] = n;
		matrizA[0][1] = sX;
		matrizA[1][0] = sX;
		matrizA[1][1] = sXa2;
		matrizResultados[0] = sY;
		matrizResultados[1] = sXY;
		this.setDeterminante();
        this.setDB0();
        this.setDB1();
	}
	
	public void setN(double n) {
		this.n = n;
	}
	
	public double getN() {
		return n;
	}
	
	public void setSumaX() {
		sX = 0;
		for (int i = 0; i < n; i++) {
			sX += valores[i][0];
		}
	}
	
	public double getSumaX() {
		return sX;
	}
	
	public void setSumaY() {
		sY = 0;
		for (int i = 0; i < n; i++) {
			sY += valores[i][1];
		}
	}
	
	public double getSumaY() {
		return sY;
	}
	
	public void setSumaXY() {
		sXY = 0;
		for (int i = 0; i < valores.length; i++) {
			sXY += valores[i][0] * valores[i][1];
		}
	}
	
	public double getSumaXY() {
		return sXY;
	}
	
	public void setSumaXCuadrado() {
		sXa2 = 0;
		for (int i = 0; i < valores.length; i++) {
			sXa2 += Math.pow(valores[i][0], 2);
		}
	}
	
	public double getSumaXCuadrado() {
		return sXa2;
	}
	
	public void setDeterminante() {
		det = (matrizA[0][0] * matrizA[1][1]) - (matrizA[1][0]*matrizA[0][1]);
	}
	
	public double getDeterminante() {
		return det;
	}
	
	public void setDB1() {
		detB1 = (matrizA[0][0]*matrizResultados[1])-(matrizA[1][0]*matrizResultados[0]); 
	}
	
	public double getDB1() {
		return detB1;
	}
	
	public void setDB0() {
		detB0 = (matrizResultados[0]*matrizA[1][1])-(matrizResultados[1]*matrizA[0][1]); 
	}
	
	public double getDB0() {
		return detB0;
	}
}
