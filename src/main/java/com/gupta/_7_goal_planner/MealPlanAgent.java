package com.gupta._7_goal_planner;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface MealPlanAgent {
    @UserMessage("""
            Recipe:
            {{recipe}}

            Casual serving option:
            {{casualServing}}

            Restaurant serving option:
            {{restaurantServing}}

            Create a complete meal plan for the customer.

            Return the response in this format:

            Recipe:
            <include the recipe>

            Casual serving:
            <include the casual serving option>

            Restaurant serving:
            <include the restaurant serving option>
            """)

    @Agent(
            description = "Combines a recipe with casual and restaurant serving options into a complete meal plan",
            outputKey = "mealPlan"
    )
    String create(
            @V("recipe") String recipe,
            @V("casualServing") String casualServing,
            @V("restaurantServing") String restaurantServing
    );
}