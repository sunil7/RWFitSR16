package androidx.appcompat.app;

import android.content.DialogInterface;
import android.view.View;
import android.widget.AdapterView;
import java.time.LocalDate;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public final class d implements AdapterView.OnItemClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f447a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f448b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f449c;

    public /* synthetic */ d(int i3, Object obj, Object obj2) {
        this.f447a = i3;
        this.f449c = obj;
        this.f448b = obj2;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i3, long j4) {
        switch (this.f447a) {
            case 0:
                e eVar = (e) this.f449c;
                DialogInterface.OnClickListener onClickListener = eVar.f461l;
                h hVar = (h) this.f448b;
                onClickListener.onClick(hVar.f483b, i3);
                if (!eVar.f463n) {
                    hVar.f483b.dismiss();
                    break;
                }
                break;
            default:
                c7.c cVar = (c7.c) this.f448b;
                DateTime dateTime = (DateTime) cVar.f3400a.get(i3);
                c7.b bVar = (c7.b) this.f449c;
                bVar.f3399h = dateTime;
                if (!LocalDate.of(dateTime.getYear(), dateTime.getMonthOfYear(), dateTime.getDayOfMonth()).isAfter(LocalDate.now())) {
                    cVar.f3401b = bVar.f3399h;
                    bVar.h();
                    break;
                }
                break;
        }
    }
}
