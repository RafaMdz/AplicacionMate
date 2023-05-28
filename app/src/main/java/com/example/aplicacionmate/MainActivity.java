package com.example.aplicacionmate;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2, btn3, btn4, btn5;
    int limitador = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);

    }


    private void recibirDato(){
        Bundle extra = getIntent().getExtras();
        if(limitador <= extra.getInt("limitar")) {
            limitador = extra.getInt("limitar");
        }
    }

    @Override
    public void onClick(View v) {
        Intent acceder = new Intent(MainActivity.this, Leccion.class);

        switch (v.getId()) {

            case R.id.btn1:
                acceder.putExtra("leccion",1);
                startActivity(acceder);
                break;
            case R.id.btn2:
                //Variable para verificar que se pueded acceder a la leccion 2
                if(limitador >= 1){
                    acceder.putExtra("leccion",2);
                    startActivity(acceder);
                }else{
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn3:
                //Variable para verificar que se pueded acceder a la leccion 2
                if(limitador >= 2){
                    acceder.putExtra("leccion",3);
                    startActivity(acceder);
                }else{
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn4:
                if(limitador >= 3){
                    acceder.putExtra("leccion",4);
                    startActivity(acceder);
                }else{
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn5:
                if(limitador >= 4){
                    acceder.putExtra("leccion",5);
                    startActivity(acceder);
                }else{
                    Toast.makeText(this, "Leccion no valida para ingresar", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}