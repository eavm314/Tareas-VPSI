package tareas.practice1P;

public class Days {
    public String nextDay(int day, int month, int year) throws IllegalArgumentException {
        if (!isValidDate(day, month, year)) {
            throw new IllegalArgumentException("Fecha no válida");
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Ajustar el número de días de febrero para años bisiestos
        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        // Verificar si es el último día del mes
        if (day == daysInMonth[month]) {
            day = 1;
            if (month == 12) {
                month = 1;
                year++;
            } else {
                month++;
            }
        } else {
            day++;
        }

        // Formatear la fecha en el formato "dd/MM/yyyy"
        String formattedDay = String.format("%02d", day);
        String formattedMonth = String.format("%02d", month);
        return formattedDay + "/" + formattedMonth + "/" + year;
    }

    private boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12 || day < 1) {
            return false;
        }

        int[] daysInMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            daysInMonth[2] = 29;
        }

        return day <= daysInMonth[month];
    }

    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        Days dateUtils = new Days();
        try {
            System.out.println(dateUtils.nextDay(31, 12, 2023)); // Output: 01/01/2024
            System.out.println(dateUtils.nextDay(28, 2, 2020));  // Output: 29/02/2020
            System.out.println(dateUtils.nextDay(29, 2, 2020));  // Output: 01/03/2020
            System.out.println(dateUtils.nextDay(1, 11, -2000)); // Output: 01/01/2021
            System.out.println(dateUtils.nextDay(1, 11, 0)); // Output: 01/01/2021
            // Invalid date example
             System.out.println(dateUtils.nextDay(32, 12, 2020)); // Throws IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
