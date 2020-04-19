package swing1.calculadora;

import java.awt.EventQueue;

import swing1.calculadora.Controller;
import swing1.calculadora.Model;
import swing1.calculadora.View;

public class Main {
	public static void main(String[] args) {
		 Model m = new Model();
		 Controller control = new Controller(m);
		 
		 EventQueue.invokeLater(new Runnable() {
			 public void run() {
			 new View(control); 
		 }});
	}
}
