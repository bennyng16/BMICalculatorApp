package xyz.bennyng.bmicalculator;

import android.util.Log;

/**
 * Created by Benny on 8/29/2015.
 */
public class BMICalculator {
    public final static String TAG = BMICalculator.class.getSimpleName();
    private double mMass; // lbs
    private double mHeight; // inches


    public void setMass(double mass) {
        mMass = mass;
    }

    public void setHeight(double height) {
        mHeight = height;
    }

    public double getBMI() {
        double bmi = Math.round(mMass / (mHeight * mHeight) * 703 * 10);
        return bmi / 10;
    }
}
