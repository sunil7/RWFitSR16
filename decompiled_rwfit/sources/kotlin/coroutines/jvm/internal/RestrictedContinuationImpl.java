package kotlin.coroutines.jvm.internal;

import gh.a;
import gh.e;
import kotlin.coroutines.EmptyCoroutineContext;

/* loaded from: classes2.dex */
public abstract class RestrictedContinuationImpl extends BaseContinuationImpl {
    public RestrictedContinuationImpl(a<Object> aVar) {
        super(aVar);
        if (aVar != null && aVar.getContext() != EmptyCoroutineContext.INSTANCE) {
            throw new IllegalArgumentException("Coroutines with restricted suspension must have EmptyCoroutineContext");
        }
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl, gh.a
    public e getContext() {
        return EmptyCoroutineContext.INSTANCE;
    }
}
