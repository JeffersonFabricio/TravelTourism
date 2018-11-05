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
import programacao.mobile.android.traveltourism.util.DiasUtil;
import programacao.mobile.android.traveltourism.util.MoedaUtil;
import programacao.mobile.android.traveltourism.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APP_BAR);

        Pacote pacoteRecife = new Pacote("Recife", "recife_pe", 2, new BigDecimal("243.99"));

        mostraLocal(pacoteRecife);
        mostraImg(pacoteRecife);
        mostraDias(pacoteRecife);
        mostraPreco(pacoteRecife);
        mostraData(pacoteRecife);

    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_pacote_data);
        String dataFormatadaViagem = DataUtil.periodoEmTxt(pacote.getDias());
        data.setText(dataFormatadaViagem);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_pacote_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraDias(Pacote pacote) {
        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasTxt = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasTxt);
    }

    private void mostraImg(Pacote pacote) {
        ImageView img = findViewById(R.id.resumo_pacote_img);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacote.getImg());
        img.setImageDrawable(drawablePacote);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacote.getLocal());
    }
}
