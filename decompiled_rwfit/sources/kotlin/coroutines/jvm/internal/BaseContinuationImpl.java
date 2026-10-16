package kotlin.coroutines.jvm.internal;

import androidx.appcompat.widget.d3;
import eh.g;
import gh.a;
import hh.b;
import hh.c;
import hh.d;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public abstract class BaseContinuationImpl implements a<Object>, b, Serializable {
    private final a<Object> completion;

    public BaseContinuationImpl(a<Object> aVar) {
        this.completion = aVar;
    }

    public a<g> create(a<?> completion) {
        e.f(completion, "completion");
        throw new UnsupportedOperationException("create(Continuation) has not been overridden");
    }

    public b getCallerFrame() {
        a<Object> aVar = this.completion;
        if (aVar instanceof b) {
            return (b) aVar;
        }
        return null;
    }

    public final a<Object> getCompletion() {
        return this.completion;
    }

    @Override // gh.a
    public abstract /* synthetic */ gh.e getContext();

    public StackTraceElement getStackTraceElement() {
        int i3;
        String str;
        c cVar = (c) getClass().getAnnotation(c.class);
        String str2 = null;
        if (cVar == null) {
            return null;
        }
        int v6 = cVar.v();
        if (v6 > 1) {
            throw new IllegalStateException(("Debug metadata version mismatch. Expected: 1, got " + v6 + ". Please update the Kotlin standard library.").toString());
        }
        try {
            Field declaredField = getClass().getDeclaredField("label");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(this);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            i3 = (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            i3 = -1;
        }
        int i10 = i3 >= 0 ? cVar.l()[i3] : -1;
        d3 d3Var = d.f14325b;
        d3 d3Var2 = d.f14324a;
        if (d3Var == null) {
            try {
                d3 d3Var3 = new d3(Class.class.getDeclaredMethod("getModule", null), getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
                d.f14325b = d3Var3;
                d3Var = d3Var3;
            } catch (Exception unused2) {
                d.f14325b = d3Var2;
                d3Var = d3Var2;
            }
        }
        if (d3Var != d3Var2) {
            Method method = d3Var.f887a;
            Object invoke = method != null ? method.invoke(getClass(), null) : null;
            if (invoke != null) {
                Method method2 = d3Var.f888b;
                Object invoke2 = method2 != null ? method2.invoke(invoke, null) : null;
                if (invoke2 != null) {
                    Method method3 = d3Var.f889c;
                    Object invoke3 = method3 != null ? method3.invoke(invoke2, null) : null;
                    if (invoke3 instanceof String) {
                        str2 = (String) invoke3;
                    }
                }
            }
        }
        if (str2 == null) {
            str = cVar.c();
        } else {
            str = str2 + '/' + cVar.c();
        }
        return new StackTraceElement(str, cVar.m(), cVar.f(), i10);
    }

    public abstract Object invokeSuspend(Object obj);

    public void releaseIntercepted() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // gh.a
    public final void resumeWith(Object obj) {
        Object invokeSuspend;
        a aVar = this;
        while (true) {
            BaseContinuationImpl baseContinuationImpl = (BaseContinuationImpl) aVar;
            a aVar2 = baseContinuationImpl.completion;
            e.c(aVar2);
            try {
                invokeSuspend = baseContinuationImpl.invokeSuspend(obj);
            } catch (Throwable th2) {
                obj = Result.m75constructorimpl(new Result.Failure(th2));
            }
            if (invokeSuspend == CoroutineSingletons.COROUTINE_SUSPENDED) {
                return;
            }
            obj = Result.m75constructorimpl(invokeSuspend);
            baseContinuationImpl.releaseIntercepted();
            if (!(aVar2 instanceof BaseContinuationImpl)) {
                aVar2.resumeWith(obj);
                return;
            }
            aVar = aVar2;
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("Continuation at ");
        Object stackTraceElement = getStackTraceElement();
        if (stackTraceElement == null) {
            stackTraceElement = getClass().getName();
        }
        sb2.append(stackTraceElement);
        return sb2.toString();
    }

    public a<g> create(Object obj, a<?> completion) {
        e.f(completion, "completion");
        throw new UnsupportedOperationException("create(Any?;Continuation) has not been overridden");
    }
}
