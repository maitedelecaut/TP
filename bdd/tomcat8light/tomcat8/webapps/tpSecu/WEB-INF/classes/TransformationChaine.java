import javax.swing.JOptionPane;

import org.apache.commons.lang3.StringEscapeUtils;

public class TransformationChaine{
	public static void main(String[] args) {
	    JOptionPane jop = new JOptionPane(), jop2 = new JOptionPane();
	    String nom = jop.showInputDialog(null, "Entrer une chaine de caractère !", "chaine !", JOptionPane.QUESTION_MESSAGE);
	    
	    nom = StringEscapeUtils.escapeHtml4(nom);
	    System.out.println(nom);
	}
}
