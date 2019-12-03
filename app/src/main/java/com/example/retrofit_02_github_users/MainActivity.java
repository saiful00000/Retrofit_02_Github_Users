package com.example.retrofit_02_github_users;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView myRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRecyclerView = findViewById(R.id.my_recycler_view_id);

        getUsers();
    }

    private void getUsers() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final Api api = retrofit.create(Api.class);

        final Call<List<User>> users = api.getUsers();

        users.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                List<User> usersList = response.body();

                int n = usersList.size();

                String[] userNames = new String[n];
                String[] userIds = new String[n];
                String[] userTypes = new String[n];
                String[] userAdmins = new String[n];

                System.out.println("..........................................................................."+n);

                for (int i = 0; i < n; i++) {
                    userNames[i] = usersList.get(i).getLogin();
                    userIds[i] = Integer.toString(usersList.get(i).getId());
                    userTypes[i] = usersList.get(i).getType();
                    userAdmins[i] = usersList.get(i).getSite_admin();
                }

                myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                myRecyclerView.setAdapter(new MainListAdapter(userNames, userIds, userTypes, userAdmins));
                myRecyclerView.addItemDecoration(new DividerItemDecoration(getBaseContext(), LinearLayout.VERTICAL));

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
