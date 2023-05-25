package ex1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("deprecation")
public class Vue extends JFrame implements Observer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Modele m;
	private JLabel[][] tabG;
	private JLabel nb = new JLabel();

	
	
	private BufferedImage image;
	
	{
		try {
			image = ImageIO.read(new File("terre.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}
	
	BufferedImage terre = image; // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icone = new ImageIcon(terre.getScaledInstance(200, 200,java.awt.Image.SCALE_SMOOTH)); 
	

	{
		try {
			image = ImageIO.read(new File("data.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}

	BufferedImage salade = image.getSubimage(0, 0, 150, 150); // image du légume le légume (x, y : coin supérieur gauche, w, h : largeur et hauteur)

	ImageIcon icone2 = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	


	
	
	public Vue(Modele m) {
		this.m = m;
		tabG = new JLabel[m.getSize()][m.getSize()];
		setTitle("Potager");
		setSize(700, 700);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setVisible(true);
		
		JPanel panelPrincipal = new JPanel();
		this.add(panelPrincipal);
		panelPrincipal.setLayout(new BorderLayout());
		
		JPanel panelMenu = new JPanel();
		panelMenu.setSize(400,700);
		JButton vid = new JButton("Tout récolter");
		panelMenu.add(vid);
		vid.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.vider();
			}
		});
		
		nb.setForeground(Color.BLUE);
		nb.setText("Hello world!");
		panelMenu.add(nb);
		
		panelMenu.setBackground(Color.black);
		panelMenu.setVisible(true);
		panelPrincipal.add(panelMenu, BorderLayout.EAST);
		panelPrincipal.setBackground(Color.blue);
		panelPrincipal.setVisible(true);
		
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(m.getSize(),m.getSize()));
		
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
		

		JLabel a;
		
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				a = new JLabel(icone, JLabel.CENTER);
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
		nb.setText(((Integer)(m.getNb())).toString());
		
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				if(m.getTab()[i][j].hasLegume()) {
					
					icone2 = new ImageIcon(salade.getScaledInstance(Math.min(100,m.getTab()[i][j].getLegume().getTmp()*2+1), Math.min(100,m.getTab()[i][j].getLegume().getTmp()*2+1),java.awt.Image.SCALE_SMOOTH)); 
					tabG[i][j].setIcon(icone2);
				}
				
				else {
					tabG[i][j].setIcon(icone);

				}
			}
		}
	}
}
