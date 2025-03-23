package cross_cuting;
public class Codigo {
    public static String id(int limit, int number){
        String cero="";
        String codigo;
        int digito=String.valueOf(number).length();
        for (int i = 0; i < (limit-digito); i++) {
            cero=cero+"0";
        }
        codigo=cero+""+(number);
        if(codigo.length()<=limit)
            return codigo;
        else
            return "codigo no requerido";
    }
    
    public static String idText(String letter, int limit, int number){
        String cero="";
        String codigo;
        int digito=String.valueOf(number).length();
        for (int i = 0; i < (limit-digito); i++) {
            cero=cero+"0";
        }
        codigo=cero+""+(number);
        if(codigo.length()<=limit)
            return letter+codigo;
        else
            return "codigo no requerido";
    }
}
