package pwr.kasztelanic.app1.counters;

public interface ICountBMI
{
    float countBMI(float mass, float height);

    boolean isValidMass(float mass);

    boolean isValidHeight(float height);
}
