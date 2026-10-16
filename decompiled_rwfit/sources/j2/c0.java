package j2;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.text.TextUtils;
import android.view.View;
import com.bingoogolapple.qrcode.core.QRCodeView;
import com.example.test.ui.device.activity.ScanQrCodeActivity;
import l1.h1;

/* loaded from: classes.dex */
public final class c0 extends AnimatorListenerAdapter {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f15185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f15186b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f15187c;

    public /* synthetic */ c0(int i3, Object obj, Object obj2) {
        this.f15185a = i3;
        this.f15187c = obj;
        this.f15186b = obj2;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        switch (this.f15185a) {
            case 2:
                ((h1) this.f15186b).a((View) this.f15187c);
                break;
            default:
                super.onAnimationCancel(animator);
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator animator) {
        switch (this.f15185a) {
            case 0:
                ((m0.b) this.f15186b).remove(animator);
                ((f0) this.f15187c).f15217m.remove(animator);
                break;
            case 1:
                ((ra.e) this.f15186b).setCircularRevealOverlayDrawable(null);
                break;
            case 2:
                ((h1) this.f15186b).onAnimationEnd();
                break;
            default:
                QRCodeView qRCodeView = (QRCodeView) this.f15187c;
                if (qRCodeView.e) {
                    String str = (String) this.f15186b;
                    if (TextUtils.isEmpty(str)) {
                        try {
                            Camera camera = qRCodeView.f6860a;
                            if (camera != null) {
                                camera.setOneShotPreviewCallback(qRCodeView);
                                break;
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    } else {
                        qRCodeView.e = false;
                        try {
                            t3.d dVar = qRCodeView.f6863d;
                            if (dVar != null) {
                                ((ScanQrCodeActivity) dVar).S0(str);
                                break;
                            }
                        } catch (Exception e10) {
                            e10.printStackTrace();
                        }
                    }
                }
                break;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
        switch (this.f15185a) {
            case 0:
                ((f0) this.f15187c).f15217m.add(animator);
                break;
            case 1:
                ((ra.e) this.f15186b).setCircularRevealOverlayDrawable((Drawable) this.f15187c);
                break;
            case 2:
                ((h1) this.f15186b).onAnimationStart();
                break;
            default:
                super.onAnimationStart(animator);
                break;
        }
    }

    public /* synthetic */ c0(Object obj, int i3, Object obj2, boolean z5) {
        this.f15185a = i3;
        this.f15186b = obj;
        this.f15187c = obj2;
    }
}
