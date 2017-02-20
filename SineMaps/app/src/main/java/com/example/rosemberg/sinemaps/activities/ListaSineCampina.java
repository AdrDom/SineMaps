package com.example.rosemberg.sinemaps.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.rosemberg.sinemaps.R;
import com.example.rosemberg.sinemaps.asynctasks.ListaSineAsyncTask;
import com.example.rosemberg.sinemaps.sine.Sine;

import java.util.concurrent.ExecutionException;

public class ListaSineCampina extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sine_campina);

        ListView lista2 = (ListView) findViewById(R.id.lista2);
        ListaSineAsyncTask listaSineCampina = new ListaSineAsyncTask();

        try {
            ArrayAdapter<Sine> adapter = new ArrayAdapter<> (this,android.R.layout.simple_list_item_1, listaSineCampina.execute("http://mobile-aceite.tcu.gov.br/mapa-da-saude/rest/emprego/latitude/-7.242662/longitude/-35.9716057/raio/100").get());
            lista2.setAdapter(adapter);
        }catch (InterruptedException | ExecutionException e){
            e.printStackTrace();
        }
    }
}
