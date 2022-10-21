package com.example.materiai_ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class Profile extends AppCompatActivity {
    Button btnBack, btnFL, btnLogOut;
    TextView followerTextView, tv;
    int followerText;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        btnFL = (Button) findViewById(R.id.button);
        followerTextView = (TextView) findViewById(R.id.fllowerText);
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        tv = (TextView) findViewById(R.id.textView7);

        bottomNavigationView.setSelectedItemId(R.id.action_profile);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_list:
                        Intent list = new Intent(Profile.this, List.class);
                        startActivity(list);
                        break;
                    case R.id.action_Logout:
                        alertDialog.setTitle("Đăng xuất");
                        alertDialog.setMessage("Bạn có chắc chắn muốn đăng xuất?");
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Intent signIn = new Intent(Profile.this, SignIn.class);
                                startActivity(signIn);
                            }
                        });
                        alertDialog.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        alertDialog.show();
                        break;
                }
            }
        });


        btnFL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btnFL.getText().equals("Follow")) {
                    followerText =Integer.parseInt(followerTextView.getText().toString()) + 1;
                    followerTextView.setText("0"+followerText);
                    btnFL.setText("UnFollow");
                }
                else {
                    followerText =Integer.parseInt(followerTextView.getText().toString()) - 1;
                    followerTextView.setText("0"+followerText);
                    btnFL.setText("Follow");}
            }
        });

    }
}