package org.pensionplan.pensionplan.Fragments;

/**
 * Created by owner on 4/14/2017.
 */

public class PensionModule {


    // Constants
    public static int LIFE_EXPECTANCE = 80;
    public static int RETIREMENT_AGE = 60;
    public static double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double annualIncMonthly = 0.12;
    public static double compoundedTimes = 0.25;
    //public static double BeginningValue;

    // public static double withdrawal;


    // Life span after retirement
    public static double getLifespan() {
        return PensionModule.LIFE_EXPECTANCE - RETIREMENT_AGE;
    }

    // End value
    public static double getEndValue(double amountToHeir, int currentAge) {
        double top = PensionModule.LIFE_EXPECTANCE - currentAge;
        double base = (1 + inflation);
        return (Math.pow(base, top)) * amountToHeir;
    }

    public static double getQuarterly(double inflation, double amountWithdrawal, int retirementAge, int currentAge) {
        double quarterly = 1 + inflation;
        int planningPeriod = retirementAge - currentAge;
        double quarterlyPower = Math.pow(quarterly, planningPeriod);
        return quarterlyPower * amountWithdrawal * 3;


    }

    //Withdrawal
    public static double getWithdrawal(double annualIncrease, int retirementAge, double inflation, double amountWithdrawal, int currentAge) {
        double annualAdd = 1 + annualIncrease;
        int lifespan = (LIFE_EXPECTANCE - RETIREMENT_AGE);
        int lifespanSub = lifespan - 1;
        return (Math.pow(annualAdd, lifespanSub)) * getQuarterly(inflation, amountWithdrawal, retirementAge, currentAge);


    }

    public static double getPrewithdrawal(double amountToHeir, int currentAge, int retirementAge, double amountWithdrawal) {


        double prewithdrawal = getEndValue(amountToHeir, currentAge) + getWithdrawal(annualIncrease, retirementAge, inflation, amountWithdrawal, currentAge);
        return prewithdrawal;
    }

    // Beginning

    public static double getBeginning(double amountToHeir, int currentAge, int retirementAge, double amountWithdrawal, double interest, double compoundedTimes) {
        double Beginning = getPrewithdrawal(amountToHeir, currentAge, retirementAge, amountWithdrawal) / (1 + (interest * compoundedTimes));
        return Beginning;

    }

    public static double calculate(double amountToHeir, int currentAge, double amountWithdrawal) {

        double finalResult = 0.0;
        double finalResultTwo, NewPrewithdrawal, withdrawal;


        double BeginningValue = getBeginning(amountToHeir, currentAge, RETIREMENT_AGE, amountWithdrawal, interest, compoundedTimes);

        double lifespan = getLifespan();

        double currentWith = PensionModule.getWithdrawal(annualIncrease, RETIREMENT_AGE, inflation, amountWithdrawal, currentAge);


        while (lifespan > 1.0)

        {

            double lifespanVal = lifespan;
            lifespanVal *= 10;
            int checklifespan = (int) (lifespanVal % 10);

            System.out.println("Life Span = " + lifespan);


            if (checklifespan == 0) {
                withdrawal = currentWith / (1 + annualIncrease);
                finalResult = BeginningValue;

                NewPrewithdrawal = finalResult + withdrawal;
                finalResultTwo = NewPrewithdrawal / (1 + (interest * compoundedTimes));

                currentWith = withdrawal;
                BeginningValue = finalResultTwo;

            } else {
                withdrawal = currentWith;
                finalResult = BeginningValue;
                NewPrewithdrawal = finalResult + withdrawal;
                finalResultTwo = NewPrewithdrawal / (1 + (interest * compoundedTimes));
                System.out.println("Beginning value = " + BeginningValue);
                currentWith = withdrawal;
                BeginningValue = finalResultTwo;

            }

            lifespan -= compoundedTimes;


        }
        ;


        return BeginningValue;
    }

    public static double getImpliedInterest(double annualInterest, double compoundedTimes) {
        double ImpliedInterest = (1 + annualInterest);
        double InverseCompoundedTimes = 1 / compoundedTimes;
        double result = (((Math.pow(ImpliedInterest, InverseCompoundedTimes)) - 1) * compoundedTimes) * 100;

        return result;
    }

    public static double getImpliedGrowth(double annualIncrease, double compoundedTimes) {
        double ImpliedGrowth = (1 + annualIncrease);
        double InverseCompoundedTimes = 1 / compoundedTimes;
        double result = (((Math.pow(ImpliedGrowth, InverseCompoundedTimes)) - 1) * compoundedTimes) * 100;

        return result;
    }

    public static double getRresult(double compoundedTimes) {

        double Rresult = getImpliedInterest(annualInterest, compoundedTimes) / compoundedTimes;
        double RresultAns = Math.round(Rresult * 100) * 10;//)/100;
        return RresultAns / 1000;
    }

    public static double getNresult(double compoundedTimes, double currentAge) {
        //planningPeriod = getPlanningPeriod(currentAge)

        double PlanningPeriod = RETIREMENT_AGE - currentAge;

        double Nresult = PlanningPeriod * compoundedTimes;


        return Nresult;
    }

    public static double getGresult(double compoundedTimes) {

        double Gresult = getImpliedGrowth(annualIncrease, compoundedTimes) / compoundedTimes;
        double GresultAns = Math.round(Gresult * 100) * 10;//)/100;
        return GresultAns / 1000;
        //return GresultAns;
    }

    public static double getMonthlyDep(double compoundedTimes, int currentAge, double amountToHeir, double amountWithdrawal) {
        double AddInterest = 1 + (getRresult(compoundedTimes) / 100);
        double AddGrowth = 1 + (getGresult(compoundedTimes) / 100);
        //double InterestGrowth = Math.pow(AddGrowth, getNresult(compoundedTimes, currentAge));
        double quartelyCompounded = 12 / compoundedTimes;
        //double DifferenceOf =getRresult(compoundedTimes) - getGresult(compoundedTimes);
        double DifferenceOf = (Math.ceil((getRresult(compoundedTimes) - getGresult(compoundedTimes)) * 100) * 10) / 1000;

        double InterestGrowth = Math.pow(AddInterest, getNresult(compoundedTimes, currentAge)) - Math.pow(AddGrowth, getNresult(compoundedTimes, currentAge));
        ;
        double Temp = (InterestGrowth / (DifferenceOf / 100));
        double MonthlyDep = calculate(amountToHeir, currentAge, amountWithdrawal) / Temp;

        double finalMonththly = MonthlyDep / (quartelyCompounded);

        return finalMonththly;
    }
}




