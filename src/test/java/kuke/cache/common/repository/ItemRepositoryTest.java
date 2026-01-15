package kuke.cache.common.repository;

import kuke.cache.common.model.Item;
import kuke.cache.common.model.ItemCreateRequest;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ItemRepositoryTest {
    private ItemRepository itemRepository = new ItemRepository();

    // 전체 목록 조회 테스트
    // 1. 전체 데이터를 세팅

    // 2. 전체 목록 조회 기능을 테스트하기 (e.g. 파라미터로 받는 paging 처리, 해당 기능들이 잘 동작하는지 테스트해보면 될 듯)
    @Test
    void readAll() {
        List<Item> items = IntStream.range(0, 3)
                .mapToObj(idx -> itemRepository.create(Item.create(new ItemCreateRequest("data" + idx))))
                .toList();

        List<Item> firstPage = itemRepository.readAll(1L, 2L);
        List<Item> lastPage = itemRepository.readAll(2L, 2L);

        assertThat(firstPage).hasSize(2);
        assertThat(firstPage.get(0).getItemId()).isEqualTo(items.get(2).getItemId());
        assertThat(firstPage.get(1).getItemId()).isEqualTo(items.get(1).getItemId());

        assertThat(lastPage).hasSize(1);
        assertThat(lastPage.get(0).getItemId()).isEqualTo(items.get(0).getItemId());
    }

    @Test
    void readAllInfiniteScroll() {
        List<Item> items = IntStream.range(0, 3)
                .mapToObj(idx -> itemRepository.create(Item.create(new ItemCreateRequest("data" + idx))))
                .toList();

        List<Item> firstPage = itemRepository.readAllInfiniteScroll(null, 2L);
        List<Item> lastPage = itemRepository.readAllInfiniteScroll(items.get(0).getItemId(), 2L);

        assertThat(firstPage).hasSize(2);
        assertThat(firstPage.get(0).getItemId()).isEqualTo(items.get(2).getItemId());
        assertThat(firstPage.get(1).getItemId()).isEqualTo(items.get(1).getItemId());

        assertThat(lastPage).hasSize(1);
        assertThat(lastPage.get(0).getItemId()).isEqualTo(items.get(0).getItemId());

    }
}