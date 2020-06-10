package com.example.agile_phoneshoping.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.agile_phoneshoping.User;
import com.example.agile_phoneshoping.database.AppDatabase;
import com.example.agile_phoneshoping.R;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {


    private TextInputEditText edtUsername;
    private TextInputEditText edtPassword;
    private Button btnLogin;
    private TextView tvSignUp;
    Intent intent;

    //tạo biến để lưu data
    public  static  final  String SHARED_PREFS="SHAREDPREFS";
    public  static  final  String USERNAME="text";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //com.example.agile_phoneshoping.data
        AppDatabase db = Room.databaseBuilder(this,
                AppDatabase.class, "user.db").allowMainThreadQueries().build();
        initView();

        //test data
     db.userDAO().insert(new User(1,"nguyễn văn tú","tunvph",5555,"hà nam","tiền mặt","user"));
//List<user> result=db.userDAO().getAll();
//String a=result.get(0).name;
//Toast.makeText(getApplicationContext(),"name user là : "+a,Toast.LENGTH_SHORT).show();



        // Login navigate
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          saveData();
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //Sign Up navigate

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    private void initView(){
        edtUsername = (TextInputEditText) findViewById(R.id.edtUsername);
        edtPassword = (TextInputEditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);




    }
    //save data
    public void saveData(){
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PREFS, MODE_PRIVATE );
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(USERNAME,edtUsername.getText().toString());
        editor.apply();

//        editor.commit();
        String userName=sharedPreferences.getString(USERNAME,"not found");
        Log.e("user đăng nhập  là ", ":"+userName );
        Toast.makeText(getApplicationContext(),"user đăng nhập  là "+userName,Toast.LENGTH_SHORT).show();


    }
}
//c1 save user
//c1
//                SharedPreferences prefs=getSharedPreferences("File", MODE_PRIVATE );
//                SharedPreferences.Editor e=  prefs.edit();
//                //keys should be constants as well, or derived from a constant prefix in a loop.
//                e.putString("Email1", "example@example.com").putString("Password1", "password1");
//              e.putString("Email2", "example_2@example.com").putString("Password2", "password2");
//           //  commit once, not twice
//                e.commit();
//
//               //not found should be a constant in a xml resource file
//                String mail1=prefs.getString("Email1","not found");
//                Toast.makeText(getApplicationContext(),"emai là "+mail1,Toast.LENGTH_SHORT).show();