package androidx.databinding;

/* loaded from: classes.dex */
public abstract class a implements f {
    private transient h mCallbacks;

    @Override // androidx.databinding.f
    public void addOnPropertyChangedCallback(e eVar) {
        synchronized (this) {
            try {
                if (this.mCallbacks == null) {
                    this.mCallbacks = new h();
                }
            } finally {
            }
        }
        h hVar = this.mCallbacks;
        synchronized (hVar) {
            try {
                if (eVar == null) {
                    throw new IllegalArgumentException("callback cannot be null");
                }
                int lastIndexOf = hVar.f1988a.lastIndexOf(eVar);
                if (lastIndexOf >= 0) {
                    if (hVar.a(lastIndexOf)) {
                    }
                }
                hVar.f1988a.add(eVar);
            } finally {
            }
        }
    }

    public void notifyChange() {
        synchronized (this) {
            try {
                h hVar = this.mCallbacks;
                if (hVar == null) {
                    return;
                }
                hVar.b(this, 0);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void notifyPropertyChanged(int i3) {
        synchronized (this) {
            try {
                h hVar = this.mCallbacks;
                if (hVar == null) {
                    return;
                }
                hVar.b(this, i3);
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public void removeOnPropertyChangedCallback(e eVar) {
        synchronized (this) {
            try {
                h hVar = this.mCallbacks;
                if (hVar == null) {
                    return;
                }
                synchronized (hVar) {
                    try {
                        if (hVar.f1991d == 0) {
                            hVar.f1988a.remove(eVar);
                        } else {
                            int lastIndexOf = hVar.f1988a.lastIndexOf(eVar);
                            if (lastIndexOf >= 0) {
                                hVar.f(lastIndexOf);
                            }
                        }
                    } finally {
                    }
                }
            } finally {
            }
        }
    }
}
