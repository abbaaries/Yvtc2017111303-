package nick.yvtc2017111303_.data;

import android.content.ContentValues;
import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by 58_009 on 2017/11/15.
 */

public class StudentDAOFileImp1 implements StudentDAO {
    ArrayList<Student> data;                            //宣告一個ArrayList<>物件容器data
    Context context;                                    //宣告一個環境(容器)變數
    String DATA_FILE;                                   //宣告一個字串變數
    public StudentDAOFileImp1(Context context){         //設定一個接收值 context  當主程式產生一個StudentDAOFileImp1物件時(必須寫入傳入值)
        this.context=context;                           //就會執行建構值裡面內容
        DATA_FILE = context.getFilesDir().getAbsolutePath()+ File.separator+"mydata.json";//字串承接
        data=new ArrayList<>();                         //新增一個ArrayList<>新物件容器 存取Student 的陣列
        loadData();                                     //啟動程式時 自動讀檔
    }
    private void savaData(){                            //宣告一個儲存方法
        try {
            FileWriter fw = new FileWriter(DATA_FILE);
            Gson gson = new Gson();                     //建立GSON物件
            String str = gson.toJson(data);             //將ArrayList<>物件data轉成JSON數據
            fw.write(str);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void loadData(){                            //宣告一個讀取方法
        try {
            FileReader fr = new FileReader(DATA_FILE);  //讀取DATA_FILE檔案資料
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            br.close();
            fr.close();
            if(str.trim().length()>0){                  //假如str不是空的
                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Student>>(){}.getType();//通過getType()方法獲取到我們使用的泛型類的泛型參數類型
                //TypeToken是Gson庫中包含的一種獲取JSON類型的類，可以傳入泛型來獲取類型，而getType或getClass這種方法是獲取不到泛型類型的
                data = gson.fromJson(str,listType);         //從JSON數據轉回來 json的String,json的類型
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void add(Student s) {
        data.add(s);
        savaData();
    }

    @Override
    public Student[] getData() {
        return data.toArray(new Student[data.size()]);
    }

    @Override
    public void update(Student s) {

    }

    @Override
    public void clear() {
        data.clear();
        savaData();
    }

    @Override
    public void delete(Student s) {

    }

    @Override
    public Student getOneStudent(int id) {
        return null;
    }

    @Override
    public Student[] searchByName(String name) {
        return new Student[0];
    }
}
