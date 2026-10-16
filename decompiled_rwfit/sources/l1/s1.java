package l1;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import java.util.Objects;

/* loaded from: classes.dex */
public class s1 extends q1 {
    public s1(x1 x1Var, WindowInsets windowInsets) {
        super(x1Var, windowInsets);
    }

    @Override // l1.v1
    public x1 a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f15721c.consumeDisplayCutout();
        return x1.h(consumeDisplayCutout, null);
    }

    @Override // l1.v1
    public j e() {
        DisplayCutout displayCutout;
        displayCutout = this.f15721c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new j(displayCutout);
    }

    @Override // l1.p1, l1.v1
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof s1)) {
            return false;
        }
        s1 s1Var = (s1) obj;
        return Objects.equals(this.f15721c, s1Var.f15721c) && Objects.equals(this.f15724g, s1Var.f15724g);
    }

    @Override // l1.v1
    public int hashCode() {
        return this.f15721c.hashCode();
    }
}
