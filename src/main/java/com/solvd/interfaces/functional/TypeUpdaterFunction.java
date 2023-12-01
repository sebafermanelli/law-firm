package com.solvd.interfaces.functional;

@FunctionalInterface
public interface TypeUpdaterFunction<T> {
  void changeType(T object);
}
