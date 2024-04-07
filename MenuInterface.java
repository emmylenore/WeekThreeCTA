package weekThree;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class MenuInterface extends JFrame {
	private JFrame frame;
	private JTextArea textBox;
	JPanel panel;
	
	public MenuInterface() {
		
		
		 panel = new JPanel();
	        panel.setBounds(0, 15, 500, 415);
	        panel.setBackground(Color.orange);
	        
		 frame = new JFrame("menu example");
		 frame.add(panel);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
	        frame.setSize(500, 415);   
	        frame.setLayout(new BorderLayout());  
	        frame.setVisible(true);
	     
	        
	       
	        
	      
	        
	        JMenuBar menuBar = new JMenuBar();
	        JMenu menubar = new JMenu("Menu Bar 1-4"); 

	        
	        JMenuItem showDateTimeItem = new JMenuItem("Show Date and Time");
	        JMenuItem saveToFileItem = new JMenuItem("Save to File");
	        JMenuItem changeBackgroundColorItem = new JMenuItem("Change Background Color");
	        JMenuItem exitItem = new JMenuItem("Exit");

	        
	        showDateTimeItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                showDateTime();  
	            }
	        });

	        saveToFileItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                saveToFile();  
	            }
	        });

	        changeBackgroundColorItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                changeBackgroundColor();  
	            }
	        });

	        exitItem.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                System.exit(0); 
	            }
	        });

	        
	        menubar.add(showDateTimeItem);
	        menubar.add(saveToFileItem);
	        menubar.add(changeBackgroundColorItem);
	        menubar.add(exitItem);

	        
	        menuBar.add(menubar);

	        frame.setJMenuBar(menuBar);

	        textBox = new JTextArea();
	        frame.add(new JScrollPane(textBox), BorderLayout.CENTER);

	        frame.setVisible(true);
	    }

	    private void showDateTime() {
	        String dateTime = new java.util.Date().toString();
	        textBox.append(dateTime + "\n");
	    }

	    private void saveToFile() {
	        String content = textBox.getText();
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt"))) {
	            writer.write(content);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	   
	    private void changeBackgroundColor() {
	    	 float hue = (float) Math.random();
	    		 Color color = Color.getHSBColor(hue, 1.0f, 1.0f) ;
		         panel.setBackground(color); 
	    	 
	         
	    }

	    
	    public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                new MenuInterface(); 
	            }
	        });
	    }
	
	}
	


