package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 * Иммутабельный класс, содержащий поле с изменяемым классом
 */
public final class ImmutableClass {
    private final String id;
    private final MutableClass mutableField;
    private final List<String> immutableList;

    public ImmutableClass(String id, MutableClass mutableField) {
        this.id = id;
        this.mutableField = createDeepCopy(mutableField);
        this.immutableList = Collections.unmodifiableList(
                new ArrayList<>(mutableField.getItems())
        );
    }

    private MutableClass createDeepCopy(MutableClass original) {
        if (original == null) {
            return null;
        }

        MutableClass copy = new MutableClass(original.getName(), original.getValue());
        for (String item : original.getItems()) {
            copy.addItem(item);
        }
        return copy;
    }

    public String getId() {
        return id;
    }

    public MutableClass getMutableField() {
        return createDeepCopy(this.mutableField);
    }

    public List<String> getImmutableList() {
        return immutableList;
    }

    public List<String> getItemsCopy() {
        return new ArrayList<>(immutableList);
    }

    public ImmutableClass withMutableField(MutableClass newMutableField) {
        return new ImmutableClass(this.id, newMutableField);
    }

    public ImmutableClass withId(String newId) {
        return new ImmutableClass(newId, this.mutableField);
    }

    @Override
    public String toString() {
        return "ImmutableClass{id='" + id + "', mutableField=" + mutableField +
                ", immutableList=" + immutableList + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ImmutableClass that = (ImmutableClass) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(mutableField, that.mutableField) &&
                Objects.equals(immutableList, that.immutableList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mutableField, immutableList);
    }
}