package org.pensionplan.pensionplan;

import android.util.Log;

public class PensionModule {

    // Constants
    public static int LIFE_EXPECTANCE = 80;
    public static int RETIREMENT_AGE = 60;
    public static double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double annualincMonthly = 0.12;
    static double product;
    static int retireAge;

    double amountToHeir =30000;
    int currentAge = 23;

    double amountWithdrawal = 2000;



    // Life span after retirement
    public static double getLifespan(int compoundedTimes) {
        return PensionModule.LIFE_EXPECTANCE - RETIREMENT_AGE;
    }

    // End value
    public static double getEndValue(double amountToHeir, int currentAge) {
        double top = PensionModule.LIFE_EXPECTANCE - currentAge;
        double base = amountToHeir*(1+inflation);
        return Math.pow(base, top);
    }
    public static double getQuarterly(double inflation,double amountWithdrawal,int retirementAge,int currentAge, double product){
        double quarterly = 1 + inflation;
        int planningPeriod = retirementAge -  currentAge;
        double quarterlyPower = Math.pow(quarterly, planningPeriod);
        product = quarterlyPower *amountWithdrawal*3;
        return product;

    }
    //Withdrawal
    public static double getWithdrawal( double annualIncrease,int retirementAge, double inflation, double amountWithdrawal, int currentAge){
        double annualAdd = 1 + annualIncrease;
        int lifespan =(LIFE_EXPECTANCE -RETIREMENT_AGE);
        int lifespanSub =lifespan-1;

        return Math.pow(annualAdd*PensionModule.getQuarterly( inflation, amountWithdrawal, retirementAge, currentAge, product), lifespanSub);

    }
    public static double getPrewithdrawal(double amountToHeir,int currentAge,int retirementAge, double amountWithdrawal){


        double prewithdrawal = getEndValue(amountToHeir,currentAge)+ getWithdrawal(annualIncrease,retirementAge,inflation, amountWithdrawal,currentAge);
        return prewithdrawal;
    }

    // Beginning

    public static double getBeginning(double amountToHeir,int currentAge,int retirementAge, double amountWithdrawal,double interest, double compoundedTimes){
        double beginning = getPrewithdrawal(amountToHeir,currentAge,retirementAge,  amountWithdrawal)/ (1+(interest*compoundedTimes));

        Log.e("RESULT",String.valueOf(beginning));

        return beginning;
    }



}




