package com.example.quranapp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.quranapp.model.ChaptersItem;


import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {

     List<ChaptersItem> results = new ArrayList<>();

     public MainAdapter(List<ChaptersItem> results){
         this.results = results;
     }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

       return new MainViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder holder, int position) {
        final ChaptersItem chapters = results.get(position);

         holder.textViewSurahlatin.setText(chapters.getNameSimple());
         holder.textViewTerjemahanSurah.setText(chapters.getTranslatedName().getName());
        holder.textViewSurahArab.setText(chapters.getNameArabic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.itemView.getContext(),DetailSurahActivity.class);
                intent.putExtra("id", chapters.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSurahlatin, textViewTerjemahanSurah, textViewSurahArab;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSurahlatin = itemView.findViewById(R.id.tvSurahLatin);
            textViewTerjemahanSurah = itemView.findViewById(R.id.TvTerjemahanSurah);
            textViewSurahArab = itemView.findViewById(R.id.tvSurahArab);

        }
    }
    public void setData(List<ChaptersItem> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
}
