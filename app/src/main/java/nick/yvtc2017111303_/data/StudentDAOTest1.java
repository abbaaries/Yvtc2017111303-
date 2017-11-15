package nick.yvtc2017111303_.data;

import java.util.ArrayList;

/**
 * Created by 58_009 on 2017/11/13.
 */

public class StudentDAOTest1 {
    ArrayList<Student> data = new ArrayList();
    int MaxId = 1;
    public void add(Student s){
        s.id = MaxId;
        data.add(s);
        MaxId++;
    }

    public ArrayList<Student> getData(){
        return data;
    }
    public void update(Student s){
        for(Student tmp:data){
            if(tmp.id==s.id){
                tmp.name=s.name;
                tmp.tel=s.tel;
                tmp.addr=s.addr;
            }
        }
    }
}
