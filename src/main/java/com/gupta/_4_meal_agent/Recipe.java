package com.gupta._4_meal_agent;

import java.util.List;

public record Recipe(
        String name,
        int minutes,
        List<String> ingredients,
        List<String> steps
) {

    @Override
    public String toString() {
        return """
                Name: %s
                Minutes: %d
                Ingredients: %s
                Steps:
                %s
                """.formatted(
                name,
                minutes,
                String.join(", ", ingredients),
                String.join("\n", steps.stream().map(step -> "- " + step).toList())
        );
    }
}