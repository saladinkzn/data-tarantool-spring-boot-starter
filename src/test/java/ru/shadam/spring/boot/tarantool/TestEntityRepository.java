package ru.shadam.spring.boot.tarantool;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sala
 */
@Repository
public interface TestEntityRepository extends CrudRepository<TestEntity, Long> {
}
