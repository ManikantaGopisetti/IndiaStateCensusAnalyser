package com.bridgelabz;

public class CensusAnalyserException extends Exception {

	public enum ExceptionType {
		CENSUS_FILE_PROBLEM, CENSUS_FILE_NOT_FOUND, WRONG_FILE, INVALID_TYPE, INVALID_DELIMITER, INVALID_HEADER
	}

	public ExceptionType type;

	public CensusAnalyserException(String message, ExceptionType type) {
		super(message);
		this.type = type;
	}

	public CensusAnalyserException(String message, ExceptionType type, Throwable cause) {
		super(message, cause);
		this.type = type;
	}
}
