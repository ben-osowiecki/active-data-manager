package com.benosowiecki.activedatamanager.domain;

import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class AlertIdentifierList implements List<IdentifiedResource> {

    private List<IdentifiedResource> alerts;

    @Override
    public int size() {
        return alerts.size();
    }

    @Override
    public boolean isEmpty() {
        return CollectionUtils.isEmpty(alerts);
    }

    @Override
    public boolean contains(Object o) {
        return alerts.contains(o);
    }

    @Override
    public Iterator<IdentifiedResource> iterator() {
        return alerts.iterator();
    }

    @Override
    public Object[] toArray() {
        return alerts.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return alerts.toArray(a);
    }

    @Override
    public boolean add(IdentifiedResource alertSummary) {
        return alerts.add(alertSummary);
    }

    @Override
    public boolean remove(Object o) {
        return alerts.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return alerts.contains(c);
    }

    @Override
    public boolean addAll(Collection<? extends IdentifiedResource> c) {
        return alerts.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends IdentifiedResource> c) {
        return alerts.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return alerts.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return alerts.retainAll(c);
    }

    @Override
    public void clear() {
        alerts.clear();
    }

    @Override
    public IdentifiedResource get(int index) {
        return alerts.get(index);
    }

    @Override
    public IdentifiedResource set(int index, IdentifiedResource element) {
        return alerts.set(index, element);
    }

    @Override
    public void add(int index, IdentifiedResource element) {
        alerts.set(index, element);
    }

    @Override
    public IdentifiedResource remove(int index) {
        return alerts.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return alerts.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return alerts.lastIndexOf(o);
    }

    @Override
    public ListIterator<IdentifiedResource> listIterator() {
        return alerts.listIterator();
    }

    @Override
    public ListIterator<IdentifiedResource> listIterator(int index) {
        return alerts.listIterator(index);
    }

    @Override
    public List<IdentifiedResource> subList(int fromIndex, int toIndex) {
        return alerts.subList(fromIndex, toIndex);
    }
}
