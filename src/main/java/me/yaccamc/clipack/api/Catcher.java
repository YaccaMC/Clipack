package me.yaccamc.clipack.api;

@FunctionalInterface
public interface Catcher {
    RuntimeException catches(Exception value);
}
