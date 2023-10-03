package tareas.practice1P;

public class Banco {

    public int getMaximoPrestamo(String ci){
        String categoria = Asfi.getCategoria(ci);

        return switch (categoria) {
            case "A" -> 200000;
            case "B" -> 100000;
            case "C" -> 0;
            default -> -1;
        };
    }
}
