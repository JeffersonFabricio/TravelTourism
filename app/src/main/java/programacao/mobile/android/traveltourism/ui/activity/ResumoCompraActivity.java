package programacao.mobile.android.traveltourism.ui.activity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.model.Pacote;
import programacao.mobile.android.traveltourism.util.DataUtil;
import programacao.mobile.android.traveltourism.util.MoedaUtil;
import programacao.mobile.android.traveltourism.util.ResourceUtil;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String TITLE_APPBAR = "Resumo da compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);

        setTitle(TITLE_APPBAR);

        Pacote pacoteRecife = new Pacote("Recife", "recife_pe", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteRecife);
        mostraImg(pacoteRecife);
        mostraPreco(pacoteRecife);
        mostraData(pacoteRecife);

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data);
        String dataFormatadaViagem = DataUtil.periodoEmTxt(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraImg(Pacote pacote) {
        ImageView img = findViewById(R.id.resumo_compra_imgLocal);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImg());
        img.setImageDrawable(drawablePacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local);
        local.setText(pacote.getLocal());
    }
}
