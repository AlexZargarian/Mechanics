import java.util.function.Function;

import static sun.swing.MenuItemLayoutHelper.max;

public class Analyze {
    Function f;

    double period, delta;
    double omega0;
    double N;

    double T;
    double dt;
    int n = 100000;
    Spring obj = new Spring();
    double[] a = new double[n];
    double[] b = new double[n];
    int r = 0;

    double[] x = obj.move(T, dt);

    Analyze(Function f, double N, double delta) {
        this.f = f;
        this.delta = delta;
        this.N = N;
        N = T / dt;
        period = N * delta;
        omega0 = 2 * Math.PI / period;
    }

    double getSineCoefficient(int n) {
        double sum = 0;
        double t = 0;
        while (r < n) {
            for (int i = 0; i < N; i++) {
                sum += x[i] * Math.sin(n * omega0 * t);
                t += delta;
                a[i] = 2 * delta * sum / period;
                n++;
            }
            n++;
        }
        return a[n];
    }

    double getCosineCoefficient(int n) {
        double sum = 0;
        double t = 0;
        while (r < n) {
            for (int i = 0; i < N; i++) {
                sum += x[i] * Math.cos(n * omega0 * t);
                t += delta;
            }
            b[n] = 2 * delta * sum / period;

        }
        return b[n];
    }

    public void myMethod() {
        double max1 = b[0];
        double max2 = a[0];
        for (int i = 0; i < n; i++) {
            max1 = b[0];
            if (b[i] > max1) {
                max1 = b[i];
            }
            for ( i = 0; i < n; i++) {
                max2 = a[0];
                if (a[i] > max1) {
                    max2 = a[i];
                }

            }
        }
        double max1power = max1 * max1;
        double max2power = max2 * max2;
       double w= Math.sqrt(max1power+max2power);
        double occelation=w* omega0;
    }

}

