package programacao.mobile.android.traveltourism.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Pagamento {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private int numeroCartao;
    private int mesValidadeCartao;
    private int anoValidadeCartao;
    private int cvc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(int numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getMesValidadeCartao() {
        return mesValidadeCartao;
    }

    public void setMesValidadeCartao(int mesValidadeCartao) {
        this.mesValidadeCartao = mesValidadeCartao;
    }

    public int getAnoValidadeCartao() {
        return anoValidadeCartao;
    }

    public void setAnoValidadeCartao(int anoValidadeCartao) {
        this.anoValidadeCartao = anoValidadeCartao;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    private String nomeCartao;

}
