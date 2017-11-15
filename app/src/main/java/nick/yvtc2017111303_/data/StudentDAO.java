package nick.yvtc2017111303_.data;

/**
 * Created by 58_009 on 2017/11/13.
 */

public interface StudentDAO {
    void add(Student s);
    Student[] getData();
    void update(Student s);
    void clear();
    void delete(Student s);
    Student getOneStudent(int id);
    Student[] searchByName(String name);
}
