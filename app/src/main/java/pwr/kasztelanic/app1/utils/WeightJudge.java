package pwr.kasztelanic.app1.utils;

public class WeightJudge
{
    private static final float UNDERWEIGHT_THRESHOLD = 18.5f;
    private static final float OVERWEIGHT_THRESHOLD = 25.0f;
    private static final float OBESITY_THRESHOLD = 30.0f;

    public static WeightStatus getStatus(float bmi)
    {
        if (isObese(bmi))
            return WeightStatus.OBESITY;
        if (isOverweight(bmi))
            return WeightStatus.OVERWEIGHT;
        if (isUnderweight(bmi))
            return WeightStatus.UNDERWEIGHT;
        return WeightStatus.OK;
    }

    private static boolean isObese(float bmi)
    {

        return bmi >= OBESITY_THRESHOLD;
    }

    private static boolean isOverweight(float bmi)
    {

        return bmi >= OVERWEIGHT_THRESHOLD;
    }

    private static boolean isUnderweight(float bmi)
    {

        return bmi <= UNDERWEIGHT_THRESHOLD;
    }
}
