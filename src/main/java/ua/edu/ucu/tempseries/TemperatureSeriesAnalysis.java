package ua.edu.ucu.tempseries;

public class TemperatureSeriesAnalysis {

    interface FindingPredicate {
        boolean compare(double a, double b);
    }

    private double[] tempSeries;

    public TemperatureSeriesAnalysis() {
        tempSeries = new double[0];
    }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        tempSeries = temperatureSeries;
    }

    private void checkEmpty() throws IllegalArgumentException {
        int seriesLen = tempSeries.length;
        if (seriesLen == 0) {
            throw new IllegalArgumentException();
        }
    }

    private double predicateFinding(FindingPredicate predicate) {
        checkEmpty();
        double bestValue = tempSeries[0];
        for (double val: tempSeries) {
            if (predicate.compare(val, bestValue)) {
                bestValue = val;
            }
        }
        return bestValue;
    }

    private double[] append(double[] values, double... toAppend) {
        int valLen = values.length;
        int appendLen = toAppend.length;
        double[] data = new double[valLen + appendLen];
        int index = 0;
        for (int i = 0; i < valLen; ++i, ++index) {
            data[index] = values[i];
        }
        for (int j = 0; j < appendLen; ++j, ++index) {
            data[index] = toAppend[j];
        }
        return data;
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
            curSummon = (val - avg) * (val - avg);
            dev += curSummon;
        }
        dev /= serLen;
        dev = Math.sqrt(dev);
        return dev;
    }

    public double min() {
        FindingPredicate predicate = new FindingPredicate() {
            @Override
            public boolean compare(double a, double b) {
                return a < b;
            }
        };
        return predicateFinding(predicate);
    }

    public double max() {
        FindingPredicate predicate = new FindingPredicate() {
            @Override
            public boolean compare(double a, double b) {
                return a > b;
            }
        };
        return predicateFinding(predicate);
    }

    public double findTempClosestToZero() {
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue) {
        checkEmpty();
        final double comparingVal = tempValue;
        FindingPredicate predicate = new FindingPredicate() {
            @Override
            public boolean compare(double a, double b) {
                double a_diff = Math.abs(a - comparingVal);
                double b_diff = Math.abs(b - comparingVal);
                if (a_diff == b_diff && a > b) {
                    return true;
                }
                if (a_diff < b_diff) {
                    return true;
                }
                return false;
            }
        };
        return predicateFinding(predicate);
    }

    public double[] findTempsLessThen(double tempValue) {
        double[] values = {};
        for (double val: tempSeries) {
            if (val < tempValue) {
                values = append(values, val);
            }
        }
        return values;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        double[] values = {};
        for (double val: tempSeries) {
            if (val > tempValue) {
                values = append(values, val);
            }
        }
        return values;
    }

    public TempSummaryStatistics summaryStatistics() {
        checkEmpty();
        double avg = average();
        double deviation = deviation();
        double minimal = min();
        double maximal = max();
        return new TempSummaryStatistics(avg, deviation, minimal, maximal);
    }

    public int addTemps(double... temps) {
        int serLen = tempSeries.length;
        int tempsLen = temps.length;
        tempSeries = append(tempSeries, temps);
        return serLen + tempsLen;
    }
}
