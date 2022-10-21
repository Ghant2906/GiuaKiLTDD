package com.example.materiai_ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import kotlinx.coroutines.Delay;

public class SignIn extends AppCompatActivity {
    Button btnLogin, btnSignUp;
    TextView email, pass;
    static String[] listEmail = new String[50], listPass = new String[50];;
    static String tempEmail = null, tempPass = null;

    private void thongBao(String title, String mess){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle(title);
        alertDialog.setMessage(mess);
        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        alertDialog.show();
    };

    public int checkAccount(){
        int i = 0;
        while (listEmail[i] != null) {
            if(email.getText().toString().equals(listEmail[i]) && pass.getText().toString().equals(listPass[i])) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        btnLogin = (Button) findViewById(R.id.loginButton_Login);
        btnSignUp = (Button) findViewById(R.id.signUpButton_Login);
        email = (TextView) findViewById(R.id.emailText_Login);
        pass = (TextView) findViewById(R.id.pass_Login);
        listEmail[0] = "Thang";
        listPass[0] = "29062002";

        int index = 0;
        while (listEmail[index] != null){
            index++;
        }
        listEmail[index] = tempEmail;
        listPass[index] = tempPass;

        tempEmail = null;
        tempPass = null;

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("add", String.valueOf(listEmail[0]));
                Log.e("add", String.valueOf(listPass[0]));
                Log.e("add", String.valueOf(listEmail[1]));
                Log.e("add", String.valueOf(listPass[1]));
                Log.e("add", String.valueOf(listEmail[2]));
                Log.e("add", String.valueOf(listPass[2]));
                if(email.getText().toString().equals("") || pass.getText().toString().equals(""))
                    thongBao("Error","Vui lòng nhập tài khoản, mật khẩu");
                else if(checkAccount() == 1) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    Intent list = new Intent(SignIn.this, List.class);
                    startActivity(list);
                }else
                    thongBao("Error","Tài khoản hoặc mật khẩu sai!");
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent signUp = new Intent(SignIn.this, SignUp.class);
                startActivity(signUp);
            }
        });


    }
}