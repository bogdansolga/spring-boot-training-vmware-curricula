### Day 2 requirements
Integrate support for CRUD operations on `Product` entities in our end-to-end project

Required functionalities:
- use DTOs for their serializing and de-serializing
- expose and implement the CRUD operations
- create all three layer architecture classes:
  - a `@RestController`
  - a `@Service`
  - a `@Repository`
- use an in-memory list in the `@Repository`
- add a few `Product`s in the in-memory list on app startup

------------------------------------------------------------------------------------------------------

### Day 3 requirements
Integrate support for CRUD operations on the JPA `Product` and `Section` entities in our end-to-end project

Required functionalities:
- use DTOs for their serializing and de-serializing
- expose and implement the CRUD operations
- create the three layer architecture classes for the `Product` and `Section` entities:
  - a `@RestController` for each entity
  - a `@Service` for each entity
  - a `@Repository` for each entity
- use a custom configured `DataSource`, using the host cores number as default pool size

------------------------------------------------------------------------------------------------------

### Day 4 requirements

#### Async processing
Integrate two async processing operations on the end-to-end project:
- A `DeferredResult` returning for the returning of all the `ProductDTO`s, including the three 
processing modes:
  - on success
  - on failure (/ exception)
  - on timeout
- An `@Async` processing for the returning of a `Product` from the database

If sufficient time, integrate an `AsyncUncaughtExceptionHandler` in the project

#### Operations retrying, caching and task scheduling
Integrate the following operations in your code:
- a `@Retry` operation on the retrieving of a Product by Id, with an exponential backoff policy
- a `@Cacheable` and a `@CacheEvict` operation for a Product with a certain ID
- a non-clustered and `@Retry`able `@Scheduled` task that retrieves the latest Products from a deposit 