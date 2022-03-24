package view;

import java.util.concurrent.Semaphore;

import controller.corredor;

public class Main {

	public static void main(String[] args) {
		int corredores = 4;
		int disCorredor = 200;
		Semaphore semaforo = new Semaphore(1);
		
		for (int i = 0; i < corredores; i++) {
			new corredor(i, disCorredor, semaforo ).start();
		}
	}

}
