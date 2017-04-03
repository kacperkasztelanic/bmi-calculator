package pwr.kasztelanic.app1;

import org.junit.Assert;
import org.junit.Test;

import pwr.kasztelanic.app1.utils.WeightJudge;
import pwr.kasztelanic.app1.utils.WeightStatus;

public class WeightJudgeTest
{
    @Test
    public void ObesityThresholdIsCorrect()
    {
//        GIVEN
        float bmi = 30.0f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OBESITY);
    }

    @Test
    public void ObesityIsCorrect()
    {
//        GIVEN
        float bmi = 35.0f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OBESITY);
    }

    @Test
    public void OverweightThresholdIsCorrect()
    {
//        GIVEN
        float bmi = 25.0f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OVERWEIGHT);
    }

    @Test
    public void OverweightIsCorrect()
    {
//        GIVEN
        float bmi = 27f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OVERWEIGHT);
    }

    @Test
    public void UnderweightThresholdIsCorrect()
    {
//        GIVEN
        float bmi = 18.5f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.UNDERWEIGHT);
    }

    @Test
    public void UnderweightIsCorrect()
    {
//        GIVEN
        float bmi = 18.0f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.UNDERWEIGHT);
    }

    @Test
    public void CorrectWeightMinimumThresholdIsCorrect()
    {
//        GIVEN
        float bmi = 18.51f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OK);
    }

    @Test
    public void CorrectWeightMaximumThresholdIsCorrect()
    {
//        GIVEN
        float bmi = 24.99f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OK);
    }

    @Test
    public void CorrectWeightIsCorrect()
    {
//        GIVEN
        float bmi = 20f;
//        THEN
        Assert.assertEquals(WeightJudge.getStatus(bmi), WeightStatus.OK);
    }
}
