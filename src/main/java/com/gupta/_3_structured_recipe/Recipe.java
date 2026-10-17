package com.gupta._3_structured_recipe;

import java.util.List;

public record Recipe(
                    String name,
                    int minutes,
                    List<String> ingredients,
                    List<String> steps) {
}
