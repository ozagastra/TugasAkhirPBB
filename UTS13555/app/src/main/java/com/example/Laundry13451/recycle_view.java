package com.example.Laundry13451;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Laundry13451.R;
import com.example.Laundry13451.adapter.AdapterGrid;
import com.example.Laundry13451.adapter.AdapterLinear;

import java.util.ArrayList;

public class recycle_view extends AppCompatActivity {

    ArrayList<modelproduk> modelprodukArrayList = new ArrayList<>();
    RecyclerView elektronik;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        elektronik = findViewById(R.id.elektronik);

        baca_data_brg();

        showRecyclerList();
    }

    String KodeElektronik[]={"BN557","HD112","JK998","KC877",
            "KB334","KD332","KJ887","SM996","SM998","VR210"};

    String namaElektronik[] = {"Ban Mobil Softcompound", "Head Unit Android", "Jok Mobil",
            "Kaca Mobil Anti Peluru", "Kaliper Brembo", "Klakson Denso",
            "Kulit Jok 100% Asli", "Setir Mobil Racing", "Spion Mobil", "Velg Racing"};

    int gambar[] = {R.drawable.ban, R.drawable.head, R.drawable.jok,
            R.drawable.kaca, R.drawable.kaliper, R.drawable.klakson,
            R.drawable.kulit, R.drawable.setir, R.drawable.spion, R.drawable.velg};

    int hargaBrg[] = {10000000, 15000000, 50000000,
            100000000, 50000000, 150000000,
            200000000, 20000000, 3000000, 25000000};

    String satuanElektronik[] = {"Pasang", "Unit", "Unit",
            "Unit", "Unit", "Unit",
            "Meter", "Unit", "Unit", "Pasang"};
    int jumlahBrg[]={
            1,1,1,1,1,1,1,1,1,1
    };



    private void baca_data_brg() {
        for(int i=0; i<namaElektronik.length; i++) {
            modelprodukArrayList.add(new modelproduk(
                    KodeElektronik[i],
                    namaElektronik[i],
                       satuanElektronik[i],
                    hargaBrg[i],
                    jumlahBrg[i],
                    gambar[i]
            ));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.item1) {
            showRecyclerList();
        } else {
            showRecyclerGrid();
        }

        return super.onOptionsItemSelected(item);
    }

    private void showRecyclerList() {
        baca_data_brg();

        AdapterLinear menuAdapterLinear = new AdapterLinear(modelprodukArrayList, this);
        elektronik.setAdapter(menuAdapterLinear);
        elektronik.setLayoutManager(new LinearLayoutManager(this));
    }
    private void showRecyclerGrid() {
        baca_data_brg();

        AdapterGrid menuAdapterGrid = new AdapterGrid(modelprodukArrayList, this);
        elektronik.setAdapter(menuAdapterGrid);
        elektronik.setLayoutManager(new GridLayoutManager(this, 2));
    }
}