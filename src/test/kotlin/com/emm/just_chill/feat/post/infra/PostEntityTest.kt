package com.emm.just_chill.feat.post.infra

import com.emm.just_chill.feat.profile.infra.UserProfileJpaRepository
import com.emm.just_chill.feat.user.infra.UserEntity
import com.emm.just_chill.feat.user.infra.UserJpaRepository
import com.github.javafaker.Faker
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class PostEntityTest(
    @Autowired private val userProfileRepository: UserProfileJpaRepository,
    @Autowired private val userRepository: UserJpaRepository,
    @Autowired private val postRepository: PostJpaRepository,
    @Autowired private val studentJpaRepository: StudentJpaRepository,
    @Autowired private val courseJpaRepository: CourseJpaRepository,
) {

    private val faker = Faker.instance()

    @Test
    fun deleteUser() {
        val studentEntity = StudentEntity(
            id = UUID.randomUUID().toString(),
            name = "random de mrd ",
        )
        val courseEntity = CourseEntity(
            id = UUID.randomUUID().toString(),
            name = "curso de mierda",
        )

        studentEntity.courses.add(courseEntity)

        studentJpaRepository.save(studentEntity)
    }

    @Test
    fun `create user and profile`() {
        val userEntity = UserEntity(
            id = UUID.randomUUID().toString(),
            name = faker.name().firstName(),
            email = faker.internet().emailAddress(),
        )

        val postsEntities: List<PostEntity> = (1..15).map {
            PostEntity(
                id = UUID.randomUUID().toString(),
                title = faker.lorem().word(),
                content = faker.lorem().sentence(),
                user = userEntity,
            )
        }

        userRepository.save(userEntity)
//
//        val userProfileEntity = UserProfileEntity(
//            id = UUID.randomUUID().toString(),
//            address = faker.address().city(),
//            birthDate = LocalDate.now(),
//            profilePicture = faker.internet().image(),
//            user = userEntity,
//        )
//
//        val postEntity = PostEntity(
//            id = UUID.randomUUID().toString(),
//            title = faker.lorem().word(),
//            content = faker.lorem().sentence(),
//            user = userEntity,
//        )
//        userProfileRepository.save(userProfileEntity)
//        postRepository.save(postEntity)
    }
}