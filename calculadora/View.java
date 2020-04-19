package swing1.calculadora;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class View extends JFrame implements ActionListener,ObserverCalculator{
	
	Controller control;
	private JButton plus;
	private JButton minus;
	private JButton product;
	private JButton division;
	private JTextField oper1;
	private JTextField oper2;
	private JTextField result;
	
	public View(Controller c) {
		super("Calculadora Simple");
		this.control = c;
		this.control.addObserver(this);
		initGUI();
	}
	
	public void initGUI() {
		this.setLayout(null);
		this.setBounds(100,100,285,210);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		plus = createButton("+",20,75,50,30);
		plus.addActionListener(this);
		minus = createButton("-",80,75,50,30);
		minus.addActionListener(this);
		product = createButton("*",140,75,50,30);
		product.addActionListener(this);
		division = createButton("/",200,75,50,30);
		division.addActionListener(this);
		oper1 = createText(20,20,110,30);
		oper2 = createText(140,20,110,30);
		result = createText(20,115,230,30);
		result.setEditable(false);
			
		this.add(plus);
		this.add(minus);
		this.add(product);
		this.add(division);
		this.add(oper1);
		this.add(oper2);
		this.add(result);
		
		this.setVisible(true);
	}

	public JButton createButton(String caption,int x, int y, int width, int height) {
		JButton b = new JButton(caption);
		b.setBounds(x, y, width, height);
		return b;
	}
	
	public JTextField createText(int x, int y, int width, int height) {
		JTextField t = new JTextField();
		t.setBounds(x, y, width, height);
		return t;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equalsIgnoreCase("+"))
			this.control.plus(Integer.parseInt(this.oper1.getText()), Integer.parseInt(this.oper2.getText()));
		else if(e.getActionCommand().equalsIgnoreCase("-"))
			this.control.minus(Integer.parseInt(this.oper1.getText()), Integer.parseInt(this.oper2.getText()));
		else if(e.getActionCommand().equalsIgnoreCase("*"))
			this.control.product(Integer.parseInt(this.oper1.getText()), Integer.parseInt(this.oper2.getText()));
		else if(e.getActionCommand().equalsIgnoreCase("/"))
			this.control.division(Integer.parseInt(this.oper1.getText()), Integer.parseInt(this.oper2.getText()));
	}

	@Override
	public void update(float result) {
		this.result.setText(Float.toString(result));	
	}

}
