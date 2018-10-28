package testing;

import org.junit.Assert;
import org.junit.Test;

public class AdditionTest { 
@Test 
public void addIntTest() { 
Addition addition = new Addition(); 
int sum = addition.add(20, 30); 
Assert.assertEquals(50, sum); 
} 
} 