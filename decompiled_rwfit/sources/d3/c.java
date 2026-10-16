package d3;

import com.amap.location.support.bean.cell.AmapCell;
import com.google.android.exoplayer2.Format;
import de.o;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c {

    /* renamed from: f, reason: collision with root package name */
    public static volatile c f12233f;

    /* renamed from: g, reason: collision with root package name */
    public static final Object f12234g = new Object();

    /* renamed from: a, reason: collision with root package name */
    public j3.a f12235a;

    /* renamed from: b, reason: collision with root package name */
    public Object f12236b;

    /* renamed from: c, reason: collision with root package name */
    public Object f12237c;

    /* renamed from: d, reason: collision with root package name */
    public final Object f12238d;
    public final Object e;

    public c(int i3) {
        switch (i3) {
            case 1:
                a aVar = new a();
                aVar.f12222f = new ArrayList();
                aVar.f12223g = new ArrayList();
                this.f12238d = aVar;
                this.e = new ArrayList(3);
                break;
            default:
                this.f12238d = new j3.a();
                this.f12236b = new c(1);
                o oVar = new o(18, false);
                oVar.f12377b = new ArrayList();
                oVar.f12379d = new ArrayList();
                this.f12237c = oVar;
                this.e = new c3.a(2048);
                break;
        }
    }

    public void a(AmapCell amapCell) {
        ArrayList arrayList = (ArrayList) this.e;
        int size = arrayList.size();
        if (size == 0) {
            arrayList.add(amapCell);
            return;
        }
        int i3 = -1;
        long j4 = Format.OFFSET_SAMPLE_RELATIVE;
        int i10 = 0;
        int i11 = -1;
        while (true) {
            if (i10 >= size) {
                i3 = i11;
                break;
            }
            AmapCell amapCell2 = (AmapCell) arrayList.get(i10);
            if (amapCell.equals(amapCell2)) {
                int i12 = amapCell.signalStrength;
                if (i12 != amapCell2.signalStrength) {
                    amapCell2.lastUpdateSystemMills = i12;
                    amapCell2.signalStrength = i12;
                }
            } else {
                j4 = Math.min(j4, amapCell2.lastUpdateSystemMills);
                if (j4 == amapCell2.lastUpdateSystemMills) {
                    i11 = i10;
                }
                i10++;
            }
        }
        if (i3 >= 0) {
            if (size < 3) {
                arrayList.add(amapCell);
            } else {
                if (amapCell.lastUpdateSystemMills <= j4 || i3 >= size) {
                    return;
                }
                arrayList.remove(i3);
                arrayList.add(amapCell);
            }
        }
    }
}
