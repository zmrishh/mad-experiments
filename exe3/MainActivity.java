package com.example.final_cal;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
private EditText editText;
private StringBuilder expression = new StringBuilder();
private ExpressionEvaluator evaluator = new ExpressionEvaluator();
@Override protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
editText = findViewById(R.id.editText);
setupButtons(); } private void setupButtons() { int[] buttonIds = {
R.id.button_clear, R.id.button_mod, R.id.button_divide, R.id.button_multiply,
R.id.button_sin, R.id.button_cos, R.id.button_tan, R.id.button_subtract,
R.id.button_sqrt, R.id.button_pow, R.id.button_add, R.id.button_log,
R.id.button_ln, R.id.button_equals,
R.id.button_0, R.id.button_1, R.id.button_2, R.id.button_3,
R.id.button_4, R.id.button_5, R.id.button_6, R.id.button_7,
R.id.button_8, R.id.button_9 };
for (int id : buttonIds) { Button button = findViewById(id);
button.setOnClickListener(this::onButtonClick); } }
private void onButtonClick(View view) {
Button button = (Button) view; String buttonText = button.getText().toString();
if (buttonText.equals("C")) { expression.setLength(0);
} else if (buttonText.equals("=")) { calculateResult();
return; } else { expression.append(buttonText); }
updateDisplay(); } private void updateDisplay() {
editText.setText(expression.toString()); }
private void calculateResult() { try { String exp = expression.toString();
double result = evaluator.evaluate(exp); expression.setLength(0);
expression.append(result); } catch (Exception e) {
expression.setLength(0); expression.append("Error"); } updateDisplay();
} }
