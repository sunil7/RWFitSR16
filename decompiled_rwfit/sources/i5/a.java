package i5;

import androidx.lifecycle.n;
import androidx.recyclerview.widget.z1;
import com.dh.imagepick.R;
import com.dh.imagepick.preview.core.LifecycleDisposable;
import com.dh.imagepick.preview.widgets.video.ExoVideoView;
import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.gms.internal.mlkit_vision_barcode.oc;
import j5.e;

/* loaded from: classes.dex */
public final class a extends e {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ExoVideoView f14354b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ z1 f14355c;

    public a(ExoVideoView exoVideoView, z1 z1Var, n nVar) {
        this.f14354b = exoVideoView;
        this.f14355c = z1Var;
        m0.b bVar = com.dh.imagepick.preview.utils.a.f7147a;
        if (nVar == null) {
            return;
        }
        nVar.a(new LifecycleDisposable(nVar, this));
    }

    @Override // rg.s
    public final void onNext(Object obj) {
        ((Number) obj).longValue();
        boolean z5 = b.f14356a;
        ExoVideoView exoVideoView = this.f14354b;
        if (z5) {
            if (exoVideoView != null) {
                int i3 = ExoVideoView.f7177f;
            }
        } else {
            PlayerControlView playerControlView = (PlayerControlView) oc.a(this.f14355c, R.id.playerControlView);
            if (playerControlView == null) {
                return;
            }
            if (exoVideoView != null) {
                int i10 = ExoVideoView.f7177f;
            }
            playerControlView.setPlayer(null);
        }
    }
}
