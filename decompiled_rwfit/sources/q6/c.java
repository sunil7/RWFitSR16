package q6;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import g9.r;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f17792a;

    /* renamed from: b, reason: collision with root package name */
    public a f17793b;

    public c(ArrayList arrayList) {
        this.f17792a = arrayList;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        return this.f17792a.size();
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        b bVar = (b) z1Var;
        com.example.test.ui.testui.b bVar2 = (com.example.test.ui.testui.b) this.f17792a.get(i3);
        if (bVar2 != null) {
            bVar.f17790a.setText(bVar2.f8260b);
            bVar.f17790a.setText(bVar2.f8262d.intValue());
            int i10 = bVar2.f8261c;
            ImageView imageView = bVar.f17791b;
            if (i10 == 0) {
                imageView.setImageResource(R$drawable.svg_select_no);
            } else {
                imageView.setImageResource(R$mipmap.select_yes);
            }
        }
        bVar.itemView.setOnClickListener(new r(this, i3, 1));
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.item_ring_card, viewGroup, false);
        b bVar = new b(inflate);
        bVar.f17790a = (TextView) inflate.findViewById(R$id.cardid);
        bVar.f17791b = (ImageView) inflate.findViewById(R$id.cardsel);
        return bVar;
    }

    public void setOnItemSelectClickListener(a aVar) {
        this.f17793b = aVar;
    }
}
