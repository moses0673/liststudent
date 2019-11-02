package com.example.moses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.moses.data.Student;

import java.sql.SQLOutput;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listViewStudents;
    private ArrayList<Student> arrayListStudent = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

listViewStudents = findViewById(R.id.listViewStudents);

arrayListStudent.add(new Student("moses wong","1234","DWD"));
        arrayListStudent.add(new Student("peter choo","1235","DIT"));
        arrayListStudent.add(new Student("jeremy wan","1236","DAG"));
        arrayListStudent.add(new Student("john oh","1237","DNT"));

        StudentAdapter adapter = new StudentAdapter(arrayListStudent, this);

        listViewStudents.setAdapter(adapter);

        listViewStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) parent.getAdapter().getItem(position);

                Intent i = new Intent(MainActivity.this,StudentProfileActivity.class);

                i.putExtra("name",student.getStudentName());
                i.putExtra("id",student.getStudentID());
                i.putExtra("course",student.getStudentCourse());
                startActivity(i);
            }
        });
}
}
