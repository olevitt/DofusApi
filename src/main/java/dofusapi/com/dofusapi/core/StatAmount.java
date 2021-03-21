package dofusapi.com.dofusapi.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class StatAmount {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idStatAmount = 1;
    public int min;
    public int max;

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }
}
