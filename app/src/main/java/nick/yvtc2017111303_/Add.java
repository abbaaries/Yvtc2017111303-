package nick.yvtc2017111303_;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import nick.yvtc2017111303_.data.Student;

public class Add extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }

    public void clickAdd(View view) {
        EditText ed1 = (EditText)findViewById(R.id.et_name);
        EditText ed2 = (EditText)findViewById(R.id.et_tel);
        EditText ed3 = (EditText)findViewById(R.id.et_addr);
        MainActivity.t.add(new Student(ed1.getText().toString(),ed2.getText().toString(),ed3.getText().toString()));
        finish();
    }
}
