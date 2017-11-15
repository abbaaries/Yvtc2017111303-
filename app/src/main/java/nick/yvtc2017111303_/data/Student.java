package nick.yvtc2017111303_.data;

/**
 * Created by 58_009 on 2017/11/13.
 */

public class Student {
    public int id;
    public String name;
    public String tel;
    public String addr;

    public Student(String name , String tel , String addr){
        this.name=name;
        this.tel=tel;
        this.addr=addr;
    }

    @Override
    public String toString() {
        return id+","+name+","+tel+","+addr;
    }
}
