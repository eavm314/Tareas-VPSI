package example3;

public class InvNumber {
    public String invertir(int num){
        if(num<0)
            return "Valor Incorrecto";

        String stringNum = Integer.toString(num);
        StringBuilder stringBuilder = new StringBuilder(stringNum);
        stringBuilder.reverse();
        return stringBuilder.toString();
    }
}
