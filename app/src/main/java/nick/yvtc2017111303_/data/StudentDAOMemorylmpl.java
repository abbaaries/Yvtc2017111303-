package nick.yvtc2017111303_.data;

import java.util.ArrayList;

/**
 * Created by 58_009 on 2017/11/13.
 */

public class StudentDAOMemorylmpl implements StudentDAO{
    ArrayList<Student> data = new ArrayList();
    int MaxId = 1;
    @Override
    public void add(Student s) {
        s.id = MaxId;
        data.add(s);
        MaxId++;
    }
    @Override
    public Student[] getData() {
        return data.toArray(new Student[data.size()]);
    }
    @Override
    public void update(Student s) {
        for(Student tmp:data){
            if(tmp.id==s.id){
                tmp.name=s.name;
                tmp.tel=s.tel;
                tmp.addr=s.addr;
            }
        }
    }
    @Override
    public void clear() {
        data.clear();
    }
    @Override
    public void delete(Student s) {
        for(int i = data.size()-1;i>=0;i--){
            if(data.get(i).id==s.id){
                data.remove(i);
                break;
            }
        }
    }
    @Override
    public Student getOneStudent(int id) {
        for(Student tmp : data) {
            if (tmp.id == id){
                return tmp;
            }
        }
        return null;
    }
    @Override
    public Student[] searchByName(String name) {
        ArrayList<Student> tmpList = new ArrayList<>();
        for(Student tmp:data){
            if(tmp.name.equals(name)){
                tmpList.add(tmp);
            }
        }
        return tmpList.toArray(new Student[tmpList.size()]);
    }
}
