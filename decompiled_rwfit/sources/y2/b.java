package y2;

import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class b extends c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p2.l f19941b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f19942c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ boolean f19943d;

    public b(p2.l lVar, String str, boolean z5) {
        this.f19941b = lVar;
        this.f19942c = str;
        this.f19943d = z5;
    }

    @Override // y2.c
    public final void b() {
        p2.l lVar = this.f19941b;
        WorkDatabase workDatabase = lVar.f17427c;
        workDatabase.c();
        try {
            ArrayList g10 = workDatabase.n().g(this.f19942c);
            int size = g10.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = g10.get(i3);
                i3++;
                c.a(lVar, (String) obj);
            }
            workDatabase.h();
            workDatabase.f();
            if (this.f19943d) {
                p2.d.a(lVar.f17426b, lVar.f17427c, lVar.e);
            }
        } catch (Throwable th2) {
            workDatabase.f();
            throw th2;
        }
    }
}
