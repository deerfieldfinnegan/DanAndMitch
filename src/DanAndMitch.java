import java.applet.*;
import java.net.*;
import javax.swing.JOptionPane;
import java.applet.Applet; 
import java.awt.Graphics;
import java.awt.*;
import java.awt.*; 
import java.awt.event.*;
import java.awt.geom.Line2D;
import javax.swing.JApplet;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DanAndMitch extends Applet {
	
	
	
	public static void main(String[] args) {
		Double watts = 0.0 ; //defining the numeber of watts in the beginning
		Double elec = 0.0; //the cost depending on the country you live in
		Double bCost = 0.0; //if the number of years of ownership is 5 or more years the battery cost increases
		String input1 = JOptionPane.showInputDialog("How much did you purchase your computer for?");
		Double purchase = Double.parseDouble(input1);
		String computer = JOptionPane.showInputDialog("Do you own a laptop or a desktop?"); 
		String brand = JOptionPane.showInputDialog("Do you have an Intel or AMD CPU?"); //Asking about CPU
		String input2 = JOptionPane.showInputDialog("How many cores do you have?"); //Asking about cores, this contributes to follow up questions depending on your CPU answer
		Double cores = Double.parseDouble(input2);
		String ram1 = JOptionPane.showInputDialog("How big is your ram in MB?");
		Double ram = Double.parseDouble(ram1);
		String gigs1 = JOptionPane.showInputDialog("How many gigabytes is your hard disk?"); //The gigs of the hard disk
		Double gigs= Double.parseDouble(gigs1);
		String hard1 = JOptionPane.showInputDialog("Is your hard disk 3.5 or 2.5 inches?"); //The most common types of hard disk sizes and the biggest affect on energy is the size not the GB
		Double hard = Double.parseDouble(hard1);
		String country = JOptionPane.showInputDialog("Do you live in USA, China, India, Mexico, Canada, Russia, Brazil or Japan?"); //To figure out the cost per KwH where they live
		String battery1 = JOptionPane.showInputDialog("How many years do you expect to keep the computer"); //To help calculate the electricity cost and if the battery will need to be replaced
		Double battery = Double.parseDouble(battery1);
		String hours1 = JOptionPane.showInputDialog("How many hours a day do you leave computer on?"); //to figure out the energy per day, x 365 is the energy per year
		Double hours = Double.parseDouble(hours1);
		if (computer.equals("laptop")) {
			watts = watts + 30.0;
			String laptop1 = JOptionPane.showInputDialog("Is your laptop screen 11, 12,13, 14, or 15 inches?"); //figuring out the wattage if you havae a laptop
			Double laptop = Double.parseDouble(laptop1);
			if (laptop == 11){
				watts = watts + 5.0;
			}
			if (laptop == 12){
				watts = watts + 8.1;
			}
			if (laptop == 13){
				watts = watts + 8.6;
			}
			if (laptop == 14){
				watts = watts + 10.0;
			}
			if (laptop == 15){
				watts = watts + 10.0;
			}
		}
		if (computer.equals("desktop")){ //figuring out the wattage if its a desktop and asking for screen size
			String desktop1 = JOptionPane.showInputDialog("Do you have a 21.5 inch desktop, or a 27 inch desktop?");
			Double desktop = Double.parseDouble(desktop1);
			if (desktop == 21.5){
				watts = watts + 37.5;
			}
			if (desktop == 27){
				watts = watts + 79.0;
			}
		}
		if (brand.equals("Intel")){ //the most common CPUs with the cores and the wattage increases by the number added
			String intel = JOptionPane.showInputDialog("Do you have the Intel Athlon II X4 630, the Intel Core 2 Duo E7500, Intel Core i3 -6300T X2, or Intel Core 2 Quad Q8200?");
			if (intel.equals("Intel Athlon II X4 630")){
				watts = watts + 98.0;
			}
			if (intel.equals("Intel Core 2 Duo E7500")){
				watts = watts + 40.8;
			}
			if (intel.equals("Intel Core i3 -6300T X2")){
				watts = watts + 75.0;
			}
			if (intel.equals("Intel Core 2 Quad Q8200")){
				watts = watts + 52.0;
			}
			}
		if (brand.equals("AMD")){ //The most common CPUs with AMD and the wattage depending on the answer
			String amd = JOptionPane.showInputDialog("Do you have the AMD PHENOM™ II X4 925 W, the AMD PHENOM™ X4 9750, or the AMD PHENOM™ II X3 720?");
			if (amd.equals("AMD PHENOM™ II X4 925 W")){
				watts = watts + 121.2;
			}
			if (amd.equals("AMD PHENOM™ X4 9750")){
				watts = watts + 126.0;
			}
			if (amd.equals("AMD PHENOM™ II X3 720")){
				watts = watts + 81.6;
			}
		}
		if (hard==3.5){ //wattage depending on the size of the hard disk 
			watts = watts + 192.0;
		}
		if (hard==2.5){
			watts = watts + 12.5;
		}
	    if (country.equals("USA")){ //electricity cost per country
		elec = elec +.1273;
		}
		if (country.equals("China")){
			elec = elec + .08;
		}
		if (country.equals("India")){
			elec = elec +.08;
		}
		if (country.equals("Mexico")){
			elec = elec + .1;
		}
		if (country.equals("Canada")){
			elec = elec + .1;
		}
		if (country.equals("Russia")){
			elec = elec + .11;
		}
		if (country.equals("Brazil")){
			elec = elec + .17;
		}
		if (country.equals("Japan")){
			elec = elec + .26;
		}
		if (battery>=4){ //Saying if the number of years planning on keeping it is great or equal to 4 than you replace the battery
			bCost = bCost + 65;
		} 
		double a1 = ((watts/1000) * hours * elec); 
		double b = (bCost); 
		String a = "" + a1;
		double a2 = (bCost+purchase+(((((365*battery)*(watts/1000))*hours)*elec))) ; 
		String b1 = "" +a2;
		String b3 = "" +b;
		JFrame frame = new JFrame("COSTS");
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


	    Panel p = new Panel();
	    p.setLayout(new GridLayout(0, 1, 100, 100));

	    Button button = new Button("Electricity cost per day is");
	    final JLabel label = new JLabel(Long.toString(Long.MAX_VALUE));
	    label.setText(a);
	    Button button1 = new Button("The total cost of the computer for "+ battery +" years is ");
	    final JLabel label2 = new JLabel(Long.toString(Long.MAX_VALUE));
	    label2.setText(b1);
	    Button button2 = new Button("The cost of the battery is");
	    final JLabel label3 = new JLabel(Long.toString(Long.MAX_VALUE));
	    label3.setText(b3);

	    p.add(button);
	    p.add(label);
	    p.add(button1);
	    p.add(label2);
	    p.add(button2);
	    p.add(label3);
	    frame.add(p, BorderLayout.NORTH);
	    frame.pack();
	}
	 public void stop() {}
     public void destroy() {}
	
		
}
		

		




