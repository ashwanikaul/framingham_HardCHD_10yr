package org.ehr.functions;

import org.ehr.model.Patient;
import org.ehr.model.Sex;

import chd.farmingham.hardrisk.RiskCalc;
import chd.farmingham.hardrisk.RiskCalcFemale;
import chd.farmingham.hardrisk.RiskCalcMale;

public class CalcTenYrRisk_sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Patient patient = new Patient(25, 187, 45, 125, false, true, Sex.Female);
		RiskCalc riskCalc = null;
		
		if (patient.getSex().equals(Sex.Male)){
			riskCalc = new RiskCalcMale(patient);
		}else if (patient.getSex().equals(Sex.Female)){
			riskCalc = new RiskCalcFemale(patient);
		}
		
		System.out.println(riskCalc.getTenYearRisk());

	}

}
