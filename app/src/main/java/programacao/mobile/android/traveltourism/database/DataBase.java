package programacao.mobile.android.traveltourism.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my_database";
    public static final String TABLE_NAME = "traveltourism_tbl";

    public DataBase(Context context){
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_NAME +" ("
                +"id_pacote INTEGER PRIMARY KEY autoincrement,"
                +" local varchar(45) NOT NULL ,"
                +" img varchar(45) NOT NULL,"
                +" qtd_dias varchar(45) NOT NULL,"
                +" valor_dia double"
                + ");");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
