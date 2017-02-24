package com.example.rosemberg.sinemaps.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rosemberg.sinemaps.R;
import com.example.rosemberg.sinemaps.asynctasks.ListaSineAsyncTask;
import com.example.rosemberg.sinemaps.sine.Sine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class PesqSinePorCod extends AppCompatActivity implements View.OnClickListener{
    private EditText etSineCod;
    private Button btnPesquisar;
    private TextView tvMostraSine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesq_sine_por_cod);

        etSineCod = (EditText) findViewById(R.id.etSineCod);
        btnPesquisar = (Button) findViewById(R.id.btnPesquisar);
        tvMostraSine = (TextView) findViewById(R.id.tvMostraSine);

        btnPesquisar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            String cod = etSineCod.getText().toString();

            ListView lista1 = (ListView) findViewById(R.id.lista1);
            ListaSineAsyncTask listaSineBrasil = new ListaSineAsyncTask();


            try {
                ArrayAdapter<Sine> adapter = new ArrayAdapter<> (this,android.R.layout.simple_list_item_1, listaSineBrasil.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/cod/"+cod).get());
                lista1.setAdapter(adapter);
            }catch (ExecutionException e){
                    e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
    }
}
