package lzm.com.salary;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StateActivity extends AppCompatActivity {

    private Button btn1,btn2,btn3,btn4,btn5,btn6;
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state);
        init();
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StateActivity.this,FirstActivity.class);
                startActivity(intent);
            }
        });
//        弹框
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(StateActivity.this);
                dialog.setTitle("hello world!");
                dialog.setMessage("something import!");
                dialog.setCancelable(true);
//                dialog.setPositiveButton("ok",)
            }
        });
//        打开fragment
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyApplication app = (MyApplication) getApplication();
                Log.d("++++++++++++",app.TAG);
                Intent intent = new Intent(StateActivity.this,FragmentActivity.class);
                startActivity(intent);
            }
        });
//        保存数据到SharedPreferences
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                保存字符串
                SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                String name="Langrs";
                String age="122";
                editor.putString("name", name);
                editor.putString("age", age);
                editor.commit();
            }

        });
//        获取变量
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences=getSharedPreferences("user", Context.MODE_PRIVATE);
                String name=preferences.getString("name", "defaultname");
                String age=preferences.getString("age", "0");
                Log.d("___________",name + "/" + age + "!");
                Toast.makeText(StateActivity.this,name + "/"+age,Toast.LENGTH_SHORT);
//                Drawable drawable = getResources().getDrawable(R.drawable);//错误时要显示的图片
                et1.setError("提示填写错误",null);
            }
        });
    }
    private void init(){
        btn1 = (Button) findViewById(R.id.state_btn1);
        btn2 = (Button) findViewById(R.id.state_btn2);
        btn3 = (Button) findViewById(R.id.state_btn3);
        btn4 = (Button) findViewById(R.id.state_btn4);
        btn5 = (Button) findViewById(R.id.state_btn5);
        btn6 = (Button) findViewById(R.id.state_btn6);
        et1 = (EditText) findViewById(R.id.state_et2);

    }
}
