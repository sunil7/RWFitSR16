package androidx.databinding;

import java.io.Serializable;

/* loaded from: classes.dex */
public class ObservableField<T> extends c implements Serializable {
    static final long serialVersionUID = 1;
    private T mValue;

    public ObservableField() {
    }

    public T get() {
        return this.mValue;
    }

    public void set(T t8) {
        if (t8 != this.mValue) {
            this.mValue = t8;
            notifyChange();
        }
    }

    public ObservableField(T t8) {
        this.mValue = t8;
    }

    public ObservableField(f... fVarArr) {
        super(fVarArr);
    }
}
