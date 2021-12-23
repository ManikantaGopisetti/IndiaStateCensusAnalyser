package com.bridgelabz;

public class CSVStateCensus {

	public String state;

	public long population;

	public long areaInSqKm;

	public double densityPerSqKm;

	public CSVStateCensus(String state, long population, long areaInSqKm, double densityPerSqKm) {
		super();
		this.state = state;
		this.population = population;
		this.areaInSqKm = areaInSqKm;
		this.densityPerSqKm = densityPerSqKm;
	}

	@Override
	public String toString() {
		return "IndiaCensusCSV{" + "State='" + state + '\'' + ", Population='" + population + '\'' + ", AreaInSqKm='"
				+ areaInSqKm + '\'' + ", DensityPerSqKm='" + densityPerSqKm + '\'' + '}';
	}

}
