//GUI-related imports

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.Arrays;
import java.util.Scanner;
//File-related imports

import java.io.FileReader; 		// both needed
import java.io.IOException;

public class  Project05 extends Frame implements ActionListener
{
	
	
	String Input;
	
	double SumIn;
	double sumFinal;
	
	int GCDFinal;
	int N;
	int K;
	
	long startTime;
	long estimatedTime;
	
	char a = 'A';
	char b = 'B';
	char c = 'C';
			
	String[] description = new String[]
			{
			" This program allows the user to find the solution to  ",
			" A sum series, the greatest common divisor and Towers of Hanoi",
			
			};
	
	Recursion r = new Recursion();
	
	// File Parameters
//	String dataFilePath = null;
//	String dataFileName = null;
	
	

	String command = "";
		
	public static void main(String[] args)
	{
		Frame frame = new  Project05();
		
		frame.setResizable(true);
		frame.setSize(1000,700);
		frame.setVisible(true);
	
	}
	
	public  Project05()
	{
		setTitle("Recursive Routines");
	//FileMenu		   			
		MenuBar mb = new MenuBar();
		setMenuBar(mb);
		
		Menu fileMenu = new Menu("File");
		mb.add(fileMenu);
		
		MenuItem miAbout = new MenuItem("About");
		miAbout.addActionListener(this);
		fileMenu.add(miAbout);
		
		MenuItem miExit = new MenuItem("Exit");
		miExit.addActionListener(this);
		fileMenu.add(miExit);
		
		//ProcessMenu
		Menu Functions = new Menu("Functions");
		mb.add(Functions);
		
		MenuItem miP1 = new MenuItem("Summing Series");
		miP1.addActionListener(this);
		Functions.add(miP1);
		
		MenuItem miGCD = new MenuItem("Greatest Common Divisor");
		miGCD.addActionListener(this);
		Functions.add(miGCD);
		
		MenuItem miTOH = new MenuItem("Towers Of Hanoi");
		miTOH.addActionListener(this);
		Functions.add(miTOH);
		
		
	
		
		WindowListener l = new WindowAdapter()
		{
						
			public void windowClosing(WindowEvent ev)
			{
				System.exit(0);
			}
			
			public void windowActivated(WindowEvent ev)
			{
				repaint();
			}
			
			public void windowStateChanged(WindowEvent ev)
			{
				repaint();
			}
		
		};
		
		ComponentListener k = new ComponentAdapter()
		{
			public void componentResized(ComponentEvent e) 
			{
     		repaint();           
 		}
		};
		
		// register listeners
			
		this.addWindowListener(l);
		this.addComponentListener(k);

	}
	
//******************************************************************************
//called by windows manager whenever the application window performs an action
//(select a menu item, close, resize, ....
//******************************************************************************

	public void actionPerformed (ActionEvent ev)
		{
			// figure out which command was issued
			
			command = ev.getActionCommand();
			
			// take action accordingly
						
			if("About".equals(command))
			{
				
				
				repaint();
			}
			
			else
				if("Summing Series".equals(command))
				{
					SumIn=0;
					Input=null;
					startTime = 0;
					estimatedTime = 0;
					
					Input = JOptionPane.showInputDialog("Please enter a number");
				 SumIn = Double.parseDouble(Input);	
				 
				 startTime = System.nanoTime();
				 sumFinal =	r.sumseries(SumIn);
		
				 estimatedTime = System.nanoTime() - startTime;
				 
					repaint();
				}
			else
				if("Exit".equals(command))
				{
					System.exit(0);
				}
			
				else
					if("Greatest Common Divisor".equals(command))
					{
					N=0;
					K=0;
					Input=null;
					startTime = 0;
					estimatedTime = 0;
					
					Input = JOptionPane.showInputDialog("Please enter a number");
						
					 N = Integer.parseInt(Input);	
					 Input=null;
					 Input = JOptionPane.showInputDialog("Please enter a number a second number");
					 
					 K = Integer.parseInt(Input);	
					 
					 startTime = System.nanoTime();
					 
					 GCDFinal = r.gcd(N, K);
					 
					 estimatedTime = System.nanoTime() - startTime;
						repaint();
					}
					else
						if("Towers Of Hanoi".equals(command))
						{
							N=0;
							Input=null;
							startTime = 0;
							estimatedTime = 0;
							r.diskMoves=0;
					
							
							Input = JOptionPane.showInputDialog("Please Enter a Number of disks ");
							 N = Integer.parseInt(Input);
							 startTime = System.nanoTime();
							 r.TOH(N,a,c,b);
							 estimatedTime = System.nanoTime() - startTime;
							repaint();	
						}
			

		}
//********************************************************
//called by repaint() to redraw the screen
//********************************************************
		
		public void paint(Graphics g)
		{
			
			
			int ww = (int)this.getWidth();
			int wh = (int)this.getHeight() -40;
			
		
			if("Summing Series".equals(command))
					{
				g.drawString("n = " + SumIn, 300, 300);
				g.drawString("Summation  = " + sumFinal , 300, 350);
				g.drawString("Execution Time =  " + estimatedTime , 300, 380);
				
					}
			if("Greatest Common Divisor".equals(command))
			{
				g.drawString("N = " + N, 300, 250);
				g.drawString("K = " + K, 300, 300);
				g.drawString("Greatest Common Divisor  = " + GCDFinal , 300, 350);
				g.drawString("Execution Time =  " + estimatedTime , 300, 380);
			}
			
			if("Towers Of Hanoi".equals(command))
			{
				int x=100;
				int y=100;
				
					g.drawString("Disk#",x , y-25);	
					g.drawString("From", x+50, y-25);	
					g.drawString("To", x+100, y-25);
					
					g.drawLine(x-5,y-20,x+35,y-20);
					g.drawLine(x+45,y-20,x+85,y-20);
					g.drawLine(x+95,y-20,x+145,y-20);
	
		
				for (int h=0;h<r.diskMoves; h++)
				{
					if(y >= wh-50)
					{
						x=x+200;
						y=100;
						g.drawString("Disk#",x, 75);	
						g.drawString("From" ,x+50, 75);	
						g.drawString("To", x+100,75);
						
						g.drawLine(x-5, 80,x+35,80);
						g.drawLine(x+45,80,x+85,80);
						g.drawLine(x+95,80,x+145,80);
						
					}
					g.drawString("" + r.diskNumber[h], x, y);
					g.drawString("" + r.From[h], x + 50, y);
					g.drawString("" + r.To[h], x + 100, y);

					y=y+25;
				}
				g.drawString("Number of moves:" +r.diskMoves,x,y);
				g.drawString("Estimated execution time:" +estimatedTime,x,y+25);
				
			}
			if("About".equals(command))
			{
				int x1=100;
				int y1=100;
				
				for (int i=0; i<2; i++)
				{
					g.drawString(description[i],x1+120,y1+140);
					y1=y1+25;
				}
				
			}
			
			
			
			}
			
		}
	
