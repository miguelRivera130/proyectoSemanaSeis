package com.example.appcliente;

import android.widget.Button;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

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
	private String dato = "0,0";
	private MainActivity observer;
	private Boolean activar = false;

	// ActivadorDeSuscripcion
	public void setCliente(MainActivity observer) {
		this.observer = observer;
	}

	public void run() {
		try {
			
			//ApartadoDeConecion
			System.out.println("esperando coneccion");
			socket = new Socket("192.168.1.68",5000);
			System.out.println("coneccion con el sever aceptada");
			activar = true;
			
			
			//ApartadoDeDeclaracion
			InputStream is = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			
			writer = new BufferedWriter(new OutputStreamWriter(out));
			BufferedReader reader = new BufferedReader(new InputStreamReader(is));
			
			//ApartadoParaRecepcionDeDAtos
			while(activar){
				System.out.println("esperando datos");
				String dato = reader.readLine();
				observer.messageArrival(dato);
				
			}
		} catch(UnknownHostException e) {
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void envioDeDatos(String dato) {

		new Thread(

				()->{
					try {

						writer.write(dato + "\n");
						writer.flush();

					} catch (IOException e) {
						e.printStackTrace();
					}
				}

		).start();

	}
}
