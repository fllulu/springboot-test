package com.test.utils;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.StrUtil;
import com.google.common.base.Preconditions;

import java.util.Collection;
import java.util.Map;

public class NullUtil {
    public NullUtil() {
    }

    public static Boolean isNull(Object obj) {
        return obj == null;
    }

    public static Boolean isNotNull(Object obj) {
        return obj != null;
    }

    public static <T> T defaultIfNull(T object, T defaultValue) {
        return null != object ? object : defaultValue;
    }

    public static Boolean isBlank(CharSequence cs) {
        return StrUtil.isBlank(cs);
    }

    public static Boolean isNotBlank(CharSequence cs) {
        return StrUtil.isNotBlank(cs);
    }

    public static Boolean isEmpty(Collection<?> collection) {
        return CollectionUtil.isEmpty(collection);
    }

    public static Boolean isNotEmpty(Collection<?> collection) {
        return CollectionUtil.isNotEmpty(collection);
    }

    public static boolean isEmpty(Map<?, ?> map) {
        return CollectionUtil.isEmpty(map);
    }

    public static Boolean isNotEmpty(Map<?, ?> map) {
        return CollectionUtil.isNotEmpty(map);
    }

    public static <T> T checkNotNull(T reference) {
        return Preconditions.checkNotNull(reference);
    }

    public static int checkElementIndex(int index, int size) {
        return Preconditions.checkElementIndex(index, size);
    }

    public static void checkArgument(boolean expression) {
        Preconditions.checkArgument(expression);
    }

    public static void checkState(boolean expression) {
        Preconditions.checkState(expression);
    }
}

