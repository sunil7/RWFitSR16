package org.greenrobot.greendao.converter;

/* loaded from: classes2.dex */
public interface PropertyConverter<P, D> {
    D convertToDatabaseValue(P p8);

    P convertToEntityProperty(D d5);
}
