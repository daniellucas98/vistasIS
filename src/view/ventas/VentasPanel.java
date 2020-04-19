package view.ventas;

import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import view.CardSwitcher;
import view.ModuloMenu;
import view.ModuloPanel;
import view.clientes.AltaCliente;

public class VentasPanel extends JPanel {
	public VentasPanel() {
		initGUI();
	}
	private ModuloMenu ventasMenu;
	private ModuloPanel ventasPanel;
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		CardLayout cardLayout = new CardLayout();
		ventasPanel = new ModuloPanel(cardLayout);
		CardSwitcher switcher = new CardSwitcher(ventasPanel, cardLayout);
		ventasMenu = new ModuloMenu(switcher, 30);
		
		addFuncion(new AltaCliente(), new JButton("   Abrir venta"), "Ventas/abrirventa", "AbrirVenta");
		addFuncion(new AltaCliente(), new JButton("   Mostrar venta"), "Ventas/mostrarventa", "MostrarVenta");
		addFuncion(new ListarVentas(), new JButton("   Listar venta"), "Ventas/listarventa", "ListarVentas");
		
		
		add(ventasPanel, BorderLayout.CENTER);
		add(ventasMenu, BorderLayout.NORTH);
		
	}
	
	private void addFuncion(JPanel panel, JButton button, String dirIcon, String card) {
		ventasPanel.addPanel(panel, card);
		ventasMenu.addButton(button, dirIcon, card);
	}
}