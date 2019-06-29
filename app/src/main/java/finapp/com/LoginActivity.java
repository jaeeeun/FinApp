package finapp.com;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    // 비밀번호 암호화, 툴바 없애기, 엔터로 로그인 <-완료

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText loginEmail = findViewById(R.id.loginEmail);
        final EditText loginPassword = findViewById(R.id.loginPassword);
        Button btn_signin = findViewById(R.id.btn_signIn);
        Button btn_signUp = findViewById(R.id.btn_signUp);

        mAuth = FirebaseAuth.getInstance();


        loginPassword.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {

                if (i == KeyEvent.KEYCODE_ENTER) {
                    mAuth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPassword.getText().toString())
                            .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        //클라이언트면 ->클라이언트 화면으로
                                        //프리랜서면 -> 프리랜서 화면으로
                                        startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                                        finish();
                                    } else {
                                        Toast.makeText(getApplicationContext(), "아이디나 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                                    }
                                }
                            });


                }
                return false;

            }

        });
        //로그인 버튼 입력
        btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signInWithEmailAndPassword(loginEmail.getText().toString(), loginPassword.getText().toString())
                        .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(LoginActivity.this, MenuActivity.class));
                                    finish();
                                } else {
                                    Toast.makeText(getApplicationContext(), "아이디나 비밀번호를 확인하세요.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });

        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class));
                finish();
            }
        });


    }
}
