package y2;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;

/* loaded from: classes.dex */
public final class a extends c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p2.l f19939b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ UUID f19940c;

    public a(p2.l lVar, UUID uuid) {
        this.f19939b = lVar;
        this.f19940c = uuid;
    }

    @Override // y2.c
    public final void b() {
        p2.l lVar = this.f19939b;
        WorkDatabase workDatabase = lVar.f17427c;
        workDatabase.c();
        try {
            c.a(lVar, this.f19940c.toString());
            workDatabase.h();
            workDatabase.f();
            p2.d.a(lVar.f17426b, lVar.f17427c, lVar.e);
        } catch (Throwable th2) {
            workDatabase.f();
            throw th2;
        }
    }
}
