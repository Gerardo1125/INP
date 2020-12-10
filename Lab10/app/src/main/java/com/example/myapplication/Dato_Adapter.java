package com.example.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.model.Ubicacion;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;

public class Dato_Adapter extends FirestoreRecyclerAdapter<Ubicacion, Dato_Adapter.ViewHolder> {

    /**
     * Create a new RecyclerView adapter that listens to a Firestore Query.  See {@link
     * FirestoreRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public Dato_Adapter(@NonNull FirestoreRecyclerOptions<Ubicacion> options) {

        super(options);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_datos,parent,false);

        return new ViewHolder(view);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @NonNull Ubicacion ubicacion) {
        viewHolder.fecha.setText(ubicacion.getFecha());
        viewHolder.hora.setText(ubicacion.getHora());
        viewHolder.latitud.setText(""+ubicacion.getLatitud());
        viewHolder.longitud.setText(""+ubicacion.getLongitud());
        viewHolder.velocidad.setText(""+ubicacion.getVelocidad());
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView fecha;
        TextView hora;
        TextView latitud;
        TextView longitud;
        TextView velocidad;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            fecha = itemView.findViewById(R.id.fecha);
            hora = itemView.findViewById(R.id.hora);
            latitud = itemView.findViewById(R.id.latitud);
            longitud = itemView.findViewById(R.id.longitud);
            velocidad = itemView.findViewById(R.id.velocidad);
        }
    }

}
