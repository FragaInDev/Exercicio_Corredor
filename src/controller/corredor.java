package controller;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class corredor extends Thread {
	private Semaphore semaforo;
	private int corredores;
	int disCorredor;
	int disPercorrida = 0;
	
	public corredor(int _corredores, int _disCorredor, Semaphore smf) {
		this.corredores = _corredores;
		this.disCorredor = _disCorredor;
		semaforo = smf;
	}
	
	@Override
	public void run() {
		while (disPercorrida < disCorredor) {
			pCorre();
		}
		try {
			int abrePorta = new Random().nextInt(2000)+1000;
			sleep(abrePorta);
			semaforo.acquire();
			System.out.println("A pessoa do corredor "+corredores+ " cruzou a porta.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
		
	}
	
	public void pCorre() { //pessoa correndo
		int vCorrida = new Random().nextInt(6) + 4; //velocidade aleatória de 4 a 6 m/s
		disPercorrida += vCorrida;
		
		if (disPercorrida > disCorredor) {
			disPercorrida = disCorredor;
		}
		
		System.out.println("A pessoa do corredor "+ corredores + " está correndo em uma velocidade de " + vCorrida + " m/s...");
	}
	
}
