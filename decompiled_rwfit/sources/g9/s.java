package g9;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;

/* loaded from: classes.dex */
public final class s extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f14000a;

    /* renamed from: b, reason: collision with root package name */
    public final int[] f14001b;

    /* renamed from: c, reason: collision with root package name */
    public int f14002c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView f14003d;

    public s(StyledPlayerControlView styledPlayerControlView, String[] strArr, int[] iArr) {
        this.f14003d = styledPlayerControlView;
        this.f14000a = strArr;
        this.f14001b = iArr;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f14000a.length;
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        w wVar = (w) z1Var;
        String[] strArr = this.f14000a;
        if (i3 < strArr.length) {
            wVar.f14012a.setText(strArr[i3]);
        }
        wVar.f14013b.setVisibility(i3 == this.f14002c ? 0 : 4);
        wVar.itemView.setOnClickListener(new r(this, i3, 0));
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new w(LayoutInflater.from(this.f14003d.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}
