package n2;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public final DataSetObservable f16360a = new DataSetObservable();

    /* renamed from: b, reason: collision with root package name */
    public DataSetObserver f16361b;

    public abstract void a(ViewPager viewPager, int i3, Object obj);

    public void b() {
    }

    public abstract int c();

    public int d(Object obj) {
        return -1;
    }

    public CharSequence e(int i3) {
        return null;
    }

    public abstract Object f(ViewPager viewPager, int i3);

    public abstract boolean g(View view, Object obj);

    public void h() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f16361b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        this.f16360a.notifyChanged();
    }

    public void i(Object obj) {
    }

    public void j(ViewPager viewPager) {
    }
}
