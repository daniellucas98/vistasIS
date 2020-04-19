package view.productos;

import java.awt.BorderLayout;
import java.awt.CardLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import view.CardSwitcher;
import view.ModuloMenu;
import view.ModuloPanel;
import view.clientes.AltaCliente;
import view.personal.AltaEmpleado;
import view.ventas.ListarVentas;

public class ProductosPanel extends JPanel {
	public ProductosPanel() {
		initGUI();
	}
	private ModuloMenu productosMenu;
	private ModuloPanel productosPanel;
	
	private void initGUI() {
		setLayout(new BorderLayout());
		
		CardLayout cardLayout = new CardLayout();
		productosPanel = new ModuloPanel(cardLayout);
		CardSwitcher switcher = new CardSwitcher(productosPanel, cardLayout);
		productosMenu = new ModuloMenu(switcher, 45);
		
		addFuncion(new AltaEmpleado(), new JButton("   Alta producto"), "Productos/altaproducto", "AltaProducto");
		addFuncion(new ListarVentas(), new JButton("   Baja producto"), "Productos/bajaproducto", "BajaProducto");
		addFuncion(new AltaCliente(), new JButton("Modificar producto"), "Productos/modproducto", "ModificarProducto");
		addFuncion(new AltaCliente(), new JButton("Mostrar producto"), "Productos/mostrarproducto", "MostrarProducto");
		addFuncion(new AltaCliente(), new JButton("Listar productos"), "Productos/listarproducto", "ListarProductos");
		addFuncion(new AltaCliente(), new JButton("Buscar productos"), "Productos/buscarproducto", "BuscarProductos");
		
		
		add(productosPanel, BorderLayout.CENTER);
		add(productosMenu, BorderLayout.NORTH);
		
	}
	
	private void addFuncion(JPanel panel, JButton button, String dirIcon, String card) {
		productosPanel.addPanel(panel, card);
		productosMenu.addButton(button, dirIcon, card);
	}
}