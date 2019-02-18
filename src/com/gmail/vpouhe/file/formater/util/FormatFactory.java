package com.gmail.vpouhe.file.formater.util;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.gmail.vpouhe.file.formater.model.Report;

/**
 * Classe utilitaire transorme les donn�es d'un fichier en fichier xml ou
 * fichier Json
 * 
 * @author Vincent
 *
 */
public class FormatFactory {
	static Logger log = Logger.getLogger(FormatFactory.class);

	/**
	 * Cette méthode dirige vers la fonction appropriée.
	 * 
	 * @param nomFichier
	 * @param formatSortie
	 * @param pathSortie
	 */
	public void formatDonees(String nomFichier, String formatSortie, String pathSortie) {
		if (formatSortie.equalsIgnoreCase("XML")) {
			writeXMLFile(nomFichier, pathSortie);
		} else if (formatSortie.equalsIgnoreCase("JSON")) {
			writeJsonFile(nomFichier, pathSortie);
		} else {
			log.info("Le format, " + formatSortie + ", n'est pas pris en charge.");
		}
	}

	/**
	 * Cette Méthode initialise l'objet report et fait appel à la fonction de
	 * création du fichier xml.
	 * 
	 * @param nomFichier
	 * @param destination
	 */
	public void writeXMLFile(String nomFichier, String destination) {
		log.info("Dans FormatFactory.writeXMLFile()");

		// Initialisation de l'objet Report avec les donnees du fichier.
		Report report = LireLeFichier.getReport(nomFichier);
		log.debug("Dans FormatFactory.writeXMLFile --> Report : " + report.toString());

		// Création du fichier XML
		try {
			write2XMLFile(report, destination);
		} catch (IOException e) {
			log.info("Erreur lors de la création du Fichier XML.");
			e.printStackTrace();
		}
		log.info("Fichier XML créé");
	}

	/**
	 * Cette méthode transfert les donnée d'un fichier fichier XML
	 * 
	 * @param object
	 * @throws IOException
	 */
	public void write2XMLFile(Object object, String pathFile) throws IOException {
		log.info("Dans FormatFactory.write2XMLFile()");
		XmlMapper xmlMapper = new XmlMapper();

		// Pour indenter le format XML
		xmlMapper.enable(SerializationFeature.INDENT_OUTPUT);

		xmlMapper.writeValue(new File(pathFile), object);

		log.info("FormatFactory.write2XMLFile() OUT");
	}

	/**
	 * Cette méthode transfert les donnée d'un fichier de données au format Json
	 * 
	 * @param nomFichier
	 */
	public void writeJsonFile(String nomFichier, String destination) {
		log.info("Dans FormatFactory.writeJsonFile()");
		// Initialisation d'un tableau avec les donn�es du fichier.
		Report report = LireLeFichier.getReport(nomFichier);

		ObjectMapper mapper = new ObjectMapper();
		// Pour indenter les objets au format Json
		mapper.enable(SerializationFeature.INDENT_OUTPUT);

		File file = new File(destination);
		try {
			// Ecriture des donnees dans un fichier JSON.
			mapper.writeValue(file, report.getReferences());
		} catch (IOException e) {
			log.info("Erreur lors de la création du Fichier JSON.");
			e.printStackTrace();
		}
		log.info("FormatFactory.writeJsonFile() OUT");
	}
}
