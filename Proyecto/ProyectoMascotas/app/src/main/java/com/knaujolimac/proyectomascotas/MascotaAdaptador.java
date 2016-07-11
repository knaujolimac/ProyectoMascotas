package com.knaujolimac.proyectomascotas;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.knaujolimac.miappcorporativa.R;

import java.util.ArrayList;

/**
 * Created by Juan Camilo Chaparro on 10/07/2016.
 */
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Le genera vida al Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota,parent,false);
        return new MascotaViewHolder(v);
    }


    /**
     * Cada vez quese recorre la lista de mascotas
     * @param mascotaViewHolder
     * @param position
     */
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder,final int position) {
        final Mascota mascota = mascotas.get(position);

        //Se setean los valores en el holder
        mascotaViewHolder.imgFoto.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreMascotaCv.setText(mascota.getNombreMascota());
        mascotaViewHolder.tvCantLikeMascotaCv.setText(String.valueOf(mascota.getCantidadLikes()));

        mascotaViewHolder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int cantidad = mascota.getCantidadLikes();
                //se actualiza la cantidad de las mascotas
                cantidad++;
                mascota.setCantidadLikes(cantidad);
                //Se actualiza la lista principal
                ((MainActivity)activity).actualizarObjetoLista(mascota,position);
                mascotaViewHolder.tvCantLikeMascotaCv.setText(String.valueOf(mascota.getCantidadLikes()));
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreMascotaCv;
        private TextView tvCantLikeMascotaCv;
        private ImageButton btnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreMascotaCv = (TextView)itemView.findViewById(R.id.tvNombreMascotaCv);
            tvCantLikeMascotaCv = (TextView)itemView.findViewById(R.id.tvCantLikeMascotaCv);
            btnLike = (ImageButton)itemView.findViewById(R.id.btnLike);
        }
    }
}
