package t3;

import android.animation.ValueAnimator;
import com.bingoogolapple.qrcode.core.QRCodeView;
import com.google.android.material.internal.t;
import j2.c0;

/* loaded from: classes.dex */
public final class c implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18498a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f18499b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ int f18500c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ String f18501d;
    public final /* synthetic */ QRCodeView e;

    public c(QRCodeView qRCodeView, int i3, int i10, int i11, String str) {
        this.e = qRCodeView;
        this.f18498a = i3;
        this.f18499b = i10;
        this.f18500c = i11;
        this.f18501d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i3 = this.f18498a;
        int min = Math.min(this.f18499b + i3, this.f18500c);
        long[] jArr = QRCodeView.f6859o;
        QRCodeView qRCodeView = this.e;
        qRCodeView.getClass();
        ValueAnimator ofInt = ValueAnimator.ofInt(i3, min);
        qRCodeView.f6869k = ofInt;
        ofInt.addUpdateListener(new t(qRCodeView, 11));
        qRCodeView.f6869k.addListener(new c0(3, qRCodeView, this.f18501d));
        qRCodeView.f6869k.setDuration(600L);
        qRCodeView.f6869k.setRepeatCount(0);
        qRCodeView.f6869k.start();
        qRCodeView.f6870l = System.currentTimeMillis();
    }
}
