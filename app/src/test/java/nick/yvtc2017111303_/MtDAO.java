package nick.yvtc2017111303_;

import org.junit.Test;

import nick.yvtc2017111303_.data.Student;
import nick.yvtc2017111303_.data.StudentDAOMemorylmpl;

import static org.junit.Assert.assertEquals;

/**
 * Created by 58_009 on 2017/11/15.
 */

public class MtDAO {
    @Test
    public void TestMemoryDAO1()
    {
        StudentDAOMemorylmpl dao = new StudentDAOMemorylmpl();
        dao.add(new Student("AA", "11", "aabb"));
        dao.clear();
        dao.add(new Student("BB", "22", "aabb"));
        dao.add(new Student("CC", "33", "aabb"));
        Student[] stus = dao.getData();
        assertEquals(stus.length, 2);
    }
    @Test
    public void TestMemoryDAO2()
    {
        StudentDAOMemorylmpl dao = new StudentDAOMemorylmpl();
        dao.clear();
        dao.add(new Student("aa","11","xx"));
        dao.add(new Student("bb","22","yy"));
        dao.add(new Student("cc","33","zz"));
        Student[] students=dao.getData();
        assertEquals(students[2].name,"cc");




    }
    @Test
    public void TestMemoryDAO3Update(){
        StudentDAOMemorylmpl dao = new StudentDAOMemorylmpl();
        dao.clear();
        dao.add(new Student("aa","11","xx"));
        dao.add(new Student("bb","22","yy"));
        dao.add(new Student("cc","33","zz"));
        Student[] students=dao.getData();
        Student s= students[1];
        s.name="55";
        s.addr= "KK";
        dao.update(s);
        Student[] check=dao.getData();
        assertEquals(check[1].addr,"KK");
    }
    @Test
    public void TestMemoryDAO4Delete(){
        StudentDAOMemorylmpl dao = new StudentDAOMemorylmpl();
        dao.clear();
        dao.add(new Student("aa","11","xx"));
        dao.add(new Student("bb","22","yy"));
        dao.add(new Student("cc","33","zz"));
        Student[] students=dao.getData();
        Student s= students[1];
        dao.delete(s);
        Student[] check=dao.getData();
        assertEquals(check.length,2);
    }
    @Test
    public void TestMemoryDAO5getOneStudent(){
        StudentDAOMemorylmpl dao = new StudentDAOMemorylmpl();
        dao.clear();
        dao.add(new Student("aa","11","xx"));
        dao.add(new Student("bb","22","yy"));
        dao.add(new Student("cc","33","zz"));
        Student stu=dao.getOneStudent(2);
        assertEquals("bb",stu.name);
    }
    @Test
    public void TestMemoryDAO6searchByName(){
        StudentDAOMemorylmpl dao = new StudentDAOMemorylmpl();
        dao.clear();
        dao.add(new Student("aa","11","xx"));
        dao.add(new Student("bb","22","yy"));
        dao.add(new Student("cc","33","zz"));
        dao.add(new Student("cc","44","uu"));
        Student[] stu=dao.searchByName("cc");
        assertEquals(stu.length,2);
    }
}
