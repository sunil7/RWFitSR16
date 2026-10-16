package c7;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import org.joda.time.DateTime;

/* loaded from: classes.dex */
public final class c extends BaseAdapter {

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f3400a;

    /* renamed from: b, reason: collision with root package name */
    public DateTime f3401b;

    @Override // android.widget.Adapter
    public final int getCount() {
        return 7;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        return (DateTime) this.f3400a.get(i3);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        return i3;
    }

    @Override // android.widget.Adapter
    public final View getView(int i3, View view, ViewGroup viewGroup) {
        ArrayList arrayList = this.f3400a;
        ((DateTime) arrayList.get(i3)).toString("yyyyMMdd").equals(this.f3401b.toString("yyyyMMdd"));
        throw null;
    }
}
