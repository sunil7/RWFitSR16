package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.hardware.Camera;
import android.view.View;
import android.widget.TextView;
import com.bingoogolapple.qrcode.core.CameraPreview;
import com.bingoogolapple.qrcode.core.QRCodeView;
import com.github.mikephil.charting.charts.Chart;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.textfield.TextInputLayout;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;

/* loaded from: classes.dex */
public final class t implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10637a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f10638b;

    public /* synthetic */ t(Object obj, int i3) {
        this.f10637a = i3;
        this.f10638b = obj;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        switch (this.f10637a) {
            case 0:
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                TextView textView = (TextView) this.f10638b;
                textView.setScaleX(floatValue);
                textView.setScaleY(floatValue);
                break;
            case 1:
                ((com.google.android.material.textfield.l) this.f10638b).f10923c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 2:
                ((TextInputLayout) this.f10638b).f10868p1.n(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 3:
                ((SmartRefreshLayout) this.f10638b).f1.l(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
                break;
            case 4:
                ((TabLayout) this.f10638b).scrollTo(((Integer) valueAnimator.getAnimatedValue()).intValue(), 0);
                break;
            case 5:
                ((eb.h) this.f10638b).k(((Float) valueAnimator.getAnimatedValue()).floatValue());
                break;
            case 6:
                ((CollapsingToolbarLayout) this.f10638b).setScrimAlpha(((Integer) valueAnimator.getAnimatedValue()).intValue());
                break;
            case 7:
                ((View) this.f10638b).invalidate();
                break;
            case 8:
                ((Chart) this.f10638b).postInvalidate();
                break;
            case 9:
                float floatValue2 = ((Float) valueAnimator.getAnimatedValue()).floatValue() * 1.0f;
                md.c cVar = (md.c) this.f10638b;
                cVar.f16035b.f11308d.setTranslationY(r1.f11315l * (floatValue2 / r1.f11314k));
                cVar.f16035b.f11319p = true;
                break;
            case 10:
                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                eb.h hVar = ((BottomSheetBehavior) this.f10638b).f10279i;
                if (hVar != null) {
                    hVar.m(floatValue3);
                    break;
                }
                break;
            default:
                QRCodeView qRCodeView = (QRCodeView) this.f10638b;
                CameraPreview cameraPreview = qRCodeView.f6861b;
                if (cameraPreview != null && cameraPreview.c()) {
                    int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    Camera.Parameters parameters = qRCodeView.f6860a.getParameters();
                    parameters.setZoom(intValue);
                    qRCodeView.f6860a.setParameters(parameters);
                    break;
                }
                break;
        }
    }
}
