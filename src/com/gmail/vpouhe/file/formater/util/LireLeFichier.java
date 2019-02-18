package com.gmail.vpouhe.file.formater.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.gmail.vpouhe.file.formater.model.Reference;
import com.gmail.vpouhe.file.formater.model.Report;

public class LireLeFichier {
	static Logger log = Logger.getLogger(FormatFactory.class);

	/**
	 * Cette méthode retourne initialise l'objet Report, qui représente le fichier
	 * des références.
	 * 
	 * @param inputFile
	 * @return
	 */
	public static Report getReport(String inputFile) {
		log.info("Dans LireLeFichier.getReport()");
		Report report = new Report();

		// Collection des référence dans le fichier txt
		List<Reference> ListReferences = new ArrayList<Reference>();

		int _position = inputFile.lastIndexOf("\\");

		// Récupération du nom du fichier
		String refInputFile = inputFile.substring(_position + 1);

		report.setInputFile(refInputFile);

		// Initialisation de la collection des lignes dans le fichier txt
		List<String> lignesDuFichierTxt = getLignesFichier(inputFile);

		Reference reference;

		for (String ligneReference : lignesDuFichierTxt) {
			String[] tabDonneesLigneFichierTxt = ligneReference.split("\\;");
			reference = new Reference();

			int taileTab = tabDonneesLigneFichierTxt.length;
			for (int i = 0; i < taileTab; i++) {
				switch (i) {
				case 0:
					reference.setNumReference(tabDonneesLigneFichierTxt[i]);
					break;
				case 1:
					reference.setColor(tabDonneesLigneFichierTxt[i]);
					break;
				case 2:
					reference.setPrice(tabDonneesLigneFichierTxt[i]);
					break;
				case 3:
					reference.setSize(tabDonneesLigneFichierTxt[i]);
					break;
				}

			}

			ListReferences.add(reference);
			report.setReferences(ListReferences);
		}
		log.info("Dans LireLeFichier.getReport() OUT");
		return report;
	}

	/**
	 * Cette méthode lit un fichier txt et retourne une collection des lignes
	 * trouvées
	 * 
	 * @param inputFile
	 * @return
	 */
	public static List<String> getLignesFichier(String inputFile) {

		List<String> lignesDuTexte = new ArrayList<String>();// Collection des lignes du fichier txt
		String ligneDuTexte;// Une ligne du fichier txt en lecture

		// Récupération du fichier txt
		File fichierTxt = new File(inputFile);

		try {
			// Lecture du fichier txt
			FileReader fileReader = new FileReader(fichierTxt);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			try {
				// Parcours du flux
				while ((ligneDuTexte = bufferedReader.readLine()) != null) {
					lignesDuTexte.add(ligneDuTexte);
				}
				bufferedReader.close();
				fileReader.close();
			} catch (IOException exception) {
				System.out.println("Erreur lors de la lecture : " + exception.getMessage());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("Le fichier n'a pas été trouvé");
		}

		return lignesDuTexte;
	}

}
