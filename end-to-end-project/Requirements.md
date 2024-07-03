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