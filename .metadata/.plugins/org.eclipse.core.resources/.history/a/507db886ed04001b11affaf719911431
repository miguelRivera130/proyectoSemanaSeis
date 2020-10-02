import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

import com.google.gson.Gson;

import model.Cuenta;
import processing.core.PApplet;

public class TCPSingleton extends Thread {

	private static TCPSingleton instance;

	private TCPSingleton() {
	}

	public static TCPSingleton getInstance() {

		if (instance == null) {
			instance = new TCPSingleton();
		}
		return instance;

	}

	// declaraciones
	private BufferedWriter writer;
	private Socket socket;
	private Server observer;
	private Boolean activador;

	// ActivadorDeSuscripcion
	public void setServer(Server observer) {
		this.observer = observer;
	}

	public void run() {
		try {
			
			//ApartadoDeConeción
			System.out.println("esperando coneccion");
			ServerSocket server = new ServerSocket(5000);
			socket = server.accept();
			System.out.println("cliente conectado");
			setActivador(true);
			
			
			//ApartadoDeDeclaracion
			InputStream is = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			writer = new BufferedWriter(new OutputStreamWriter(out));
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			//ApartadoParaRecepcionDeDAtos
			while(getActivador()){
				System.out.println("esperando datos");
				String dato = reader.readLine();
				System.out.println("datos:" + " " + dato);
				
				Gson gson = new Gson();
				Cuenta[] objs = gson.fromJson(dato, Cuenta[].class);
				
				for (int i = 0; i < objs.length; i++) {
					
					observer.messageArrival(dato);
					
				}
				
			}
		} catch(UnknownHostException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Boolean getActivador() {
		return activador;
	}

	public void setActivador(Boolean activador) {
		this.activador = activador;
	}

}
