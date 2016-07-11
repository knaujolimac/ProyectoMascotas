package com.knaujolimac.proyectomascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.widget.ImageButton;

import com.knaujolimac.miappcorporativa.R;

import java.util.ArrayList;

public class MascotaFavoritoActivity extends AppCompatActivity {

    ArrayList<Mascota> listMascotasFavoritas;
    private RecyclerView rvMascotasFav;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorito);

        rvMascotasFav = (RecyclerView)findViewById(R.id.rvMascotasFav);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBarFav);
        setSupportActionBar(miActionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ImageButton btnFavorito = (ImageButton)findViewById(R.id.btnFavorito);
        btnFavorito.setVisibility(ImageButton.INVISIBLE);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotasFav.setLayoutManager(llm);

        // mascotas favoritas
        this.obtenerMascotasFavoritas();
        //Inicializar adaptador
        this.inicializarAdaptador();

    }

    /**
     * Inicializa el adaptador
     */
    private void inicializarAdaptador(){
        MascotaFavoritoAdaptador mascotaAdaptador = new MascotaFavoritoAdaptador(this.listMascotasFavoritas, this);
        rvMascotasFav.setAdapter(mascotaAdaptador);
    }

    /**
     * Método encarcagado de inicializar las mascotas favoritas
     */
    private void obtenerMascotasFavoritas(){
        listMascotasFavoritas = new ArrayList<Mascota>();
        listMascotasFavoritas.add(new Mascota(R.drawable.perroc,"Bruno",50));
        listMascotasFavoritas.add(new Mascota(R.drawable.perrod,"Chispita",30));
        listMascotasFavoritas.add(new Mascota(R.drawable.perroh,"Darwin",25));
        listMascotasFavoritas.add(new Mascota(R.drawable.gatob,"Dinamita",15));
        listMascotasFavoritas.add(new Mascota(R.drawable.gatoc,"Cash",10));
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(MascotaFavoritoActivity.this,MainActivity.class);
            startActivity(intent);
            //se finaliza el activity para optimizar la memoria
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }

}
