package Mastermind;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.*;

//Der Codierer entscheidet sich f�r eine Farbfolge

public class Codierer extends JFrame {

	private Color[] farbe;
	private Color[] ccolor;

	private Panel southP;
	private Panel centerP;
	private Panel northP;
	private JButton[] buttonsammler;
	private JButton eins;
	private JButton zwei;
	private JButton drei;
	private JButton vier;
	private JButton best�tigen;

	private JSlider sliderFarbe;
	private JSlider sliderButton;

	private ChangeListener farbListener;
	private MouseListener best�tigenListener;

	// Getter und Setter
	public Color[] getFarbe() {
		return farbe;
	}

	public void setFarbe(Color[] farbe) {
		this.farbe = farbe;
	}

	public Panel getSouthP() {
		return southP;
	}

	public void setSouthP(Panel southP) {
		this.southP = southP;
	}

	public Panel getCenterP() {
		return centerP;
	}

	public void setCenterP(Panel centerP) {
		this.centerP = centerP;
	}

	public Panel getNorthP() {
		return northP;
	}

	public void setNorthP(Panel northP) {
		this.northP = northP;
	}

	public JButton[] getButtonsammler() {
		return buttonsammler;
	}

	public void setButtonsammler(JButton[] buttonsammler) {
		this.buttonsammler = buttonsammler;
	}

	public Color[] getCcolor() {
		return ccolor;
	}

	public void setCcolor(Color[] ccolor) {
		this.ccolor = ccolor;
	}

	public JButton getEins() {
		return eins;
	}

	public void setEins(JButton eins) {
		this.eins = eins;
	}

	public JButton getZwei() {
		return zwei;
	}

	public void setZwei(JButton zwei) {
		this.zwei = zwei;
	}

	public JButton getDrei() {
		return drei;
	}

	public void setDrei(JButton drei) {
		this.drei = drei;
	}

	public JButton getVier() {
		return vier;
	}

	public void setVier(JButton vier) {
		this.vier = vier;
	}

	public JSlider getSliderFarbe() {
		return sliderFarbe;
	}

	public void setSliderFarbe(JSlider sliderFarbe) {
		this.sliderFarbe = sliderFarbe;
	}

	public JSlider getSliderButton() {
		return sliderButton;
	}

	public void setSliderButton(JSlider sliderButton) {
		this.sliderButton = sliderButton;
	}

	public ChangeListener getFarbListener() {
		return farbListener;
	}

	public void setFarbListener(ChangeListener farbListener) {
		this.farbListener = farbListener;
	}

	// Konstruktor f�r Codierer
	public Codierer() {
		super("Codierer Screen");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(612, 512);
		this.initialisiereKomponenten();
		this.ordneKomponentenAn();
		this.registrierelistener();
		this.setVisible(true);
	}

	// Initialisiert die Komponenten von Codierer
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
		this.best�tigen = new JButton("Best�tigen");

		this.farbListener = new FarbListener();
		this.best�tigenListener = new Best�tigenListener();

		this.sliderFarbe = this.erstelleSchieberegler(1, 6);
		this.sliderButton = this.erstelleSchieberegler(1, 4);

		this.buttonsammler = new JButton[] { eins, zwei, drei, vier };

	}

	// Innere Klasse f�r die Slider Listener
	private class Best�tigenListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			best�tigen();
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub

		}

	}

	private class FarbListener implements ChangeListener {

		public void stateChanged(ChangeEvent e) {
			farbe();
		}

	}

	// Methode f�r den Slider Listener (l�uft die Buttons durch und w�hlt eine
	// Farbe/ f�r den Anwender ist die Farbe zu der Zahl im Vorfeld nicht
	// bekannt)
	private void best�tigen() {
		this.ccolor = new Color[] { this.eins.getBackground(), this.zwei.getBackground(), this.drei.getBackground(),
				this.vier.getBackground() };
	}

	private void farbe() {
		int i = sliderFarbe.getValue() - 1;
		buttonsammler[sliderButton.getValue() - 1].setBackground(farbe[i]);
	}

	// �bergibt den Komponenten die Listener
	private void registrierelistener() {
		this.sliderFarbe.addChangeListener(this.farbListener);
		this.best�tigen.addMouseListener(this.best�tigenListener);
	}

	// Methode zum Erstellen der Slider
	private JSlider erstelleSchieberegler(int minimum, int maximum) {
		JSlider schieberegler = new JSlider(minimum, maximum);
		schieberegler.setPaintLabels(true);
		schieberegler.setPaintTicks(true);
		schieberegler.setMajorTickSpacing(1);
		return schieberegler;
	}

	// Organisationsmethode f�r die Komponenten (Darstellung)
	private void ordneKomponentenAn() {

		southP.add(sliderFarbe);
		southP.add(best�tigen);
		southP.add(sliderButton);

		add(southP, BorderLayout.SOUTH);
		add(northP, BorderLayout.NORTH);

		for (int i = 0; i < buttonsammler.length; i++)
			centerP.add(buttonsammler[i]);

		add(centerP, BorderLayout.CENTER);

	}

}
