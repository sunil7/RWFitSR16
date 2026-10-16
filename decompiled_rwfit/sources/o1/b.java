package o1;

import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.d2;
import androidx.appcompat.widget.i3;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.liulishuo.filedownloader.model.FileDownloadModel;

/* loaded from: classes.dex */
public abstract class b extends BaseAdapter implements Filterable {

    /* renamed from: a, reason: collision with root package name */
    public boolean f16682a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f16683b;

    /* renamed from: c, reason: collision with root package name */
    public Cursor f16684c;

    /* renamed from: d, reason: collision with root package name */
    public int f16685d;
    public a e;

    /* renamed from: f, reason: collision with root package name */
    public d2 f16686f;

    /* renamed from: g, reason: collision with root package name */
    public c f16687g;

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f16684c;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.e;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                d2 d2Var = this.f16686f;
                if (d2Var != null) {
                    cursor2.unregisterDataSetObserver(d2Var);
                }
            }
            this.f16684c = cursor;
            if (cursor != null) {
                a aVar2 = this.e;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                d2 d2Var2 = this.f16686f;
                if (d2Var2 != null) {
                    cursor.registerDataSetObserver(d2Var2);
                }
                this.f16685d = cursor.getColumnIndexOrThrow(FileDownloadModel.ID);
                this.f16682a = true;
                notifyDataSetChanged();
            } else {
                this.f16685d = -1;
                this.f16682a = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    @Override // android.widget.Adapter
    public final int getCount() {
        Cursor cursor;
        if (!this.f16682a || (cursor = this.f16684c) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f16682a) {
            return null;
        }
        this.f16684c.moveToPosition(i3);
        if (view == null) {
            i3 i3Var = (i3) this;
            view = i3Var.f933j.inflate(i3Var.f932i, viewGroup, false);
        }
        a(view, this.f16684c);
        return view;
    }

    @Override // android.widget.Filterable
    public final Filter getFilter() {
        if (this.f16687g == null) {
            c cVar = new c();
            cVar.f16688a = this;
            this.f16687g = cVar;
        }
        return this.f16687g;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i3) {
        Cursor cursor;
        if (!this.f16682a || (cursor = this.f16684c) == null) {
            return null;
        }
        cursor.moveToPosition(i3);
        return this.f16684c;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i3) {
        Cursor cursor;
        if (this.f16682a && (cursor = this.f16684c) != null && cursor.moveToPosition(i3)) {
            return this.f16684c.getLong(this.f16685d);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i3, View view, ViewGroup viewGroup) {
        if (!this.f16682a) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (!this.f16684c.moveToPosition(i3)) {
            throw new IllegalStateException(l0.j(i3, "couldn't move cursor to position "));
        }
        if (view == null) {
            view = d(viewGroup);
        }
        a(view, this.f16684c);
        return view;
    }
}
