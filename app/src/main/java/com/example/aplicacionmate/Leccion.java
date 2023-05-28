package com.example.aplicacionmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class Leccion extends AppCompatActivity implements View.OnClickListener{
    Button btn1, btn2, btn3;
    static TextView tx1, tx2;
    WebView wv;
    ImageView inicio, ejemploC;
    VideoView video;
    int numlec = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leccion);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        tx1 = findViewById(R.id.titulo);
        tx2 = findViewById(R.id.info);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

        inicio = (ImageView) findViewById(R.id.inicio);
        video = findViewById(R.id.video);

        wv = findViewById(R.id.webview);

        WebSettings webSettings = wv.getSettings();
        webSettings.setJavaScriptEnabled(true);

        recibirDato();
    }

    private void recibirDato(){
        //Videourl para locla y videorul2 para web view
        String videourl = "";
        Bundle extra = getIntent().getExtras();
        numlec = extra.getInt("leccion");

        if(numlec == 1){
            tx1.setText("La Decena");
            tx2.setText("¿Qué busco?\n*Que completen una decena dado un numero menor que 10, utilizando colecciones\n\n¿Que material necesito?\n\t*2 juegos de tarjetas numero-coleccion 0 al 10 por parejan\n\n¿Como guio el proceso?\n\t*Para iniciar el juego, pídales que coloquen tarjetas del 0 al 10 al centro. Del resto, deben de revolverlas y tomar las cartas para formar 10. Alguien puede tomar, por ejemplo, las cartas 1, 2, 5 y 2, o bien, algo como 0, 9 y 1");
            videourl = "android.resource://" + getPackageName() + "/" + R.raw.decenas;
            wv.loadUrl("https://youtube.com/shorts/JTUX_7wXQ_Y?feature=share");
        }else if(numlec == 2){
            tx1.setText("Hasta el 15");
            tx2.setText("¿Que tiene mas?\n¿Que busco?\n*Que comparen colecciones e objetos con procedimientos propios.\n¿Que material necesito?\n\tPara cada pareja 3 dados con el numero 6 oculto");
            videourl = "android.resource://" + getPackageName() + "/" + R.raw.quince;
            wv.loadUrl("https://youtube.com/shorts/JTUX_7wXQ_Y?feature=share");
        }else if(numlec == 3){
            tx1.setText("Hasta el 30");
            tx2.setText("Mas sorpresas\n¿Que busco?\n¿Que busco?\n\t*Que utilicen estrategias propias de conteo para cuantificar colecciones concretas de 15 a 30 objetos\n¿Que materiales necesita?\n\t*Una caja de sorpresas por estudiante\n\t*Coloque dentro de la caja objetos como piedritas, fichas y semillas. Puede haber de 15 a 30 objetos");
            videourl = "android.resource://" + getPackageName() + "/" + R.raw.treinta;
            wv.loadUrl("https://youtube.com/shorts/JTUX_7wXQ_Y?feature=share");
        }else if(numlec == 4){
            tx1.setText("Hasta el 50");
            tx2.setText("");
            videourl = "android.resource://" + getPackageName() + "/" + R.raw.cincuenta;
            wv.loadUrl("https://youtube.com/shorts/JTUX_7wXQ_Y?feature=share");
        }else{
            tx1.setText("Estrategias de suma y resta");
            tx2.setText("");
            inicio.setImageResource(R.mipmap.mate);
            videourl = "android.resource://" + getPackageName() + "/" + R.raw.decenas;
            wv.loadUrl("https://youtube.com/shorts/JTUX_7wXQ_Y?feature=share");
        }

        Uri uri = Uri.parse(videourl);
        video.setVideoURI(uri);

        MediaController mediacontroller = new MediaController(this);
        video.setMediaController(mediacontroller);
        mediacontroller.setAnchorView(video);



    }

    @Override
    public void onClick(View v) {
        Intent acceder = new Intent(Leccion.this, MainActivity.class);
        switch (v.getId()) {

            case R.id.btn1:

                break;
            case R.id.btn2:

                //acceder.putExtra("limitar",numlec);
                camara();
                break;
            case R.id.btn3:
                startActivity(acceder);
                break;
        }
    }

    private void camara(){
        Intent camaraA = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //if(camaraA.resolveActivity(getPackageManager())!=null){
            startActivityForResult(camaraA, 1);
        //}
    }
}