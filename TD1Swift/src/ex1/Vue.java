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
import java.util.ArrayList;
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
	private JLabel score = new JLabel();
	private JLabel date = new JLabel();
	private JLabel invSal = new JLabel();
	private JLabel invCar = new JLabel();
	private JLabel invTom = new JLabel();
	private ArrayList<BufferedImage> list = new ArrayList<BufferedImage>();
	
	
	
	private BufferedImage image;
	
	{
		try {
			image = ImageIO.read(new File("terre.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}
	
	BufferedImage terre = image; // image du l�gume le l�gume (x, y : coin sup�rieur gauche, w, h : largeur et hauteur)

	ImageIcon icone = new ImageIcon(terre.getScaledInstance(200, 200,java.awt.Image.SCALE_SMOOTH)); 
	

	{
		try {
			image = ImageIO.read(new File("data.png")); // chargement de l'image globale
		}catch(Exception e) {
			e.addSuppressed(e);
		}
	}

	BufferedImage salade = image.getSubimage(0, 0, 150, 150); // image du l�gume le l�gume (x, y : coin sup�rieur gauche, w, h : largeur et hauteur)

	ImageIcon icSal = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	
	
	
	BufferedImage tomate = image.getSubimage(3120 , 1170, 150, 150); // image du l�gume le l�gume (x, y : coin sup�rieur gauche, w, h : largeur et hauteur)

	ImageIcon icTom = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	
	BufferedImage carotte = image.getSubimage(390 , 390 , 150, 150); // image du l�gume le l�gume (x, y : coin sup�rieur gauche, w, h : largeur et hauteur)

	ImageIcon icCar = new ImageIcon(salade.getScaledInstance(100, 100,java.awt.Image.SCALE_SMOOTH)); 
	
	


	
	
	public Vue(Modele m) {
		list.add(salade);
		list.add(carotte);
		list.add(tomate);
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
		JButton vid = new JButton("Tout r�colter");
		panelMenu.add(vid);
		vid.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.vider();
			}
		});
		
		JButton sal = new JButton("Salade");
		panelMenu.add(sal);
		sal.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.select(0);
			}
		});
		
		JButton car = new JButton("Carotte");
		panelMenu.add(car);
		car.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.select(1);
			}
		});
		
		JButton tom = new JButton("Tomate");
		panelMenu.add(tom);
		tom.addMouseListener(new MouseAdapter(){
			@Override
			public void mouseClicked(MouseEvent e) {
				m.select(2);
			}
		});
		
		score.setForeground(Color.WHITE);
		
		date.setForeground(Color.WHITE);
		
		panelMenu.add(score);
		
		panelMenu.add(date);
		
		invSal.setForeground(Color.WHITE);
		invCar.setForeground(Color.WHITE);
		invTom.setForeground(Color.WHITE);
		
		panelMenu.add(invSal);
		panelMenu.add(invCar);
		panelMenu.add(invTom);
		
		panelMenu.setBackground(Color.black);
		panelMenu.setVisible(true);
		panelMenu.setLayout(new GridLayout(10,1));
		panelPrincipal.add(panelMenu, BorderLayout.EAST);
		panelPrincipal.setBackground(Color.blue);
		panelPrincipal.setVisible(true);
		
		
		JPanel panelCentral = new JPanel();
		panelCentral.setLayout(new GridLayout(m.getSize(),m.getSize()));
		
		panelPrincipal.add(panelCentral, BorderLayout.CENTER);
		
		JPanel panelBas = new JPanel();
		panelBas.setLayout(new GridLayout());
		panelPrincipal.add(panelBas, BorderLayout.SOUTH);
		
		
		

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
		score.setText("Score : "+((Integer)(m.getNb()*10)).toString());
		date.setText("Date : "+m.getMet().getDate());
		invSal.setText("Salade : "+ m.getInv(0));
		invCar.setText("Carotte : "+ m.getInv(1));
		invTom.setText("Tomate : "+ m.getInv(2));
		for(int i=0; i<m.getSize();i++) {
			for(int j=0; j<m.getSize();j++) {
				for(int g =0; g<list.size(); g++) {
				if(m.getTab()[i][j].hasLegume()) {
					
					ImageIcon ic = new ImageIcon(list.get(m.getTab()[i][j].getLegume().getType()).getScaledInstance(Math.min(100,m.getTab()[i][j].getLegume().getTmp()*2+1), Math.min(100,m.getTab()[i][j].getLegume().getTmp()*2+1),java.awt.Image.SCALE_SMOOTH)); 
					tabG[i][j].setIcon(ic);
				}
				
				else {
					tabG[i][j].setIcon(icone);

				}
			}
		}
	}
}
}
