package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.database.GeradorBancoDeDados;
import programacao.mobile.android.traveltourism.model.Pacote;
import programacao.mobile.android.traveltourism.model.Pagamento;
import programacao.mobile.android.traveltourism.util.MoedaUtil;

import static programacao.mobile.android.traveltourism.ui.activity.PacoteActivityConstantes.PACOTE;

public class PagamentoActivity extends AppCompatActivity {

    public static final String TITULO_APPBAR = "Pagamento";
    private Pagamento pagamento = new Pagamento();
    private EditText campoNome;
    private EditText campoNumCartao;
    private EditText campoMes;
    private EditText campoAno;
    private EditText campoCvc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pagamento);

        setTitle(TITULO_APPBAR);

        carregaPacoteRecebido();

    }

    @Nullable
    protected View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_pagamento, container, false);

        configuraComponentesDaView(view);

        atribuirValoresRecebidosPelaTela();

        GeradorBancoDeDados gerador = new GeradorBancoDeDados();
        //gerador.gera(context);

        return view;
    }

    private void configuraComponentesDaView(View view) {
        this.campoNome = view.findViewById(R.id.pagamento_editTxtNomeCartao);
        this.campoNumCartao = view.findViewById(R.id.pagamento_editTxtNumCartao);
        this.campoMes = view.findViewById(R.id.pagamento_editTxtMesCartao);
        this.campoAno = view.findViewById(R.id.pagamento_editTxtAnoCartao);
        this.campoCvc = view.findViewById(R.id.pagamento_editTxtCvcCartao);
    }

    private void atribuirValoresRecebidosPelaTela() {
        pagamento.setNomeCartao(campoNome.getText().toString());
        pagamento.setNumeroCartao(Integer.parseInt(campoNumCartao.getText().toString()));
        pagamento.setMesValidadeCartao(Integer.parseInt(campoMes.getText().toString()));
        pagamento.setAnoValidadeCartao(Integer.parseInt(campoAno.getText().toString()));
        pagamento.setCvc(Integer.parseInt(campoCvc.getText().toString()));
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if(intent.hasExtra(PACOTE)){
            final Pacote pacote = (Pacote) intent.getSerializableExtra(PACOTE);

            mostraPreco(pacote);
            configuraBtn(pacote);
        }
    }

    private void configuraBtn(final Pacote pacote) {
        Button botaFinalizacompra = findViewById(R.id.pagamento_btnFinalizaCompra);
        botaFinalizacompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                vaiParaResumoCompra(pacote);
            }
        });
    }

    private void vaiParaResumoCompra(Pacote pacote) {
        Intent intent = new Intent(PagamentoActivity.this, ResumoCompraActivity.class);
        intent.putExtra(PACOTE, pacote);
        startActivity(intent);
    }

    private void mostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.pagamento_valorCompra);
        String moedaBrasileira = MoedaUtil
                .formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }
}
