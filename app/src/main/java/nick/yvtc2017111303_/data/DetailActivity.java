package nick.yvtc2017111303_.data;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import nick.yvtc2017111303_.EditActivity;
import nick.yvtc2017111303_.MainActivity;
import nick.yvtc2017111303_.R;

public class DetailActivity extends AppCompatActivity {
    TextView tv1,tv2,tv3;
    Student stu;
    int id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tv1=(TextView)findViewById(R.id.tv_DetialName);
        tv2=(TextView)findViewById(R.id.tv_DetialTel);
        tv3=(TextView)findViewById(R.id.tv_DetialAddr);

        id =getIntent().getIntExtra("id",-1);       //取得所有傳過來的id數值
        stu = MainActivity.t.getOneStudent(id); //使用getOneStudent 找到指定的Student類別

    }

    @Override
    protected void onResume() {
        tv1.setText(stu.name);
        tv2.setText(stu.tel);
        tv3.setText(stu.addr);
        super.onResume();
    }

    public void clickBack(View view) {
        finish();
    }

    public void clickDelete(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(R.string.delete_confirm);
        builder.setPositiveButton(R.string.okay, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                MainActivity.t.delete(stu);
                finish();
            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }

    public void clickEdit(View view) {
        Intent it = new Intent();
        it.setClass(DetailActivity.this, EditActivity.class);
        it.putExtra("id",id);
        startActivity(it);
    }
}
