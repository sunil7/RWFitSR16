package com.bumptech.glide.load.engine;

import t4.f;
import z3.j;
import z3.k;
import z3.l;

/* loaded from: classes.dex */
public final class d implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7017a;

    /* renamed from: b, reason: collision with root package name */
    public final com.bumptech.glide.request.a f7018b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f7019c;

    public /* synthetic */ d(l lVar, com.bumptech.glide.request.a aVar, int i3) {
        this.f7017a = i3;
        this.f7019c = lVar;
        this.f7018b = aVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CallbackException callbackException;
        switch (this.f7017a) {
            case 0:
                com.bumptech.glide.request.a aVar = this.f7018b;
                aVar.f7034b.a();
                synchronized (aVar.f7035c) {
                    synchronized (this.f7019c) {
                        try {
                            k kVar = this.f7019c.f20249a;
                            com.bumptech.glide.request.a aVar2 = this.f7018b;
                            kVar.getClass();
                            if (kVar.f20247a.contains(new j(aVar2, f.f18513b))) {
                                l lVar = this.f7019c;
                                com.bumptech.glide.request.a aVar3 = this.f7018b;
                                lVar.getClass();
                                try {
                                    aVar3.k(lVar.f20264q, 5);
                                } finally {
                                }
                            }
                            this.f7019c.d();
                        } finally {
                        }
                    }
                }
                return;
            default:
                com.bumptech.glide.request.a aVar4 = this.f7018b;
                aVar4.f7034b.a();
                synchronized (aVar4.f7035c) {
                    synchronized (this.f7019c) {
                        try {
                            k kVar2 = this.f7019c.f20249a;
                            com.bumptech.glide.request.a aVar5 = this.f7018b;
                            kVar2.getClass();
                            if (kVar2.f20247a.contains(new j(aVar5, f.f18513b))) {
                                this.f7019c.f20265s.a();
                                l lVar2 = this.f7019c;
                                com.bumptech.glide.request.a aVar6 = this.f7018b;
                                lVar2.getClass();
                                try {
                                    aVar6.l(lVar2.f20265s, lVar2.f20262o, lVar2.f20268v);
                                    this.f7019c.h(this.f7018b);
                                } finally {
                                }
                            }
                            this.f7019c.d();
                        } finally {
                        }
                    }
                }
                return;
        }
    }
}
