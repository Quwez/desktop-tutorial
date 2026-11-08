package ru.vsu.cs.iterator;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ApiPageIterator implements Iterator<String>, Iterable<String> {
    private final pageApi api;
    private int nextPage = 0;
    private int cursor = 0;
    private List<String> buffer = Collections.emptyList();
    private boolean hasMorePages = true;

    public ApiPageIterator(pageApi api) {
        this.api = api;
    }

    @Override
    public boolean hasNext() {
        if (cursor < buffer.size()) {
            return true;
        }
        if (!hasMorePages) {
            return false;
        }

        pageApi.Page page = api.fetchPage(nextPage);
        nextPage++;
        buffer = page.getItems();
        hasMorePages = page.hasMore();
        cursor = 0;

        return !buffer.isEmpty();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException("Больше нет элементов");
        }
        return buffer.get(cursor++);
    }

    @Override
    public Iterator<String> iterator() {
        return new ApiPageIterator(this.api);
    }
}