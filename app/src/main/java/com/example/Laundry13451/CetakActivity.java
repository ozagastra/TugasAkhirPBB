package com.example.Laundry13451;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.Laundry13451.R;

public class CetakActivity extends AppCompatActivity {

    TextView namaBarang, hargaBarang, jumlahBarang, totalHarga, ppn, bayar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cetak);

        namaBarang = findViewById(R.id.tv_nama_brg);
        hargaBarang = findViewById(R.id.tv_harga_brg);
        jumlahBarang = findViewById(R.id.tv_jumlah_brg);
        totalHarga = findViewById(R.id.tv_total_harga);
        ppn = findViewById(R.id.tv_ppn);
        bayar = findViewById(R.id.tv_bayar);

        setData();
    }

    private void setData() {


        namaBarang.setText(getIntent().getStringExtra("namaBrg"));

    }
}