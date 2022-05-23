public class Spring {
    private double k;

    public Spring() {
        this.k = 1;
    }

    public Spring(double k) {
        this.k = 1;

    }

    public double getK() {
        return this.k;
    }

    private void setk(double k) {
        this.k = k;
    }

    public double[] move(double t, double dt, double x0, double v0) {
        int n = (int) ((t) / dt);
        double w = Math.sqrt(k);

        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = (x0 * Math.cos(w * (t) + (v0 / w) * Math.sin(w * (t))));
        }

        return result;
    }

    public double[] move(double t, double dt, double x0) {
        int n = (int) ((t) / dt);
        double w = Math.sqrt(k);

        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = (x0 * Math.cos(t));
        }

        return result;
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0) {
        return move(t0, t1, dt, x0, v0, 1.0);
    }

    public double[] move(double t0, double t1, double dt, double x0, double v0, double m) {
        int n = (int) ((t1 - t0) / dt);
        double w = Math.sqrt(k / m);

        double[] result = new double[n];

        for (int i = 0; i < n; i++) {
            result[i] = (x0 * Math.cos(w * (t0 + i * dt) + (v0 / w) * Math.sin(w * (t0 + i * dt))));
        }

        return result;
    }

    Spring inSeries(Spring that) {
        Spring result = new Spring();
        result.k = that.k + this.k;


        return result;

    }

    Spring inParallel(Spring that) {
        Spring result = new Spring();
        (result.k) = ((this.k*that.k)/(this.k+that.k));
        return result;
    }

}
