package crtjava;
class Student{
	String name;
	String course;
	String sub;
	int fee;
	int maths;
	int sci;
	int eng;
	public Student(String name, String course, int fee, int maths, int sci, int eng) {
		super();
		this.name = name;
		this.course = course;
		this.sub=sub;
		this.fee = fee;
		this.maths = maths;
		this.sci = sci;
		this.eng = eng;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", course=" + course + ", fee=" + fee + ", maths=" + maths + ", sci=" + sci
				+ ", eng=" + eng + "]";
	}
	
}
public class StudentResults {
		
		static Student[] students = new Student[15];
		static int Fee_MaX = 75000;
		
		static void prepareStudentData() {
			
			String[] courseNames = {"IT","CSE","CIVIL","Mechanical"};
			
			
			for(int i=0;i<=14;i++) {
				int max=100,min=0,feeMax=75000,feeMin=5000;
				String course =  	courseNames[(int)(Math.random() * (3 - 0 + 1) +min)];
				int fee = (int)(Math.random() * (feeMax - feeMin + 1) + min); 
				int maths = (int)(Math.random() * (max - min + 1) + min); 
				int sci = (int)(Math.random() * (max - min + 1) + min); 
				int eng = (int)(Math.random() * (max - min + 1) + min); 
				
				students[i]= new Student("student"+(i+1),course,
						fee,maths,sci,eng);
				
		
			}
			
			

		}
	public static void main(String[] args) {
	

		prepareStudentData();
		System.out.println("Total Due Amount.....");
		processFee(Fee_MaX);
		System.out.println("Total Due Amount.....");
		int amt =10000;
		System.out.println("Student Paid Less than "+amt+ "List");
		
		processFee(10000);
		
		//processFeeFor("Pass");
		failStudents("Fail");
		failSubject("maths","sci","eng");

	}

	private static void processFeeFor(String result) {
long dueAmount =0;

for(int i=0;i<students.length;i++) {
	if(students[i].fee < Fee_MaX) {
		if ( (students[i].maths > 35)
			&& (students[i].sci > 35)
			&& (students[i].eng > 35)
			) {
			dueAmount = dueAmount + students[i].fee;
		}//if
	}// if
}// loop

System.out.println("total due Amount For"+result+" --->"+dueAmount);
}
private static void processFee(int amt) {
	
	long dueAmount =0;
	
	for(int i=0;i<students.length;i++) {
		if(students[i].fee < amt) {
			if(amt != Fee_MaX) {
				System.out.println(students[i]);
			}
			dueAmount = dueAmount + students[i].fee;
		}//if
	}// loop
	
	System.out.println("total due Amount--->"+dueAmount);
	
}

private static void failStudents(String result) {
	for(int i=0;i<students.length;i++) {
		if ( (students[i].maths < 35)
				|| (students[i].sci < 35)
				|| (students[i].eng < 35)
				) {
			System.out.println("Student"+(i+1));
		}//if
	}//for
	
}

private static void failSubject(String math,String sci,String eng) {
	
	
	System.out.println("failed student in the subjects are:");
	for(int i=0;i<students.length;i++) {
		if (students[i].maths < 35){
			System.out.println("Student"+(i+1)+" failed in Maths with marks "+students[i].maths);
		}//if
		if (students[i].sci < 35){
			System.out.println("Student"+(i+1)+" failed in Science with marks "+students[i].maths);
		}//if
		if (students[i].maths < 35){
			System.out.println("Student"+(i+1)+" failed in English with marks "+students[i].maths);
		}//if
		}//for
}
}
