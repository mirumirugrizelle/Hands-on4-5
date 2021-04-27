public class RegresionLineal {
	public static void main(String[] args) {
		double matriz[][] = {{23,651},{26,762},{30,856},{34,1063},{43,1190},{48,1298},{52,1421},{57,1440},{58,1518}};
		System.out.println("- REGRESION LINEAL SIMPLE -");
		double y;
		Modelo s = new Modelo(matriz);
		for (int i = 0; i < args.length; i++) {
			s.setX(Double.parseDouble(args[i]));
            System.out.println("-- PARA X = "+s.getX());
			s.calcularY();
			y = s.getY();
			System.out.println(s.toString());
			System.out.println("y = "+y);
		}
		System.out.println("- REGRESION LINEAL SIMPLE FIN -");
	}

}