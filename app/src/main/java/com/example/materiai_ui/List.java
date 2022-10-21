package com.example.materiai_ui;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class List extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    ListView lvItem;
    static ArrayList<Item> itemArrayList;
    ItemAdapter adapter;
    static int viTri= -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        lvItem = (ListView) findViewById(R.id.listViewIItem);
        itemArrayList = new ArrayList<>();
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav);

        bottomNavigationView.setOnNavigationItemReselectedListener(new BottomNavigationView.OnNavigationItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_profile:
                        Intent profile = new Intent(List.this, Profile.class);
                        startActivity(profile);
                        break;
                    case R.id.action_Logout:
                        alertDialog.setTitle("Đăng xuất");
                        alertDialog.setMessage("Bạn có chắc chắn muốn đăng xuất?");
                        alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                                Intent signIn = new Intent(List.this, SignIn.class);
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

        itemArrayList.add(new Item(R.drawable.mon1,"Kem bơ","Mô tả món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon2,"Lẩu gà ớt hiểm","Mô tả món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon3,"Gà kho gừng","Mô tả món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon4,"Thịt kho quẹt","Mô tả món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon5,"Mực hấp","Mô tả món ăn","8$"));
        itemArrayList.add(new Item(R.drawable.mon6,"Cá lóc kho tộ","Mô tả món ăn","8$"));

        adapter = new ItemAdapter(this, itemArrayList);
        lvItem.setAdapter(adapter);

        lvItem.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                viTri = position;
                Intent detail = new Intent(List.this, Detail.class);
                startActivity(detail);
            }
        });

        lvItem.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                viTri = i;
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(List.this);
                alertDialog.setTitle("Xóa Item?");
                alertDialog.setMessage("Bạn chắc chắn muốn xóa?");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(List.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                        itemArrayList.remove(viTri);
                        adapter.notifyDataSetChanged();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                alertDialog.show();
                return true;
            }
        });
    }
}