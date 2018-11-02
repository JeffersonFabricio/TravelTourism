package programacao.mobile.android.traveltourism.model;

import java.math.BigDecimal;

public class Pacote {

    private final String local;
    private final String img;
    private final int dias;
    private final BigDecimal preco;

    public Pacote(String local, String img, int dias, BigDecimal preco) {
        this.local = local;
        this.img = img;
        this.dias = dias;
        this.preco = preco;
    }

    public String getLocal() {
        return local;
    }

    public String getImg() {
        return img;
    }

    public int getDias() {
        return dias;
    }

    public BigDecimal getPreco() {
        return preco;
    }

}