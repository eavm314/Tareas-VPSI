package avance.mockExample1;
// Dev: Alexia
public class CalculatorAdvanced {

    private String name = "calculadora" ;

    // PASO 1
    // verificar si se puede agregar el objeto que se desea mockear
    // si el objeto tiene un metodo SET
    // si el objeto tiene un constructor parametrizado
    private ServiceCalc calcService;
    public CalculatorAdvanced(){
        calcService = new ServiceCalc();
    }

    public CalculatorAdvanced(ServiceCalc calcService) {
        this.calcService = calcService;
    }

    public void setCalcService(ServiceCalc calcService) {
        this.calcService = calcService;
    }

    public int getFactorial(int number){
        int f = 1;
        for (int i = 1; i <= number ; i++) {
            f = calcService.mult(f,i);
        }
        return f;
    }
}
