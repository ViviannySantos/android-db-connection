package developer.app.com.connection.controller;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import developer.app.com.connection.R;
import developer.app.com.connection.model.MyDatabase;

public class MainActivity extends AppCompatActivity {

    private ListView listaMenu;
    private MyDatabase db;

    private List<String> clientes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializando a listMenu
        listaMenu = (ListView) findViewById(R.id.listaClientes);

        //Inicializa e recupera os dados do banco
        db = new MyDatabase(this);
        clientes = db.listClientes();

        // Popular a adapter com os dados da banco
        listaMenu.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, clientes));
    }
}
