package monografia.ufjf.myapplication;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

public class AtividadeFisicaContract {

    public final class Atividade implements BaseColumns
    {
        public static final String TABLE_NAME = "Atividade";
        public static final String COLUMN_NAME_NOME = "nome";
        public static final String COLUMN_NAME_TEMPO = "tempo";
        public static final String COLUMN_NAME_DISTANCIA = "distancia";
        public static final String COLUMN_NAME_PONTO = "ponto";
        public static final String CREATE_ATIVIDADE = "CREATE TABLE " + AtividadeFisicaContract.Atividade.TABLE_NAME + " ("
                + AtividadeFisicaContract.Atividade._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + AtividadeFisicaContract.Atividade.COLUMN_NAME_NOME + " TEXT, "
                + AtividadeFisicaContract.Atividade.COLUMN_NAME_TEMPO + " TEXT, "
                + AtividadeFisicaContract.Atividade.COLUMN_NAME_DISTANCIA + " TEXT, "
                + AtividadeFisicaContract.Atividade.COLUMN_NAME_PONTO + " TEXT "
                +")";
        public static final String DROP_CREATE_ATIVIDADE = "DROP TABLE IF EXISTS " + AtividadeFisicaContract.Atividade.TABLE_NAME;
    }

    public static void saveAtividade(SQLiteDatabase db, String nome, String tempo, String distancia, String ponto) {
        db.insert(AtividadeFisicaContract.Atividade.TABLE_NAME,null,
                createContentValue(nome, tempo, distancia, ponto));
    }

    public static void updateAtividade(SQLiteDatabase db, int id, String nome, String tempo, String distancia, String ponto) {
        db.update(AtividadeFisicaContract.Atividade.TABLE_NAME,createContentValue(nome, tempo, distancia, ponto),
                AtividadeFisicaContract.Atividade._ID + " = ?", new String[] {Integer.toString(id)});
    }

    private static ContentValues createContentValue(String nome, String tempo, String distancia, String ponto)
    {
        ContentValues cv = new ContentValues();
        cv.put(AtividadeFisicaContract.Atividade.COLUMN_NAME_NOME, nome);
        cv.put(AtividadeFisicaContract.Atividade.COLUMN_NAME_TEMPO, tempo);
        cv.put(AtividadeFisicaContract.Atividade.COLUMN_NAME_DISTANCIA, distancia);
        cv.put(AtividadeFisicaContract.Atividade.COLUMN_NAME_PONTO, ponto);
        return cv;
    }
    public static Cursor getAtividadeCursor(SQLiteDatabase db, String selection, String[] selectionArgs)
    {
        return db.query(AtividadeFisicaContract.Atividade.TABLE_NAME, new String[] {AtividadeFisicaContract.Atividade._ID, AtividadeFisicaContract.Atividade.COLUMN_NAME_NOME,
                AtividadeFisicaContract.Atividade.COLUMN_NAME_TEMPO, AtividadeFisicaContract.Atividade.COLUMN_NAME_DISTANCIA,
                AtividadeFisicaContract.Atividade.COLUMN_NAME_PONTO}, selection, selectionArgs,null,null,null,null);
    }


}
