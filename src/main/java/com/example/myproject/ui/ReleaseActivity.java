package com.example.myproject.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.myproject.R;
import com.example.myproject.helper.MyDataHelper;

public class ReleaseActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    Button button;
    EditText ed_name,ed_phone,ed_description,ed_date,ed_location;
    //1 ==lost 2 == found
    private int type = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        button = findViewById(R.id.button);
        radioGroup = findViewById(R.id.radioGroup);
        ed_name = findViewById(R.id.ed_name);
        ed_phone = findViewById(R.id.ed_phone);
        ed_description = findViewById(R.id.ed_description);
        ed_date = findViewById(R.id.ed_date);
        ed_location = findViewById(R.id.ed_location);
        init();
    }

    public void init(){
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                switch (checkedId){
                    case R.id.rb_lost:
                        type = 1;
                        break;
                    case R.id.rb_found:
                        type = 2;
                        break;
                }
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = ed_name.getText().toString().trim();
                String phone = ed_phone.getText().toString().trim();
                String description = ed_description.getText().toString().trim();
                String date = ed_date.getText().toString().trim();
                String location = ed_location.getText().toString().trim();
                if (TextUtils.isEmpty(name)){
                    Toast.makeText(ReleaseActivity.this,"Enter Name",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)){
                    Toast.makeText(ReleaseActivity.this,"Enter Phone",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(description)){
                    Toast.makeText(ReleaseActivity.this,"Enter Description",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(date)){
                    Toast.makeText(ReleaseActivity.this,"Enter Date",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(location)){
                    Toast.makeText(ReleaseActivity.this,"Enter Location",Toast.LENGTH_SHORT).show();
                    return;
                }

                MyDataHelper myDataHelper = new MyDataHelper(ReleaseActivity.this);
                SQLiteDatabase db = myDataHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("type", type);
                values.put("name", name);
                values.put("phone", phone);
                values.put("description", description);
                values.put("date", date);
                values.put("location", location);
                db.insert("lost_found" , null , values);
                Toast.makeText(ReleaseActivity.this,"Successfully published",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}