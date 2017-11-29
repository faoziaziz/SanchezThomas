package org.labseni.sanchezthomas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

public class cekjadwal extends AppCompatActivity {
    public static final String JAM_KEY="jam";
    public static final String TANGGAL_KEY="tanggal";
    public static final String AGENDA_KEY="agenda";
    private EditText EditTanggal;
    private EditText EditJam;
    private EditText EditAgenda;
    private String tanggal;
    private String jam;
    private String agenda;
    private StorageReference mStorageRef;

   // mStorageRef = FirebaseStorage.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cekjadwal);
    }
    public void saveJadwal(View view)
    {
        EditTanggal= (EditText) findViewById(R.id.editTanggal);
        EditJam= (EditText) findViewById(R.id.editJam);
        EditAgenda=(EditText) findViewById(R.id.editAgenda);
        jam=EditJam.getText().toString();
        tanggal=EditTanggal.getText().toString();
        agenda=EditAgenda.getText().toString();

        if(jam.isEmpty()||agenda.isEmpty()||jam.isEmpty()){return;}
        Map<String, Object> dataToSave=new HashMap<String, Object>();
        dataToSave.put(JAM_KEY, jam);
        dataToSave.put(AGENDA_KEY, agenda);
        dataToSave.put(TANGGAL_KEY, tanggal);



    }
}
