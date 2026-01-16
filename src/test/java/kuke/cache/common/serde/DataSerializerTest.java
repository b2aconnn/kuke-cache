package kuke.cache.common.serde;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class DataSerializerTest {
    @Test
    void serde() {
        MyData myData = new MyData("id", "data");
        String serialized = DataSerializer.serializeOrException(myData);
        MyData deserialized = DataSerializer.deserializeOrNull(serialized, MyData.class);

        assertThat(deserialized).isEqualTo(myData);
    }

    // record class : 불변 클래스를 record라는 이름으로 편하게 사용할 수 있게 제공해주는 클래스
    record MyData(
        String id,
        String data
    ) {}
}