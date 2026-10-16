package u6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.j1;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.testui.TRingSportTypeNewActivity;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public final class u extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public TRingSportTypeNewActivity f18925a;

    /* renamed from: b, reason: collision with root package name */
    public List f18926b;

    /* renamed from: c, reason: collision with root package name */
    public s f18927c;

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        List list = this.f18926b;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        t tVar = (t) z1Var;
        if (i3 == 1) {
            i3 = 5;
        } else if (i3 == 4) {
            i3 = 6;
        } else if (i3 == 5) {
            i3 = 1;
        } else if (i3 == 6) {
            i3 = 4;
        }
        tVar.f18924b.setText((String) this.f18926b.get(i3));
        tVar.itemView.setOnClickListener(new g9.r(this, i3, 2));
        String j4 = l0.j(i3 + 7, "jlrunning_");
        TRingSportTypeNewActivity tRingSportTypeNewActivity = this.f18925a;
        int identifier = tRingSportTypeNewActivity.getResources().getIdentifier(j4, "mipmap", tRingSportTypeNewActivity.getPackageName());
        j1 j1Var = new j1(-1, -2);
        if (identifier > 0) {
            ((ViewGroup.MarginLayoutParams) j1Var).height = -2;
            ((ViewGroup.MarginLayoutParams) j1Var).width = -1;
            z1Var.itemView.setVisibility(0);
            tVar.f18923a.setImageResource(identifier);
        } else {
            ((ViewGroup.MarginLayoutParams) j1Var).height = 0;
            ((ViewGroup.MarginLayoutParams) j1Var).width = 0;
            z1Var.itemView.setVisibility(8);
        }
        z1Var.itemView.setLayoutParams(j1Var);
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.f18925a).inflate(R$layout.sport_type_item, viewGroup, false);
        t tVar = new t(viewGroup2);
        tVar.f18923a = (ImageView) viewGroup2.findViewById(R$id.iv_avatar);
        tVar.f18924b = (TextView) viewGroup2.findViewById(R$id.tv_name);
        return tVar;
    }

    public void setOnItemClickListener(s sVar) {
        this.f18927c = sVar;
    }
}
