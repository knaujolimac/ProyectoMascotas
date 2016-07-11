package com.knaujolimac.proyectomascotas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;

import com.knaujolimac.miappcorporativa.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> listMascotas;
    private RecyclerView rvMascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        ImageButton btnFavorito = (ImageButton)findViewById(R.id.btnFavorito);

        btnFavorito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MascotaFavoritoActivity.class);
                startActivity(intent);
            }
        });

        rvMascotas = (RecyclerView)findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);

        //Inicializar mascotas
        this.inicializarMascotas();
        //Inicializar adaptador
        this.inicializarAdaptador();

    }

    public void verFavoritos(){

    }

    /**
     * Inicializa el adaptador
     */
    private void inicializarAdaptador(){
        MascotaAdaptador mascotaAdaptador = new MascotaAdaptador(this.listMascotas, this);
        rvMascotas.setAdapter(mascotaAdaptador);
    }

    /**
     * Método encargado de inicializar las mascotas
     */
    private void inicializarMascotas() {
        listMascotas = new ArrayList<Mascota>();
        listMascotas.add(new Mascota(R.drawable.perroa,"Ander"));
        listMascotas.add(new Mascota(R.drawable.perrob,"Barry"));
        listMascotas.add(new Mascota(R.drawable.perroc,"Bruno"));
        listMascotas.add(new Mascota(R.drawable.perrod,"Chispita"));
        listMascotas.add(new Mascota(R.drawable.perroe,"Chispi"));
        listMascotas.add(new Mascota(R.drawable.perrof,"Dardo"));
        listMascotas.add(new Mascota(R.drawable.perrog,"Deus"));
        listMascotas.add(new Mascota(R.drawable.perroh,"Darwin"));
        listMascotas.add(new Mascota(R.drawable.gatoa,"Diosa"));
        listMascotas.add(new Mascota(R.drawable.gatob,"Dinamita"));
        listMascotas.add(new Mascota(R.drawable.gatoc,"Cash"));
        listMascotas.add(new Mascota(R.drawable.gatod,"Cornelius"));
    }

    /**
     * Método encargado de actualizar los valores de la lista principal
     * @param mascota
     * @param index
     */
    public void actualizarObjetoLista(Mascota mascota, int index){
        listMascotas.set(index,mascota);
    }


}
