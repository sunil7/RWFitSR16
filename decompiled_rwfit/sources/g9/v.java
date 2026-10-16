package g9;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final class v extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f14008a;

    /* renamed from: b, reason: collision with root package name */
    public final String[] f14009b;

    /* renamed from: c, reason: collision with root package name */
    public final Drawable[] f14010c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView f14011d;

    public v(StyledPlayerControlView styledPlayerControlView, String[] strArr, Drawable[] drawableArr) {
        this.f14011d = styledPlayerControlView;
        this.f14008a = strArr;
        this.f14009b = new String[strArr.length];
        this.f14010c = drawableArr;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f14008a.length;
    }

    @Override // androidx.recyclerview.widget.z0
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        u uVar = (u) z1Var;
        uVar.f14004a.setText(this.f14008a[i3]);
        String str = this.f14009b[i3];
        TextView textView = uVar.f14005b;
        if (str == null) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
        }
        Drawable drawable = this.f14010c[i3];
        ImageView imageView = uVar.f14006c;
        if (drawable == null) {
            imageView.setVisibility(8);
        } else {
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        StyledPlayerControlView styledPlayerControlView = this.f14011d;
        return new u(styledPlayerControlView, LayoutInflater.from(styledPlayerControlView.getContext()).inflate(R$layout.exo_styled_settings_list_item, viewGroup, false));
    }
}
