package AprenderPracticar;

public class practicas1 {

	public static void main(String[] args){
//  VARIABLES: Es un contendor donde se almacenará valores enteros
// númros decimales, caracteres, cadenas de caracteres (palabra o frase)
// IMPORTANTE se escribe formato lowerCamelCase: ejemplo: precioTotal
		
//VARIABLES ENTERAS
		int x= 2;
		int y= 9; 
		int suma= x + y;
		
		System.out.println("La suma es "+ suma);
		
		int multi= x * y;
		System.out.println("La multiplicación es " + multi);


// VARIABLES DECIMALES
		
		double a= 8;
		double b= 25.01;
		
		System.out.println("Valor de a "+ a);		
		
		System.out.println("Valor de b "+ b);
		
// CADENA DE CARACTERES 
		String miPalabra= "Cerveza";
		String miFrase="¿Dónde esta mi cerveza?";
		
		System.out.println("Una palabra que uso con frecuencia: "+ miPalabra);
		System.out.println("Una frase que us a veces "+ miFrase);
// Conversion de tipos (Casting)
		int d= 5;
		int f= 4;
		double division; //almacenamos posible decimal al operar
		
		division= (double)f / (double)d;
		// division = f / d 
		System.out.println("El resultado de la división es: "+division);
		
		
	}
}