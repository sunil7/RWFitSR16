package androidx.databinding;

/* loaded from: classes.dex */
public abstract class c extends a {
    public c() {
    }

    public c(f... fVarArr) {
        if (fVarArr == null || fVarArr.length == 0) {
            return;
        }
        b bVar = new b(this);
        for (f fVar : fVarArr) {
            fVar.addOnPropertyChangedCallback(bVar);
        }
    }
}
