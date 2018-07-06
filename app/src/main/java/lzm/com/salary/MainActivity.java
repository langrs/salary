package lzm.com.salary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private String[] data ={"一个人中国梦","新中国下的蛋","红太阳,红彤彤","社会主义好","美丽岛","雅马哈","苹果","联想","华为有效公司",
    "小混蛋","美丽的西双版纳","新年好","朱军","董存瑞"};

    private ListView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        lv1.setAdapter(arrayAdapter);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,DetailActivity.class);
                intent.putExtra("data",data[position]);
                startActivity(intent);
            }
        });
    }
    private void init(){
        lv1 = (ListView) findViewById(R.id.main_lv1);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {

    }
}
