package com.marishkakravchenko.net.ui.activities;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.marishkakravchenko.net.R;
import com.marishkakravchenko.net.data.network.RestService;
import com.marishkakravchenko.net.data.network.ServiceGenerator;
import com.marishkakravchenko.net.data.network.res.ResUserModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    public static String LOG_TAG = "my_log";

    @BindView(R.id.button)
    Button button;

    @BindView(R.id.main_coordinator_container)
    CoordinatorLayout mCoordinatorLayout;

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        textView = (TextView) findViewById(R.id.textView);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Super fast hello world from JRebel for Android", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fetch();
            }
        });
    }

    private void fetch() {
      /* if (NetworkStatusChecker.isNetworkAvailable(this)) {*/
        RestService RestService = ServiceGenerator.createService(RestService.class);
        Call<ResUserModel> call = RestService.repoContributors("tseglevskiy", "testdata");
        call.enqueue((new Callback<ResUserModel>() {
            @Override
            public void onResponse(Call<ResUserModel> call, Response<ResUserModel> response) {
                assert textView != null;
                getUserData(response.body());
            }

            @Override
            public void onFailure(Call<ResUserModel> call, Throwable t) {
                assert textView != null;
                textView.setText("Something went wrong: " + t.getMessage());

            }
        }));
       /* } else {
            showSnackBar("Сеть на данный момент недоступна, попробуйте позже");
        }*/
    }

    private void getUserData(ResUserModel userModel) {

        for (ResUserModel.User user : userModel.getUsers()) {
            System.out.println(user.getName());
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showSnackBar(String message) {
        Snackbar.make(mCoordinatorLayout, message, Snackbar.LENGTH_LONG).show();

    }


}
