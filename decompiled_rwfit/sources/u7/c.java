package u7;

import com.github.mikephil.charting.data.Entry;

/* loaded from: classes.dex */
public abstract class c extends h {

    /* renamed from: f, reason: collision with root package name */
    public final androidx.recyclerview.widget.x f18941f;

    public c(k7.a aVar, v7.i iVar) {
        super(aVar, iVar);
        this.f18941f = new androidx.recyclerview.widget.x(this);
    }

    public static boolean s(o7.d dVar) {
        if (dVar.f16819n) {
            return dVar.f16815j || dVar.f16816k;
        }
        return false;
    }

    public final boolean r(Entry entry, o7.d dVar) {
        if (entry == null) {
            return false;
        }
        float indexOf = dVar.f16820o.indexOf(entry);
        float size = dVar.f16820o.size();
        this.f18948b.getClass();
        return indexOf < size * 1.0f;
    }
}
