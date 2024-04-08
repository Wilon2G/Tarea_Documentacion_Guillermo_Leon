package main;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import utilidades.StdDraw;

/**
 * Esta clase contiene el codigo principal de la aplicacion, al ejecutarla debera aparecer una ventana con la fecha y hora actual.
 * @author Wilon
 * @version "20.0.1"
 * @since 03/04/2024
 * 
 */

public class RelojDigital {
	
	/**
	 * El main contiene el codigo para ejecutar el programa, creara una ventana de 100x100 con la fecha y hora actual, también dispondra de un boton que sirve para cambiar el color de fondo del reloj.
	 * @see <a href="https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html">Click aqui para mas info de la clase StdDraw</a>
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/awt/Color.html">Click aqui para mas info de la clase Color</a>
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Random.html">Click aqui para mas info de la clase Random</a>
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html">Click aqui para mas info de la clase SimpleDateFormat</a>
	 * @see <a href="https://docs.oracle.com/javase%2F7%2Fdocs%2Fapi%2F%2F/java/awt/Font.html">Click aqui para mas info de la clase Font</a>
	 * @see <a href="https://docs.oracle.com/javase/8/docs/api/java/util/Date.html">Click aqui para mas info de la clase Date</a>
	 */
	public static void main(String[] args) {
		

		StdDraw.setXscale(-100, 100);
		StdDraw.setYscale(-100, 100);
		
		Color c= new Color(0);
		c=Color.LIGHT_GRAY;
		
		Random r= new Random();
		
		
		SimpleDateFormat sdf= new SimpleDateFormat("EEEE  dd' de 'MMMM' de 'yyyy");
		SimpleDateFormat sdf2= new SimpleDateFormat("HH:mm:ss");
		Font f=new Font("Arial",0,30);
		StdDraw.setFont(f);
		StdDraw.enableDoubleBuffering();
		do {
			Date fecha= new Date();
			StdDraw.clear(c);
			StdDraw.setPenColor(Color.black);
			StdDraw.text(0, 15, sdf.format(fecha));
			StdDraw.setPenColor(Color.red);
			StdDraw.text(0, -10, sdf2.format(fecha));
			StdDraw.text(0, -35, "Cambiar color");
			StdDraw.rectangle(0, -35, 50, 10);
			if (cambioColor()) {
				int n=r.nextInt(0,4);
				c=cambiarColor(n);
			}
			
			
			StdDraw.show();
		} while (true);
		
		
	}

	
	/**
	 * Este metodo recibe un numero enterop comprendido entre el 0 y el 3 y devuelve un color dependiendo del valor que se le pase.
	 * @param n Es el entero que determina el color que devueleve el metodo.
	 * @return 0--> azul  1--> verde  2--> naranja  3-->  gris claro
	 * @throws IllegalArgumentException si se le pasa un valor que no este entre el 0 y el 3 (ambos incluidos).
	 */
	private static Color cambiarColor(int n) {
		if (n<0||n>3) {
			throw new IllegalArgumentException("Error, el número debe estar comprendido entre 0 y 3");
		}
		Color c2=new Color(0);
		switch (n) {
		case 0:
			c2=Color.blue;
			break;
		case 1:
			c2= Color.green;
			break;
		case 2:
			c2= Color.orange;
			break;
		case 3:
			c2=Color.LIGHT_GRAY;
			break;

		default:
			break;
		}		
		return c2;
	}


	/**
	 * Este metodo detecta cuando ha ocurrido un click en una region determinada y devuelve un booleano.
	 * @return true o false dependiendo de si se hace click en la region.
	 */
	private static boolean cambioColor() {
		return StdDraw.isMousePressed()&&StdDraw.mouseX()>-50&&StdDraw.mouseX()<50&&StdDraw.mouseY()<-25&&StdDraw.mouseY()>-45;
	}
	
	

}
