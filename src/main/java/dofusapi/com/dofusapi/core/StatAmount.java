package dofusapi.com.dofusapi.core;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class StatAmount implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int idStatAmount;
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

    public int getIdStatAmount() {
        return idStatAmount;
    }

    public void setIdStatAmount(int idStatAmount) {
        this.idStatAmount = idStatAmount;
    }
}
