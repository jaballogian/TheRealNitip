package com.nitip.therealnitip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SementaraPostActivity extends AppCompatActivity {

    private EditText namaBarangEidtText, hargaBarangEditText, jenisNitipEditText, namaPemilikEditText, tanggalEditText, asalKotaEditText;
    private Button masukanDataButton;
    private ImageButton fotoBarangImageButton;

    DatabaseReference dataBase;
    FirebaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sementara_post);

        dataBase = FirebaseDatabase.getInstance().getReference();
        helper = new FirebaseHelper(dataBase);

        namaBarangEidtText = (EditText) findViewById(R.id.namaBarangEditText);
        hargaBarangEditText = (EditText) findViewById(R.id.hargaBarangEditText);
        jenisNitipEditText = (EditText) findViewById(R.id.jenisNiitipEditText);
        namaPemilikEditText = (EditText) findViewById(R.id.namaPemilikEditText);
        tanggalEditText = (EditText) findViewById(R.id.tanggalEditText);
        asalKotaEditText = (EditText) findViewById(R.id.asalKotaEditText);

        fotoBarangImageButton = (ImageButton) findViewById(R.id.fotoBarangButton);
        masukanDataButton = (Button) findViewById(R.id.masukanDataButton);

        masukanDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String namaBarang = namaBarangEidtText.getText().toString();
                String hargaBarang = hargaBarangEditText.getText().toString();
                String jenisNitip = jenisNitipEditText.getText().toString();
                String namaPemilik = namaPemilikEditText.getText().toString();
                String tanggal = tanggalEditText.getText().toString();
                String asalKota = asalKotaEditText.getText().toString();

                BarangInHome b = new BarangInHome();
                b.setNamaBarang(namaBarang);
                b.setHargaBarang(hargaBarang);
                b.setJenisNitip(jenisNitip);
                b.setNamaPemilik(namaPemilik);
                b.setTanggal(tanggal);
                b.setAsalKota(asalKota);

                helper.save(b);

                Intent keMainActivity = new Intent(SementaraPostActivity.this, MainActivity.class);
                startActivity(keMainActivity);

            }
        });

        /**
        fotoBarangImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
         **/
    }
}
