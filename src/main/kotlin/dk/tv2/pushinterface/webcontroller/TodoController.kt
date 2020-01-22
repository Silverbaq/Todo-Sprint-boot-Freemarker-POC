package dk.tv2.pushinterface.webcontroller

import dk.tv2.pushinterface.exception.ResourceNotFoundException
import dk.tv2.pushinterface.form.TodoForm
import dk.tv2.pushinterface.model.Todo
import dk.tv2.pushinterface.repository.TodoRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import java.util.*
import javax.validation.Valid

@Controller
class TodoController {
    @Autowired
    private lateinit var todoRepository: TodoRepository

    @GetMapping("/")
    fun index(model: Model): String {
        val todos: List<Todo> = todoRepository.findAll()

        model.addAttribute("name", "Steffen")
        model.addAttribute("todos", todos)
        model.addAttribute("todoForm", TodoForm())

        return "index"
    }

    @PostMapping("/addTodo")
    fun addTodo(@Valid @ModelAttribute("todo") todoForm: TodoForm, model: Model): String{
        val todo = Todo(
                id = 0,
                value = todoForm.value,
                createdAt = Date(),
                updatedAt = Date(),
                done = false
        )
        todoRepository.save(todo)
        return "redirect:/"
    }

    @PostMapping("/removeTodo")
    fun removeTodo(@Valid @ModelAttribute("id") id: Long): String {
        val todo = todoRepository.findById(id).orElseThrow { ResourceNotFoundException("Todo", "id", id) }
        todoRepository.delete(todo)
        return "redirect:/"
    }
}