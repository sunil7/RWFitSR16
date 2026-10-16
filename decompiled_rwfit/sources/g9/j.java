package g9;

import android.view.TextureView;
import android.view.View;
import com.google.android.exoplayer2.ui.PlayerView;

/* loaded from: classes.dex */
public final class j implements com.google.android.exoplayer2.o, View.OnLayoutChangeListener, View.OnClickListener, i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerView f13975a;

    public j(PlayerView playerView) {
        this.f13975a = playerView;
        new com.google.android.exoplayer2.s();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i3 = PlayerView.f8957z;
        this.f13975a.f();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        PlayerView.a((TextureView) view, this.f13975a.f8979x);
    }
}
