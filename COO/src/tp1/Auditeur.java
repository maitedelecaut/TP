package tp1;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Auditeur extends Observer{
	JTextArea text = new JTextArea();
	JTextField ecrire = new JTextField();
	Auditeur a = this;
	Tchat t;

	@Override
	public void Update(List<Object> l) {
		for(int i = 0; i<l.size();i++)
			text.setText(l.get(i) + "\n");
	}

	public Auditeur(Tchat t){
		this.t = t;
		JFrame audit = new JFrame("Auditeur");
		audit.setPreferredSize(new Dimension(300,300));
		audit.setLayout(new BorderLayout());
		audit.getContentPane().add(ecrire, BorderLayout.SOUTH);
		audit.getContentPane().add(text, BorderLayout.CENTER);
		audit.pack();
		audit.setVisible(true);	
		audit.addWindowListener(new WindowListener(){

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				audit.dispatchEvent(e);
				t.Detach(a);
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ecrire.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				t.textAuditeur(ecrire.getText());
				
			}
			
		});
	}
}
