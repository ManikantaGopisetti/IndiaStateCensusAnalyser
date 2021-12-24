package com.bridgelabz;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class StateCensusAnalyser {

	ArrayList<CSVStateCensus> stateCensus = new ArrayList<CSVStateCensus>();

	public int loadIndiaCensusData(String indiaCensusCsvFilePath) throws CensusAnalyserException {

		try {

			CSVReader csvReader = new CSVReader(new FileReader(indiaCensusCsvFilePath));
			String[] entry = csvReader.readNext();
			if (entry.length != 4) {
				throw new CensusAnalyserException(" Incorrect Delimiters ",
						CensusAnalyserException.ExceptionType.INVALID_DELIMITER);
			}
			if (headerCheck(entry) == false) {
				throw new CensusAnalyserException(" Header not matched ",
						CensusAnalyserException.ExceptionType.INVALID_HEADER);
			}
			while ((entry = csvReader.readNext()) != null) {
				stateCensus.add(new CSVStateCensus(entry[0], Long.parseLong(entry[1]), Long.parseLong(entry[2]),
						Double.parseDouble(entry[3])));
			}
			for (CSVStateCensus data : stateCensus) {
				System.out.println(data);
			}
			return stateCensus.size();

		} catch (FileNotFoundException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_NOT_FOUND);
		} catch (CsvValidationException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		} catch (NumberFormatException e) {
			throw new CensusAnalyserException(e.getMessage(), CensusAnalyserException.ExceptionType.INVALID_TYPE);
		} catch (IOException e) {
			throw new CensusAnalyserException(e.getMessage(),
					CensusAnalyserException.ExceptionType.CENSUS_FILE_PROBLEM);
		}

	}

	private boolean headerCheck(String[] entry) {
		if (entry[0].equals("State") && entry[1].equals("Population") && entry[2].equals("AreaInSqKm")
				&& entry[3].equals("DensityPerSqKm")) {
			return true;
		}
		return false;
	}

}
