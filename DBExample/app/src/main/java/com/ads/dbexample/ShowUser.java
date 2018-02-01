package com.ads.dbexample;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class ShowUser extends AppCompatActivity {
    private static final String TAG = ShowUser.class.getSimpleName() ;
    private ArrayList<UsersDataModel> list;
    private ShowUseAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_user);
        new GetUsers().execute();
        //setup recycleView of user in list
        list = new ArrayList<>();
        RecyclerView listView = findViewById(R.id.list);
        adapter = new ShowUseAdapter(this,list);
        listView.setLayoutManager(new LinearLayoutManager(ShowUser.this));
        listView.setAdapter(adapter);
    }

    /**
     * <h2>GetUsers<h2/>
     * Fetch inserted user in async call
     */
    private class GetUsers extends AsyncTask<Void,Void,ArrayList<UsersDataModel>>{

        @Override
        protected ArrayList<UsersDataModel> doInBackground(Void... voids) {
            return (ArrayList<UsersDataModel>) MainActivity.db.getUserDataModelDao().getAllUsers();
        }

        @Override
        protected void onPostExecute(ArrayList<UsersDataModel> usersDataModels) {
            super.onPostExecute(usersDataModels);
            Log.v(TAG,"Users - "+usersDataModels.toString());
            list.addAll(usersDataModels);
           adapter.notifyDataSetChanged();
        }
    }
}
