package com.editions.check_internet_connection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button button;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        button= findViewById(R.id.button);
        textView= findViewById(R.id.textView);



        // Old Option ===============================================
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Code Here
//
//                ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
//                NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();
//
//                if (networkInfo!=null && networkInfo.isConnected()){
//                    textView.setText("Internet Is Connected");
//                }else {
//                    textView.setText("NO Internet");
//                }
//
//            }
//        });
        // Old Option ===============================================


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkInternet()){
                    textView.setText("Internet is Connected");
                }else {
                    textView.setText("No Internet");
                }



            }
        });



    } // onClick end here================================================


    public boolean checkInternet(){
        ConnectivityManager connectivityManager= (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo= connectivityManager.getActiveNetworkInfo();

        if (networkInfo !=null && networkInfo.isConnected()){
            return true;
        }else {
            return false;
        }
    } // Mathord end Here===================================================


}