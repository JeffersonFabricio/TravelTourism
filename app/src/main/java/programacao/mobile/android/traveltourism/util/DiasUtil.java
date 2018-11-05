package programacao.mobile.android.traveltourism.util;

import android.support.annotation.NonNull;

public class DiasUtil {

    public static final String PLURAL = " Dias";
    public static final String SINGULAR = " Dia";

    @NonNull
    public static String formataEmTexto(int quantidadeDeDias) {
        if(quantidadeDeDias > 1){
            return quantidadeDeDias + PLURAL;
        } else {
            return quantidadeDeDias + SINGULAR;
        }
    }

}
