package eb;

import android.graphics.Canvas;
import android.graphics.Matrix;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class p extends v {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f12563b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Matrix f12564c;

    public p(ArrayList arrayList, Matrix matrix) {
        this.f12563b = arrayList;
        this.f12564c = matrix;
    }

    @Override // eb.v
    public final void a(Matrix matrix, db.a aVar, int i3, Canvas canvas) {
        ArrayList arrayList = this.f12563b;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((v) obj).a(this.f12564c, aVar, i3, canvas);
        }
    }
}
