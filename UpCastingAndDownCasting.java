package seleniumConcepts;

 class A{
	
public void me2() {
	System.out.println("instinde class A");
}
	
}

 class B extends A{
	public void me3() {
		System.out.println("inside class B");
	}
}


public class UpCastingAndDownCasting {
	
	public static void main(String []args) {
		
		A obj1 = new B();
		B obj2 = (B)obj1;
		obj2.me3();
		
	}
	
}
	

