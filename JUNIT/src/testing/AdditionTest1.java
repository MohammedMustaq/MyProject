package testing;

import java.util.Arrays;
import java.util.Collection;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) 
public class AdditionTest1 { 
private int a; 
private int b; 
private int sum; 
public  AdditionTest1(int a, int b, int sum) { 
this.a=a; 
this.b=b; 
this.sum=sum; 
} 
@BeforeClass 
public static void executeBefore() { 
System.out.println("Testing Addition starting"); 
} 
@Before 
public void executeBeforeTestCase() { 
System.out.println("Test method starting"); 
} 
@Test 
public void addIntTest() { 
Addition addition = new Addition(); 
int sum = addition.add(a, b); 
Assert.assertEquals(this.sum, sum); 
} 
@After 
public void executeAfterTestCase() { 
System.out.println("Test methods ending"); 
} 
@AfterClass 
public static void executeAfter() { 
System.out.println("Testing Addition ending"); 
} 
@Parameters 
public static Collection<Object[]> inputsAndOutputs() { 
return Arrays.asList(new Object[][] { 
{1,2,3}, 
{5,5,10}, 
{7,3,10}, 
{-4,5,1} 
}); 
} 
} 