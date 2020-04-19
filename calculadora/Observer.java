package swing1.calculadora;

public interface Observer<T> {
	public void addObserver(T o);
	public void deleteObserver(T o);
}
