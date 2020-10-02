package com.example.appcliente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.UUID;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private TCPSingleton tcp;
    private EditText user;
    private EditText pasword;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enviar = findViewById(R.id.activador);
        pasword = findViewById(R.id.contraseña);
        user = findViewById(R.id.usuario);

        tcp = TCPSingleton.getInstance();
        tcp.setCliente(this);
        tcp.start();

        enviar.setOnClickListener(this);
    }

    public void messageArrival(String message){

        runOnUiThread(

                ()->{

                }
        );

    }

    @Override
    public void onClick(View view) {

        //reconocer que se pulso el boton instanciado
        switch (view.getId()){

            case R.id.activador:

                Gson gson = new Gson();

                String id = UUID.randomUUID().toString();
                String usuarios = user.getText().toString();
                String contraseñas = pasword.getText().toString();

                ArrayList<Cuenta> obj = new ArrayList<>();

                obj.add(new Cuenta(id,usuarios,contraseñas));

                String json = gson.toJson(obj);
                tcp.envioDeDatos(json);

                SharedPreferences preferences = getSharedPreferences("usuarios", MODE_PRIVATE);
                preferences.edit().putString("usuariosRegistrados", json);

                break;
        }
    }
}