package org.pensionplan.pensionplan.utilities;

/**
 * Created by owner on 4/20/2017.
 */

public class LumpsumWithdrawal {


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
    double LumpsumDep;
    private double compoundedTimes;

    // Intermediate fields


    // Output field
    private double InitlumpsumWithdrawal;
    private double currentequivalent;

    // Null constructor
    public LumpsumWithdrawal(int currentAge, int retirementAge, int lifeExpectance,
                             double LumpsumDep,double compoundedTimes) {
        super();
        this.currentAge = currentAge;
        this.retirementAge = retirementAge;
        this.lifeExpectance = lifeExpectance;
        this.LumpsumDep = LumpsumDep;
        this.compoundedTimes = compoundedTimes;

        // Prepare output
        this.InitlumpsumWithdrawal= getLumpsumWith();
        this.currentequivalent = getcurrentequivalent();
    }


    // Life span after retirement
    public double getLifespan() {
        return MonthlyWithdrawal.LIFE_EXPECTANCE - RETIREMENT_AGE;
    }

    public double getPlanningPeriod() {
        return MonthlyWithdrawal.RETIREMENT_AGE - currentAge;
    }
    public double getImpliedInterest(){
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
    public double getLumpsumWith(){
        double NewAddInterest = 1 + getRresult()/100;
        double NewAddGrowth = 1 + getGresult()/100;
        double quartelyCompounded = 12/compoundedTimes;
        double DifferenceOf = (((Math.ceil((getRresult() - getGresult())*100)*10)/1000)/100);

        double InterestGrowthTemp = Math.pow(NewAddInterest, getNresult())- Math.pow(NewAddGrowth, getNresult());
        double InterestGrowth = Math.round(InterestGrowthTemp*100);
        InterestGrowth /= 100;
        double Temp = Math.round((InterestGrowth/(DifferenceOf))*100);
        Temp /= 100;

        double MonthlyWith = LumpsumDep * Temp * quartelyCompounded;

        return MonthlyWith;
    }
    public double getPrincipal(){
        double Principal =  31303110.27;
        return Principal;

    }
    public double getLumpsumWithdrawal(){
        double LumpsumWithdrawalRetire = getLumpsumWith()- getPrincipal();

        return LumpsumWithdrawalRetire;
    }
    public double getcurrentequivalent() {

        double divinflation = 1 + inflation;
        double divinflationtemp = Math.pow(divinflation,getPlanningPeriod());
        double Total = getLumpsumWithdrawal()/divinflationtemp;
        double TotalLumpsumWithdrawal=	Math.round(Total*100);
        TotalLumpsumWithdrawal /= 100;
        return TotalLumpsumWithdrawal;
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


    public void setLumpsumInvested(double lumpsumInvested) {
        this.LumpsumDep = lumpsumInvested;
    }


    public double getInitlumpsumWithdrawal() {
        return InitlumpsumWithdrawal;
    }


    public double getCurrentequivalent() {
        return currentequivalent;
    }



}
