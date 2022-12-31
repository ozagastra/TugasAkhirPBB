package com.example.Laundry13451;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.UTS13555.R;

public class DetailActivty extends AppCompatActivity {
    ImageView ivImagebrg;
    TextView tvKodebrg, tvNamabrg, tvSatuanbrg, tvHargabrg,tvJumlahbrg,tvJumlahHarga;
    Button btnPlus, btnMinus, btnBayar;

    int tampungTotal=0;
    int totalHarga=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivImagebrg = findViewById(R.id.iv_image_brg);
        tvKodebrg = findViewById(R.id.tv_kode_brg);
        tvNamabrg = findViewById(R.id.tv_nama_brg);
        tvHargabrg = findViewById(R.id.tv_harga_brg);
        tvSatuanbrg = findViewById(R.id.satuan_brg);
        tvJumlahbrg = findViewById(R.id.tv_jumlah_brg);
        tvJumlahHarga = findViewById(R.id.tv_jumlah_harga);
        btnPlus = findViewById(R.id.btn_plus);
        btnMinus = findViewById(R.id.btn_minus);
        btnBayar = findViewById(R.id.btn_beli);

        btnBayar.setOnClickListener(v -> {
            goToCetak();
        });

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);
        String title = getIntent().getStringExtra("namaBrg");
        setActionBarTitle(title);

        getExtra();

        btnPlus.setOnClickListener(v -> {
            addTotal();
        });

        btnMinus.setOnClickListener(v -> {
            minusTotal();
        });
    }

    private void goToCetak() {
        Intent intent = new Intent(this, CetakActivity.class);
        intent.putExtra("namaBrg", getIntent().getStringExtra("namaBrg"));
        intent.putExtra("hargaBrg", getIntent().getIntExtra("hargaBrg", 0));
        intent.putExtra("jumlahBrg", getIntent().getIntExtra("jumlahBrg", 0));
        intent.putExtra("totalHarga", totalHarga * tampungTotal);

        startActivity(intent);
    }

    private void getExtra() {
        String kodeBrg = getIntent().getStringExtra("kodeBrg");
        String namaBrg = getIntent().getStringExtra("namaBrg");
        String satuanBrg = getIntent().getStringExtra("satuanBrg");
        int hargaBrg = getIntent().getIntExtra("hargaBrg", 0);
        int jumlahBrg = getIntent().getIntExtra("jumlahBrg", 0);
        int gambarBrg = getIntent().getIntExtra("imageBrg", R.drawable.premi);

        tampungTotal=jumlahBrg;
        totalHarga=hargaBrg;

        setData(kodeBrg, namaBrg, satuanBrg, hargaBrg, jumlahBrg, gambarBrg);
    }

    private void setData(String kodeBrg, String namaBrg, String satuanBrg, int hargaBrg, int jumlahBrg, int gambarBrg
    ) {
        tvKodebrg.setText(kodeBrg);
        tvNamabrg.setText(namaBrg);
        tvSatuanbrg.setText(satuanBrg);
        tvHargabrg.setText(String.format("Rp. %s", hargaBrg));
        tvJumlahbrg.setText(String.valueOf(jumlahBrg));
        ivImagebrg.setImageResource(gambarBrg);

        tvJumlahbrg.setText(String.format("Rp. %s", hargaBrg));
    }

    private void setActionBarTitle(String title) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    private void addTotal() {
        tampungTotal=tampungTotal+1;

        tvJumlahbrg.setText(String.valueOf(tampungTotal));
        tvJumlahbrg.setText(String.format("Rp. %s", calcTotalPrice()));
    }

    private void minusTotal() {
        if(tampungTotal!=0) {
            tampungTotal=tampungTotal-1;
        }

        tvJumlahbrg.setText(String.valueOf(tampungTotal));
        tvJumlahbrg.setText(String.format("Rp. %s", calcTotalPrice()));
    }

    private int calcTotalPrice() {
        return totalHarga * tampungTotal;
    }
}