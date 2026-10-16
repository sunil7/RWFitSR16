package kotlin.coroutines.jvm.internal;

import gh.a;
import gh.b;
import gh.e;

/* loaded from: classes2.dex */
public abstract class ContinuationImpl extends BaseContinuationImpl {
    private final e _context;

    /* renamed from: a, reason: collision with root package name */
    public transient a f15644a;

    public ContinuationImpl(a<Object> aVar, e eVar) {
        super(aVar);
        this._context = eVar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, gh.a
    public e getContext() {
        e eVar = this._context;
        kotlin.jvm.internal.e.c(eVar);
        return eVar;
    }

    public final a<Object> intercepted() {
        a<Object> aVar = this.f15644a;
        if (aVar != null) {
            return aVar;
        }
        getContext().get(b.f14066a);
        this.f15644a = this;
        return this;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public void releaseIntercepted() {
        a aVar = this.f15644a;
        if (aVar == null || aVar == this) {
            this.f15644a = hh.a.f14323a;
        } else {
            getContext().get(b.f14066a);
            kotlin.jvm.internal.e.c(null);
            throw null;
        }
    }

    public ContinuationImpl(a<Object> aVar) {
        this(aVar, aVar != null ? aVar.getContext() : null);
    }
}
