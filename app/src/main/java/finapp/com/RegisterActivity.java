package finapp.com;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.regex.Pattern;


public class RegisterActivity extends AppCompatActivity {
    EditText idText;
    EditText pwText;
    Button joinBtn;
    Button cancleBtn;

    public String status=""; //1=프리랜서 2=클라이언트

    // 파이어베이스 데이타베이스 객체 생성
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();

    private String email ;
    private String pw ;


    // 비밀번호 정규식
    private static final Pattern PASSWORD_PATTERN = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$");

    // 파이어베이스 인증 객체 생성
    private FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        idText = findViewById(R.id.idText);
        pwText = findViewById(R.id.pwText);
        joinBtn = findViewById(R.id.joinBtn);
        cancleBtn = findViewById(R.id.cancleBtn);

        final RadioGroup radioGroup = findViewById(R.id.radio_group);
        RadioButton radio_client = findViewById(R.id.radio_client);
        RadioButton radio_free = findViewById(R.id.radio_free);

        // 파이어베이스 인증 객체 선언
        firebaseAuth = FirebaseAuth.getInstance();

        /* 프로젝트 데이터 베이스 추가 - 귀찮아서 여기다가 했음
        HashMap user;
        user = new HashMap<>();
        user.put("projectname", "모션그래픽");
        user.put("startmonth",6);
        user.put("startday", 10);
        user.put("endmonth", 6);
        user.put("endday", 20);
        user.put("today_start",-27);
        user.put("today_end",-10);
        user.put("day1",5);
        user.put("day2",8);
        user.put("day3",10);
        databaseReference.child("project1").push().setValue(user);
        */

        /*
        HashMap user;
        user = new HashMap<>();
        user.put("projectname", "브랜드컨셉");
        user.put("startmonth",6);
        user.put("startday", 8);
        user.put("endmonth", 6);
        user.put("endday", 23);
        user.put("today_start",-22);
        user.put("today_end",-7);
        user.put("day1",11);
        user.put("day2",14);
        user.put("day3",21);
        databaseReference.child("project1").push().setValue(user);
*/

        radioGroup.setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {

                        switch (i) {
                            case R.id.radio_free:
                                status = "free";
                                break;

                            case R.id.radio_client:
                                status = "client";
                                break;

                            default:
                                break;
                        }
                    }
                });


        joinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                //myRef.setValue(nameText.getText().toString());
                email = idText.getText().toString();
                pw = pwText.getText().toString();



                if (isValidEmail() && isValidPasswd()) {
                    createUser(email, pw);
                    Intent it = new Intent(RegisterActivity.this, LoginActivity.class);
                    startActivity(it);
                }
            }
        });
    }

    public void onStart()
    {
        super.onStart();

        FirebaseUser currentUser = firebaseAuth.getCurrentUser();

    }
    // 이메일 유효성 검사
    private boolean isValidEmail() {
        if (email.isEmpty()) {
            // 이메일 공백
            Toast.makeText(RegisterActivity.this,"이메일 공백",Toast.LENGTH_SHORT).show();


            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            // 이메일 형식 불일치
            Toast.makeText(RegisterActivity.this,"이메일 형식 불일치",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    // 비밀번호 유효성 검사
    private boolean isValidPasswd() {
        if (pw.isEmpty()) {
            // 비밀번호 공백
            Toast.makeText(RegisterActivity.this,"비밀번호 공백",Toast.LENGTH_SHORT).show();
            return false;
        } else if (!PASSWORD_PATTERN.matcher(pw).matches()) {
            // 비밀번호 형식 불일치
            Toast.makeText(RegisterActivity.this,"비밀번호 형식 불일치",Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    // 회원가입
    private void createUser(String email, String password) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // 회원가입 성공
                           // Log.e("왜오류나는거야", "onComplete: Failed=" + task.getException().getMessage());
                            FirebaseUser currentUser = firebaseAuth.getCurrentUser();
                            HashMap user;
                            user = new HashMap<>();
                            user.put("uid", currentUser.getUid());
                            user.put("email", currentUser.getEmail());
                            user.put("status", status);

                            databaseReference.child("user").push().setValue(user);
                            Toast.makeText(RegisterActivity.this, R.string.success_signup, Toast.LENGTH_SHORT).show();

                        } else {
                            // 회원가입 실패
                            Toast.makeText(RegisterActivity.this, "실패", Toast.LENGTH_SHORT).show();

                    }
                    }
                });
    }


}

