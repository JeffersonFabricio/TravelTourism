package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.model.Pacote;
import programacao.mobile.android.traveltourism.util.MoedaUtil;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        Intent intent = getIntent();
        if(intent.hasExtra("pacote")){
            final Pacote pacote = (Pacote) intent.getSerializableExtra("pacote");
            mostraPreco(pacote);

            Button botaFinalizacompra = findViewById(R.id.pagamento_btnFinalizaCompra);
            botaFinalizacompra.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
                    intent.putExtra("pacote", pacote);
                    startActivity(intent);
                }
            });
        }
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_valorCompra);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
