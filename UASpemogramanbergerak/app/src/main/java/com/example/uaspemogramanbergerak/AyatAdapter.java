package com.example.uaspemogramanbergerak;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uaspemogramanbergerak.ayatmodel.VersesItem;
import com.example.uaspemogramanbergerak.terjemahan.ItemTranslation;

import java.util.List;

public class AyatAdapter extends RecyclerView.Adapter<AyatAdapter.ViewHolder> {

    private static List<VersesItem> list1;
    private static List<ItemTranslation> list2;
    public AyatAdapter(List<VersesItem> list1, List<ItemTranslation> list2){
        this.list1 = list1;
        this.list2 = list2;
    }
    @NonNull
    @Override
    public AyatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.ayat, parent, false)
        );
    }
    @Override
    public void onBindViewHolder(@NonNull AyatAdapter.ViewHolder holder, int position) {
        VersesItem list = list1.get(position);
        ItemTranslation list_ = list2.get(position);

        holder.textViewAyat.setText(list.getTextUthmani());
        holder.textViewTerjemahanAyat.setText(list_.getText());
        holder.textViewNomorAyat.setText(String.valueOf(position + 1));
    }
    @Override
    public int getItemCount() {
        return list2.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewAyat, textViewNomorAyat, textViewTerjemahanAyat;

        public ViewHolder(View itemView){
            super(itemView);

            textViewAyat = itemView.findViewById(R.id.pembukaayat);
            textViewNomorAyat = itemView.findViewById(R.id.nomorayat);
            textViewTerjemahanAyat = itemView.findViewById(R.id.menterjemah);
        }
    }
    public void setData(List<VersesItem> data, List<ItemTranslation> data1) {

        list1.clear();
        list1.addAll(data);

        list2.clear();
        list2.addAll(data1);
        notifyDataSetChanged();
    }

}
