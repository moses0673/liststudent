package com.example.moses;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.moses.data.Student;

import java.util.ArrayList;

    public class StudentAdapter extends ArrayAdapter<Student> {
    private ArrayList<Student> dataSet;
    private Context context;



    private static class ViewHolder{
        TextView tvStudentName;
        TextView tvStudentID;
        TextView tvStudentCourse;

    }

    public StudentAdapter(ArrayList<Student> data, Context context) {
        super(context, R.layout.student_list_item, data);
        this.dataSet = data;
        this.context = context;
    }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            Student student = getItem(position);

            ViewHolder holder;


            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(context).inflate(R.layout.student_list_item, parent, false);

                holder.tvStudentCourse = convertView.findViewById(R.id.tvStudentCourse);
                holder.tvStudentName = convertView.findViewById(R.id.tvStudentaName);
                holder.tvStudentID =convertView.findViewById(R.id.tvStudentID);


                convertView.setTag(holder);
            }else{
                holder = (ViewHolder) convertView.getTag();

            }

            holder.tvStudentName.setText(student.getStudentName());
            holder.tvStudentID.setText(student.getStudentID());
            holder.tvStudentCourse.setText(student.getStudentCourse());

            return convertView;

            }

}
