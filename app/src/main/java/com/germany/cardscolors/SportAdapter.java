package com.germany.cardscolors;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.ViewHolder>  {


    // Rest of ViewHolder code.
    private ArrayList<Sport> listaDeportes;
    private Context contexto;
    private LayoutInflater mInflater;

    public SportsAdapter(ArrayList<Sport> listaDeportes, Context contexto) {
        this.listaDeportes = listaDeportes;
        this.contexto = contexto;
        mInflater = LayoutInflater.from(contexto);
    }

    @NonNull
    @Override
    public SportsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.list_item,
                parent, false);
        return new ViewHolder( mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull SportsAdapter.ViewHolder holder, int position) {
        String title = listaDeportes.get(position).getTitle();
        String info = listaDeportes.get(position).getInfo();
        int imagen = listaDeportes.get(position).getImageResource();

//        holder.sportsImage.setImageResource(imagen);
        Glide.with(contexto).load(listaDeportes.get(position).getImageResource()).into(holder.sportsImage);
        holder.idTxtTitle.setText(title);
        holder.idTxtInfo.setText(info);
    }

    @Override
    public int getItemCount() {
        return listaDeportes.size();
    }
    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView sportsImage;
        TextView idTxtTitle;
        TextView idTxtInfo;
     SportsAdapter adapter;

        public ViewHolder(@NonNull View itemView,  SportsAdapter adapter) {
            super(itemView);
                this.adapter= adapter;
            sportsImage = itemView.findViewById(R.id.sportsImage);
            idTxtTitle= itemView.findViewById(R.id.idTxtTitle);
            idTxtInfo = itemView.findViewById(R.id.idTxtInfo);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Sport currentSport = listaDeportes.get(getAdapterPosition());

            Intent detailIntent = new Intent(contexto, DetalleActividad.class);
                detailIntent.putExtra("Item", currentSport);


            contexto.startActivity(detailIntent);
        }
    }
}
