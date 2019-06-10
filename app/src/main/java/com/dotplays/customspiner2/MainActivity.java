package com.dotplays.customspiner2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private AppCompatSpinner spStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spStudent = findViewById(R.id.spStudent);


        final List<Student> studentList = new ArrayList<>();


        Student studentFake = new Student();
        studentFake.id = "-1";
        studentFake.name = "---Select One---";
        studentList.add(0, studentFake);

        for (int i = 0; i < 20; i++) {
            Student student = new Student();
            student.id = String.valueOf(i);
            student.name = "Huy Nguyen " + i;
            studentList.add(student);
        }

        MySpinnerAdapter mySpinnerAdapter = new MySpinnerAdapter(MainActivity.this, studentList);

        spStudent.setAdapter(mySpinnerAdapter);


        spStudent.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Student student = studentList.get(position);

                Toast.makeText(MainActivity.this, student.name, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


    }

    public void showSelectedItem(View view) {
        Student student = (Student) spStudent.getSelectedItem();

        if (student.name.equals("---Select One---")) {
            Toast.makeText(MainActivity.this, "Vui long chon Sinh vien", Toast.LENGTH_SHORT).show();
        } else
            Toast.makeText(MainActivity.this, student.name, Toast.LENGTH_SHORT).show();


    }
}
