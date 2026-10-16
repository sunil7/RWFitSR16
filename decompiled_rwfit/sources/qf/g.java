package qf;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.WindowManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;

/* loaded from: classes2.dex */
public final class g {

    /* renamed from: b, reason: collision with root package name */
    public final Context f17947b;

    /* renamed from: c, reason: collision with root package name */
    public final ef.i f17948c;

    /* renamed from: d, reason: collision with root package name */
    public final f f17949d;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17952h;

    /* renamed from: a, reason: collision with root package name */
    public final Handler f17946a = new Handler(Looper.getMainLooper());
    public int e = -1;

    /* renamed from: g, reason: collision with root package name */
    public int f17951g = -1;

    /* renamed from: f, reason: collision with root package name */
    public final h0.d f17950f = new h0.d(this, 1);

    public g(Context context, ef.i iVar) {
        this.f17947b = context;
        this.f17948c = iVar;
        this.f17949d = new f(this, context.getApplicationContext());
    }

    public final int a() {
        int rotation = ((WindowManager) this.f17947b.getSystemService("window")).getDefaultDisplay().getRotation();
        if (rotation == 1) {
            return 90;
        }
        if (rotation == 2) {
            return 180;
        }
        if (rotation != 3) {
            return 0;
        }
        return SubsamplingScaleImageView.ORIENTATION_270;
    }
}
