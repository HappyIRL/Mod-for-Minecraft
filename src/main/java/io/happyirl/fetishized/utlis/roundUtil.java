package io.happyirl.fetishized.utlis;

public class roundUtil
{
    public static double roundDouble (double number)
    {
        //round number to 1/100th
        number = Math.round(number * 100) / 100d;
        //fix floating point error due to it being stored as binary
        return Math.nextAfter(number, number + Math.signum(number));
    }
}
