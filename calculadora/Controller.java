package swing1.calculadora;

public class Controller {

	private Model model;
	
	public Controller(Model m) {
		this.model = m;
	}
	
	public void plus(int n1, int n2) {
		this.model.plus(n1, n2);
	}
	
	public void minus(int n1, int n2) {
		this.model.minus(n1, n2);
	}
	
	public void product(int n1, int n2) {
		this.model.product(n1, n2);
	}
	
	public void division(int n1, int n2) {
		this.model.division(n1, n2);
	}
	
	public void addObserver(ObserverCalculator o) {
		this.model.addObserver(o);
	}
	
	public void deleteObserver(ObserverCalculator o) {
		this.model.addObserver(o);
	}
}
