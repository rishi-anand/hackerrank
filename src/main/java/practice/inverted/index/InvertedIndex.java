package practice.inverted.index;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InvertedIndex<T extends IndexValue> {

    private Map<String, Set<T>> index;

    public Set<T> getIntersections(List<String> keys) {
        if(keys != null) {
            List<Set<T>> valueSets = new ArrayList<>();
            for(String key : keys) {
                Set<T> values = index.get(key);
                if(values != null) {
                    valueSets.add(values);
                }
            }

            if(!valueSets.isEmpty()) {
                Set<T> baseSet = valueSets.get(0);

                if(valueSets.size() > 1) {
                    for (int i = 1; i < valueSets.size(); i++) {
                        baseSet.retainAll(valueSets.get(i));
                    }
                }
                return baseSet;
            }
        }
        return Collections.emptySet();
    }

    public static <T extends IndexValue> Builder builder() {
        return new Builder<T>();
    }

    public static final class Builder<T extends IndexValue> {
        private Map<String, Set<T>> index;

        public Builder index(String key, T value) {
            Set<T> values = index.get(key);
            if(values == null) {
                values = new HashSet<>();
                index.put(key, values);
            }
            values.add(value);
            return this;
        }

        public Builder index(String key, Set<T> values) {
            if(values != null) {
                Set<T> existingValues = index.get(key);
                if(existingValues == null) {
                    index.put(key, values);
                } else {
                    existingValues.addAll(values);
                }
            }

            return this;
        }

        public InvertedIndex build() {
            return new InvertedIndex(this);
        }
    }

    private InvertedIndex(Builder builder) {
        index = builder.index;
    }
}
