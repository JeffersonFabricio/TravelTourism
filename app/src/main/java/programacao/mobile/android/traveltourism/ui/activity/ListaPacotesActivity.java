package programacao.mobile.android.traveltourism.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.dao.PacoteDAO;
import programacao.mobile.android.traveltourism.model.Pacote;
import programacao.mobile.android.traveltourism.ui.adapter.ListaPacotesAdapter;

public class ListaPacotesActivity extends AppCompatActivity {

    public static final String PACOTES = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);

        setTitle(PACOTES);
        configuraLista();

        Intent intent = new Intent(this, ResumoPacoteActivity.class);
        startActivity(intent);

    }

    private void configuraLista() {
        ListView listaDePacotes = findViewById(R.id.lista_pacote_listView);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listaDePacotes.setAdapter(new ListaPacotesAdapter(pacotes, this));
    }
}
