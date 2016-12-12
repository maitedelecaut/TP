package Draggenda;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Save{ 
	ArrayList<String> listuser=new ArrayList<>();
	Logs log;

	/**
	 * constructeur save
	 * @param log
	 */
	public Save(Logs log){
		this.log=log;
	}

	/**
	 * sauvegarder l agenda en txt
	 * @param age
	 */
	public void sauvegarder(Agenda age){
		int i=0;
		ObjectOutputStream ooss = null;
		ObjectInputStream oiss = null;
		try {
			int idxligne=log.retournerIndexUser(age.getlog());
			oiss = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("SauvegardeAgenda.txt"))));
			ooss = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("SauvegardeAgenda.txt"))));
			Agenda line=(Agenda)oiss.readObject();
			while(line!=null && i<idxligne){
				ooss.writeObject(line);
				i++;
				line=(Agenda)oiss.readObject();
			}
			ooss.writeObject(age);
			i++;
			line=(Agenda)oiss.readObject();
			while(line!=null){
				ooss.writeObject(line);
				line=(Agenda)oiss.readObject();

			}
			ooss.close();
			oiss.close();
		}catch (EOFException e){
			try {
				ooss = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File("SauvegardeAgenda.txt"))));
				ooss.writeObject(age);
				ooss.close();
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public void nouveauUtilisateur(String newuser){
		try {
			FileWriter fw=new FileWriter("SauvegardeUtilisateur.csv");
			fw.write(newuser);
			fw.close();
		} catch (FileNotFoundException e1) {

			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public ArrayList<String> listeUtilisateur(){
		try {
			BufferedReader bw = new BufferedReader(new FileReader("SauvegardeUtilisateur.csv"));
			String line=bw.readLine();
			while(line!=null){
				listuser.add(line);
				line=bw.readLine();
			}
			bw.close();
		} catch (FileNotFoundException e1) {
			try{
				PrintWriter pw = new PrintWriter(new File("SauvegardeUtilisateur.csv"));
				pw.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return listuser;

	}

	public Agenda charger(int idx){
		ObjectInputStream oiss = null;
		Agenda age=null;
		try {
			oiss = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File("SauvegardeAgenda.txt"))));
			for(int i=0; i<idx; i++){
				oiss.readObject();
			}
			age=(Agenda)oiss.readObject();
			oiss.close();
		} catch (FileNotFoundException e) {

			try {
				PrintWriter pw = new PrintWriter(new File("SauvegardeAgenda.txt"));
				pw.close();
				for(String nom:log.comptes.keySet())
					age=new Agenda(nom);
			} catch (FileNotFoundException e1) {
				e1.printStackTrace();
			}
		}catch(EOFException e){
			for(String nom:log.comptes.keySet())
				age=new Agenda(nom);
		}catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return age;
	}


}