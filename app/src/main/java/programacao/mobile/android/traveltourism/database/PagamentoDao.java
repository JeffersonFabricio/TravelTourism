package programacao.mobile.android.traveltourism.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

import programacao.mobile.android.traveltourism.model.Pagamento;

@Dao
public interface PagamentoDao {

    @Insert
    void insere(Pagamento pagamento);

}
