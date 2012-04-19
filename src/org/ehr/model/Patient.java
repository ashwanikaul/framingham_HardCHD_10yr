package org.ehr.model;



public class Patient {

	private int age;
	private int totalCholestrol;
	private int HDL;
	private int SBP;
	private boolean treatmentForHTN;
	private boolean smoker; //TRUE for smoker, FALSE for nonsmoker
	private int points;
	private Sex sex;
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getTotalCholestrol() {
		return totalCholestrol;
	}
	
	public void setTotalCholestrol(int totalCholestrol) {
		this.totalCholestrol = totalCholestrol;
	}
	
	public int getHDL() {
		return HDL;
	}
	
	public void setHDL(int hDL) {
		HDL = hDL;
	}
	
	public int getSBP() {
		return SBP;
	}
	
	public void setSBP(int sBP) {
		SBP = sBP;
	}
	
	public boolean isTreatmentForHTN() {
		return treatmentForHTN;
	}
	
	public void setTreatmentForHTN(boolean treatmentForHTN) {
		this.treatmentForHTN = treatmentForHTN;
	}
	
	public boolean isSmoker() {
		return smoker;
	}
	
	public void setSmoker(boolean smoker) {
		this.smoker = smoker;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}
	 

	public Patient(int age, int totalCholestrol, int hDL, int sBP,
			boolean treatmentForHTN, boolean smoker, Sex sex) {
		super();
		this.age = age;
		this.totalCholestrol = totalCholestrol;
		this.HDL = hDL;
		this.SBP = sBP;
		this.treatmentForHTN = treatmentForHTN;
		this.smoker = smoker;
		this.sex = sex;
	}

	public Sex getSex() {
		return sex;
	}

	public void setSex(Sex sex) {
		this.sex = sex;
	}
	
	public String toString(){
		StringBuffer toStr = new StringBuffer();
		toStr.append(this.sex).append("\n");
		toStr.append("Age:").append(this.age).append("\n");
		toStr.append("Total Cholestrol:").append(this.totalCholestrol).append("\n");
		toStr.append("HDL:").append(this.HDL).append("\n");
		toStr.append("SBP:").append(this.SBP).append("\n");
		toStr.append("Treatment for HTN:").append(this.treatmentForHTN?"Treated for HTN":"Not Treated for HTN").append("\n");
		toStr.append("Smoking status:").append(this.smoker?"Is current smoker":"Non Smoker").append("\n");
		return toStr.toString();
	}

	
}
