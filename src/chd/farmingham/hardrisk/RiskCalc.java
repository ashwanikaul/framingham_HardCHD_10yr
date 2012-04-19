package chd.farmingham.hardrisk;

import java.util.NavigableMap;

import org.ehr.model.Patient;

public abstract class RiskCalc {
	
	protected Patient patient;
	protected int[] tenYearRisk;
	protected NavigableMap<Integer, Integer> ageMap;
	protected NavigableMap<Integer, Integer> hdlMap;
	protected NavigableMap<Integer, Integer> sbpMap_treated;
	protected NavigableMap<Integer, Integer> sbpMap_untreated;
	protected NavigableMap<Integer, Integer> smokerMap;
	protected NavigableMap<Integer, Integer[]> totalCholestrolMap;
	protected NavigableMap<Integer, Integer> tchAgeMap;
	
	private int getAgeScore(){
		if (this.patient.getAge() < 20 || this.patient.getAge() > 79) //Same boundary conditions for Male & Female
			return -10;
		else 
			return this.ageMap.floorEntry(this.patient.getAge()).getValue();
	}
	
	private int getHdlScore(){
		if (this.patient.getHDL() < 40) //Same for Male & Female
			return 2;
		else 
			return this.hdlMap.floorEntry(this.patient.getHDL()).getValue();
	}
	
	private int getSBPScore(){
		
		if(this.patient.isTreatmentForHTN()){
			if(this.patient.getSBP() < 120) //Same boundary condition for Male & Female
				return 0;
			else
				return this.sbpMap_treated.floorEntry(this.patient.getSBP()).getValue();
		}else{
			if(this.patient.getSBP() < 120) //Same boundary condition for Male & Female
				return 0;
			else
				return this.sbpMap_untreated.floorEntry(this.patient.getSBP()).getValue();
		}
	}
	
	private int getSmokerStatusScore(){
		if (this.patient.isSmoker()){
			if (this.patient.getAge() < 20 || this.patient.getAge() > 79)
				return -10; //Age out of range
			else 
				return this.smokerMap.floorEntry(this.patient.getAge()).getValue();
		}else
			return 0;
	}
	
	private int getTotalCholestrolScore(){
		if(this.patient.getTotalCholestrol() < 160) //Same boundary condition for Male & Female
			return 0;
		else{
			int index = this.tchAgeMap.floorEntry(this.patient.getAge()).getValue();
			Integer[] scoreRange = this.totalCholestrolMap.floorEntry(this.patient.getTotalCholestrol()).getValue(); 
		
			return scoreRange[index];
		}
	}
	
	protected void setTotalPoints(){
		this.patient.setPoints(getAgeScore() + getHdlScore() +  getSBPScore() + getSmokerStatusScore() + getTotalCholestrolScore());
	}
	
	public abstract int getTenYearRisk();
	
}
