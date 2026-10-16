package kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Map;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.reflect.KVisibility;
import uh.l;

/* loaded from: classes2.dex */
public abstract class CallableReference implements uh.b, Serializable {
    public static final Object NO_RECEIVER = NoReceiver.f15646a;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient uh.b reflected;
    private final String signature;

    public static class NoReceiver implements Serializable {

        /* renamed from: a, reason: collision with root package name */
        public static final NoReceiver f15646a = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return f15646a;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    @Override // uh.b
    public Object call(Object... objArr) {
        return getReflected().call(objArr);
    }

    @Override // uh.b
    public Object callBy(Map map) {
        return getReflected().callBy(map);
    }

    public uh.b compute() {
        uh.b bVar = this.reflected;
        if (bVar != null) {
            return bVar;
        }
        uh.b computeReflected = computeReflected();
        this.reflected = computeReflected;
        return computeReflected;
    }

    public abstract uh.b computeReflected();

    @Override // uh.a
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public String getName() {
        return this.name;
    }

    public uh.d getOwner() {
        Class cls = this.owner;
        if (cls == null) {
            return null;
        }
        if (!this.isTopLevel) {
            return g.a(cls);
        }
        g.f15651a.getClass();
        return new f(cls);
    }

    @Override // uh.b
    public List<Object> getParameters() {
        return getReflected().getParameters();
    }

    public uh.b getReflected() {
        uh.b compute = compute();
        if (compute != this) {
            return compute;
        }
        throw new KotlinReflectionNotSupportedError();
    }

    @Override // uh.b
    public l getReturnType() {
        getReflected().getReturnType();
        return null;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override // uh.b
    public List<Object> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override // uh.b
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override // uh.b
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override // uh.b
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override // uh.b
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override // uh.b
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public CallableReference(Object obj) {
        this(obj, null, null, null, false);
    }

    public CallableReference(Object obj, Class cls, String str, String str2, boolean z5) {
        this.receiver = obj;
        this.owner = cls;
        this.name = str;
        this.signature = str2;
        this.isTopLevel = z5;
    }
}
