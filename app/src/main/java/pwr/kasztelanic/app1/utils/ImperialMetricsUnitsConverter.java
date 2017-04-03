package pwr.kasztelanic.app1.utils;

public class ImperialMetricsUnitsConverter
{
    private static final float LB_TO_KG_RATIO = 0.45359237f;
    private static final float FT_TO_M_RATIO = 0.3048f;

    public static float lbToKg(float lb)
    {

        return LB_TO_KG_RATIO * lb;
    }

    public static float ftToM(float ft)
    {

        return FT_TO_M_RATIO * ft;
    }

    public static float kgToLb(float kg)
    {
        return 1 / LB_TO_KG_RATIO * kg;
    }

    public static float mToFt(float m)
    {
        return 1 / FT_TO_M_RATIO * m;
    }
}
