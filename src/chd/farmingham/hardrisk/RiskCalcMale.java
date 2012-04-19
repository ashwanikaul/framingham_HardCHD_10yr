package chd.farmingham.hardrisk;

import java.util.TreeMap;

import org.ehr.model.Patient;

public class RiskCalcMale extends RiskCalc{
	
	int[] tenYearMaleRisk  = {1,1,1,1,1,2,2,3,4,5,6,8,10,12,16,20,25};
	
	public RiskCalcMale(Patient patient) {
		super();
		
		this.patient = patient;
		
		ageMap = new TreeMap<Integer,Integer>();
		ageMap.put(20,- 9);
		ageMap.put(35,- 4);
		ageMap.put(40,0);
		ageMap.put(45,3);
		ageMap.put(50,6);
		ageMap.put(55,8);
		ageMap.put(60,10);
		ageMap.put(65,11);
		ageMap.put(70,12);
		ageMap.put(75,13);
		
		this.hdlMap = new TreeMap<Integer,Integer>();
		hdlMap.put(40,1);
		hdlMap.put(50,0);
		hdlMap.put(60,-1);
		
		this.sbpMap_treated = new TreeMap<Integer,Integer>();
		sbpMap_treated.put(120, 1);
		sbpMap_treated.put(130, 2);
		sbpMap_treated.put(140, 2);
		sbpMap_treated.put(160, 3);

		this.sbpMap_untreated = new TreeMap<Integer,Integer>();
		sbpMap_untreated.put(120, 0);
		sbpMap_untreated.put(130, 1);
		sbpMap_untreated.put(140, 1);
		sbpMap_untreated.put(160, 2);

		this.smokerMap = new TreeMap<Integer,Integer>();
		smokerMap.put(20,8);
		smokerMap.put(40,5);
		smokerMap.put(50,3);
		smokerMap.put(60,1);
		smokerMap.put(70,1);
		
		this.totalCholestrolMap = new TreeMap<Integer,Integer[]>();
		totalCholestrolMap.put(160, new Integer[] {4,3,2,1,0});
		totalCholestrolMap.put(200, new Integer[] {7,5,3,1,0});
		totalCholestrolMap.put(240, new Integer[] {9,6,4,2,1});
		totalCholestrolMap.put(280, new Integer[] {11,8,5,3,1});

		this.tchAgeMap = new TreeMap<Integer,Integer>();
		tchAgeMap.put(20,0);
		tchAgeMap.put(40,1);
		tchAgeMap.put(50,2);
		tchAgeMap.put(60,3);
		tchAgeMap.put(70,4);
	}
	
	public int getTenYearRisk(){
		this.setTotalPoints();
	
		if (this.patient.getPoints() < 0 )
			return 0; //Less than 1
		else if (this.patient.getPoints() >= 17)
			return 30; //Greater than equal to 30
		else
			return tenYearMaleRisk[this.patient.getPoints()];
	}
	
	
}
