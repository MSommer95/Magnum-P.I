package Mastermind;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.*;

//Der Codierer entscheidet sich für eine Farbfolge

public class Codierer extends JFrame{
	private Panel southP;
	private Panel centerP;
	private Panel northP;
	private JButton[] buttonsammler;
	private JButton eins;
	private JButton zwei;
	private JButton drei;
	private JButton vier;
	private JButton fünf;
	private JButton sechs;

	private JSlider slider;
	private MouseListener back;
	private Menue menue;
	
	public Codierer(){
		super("Codierer Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(256,256);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
		this.registrierelistener();
	}
	
	
	private void initialisiereKomponenten(){
		this.southP = new Panel();
		this.southP.setBackground( new Color(250,240,230));
		
		this.centerP = new Panel();
		this.centerP.setBackground( new Color(150,0,150));
		
		this.northP = new Panel();
		this.northP.setBackground( new Color(150,0,190));
		
		this.eins = new JButton("eins");
		this.zwei = new JButton("zwei");
		this.drei = new JButton("drei");
		this.vier = new JButton("vier");
		this.fünf = new JButton("fünf");
		this.sechs = new JButton("sechs");
		
	
		this.slider = this.erstelleSchieberegler(1, 6);
		this.back = new BackListener();
		
		this.buttonsammler = new JButton[] {eins, zwei, drei, vier, fünf, sechs};
		this.setVisible(true);
	}
	
	
	private class BackListener implements MouseListener {
		
		public void mouseClicked(MouseEvent e){
		back();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	private void back(){
	}
	
	private void registrierelistener(){
	}
	
	private JSlider erstelleSchieberegler(int minimum, int maximum){
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMajorTickSpacing(1);
		return schieberegler;
	}

	private void ordneKomponentenAn(){
		
		southP.add(slider);
		add(southP, BorderLayout.SOUTH);
		add(northP, BorderLayout.NORTH);
		
		for(int i=0; i<buttonsammler.length; i++)
	         centerP.add(buttonsammler[i]);
		
		add(centerP,BorderLayout.CENTER);
		
		

		
	}

}
