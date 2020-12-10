package com.example.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Ubicacion;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

public class MostrarDatos extends AppCompatActivity {

    RecyclerView recyclerView;
    Dato_Adapter adapter;
    FirebaseFirestore mFire;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_datos);
        mFire = FirebaseFirestore.getInstance();
        recyclerView = (RecyclerView)findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Query query = mFire.collection("Trayectoria");
        FirestoreRecyclerOptions<Ubicacion> firestoreRecyclerOptions =
                new FirestoreRecyclerOptions.Builder<Ubicacion>()
                .setQuery(query,Ubicacion.class).build();

        adapter = new Dato_Adapter(firestoreRecyclerOptions);
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop(){
        super.onStop();
        adapter.stopListening();
    }
}
