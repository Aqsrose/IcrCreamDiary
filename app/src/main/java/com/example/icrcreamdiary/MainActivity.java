package com.example.icrcreamdiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements  NavigationView.OnNavigationItemSelectedListener {

ImageView homebtn,addbtn,tipbtn;
    //for bottomFragment

     EditText addtitle, addContent;
 //  Button btnAdd;
    MiddleFragment middleFragment;
    BottomFragment bottomFragment;
    FragmentManager fragmentManager;

    //top
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    //buttons and image
//    Button btnMainSignIn, btnMainSignUp, btnLogout, btnAdd;
   // ImageView imgProfile;

    //firebase
    FirebaseAuth auth;

    //arraylist
    ArrayList<IceCreamList> content;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        homebtn=findViewById(R.id.homebtn);
        addbtn=findViewById(R.id.addbtn);
        tipbtn=findViewById(R.id.tipbtn);

        replaceFragment(new MiddleFragment());
        homebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             replaceFragment(new MiddleFragment());
            }
        });
        addbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new BottomFragment());

            }
        });
        tipbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                replaceFragment(new TipFragment());


            }
        });

//        fragmentManager=this.getSupportFragmentManager();
//        middleFragment=(MiddleFragment) fragmentManager.findFragmentById(R.id.middleFragment);
//        bottomFragment=(BottomFragment) fragmentManager.findFragmentById(R.id.bottomFragment);

        //toolbar,navigationBar and drawer
        toolbar = findViewById(R.id.toolbar);
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navView);

        //setting toolbar
        setSupportActionBar(toolbar);

        //setting navigation bar
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_Bar_open, R.string.navigation_Bar_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.bringToFront();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.home);


        //btn
//        tvTitle = findViewById(R.id.tvTitle);
//        tvContent = findViewById(R.id.tvContent);
        addtitle = findViewById(R.id.addtitle);
        addContent = findViewById(R.id.addContent);

//        btnAdd = findViewById(R.id.btnAdd);
//        Log.d("btn added ",btnAdd+"");
//         btnAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (addtitle.getText().toString().isEmpty() || addContent.getText().toString().isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Please enter all fields!", Toast.LENGTH_SHORT).show();
//                } else {
//                    ApplicationClass.content.add(new IceCreamList(addtitle.getText().toString().trim(), addContent.getText().toString().trim()));
//                    Toast.makeText(MainActivity.this, "Ice cream recipe successfully added", Toast.LENGTH_SHORT).show();
//                    addtitle.setText(null);
//                    addContent.setText(null);
//                }
//            }
//        });

        auth = FirebaseAuth.getInstance();

//        btnMainSignIn = findViewById(R.id.btnMainSignIn);
//        btnMainSignUp = findViewById(R.id.btnMainSignUp);
//        btnLogout = findViewById(R.id.btnLogout);
//        imgProfile = findViewById(R.id.imgProfile);
//

//        btnMainSignIn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
//                startActivity(intent);
//            }
//        });

//        btnMainSignUp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
//                startActivity(intent);
//            }
//        });
//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                auth.signOut();
//                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
//                startActivity(intent);
//
//            }
//        });


    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager= getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();

        }
    }




    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {
        switch (menuitem.getItemId()) {
            case R.id.home:
                break;
            case R.id.tips:
                Intent intenttip = new Intent(MainActivity.this, TipsActivity.class);
                startActivity(intenttip);
                break;
            case R.id.logoutt:
                auth.signOut();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                break;
            case R.id.location:
                Intent intentmap = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=33.58021135614505, 73.01065135495061(rawalpindi)"));
                startActivity(intentmap);
            case R.id.about:
                Toast.makeText(this, "about", Toast.LENGTH_SHORT).show();
                break;
            case R.id.feedback:
                Toast.makeText(this, "feedback", Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}