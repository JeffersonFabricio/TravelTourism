package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

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

        Intent intent = getIntent();
        if(intent.hasExtra("pacote")){
            Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");

            mostraLocal(pacote);
            mostraImg(pacote);
            mostraPreco(pacote);
            mostraData(pacote);
        }

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
