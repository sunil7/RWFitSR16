package ca;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.nio.charset.Charset;
import java.util.Random;

/* loaded from: classes.dex */
public final class h extends ThreadLocal {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f3420a;

    @Override // java.lang.ThreadLocal
    public final Object initialValue() {
        switch (this.f3420a) {
            case 0:
                return 0L;
            case 1:
                return Boolean.FALSE;
            case 2:
                return new Random();
            case 3:
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    return a6.d();
                }
                if (Looper.myLooper() != null) {
                    return new w.c(new Handler(Looper.myLooper()));
                }
                return null;
            case 4:
                return Charset.forName("UTF-8").newDecoder();
            case 5:
                return Charset.forName("UTF-8");
            default:
                return new yh.c();
        }
    }
}
