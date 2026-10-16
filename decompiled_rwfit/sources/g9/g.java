package g9;

import android.view.View;
import android.widget.TextView;
import com.google.android.exoplayer2.ui.PlayerControlView;

/* loaded from: classes.dex */
public final class g implements com.google.android.exoplayer2.o, i0, View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PlayerControlView f13950a;

    public g(PlayerControlView playerControlView) {
        this.f13950a = playerControlView;
    }

    @Override // g9.i0
    public final void a(long j4) {
        PlayerControlView playerControlView = this.f13950a;
        playerControlView.K = true;
        TextView textView = playerControlView.f8944m;
        if (textView != null) {
            textView.setText(i9.g.d(playerControlView.f8946o, playerControlView.f8947p, j4));
        }
    }

    @Override // g9.i0
    public final void b(long j4, boolean z5) {
        this.f13950a.K = false;
    }

    @Override // g9.i0
    public final void c(long j4) {
        PlayerControlView playerControlView = this.f13950a;
        TextView textView = playerControlView.f8944m;
        if (textView != null) {
            textView.setText(i9.g.d(playerControlView.f8946o, playerControlView.f8947p, j4));
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f13950a.getClass();
    }
}
