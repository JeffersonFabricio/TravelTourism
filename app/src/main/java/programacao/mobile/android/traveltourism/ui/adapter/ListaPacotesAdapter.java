package programacao.mobile.android.traveltourism.ui.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import programacao.mobile.android.traveltourism.R;
import programacao.mobile.android.traveltourism.model.Pacote;

public class ListaPacotesAdapter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private Context context;

    public ListaPacotesAdapter(List<Pacote> pacotes, Context context){
        this.pacotes = pacotes;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int posicao) {
        return pacotes.get(posicao);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int posicao, View view, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(posicao);

        TextView local = viewCriada.findViewById(R.id.item_pacote_txtNomeCidade);
        local.setText(pacote.getLocal());

        ImageView img = viewCriada.findViewById(R.id.item_pacote_imgFotoCidade);
        Resources resources = context.getResources();
        int idDoDrawable = resources.getIdentifier(pacote.getImg()
                , "drawable", context.getPackageName());
        Drawable drawableImgPacote = resources.getDrawable(idDoDrawable);
        img.setImageDrawable(drawableImgPacote);

        TextView dias = viewCriada.findViewById(R.id.item_pacote_txtDias);
        dias.setText(pacote.getDias() + "dias");

        TextView preco = viewCriada.findViewById(R.id.item_pacote_txtValor);
        preco.setText(pacote.getPreco().toString());

        return viewCriada;
    }

}
