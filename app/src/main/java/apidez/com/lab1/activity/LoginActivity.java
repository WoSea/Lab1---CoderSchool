package apidez.com.lab1.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import apidez.com.lab1.R;

import static android.R.attr.onClick;

public class LoginActivity extends AppCompatActivity {

    private TextView tvSignUp,tvForgotPassword;
    private EditText edtEmail,edtPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // TODO: Insert your code
        tvSignUp= (TextView) findViewById(R.id.tvSignup);
        tvForgotPassword= (TextView) findViewById(R.id.tvForgotpass);
        edtEmail= (EditText) findViewById(R.id.edtEmail);
        edtPassword= (EditText) findViewById(R.id.edtPassword);
        btnLogin= (Button) findViewById(R.id.btnLogin);

        onClick();
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    private void onClick()
    {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,StreamActivity.class));
            }
        });
    }
}
