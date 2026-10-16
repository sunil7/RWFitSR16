package n;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import com.example.test.ui.main.model.PageViewModel;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import java.text.DateFormatSymbols;
import java.util.Locale;
import t.f1;

/* loaded from: classes.dex */
public final /* synthetic */ class x0 implements k.a, rd.e, t.w0, cf.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16317a;

    public /* synthetic */ x0(int i3) {
        this.f16317a = i3;
    }

    @Override // cf.c
    public String a(int i3) {
        switch (this.f16317a) {
            case 5:
                String valueOf = String.valueOf(i3);
                return i3 < 10 ? kotlin.jvm.internal.e.k(valueOf, "0") : valueOf;
            default:
                String valueOf2 = String.valueOf(i3);
                if (1 > i3 || i3 > 12) {
                    return valueOf2;
                }
                String[] months = new DateFormatSymbols(Locale.US).getMonths();
                kotlin.jvm.internal.e.e(months, "DateFormatSymbols(Locale.US).months");
                String str = (String) kotlin.collections.g.g(months).get(i3 - 1);
                if (str.length() <= 3) {
                    return str;
                }
                String substring = str.substring(0, 3);
                kotlin.jvm.internal.e.e(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                return substring;
        }
    }

    @Override // k.a
    public Object apply(Object obj) {
        String text$lambda$0;
        switch (this.f16317a) {
            case 1:
                return null;
            default:
                text$lambda$0 = PageViewModel.text$lambda$0((Integer) obj);
                return text$lambda$0;
        }
    }

    @Override // t.w0
    public void b(f1 f1Var) {
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(f1Var.f18320b.getWidth(), f1Var.f18320b.getHeight());
        surfaceTexture.detachFromGLContext();
        Surface surface = new Surface(surfaceTexture);
        f1Var.a(surface, a6.a(), new c0.d(2, surface, surfaceTexture));
    }
}
