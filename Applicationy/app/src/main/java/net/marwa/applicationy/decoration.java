package net.marwa.applicationy;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

public class decoration extends AppCompatActivity {

    private Button selectImage;
    private StorageReference storage;
    private static final int GALLERY_INTENT=2;
    private EditText price,id;
    private double price1;
    private int id1;
    private ImageView image;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decoration);
          //get the spinner from the xml.
        Spinner dropdown = findViewById(R.id.type);
         //create a list of items for the spinner.
        String[] items = new String[]{"1", "2", "three"};
            //create an adapter to describe how the items are displayed, adapters are used in several places in android.
          //There are multiple variations of this, but this is the basic variant.
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
         //set the spinners adapter to the previously created one.
        dropdown.setAdapter(adapter);

        selectImage=(Button) findViewById(R.id.upload_decoration);
        storage= FirebaseStorage.getInstance().getReference();
        selectImage.setOnClickListener(new View.OnClickListener()
        {
@Override
            public void onClick(View view){

    Intent intent = new Intent(Intent.ACTION_PICK);
    intent.setType("image/*");

    startActivityForResult(intent,GALLERY_INTENT);

        }


        });
    }
@Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode, data);
        if(requestCode==GALLERY_INTENT&& resultCode==RESULT_OK){
            Uri uri = data.getData();
            price1= parseDouble(price.getText().toString());
            id1=parseInt(id.getText().toString());
            class_decoration decorationInfo  =new class_decoration(id1,price1,data);
            databaseReference.child(String.valueOf(id1)).setValue(decorationInfo);

            StorageReference filePath=storage.child("Decoration photos");
filePath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
    @Override
    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
        Toast.makeText(decoration.this,"add done.",Toast.LENGTH_LONG).show();


    }
});}
}

}
