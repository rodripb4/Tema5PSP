package Ejercicio5;


import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Provider;

public class Ejercicio5 {

	public static void main(String[] args) {
    MessageDigest md;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
			
			//Importar libreria propia 
			String texto = "Esto es un texto plano.";
			String clave= "clave de cifrado";
			byte dataBytes[] = texto.getBytes();//Texto a bytes
			md.update(dataBytes);//SE INTRODUCE TEXTO A BYTES A RESUMIR
			byte resumen[] = md.digest(clave.getBytes());//SE CALCULA EL RESUMEN
			
			System.out.println("Mensaje original: "+texto);
			System.out.println("Numero de bytes: "+ md.getDigestLength());
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+ new String(resumen));
			System.out.println("Mensaje Hexadecimal: "+ Hexadecimal(resumen));
			Provider proveedor = md.getProvider();
			
			System.out.println("Proveedor: "+proveedor.toString());
			
			System.out.println("/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////");
			
			
			//String 2
			String texto2= "Esto es otro texto plano.";
			
			byte dataBytes2[] = texto2.getBytes();//Texto a bytes
			md.update(dataBytes2);//SE INTRODUCE TEXTO A BYTES A RESUMIR
			byte resumen2[] = md.digest(clave.getBytes());//SE CALCULA EL RESUMEN
			
			System.out.println("Mensaje original: "+texto2);
			System.out.println("Numero de bytes: "+ md.getDigestLength());
			System.out.println("Algoritmo: "+md.getAlgorithm());
			System.out.println("Mensaje resumen: "+ new String(resumen2));
			System.out.println("Mensaje Hexadecimal: "+ Hexadecimal(resumen2));
			Provider proveedor2 = md.getProvider();
			
			System.out.println("Proveedor: "+proveedor2.toString());
			
			
			
			
		} catch (NoSuchAlgorithmException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	
	static String Hexadecimal(byte[] resumen) {
		String hex="";
		for (int i = 0; i < resumen.length; i++) {
			String h = Integer.toHexString(resumen[i] & 0xFF);
			if(h.length() == 1) hex +="0"; 
			hex += h;
		}
		return hex.toUpperCase();
	}


}
