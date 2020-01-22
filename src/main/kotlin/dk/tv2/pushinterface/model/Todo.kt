package dk.tv2.pushinterface.model

import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.util.*
import javax.persistence.*

@Entity
@EntityListeners(AuditingEntityListener::class)
class Todo(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        var value: String,
        var createdAt: Date,
        var updatedAt: Date,
        var done: Boolean
)