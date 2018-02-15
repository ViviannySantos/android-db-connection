package developer.app.com.connection.model;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ViviannySantos on 15/01/18.
 */

public class MyDatabase extends SQLiteAssetHelper {

    private static final String DATABASE_NAME = "bd.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     * Lista as clientes cadastrados.
     *
     * @return listUsers
     */
    public List<String> listClientes() {

        List<String> listUsers = new ArrayList<String>();

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Procura no banco e pega na tabela tipos, o campo tipo
        String [] sqlSelect = {"cli_nome"}; // coluna
        String sqlTables = "cliente";  // tabela

        qb.setTables(sqlTables);
        Cursor c = qb.query(db, sqlSelect, null, null,
                null, null, null);

        String tipo;
        c.moveToFirst();
        //Transformando os itens de cada posição do cursor e adicionando a Lista para retornar
        //Adapters só aceitam List ou String[]
        do {
            tipo = c.getString(0);
            listUsers.add(tipo);
        } while (c.moveToNext());
        c.close();

        return listUsers;
    }

    /**
     * Busca a dados do cliente.
     *
     * @param documento1
     * @return listUsers
     */
    public List<String> dadosCliente(String documento1) {

        List<String> listUsers = new ArrayList<String>();

        SQLiteDatabase db = getReadableDatabase();

        // Select All Query
        String selectQuery = "select (cli_nome, cli_rg) from cliente where cli_doc1 like '"+documento1+"'";
        Cursor c = db.rawQuery(selectQuery, null);

        String mensagem;
        c.moveToFirst();
        do {
            mensagem = c.getString(0);
            listUsers.add(mensagem);
        } while (c.moveToNext());
        c.close();

        return listUsers;

    }

}
