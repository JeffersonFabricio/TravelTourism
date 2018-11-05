package programacao.mobile.android.traveltourism.ui.adapter;

import android.content.Context;
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
import programacao.mobile.android.traveltourism.util.DiasUtil;
import programacao.mobile.android.traveltourism.util.MoedaUtil;
import programacao.mobile.android.traveltourism.util.ResourceUtil;

public class ListaPacotesAdapter extends BaseAdapter {

    public static final String DRAWABLE = "drawable";
    public static final String DIA = " Dia";
    public static final String DIAS = " Dias";
    private final List<Pacote> pacotes;
    private final Context context;

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

        mostraLocal(viewCriada, pacote);
        mostraImg(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_txtValor);
        String moedaBrasileira = MoedaUtil.formataParaBrasileiro(pacote.getPreco());
        preco.setText(moedaBrasileira);

    }

    private void mostraDias(View viewCriada, Pacote pacote) {

        TextView dias = viewCriada.findViewById(R.id.item_pacote_txtDias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }

    private void mostraImg(View viewCriada, Pacote pacote) {
        ImageView img = viewCriada.findViewById(R.id.item_pacote_imgFotoCidade);
        Drawable drawableImgPacote = ResourceUtil.devolveDrawable(context, pacote.getImg());
        img.setImageDrawable(drawableImgPacote);
    }

    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_txtNomeCidade);
        local.setText(pacote.getLocal());
    }

}
