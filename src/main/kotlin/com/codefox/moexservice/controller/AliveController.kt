import com.codefox.moexservice.dto.ErrorDto
import com.codefox.moexservice.service.BondService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/")
@RestController
class AliveController() {

    @GetMapping("/alive")
    fun getStatus(): ErrorDto = ErrorDto("no error", 0)

}