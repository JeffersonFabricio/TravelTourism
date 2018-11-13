package programacao.mobile.android.traveltourism.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import programacao.mobile.android.traveltourism.model.Pacote;

@Database(entities = {Pacote.class}, version = 1)
public abstract class PacoteDatabase extends RoomDatabase {

    abstract PacoteDao getPacoteDao();
}
