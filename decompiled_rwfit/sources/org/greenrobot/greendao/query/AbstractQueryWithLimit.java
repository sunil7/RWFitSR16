package org.greenrobot.greendao.query;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import org.greenrobot.greendao.AbstractDao;

/* loaded from: classes2.dex */
abstract class AbstractQueryWithLimit<T> extends AbstractQuery<T> {
    protected final int limitPosition;
    protected final int offsetPosition;

    public AbstractQueryWithLimit(AbstractDao<T, ?> abstractDao, String str, String[] strArr, int i3, int i10) {
        super(abstractDao, str, strArr);
        this.limitPosition = i3;
        this.offsetPosition = i10;
    }

    public void setLimit(int i3) {
        checkThread();
        int i10 = this.limitPosition;
        if (i10 == -1) {
            throw new IllegalStateException("Limit must be set with QueryBuilder before it can be used here");
        }
        this.parameters[i10] = Integer.toString(i3);
    }

    public void setOffset(int i3) {
        checkThread();
        int i10 = this.offsetPosition;
        if (i10 == -1) {
            throw new IllegalStateException("Offset must be set with QueryBuilder before it can be used here");
        }
        this.parameters[i10] = Integer.toString(i3);
    }

    @Override // org.greenrobot.greendao.query.AbstractQuery
    public AbstractQueryWithLimit<T> setParameter(int i3, Object obj) {
        if (i3 < 0 || !(i3 == this.limitPosition || i3 == this.offsetPosition)) {
            return (AbstractQueryWithLimit) super.setParameter(i3, obj);
        }
        throw new IllegalArgumentException(l0.j(i3, "Illegal parameter index: "));
    }
}
