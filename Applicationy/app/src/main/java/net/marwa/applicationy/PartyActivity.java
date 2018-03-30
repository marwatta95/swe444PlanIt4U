package net.marwa.applicationy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import org.w3c.dom.Text;

public class PartyActivity extends AppCompatActivity {
    private  Button confirm;
    private Button cancel;
    private TextView hall;
    private TextView decor;
    private TextView photographer;
    private TextView music;
    private TextView clown;
    private TextView custom;
    private TextView food;
    private TextView makeup;
    private TextView hair;
    private DatabaseReference dr;
    private  Party party;
    private StorageReference storageReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);
// showing the party information

        Intent intent = getIntent();
        final String type1 = intent.getExtras().getString( "type" );
        final String date1 = intent.getExtras().getString( "date" );
        final String guests1 = intent.getExtras().getString( "guests" );
        final String location1 = intent.getExtras().getString( "location" );
        final String hall1 = intent.getExtras().getString( "hall" );
        final String decor1 = intent.getExtras().getString( "decor" );
        final String appetizer1 = intent.getExtras().getString( "appetizer" );
        final String main1 = intent.getExtras().getString( "main" );
        final String dessert1 = intent.getExtras().getString( "dessert" );
        final String cake1 = intent.getExtras().getString( "cake" );
        final String photographer1 = intent.getExtras().getString( "photographer" );
        final String singer1 = intent.getExtras().getString( "singer" );
        final String dj1 = intent.getExtras().getString( "dj" );
        final String band1 = intent.getExtras().getString( "band" );
        final String makeup1 = intent.getExtras().getString( "makeup" );
        final String hair1 = intent.getExtras().getString( "hair" );
        final String clown1=intent.getExtras().getString("clown");
        final String custom1=intent.getExtras().getString("custom");
        clown = (TextView) findViewById(R.id.textViewClown);
        clown.setVisibility(View.INVISIBLE);

        hall = (TextView)findViewById(R.id.textViewHall);
        hall.setText(hall1, TextView.BufferType.EDITABLE);

        decor = (TextView)findViewById(R.id.textViewDecor);
        decor.setText(decor1, TextView.BufferType.EDITABLE);

        photographer = (TextView)findViewById(R.id.textViewPhoto);
        photographer.setText(photographer1, TextView.BufferType.EDITABLE);

        music = (TextView)findViewById(R.id.textViewMusic);
        if(singer1!=null)
            music.setText(singer1, TextView.BufferType.EDITABLE);
        else   if(dj1!=null)
            music.setText(dj1, TextView.BufferType.EDITABLE);
        else if(band1!=null)
            music.setText(band1, TextView.BufferType.EDITABLE);


        food = (TextView)findViewById(R.id.textViewFood);
        if(appetizer1!=null)
            food.setText(appetizer1, TextView.BufferType.EDITABLE);
        else   if(main1!=null)
            food.setText(main1, TextView.BufferType.EDITABLE);
        else if(dessert1!=null)
            food.setText(dessert1, TextView.BufferType.EDITABLE);
        else if(cake1!=null)
            food.setText(cake1, TextView.BufferType.EDITABLE);

         makeup=(TextView)findViewById(R.id.textViewMakeup);
        makeup.setText(makeup1, TextView.BufferType.EDITABLE);

       hair=(TextView)findViewById(R.id.textViewHairDresser);
       hair.setText(hair1, TextView.BufferType.EDITABLE);

        custom = (TextView)findViewById(R.id.textViewCustom);
        custom.setText(custom1);

       if(type1.equals("Birthday")) {

           clown.setText(clown1);
           clown.setVisibility(View.VISIBLE);
       }



            // if the user want to cancel the party
        cancel=(Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {

                startActivity(new Intent(getApplicationContext(), UserHomeActivity.class));

            }
        });




      // if the user want to confirm the party
        confirm=(Button) findViewById(R.id.confirm);
        confirm.setOnClickListener( new View.OnClickListener()   {
            public void onClick(View v){
                if((appetizer1!=null))
         party= new Party((Hall)getIntent().getSerializableExtra("hall"),(Decor) getIntent().getSerializableExtra("decor"),(Band) getIntent().getSerializableExtra("Band"),(Clown) getIntent().getSerializableExtra("clown"),(Custom) getIntent().getSerializableExtra("custom"),(Dj)getIntent().getSerializableExtra("singer"),(Food) getIntent().getSerializableExtra("appetizer"),(Hair) getIntent().getSerializableExtra("hair"),(Photographer)getIntent().getSerializableExtra("photographer"),(MakeUp)getIntent().getSerializableExtra("makeup"),(Singer) getIntent().getSerializableExtra("singer"));
                if((dessert1!=null))
                    party= new Party((Hall)getIntent().getSerializableExtra("hall"),(Decor) getIntent().getSerializableExtra("decor"),(Band) getIntent().getSerializableExtra("Band"),(Clown) getIntent().getSerializableExtra("clown"),(Custom) getIntent().getSerializableExtra("custom"),(Dj)getIntent().getSerializableExtra("singer"),(Food) getIntent().getSerializableExtra("dessert"),(Hair) getIntent().getSerializableExtra("hair"),(Photographer)getIntent().getSerializableExtra("photographer"),(MakeUp)getIntent().getSerializableExtra("makeup"),(Singer) getIntent().getSerializableExtra("singer"));
                if((main1!=null))
                    party= new Party((Hall)getIntent().getSerializableExtra("hall"),(Decor) getIntent().getSerializableExtra("decor"),(Band) getIntent().getSerializableExtra("Band"),(Clown) getIntent().getSerializableExtra("clown"),(Custom) getIntent().getSerializableExtra("custom"),(Dj)getIntent().getSerializableExtra("singer"),(Food) getIntent().getSerializableExtra("main1"),(Hair) getIntent().getSerializableExtra("hair"),(Photographer)getIntent().getSerializableExtra("photographer"),(MakeUp)getIntent().getSerializableExtra("makeup"),(Singer) getIntent().getSerializableExtra("singer"));
                if((cake1!=null))
                    party= new Party((Hall)getIntent().getSerializableExtra("hall"),(Decor) getIntent().getSerializableExtra("decor"),(Band) getIntent().getSerializableExtra("Band"),(Clown) getIntent().getSerializableExtra("clown"),(Custom) getIntent().getSerializableExtra("custom"),(Dj)getIntent().getSerializableExtra("singer"),(Food) getIntent().getSerializableExtra("cake"),(Hair) getIntent().getSerializableExtra("hair"),(Photographer)getIntent().getSerializableExtra("photographer"),(MakeUp)getIntent().getSerializableExtra("makeup"),(Singer) getIntent().getSerializableExtra("singer"));

// to the database
             dr= FirebaseDatabase.getInstance().getReference();
                String id = dr.push().getKey();
             dr.child("Party").child(id).setValue(party);
                Toast.makeText( getApplicationContext(), "your party has been reserved", Toast.LENGTH_LONG ).show();



            }});




    }
}
