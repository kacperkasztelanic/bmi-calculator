package pwr.kasztelanic.app1;

import org.junit.Assert;
import org.junit.Test;

import pwr.kasztelanic.app1.utils.ImperialMetricsUnitsConverter;

public class ImperialToMetricConversionTest
{
    @Test
    public void LbToKgIsCorrect()
    {
//        GIVEN
        float testMassImperial = 200f;
//        THEN
        float testMassMetric = ImperialMetricsUnitsConverter.lbToKg(testMassImperial);
        Assert.assertEquals(testMassMetric, 90.718f, 0.01f);
    }

    @Test
    public void FtToMIsCorrect()
    {
//        GIVEN
        float testHeightImperial = 5.5f;
//        THEN
        float testHeightMetric = ImperialMetricsUnitsConverter.ftToM(testHeightImperial);
        Assert.assertEquals(testHeightMetric, 1.676f, 0.01f);
    }
}
