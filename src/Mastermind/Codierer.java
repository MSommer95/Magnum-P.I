package Mastermind;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.*;

//Der Codierer entscheidet sich für eine Farbfolge

public class Codierer extends JFrame {

	private Color[] farbe;

	private Panel southP;
	private Panel centerP;
	private Panel northP;
	private JButton[] buttonsammler;
	private JButton eins;
	private JButton zwei;
	private JButton drei;
	private JButton vier;

	private JSlider sliderFarbe;
	private JSlider sliderButton;
	private MouseListener back;
	private Menue menue;

	private ChangeListener farbListener;

	public Codierer() {
		super("Codierer Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(512, 512);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
		this.registrierelistener();
	}

	private void initialisiereKomponenten() {
		this.southP = new Panel();
		this.southP.setBackground(new Color(250, 240, 230));

		this.centerP = new Panel();
		this.centerP.setBackground(new Color(150, 0, 150));

		this.northP = new Panel();
		this.northP.setBackground(new Color(150, 0, 190));

		this.farbe = new Color[] { Color.BLACK, Color.RED, Color.YELLOW, Color.BLUE, Color.WHITE, Color.GREEN };

		this.eins = new JButton("eins");
		this.zwei = new JButton("zwei");
		this.drei = new JButton("drei");
		this.vier = new JButton("vier");

		this.farbListener = new FarbListener();

		this.sliderFarbe = this.erstelleSchieberegler(1, 6);
		this.sliderButton = this.erstelleSchieberegler(1, 4);

		this.back = new BackListener();

		this.buttonsammler = new JButton[] { eins, zwei, drei, vier };
		this.setVisible(true);
	}

	private class BackListener implements MouseListener {

		public void mouseClicked(MouseEvent e) {
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

	private class FarbListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			farbe();
		}

	}

	private void back() {
	}

	private void farbe() {
		int i = sliderFarbe.getValue() - 1;
		buttonsammler[sliderButton.getValue() - 1].setBackground(farbe[i]);
	}

	private void registrierelistener() {
		this.sliderFarbe.addChangeListener(this.farbListener);
	}

	private JSlider erstelleSchieberegler(int minimum, int maximum) {
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMajorTickSpacing(1);
		return schieberegler;
	}

	private void ordneKomponentenAn() {

		southP.add(sliderFarbe);
		southP.add(sliderButton);
		add(southP, BorderLayout.SOUTH);
		add(northP, BorderLayout.NORTH);

		for (int i = 0; i < buttonsammler.length; i++)
			centerP.add(buttonsammler[i]);

		add(centerP, BorderLayout.CENTER);

	}

}
