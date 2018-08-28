package com.example.dell.firstpro.DataEntry;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.firstpro.R;
import com.example.dell.firstpro.SqLite.DB;

public class UserActivity extends AppCompatActivity {
    Button okB, updateB, deleteB, getoneB, getAllB;
    EditText nameT, addressT;
    DB db;
    String name, address, id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        init();
        actions();
    }

    private void init() {
        okB = (Button)findViewById(R.id.OkBTN);
        deleteB =(Button) findViewById(R.id.deleteBTN);
        updateB = (Button)findViewById(R.id.updateBTN);
        getoneB =(Button) findViewById(R.id.getBTN);
        getAllB = (Button)findViewById(R.id.getAllBTN);
        nameT = findViewById(R.id.NameTXT);
        addressT = findViewById(R.id.AddressTXT);

        db = new DB(this);
    }

    private void actions() {
//        okB.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.i("fred","fred000");
//            }
//        });
        okB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id = "1";
                db.delete(Integer.parseInt(id));

            }
        });

        deleteB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameT.getText().toString();
                address = addressT.getText().toString();
                db.insert(name, address);

            }
        });
        updateB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameT.getText().toString();
                address = addressT.getText().toString();
                db.update(2,name, address);

            }
        });
        getAllB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = db.getAll();
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(getBaseContext(), "id  " + c.getInt(0) + "/n"
                                + "name  " + c.getString(1) + "/n"
                                + "address  " + c.getString(2), Toast.LENGTH_SHORT).show();
                    } while (c.moveToNext());
                }
            }
        });

        getoneB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor c = db.getByID(1);
                if (c.moveToFirst()) {
                    do {
                        Toast.makeText(getBaseContext(), "id  " + c.getInt(0) + "/n"
                                + "name  " + c.getString(1) + "/n"
                                + "address  " + c.getString(2), Toast.LENGTH_SHORT).show();
                    } while (c.moveToNext());
                }
            }
        });
    }
}
