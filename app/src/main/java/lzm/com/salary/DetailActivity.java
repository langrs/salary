package lzm.com.salary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private Button btn1;
    private TextView tv1,tv2;
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("------------","onCreate");
        setContentView(R.layout.activity_detail);
        init();
//        获取传入的参数内容
        Intent intent = getIntent();
        String data = intent.getStringExtra("data");
        tv1.setText("传入的参数是:" + data);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        去除被摧毁前的数据
        if(savedInstanceState != null){
            String txt = savedInstanceState.getString("tv1");
            tv2.setText(txt);
        }
    }
    private void init(){
        btn1 = (Button) findViewById(R.id.detail_btn1);
        tv1 = (TextView) findViewById(R.id.detail_tv1);
        tv2 = (TextView) findViewById(R.id.detail_tv2);
        et1 = (EditText) findViewById(R.id.detail_et1);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//        String txt = tv1.getText().toString();
//        outState.putString("tv1",txt);
//        Log.d(DetailActivity.class.toString(),"已经保存数据:" + outState.getString("tv1"));
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("-----------","onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("-----------","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("-----------","onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("-----------","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("-----------","onResume");
    }
}
