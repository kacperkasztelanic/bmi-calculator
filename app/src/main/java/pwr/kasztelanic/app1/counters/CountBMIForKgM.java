package pwr.kasztelanic.app1.counters;

public class CountBMIForKgM implements ICountBMI
{
    private static final float MIN_MASS = 10.0f;
    private static final float MAX_MASS = 250.0f;
    private static final float MIN_HEIGHT = 0.5f;
    private static final float MAX_HEIGHT = 2.5f;

    @Override
    public float countBMI(float mass, float height)
    {
        if (!isValidMass(mass) || !isValidHeight(height))
            throw new IllegalArgumentException("Illegal mass or height value.");
        return mass / (height * height);
    }

    @Override
    public boolean isValidMass(float mass)
    {
        return mass >= MIN_MASS && mass <= MAX_MASS;
    }

    @Override
    public boolean isValidHeight(float height)
    {
        return height >= MIN_HEIGHT && height <= MAX_HEIGHT;
    }
}
