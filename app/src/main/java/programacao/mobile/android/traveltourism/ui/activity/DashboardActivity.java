package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import programacao.mobile.android.traveltourism.R;

public class DashboardActivity extends AppCompatActivity {

    public static final String PROGRAMACAO_MOBILE = "Programação Mobile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle(PROGRAMACAO_MOBILE);

        vaiParaPacotesActivity();

        Button btnOfertas = findViewById(R.id.dashboard_VerificarCartoesCadastrado);
        btnOfertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intencao = new Intent(DashboardActivity.this, .class);
                //startActivity(intencao);
            }
        });

    }

    private void vaiParaPacotesActivity() {
        Button btnOfertas = findViewById(R.id.dashboard_btnVerOfertas);
        btnOfertas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(DashboardActivity.this, ListaPacotesActivity.class);
                startActivity(intencao);
            }
        });
    }
}
