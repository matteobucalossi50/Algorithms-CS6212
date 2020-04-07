package proj3package;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Project3Test {
  
//    int a[] = {20, 300, 400, 50, 200};       //result max sum: 900
    
    
    @Test
    public void testBase() {
	
	Project3 tester = new Project3();

	int[] a = {10, 100, 300, 400, 50, 4500, 200, 30, 90};   //result max sum: 5090
			
	assertEquals(5090, tester.base(a, a.length));
	
    }

    @Test
    public void testMethod() {
	Project3 tester = new Project3();

	int[] a = {10, 100, 300, 400, 50, 4500, 200, 30, 90};   //result max sum: 5500
			
	assertEquals(5500, tester.method(a, a.length, 2));
	
    }

}
