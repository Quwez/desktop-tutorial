package ru.vsu.cs.iterator;

import java.util.Collections;
import java.util.List;

public class pageApi {

    public static class Page {
        private final List<String> items;
        private final boolean hasMore;

        public Page(List<String> items, boolean hasMore) {
            this.items = items;
            this.hasMore = hasMore;
        }

        public List<String> getItems() {
            return items;
        }

        public boolean hasMore() {
            return hasMore;
        }
    }

    private final List<String> data;
    private final int pageSize;
    private int requests = 0;

    public pageApi(List<String> data, int pageSize) {
        if (pageSize <= 0) {
            throw new IllegalArgumentException();
        }
        this.data = data;
        this.pageSize = pageSize;
    }

    public Page fetchPage(int pageNumber) {
        requests++;
        int from = pageNumber * pageSize;
        if (from >= data.size()) {
            return new Page(Collections.emptyList(), false);
        }
        int to = Math.min(from + pageSize, data.size());
        boolean hasMore = to < data.size();
        return new Page(data.subList(from, to), hasMore);
    }

    public int getRequests() {
        return requests;
    }
}