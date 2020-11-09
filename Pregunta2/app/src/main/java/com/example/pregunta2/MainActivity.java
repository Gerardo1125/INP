package com.example.pregunta2;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public int[] valores = {3,4,1,2,0,2,3};
    public int[] dias = {1,2,3,4,5,6,7};
    int init_X = 150, init_Y = 200,space_interlinear = 30;
    int line = 500;
    private Path[] lineas = new Path[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new miPropiaVista(this));
    }

    public class miPropiaVista extends View{

        public miPropiaVista(Context context) {
            super(context);
        }

        protected void onDraw(Canvas canvas){

            int add = 0, addText = 0;
            double valor = 5,calc = valor/(double)10;

            Paint miPincel = new Paint();

            miPincel.setColor(Color.GRAY);

            miPincel.setTextSize(23);
            miPincel.setTypeface(Typeface.SANS_SERIF);

            for ( int i = 0; i < lineas.length; i++){
                miPincel.setStrokeWidth(4);
                miPincel.setStyle(Paint.Style.STROKE);
                lineas[i] = new Path();
                lineas[i].lineTo(line,0);
                lineas[i].offset(init_X,(init_Y+add));
                canvas.drawPath(lineas[i],miPincel);
                miPincel.setStrokeWidth(1);
                miPincel.setStyle(Paint.Style.FILL);
                valor = valor -calc;
                canvas.drawText(""+valor, init_X-40, (205+add), miPincel);
                add = add+space_interlinear;
            }

            miPincel.setTextSize(25);

            for (int i = 0; i < dias.length; i++){
                canvas.drawText("Día "+dias[i], 165+addText, (210+add+10), miPincel);
                addText = addText+(line-15)/dias.length;
            }

            miPincel.setTextSize(40);

            canvas.drawText("Progreso", 300, 110,miPincel);


            estadísticas(canvas,miPincel);

            miPincel.setTextSize(25);

            canvas.translate(0, getWidth()/2);
            canvas.rotate(-90);
            canvas.drawText("Kilómetros",-60,90,miPincel);

        }

        public void estadísticas(Canvas canvas, Paint miPincel){

            int aux = valores[0], init = 175;
            miPincel.setStrokeWidth(6);
            miPincel.setTextSize(25);

            for (int i = 1; i < valores.length; i++){
                miPincel.setColor(Color.GRAY);
                canvas.drawText(""+aux, init-5, init_Y+space_interlinear*((10-aux*2)-1)-10,miPincel);
                int aux2 = valores[i];
                aux2 = 10 - aux2*2;
                aux = 10 - aux*2;
                miPincel.setColor(Color.RED);
                canvas.drawLine((float)init, (float)(init_Y+space_interlinear*(aux-1)), (float)(init+(line-15)/dias.length),(float)(init_Y+
                        space_interlinear*(aux2-1)),miPincel);

                aux = valores[i];
                init = init+(line-15)/dias.length;
            }
            miPincel.setColor(Color.GRAY);
            canvas.drawText(""+aux, init-5, init_Y+space_interlinear*((10-aux*2)-1)-10,miPincel);
            miPincel.setColor(Color.GRAY);
        }
    }
}