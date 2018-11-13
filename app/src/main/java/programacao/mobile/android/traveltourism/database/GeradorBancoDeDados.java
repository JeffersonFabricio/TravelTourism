package programacao.mobile.android.traveltourism.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class GeradorBancoDeDados {

    public PacoteDatabase gera(Context context){
        PacoteDatabase travelTurismDB = Room.databaseBuilder(context, PacoteDatabase.class, "TravelTurismDB").build();

        return travelTurismDB;
    }
}
