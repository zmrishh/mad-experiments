package com.example.yoges05; 
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
private EditText usernameEditText;
private EditText idEditText;
private Button validateButton;
private static final String CORRECT_USERNAME = "Yoges";
private static final String CORRECT_PASSCODE = "1511";
@Override
protected void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.activity_main);
usernameEditText = findViewById(R.id.username_edit_text);
idEditText = findViewById(R.id.id_edit_text);
validateButton = findViewById(R.id.validate_button);
validateButton.setOnClickListener(v -> validateInputs()); }
private void validateInputs() {
String username = usernameEditText.getText().toString().trim();
String passcode = idEditText.getText().toString().trim();
if (TextUtils.isEmpty(username) || TextUtils.isEmpty(passcode)) {
showToast(getString(R.string.empty_fields_error)); return; }
if (!username.equals(CORRECT_USERNAME)) {
showToast(getString(R.string.invalid_username_error)); return; }
if (!passcode.equals(CORRECT_PASSCODE)) {
showToast(getString(R.string.invalid_id_error)); return;}
showToast("Validation Successful!"); } private void showToast(String message) {
LayoutInflater inflater = getLayoutInflater();
View toastLayout = inflater.inflate(R.layout.custom_toast_layout, null);
TextView toastText = toastLayout.findViewById(R.id.toast_text);
toastText.setText(message);
Toast customToast = new Toast(getApplicationContext());
customToast.setView(toastLayout);
customToast.setDuration(Toast.LENGTH_SHORT);
customToast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.BOTTOM, 0, dpToPx(100)); 
customToast.show(); } private int dpToPx(int dp) {
float density = getResources().getDisplayMetrics().density;
return Math.round(dp * density); 
} }
