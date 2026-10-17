package com.gupta._4_meal_agent;

import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.agentic.UntypedAgent;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        QuickCookAgent cook = AgenticServices
                .agentBuilder(QuickCookAgent.class)
                .chatModel(ModelConfig.create())
                .build();

        UntypedAgent mealAgent = AgenticServices
                .sequenceBuilder()
                .subAgents(cook)
                .outputKey("recipe")
                .build();

        Object result = mealAgent.invoke(Map.of("ingredients", "bread, tomato, cheese"));

        System.out.println(result);
    }
}


/*public class Demo {
    public static void main(String[] args) {
        QuickCook cook = AgenticServices
                .agentBuilder(QuickCook.class)
                .chatModel(ModelConfig.create())
                .build();

        Recipe recipe = cook.suggest("bread, tomato, cheese");

        System.out.println("Name: " + recipe.name());
        System.out.println("Minutes: " + recipe.minutes());
        System.out.println("Ingredients: " + recipe.ingredients());
        System.out.println("Steps:");
        recipe.steps().forEach(step -> System.out.println("- " + step));
    }
}*/
