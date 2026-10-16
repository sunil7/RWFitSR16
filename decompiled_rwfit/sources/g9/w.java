package g9;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.z1;
import com.google.android.exoplayer2.ui.R$id;

/* loaded from: classes.dex */
public final class w extends z1 {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f14012a;

    /* renamed from: b, reason: collision with root package name */
    public final View f14013b;

    public w(View view) {
        super(view);
        if (i9.g.f14378a < 26) {
            view.setFocusable(true);
        }
        this.f14012a = (TextView) view.findViewById(R$id.exo_text);
        this.f14013b = view.findViewById(R$id.exo_check);
    }
}
