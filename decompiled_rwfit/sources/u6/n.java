package u6;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.z0;
import androidx.recyclerview.widget.z1;
import com.example.network.bean.FamilySportItem;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.testui.TRingFamilySportsActivity;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class n extends z0 {

    /* renamed from: a, reason: collision with root package name */
    public TRingFamilySportsActivity f18911a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f18912b;

    @Override // androidx.recyclerview.widget.z0
    public final int getItemCount() {
        ArrayList arrayList = this.f18912b;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.z0
    public final int getItemViewType(int i3) {
        return ((FamilySportItem) this.f18912b.get(i3)).getType().intValue();
    }

    @Override // androidx.recyclerview.widget.z0
    public final void onBindViewHolder(z1 z1Var, int i3) {
        m mVar = (m) z1Var;
        FamilySportItem familySportItem = (FamilySportItem) this.f18912b.get(i3);
        String str = "--";
        switch (familySportItem.getType().intValue()) {
            case 1:
                mVar.f18908a.setText(R$string.str_hr_title);
                StringBuilder sb2 = new StringBuilder();
                Integer num = str;
                if (familySportItem.getValue() != null) {
                    num = familySportItem.getValue();
                }
                sb2.append(num);
                sb2.append(" bpm");
                mVar.f18909b.setText(sb2.toString());
                mVar.f18910c.setImageResource(R$mipmap.family_sport_heart_rate);
                break;
            case 2:
                if (familySportItem.getValue() != null) {
                    int intValue = familySportItem.getValue().intValue() / 60;
                    int intValue2 = familySportItem.getValue().intValue() % 60;
                    mVar.f18909b.setText(intValue + " h " + intValue2 + " m");
                } else {
                    mVar.f18909b.setText("-- h -- m");
                }
                mVar.f18908a.setText(R$string.str_sleep_title);
                mVar.f18910c.setImageResource(R$mipmap.family_sport_sleep);
                break;
            case 3:
                mVar.f18908a.setText(R$string.str_bo_title);
                StringBuilder sb3 = new StringBuilder();
                Integer num2 = str;
                if (familySportItem.getValue() != null) {
                    num2 = familySportItem.getValue();
                }
                sb3.append(num2);
                sb3.append(" %");
                mVar.f18909b.setText(sb3.toString());
                mVar.f18910c.setImageResource(R$mipmap.family_sport_oxygen);
                break;
            case 4:
                mVar.f18908a.setText(R$string.str_bloodsugar_title);
                StringBuilder sb4 = new StringBuilder();
                String str2 = str;
                if (familySportItem.getValue() != null) {
                    str2 = familySportItem.getBigDecimalValue().toPlainString();
                }
                mVar.f18909b.setText(r5.a.f(sb4, str2, " mmol/L"));
                mVar.f18910c.setImageResource(R$mipmap.family_sport_sugar);
                break;
            case 5:
                mVar.f18908a.setText(R$string.ring_str_hrv_title);
                StringBuilder sb5 = new StringBuilder();
                String str3 = str;
                if (familySportItem.getValue() != null) {
                    str3 = familySportItem.getValue();
                }
                sb5.append((Object) str3);
                sb5.append(" ms");
                mVar.f18909b.setText(sb5.toString());
                mVar.f18910c.setImageResource(R$mipmap.family_sport_hrv);
                break;
            case 6:
                mVar.f18908a.setText(R$string.str_press_title);
                String str4 = str;
                if (familySportItem.getValue() != null) {
                    str4 = familySportItem.getValue().toString();
                }
                mVar.f18909b.setText(str4);
                mVar.f18910c.setImageResource(R$mipmap.family_sport_pressure);
                break;
        }
    }

    @Override // androidx.recyclerview.widget.z0
    public final z1 onCreateViewHolder(ViewGroup viewGroup, int i3) {
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(this.f18911a).inflate(R$layout.family_sport_item, viewGroup, false);
        m mVar = new m(viewGroup2);
        mVar.f18908a = (TextView) viewGroup2.findViewById(R$id.itemName);
        mVar.f18909b = (TextView) viewGroup2.findViewById(R$id.itemValue);
        mVar.f18910c = (ImageView) viewGroup2.findViewById(R$id.itemPic);
        return mVar;
    }

    public void setOnItemClickListener(l lVar) {
    }
}
