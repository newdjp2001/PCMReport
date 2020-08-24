package com.codes.pro;


public class PCMBase {
	int physics;
	int chemistry;
	int math;
	int total;
	char grade;
	
	int temp;
	int avg;
	
	

	public void setPhysics(int physics) {
		
		this.physics = physics;
	}

	public int getPhysics() {
		return physics;
	}

	public void setChemistry(int chemistry) {
		
		this.chemistry = chemistry ;
	}

	public int getChemistry() {
		return chemistry;
	}

	public void setMath(int math) {
		
		this.math = math ;
	}
	
	public int getMath() {
		return math;
	}

	public void setTotal() {
		
			total = physics + chemistry + math;
			temp = total ;
		
	}

	public int getTotal() {
		return total;
	}

	public void setGrade() {
		
			avg=temp/3;
			if(avg>=80) {
				grade = 'A';
			}
			else if(avg>=50 && avg<80) {
				grade = 'B';
			}
			else {
				grade = 'C';
			}
		}
	
	
	public char getGrade() {
		return grade;
	}
	
}
