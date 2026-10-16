package g9;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.z1;
import com.google.android.exoplayer2.ui.R$id;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final class u extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f14004a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f14005b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f14006c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView f14007d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(StyledPlayerControlView styledPlayerControlView, View view) {
        super(view);
        this.f14007d = styledPlayerControlView;
        if (i9.g.f14378a < 26) {
            view.setFocusable(true);
        }
        this.f14004a = (TextView) view.findViewById(R$id.exo_main_text);
        this.f14005b = (TextView) view.findViewById(R$id.exo_sub_text);
        this.f14006c = (ImageView) view.findViewById(R$id.exo_icon);
        view.setOnClickListener(new com.example.test.ui.testui.p(this, 4));
    }
}
