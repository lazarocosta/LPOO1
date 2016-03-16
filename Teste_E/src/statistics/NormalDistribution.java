package statistics;

public class NormalDistribution implements ProbabilityDistribution {
	private double mean;
	private double stddev;
	
	public NormalDistribution() {
		this.mean = 0;
		this.stddev = 1;
	}
	
	public NormalDistribution(double mean, double stddev) throws IllegalArgumentException{
		if (stddev == 0) {
			throw new IllegalArgumentException();
		}
		
		this.mean = mean;
		this.stddev = stddev;
	}

	public double getMean() {
		return mean;
	}

	public double getStddev() {
		return stddev;
	}
	
	public double probabilityDensityFunction(double x) {
		return (1/(stddev*Math.sqrt(2*Math.PI)))*Math.exp((-(x-mean)*(x-mean))/2*stddev*stddev);
	}
	
	public double calcRangeProbability(int min, int max) {
		System.out.print(probabilityDensityFunction(min));
		System.out.print(probabilityDensityFunction(max));
		
		return probabilityDensityFunction(min) - probabilityDensityFunction(max);
	}
}
