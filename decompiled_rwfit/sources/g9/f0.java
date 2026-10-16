package g9;

import android.view.TextureView;
import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerView;

/* loaded from: classes.dex */
public final class f0 implements com.google.android.exoplayer2.o, View.OnLayoutChangeListener, View.OnClickListener, z {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerView f13949a;

    public f0(StyledPlayerView styledPlayerView) {
        this.f13949a = styledPlayerView;
        new com.google.android.exoplayer2.s();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i3 = StyledPlayerView.f9016z;
        this.f13949a.f();
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        StyledPlayerView.a((TextureView) view, this.f13949a.f9038x);
    }
}
