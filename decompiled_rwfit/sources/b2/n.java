package b2;

import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public abstract class n {

    /* renamed from: a, reason: collision with root package name */
    public final AtomicBoolean f3143a = new AtomicBoolean(false);

    /* renamed from: b, reason: collision with root package name */
    public final i f3144b;

    /* renamed from: c, reason: collision with root package name */
    public volatile SupportSQLiteStatement f3145c;

    public n(i iVar) {
        this.f3144b = iVar;
    }

    public final SupportSQLiteStatement a() {
        this.f3144b.a();
        if (!this.f3143a.compareAndSet(false, true)) {
            String b3 = b();
            i iVar = this.f3144b;
            iVar.a();
            iVar.b();
            return iVar.f3123c.getWritableDatabase().compileStatement(b3);
        }
        if (this.f3145c == null) {
            String b10 = b();
            i iVar2 = this.f3144b;
            iVar2.a();
            iVar2.b();
            this.f3145c = iVar2.f3123c.getWritableDatabase().compileStatement(b10);
        }
        return this.f3145c;
    }

    public abstract String b();

    public final void c(SupportSQLiteStatement supportSQLiteStatement) {
        if (supportSQLiteStatement == this.f3145c) {
            this.f3143a.set(false);
        }
    }
}
