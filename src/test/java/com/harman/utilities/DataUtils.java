package com.harman.utilities;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public String[][] validCredentialData() {
		String[][] main = new String[2][3];

		main[0][0] = "admin";
		main[0][1] = "pass";
		main[0][2] = "OpenEMR";

		main[1][0] = "physician";
		main[1][1] = "physician";
		main[1][2] = "OpenEMR";

		return main;
	}

}
