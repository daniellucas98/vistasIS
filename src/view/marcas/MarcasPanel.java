package view.marcas;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.CardSwitcher;
import view.ModuloMenu;
import view.ModuloPanel;
import view.clientes.AltaCliente;
import view.clientes.BajaCliente;
import view.personal.AltaEmpleado;

public class MarcasPanel extends JPanel {
	public MarcasPanel() {
		initGUI();
	}
	private ModuloMenu marcasMenu;
	private ModuloPanel marcasPanel;
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		CardLayout cardLayout = new CardLayout();
		marcasPanel = new ModuloPanel(cardLayout);
		CardSwitcher switcher = new CardSwitcher(marcasPanel, cardLayout);
		marcasMenu = new ModuloMenu(switcher, 45);
		
		addFuncion(new AltaMarca(), new JButton("   Alta marca"), "Marcas/altamarca", "AltaMarca");
		addFuncion(new BajaMarca(), new JButton("   Baja marca"), "Marcas/bajamarca", "BajaMarca");
		addFuncion(new AltaEmpleado(), new JButton("Modificar marca"), "Marcas/modmarca", "ModificarMarca");
		addFuncion(new BajaCliente(), new JButton("  Mostrar marca"), "Marcas/mostrarmarca", "MostrarMarca");
		addFuncion(new BajaCliente(), new JButton("   Listar marca"), "Marcas/listarmarca", "ListarMarcas");
		
		add(marcasPanel, BorderLayout.CENTER);
		add(marcasMenu, BorderLayout.NORTH);
	}
	
	private void addFuncion(JPanel panel, JButton button, String dirIcon, String card) {
		marcasPanel.addPanel(panel, card);
		marcasMenu.addButton(button, dirIcon, card);
	}
}