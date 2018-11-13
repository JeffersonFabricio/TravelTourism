package programacao.mobile.android.traveltourism.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Pacote implements Serializable {

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