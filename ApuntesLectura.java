package DAM1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class ApuntesLectura {

	public static void main(String[] args) {
//EL METODO 1 Y 2  SON SIMILARES, SOLO CAMBIAN ALGUNAS LINEAS PARA LA FUNCIÓN MAS COMPACTA
//EN AMBOS Y EN EL MÉTODO 3 LEEMOS EL FICHERO LINEA A LINEA
		
		//lectura1();
		//lectura2();
		//lectura3();
		//lectura4();
		lectura5();
	
	}
	
	public static void lectura1() {
//TRATAR LAS EXCEPCIONES EN OBLIGATORIO CUANDO SE TRABAJA CON FICHEROS
		try {
//NECESITAMOS DOS OBJETOS. FileReader SIMBOLIZA AL FICHERO.RECIBE COMO ARGUMENTO EL NOMBRE
// O LA RUTA AL MISMO
			FileReader fichero = new FileReader("C:/Users/jhonk/OneDrive/Escritorio/quijote.txt");
//BufferedReader NOS LO PODEMOS IMAGINAR COMO UN CURSOR QUE APUTNTA AL LUGAR DONDE VAMOS LEYENDO
//COMO SI SEÑALAMOS EN UN LIBRO CON EL DEDO, LA SIGUIENTE LINEA QUE NOS TOCA LEER
//INICIALMENTE APUNTA AL PRINCIPIO DEL FICHERO
			BufferedReader lector = new BufferedReader (fichero);
			String linea;
//USAMOS UN BUCLE PARA LEER DEL FICHERO. COMO AL MENOS TENDREMOS QUE LEER UNA VEZ
//LA ESTRUCTURA DO-WHILE PARECE LA MAS CORRECTA. LUEGO VEREMOS UNA ALTERNATICA
			do {
//ReadLine lee una linea completa del fichero o null cuando hayamos llegado al final
//EL ULTIMO CARACTER, EL SALTO DE LINEA SI EXISTE QUE SIMBOLIZAMOS CON \n SE SUPRIME CUANDO SE LEE
				linea = lector.readLine();
				if(linea != null)
					System.out.println(linea);
//Cuando leamos null es nuestra condición de salida: hemos leido el fichero completo				
			} while (linea != null);
// No olvidemos cerrar al final para no cosumir resursos innecesarios
			lector.close();
// Existe excepciones concretas (FileNotFound, IOException) para la mayoria de problemas que
// pueden haber con un fichero. Si usamos una excepcion generica, podemos ver que ocurre
// exactamente con el metodo getMessage
			
		} catch (Exception e) {
			System.out.println("ERROR AL LEER!! "+e.getMessage());
		}
	}
	
	public static void lectura2() {
//ESTE METODO ES SIMILAR AL ANTERIOR, PERO MAS COMPLETO
		try {
//CREAMOS EN LA MISMA SENTENCIAS LOS DOS OBJETOS QUE NECESITAMOS
			BufferedReader lector = new BufferedReader (new FileReader("C:/Users/jhonk/OneDrive/Escritorio/quijote.txt"));
			String linea;
//LEEMOS LAS LINEAS DEL FICHERO EN LA CONDICIÓN  EL WHILE Y SALIMOS SI LO QUE LEEMOS ES NULL
			while (( linea = lector.readLine()) != null) {
				System.out.println(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.out.println("ERROR!! "+e.getMessage());
		}
	}

	
	public static void lectura3() {
		try {
//EN ESTE METODO VAMOS A USAR LA CLASE Scanner QUE YA CONOCEMOS DE CUANDO LEÍAMOS DEL TECLADO
//LA CLASE File simboliza al fichero y Scanner será nuestro recurso
			File fichero = new File("C:/Users/jhonk/OneDrive/Escritorio/quijote.txt");
			Scanner teclado = new Scanner(fichero);
//COMO CONDICON DE SALIDA USAMOS HASNEXTLINE QUE NOS DEVUELVE FALSE CUANDO LLEGAMOS AL FINAL DEL FICHERO
//Y YA NO HAY MÁS LINEAS PARA LEER Y TRUE MIENTRAS QUE ESTO NO OCURRA
			while (teclado.hasNextLine()) {
//nextLine lee el fichero  una línea completa, hasta que encuentre un salto de línea
//  Al igual que en el caso anterior, tambien suprime los caracteres \n
				String linea = teclado.nextLine();
				System.out.println(linea);
			}
			teclado.close();
		} catch (Exception e) {
			System.out.println("ERROR!! "+e.getMessage());
		}
	}
	
	
	public static void lectura4() {
// En este metodo leeremos el fichero de una vez y lo que guardemos en un ArrayList donde cada elemento
// es una linea del fichero. Necesitamos el objeto Path QUE SIMBOLIZA LA RUTA AL FICHERO
// Path no necesita ir dentro de la excepcion
		Path ruta = Path.of("C:/Users/jhonk/OneDrive/Escritorio/quijote.txt");
		ArrayList <String> lineas = null;
		
		try {
//El metodo readAllLines lee el fichero completamente y luego lo cierra y almacena el contenido en un list
//Como nosotros no hemos usado el objeto list ( y el ArrayList que si conocemos es compatible y mas potente)
// Usamo cast
			lineas = (ArrayList <String>)Files.readAllLines(ruta);
// No obstante, si quiere usar List sera Asi:
			// List<String> lineas = files.readAllLines(ruta);
		} catch (Exception e) {
			System.out.println("ERROR AL LEER!! : " + e.getMessage());
		}
// PARA procesar el contenido, trabajamos con el ArrayList
// Tambien ha suprimido por nosotros los saltos de linea finales de cada linea
		for (String linea : lineas) {
			System.out.println(linea);
		}
	}
	
	public static void lectura5() {
//EL ULTIMO lee todo el contenido del fichero como  un único string 
		Path ruta = Path.of("C:/Users/jhonk/OneDrive/Escritorio/quijote.txt");
		String contenido = null;
		try {
// Leemos todo el contenido de una vez en un string
// cuidado que aqui los saltos de linea siguen existiendo. Si nuestro fichero tuviera dos lienas asi
// uno
// dos
// contenido seria así: "uno\dos"
// EL \n simboliza el salto de linea y ocupa un solo caracter y no dos
			contenido = Files.readString(ruta);
			
		} catch (Exception e) {
			System.out.println("ERROR AL LEER" + e.getMessage());
		}
		System.out.println(contenido);
	}
}
