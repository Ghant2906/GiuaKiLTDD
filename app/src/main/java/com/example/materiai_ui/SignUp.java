package com.example.materiai_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignUp extends AppCompatActivity {
    Button btnSignUp, btnBackSignIn;
    TextView passWord, comfirmPass, email;

    private void thongBaoDangKy(String title, String mess, int x) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(mess);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if(x == 0)
                    dialogInterface.dismiss();
                if(x == 1) {
                    Intent signIn = new Intent(SignUp.this, SignIn.class);
                    startActivity(signIn);
                }
            }
        });
        alertDialog.show();
    }

    public int checkEmail(){
        int k = 0;
        while (SignIn.listEmail[k] != null && SignIn.listPass[k] != null) {
            if(email.getText().toString().equals(SignIn.listEmail[k])){
                return 1;
            }
            k++;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btnSignUp = (Button) findViewById(R.id.signUpButton_SignUp);
        btnBackSignIn = (Button) findViewById(R.id.backLoginButton_SignUp);
        passWord = (TextView) findViewById(R.id.passText_SignUp);
        comfirmPass = (TextView) findViewById(R.id.comfirmPassText);
        email = (TextView) findViewById(R.id.emailText_SignUp);

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(email.getText().toString().equals("") || passWord.getText().toString().equals("") ||comfirmPass.getText().toString().equals("") )
                    thongBaoDangKy("Lỗi","Vui lòng nhập đầy đủ thông tin",0);
                else if(checkEmail() == 1)
                    thongBaoDangKy("Lỗi","Tài khoản đã tồn tại", 0);
                else if(passWord.getText().toString().equals(comfirmPass.getText().toString())){
                    SignIn.tempEmail = email.getText().toString();
                    SignIn.tempPass = passWord.getText().toString();
                    thongBaoDangKy("Thành công","Đăng ký thành công. Vui lòng đăng nhập", 1);
                } else {
                    thongBaoDangKy("Lỗi","Mật khẩu không trùng nhau", 0);
                }
            }
        });

        btnBackSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent main = new Intent(SignUp.this, SignIn.class);
                startActivity(main);
            }
        });
    }
}