package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import programacao.mobile.android.traveltourism.R;

public class DashboardActivity extends AppCompatActivity {

    public static final String PROGRAMACAO_MOBILE = "Programação Mobile";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        setTitle(PROGRAMACAO_MOBILE);

        Intent intent = new Intent(DashboardActivity.this, ListaPacotesActivity.class);
        startActivity(intent);
    }
}
