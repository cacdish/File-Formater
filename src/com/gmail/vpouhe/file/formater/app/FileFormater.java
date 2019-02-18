package com.gmail.vpouhe.file.formater.app;

import com.gmail.vpouhe.file.formater.util.FormatFactory;
import com.gmail.vpouhe.file.formater.util.TestConstants;

public class FileFormater {
	static FormatFactory formatFactory = new FormatFactory();

	public static void main(String[] args) {
		formatFactory.formatDonees(TestConstants.NOM_QUALIFIER_DU_FICHIER, TestConstants.FORMAT_XML,
				TestConstants.URL_XML_RESULT_FILE);
		formatFactory.formatDonees(TestConstants.NOM_QUALIFIER_DU_FICHIER, TestConstants.FORMAT_JSON,
				TestConstants.URL_JSON_RESULT_FILE);
	}

}
