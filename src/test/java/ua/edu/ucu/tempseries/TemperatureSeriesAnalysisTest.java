package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Ignore;

public class TemperatureSeriesAnalysisTest {

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {0, 6, 8, 14};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5;

        double actualResult = seriesAnalysis.deviation();

        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {0, 6, -5, 14};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -5;

        double actualResult = seriesAnalysis.min();

        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {0, 6, -5, 14};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 14;

        double actualResult = seriesAnalysis.max();

        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test
    public void testFindTempClosestToZero() {
        double[] temperatureSeries = {42, -111, 5, -3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -3;

        double actualResult = seriesAnalysis.findTempClosestToZero();

        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test
    public void testFindTempClosestToValue() {
        double[] temperatureSeries = {42, -111, 5, -3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 5;

        double actualResult = seriesAnalysis.findTempClosestToValue(1);

        assertEquals(expResult, actualResult, 0.0001);
    }

    @Test
    public void testFindTempsLessThen() {
        double[] temperatureSeries = {42, -111, 5, -3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {-111};
        double anchor = -53;

        double[] actualResult = seriesAnalysis.findTempsLessThen(anchor);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThen() {
        double[] temperatureSeries = {42, -111, 5, -3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expResult = {42, 5};
        double anchor = 3;

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(anchor);

        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {42, -111, 5, -3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        int expResult = 6;
        double[] toAppend = {2, 0};

        int actualResult = seriesAnalysis.addTemps(toAppend);

        assertEquals(expResult, actualResult);
    }
}
