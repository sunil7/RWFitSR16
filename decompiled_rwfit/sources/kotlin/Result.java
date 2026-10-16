package kotlin;

import eh.d;
import java.io.Serializable;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class Result<T> implements Serializable {
    public static final d Companion = new d();
    private final Object value;

    public static final class Failure implements Serializable {
        public final Throwable exception;

        public Failure(Throwable exception) {
            e.f(exception, "exception");
            this.exception = exception;
        }

        public boolean equals(Object obj) {
            return (obj instanceof Failure) && e.a(this.exception, ((Failure) obj).exception);
        }

        public int hashCode() {
            return this.exception.hashCode();
        }

        public String toString() {
            return "Failure(" + this.exception + ')';
        }
    }

    public /* synthetic */ Result(Object obj) {
        this.value = obj;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Result m74boximpl(Object obj) {
        return new Result(obj);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Object m75constructorimpl(Object obj) {
        return obj;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m76equalsimpl(Object obj, Object obj2) {
        return (obj2 instanceof Result) && e.a(obj, ((Result) obj2).m83unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m77equalsimpl0(Object obj, Object obj2) {
        return e.a(obj, obj2);
    }

    /* renamed from: exceptionOrNull-impl, reason: not valid java name */
    public static final Throwable m78exceptionOrNullimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).exception;
        }
        return null;
    }

    public static /* synthetic */ void getValue$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m79hashCodeimpl(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    /* renamed from: isFailure-impl, reason: not valid java name */
    public static final boolean m80isFailureimpl(Object obj) {
        return obj instanceof Failure;
    }

    /* renamed from: isSuccess-impl, reason: not valid java name */
    public static final boolean m81isSuccessimpl(Object obj) {
        return !(obj instanceof Failure);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m82toStringimpl(Object obj) {
        if (obj instanceof Failure) {
            return ((Failure) obj).toString();
        }
        return "Success(" + obj + ')';
    }

    public boolean equals(Object obj) {
        return m76equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m79hashCodeimpl(this.value);
    }

    public String toString() {
        return m82toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Object m83unboximpl() {
        return this.value;
    }
}
