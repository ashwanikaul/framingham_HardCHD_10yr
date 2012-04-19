package chd.farmingham.hardrisk;

import java.util.HashMap;
import java.util.TreeMap;

import org.ehr.model.Patient;

public class RiskCalcFemale extends RiskCalc{
	
	private HashMap<Integer,Integer> tenYearFemaleRisk;
	
	public RiskCalcFemale(Patient patient) {
		super();
		
		this.patient = patient;
		
		tenYearFemaleRisk = new HashMap<Integer,Integer>();
		tenYearFemaleRisk.put(9,1);
		tenYearFemaleRisk.put(10,1);
		tenYearFemaleRisk.put(11,1);
		tenYearFemaleRisk.put(12,1);
		tenYearFemaleRisk.put(13,2);
		tenYearFemaleRisk.put(14,2);
		tenYearFemaleRisk.put(15,3);
		tenYearFemaleRisk.put(16,4);
		tenYearFemaleRisk.put(17,5);
		tenYearFemaleRisk.put(18,6);
		tenYearFemaleRisk.put(19,8);
		tenYearFemaleRisk.put(20,11);
		tenYearFemaleRisk.put(21,14);
		tenYearFemaleRisk.put(22,17);
		tenYearFemaleRisk.put(23,22);
		tenYearFemaleRisk.put(24,27);
		
		
		ageMap = new TreeMap<Integer,Integer>();
		ageMap.put(20,-7);
		ageMap.put(35,-3);
		ageMap.put(40,0);
		ageMap.put(45,3);
		ageMap.put(50,6);
		ageMap.put(55,8);
		ageMap.put(60,10);
		ageMap.put(65,12);
		ageMap.put(70,14);
		ageMap.put(75,16);
		
		this.hdlMap = new TreeMap<Integer,Integer>();
		hdlMap.put(40,1);
		hdlMap.put(50,0);
		hdlMap.put(60,-1);
		
		this.sbpMap_treated = new TreeMap<Integer,Integer>();
		sbpMap_treated.put(120, 3);
		sbpMap_treated.put(130, 4);
		sbpMap_treated.put(140, 5);
		sbpMap_treated.put(160, 6);

		this.sbpMap_untreated = new TreeMap<Integer,Integer>();
		sbpMap_untreated.put(120, 1);
		sbpMap_untreated.put(130, 2);
		sbpMap_untreated.put(140, 3);
		sbpMap_untreated.put(160, 4);

		this.smokerMap = new TreeMap<Integer,Integer>();
		smokerMap.put(20,9);
		smokerMap.put(40,7);
		smokerMap.put(50,4);
		smokerMap.put(60,2);
		smokerMap.put(70,1);
		
		this.totalCholestrolMap = new TreeMap<Integer,Integer[]>();
		totalCholestrolMap.put(160, new Integer[] {4,3,2,1,1});
		totalCholestrolMap.put(200, new Integer[] {8,6,4,2,1});
		totalCholestrolMap.put(240, new Integer[] {11,8,5,3,2});
		totalCholestrolMap.put(280, new Integer[] {13,10,7,4,2});

		this.tchAgeMap = new TreeMap<Integer,Integer>();
		tchAgeMap.put(20,0);
		tchAgeMap.put(40,1);
		tchAgeMap.put(50,2);
		tchAgeMap.put(60,3);
		tchAgeMap.put(70,4);
	}
	
	public int getTenYearRisk(){
		this.setTotalPoints();
	
		if (this.patient.getPoints() < 9 )
			return 0; //Less than 1
		else if (this.patient.getPoints() >= 25)
			return 30; //Greater than equal to 30
		else
			return tenYearFemaleRisk.get(this.patient.getPoints());
	}
	
	
}
