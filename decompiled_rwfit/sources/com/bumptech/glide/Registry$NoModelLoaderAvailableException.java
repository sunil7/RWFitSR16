package com.bumptech.glide;

import d4.q;
import java.util.List;

/* loaded from: classes.dex */
public class Registry$NoModelLoaderAvailableException extends Registry$MissingComponentException {
    public Registry$NoModelLoaderAvailableException(Object obj) {
        super("Failed to find any ModelLoaders registered for model class: " + obj.getClass());
    }

    public <M> Registry$NoModelLoaderAvailableException(M m10, List<q> list) {
        super("Found ModelLoaders for model class: " + list + ", but none that handle this specific model instance: " + m10);
    }

    public Registry$NoModelLoaderAvailableException(Class<?> cls, Class<?> cls2) {
        super("Failed to find any ModelLoaders for model: " + cls + " and data: " + cls2);
    }
}
