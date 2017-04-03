package pwr.kasztelanic.app1;

import org.junit.Assert;

import org.junit.Test;

import pwr.kasztelanic.app1.counters.CountBMIForKgM;
import pwr.kasztelanic.app1.counters.ICountBMI;
import pwr.kasztelanic.app1.utils.ImperialMetricsUnitsConverter;

public class CountBMITest
{
    @Test
    public void massUnderZeroIsIncorrect()
    {
//        GIVEN
        float testMass = -1.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertFalse(countBMI.isValidMass(testMass));
    }

    @Test
    public void minMassIsCorrect()
    {
//        GIVEN
        float testMass = 10.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertTrue(countBMI.isValidMass(testMass));
    }

    @Test
    public void maxMassIsCorrect()
    {
//        GIVEN
        float testMass = 250.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertTrue(countBMI.isValidMass(testMass));
    }

    @Test
    public void massOverMaxIsIncorrect()
    {
//        GIVEN
        float testMass = 251.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertFalse(countBMI.isValidMass(testMass));
    }

    @Test
    public void massBetweenMinAndMaxIsCorrect()
    {
//        GIVEN
        float testMass = 90.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertTrue(countBMI.isValidMass(testMass));
    }

    @Test
    public void heightUnderZeroIsIncorrect()
    {
//        GIVEN
        float testHeight = -1.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertFalse(countBMI.isValidHeight(testHeight));
    }

    @Test
    public void minHeightIsCorrect()
    {
//        GIVEN
        float testHeight = 0.5f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertTrue(countBMI.isValidHeight(testHeight));
    }

    @Test
    public void maxHeightIsCorrect()
    {
//        GIVEN
        float testHeight = 2.5f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertTrue(countBMI.isValidHeight(testHeight));
    }

    @Test
    public void heightOverMaxIsIncorrect()
    {
//        GIVEN
        float testHeight = 2.6f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertFalse(countBMI.isValidHeight(testHeight));
    }

    @Test
    public void heightBetweenMinAndMaxIsCorrect()
    {
//        GIVEN
        float testHeight = 2.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertTrue(countBMI.isValidHeight(testHeight));
    }

    @Test
    public void calculationInMetricIsCorrect()
    {
//        GIVEN
        float testMass = 100f;
        float testHeight = 2.0f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        Assert.assertEquals(countBMI.countBMI(testMass, testHeight), 25f, 0.01f);
    }

    @Test
    public void calculationInImperialIsCorrect()
    {
//        GIVEN
        float testMassImperial = 200f;
        float testHeightImperial = 6.234f;
//        WHEN
        ICountBMI countBMI = new CountBMIForKgM();
//        THEN
        float testMass = ImperialMetricsUnitsConverter.lbToKg(testMassImperial);
        float testHeight = ImperialMetricsUnitsConverter.ftToM(testHeightImperial);
        Assert.assertEquals(countBMI.countBMI(testMass, testHeight), 25.12f, 0.01f);
    }
}
