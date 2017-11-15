package nick.yvtc2017111303_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import nick.yvtc2017111303_.data.Student;

public class EditActivity extends AppCompatActivity {
    EditText et1,et2,et3,et4;
    Student stu;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        et2=(EditText)findViewById(R.id.editText2);
        et3=(EditText)findViewById(R.id.editText3);
        et4=(EditText)findViewById(R.id.editText4);
        id=getIntent().getIntExtra("id",-1);
        stu=MainActivity.t.getOneStudent(id);
        et2.setText(stu.name);
        et3.setText(stu.tel);
        et4.setText(stu.addr);
    }
    public void check(View view) {
        stu.name = et2.getText().toString();
        stu.tel = et3.getText().toString();
        stu.addr = et4.getText().toString();
        finish();
    }
    public void back(View view) {
    }
}
