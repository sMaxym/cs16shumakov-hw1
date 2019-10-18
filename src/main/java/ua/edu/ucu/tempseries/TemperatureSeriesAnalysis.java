package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {

    private double[] tempSeries;

    public TemperatureSeriesAnalysis() {
        tempSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        tempSeries = temperatureSeries;
    }

    public double average() {
        double avg = 0;
        int seriesLen = tempSeries.length;
        if (seriesLen == 0){
            throw new IllegalArgumentException();
        }
        for (double val : tempSeries){
            avg += val;
        }
        return avg / seriesLen;
    }

    public double deviation() {
        return 0;
    }

    public double min() {
        return 0;
    }

    public double max() {
        return 0;
    }

    public double findTempClosestToZero() {
        return 0;
    }

    public double findTempClosestToValue(double tempValue) {
        return 0;
    }

    public double[] findTempsLessThen(double tempValue) {
        return null;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        return null;
    }

    public TempSummaryStatistics summaryStatistics() {
        return null;
    }

    public int addTemps(double... temps) {
        return 0;
    }
}
