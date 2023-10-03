package avance.example2;

public class Nota {
    public String getMessage(int value){
        String message;
        if (value >= 0 && value <= 70)
            message= "Necesitas Mejorar: "+value;
        else if (value >= 71 && value <= 80)
            message= "Bien: "+value;
        else if (value >= 81 && value <= 90)
            message= "Muy Bien: "+value;
        else if (value >= 91 && value <= 100)
            message= "Excelente: "+value;
        else
            message= "nota incorrecta-ingresa nuevamente";
        return message;
    }
}
