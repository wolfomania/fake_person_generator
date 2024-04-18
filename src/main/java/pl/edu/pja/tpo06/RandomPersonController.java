package pl.edu.pja.tpo06;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Controller
public class RandomPersonController {

    FakeDataService fakeDataService;

    private final String htmlReference;

    public RandomPersonController(FakeDataService fakeDataService) {
        this.fakeDataService = fakeDataService;
        htmlReference = "peopleGenerator";
    }

    @PostMapping(value = "/people-generator")
    public String generatePeople(
            @RequestParam int numberOfPeople,
            @RequestParam String language,
            @RequestParam(defaultValue = "false") boolean needUniversity,
            @RequestParam(defaultValue = "false") boolean needAddress,
            @RequestParam(defaultValue = "false") boolean needCountry,
            @RequestParam(defaultValue = "false") boolean needJobTitle,
            @RequestParam(defaultValue = "false") boolean needFavouriteAnimal,
            Model model
    ) {
        model.addAttribute(
                "generatedPeople",
                fakeDataService.generatePeople(
                        numberOfPeople,
                        language,
                        needUniversity,
                        needAddress,
                        needCountry,
                        needJobTitle,
                        needFavouriteAnimal
                )
        );
        return htmlReference;
    }

    @GetMapping("/people-generator")
    public String getStartingScreen() {
        System.err.println("GET");
        return htmlReference;
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public String handleMissingServletRequestParameterException(MissingServletRequestParameterException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return htmlReference;
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public String handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, Model model) {
        model.addAttribute("error", ex.getMessage());
        return htmlReference;
    }
}
