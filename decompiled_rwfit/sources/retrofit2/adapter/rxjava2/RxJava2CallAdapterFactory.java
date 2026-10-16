package retrofit2.adapter.rxjava2;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import retrofit2.CallAdapter;
import retrofit2.Response;
import retrofit2.Retrofit;
import rg.a;
import rg.e;
import rg.g;
import rg.l;
import rg.x;
import rg.y;

/* loaded from: classes2.dex */
public final class RxJava2CallAdapterFactory extends CallAdapter.Factory {
    private final boolean isAsync;

    @Nullable
    private final x scheduler;

    private RxJava2CallAdapterFactory(@Nullable x xVar, boolean z5) {
        this.scheduler = xVar;
        this.isAsync = z5;
    }

    public static RxJava2CallAdapterFactory create() {
        return new RxJava2CallAdapterFactory(null, false);
    }

    public static RxJava2CallAdapterFactory createAsync() {
        return new RxJava2CallAdapterFactory(null, true);
    }

    public static RxJava2CallAdapterFactory createWithScheduler(x xVar) {
        if (xVar != null) {
            return new RxJava2CallAdapterFactory(xVar, false);
        }
        throw new NullPointerException("scheduler == null");
    }

    @Override // retrofit2.CallAdapter.Factory
    public CallAdapter<?, ?> get(Type type, Annotation[] annotationArr, Retrofit retrofit) {
        Type type2;
        boolean z5;
        boolean z6;
        Class<?> rawType = CallAdapter.Factory.getRawType(type);
        if (rawType == a.class) {
            return new RxJava2CallAdapter(Void.class, this.scheduler, this.isAsync, false, true, false, false, false, true);
        }
        boolean z8 = rawType == e.class;
        boolean z10 = rawType == y.class;
        boolean z11 = rawType == g.class;
        if (rawType != l.class && !z8 && !z10 && !z11) {
            return null;
        }
        if (!(type instanceof ParameterizedType)) {
            String str = !z8 ? !z10 ? z11 ? "Maybe" : "Observable" : "Single" : "Flowable";
            throw new IllegalStateException(str + " return type must be parameterized as " + str + "<Foo> or " + str + "<? extends Foo>");
        }
        Type parameterUpperBound = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) type);
        Class<?> rawType2 = CallAdapter.Factory.getRawType(parameterUpperBound);
        if (rawType2 == Response.class) {
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException("Response must be parameterized as Response<Foo> or Response<? extends Foo>");
            }
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z6 = false;
            z5 = false;
        } else if (rawType2 != Result.class) {
            type2 = parameterUpperBound;
            z5 = true;
            z6 = false;
        } else {
            if (!(parameterUpperBound instanceof ParameterizedType)) {
                throw new IllegalStateException("Result must be parameterized as Result<Foo> or Result<? extends Foo>");
            }
            type2 = CallAdapter.Factory.getParameterUpperBound(0, (ParameterizedType) parameterUpperBound);
            z6 = true;
            z5 = false;
        }
        return new RxJava2CallAdapter(type2, this.scheduler, this.isAsync, z6, z5, z8, z10, z11, false);
    }
}
