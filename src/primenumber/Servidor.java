package primenumber;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(40000);
		while(true) {
			System.out.println("Aguardando cliente...");
			Socket cliente = server.accept();
			Worker worker = new Worker(cliente);
			worker.start();
		}
	}
}
