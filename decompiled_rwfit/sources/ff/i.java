package ff;

import android.util.Range;
import android.util.Size;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final class i implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13620a;

    /* renamed from: b, reason: collision with root package name */
    public final boolean f13621b;

    public /* synthetic */ i(boolean z5, int i3) {
        this.f13620a = i3;
        this.f13621b = z5;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        switch (this.f13620a) {
            case 0:
                Range range = (Range) obj;
                Range range2 = (Range) obj2;
                return this.f13621b ? (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue()) - (((Integer) range2.getUpper()).intValue() - ((Integer) range2.getLower()).intValue()) : (((Integer) range2.getUpper()).intValue() - ((Integer) range2.getLower()).intValue()) - (((Integer) range.getUpper()).intValue() - ((Integer) range.getLower()).intValue());
            default:
                Size size = (Size) obj;
                Size size2 = (Size) obj2;
                int signum = Long.signum((size.getWidth() * size.getHeight()) - (size2.getWidth() * size2.getHeight()));
                return this.f13621b ? signum * (-1) : signum;
        }
    }
}
