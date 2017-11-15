package nick.yvtc2017111303_;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;

import nick.yvtc2017111303_.data.DetailActivity;
import nick.yvtc2017111303_.data.Student;
import nick.yvtc2017111303_.data.StudentDAOFileImp1;
import nick.yvtc2017111303_.data.StudentDAOMemorylmpl;

public class MainActivity extends AppCompatActivity implements RecyclerView.OnItemTouchListener{
    public static StudentDAOFileImp1 t;   //更改成宣告一個StudentDAOFileImp1變數t  需要使用StudentDAOFileImp1 把檔案儲存到手機
    RecyclerView recyclerView;
    RecyclerView.Adapter<MyAdapter.ViewHolder> adapter;
    RecyclerView.LayoutManager layoutManager;
    GestureDetector mGD;                            //宣告一個手勢偵測器
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t= new StudentDAOFileImp1(this);            //更改成宣告一個StudentDAOFileImp1新物件
        recyclerView =(RecyclerView)findViewById(R.id.recuclerView);
        recyclerView.setHasFixedSize(false);
        layoutManager=new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
//        t.add(new Student("Bob","123","aabb"));
//        t.add(new Student("Nick","456","ed"));
        mGD = new GestureDetector(this , new GestureDetector.SimpleOnGestureListener(){ //在這設一個手勢的偵測器
            @Override
            public boolean onSingleTapUp(MotionEvent e) {                               //只覆寫 單純的按壓動作
                return true;
            }
        });
        recyclerView.addOnItemTouchListener(this);                                      //recyclerView設定ItemTouch的監聽器
    }

    @Override
    protected void onResume() {
        adapter = new MyAdapter(MainActivity.this,t.getData());
        recyclerView.setAdapter(adapter);
        super.onResume();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("+");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent it = new Intent(MainActivity.this,Add.class);
        startActivity(it);
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        View v = rv.findChildViewUnder(e.getX(),e.getY());          //獲得點擊選項的View
        if(mGD.onTouchEvent(e)){                                        //假如是上面所寫的監聽器動作
            int position =rv.getChildAdapterPosition(v);                //獲得點擊選項的View 的索引位置
            if(position>=0){                                            //索引位置如果小於0 表示沒touch到任何item
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("id",t.getData()[position].id);
                startActivity(it);
            }
        }
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {

    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
