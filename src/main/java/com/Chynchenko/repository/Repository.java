package com.Chynchenko.repository;

    public interface Repository<T> {
        public abstract void save(final T t);
        public abstract void insert(int index, final T t);
        public abstract T getById(final String id);
        public abstract T[] getAll();
        public abstract void delete(final String id);
    }

