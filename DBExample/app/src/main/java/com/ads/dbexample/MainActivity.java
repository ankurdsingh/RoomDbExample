package com.ads.dbexample;

import android.annotation.SuppressLint;
import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static UserDatabaseHelper db;
    @SuppressLint("StaticFieldLeak")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                UserDatabaseHelper.class, getString(R.string.app_name)).build();
        final EditText name = findViewById(R.id.et_name);
        final EditText age = findViewById(R.id.et_age);
        final EditText prof = findViewById(R.id.et_prof);
        Button submit = findViewById(R.id.button);
        //inserting user in db
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                int id = (int) System.currentTimeMillis();
                System.out.println("Details - "+id+" : "+name.getText()+" : "+age.getText()+" : "+prof.getText());
                UsersDataModel user = new UsersDataModel(id,name.getText().toString(),Integer.parseInt(age.getText().toString()),prof.getText().toString());
                new InsertUser().execute(user);

            }
        });



    }

    /**
     * <h2>InsertUser</h2>
     *Inserted user in db via async call
     */
    private class InsertUser extends AsyncTask<UsersDataModel, Void, Void> {
        @Override
        protected Void doInBackground(UsersDataModel... params) {
            db.getUserDataModelDao().insert(params[0]);
            return null;
        }

        @Override
        protected void onPostExecute(Void a) {
                //  after inseting user just show the details in next activity
                Intent newUser = new Intent(MainActivity.this,ShowUser.class);
                startActivity(newUser);
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

        //no inspection Simplifiable If Statement
        if (id == R.id.action_settings) {
            //Opening details of inserted user
            Intent intent = new Intent(MainActivity.this,ShowUser.class);
            startActivity(intent);

            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
