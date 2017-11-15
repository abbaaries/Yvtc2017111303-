package nick.yvtc2017111303_;

import android.content.Context;
import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import nick.yvtc2017111303_.data.Student;
import nick.yvtc2017111303_.data.StudentDAOFileImp1;

import static org.junit.Assert.assertEquals;

/**
 * Created by 58_009 on 2017/11/15.
 */

public class MyDAOFileTest {
    @Test
    public void useAppContext(){
        Context appContext = InstrumentationRegistry.getTargetContext();
        StudentDAOFileImp1 dao = new StudentDAOFileImp1(appContext);
        dao.clear();
        dao.add(new Student("AA", "11", "aabb"));
        dao.clear();
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 2);
    }
}
