package com.example.Laundry13451.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.Laundry13451.DetailActivty;
import com.example.Laundry13451.modelproduk;
import com.example.UTS13555.R;

import java.util.ArrayList;


public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.viewHolder> {
        ArrayList<modelproduk> modelprodukArrayList;
        Context context;

        public AdapterGrid(ArrayList<modelproduk> modelprodukArrayList, Context context) {
            this.modelprodukArrayList = modelprodukArrayList;
            this.context = context;
        }


        @NonNull
        @Override
        public AdapterGrid.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.menu_item_grid, parent, false);
            return new AdapterGrid.viewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull AdapterGrid.viewHolder holder, int position) {
            holder.image_brg.setImageResource(modelprodukArrayList.get(position).getGambar());
            holder.kode_brg.setText(modelprodukArrayList.get(position).getKodeProduk());
            holder.nama_brg.setText(modelprodukArrayList.get(position).getNama());
            holder.satuan_brg.setText(modelprodukArrayList.get(position).getSatuan());
            holder.harga_brg.setText(String.format("Rp. %s", modelprodukArrayList.get(position).getHarga()));
            holder.jumlah_brg.setText(String.valueOf(modelprodukArrayList.get(position).getJumlah()));
            holder.item_brg.setOnClickListener(v -> {
                Toast.makeText(context, modelprodukArrayList.get(position).getNama(), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivty.class);
                intent.putExtra("imageBrg", modelprodukArrayList.get(position).getGambar());
                intent.putExtra("kodeBrg", modelprodukArrayList.get(position).getKodeProduk());
                intent.putExtra("namaBrg", modelprodukArrayList.get(position).getNama());
                intent.putExtra("satuanBrg", modelprodukArrayList.get(position).getSatuan());
                intent.putExtra("hargaBrg", modelprodukArrayList.get(position).getHarga());
                intent.putExtra("jumlahBrg", modelprodukArrayList.get(position).getJumlah());

                context.startActivity(intent);
            });
        }

        @Override
        public int getItemCount() {
            return modelprodukArrayList.size();
        }

        protected class viewHolder extends RecyclerView.ViewHolder {
            CardView item_brg;
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


