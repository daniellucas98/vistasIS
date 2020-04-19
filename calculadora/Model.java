package swing1.calculadora;

import java.util.ArrayList;
import java.util.List;

public class Model implements Observer<ObserverCalculator>{
	
	private List<ObserverCalculator> observers;
	float result;
	
	public Model() {
		this.observers = new ArrayList<>();
		this.result = 0;
	}
	
	public void plus(int n1, int n2) {
		this.result = n1 + n2;
		for(ObserverCalculator o: observers) o.update(result);
	}
	
	public void minus(int n1, int n2) {
		this.result = n1 - n2;
		for(ObserverCalculator o: observers) o.update(result);
	}
	
	public void product(int n1, int n2) {
		this.result = n1*n2;
		for(ObserverCalculator o: observers) o.update(result);
	}
	
	public void division(int n1, int n2) {
		if(n2 == 0) {
			throw new Error("Division by zero");
		}else {
			this.result = n1/n2;
			for(ObserverCalculator o: observers) o.update(result);
		}
	}
	
	@Override
	public void addObserver(ObserverCalculator o) {
		this.observers.add(o);	
	}

	@Override
	public void deleteObserver(ObserverCalculator o) {
		this.observers.remove(o);	
	}

}
