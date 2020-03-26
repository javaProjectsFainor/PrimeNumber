package primenumber;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
	public static void main(String[] args) throws IOException {
		while(true) {
			int number = 0;
			String message = "";
	        Scanner teclado = new Scanner(System.in);
	        InetAddress end = InetAddress.getLocalHost();
	        Socket s = new Socket(end, 40000);
	        
	        Scanner entrada = new Scanner(s.getInputStream());
	        PrintWriter saida = new PrintWriter(s.getOutputStream(), true);
	        
	        System.out.println("Digite um número inteiro:");
	        number = teclado.nextInt();
	        saida.println(number);
	        message = entrada.nextLine();
	        System.out.println(message);
	        
	        entrada.close();
	        saida.close();
	        s.close();	
		}
	}
}
