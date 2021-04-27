import jade.core.AID;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class RegresionLinealGUI extends JFrame {	
	private RegresionLinealAgent myAgent;
	private JTextField xField;
	
	RegresionLinealGUI(RegresionLinealAgent a) {
		super(a.getLocalName());
		
		myAgent = a;
		
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2, 2));
		p.add(new JLabel("X:"));
		xField = new JTextField(15);
		p.add(xField);
		getContentPane().add(p, BorderLayout.CENTER);
		
		JButton addButton = new JButton("Calcular");
		addButton.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				try {
					Double xValor = Double.parseDouble(xField.getText().trim());
					myAgent.obtenerEcuacion(xValor);
					xField.setText("");
				}
				catch (Exception e) {
					JOptionPane.showMessageDialog(RegresionLinealGUI.this, "Valor  incorrecto"+e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE); 
				}
			}
		} );
		p.add(addButton);
		getContentPane().add(p, BorderLayout.SOUTH);
			
		addWindowListener(new	WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				myAgent.doDelete();
			}
		} );
		
		setResizable(false);
	}
	
	public void showGui() {
		pack();
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int centerX = (int)screenSize.getWidth() / 2;
		int centerY = (int)screenSize.getHeight() / 2;
		setLocation(centerX - getWidth() / 2, centerY - getHeight() / 2);
		super.setVisible(true);
	}	
}
