package com.example.tugas3;

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

import java.util.ArrayList;

public class AdapterRecycleView extends RecyclerView.Adapter<AdapterRecycleView.ViewHolder> {

    private ArrayList<ModelApk> dataitem;

    private Context context;


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView texthead;
        ImageView imageicon;

        LinearLayout list_apk;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            texthead = itemView.findViewById(R.id.title1);
            imageicon = itemView.findViewById(R.id.image1);
            list_apk = itemView.findViewById(R.id.list_apk);

        }
    }

    AdapterRecycleView(Context context,ArrayList<ModelApk> dataitem) {
        this.dataitem = dataitem;
        this.context = context;
    }
    @NonNull
    @Override
    public AdapterRecycleView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_apk1, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecycleView.ViewHolder holder, int position) {

        TextView texthead = holder.texthead;
        ImageView imageicon = holder.imageicon;

        texthead.setText(dataitem.get(position).getName());
        imageicon.setImageResource(dataitem.get(position).getImage());

        holder.list_apk.setOnClickListener(view ->{
            Toast.makeText(context, dataitem.get(position).getName(), Toast.LENGTH_SHORT).show();

            if (dataitem.get(position).getName().equals("google")) {
                context.startActivity(new Intent(context, GoogleActivity.class));
            }
            if (dataitem.get(position).getName().equals("line")) {
                context.startActivity(new Intent(context, LineActivity.class));
            }
            if (dataitem.get(position).getName().equals("twitter")) {
                context.startActivity(new Intent(context, TwitterActivity.class));
            }
        });



    }

    @Override
    public int getItemCount() {
        return dataitem.size();
    }


}
