package pl.com.sda.game;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Random;

@Controller
public class GameController {
    private int random;
    private String result;
    private int count;

    public GameController() {
        result = new String();
        random = new Random().nextInt(10);

    }

    @GetMapping("/game")
    public String getGame(Model model) {
        model.addAttribute("random", random);
        model.addAttribute("numberFromUser", new RandomNumber());
        model.addAttribute("result", result);
        return "game/gameView";
    }

    @PostMapping("/game")
    public String checkNumber(@ModelAttribute RandomNumber randomNumber) {
        count++;
        if (randomNumber.getUserValue() == random) {
            result = "Tyle Wygrać! Udało się za " + count + " razem.";
        } else {
            result = "Nie..";
        }
        return "redirect:/game";

    }

}
