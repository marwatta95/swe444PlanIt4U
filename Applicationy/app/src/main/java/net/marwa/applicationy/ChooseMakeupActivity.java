package net.marwa.applicationy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChooseMakeupActivity extends AppCompatActivity {
    ListView listView;
    List<MakeUp> list;
    ProgressDialog progressDialog;
    final ArrayList<String> keyList = new ArrayList<>();
    private DatabaseReference databaseReference;
    MyAdapterChooseMakeup myAdapter;
    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_choose_makeup );
        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        listView=(ListView) findViewById( R.id.list1);


        Intent intent = getIntent();
        final String type = intent.getExtras().getString( "type" );
        final String date = intent.getExtras().getString( "date" );
        final String guests = intent.getExtras().getString( "guests" );
        final String location = intent.getExtras().getString( "location" );
        final String hall = intent.getExtras().getString( "hall" );
        final String decor = intent.getExtras().getString( "decor" );
        final String appetizer = intent.getExtras().getString( "appetizer" );
        final String main = intent.getExtras().getString( "main" );
        final String dessert = intent.getExtras().getString( "dessert" );
        final String cake = intent.getExtras().getString( "cake" );
        final String photographer = intent.getExtras().getString( "photographer" );
        final String singer = intent.getExtras().getString( "singer" );


        list = new ArrayList<>();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference(SingerActivity.DATABASE_PATH);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                list.clear();

                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    keyList.add(snap.getKey());

                    MakeUp makeUp = snap.getValue(MakeUp.class);
                    if(!makeUp.dates.contains(date)){
                        list.add(makeUp);
                    }


                }
                myAdapter = new MyAdapterChooseMakeup(ChooseMakeupActivity.this,R.layout.data_items_choose_makeup,list);
                listView.setAdapter(myAdapter);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });




        FloatingActionButton fab = (FloatingActionButton) findViewById( R.id.fab );
        fab.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make( view, "Replace with your own action", Snackbar.LENGTH_LONG )
                        .setAction( "Action", null ).show();
            }
        } );
    }

}
