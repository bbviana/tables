package br.com.viana.hal

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols

/**
 * @author bbviana
 */
class ExtendGroovyClasses {

    static void process(){
        addFormat()
    }

    private static void addFormat(){
        DecimalFormat df = new DecimalFormat("#,##0.00")
        df.decimalFormatSymbols = DecimalFormatSymbols.getInstance(new Locale("pt", "BR"))

        Number.metaClass.format = {
            return df.format(delegate)
        }
    }
}
