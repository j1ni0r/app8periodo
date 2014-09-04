package pojo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by nonilto on 04/09/14.
 */
public abstract class DAO {
    protected SQLiteDatabase banco;
    protected ContentValues dados;

    public abstract long salvar(String id);
    public abstract long excluir(String id);
}
