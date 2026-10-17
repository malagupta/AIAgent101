package com.gupta._5_serving_workflow;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface ServingAdvisorAgent {
    @UserMessage("""
                Recipe:
                {{recipe}}

                Recommend the best tableware or serving utensil for this dish.
                Consider whether the dish is dry, saucy, liquid, handheld, or shareable.

                Examples:
                - omelette or toast: flat plate
                - soup or curry: bowl
                - dip or yogurt dish: small bowl
                - shared snack: platter

                Return the response in this format:

                Dish:
                <repeat the recipe name or short dish description>

                Serving advice:
                <recommend the best tableware or serving utensil with one reason>
                """)

    @Agent(description = "Recommends how to serve a recipe at the table", outputKey = "servingAdvice")
    String recommend(@V("recipe") String recipe);
}