package com.advcalender.dragonslayer.advancealarm;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DashBoard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);
        final Button checkNetwork = (Button) findViewById(R.id.checkNetwork);
        checkNetwork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isDeviceOnline()) {
                    checkNetwork.setText(R.string.connected);
                }
                else checkNetwork.setText(R.string.disconnected);
            }
        });
    }

    private boolean isDeviceOnline() {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
