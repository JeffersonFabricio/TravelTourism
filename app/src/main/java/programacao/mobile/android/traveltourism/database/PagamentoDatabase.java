package programacao.mobile.android.traveltourism.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import programacao.mobile.android.traveltourism.model.Pagamento;

@Database(entities = {Pagamento.class}, version = 1)
public abstract class PagamentoDatabase extends RoomDatabase {

    public abstract PagamentoDao getPagamentoDao();
}
