package kotlin;

import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class NotImplementedError extends Error {
    /* JADX WARN: Multi-variable type inference failed */
    public NotImplementedError() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public NotImplementedError(String message) {
        super(message);
        e.f(message, "message");
    }

    public /* synthetic */ NotImplementedError(String str, int i3, c cVar) {
        this((i3 & 1) != 0 ? "An operation is not implemented." : str);
    }
}
