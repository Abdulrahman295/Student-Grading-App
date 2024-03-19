package test.academic;

import main.academic.Student;
import org.junit.jupiter.api.*;

public class StudentTest {

    @Test
    public void testSetName(){
        Student s1 = new Student();
        s1.setName("s1");
        Assertions.assertEquals("s1", s1.getName());
    }
}
