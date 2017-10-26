import static java.awt.event.InputEvent.CTRL_DOWN_MASK;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;

public class notepad extends JFrame   {
	JFrame  frame=new JFrame();
	JTextArea ta=new JTextArea("");
	
           // menu file and components	   
	    JMenu file=new JMenu("File");
		
 	    JMenuItem 	New =new JMenuItem("     New       "); 
	    JMenuItem 	Open =new JMenuItem("     Open      "); 
	    JMenuItem    Save =new JMenuItem("     Save      ");
            JMenuItem    Saveas=new JMenuItem("     Save As  ");		
	    JMenuItem    Exit =new JMenuItem("      Exit");
		
         // menu edit and components
        JMenu edit=new JMenu("Edit");
		
 	    JMenuItem 	cut =new JMenuItem(new DefaultEditorKit.CutAction()); 	
	    JMenuItem 	copy =new JMenuItem(new DefaultEditorKit.CopyAction()); 	
	    JMenuItem    paste =new JMenuItem(new DefaultEditorKit.PasteAction()); 
	    JMenuItem   selectall =new JMenuItem("     SelectAll      "); 
	    JMenuItem   delete =new JMenuItem("     Delete        Del"); 
		
		// menu search and components
		JMenu search=new JMenu("Search");
			
 	    JMenuItem 	find =new JMenuItem("     Find       "); 
	    JMenuItem   replace =new JMenuItem("     Replace     "); 
		
		// Menu format 
		  JMenu format=new JMenu("Format");
		  JMenuItem 	 wordwrap=new JMenuItem("     Word WRap        "); 
		  JMenuItem 	font =new JMenuItem("     Font        "); 
		  // menu Help
		  JMenu Help=new JMenu("Help");
		 JMenuItem 	help =new JMenuItem("     Help        "); 
                JMenuItem about_notepad =new JMenuItem("     About Notepad       "); 		 
		
	
	public notepad() {
		
		JMenuBar menubar=new JMenuBar();
	      frame.setJMenuBar(menubar);
		  
		// add menu
		file.setMnemonic(KeyEvent.VK_F);
		cut.setText("     Cut       ");
	        copy.setText("     Copy     ");
		paste.setText("     Paste    ");
		
 
            
           New.setAccelerator(KeyStroke.getKeyStroke('N', CTRL_DOWN_MASK));	
           Save.setAccelerator(KeyStroke.getKeyStroke('S', CTRL_DOWN_MASK));	
          Open.setAccelerator(KeyStroke.getKeyStroke('O', CTRL_DOWN_MASK));	
           selectall.setAccelerator(KeyStroke.getKeyStroke('A', CTRL_DOWN_MASK));
           find.setAccelerator(KeyStroke.getKeyStroke('F', CTRL_DOWN_MASK));	
           replace.setAccelerator(KeyStroke.getKeyStroke('R', CTRL_DOWN_MASK));	
     	  cut.setAccelerator(KeyStroke.getKeyStroke('X', CTRL_DOWN_MASK));	
          copy.setAccelerator(KeyStroke.getKeyStroke('C', CTRL_DOWN_MASK));	
          paste.setAccelerator(KeyStroke.getKeyStroke('V', CTRL_DOWN_MASK));	
         
     
     
		file.add(New);
		file.add(Open);
		file.add(Save);
		file.add(Saveas);
		file.add( Exit);
		
	    edit.setMnemonic(KeyEvent.VK_E);
            	 edit.add(cut);
		 edit.add(copy);
		 edit.add(paste);
		 edit.add(selectall);
		 edit.add(delete);
		 
		 search.setMnemonic(KeyEvent.VK_S);
		 search.add(find);
		 search.add(replace);
		 
		// format.setMnemonic(KeyEvent.VK_F);
		 format.add(wordwrap);
		 format.add(font);
		 
		 Help.setMnemonic(KeyEvent.VK_H);
		 Help.add(help);
		 Help.add(about_notepad);
		 
		 menubar.add(file);				
		 menubar.add(edit);
		 menubar.add(search);
		 menubar.add(format);
		 menubar.add(Help);
		 
		 handle_file hf=new handle_file(this);
		 handle_edit he=new handle_edit(this);
		 handle_search hs=new handle_search(this);
		 
		 // adding action listner on file menu
		  New.addActionListener(hf);
		  Open.addActionListener(hf);
		  Save.addActionListener(hf);
		  Saveas.addActionListener(hf);
		  Exit.addActionListener(hf);
		 
		   // adding action listner on edit menu
		  selectall.addActionListener(he);
		  delete.addActionListener(he);
		  
		   // adding action listner on search menu
		    find.addActionListener(hs);
		    replace.addActionListener(hs);
			
			
		    JScrollPane jp = new JScrollPane(ta);             		  
		    ta.setLineWrap(true);
		    ta.setWrapStyleWord(true);
		  		  
                      jp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);             
			frame.add(jp, BorderLayout.CENTER);  
		  
		  frame.setTitle("Notepad");
		  frame.setSize(1000,1000);
		  frame.setVisible(true);
		
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
		
	}

		
	public static void main(String[] args){
		
		notepad np=new notepad();
	}
	
}


	
	
	


