package r6;

import android.widget.CompoundButton;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.example.test.ui.device.model.AlarmModel;

/* loaded from: classes.dex */
public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f18093a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AlarmModel f18094b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ BaseItemProvider f18095c;

    public /* synthetic */ b(BaseItemProvider baseItemProvider, AlarmModel alarmModel, int i3) {
        this.f18093a = i3;
        this.f18095c = baseItemProvider;
        this.f18094b = alarmModel;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z5) {
        switch (this.f18093a) {
            case 0:
                c cVar = (c) this.f18095c;
                if (cVar.f18096a != null && cVar.getAdapter2() != null) {
                    cVar.f18096a.c(cVar.getAdapter2().getItemPosition(this.f18094b), z5);
                    break;
                }
                break;
            default:
                d dVar = (d) this.f18095c;
                if (dVar.f18097a != null && dVar.getAdapter2() != null) {
                    dVar.f18097a.c(dVar.getAdapter2().getItemPosition(this.f18094b), z5);
                    break;
                }
                break;
        }
    }
}
