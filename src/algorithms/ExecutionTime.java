package algorithms;

import java.util.Locale;

public class ExecutionTime {
    private long start = 0, end = 0;

    public long getStart() {
        return this.start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public long getEnd() {
        return this.end;
    }

    public void setEnd(long end) {
        this.end = end;
    }

    public long calculateBenchMarkAlgorithm() {
        return this.end - this.start;
    }

    public void printExecTime() {
        System.out.printf(Locale.FRENCH, "Temps d'éxecution est : %o ms \n", calculateBenchMarkAlgorithm());
    }

    public void resetTime() {
        this.start = 0;
        this.end = 0;
    }
}
