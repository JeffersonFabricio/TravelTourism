package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.model.Pacote;
import programacao.mobile.android.traveltourism.util.DataUtil;
import programacao.mobile.android.traveltourism.util.DiasUtil;
import programacao.mobile.android.traveltourism.util.MoedaUtil;
import programacao.mobile.android.traveltourism.util.ResourceUtil;

import static programacao.mobile.android.traveltourism.ui.activity.PacoteActivityConstantes.PACOTE;

public class ResumoPacoteActivity extends AppCompatActivity {

    public static final String TITULO_APP_BAR = "Resumo do Pacote";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_pacote);

        setTitle(TITULO_APP_BAR);

        carregaPacoteRecebido();

    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
            if(intent.hasExtra(PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);

                inicializaCampos(pacote);
                configuraBtn(pacote);
        }
    }

    private void configuraBtn(final Pacote pacote) {
        Button botaoRealizaPagamento = findViewById(R.id.resumo_pacote_btnPagamento);
        botaoRealizaPagamento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaPagamento(pacote);
            }
        });
    }

    private void vaiParaPagamento(Pacote pacote) {
        Intent intent = new Intent(ResumoPacoteActivity.this, PagamentoActivity.class);
        intent.putExtra(PACOTE, pacote);
        startActivity(intent);
    }

    private void inicializaCampos(Pacote pacote) {
        mostraLocal(pacote);
        mostraImg(pacote);
        mostraDias(pacote);
        mostraPreco(pacote);
        mostraData(pacote);
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
