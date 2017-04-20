package org.pensionplan.pensionplan.utilities;

public class PensionModule {

	// Static fields
	public static int LIFE_EXPECTANCE = 80;
	public static int RETIREMENT_AGE = 60;
	public static double inflation = 0.12;
    public static double interest = 0.15;
    public static double annualIncrease = 0.12;
    public static double annualInterest = 0.22;
    public static double annualIncMonthly = 0.12;
    public static double compoundedTimesDep = 0.25;

	// Input fields
	private int currentAge;
	private int retirementAge;
	private int lifeExpectance;
	private double monthlyWithdrawal;
	private double amountToHeir;
	private double compoundedTimes;

	// Intermediate fields


	// Output field
	private double amountToDeposit;
	private double lumpSumWithdrawal;

	// Null constructor
	public PensionModule() {

	}

	// Initialization constructor
	public PensionModule(int currentAge, int retirementAge, int lifeExpectance,
			double monthlyWithdrawal, double amountToHeir, double compoundedTimes) {
		super();
		this.currentAge = currentAge;
		this.retirementAge = retirementAge;
		this.lifeExpectance = lifeExpectance;
		this.monthlyWithdrawal = monthlyWithdrawal;
		this.amountToHeir = amountToHeir;
		this.compoundedTimes = compoundedTimes;
		
		// Prepare output
		this.amountToDeposit = getMonthlyDep();
		this.lumpSumWithdrawal = calculate();
	}



	// Life span after retirement
	public double getLifespan() {
		return PensionModule.LIFE_EXPECTANCE - PensionModule.RETIREMENT_AGE;
	}

	// End value
	public double getEndValue() {
		double top = PensionModule.LIFE_EXPECTANCE - currentAge;
		double base = (1+PensionModule.inflation);
		return (Math.pow(base, top)) * this.amountToHeir;
	}
	
	// Quarterly contribution
	public double getQuarterly(){
		double quarterly = 1 + PensionModule.inflation;
		int planningPeriod = retirementAge -  currentAge;
		double quarterlyPower = Math.pow(quarterly, planningPeriod);
		return quarterlyPower * monthlyWithdrawal * 3;


	}
	
	//Withdrawal
	public double getWithdrawal(){
		double annualAdd = 1 + annualIncrease;
		int lifespan =(LIFE_EXPECTANCE -RETIREMENT_AGE);
		int lifespanSub =lifespan-1;
		return (Math.pow(annualAdd,lifespanSub)) * getQuarterly();


	}
	public double getPrewithdrawal(){
		double prewithdrawal = getEndValue()+ getWithdrawal();
		return prewithdrawal;
	}

	// Beginning

	public double getBeginning(){
		double Beginning = getPrewithdrawal()/(1 +(interest*compoundedTimesDep));
		return Beginning;

	}

	public double calculate(){

		double finalResult = 0.0;
		double finalResultTwo,NewPrewithdrawal,withdrawal;
		double BeginningValue = getBeginning();
		double lifespan = getLifespan();
		double currentWith = getWithdrawal();

		while(lifespan > 1.0)

		{
			double lifespanVal = lifespan;
			lifespanVal*=10;
			int checklifespan =(int) (lifespanVal % 10);

			if(checklifespan ==0){
				withdrawal = currentWith /(1 + annualIncrease);
				finalResult = BeginningValue;
                NewPrewithdrawal = finalResult + withdrawal;
				finalResultTwo = NewPrewithdrawal/(1+(interest * compoundedTimesDep));
                currentWith = withdrawal;
				BeginningValue = finalResultTwo;

			}
			else {
				withdrawal =currentWith;
				finalResult = BeginningValue;
				NewPrewithdrawal = finalResult + withdrawal;
				finalResultTwo = NewPrewithdrawal/(1+(interest * compoundedTimesDep));
				currentWith = withdrawal;
				BeginningValue = finalResultTwo;

			}

			lifespan = lifespan - compoundedTimesDep;
		};
		return Math.round(BeginningValue * 100)/100;
	}

	public double getImpliedInterest(){
		double ImpliedInterest = (1 + annualInterest);
		double InverseCompoundedTimes = 1/compoundedTimes;
		double result = (((Math.pow(ImpliedInterest, InverseCompoundedTimes)) -1) * compoundedTimes)* 100;

		return result;
	}
	public double getImpliedGrowth(){
		double ImpliedGrowth = (1 + annualIncrease);
		double InverseCompoundedTimes = 1/compoundedTimes;
		double result = (((Math.pow(ImpliedGrowth, InverseCompoundedTimes)) -1) * compoundedTimes)* 100;

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
	public double getGresult(){

		double Gresult = getImpliedGrowth() /compoundedTimes;
		double GresultAns =Math.round(Gresult*100)*10;//)/100;
		return GresultAns/1000;
		//return GresultAns;
	}

	public double getMonthlyDep(){
		double AddInterest = 1 + (getRresult()/ 100);
		double AddGrowth = 1 + (getGresult() / 100);
		//double InterestGrowth = Math.pow(AddGrowth, getNresult(compoundedTimes, currentAge));
		double quartelyCompounded = 12/compoundedTimes;
		//double DifferenceOf =getRresult(compoundedTimes) - getGresult(compoundedTimes);
		double DifferenceOf = (Math.ceil((getRresult() - getGresult())*100)*10)/1000;

		double InterestGrowth = Math.pow(AddInterest, getNresult())- Math.pow(AddGrowth, getNresult());;
		double Temp =  (InterestGrowth/(DifferenceOf/100));
		double MonthlyDep = calculate()/Temp;

		double finalMonththly = MonthlyDep /(quartelyCompounded);

		return 	Math.round(finalMonththly *100)/100;
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

	public void setMonthlyWithdrawal(double monthlyWithdrawal) {
		this.monthlyWithdrawal = monthlyWithdrawal;
	}

	public void setAmountToHeir(double amountToHeir) {
		this.amountToHeir = amountToHeir;
	}

	public double getAmountToDeposit() {
		return amountToDeposit;
	}

	public double getLumpSumWithdrawal() {
		return lumpSumWithdrawal;
	}

	


}
