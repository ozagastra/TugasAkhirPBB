package com.example.Laundry13451.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Laundry13451.DetailActivty;
import com.example.Laundry13451.R;
import com.example.Laundry13451.modelproduk;

import java.util.ArrayList;

public class AdapterLinear extends RecyclerView.Adapter<AdapterLinear.viewHolder> {
    ArrayList<modelproduk> modelprodukrArrayList;
    Context context;
    public AdapterLinear(ArrayList<modelproduk> modelproduk, Context context) {
        this.modelprodukrArrayList = modelproduk;
        this.context = context;


    }


    @NonNull
    @Override
    public AdapterLinear.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.menu_item_linear, parent, false);
        return new AdapterLinear.viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterLinear.viewHolder holder, int position) {
        holder.image_brg.setImageResource(modelprodukrArrayList.get(position).getGambar());
        holder.kode_brg.setText(modelprodukrArrayList.get(position).getKodeProduk());
        holder.nama_brg.setText(modelprodukrArrayList.get(position).getNama());
        holder.satuan_brg.setText(modelprodukrArrayList.get(position).getSatuan());
        holder.harga_brg.setText(String.format("Rp. %s", modelprodukrArrayList.get(position).getHarga()));
        holder.jumlah_brg.setText(String.valueOf(modelprodukrArrayList.get(position).getJumlah()));
        holder.item_brg.setOnClickListener(v -> {
            Toast.makeText(context, modelprodukrArrayList.get(position).getNama(), Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(context, DetailActivty.class);
            intent.putExtra("imageBrg", modelprodukrArrayList.get(position).getGambar());
            intent.putExtra("kodeBrg", modelprodukrArrayList.get(position).getKodeProduk());
            intent.putExtra("namaBrg", modelprodukrArrayList.get(position).getNama());
            intent.putExtra("satuanBrg", modelprodukrArrayList.get(position).getSatuan());
            intent.putExtra("hargaBrg", modelprodukrArrayList.get(position).getHarga());
            intent.putExtra("jumlahBrg", modelprodukrArrayList.get(position).getJumlah());

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modelprodukrArrayList.size();
    }

    protected class viewHolder extends RecyclerView.ViewHolder {
        LinearLayout item_brg;
        ImageView image_brg;
        TextView kode_brg, nama_brg, satuan_brg, harga_brg, jumlah_brg;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            item_brg = itemView.findViewById(R.id.item_brg);
            image_brg = itemView.findViewById(R.id.iv_image_brg);
            kode_brg = itemView.findViewById(R.id.tv_kode_brg);
            nama_brg = itemView.findViewById(R.id.tv_nama_brg);
            satuan_brg = itemView.findViewById(R.id.tv_satuan_brg);
            harga_brg = itemView.findViewById(R.id.tv_harga_brg);
            jumlah_brg = itemView.findViewById(R.id.tv_jumlah_brg);
        }
    }
}