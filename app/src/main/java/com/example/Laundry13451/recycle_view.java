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

import com.example.Laundry13451.adapter.AdapterGrid;
import com.example.Laundry13451.adapter.AdapterLinear;

import java.util.ArrayList;

public class recycle_view extends AppCompatActivity {

    ArrayList<modelproduk> modelprodukArrayList = new ArrayList<>();
    RecyclerView laundry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view);

        laundry = findViewById(R.id.laundry);

        baca_data_brg();

        showRecyclerList();
    }

    String KodeLaundry[]={"DC5577","ST1312","PW998","BC877",
            "KC334","GC332","SC887","HC996",};

    String typeLaundry[] = {"Dry Cleaning", "Setrika", "Premium wash",
            "Bedcover cleaning", "Karpet Cleaning", "Gorden Cleaning",
            "Shoes Cleaner", "Helm Cleaner"};

    int gambar[] = {R.drawable.dry, R.drawable.setrika, R.drawable.premi,
            R.drawable.cover, R.drawable.karpetcleaning, R.drawable.gorden,
            R.drawable.sepatu, R.drawable.head};

    int hargaLaundry[] = {10000, 5000, 25000,
            30000, 50000, 30000,
            30000, 25000};

    String satuanElektronik[] = {"1Kg", "1Kg", "1Kg",
            "1Kg", "1 Item", "1Kg",
            "1 Item", "1 Item"};
    int jumlahBrg[]={
            1,1,1,1,1,1,1,1
    };



    private void baca_data_brg() {
        for(int i=0; i<typeLaundry.length; i++) {
            modelprodukArrayList.add(new modelproduk(
                    KodeLaundry[i],
                    typeLaundry[i],
                    satuanElektronik[i],
                    hargaLaundry[i],
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
        laundry.setAdapter(menuAdapterLinear);
        laundry.setLayoutManager(new LinearLayoutManager(this));
    }
    private void showRecyclerGrid() {
        baca_data_brg();

        AdapterGrid menuAdapterGrid = new AdapterGrid(modelprodukArrayList, this);
        laundry.setAdapter(menuAdapterGrid);
        laundry.setLayoutManager(new GridLayoutManager(this, 2));
    }
}