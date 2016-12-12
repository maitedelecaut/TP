package tp1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Tchat extends Subject{
	
	JFrame tchat = new JFrame("Radio Tchat");
	JButton b = new JButton("Nouvel auditeur");
	JTextField text = new JTextField();
	JTextArea lire = new JTextArea();
	
	Tchat t = this;
	
	public Tchat(){
		
		tchat.setPreferredSize(new Dimension(300,300));
		tchat.setLayout(new BorderLayout());
		tchat.getContentPane().add(b, BorderLayout.NORTH);
		tchat.getContentPane().add(text, BorderLayout.SOUTH);
		tchat.getContentPane().add(lire, BorderLayout.CENTER);
		
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				Attach(new Auditeur(t));
			}
			
		});
		
		text.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				lire.setText(lire.getText() + "\n" + text.getText());
				notifyObservers();
			}
			
		});
		
		tchat.pack();
		tchat.setVisible(true);
		
		tchat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public List<Object> getArgs() {
		List <Object> s = new ArrayList<>();
		s.add(lire.getText());
		return s;
	}
	
	public void textAuditeur(String t){
		lire.setText(lire.getText() + "\n" + t);
		notifyObservers();
	}

}
