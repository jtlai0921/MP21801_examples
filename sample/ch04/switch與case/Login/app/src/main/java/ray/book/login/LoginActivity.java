package ray.book.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = this.findViewById(R.id.login);
        login.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText account = LoginActivity.this.findViewById(R.id.account);
                EditText password = LoginActivity.this.findViewById(R.id.password);
                if (account.getText().toString().equals("user") && password.getText().toString().equals("123456"))
                {
                    //Toast.makeText(LoginActivity.this, "帳號密碼正確", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this,MenuActivity.class));
                }
                else
                {
                    Toast.makeText(LoginActivity.this,"帳號密碼錯誤",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
