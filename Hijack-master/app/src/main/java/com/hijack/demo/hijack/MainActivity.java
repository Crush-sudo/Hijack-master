package com.hijack.demo.hijack;
import com.hijack.demo.hijack.MySharedPreferences;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    private String app_name;//定义变量
    private EditText et_app_name;//编辑框

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_app_name= (EditText) findViewById(R.id.hack_appname);
        final Intent intent = new Intent(MainActivity.this,HijackingService.class);
        findViewById(R.id.start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                app_name = et_app_name.getText().toString().trim();
                Boolean bool = MySharedPreferences.setName(app_name, MainActivity.this);
                if (bool)
                    Toast.makeText(MainActivity.this, "应用名"+app_name+"保存成功", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "应用名"+app_name+"保存失败", Toast.LENGTH_SHORT).show();
                startService(intent);
            }
        });
        findViewById(R.id.stop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stopService(intent);
            }
        });
    }
}
