package l1;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public ViewParent f15726a;

    /* renamed from: b, reason: collision with root package name */
    public ViewParent f15727b;

    /* renamed from: c, reason: collision with root package name */
    public final ViewGroup f15728c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f15729d;
    public int[] e;

    public s(ViewGroup viewGroup) {
        this.f15728c = viewGroup;
    }

    public final boolean a(float f2, float f10, boolean z5) {
        ViewParent e;
        if (this.f15729d && (e = e(0)) != null) {
            try {
                return d1.a(e, this.f15728c, f2, f10, z5);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + e + " does not implement interface method onNestedFling", e10);
            }
        }
        return false;
    }

    public final boolean b(float f2, float f10) {
        ViewParent e;
        if (this.f15729d && (e = e(0)) != null) {
            try {
                return d1.b(e, this.f15728c, f2, f10);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + e + " does not implement interface method onNestedPreFling", e10);
            }
        }
        return false;
    }

    public final boolean c(int i3, int i10, int[] iArr, int[] iArr2, int i11) {
        ViewParent e;
        int i12;
        int i13;
        if (!this.f15729d || (e = e(i11)) == null) {
            return false;
        }
        if (i3 == 0 && i10 == 0) {
            if (iArr2 == null) {
                return false;
            }
            iArr2[0] = 0;
            iArr2[1] = 0;
            return false;
        }
        ViewGroup viewGroup = this.f15728c;
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            i12 = iArr2[0];
            i13 = iArr2[1];
        } else {
            i12 = 0;
            i13 = 0;
        }
        if (iArr == null) {
            if (this.e == null) {
                this.e = new int[2];
            }
            iArr = this.e;
        }
        int[] iArr3 = iArr;
        iArr3[0] = 0;
        iArr3[1] = 0;
        if (e instanceof t) {
            ((t) e).b(viewGroup, i3, i10, iArr3, i11);
        } else if (i11 == 0) {
            try {
                d1.c(e, viewGroup, i3, i10, iArr3);
            } catch (AbstractMethodError e10) {
                Log.e("ViewParentCompat", "ViewParent " + e + " does not implement interface method onNestedPreScroll", e10);
            }
        }
        if (iArr2 != null) {
            viewGroup.getLocationInWindow(iArr2);
            iArr2[0] = iArr2[0] - i12;
            iArr2[1] = iArr2[1] - i13;
        }
        return (iArr3[0] == 0 && iArr3[1] == 0) ? false : true;
    }

    public final boolean d(int i3, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        ViewParent e;
        int i14;
        int i15;
        int[] iArr3;
        if (this.f15729d && (e = e(i13)) != null) {
            if (i3 != 0 || i10 != 0 || i11 != 0 || i12 != 0) {
                ViewGroup viewGroup = this.f15728c;
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    i14 = iArr[0];
                    i15 = iArr[1];
                } else {
                    i14 = 0;
                    i15 = 0;
                }
                if (iArr2 == null) {
                    if (this.e == null) {
                        this.e = new int[2];
                    }
                    int[] iArr4 = this.e;
                    iArr4[0] = 0;
                    iArr4[1] = 0;
                    iArr3 = iArr4;
                } else {
                    iArr3 = iArr2;
                }
                if (e instanceof u) {
                    ((u) e).g(viewGroup, i3, i10, i11, i12, i13, iArr3);
                } else {
                    iArr3[0] = iArr3[0] + i11;
                    iArr3[1] = iArr3[1] + i12;
                    if (e instanceof t) {
                        ((t) e).i(viewGroup, i3, i10, i11, i12, i13);
                    } else if (i13 == 0) {
                        try {
                            d1.d(e, viewGroup, i3, i10, i11, i12);
                        } catch (AbstractMethodError e10) {
                            Log.e("ViewParentCompat", "ViewParent " + e + " does not implement interface method onNestedScroll", e10);
                        }
                    }
                }
                if (iArr != null) {
                    viewGroup.getLocationInWindow(iArr);
                    iArr[0] = iArr[0] - i14;
                    iArr[1] = iArr[1] - i15;
                }
                return true;
            }
            if (iArr != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                return false;
            }
        }
        return false;
    }

    public final ViewParent e(int i3) {
        if (i3 == 0) {
            return this.f15726a;
        }
        if (i3 != 1) {
            return null;
        }
        return this.f15727b;
    }

    public final boolean f(int i3) {
        return e(i3) != null;
    }

    public final void g(boolean z5) {
        if (this.f15729d) {
            WeakHashMap weakHashMap = z0.f15748a;
            n0.z(this.f15728c);
        }
        this.f15729d = z5;
    }

    public final boolean h(int i3, int i10) {
        boolean f2;
        if (!f(i10)) {
            if (this.f15729d) {
                ViewGroup viewGroup = this.f15728c;
                View view = viewGroup;
                for (ViewParent parent = viewGroup.getParent(); parent != null; parent = parent.getParent()) {
                    boolean z5 = parent instanceof t;
                    if (z5) {
                        f2 = ((t) parent).j(view, viewGroup, i3, i10);
                    } else {
                        if (i10 == 0) {
                            try {
                                f2 = d1.f(parent, view, viewGroup, i3);
                            } catch (AbstractMethodError e) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e);
                            }
                        }
                        f2 = false;
                    }
                    if (f2) {
                        if (i10 == 0) {
                            this.f15726a = parent;
                        } else if (i10 == 1) {
                            this.f15727b = parent;
                        }
                        if (z5) {
                            ((t) parent).a(view, viewGroup, i3, i10);
                        } else if (i10 == 0) {
                            try {
                                d1.e(parent, view, viewGroup, i3);
                            } catch (AbstractMethodError e10) {
                                Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e10);
                            }
                        }
                    } else {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void i(int i3) {
        ViewParent e = e(i3);
        if (e != null) {
            boolean z5 = e instanceof t;
            ViewGroup viewGroup = this.f15728c;
            if (z5) {
                ((t) e).f(i3, viewGroup);
            } else if (i3 == 0) {
                try {
                    d1.g(e, viewGroup);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + e + " does not implement interface method onStopNestedScroll", e10);
                }
            }
            if (i3 == 0) {
                this.f15726a = null;
            } else {
                if (i3 != 1) {
                    return;
                }
                this.f15727b = null;
            }
        }
    }
}
