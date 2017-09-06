package ru.shadam.spring.boot.tarantool;

import org.springframework.data.annotation.Id;
import ru.shadam.tarantool.annotation.Tuple;

/**
 * @author sala
 */
public class TestEntity {
    @Id
    @Tuple(index = 0)
    private long id;
    @Tuple(index = 1)
    private String name;
}
