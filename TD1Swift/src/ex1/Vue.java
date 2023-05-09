package ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("deprecation")
public class Vue extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Modèle m;
	private JPanel[][] tabG;
	
	public Vue(Modèle m) {
		this.m = m;
		tabG = new JPanel[m.getSize()][m.getSize()];
		setTitle("Potager");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		JPanel panelPrincipal = new JPanel();
		this.add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout());
		
		JPanel panelMenu = new JPanel();
		panelMenu.setSize(100,700);
		panelMenu.setBackground(Color.black);
		panelMenu.setVisible(true);
		//panelPrincipal.add(panelMenu, BorderLayout.EAST);
		panelPrincipal.setBackground(Color.blue);
		panelPrincipal.setVisible(true);
		
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(m.getSize(),m.getSize()));
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
		JPanel a;
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				a = new JPanel();
				a.setBackground(Color.WHITE);
				a.setBorder(BorderFactory.createLineBorder(Color.black));
				panelCentral.add(a);
				final int fi = i;
				final int fj = j;
				tabG[i][j] = a;
				tabG[i][j].addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						m.maj(fi, fj);
					}
				});
			}
		}
		
		
		
		
		panelCentral.setVisible(true);
		
		
			
	}

	@Override
	public void update(Observable o, Object arg) {
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				if(m.getTab()[i][j]) {
					tabG[i][j].setBackground(Color.RED);
				}
				else {
					tabG[i][j].setBackground(Color.WHITE);
				}
			}
		}
	}
}
