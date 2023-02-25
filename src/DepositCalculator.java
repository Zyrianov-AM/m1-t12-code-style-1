import java.util.Scanner;

public class DepositCalculator  {

    double calculateComplexPercent(double amount, double yearRate, int depositPeriod) {
        double accrual = amount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);

        return roundingAmount(accrual, 2);
    }

    double calculateSimplePercent(double amount, double yearRate, int depositPeriod) {
        double accrual = amount + amount * yearRate * depositPeriod;

        return roundingAmount(accrual, 2);
    }

    double roundingAmount(double valueAmount, int places) {
        double scale = Math.pow(10, places);

        return Math.round(valueAmount * scale) / scale;
    }

    void runMenu() {
        int period;
        int depositType;
        int amount;
        double monyStorage =0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите сумму вклада в рублях:") ;
        amount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:") ;
        period = scanner.nextInt();
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();
        if (depositType == 1) {
            monyStorage = calculateSimplePercent(amount, 0.06, period);
        } else if (depositType == 2) {
            monyStorage = calculateComplexPercent(amount, 0.06, period);
        }
        System.out.println("Результат вклада: " + amount + " за " + period + " лет превратятся в " + monyStorage);
    }

    public static void main(String[] args) {
        new DepositCalculator().runMenu();
    }
}
