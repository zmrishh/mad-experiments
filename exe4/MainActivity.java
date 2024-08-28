package com.example.exe_04;
import androidx.appcompat.app.AppCompatActivity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
EditText editTextName, editTextRollNo, editTextMarks;
Button buttonAdd, buttonUpdate, buttonDelete, buttonView;
TextView textViewResults;
DBHelper dbHelper;
@Override protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
dbHelper = new DBHelper(this);
editTextName = findViewById(R.id.editTextName);
editTextRollNo = findViewById(R.id.editTextRollNo);
editTextMarks = findViewById(R.id.editTextMarks);
buttonAdd = findViewById(R.id.buttonAdd);
buttonUpdate = findViewById(R.id.buttonUpdate);
buttonDelete = findViewById(R.id.buttonDelete);
buttonView = findViewById(R.id.buttonView);
textViewResults = findViewById(R.id.textViewResults); 
buttonAdd.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View v) {
int rollNo = Integer.parseInt(editTextRollNo.getText().toString()); // Get roll number from input
String name = editTextName.getText().toString();
int marks = Integer.parseInt(editTextMarks.getText().toString());
dbHelper.insertStudent(rollNo, name, marks);
Toast.makeText(MainActivity.this, "Student Added", Toast.LENGTH_SHORT).show(); } });
buttonUpdate.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View v) {
int rollNo = Integer.parseInt(editTextRollNo.getText().toString());
String name = editTextName.getText().toString();
int marks = Integer.parseInt(editTextMarks.getText().toString());
dbHelper.updateStudent(rollNo, name, marks);
Toast.makeText(MainActivity.this, "Student Updated", Toast.LENGTH_SHORT).show(); } }); 
buttonDelete.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View v) {
int rollNo = Integer.parseInt(editTextRollNo.getText().toString());
dbHelper.deleteStudent(rollNo);
Toast.makeText(MainActivity.this, "Student Deleted", Toast.LENGTH_SHORT).show(); } });
buttonView.setOnClickListener(new View.OnClickListener() {
@Override public void onClick(View v) {
Cursor cursor = dbHelper.getAllStudents();
if (cursor.getCount() == 0) {
textViewResults.setText("No data found"); return; }
StringBuilder stringBuilder = new StringBuilder();
while (cursor.moveToNext()) {
stringBuilder.append("Roll No: ").append(cursor.getInt(0)).append("\n");
stringBuilder.append("Name: ").append(cursor.getString(1)).append("\n");
stringBuilder.append("Marks: ").append(cursor.getInt(2)).append("\n\n"); }
textViewResults.setText(stringBuilder.toString()); } }); } }
