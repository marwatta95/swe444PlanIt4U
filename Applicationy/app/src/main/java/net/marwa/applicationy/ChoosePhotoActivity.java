package net.marwa.applicationy;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChoosePhotoActivity extends AppCompatActivity {
    ListView listView;
    List<Photographer> list;
    ProgressDialog progressDialog;
    final ArrayList<String> keyList = new ArrayList<>();
    private DatabaseReference databaseReference;
    public static final String DATABASE_PATH = "Photographer";
    MyAdapterChoosePhoto myAdapter;

    private Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_choose_photo);
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

        list = new ArrayList<>();

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.show();

        databaseReference = FirebaseDatabase.getInstance().getReference(DecorActivity.DATABASE_PATH);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                progressDialog.dismiss();
                list.clear();

                for(DataSnapshot snap : dataSnapshot.getChildren()){
                    keyList.add(snap.getKey());

                    Photographer photographer = snap.getValue(Photographer.class);
                    if(!photographer.dates.contains(date)){
                        list.add(photographer);
                    }


                }
                myAdapter = new MyAdapterChoosePhoto(ChoosePhotoActivity.this,R.layout.data_items_choose_photo,list);
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


        next=(Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                final  Intent intent=new Intent(ChoosePhotoActivity.this, ChoosePhotoActivity.class);
                intent.putExtra( "type", type );
                intent.putExtra( "date", date );
                intent.putExtra( "guests", guests );
                intent.putExtra( "location", location );
                intent.putExtra( "hall", hall );
                intent.putExtra( "decor", decor );
                intent.putExtra( "appetizer", appetizer );
                intent.putExtra( "main", main );
                intent.putExtra( "dessert", dessert );
                intent.putExtra( "cake", cake );

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,final int position, long id) {
                        AlertDialog.Builder alert = new AlertDialog.Builder(
                                ChoosePhotoActivity.this );
                        alert.setTitle( "Confirm" );
                        alert.setMessage( "Are you sure you want this? " );
                        alert.setPositiveButton( "YES", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                intent.putExtra( "photographer", databaseReference.getRoot().child( DATABASE_PATH ).child( keyList.get( position ) ).getClass().toString() );
                                Toast.makeText( getApplicationContext(), "Chosen Successfully!!!", Toast.LENGTH_LONG ).show();
                                dialog.dismiss();

                            }
                        } );
                        alert.setNegativeButton( "NO", new DialogInterface.OnClickListener() {

                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        } );

                        alert.show();

                    }
                });




                startActivity(intent);




            }
        });
    }
}
