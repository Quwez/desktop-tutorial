package ru.vsu.cs.iterator;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApiPageIteratorTest {

    @Test
    void readsAllItemsWithoutExtraRequest() {
        List<String> rawData = List.of("10", "20", "30", "40", "50");
        pageApi api = new pageApi(rawData, 2);
        ApiPageIterator iterator = new ApiPageIterator(api);

        List<String> result = new ArrayList<>();
        for (String item : iterator) {
            result.add(item);
        }

        assertEquals(rawData, result);
        assertEquals(3, api.getRequests());

        assertFalse(iterator.hasNext());
        assertEquals(3, api.getRequests());
    }

    @Test
    void canBreakEarlyWithoutLoadingRemainingPages() {
        List<String> rawData = List.of("1", "2", "3", "4", "5", "6");
        pageApi api = new pageApi(rawData, 2);
        ApiPageIterator iterator = new ApiPageIterator(api);

        assertEquals("1", iterator.next());
        assertEquals(1, api.getRequests());
    }
}