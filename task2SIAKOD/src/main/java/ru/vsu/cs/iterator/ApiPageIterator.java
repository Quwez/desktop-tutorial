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
    private boolean exhausted = false;

    public ApiPageIterator(pageApi api) {
        this.api = api;
    }

    @Override
    public boolean hasNext() {
        if (cursor < buffer.size()) {
            return true;
        }

        if (exhausted) {
            return false;
        }

        pageApi.Page page = api.fetchPage(nextPage);
        nextPage++;
        buffer = page.getItems();
        cursor = 0;

        if (!page.hasMore() || buffer.isEmpty()) {
            exhausted = true;
        }

        return !buffer.isEmpty();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return buffer.get(cursor++);
    }

    @Override
    public Iterator<String> iterator() {
        return this;
    }

    public void reset() {
        this.nextPage = 0;
        this.cursor = 0;
        this.buffer = Collections.emptyList();
        this.exhausted = false;
    }
}