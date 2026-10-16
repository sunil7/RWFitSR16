package com.example.test.presenter.device;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.example.test.ui.device.activity.DialDetailActivity;
import java.io.File;

/* loaded from: classes.dex */
public final class v extends pe.p {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ x f7486b;

    public v(x xVar) {
        this.f7486b = xVar;
    }

    @Override // pe.p
    public final void a(pe.b bVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DialDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("下载完成 ", bVar != null ? bVar.b() : null));
        String b3 = bVar != null ? bVar.b() : null;
        final x xVar = this.f7486b;
        xVar.getClass();
        com.example.baselibrary.preseneter.b.j(b3, new oh.l() { // from class: com.example.test.presenter.device.DialDetailPresenter$fileDownloadSuccess$1
            {
                super(1);
            }

            @Override // oh.l
            public final eh.g invoke(String str) {
                int i3;
                int i10;
                String str2;
                eh.g gVar = eh.g.f12633a;
                if (str == null || str.length() == 0) {
                    x.this.o();
                    return gVar;
                }
                DialDetailActivity dialDetailActivity = (DialDetailActivity) ((f7.g) x.this.f7255a);
                dialDetailActivity.getClass();
                x xVar2 = x.this;
                File file = new File(android.support.v4.media.session.e.j(dialDetailActivity.getFilesDir(), "/dial"));
                if (!file.exists()) {
                    file.mkdir();
                }
                Bitmap decodeFile = BitmapFactory.decodeFile(str);
                if (decodeFile != null) {
                    i3 = (int) (decodeFile.getWidth() * 0.625f);
                    i10 = (int) (decodeFile.getHeight() * 0.625f);
                } else {
                    i3 = 150;
                    i10 = 175;
                }
                String str3 = xVar2.f7491f;
                if (str3 != null) {
                    i3 = Integer.parseInt(str3);
                }
                String str4 = xVar2.f7492g;
                if (str4 != null) {
                    i10 = Integer.parseInt(str4);
                }
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeFile, i3, i10, true);
                if (createScaledBitmap == null) {
                    str2 = "";
                } else {
                    str2 = file.getAbsolutePath() + "/dial_thumb_" + System.currentTimeMillis() + ".bin";
                }
                kotlin.jvm.internal.e.c(createScaledBitmap);
                y5.d.f(createScaledBitmap, str2);
                xVar2.m(1, xVar2.e, str2);
                return gVar;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.DialDetailPresenter$fileDownloadSuccess$2
            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }

            public final void invoke(eh.g gVar) {
            }
        });
    }

    @Override // pe.p
    public final void b(pe.b bVar, Throwable th2) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DialDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.p("下载失败：", bVar != null ? bVar.f17547d : null, " ", th2 != null ? th2.getMessage() : null));
        this.f7486b.o();
    }

    @Override // pe.p
    public final void c(pe.b bVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DialDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("下载等待中：", bVar != null ? bVar.f17547d : null));
    }

    @Override // pe.p
    public final void d(int i3, int i10) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DialDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.m("下载中：", (i3 / i10) * 100.0f));
    }

    @Override // pe.p
    public final void e(pe.b bVar) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DialDetailPresenter", com.google.android.gms.internal.mlkit_vision_barcode.l0.o("下载提示：", bVar != null ? bVar.f17547d : null, " "));
    }
}
