package com.example.uaspemogramanbergerak;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uaspemogramanbergerak.surahmodel.ChaptersItem;

import java.util.List;

public class Mainadapter extends RecyclerView.Adapter<Mainadapter.ViewHolder> {

    private List<ChaptersItem> results;

    public Mainadapter(List<ChaptersItem> results) {
        this.results = results;
    }

    @NonNull
    @Override
    public Mainadapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull Mainadapter.ViewHolder holder, int position) {
        final ChaptersItem chapters = results.get(position);

        holder.textViewSurahLatin.setText(chapters.getNameSimple());
        holder.textViewTerjemahanSurah.setText(chapters.getTranslatedName().getName());
        holder.textViewSurahArab.setText(chapters.getNameArabic());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), Detailsurah.class);
                intent.putExtra("nama surah", chapters.getNameSimple());
                intent.putExtra("arab", chapters.getNameArabic());
                intent.putExtra("nama latin", chapters.getNameComplex());
                intent.putExtra("id", chapters.getId());
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewSurahLatin , textViewTerjemahanSurah, textViewSurahArab;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewSurahLatin = itemView.findViewById(R.id.tvSurahLatin);
            textViewTerjemahanSurah = itemView.findViewById(R.id.tvTerjemahanSurah);
            textViewSurahArab = itemView.findViewById(R.id.tvSurahArab);
        }
    }

    public void setData(List<ChaptersItem> data){
        results.clear();
        results.addAll(data);
        notifyDataSetChanged();
    }
}
