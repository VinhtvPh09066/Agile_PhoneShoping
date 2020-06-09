package com.example.agile_phoneshoping.fragment;

import android.app.AlertDialog;
import android.content.SharedPreferences;
import android.net.http.SslCertificate;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import com.example.agile_phoneshoping.AppDatabase;
import com.example.agile_phoneshoping.R;
import com.example.agile_phoneshoping.activity.MainActivity;
import com.example.agile_phoneshoping.user;

import java.util.List;

import javax.xml.namespace.QName;

public class ProfileFragment extends Fragment {
ImageView imageView1;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        imageView1=view.findViewById(R.id.imageView1);
//lấy data từ SharedPreferences
        AppDatabase db = Room.databaseBuilder(getContext(),
                AppDatabase.class, "user.db").allowMainThreadQueries().build();
      List<user> users=  db.userDAO().getUserByName("nguyễn văn tú");
        String a=users.get(0).address;

        Toast.makeText(getContext(),"data"+a,Toast.LENGTH_SHORT).show();
        SharedPreferences preferences = getActivity().getSharedPreferences("SHAREDPREFS",getActivity().MODE_PRIVATE);
        String user_name = preferences.getString("text",null);
        Log.e("tag data-- ------ ", "onCreateView: "+user_name );



        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder build= new AlertDialog.Builder(getActivity());
                build.setView(R.layout.dialog_updatename);
                build.setTitle("Alert");
                build.create().show();

            }
        });
        return view;
    }

}
