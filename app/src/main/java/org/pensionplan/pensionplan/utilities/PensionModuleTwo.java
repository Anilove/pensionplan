package org.pensionplan.pensionplan.utilities;

/**
 * Created by owner on 4/20/2017.
 */

public class PensionModuleTwo {

        // Constants
        public static int LIFE_EXPECTANCE = 85;
        public static int RETIREMENT_AGE = 60;
        public static double inflation = 0.12;
        public static double interest = 0.15;
        public static double annualIncrease = 0.12;
        public static double annualInterest = 0.22;
        public static double annualincMonthly = 0.12;
        public static double compoundedTimesDec = 0.25;

        // Input fields
        private int currentAge;
        private int retirementAge;
        private int lifeExpectance;
        private  double amountWithdrawal;
        private double compoundedTimes;

        // Intermediate fields


        // Output field
        private double lumpsumToDeposit;
        private double quarterlyWithdrawal;

        // Null constructor
        public PensionModuleTwo() {

        }

        // Initialization constructor
        public PensionModuleTwo(int currentAge, int retirementAge, int lifeExpectance,
                                double amountWithdrawal,double compoundedTimes) {
            super();
            this.currentAge = currentAge;
            this.retirementAge = retirementAge;
            this.lifeExpectance = lifeExpectance;
            this.amountWithdrawal = amountWithdrawal;
            this.compoundedTimes = compoundedTimes;

            // Prepare output
            this.lumpsumToDeposit = getLumpsumReq();
            this.quarterlyWithdrawal = getQuarterly();
        }
        // Life span after retirement
        public static double getLifespan() {
            return PensionModuleTwo.LIFE_EXPECTANCE - RETIREMENT_AGE;
        }

        // End value


        public  double getQuarterly(){
            double quarterly = 1 + inflation;
            int planningPeriod = RETIREMENT_AGE -  currentAge;
            double quarterlyPower = Math.pow(quarterly, planningPeriod);
            return quarterlyPower * amountWithdrawal *3;

        }
        //Withdrawal
        public double getWithdrawal(){
            double annualAdd = 1 + annualIncrease;
            double lifespan =getLifespan();
            double lifespanSub = lifespan-1;
            return (Math.pow(annualAdd,lifespanSub)) * getQuarterly();

        }
        public double getPrewithdrawal(){
            double EndValue =0.0;

            double prewithdrawal = EndValue + getWithdrawal();
            return prewithdrawal;
        }
        // Beginning

        public double getBeginning(){
            double Beginning = getPrewithdrawal()/(1 +(interest*compoundedTimesDec));
            return Beginning;

        }

        public double getCalculate(){
            double finalResult = 0.0;
            double finalResultTwo,NewPrewithdrawal,withdrawal;
            double BeginningValue = getBeginning();
            double lifespan = getLifespan();
            double currentWith = getWithdrawal();
            double AddAnnualIncrease =(1 + annualIncrease);


            while(lifespan > 1.0)

            {
                if(lifespan !=0.75)
                {
                    double lifespanVal = lifespan;
                    lifespanVal*=10;
                    int checklifespan =(int) (lifespanVal % 10);

                    if(checklifespan == 0){
                        withdrawal = currentWith /AddAnnualIncrease;
                        //System.out.println("currentWith"+ withdrawal);
                        finalResult = BeginningValue;
                        System.out.println("Beginning value = "+BeginningValue);
                        NewPrewithdrawal = finalResult + withdrawal;
                        finalResultTwo = NewPrewithdrawal/(1+(interest * compoundedTimesDec));
                        currentWith = withdrawal;
                        BeginningValue = finalResultTwo;


                    } else if(checklifespan != 0){
                        withdrawal =currentWith;
                        finalResult = BeginningValue;
                        NewPrewithdrawal = finalResult + withdrawal;
                        finalResultTwo = NewPrewithdrawal/(1+(interest * compoundedTimesDec));
                        currentWith = withdrawal;
                        BeginningValue = finalResultTwo;

                    }

                    lifespan -= compoundedTimesDec;

                }

            };
            //double FinalBeginningValue = (Math.round(BeginningValue)*100);
            return BeginningValue;
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
            //planningPeriod = getPlanningPeriod(currentAge)

            double PlanningPeriod =RETIREMENT_AGE - currentAge ;

            double Nresult = PlanningPeriod* compoundedTimes;


            return Nresult;
        }
        public double getLumpsumReq(){
            double InterestN = 1 + (getRresult()/100);
            double temp =  getNresult();
            double powInterest= (Math.round((Math.pow(InterestN,temp))*100)*10);
            double powInterestN = powInterest/1000;


            double Lumpsum = getCalculate()/powInterestN;
            return Lumpsum;
        }

        // Setters
        public void setCurrentAge(int currentAge) {
            this.currentAge = currentAge;
        }

        public void setRetirementAge(int retirementAge) {
            this.retirementAge = retirementAge;
        }

        public void setLifeExpectance(int lifeExpectance) {
            this.lifeExpectance = lifeExpectance;
        }


        public void setAmountWithdrawal(double amountWithdrawal) {
            this.amountWithdrawal = amountWithdrawal;
        }

        public double getlumpsumToDeposit() {
            return lumpsumToDeposit;
        }

        public double getquarterlyWithdrawal() {
            return quarterlyWithdrawal;
        }

    }


