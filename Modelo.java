
public class Modelo {

	private Cramer datos;
	private double b0,b1, x, y;
	
	
	public Modelo(double[][] matriz) {
		datos = new Cramer(matriz);
		setB1(datos.getDB1(),datos.getDeterminante());
		setB0(datos.getSumaY(),datos.getSumaX(),datos.getN());
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public double getX() {
		return this.x;
	}
	
	public void setB1(double db1, double det) {
		this.b1 = db1/det;
	}
	
	public double getB1() {
		return this.b1;
	}
	
	public void setB0(double sumY, double sumX, double n) {
		this.b0 = (sumY/n) - this.b1*(sumX/n);
	}
	
	public double getB0() {
		return this.b0;
	}
	
	public void calcularY() {

		y = this.b0 + (this.b1*this.getX());
	}
	
	public double getY() {
		return this.y;
	}

	public String toString() {
		return "y = ("+this.b0+") + ("+this.b1+")("+this.x+")";
	}
}
