package g9;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.google.android.exoplayer2.ui.R$layout;
import com.google.android.exoplayer2.ui.R$string;
import com.google.android.exoplayer2.ui.StyledPlayerControlView;
import com.google.android.gms.internal.mlkit_vision_barcode.zb;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class o extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f13992a = new ArrayList();

    /* renamed from: b, reason: collision with root package name */
    public List f13993b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ StyledPlayerControlView f13994c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f13995d;
    public final /* synthetic */ StyledPlayerControlView e;

    public o(StyledPlayerControlView styledPlayerControlView, int i3) {
        this.f13995d = i3;
        this.e = styledPlayerControlView;
        this.f13994c = styledPlayerControlView;
    }

    private final void f(String str) {
    }

    public final void a(ArrayList arrayList, ArrayList arrayList2, zb zbVar) {
        switch (this.f13995d) {
            case 0:
                int size = arrayList.size();
                StyledPlayerControlView styledPlayerControlView = this.e;
                if (size > 0) {
                    ((Integer) arrayList.get(0)).intValue();
                    zbVar.getClass();
                    throw null;
                }
                if (arrayList2.isEmpty()) {
                    styledPlayerControlView.f8989d0.f14009b[1] = styledPlayerControlView.getResources().getString(R$string.exo_track_selection_none);
                } else {
                    styledPlayerControlView.f8989d0.f14009b[1] = styledPlayerControlView.getResources().getString(R$string.exo_track_selection_auto);
                }
                this.f13992a = arrayList;
                this.f13993b = arrayList2;
                return;
            default:
                boolean z5 = false;
                int i3 = 0;
                while (true) {
                    if (i3 < arrayList2.size()) {
                        if (((x) arrayList2.get(i3)).e) {
                            z5 = true;
                        } else {
                            i3++;
                        }
                    }
                }
                StyledPlayerControlView styledPlayerControlView2 = this.e;
                ImageView imageView = styledPlayerControlView2.U0;
                if (imageView != null) {
                    imageView.setImageDrawable(z5 ? styledPlayerControlView2.G : styledPlayerControlView2.H);
                    styledPlayerControlView2.U0.setContentDescription(z5 ? styledPlayerControlView2.I : styledPlayerControlView2.J);
                }
                this.f13992a = arrayList;
                this.f13993b = arrayList2;
                return;
        }
    }

    public void b(w wVar, int i3) {
        switch (this.f13995d) {
            case 1:
                c(wVar, i3);
                if (i3 > 0) {
                    wVar.f14013b.setVisibility(((x) this.f13993b.get(i3 + (-1))).e ? 0 : 4);
                    break;
                }
                break;
            default:
                c(wVar, i3);
                break;
        }
    }

    public final void c(w wVar, int i3) {
        this.f13994c.getClass();
    }

    public final void d(w wVar) {
        switch (this.f13995d) {
            case 0:
                wVar.f14012a.setText(R$string.exo_track_selection_auto);
                this.e.getClass();
                throw null;
            default:
                wVar.f14012a.setText(R$string.exo_track_selection_none);
                int i3 = 0;
                int i10 = 0;
                while (true) {
                    if (i10 < this.f13993b.size()) {
                        if (((x) this.f13993b.get(i10)).e) {
                            i3 = 4;
                        } else {
                            i10++;
                        }
                    }
                }
                wVar.f14013b.setVisibility(i3);
                wVar.itemView.setOnClickListener(new com.example.test.ui.testui.p(this, 5));
                return;
        }
    }

    public final void e(String str) {
        switch (this.f13995d) {
            case 0:
                this.e.f8989d0.f14009b[1] = str;
                break;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        if (this.f13993b.isEmpty()) {
            return 0;
        }
        return this.f13993b.size() + 1;
    }

    @Override // androidx.recyclerview.widget.z0
    public /* bridge */ /* synthetic */ void onBindViewHolder(z1 z1Var, int i3) {
        switch (this.f13995d) {
            case 1:
                b((w) z1Var, i3);
                break;
            default:
                b((w) z1Var, i3);
                break;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        return new w(LayoutInflater.from(this.f13994c.getContext()).inflate(R$layout.exo_styled_sub_settings_list_item, viewGroup, false));
    }
}
