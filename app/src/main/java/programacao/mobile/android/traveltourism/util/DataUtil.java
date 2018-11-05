package programacao.mobile.android.traveltourism.util;

import android.icu.text.SimpleDateFormat;
import android.support.annotation.NonNull;

import java.util.Calendar;

public class DataUtil {

    public static final String DIA_E_MES = "dd/MM";

    @NonNull
    public static String periodoEmTxt(int dias) {
        Calendar dataIda = Calendar.getInstance();
        Calendar dataVolta = Calendar.getInstance();
        dataVolta.add(Calendar.DATE, dias);
        SimpleDateFormat formatoDataBrasileira = new SimpleDateFormat(DIA_E_MES);
        String dataFormatadaIda = formatoDataBrasileira.format(dataIda.getTime());
        String dataFormatadaVolta = formatoDataBrasileira.format(dataVolta.getTime());
        return dataFormatadaIda + " - " + dataFormatadaVolta + " de " + dataVolta.get(Calendar.YEAR);
    }
}
