package ua.edu.ucu.tempseries;

interface FindingPredicate {
    boolean compare(double a, double b);
}

public class TemperatureSeriesAnalysis {

    private double[] tempSeries;

    public TemperatureSeriesAnalysis() {
        tempSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        tempSeries = temperatureSeries;
    }

    private void checkEmpty() {
        int seriesLen = tempSeries.length;
        if (seriesLen == 0) {
            throw new IllegalArgumentException();
        }
    }

    private double predicateFinding(FindingPredicate pred) {
        checkEmpty();
        double bestValue = tempSeries[0];
        for (double val: tempSeries) {
            if (pred.compare(val, bestValue)) {
                bestValue = val;
            }
        }
        return bestValue;
    }

    public double average() {
        checkEmpty();
        double avg = 0;
        for (double val : tempSeries) {
            avg += val;
        }
        return avg / tempSeries.length;
    }

    public double deviation() {
        checkEmpty();
        double dev = 0, avg = average(), curSummon;
        int serLen = tempSeries.length;
        for (double val: tempSeries) {
            curSummon = Math.pow(val - avg, 2);
            dev += curSummon;
        }
        dev /= serLen;
        dev = Math.sqrt(dev);
        return dev;
    }

    public double min() {
        FindingPredicate pred = new FindingPredicate() {
            @Override
            public boolean compare(double a, double b) {
                return a < b;
            }
        };
        return predicateFinding(pred);
    }

    public double max() {
        FindingPredicate pred = new FindingPredicate() {
            @Override
            public boolean compare(double a, double b) {
                return a > b;
            }
        };
        return predicateFinding(pred);
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
