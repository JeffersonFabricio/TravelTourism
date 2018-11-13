package programacao.mobile.android.traveltourism.database;

import android.arch.persistence.room.Room;
import android.content.Context;

public class GeradorBancoDeDados {

    public PagamentoDatabase gera(Context context){
        PagamentoDatabase travelTurismDB = Room.databaseBuilder(context, PagamentoDatabase.class, "TravelTurismDB").build();

        return travelTurismDB;
    }
}
