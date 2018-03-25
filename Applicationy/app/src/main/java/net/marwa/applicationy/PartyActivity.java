package net.marwa.applicationy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_party);

        cancel=(Button) findViewById(R.id.cancel);

        cancel.setOnClickListener(new View.OnClickListener()   {
            public void onClick(View v)  {

                startActivity(new Intent(getApplicationContext(), UserHomeActivity.class));

            }
        });
        //       makeParty=(Button) findViewById(R.id.);
      /*  getIntent().getSerializableExtra("hall");
        getIntent().getSerializableExtra("appetizer");
        getIntent().getSerializableExtra("decor");
        getIntent().getSerializableExtra("photographer");
      /*  getIntent().getSerializableExtra("hall");
        getIntent().getSerializableExtra("hall");
        getIntent().getSerializableExtra("hall");*/
        confirm=(Button) findViewById(R.id.confirm);
        confirm.setOnClickListener( new View.OnClickListener()   {
            public void onClick(View v){



            }});




    }
}
