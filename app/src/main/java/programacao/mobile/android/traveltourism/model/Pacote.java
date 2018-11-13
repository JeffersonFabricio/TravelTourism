package programacao.mobile.android.traveltourism.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
import java.math.BigDecimal;

@Entity
public class Pacote implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String local;
    private String img;
    private int dias;
    private BigDecimal preco;

    public Pacote(String local, String img, int dias, BigDecimal preco) {
        setLocal(local);
        setImg(img);
        setDias(dias);
        setPreco(preco);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getLocal() {
        return local;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImg() {
        return img;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public int getDias() {
        return dias;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}