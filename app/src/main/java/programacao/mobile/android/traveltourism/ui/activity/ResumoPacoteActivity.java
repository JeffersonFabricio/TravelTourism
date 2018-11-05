package programacao.mobile.android.traveltourism.ui.activity;

import android.graphics.drawable.Drawable;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.math.BigDecimal;
import java.util.Calendar;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.model.Pacote;
import programacao.mobile.android.traveltourism.util.DiasUtil;
import programacao.mobile.android.traveltourism.util.MoedaUtil;
import programacao.mobile.android.traveltourism.util.ResourceUtil;

public class ResumoPacoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle("Resumo do Pacote");

        Pacote pacoteRecife = new Pacote("Recife", "recife_pe", 2, new BigDecimal("243.99"));

        TextView local = findViewById(R.id.resumo_pacote_local);
        local.setText(pacoteRecife.getLocal());

        ImageView img = findViewById(R.id.resumo_pacote_img);
        Drawable drawablePacote = ResourceUtil.devolveDrawable(this, pacoteRecife.getImg());
        img.setImageDrawable(drawablePacote);

        TextView dias = findViewById(R.id.resumo_pacote_dias);
        String diasTxt = DiasUtil.formataEmTexto(pacoteRecife.getDias());
        dias.setText(diasTxt);

        TextView preco = findViewById(R.id.resumo_pacote_valor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacoteRecife.getPreco());
        preco.setText(moedaBrasileira);

        TextView data = findViewById(R.id.resumo_pacote_data);
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, pacoteRecife.getDias());
        SimpleDateFormat formatoDataBrasileira = new SimpleDateFormat("dd/MM");
        String dataFormatadaIda = formatoDataBrasileira.format(dataIda.getTime());
        String dataFormatadaVolta = formatoDataBrasileira.format(dataVolta.getTime());
        String dataFormatadaViagem = dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
        data.setText(dataFormatadaViagem);

    }
}
