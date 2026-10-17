package com.gupta._4_meal_agent;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
public interface QuickCookAgent {

    @SystemMessage("""
            Suggest one everyday dish for one person.
            The dish must take maximum 15 minutes and maximum 5 steps.
            Use only the listed ingredients plus salt, water and oil.
            Do not silently treat raw ingredients as precooked.
            If ingredients are insufficient, return a recipe with name "No suitable recipe",
            minutes 0, an empty ingredients list, and one step explaining that the listed
            ingredients are insufficient.
            Return a structured Recipe with name, minutes, ingredients and steps.
            """)
    @UserMessage("Available ingredients: {{ingredients}}")
    @Agent(description = "Suggests one simple dish from available ingredients", outputKey = "recipe")
    Recipe suggest(@V("ingredients") String ingredients);
}
