package primenumber;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Worker extends Thread {

	private Socket s;
	
	public Worker(Socket s) {
		this.s = s;
	}
	
	@Override
	public void run() {
		try {
			String msg = "O n�mero n�o � primo";
            Scanner entrada = new Scanner(s.getInputStream());
            PrintWriter saida = new PrintWriter(s.getOutputStream(), true);            
            int value = entrada.nextInt();
            int count = 0;
            for(int i = 1; i <= value; i++) {
            	if(value % i == 0) {
            		count++;
            	}
            }
            
            if(count == 2) {
            	msg = "N�mero � primo";
            }
            
            msg = msg + " - Endere�o:" + s.getInetAddress().getHostAddress() + " - Porta:" + s.getLocalPort();
            
            saida.println(msg);
            
	        entrada.close();
	        saida.close();
	        s.close();	
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
