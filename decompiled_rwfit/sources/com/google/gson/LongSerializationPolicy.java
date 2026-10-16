package com.google.gson;

/* loaded from: classes.dex */
public enum LongSerializationPolicy {
    DEFAULT { // from class: com.google.gson.LongSerializationPolicy.1
        @Override // com.google.gson.LongSerializationPolicy
        public g serialize(Long l3) {
            return new j(l3);
        }
    },
    STRING { // from class: com.google.gson.LongSerializationPolicy.2
        @Override // com.google.gson.LongSerializationPolicy
        public g serialize(Long l3) {
            return new j(String.valueOf(l3));
        }
    };

    LongSerializationPolicy(AnonymousClass1 anonymousClass1) {
    }

    public abstract g serialize(Long l3);
}
