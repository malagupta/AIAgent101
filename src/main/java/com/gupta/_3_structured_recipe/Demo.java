package com.gupta._3_structured_recipe;

import dev.langchain4j.service.AiServices;

public class Demo {

    public static void main(String[] args) {
        FoodOrderAssistant assistant = AiServices.builder(FoodOrderAssistant.class)
                                                 .chatModel(ModelConfig.create())
                                                 .tools(new MenuTool())
                                                 .build();

        String request = """
                I want something vegetarian with bread, tomato and cheese.
                It should be ready in 10 minutes.
                """;

        Recipe recipe = assistant.suggest(request);

        // Question: How can I move this println statements to Recipe

        System.out.println("Name: " + recipe.name());
        System.out.println("Minutes: " + recipe.minutes());
        System.out.println("Ingredients: " + recipe.ingredients());
        System.out.println("Steps:");
        recipe.steps().forEach(step -> System.out.println("- " + step));
    }
}

