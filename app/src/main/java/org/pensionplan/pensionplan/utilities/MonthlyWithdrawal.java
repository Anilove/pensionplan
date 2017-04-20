package org.pensionplan.pensionplan.utilities;

/**
 * Created by owner on 4/20/2017.
 */

public class MonthlyWithdrawal {

    // Constants
    public static int LIFE_EXPECTANCE = 80;
    public static int RETIREMENT_AGE = 60;
    public static double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double annualWith = 0.12;
    public static double compoundedTimesDec = 0.25;

    // Input fields
    private int currentAge;
    private int retirementAge;
    private int lifeExpectance;
    private double RegularMonDep;
    private double amountToHeir;
    private double compoundedTimes;
    private double FirstLumpsumWith;

    // Intermediate fields


    // Output field
    private double amountWithdrawal;
    private double lumpSumWithdrawal;

    // Null constructor
    public MonthlyWithdrawal(int currentAge, int retirementAge, int lifeExpectance
            ,double FirstLumpsumWith,double RegularMonDep, double amountToHeir, double compoundedTimes) {
        super();
        this.currentAge = currentAge;
        this.retirementAge = retirementAge;
        this.lifeExpectance = lifeExpectance;
        this.FirstLumpsumWith = FirstLumpsumWith;
        this.RegularMonDep = RegularMonDep;
        this.amountToHeir = amountToHeir;
        this.compoundedTimes = compoundedTimes;

        // Prepare output
        this.amountWithdrawal = getMonthlyWithdrawal();
        this.lumpSumWithdrawal = getLumpsumWithdrawal();
    }


    // Life span after retirement
    public double getLifespan() {
        return MonthlyWithdrawal.LIFE_EXPECTANCE - RETIREMENT_AGE;
    }

    public double getPlanningPeriod() {
        return MonthlyWithdrawal.RETIREMENT_AGE - currentAge;
    }
    public double getImpliedInterest( ){
        double ImpliedInterest = (1 + annualInterest);
        double InverseCompoundedTimes = 1/compoundedTimes;
        double result = (((Math.pow(ImpliedInterest, InverseCompoundedTimes)) -1) * compoundedTimes)* 100;

        return result;
    }
    public double getRresult(){

        double Rresult = getImpliedInterest() /compoundedTimes;
        double RresultAns =Math.round(Rresult*100)*10;//)/100;
        return RresultAns/1000;
    }
    public double getNresult(){
        double Nresult =getPlanningPeriod()* compoundedTimes;
        return Nresult;
    }
    public double getImpliedGrowth(){
        double ImpliedGrowth = (1 + annualIncrease);
        double InverseCompoundedTimes = 1/compoundedTimes;
        double result = (((Math.pow(ImpliedGrowth, InverseCompoundedTimes)) -1) * compoundedTimes)* 100;

        return result;
    }
    public double getGresult(){

        double Gresult = getImpliedGrowth() /compoundedTimes;
        double GresultAns =Math.round(Gresult*100)*10;//)/100;
        return GresultAns/1000;
    }
    public double getMonthlyWith(){
        double NewAddInterest = 1 + getRresult()/100;
        double NewAddGrowth = 1 + getGresult()/100;
        double quartelyCompounded = 12/compoundedTimes;
        double DifferenceOf = (((Math.ceil((getRresult() - getGresult())*100)*10)/1000)/100);

        double InterestGrowthTemp = Math.pow(NewAddInterest, getNresult())- Math.pow(NewAddGrowth, getNresult());
        double InterestGrowth = Math.round(InterestGrowthTemp*100);
        InterestGrowth /= 100;
        double Temp = Math.round((InterestGrowth/(DifferenceOf))*100);
        Temp /= 100;

        double MonthlyWith = RegularMonDep * Temp * quartelyCompounded;

        return MonthlyWith;
    }

    public double getFutureLumpsumWithdrawal(){
        double Temp = 1 +inflation;
        double FVLumpsumWith = Math.pow(Temp,getPlanningPeriod());
        double LumpsumWith =FirstLumpsumWith*FVLumpsumWith;
        return LumpsumWith;

    }
    public double getBeginningValue(){
        double BeginningValue = getMonthlyWith()- getFutureLumpsumWithdrawal();
        return BeginningValue;

    }
    public double InterestThreeMonth(){
        double InterestRate = interest*(getBeginningValue()/4);
        return InterestRate;
    }

    public double getWithdrawal(){
        double Withdrawal = 379002.13;
        return Withdrawal;
    }
    public double getReInvestment(){
        double ReInvestment = InterestThreeMonth()-getWithdrawal();
        return ReInvestment;
    }


    public double getMonthlyWithdrawal(){
        double beginning = Math.round(getWithdrawal()/3*100);
        beginning /=100;
        double divinflation = 1 + inflation;
        double divinflationtemp = Math.pow(divinflation,getPlanningPeriod());
        double MonthWith = beginning/divinflationtemp;
        double NewMonthWith = Math.round(MonthWith);
        return NewMonthWith;
    }

    public double getLumpsumWithdrawal(){
        double Divinflation = 1 + inflation;
        double divinflationtemp = Math.pow(Divinflation,getPlanningPeriod());
        double Temp = FirstLumpsumWith * divinflationtemp;
        double LumpsumWithdrawal = getMonthlyWith() + Temp;
        return Math.round(LumpsumWithdrawal);
    }



    public void setCurrentAge(int currentAge) {
        this.currentAge = currentAge;
    }

    public void setRetirementAge(int retirementAge) {
        this.retirementAge = retirementAge;
    }

    public void setLifeExpectance(int lifeExpectance) {
        this.lifeExpectance = lifeExpectance;
    }


    public void setRegularMonDep(double regularMonDep) {
        RegularMonDep = regularMonDep;
    }


    public void setFirstLumpsumWith(double firstLumpsumWith) {
        FirstLumpsumWith = firstLumpsumWith;
    }


    public void setAmountToHeir(double amountToHeir) {
        this.amountToHeir = amountToHeir;
    }

    public void setCompoundedTimes(double compoundedTimes) {
        this.compoundedTimes = compoundedTimes;
    }

    public double getLumpSumWithdrawal() {
        return lumpSumWithdrawal;
    }


    public double getAmountWithdrawal() {
        return amountWithdrawal;
    }


}
